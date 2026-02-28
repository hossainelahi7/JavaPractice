package com.practice.array;

public class NextPermutation {
    //TODO: Need to work on
    public void nextPermutation(int[] nums) {
        int i = nums.length-2;
        while (i>=0 && (nums[i]>=nums[i+1])){
            i--;
        }
        if(i>=0){
            int j = nums.length-1;
            while (nums[i] >= nums[j]){
                j--;
            }
            swap(i, j, nums);
        }
        reverse(i+1, nums.length-1, nums);
        return;
    }

    private void reverse(int start, int finish , int[] arr){
        while (start < finish){
            swap(start, finish, arr);
            start++;
            finish--;
        }
    }

    private void swap(int i, int j, int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] arg){
        NextPermutation nextPermutation = new NextPermutation();
        int[] numbers = {1, 5, 8, 4, 7, 6, 5, 3, 1};
        nextPermutation.nextPermutation(numbers);
    }

}
