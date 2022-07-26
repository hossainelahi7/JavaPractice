package com.practice.graph;




import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalculateEquation {
    public double[] calcEquation(List<List<String>> equations, double[] values,
                                 List<List<String>> queries) {

        HashMap<String, Pair<String, Double>> gidWeight = new HashMap<>();

        // Step 1). build the union groups
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String dividend = equation.get(0), divisor = equation.get(1);
            double quotient = values[i];

            union(gidWeight, dividend, divisor, quotient);
        }

        // Step 2). run the evaluation, with "lazy" updates in find() function
        double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String dividend = query.get(0), divisor = query.get(1);

            if (!gidWeight.containsKey(dividend) || !gidWeight.containsKey(divisor))
                // case 1). at least one variable did not appear before
                results[i] = -1.0;
            else {
                Pair<String, Double> dividendEntry = find(gidWeight, dividend);
                Pair<String, Double> divisorEntry = find(gidWeight, divisor);

                String dividendGid = dividendEntry.first;
                String divisorGid = divisorEntry.first;
                Double dividendWeight = dividendEntry.second;
                Double divisorWeight = divisorEntry.second;

                if (!dividendGid.equals(divisorGid))
                    // case 2). the variables do not belong to the same chain/group
                    results[i] = -1.0;
                else
                    // case 3). there is a chain/path between the variables
                    results[i] = dividendWeight / divisorWeight;
            }
        }

        return results;
    }

    private Pair<String, Double> find(HashMap<String, Pair<String, Double>> gidWeight, String nodeId) {
        if (!gidWeight.containsKey(nodeId))
            gidWeight.put(nodeId, new Pair<String, Double>(nodeId, 1.0));

        Pair<String, Double> entry = gidWeight.get(nodeId);
        // found inconsistency, trigger chain update
        if (!entry.first.equals(nodeId)) {
            Pair<String, Double> newEntry = find(gidWeight, entry.first);
            gidWeight.put(nodeId, new Pair<String, Double>(
                    newEntry.first, entry.second * newEntry.second));
        }

        return gidWeight.get(nodeId);
    }

    private void union(HashMap<String, Pair<String, Double>> gidWeight, String dividend, String divisor, Double value) {
        Pair<String, Double> dividendEntry = find(gidWeight, dividend);
        Pair<String, Double> divisorEntry = find(gidWeight, divisor);

        String dividendGid = dividendEntry.first;
        String divisorGid = divisorEntry.first;
        Double dividendWeight = dividendEntry.second;
        Double divisorWeight = divisorEntry.second;

        // merge the two groups together,
        // by attaching the dividend group to the one of divisor
        if (!dividendGid.equals(divisorGid)) {
            gidWeight.put(dividendGid, new Pair<String, Double>(divisorGid,
                    divisorWeight * value / dividendWeight));
        }
    }


    public static void main(String[] arg){
        CalculateEquation calcEquation = new CalculateEquation();
        List<List<String>> equations = new ArrayList<>();
        List<String> equation = new ArrayList<>();
        equation.add("a");
        equation.add("b");
        equations.add(new ArrayList<>(equation));
        equation.clear();
        equation.add("a");
        equation.add("c");
        equations.add(new ArrayList<>(equation));
        equation.clear();
        double[] values = {2.0,3.0};
        List<List<String>> queries = new ArrayList<>();
        equation.add("a");
        equation.add("c");
        queries.add(new ArrayList<>(equation));
        equation.clear();
        equation.add("b");
        equation.add("a");
        queries.add(new ArrayList<>(equation));
        equation.clear();
        equation.add("a");
        equation.add("e");
        queries.add(new ArrayList<>(equation));

        double[] expected = {6.00000,0.50000,-1.00000,1.00000,-1.00000};
        double[] results = calcEquation.calcEquation(equations, values, queries);
        for (double result : results){
            System.out.println(result);
        }
    }


    public static class Pair<T, U> {

        public Pair(T first, U second) {
            this.second = second;
            this.first = first;
        }

        public final T first;
        public final U second;

        // Because 'pair()' is shorter than 'new Pair<>()'.
        // Sometimes this difference might be very significant (especially in a
        // 80-ish characters boundary). Sorry diamond operator.
        public static <T, U> Pair<T, U> pair(T first, U second) {
            return new Pair<>(first, second);
        }

        @Override
        public String toString() {
            return "(" + first + ", " + second + ")";
        }
    }
}
