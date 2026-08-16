package com.practice.array;

import java.util.*;

public class SmallerNumber {
    public List<Integer> countSmaller(int[] nums) {
        PriorityQueue<Integer[]> queue= new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        List<Integer> result = new ArrayList<>(nums.length);
//        for(int i = nums.length-1 ; i>=0; i--){
//            Integer[] object = {nums[i], i};
//            queue.add(object);
//            List<Integer[]> list = queue
//            int index = Collections.binarySearch(object, list);
//            result.add(i, queue.size()-index);
//        }
        return result;
    }

    public static void main(String[] arg){
        SmallerNumber smallerNumber = new SmallerNumber();
        int[] input = {5,2,6,1};
        System.out.println(smallerNumber.countSmaller(input));
    }
}
