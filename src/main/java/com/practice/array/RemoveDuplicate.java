package com.practice.array;

public class RemoveDuplicate {
/*    public static int removeDuplicates(int[] nums) {
        int duplicateSize = nums.length;
        int duplicateFound = 0;
        int loopSize = nums.length-1;
        for(int i = 0; i < loopSize;i++){
            if(nums[i] == nums[i+1]){
                nums[i+1-duplicateFound] = nums[i+2];
                i++;
                duplicateFound++;
                loopSize--;
            }
//            for(int j = 0 ; j< duplicateFound; j++) {
//                nums[i+j] = nums[i+j+1];
//            }
            if(duplicateFound>0){
                nums[i] = nums[i+duplicateFound];
            }
        }
        return duplicateSize - duplicateFound;
    }*/

/*    int[] nums = [...]; // Input array
    int[] expectedNums = [...]; // The expected answer with correct length

    int k = removeDuplicates(nums); // Calls your implementation

assert k == expectedNums.length;
for (int i = 0; i < k; i++) {
        assert nums[i] == expectedNums[i];
    }*/
    public static int removeDuplicates(int[] nums) {
        int uniqueIds = 0;
        for(int i = 1; i < nums.length ; i++){
            if(nums[uniqueIds] != nums[i]){
                nums[++uniqueIds] = nums[i];
            }
        }

        return uniqueIds+1;
    }

    public static void main(String[] arg){
        int[] list = {1, 2, 3, 3, 4, 5, 6, 6, 7, 7, 8, 9, 10};
        int k = removeDuplicates(list);
        System.out.println(k);
    }
}
