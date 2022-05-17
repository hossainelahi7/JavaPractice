package com.practice.sample;

import java.util.Arrays;

public class MaxArray {

    public static int[] findMaxLenSubarray(int[] arr, int sum){
        int startIndex = -1;
        int length = 0;
        int newLength = 0;
        for(int i = 0 ; i < arr.length ; i++){
            int target = sum - arr[i];
            if(target <= 0)
                continue;
            for(int j = i+1 ; j < arr.length ; j++){
                target -= arr[j];
                if(target<0)
                    break;
                else if(target == 0){
                    newLength = j - i;
                    if(length< newLength) {
                        startIndex = i;
                        length = newLength ;
                    }
                }
            }
        }
        if(length>0)
            return Arrays.copyOfRange(arr, startIndex, startIndex + length + 1 );
        else
            return null;
    }

    public static void main(String[] arg){
        int[] nums = { 5, 6, -5, 5, 3, 5, 3, -2, 0 };
        int target = 8;
        findMaxLenSubarray(nums, target);
    }
}
