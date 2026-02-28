package com.practice.graph;


import java.awt.*;
import java.util.*;
import java.util.List;

public class MinArea {
//https://leetcode.com/explore/interview/card/google/66/others-4/3105/

    public int minAreaRect(int[][] points) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] p : points) {
            if (!map.containsKey(p[0])) {
                map.put(p[0], new HashSet<>());
            }
            map.get(p[0]).add(p[1]);
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < points.length; i++) {
            for(int j = 0; j < i; j++) {
                if (points[i][0] == points[j][0] || points[i][1] == points[j][1]) { // if have the same x or y
                    continue;
                }
                if (map.get(points[i][0]).contains(points[j][1]) && map.get(points[j][0]).contains(points[i][1])) { // find other two points
                    int current = Math.abs((points[i][0] - points[j][0])*(points[i][1] - points[j][1]));
                    if(min > current)
                        min = current;
                }
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }


/*    public int minAreaRect2(int[][] points) {
        // create a map x -> all y and y -> all x; Sort all keys and also the values.
        if(points.length<=1){
            return 0;
        }
        int minArea = Integer.MAX_VALUE;
        Map<Integer, List<Integer>> xValues = new TreeMap<>();
        Map<Integer, List<Integer>> yValues = new TreeMap<>();
        for(int[] point: points){
            xValues.getOrDefault(point[0], new ArrayList<>()).add(point[1]);
            yValues.getOrDefault(point[1], new ArrayList<>()).add(point[0]);
        }
        for(List<Integer> values : xValues.values()){
            Collections.sort(values);
        }
        for(List<Integer> values : yValues.values()){
            Collections.sort(values);
        }

        // Loop through x and then y, for each value of x1-> y1, pic x -> y2 where there is a y1 -> x2 and y2 -> x2
        // get area Math.abs ((x1-x2)*(y1-y2)) is less then min area update min area
        //
        for(Integer key : xValues.keySet()){
            int size = xValues.get(key).size();
            if(size<2)
                continue;
            Queue<Point> next = new ArrayDeque<>();
            next.addAll(getNeibours(key, xValues.get(key)));
            while (!next.isEmpty()){
                Point point1; //TODO
            }
        }

        //end of loop min area is min area;
        return minArea == Integer.MAX_VALUE? 0 : minArea;
    }

    private List<Point> getNeibours(int x, List<Integer> values){
        List<Point> pointList= new ArrayList<>();
        values.forEach(value ->{
            Point point = new Point(x, value);
            if(!visited.contains(point)){
                pointList.add(point);
                visited.add(point);
            }
        });
        return pointList;
    }*/
}
