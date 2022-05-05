package com.practice.random.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TripletCount {
    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
        Map<Long, Long> map1 = new HashMap<>();
        Map<Long, Long> map2 = new HashMap<>();
        long count = 0;
        for (int i = 0; i < arr.size(); i++) {
            long a = arr.get(i);
            long key = a / r;
            
            if (map2.containsKey(key) && a % r == 0) {
                count += map2.get(key);
            }
            
            if (map1.containsKey(key) && a % r == 0) {
                long c = map1.get(key);
                map2.put(a, map2.getOrDefault(a, 0L) + c);
            }
            
            map1.put(a, map1.getOrDefault(a, 0L) + 1); // Every number can be the start of a triplet.
        }
        return count;
    }
    

    public static void main(String[] args){
    	List<Long> inputs = new ArrayList<>();
    	inputs.add(Long.valueOf(1));
    	inputs.add(Long.valueOf(3));
    	inputs.add(Long.valueOf(9));
    	inputs.add(Long.valueOf(9));
    	inputs.add(Long.valueOf(27));
    	inputs.add(Long.valueOf(81));
    	System.out.println(inputs);
    	System.out.println(countTriplets(inputs, 3));
    }
}
