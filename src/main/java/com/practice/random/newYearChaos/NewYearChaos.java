package com.practice.random.newYearChaos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NewYearChaos {
    public static void minimumBribes(List<Integer> q) {
        // Write your code here
        int intendedFirst = Collections.min(q);
        int bribe, bribe2 = 0;
        int lastBribe = 0;
        int totalBribe = 0 ;
        int[] integerArray = q.stream().mapToInt(Integer::intValue).toArray();
        int size = integerArray.length;
        for(int i = 0 ; i < size ; i++){
            bribe = integerArray[i]-intendedFirst-i;
            if(bribe>0){
                totalBribe += bribe;
            }
            if(bribe > 2){
                System.out.println("Too chaotic");
                return;
            }
        }
        System.out.println(totalBribe);
    }

    public static void minimumBribes2(List<Integer> q) {
        // Write your code here
        int totalBribe = 0;
        int size = q.size();
        int intendedFirst = getMinValue(q);
        int[] integerArray = q.stream().mapToInt(Integer::intValue).toArray();
        for(int i = 0 ; i < size ; i++) {
            if (integerArray[i] - intendedFirst - i > 2) {
                System.out.println("Too chaotic");
                return;
            }
            for(int j = 0 ; j < i ; j++){
                if(integerArray[j] > integerArray[i])
                    totalBribe++;
            }
        }
        System.out.println(totalBribe);
    }


    public static Integer getMinValue(List<Integer> list){
        Integer minValue = Integer.MAX_VALUE;
        for(Integer value : list){
            if(minValue> value)
                minValue = value;
        }
        return  minValue;
    }

    public static void main(String[] arg){
        int[] ints = {1,2,5,3,7,8,6,4};
        List<Integer> sequence = new ArrayList<>();
        for(int i = 0 ; i< ints.length ; i++){
            sequence.add(ints[i]);
        }
        minimumBribes2(sequence);
    }

}
