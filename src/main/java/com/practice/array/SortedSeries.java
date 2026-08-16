package com.practice.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class SortedSeries {
    public int[] searchRange(int[] nums, int target) {
        int begening = searchTarget(nums, target, 0, nums.length-1, false);
        if(begening == -1)
            return new int[]{-1,-1};
        int end = searchTarget(nums, target, begening, nums.length-1, true);
        return new int[]{ begening, end};
    }

    private int searchTarget(int[] nums, int target, int start, int end, boolean endLocation){
        if(start == end && nums[start]==target)
            return start;
        while(start <= end){
            int mid = start + (end - start + 1)/2;
            if(nums[mid] == target){
                if(endLocation){
                    if(nums[mid+1] == target)
                        start = mid +1;
                    else
                        return mid;
                }else{
                    if(nums[mid-1] == target)
                        end = mid - 1;
                    else
                        return mid;
                }
            }else if (nums[mid]> target){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return -1;
    }


    public int[][] merge(int[][] intervals) {
        List<int[]> inputs = new ArrayList<>();
        for(int[] interval: intervals){
            inputs.add(interval);
        }
        Collections.sort(inputs, Comparator.comparingInt(a -> a[0]));
        for(int i = 1; i < inputs.size() ; i++){
            if(inputs.get(i)[0] < inputs.get(i-1)[1]){
                inputs.get(i-1)[1] = Math.max(inputs.get(i)[1], inputs.get(i-1)[1]);
                inputs.remove(i);
                i--;
            }
        }
        return inputs.toArray(new int[inputs.size()][]);
    }

    @Test
    public void validate(){
        int[] input = {5,7,7,8,8,10};
//        int[] input = {1};
        int input2 = 8;
//        int input2 = 1;
        int[] expected = {3,4};
//        int[] expected = {0,0};
        int[] result = searchRange(input, input2);
        Assert.assertArrayEquals(expected, result);
    }


}
