package com.practice.sample;

//https://leetcode.com/problems/split-array-largest-sum/description/

public class ArrayLargestSum {
    public int requiredSplit(int[] nums, int maxSum){
        // add nums till currentSum < maxSum
        // if sum > maxSum then increase splitCount
        // return splitCount
        int splitCount = 0;
        int currentSum = 0;
        for(int value : nums){
            currentSum+=value;
            if(currentSum > maxSum){
                currentSum = value;
                splitCount++;
            }
        }
        return splitCount+1;
    }



    public int splitArray(int[] nums, int m) {
        //find sum and max value
        int sum = 0, maxValue = 0;
        for(int value : nums){
            sum+=value;
            if(maxValue < value){
                maxValue = value;
            }
        }
        // left = max
        // right = sum
        // get mid = left + right /2
        int maxSum = 0;
        int mid = 0;
        // find how many split needed for sum to be less then  mid
        // if need more then m then left = mid + 1
        // if need less then right = mid - 1
        // mid = left + right /2
        // loop till left < right;
        while(maxValue <= sum){
            mid = (maxValue + sum)/2;
            if(requiredSplit(nums, mid) <= m){
                maxSum = mid;
                sum = mid - 1;
            }else{
                maxValue = mid + 1;
            }
        }
        return maxSum;
    }

}
