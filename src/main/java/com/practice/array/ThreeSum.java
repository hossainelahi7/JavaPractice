package com.practice.array;

import java.util.*;
import java.util.stream.Collectors;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        //check if num is less then 3
        if(nums.length<=2)
            return result;
        List<Integer> numberList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        List<Integer> newList = new ArrayList<>();
        int sum = 0;
        for(int i = 0; i <nums.length; i++){
            for(int j = i+1; j < nums.length-1; j++){
                newList.clear();
                sum = (nums[i]+nums[j])*-1;
                if(numberList.subList(j+1, nums.length).contains(sum)){
                    newList.addAll(Arrays.asList(nums[i],nums[j], sum));
                    Collections.sort(newList);
                }
                if(!newList.isEmpty() && !result.contains(newList)){
                    result.add(new ArrayList(newList));
                }
            }
        }
        return result;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length && nums[i] <= 0; ++i)
            if (i == 0 || nums[i - 1] != nums[i]) {
                twoSumII(nums, i, res);
            }
        return res;
    }
    private void twoSumII(int[] nums, int i, List<List<Integer>> res) {
        int lo = i + 1, hi = nums.length - 1;
        while (lo < hi) {
            int sum = nums[i] + nums[lo] + nums[hi];
            if (sum < 0) {
                ++lo;
            } else if (sum > 0) {
                --hi;
            } else {
                res.add(Arrays.asList(nums[i], nums[lo++], nums[hi--]));
                while (lo < hi && nums[lo] == nums[lo - 1])
                    ++lo;
            }
        }
    }

    private void twoSumHashset(int[] nums, int i, List<List<Integer>> res) {
        HashSet<Integer> seen = new HashSet<Integer>();
        for (int j = i + 1; j < nums.length; ++j) {
            int complement = -nums[i] - nums[j];
            if (seen.contains(complement)) {
                res.add(Arrays.asList(nums[i], nums[j], complement));
                while (j + 1 < nums.length && nums[j] == nums[j + 1])
                    ++j;
            }
            seen.add(nums[j]);
        }
    }


    public static void main(String[] arg){
//        int[] nums = {-1,0,1,2,-1,-4};
        int[] nums = {0,0,0};
        ThreeSum threeSum = new ThreeSum();
        System.out.println(threeSum.threeSum(nums));
    }
}
