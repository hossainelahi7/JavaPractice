package com.practice.array;

public class MaxArea {
    public int maxArea(int[] height) {
        if(height.length<=1){
            return 0;
        }
        int maxArea=0, currentArea=0, left = 0 , right = height.length-1;
        while(left < right){
            if(height[left]>height[right]){
                currentArea = height[right]*(right-left);
                right--;
            }else {
                currentArea = height[left]*(right-left);
                left++;
            }
            if(maxArea < currentArea)
                maxArea = currentArea;
        }
        return maxArea;
    }

    public static void main(String[] args){
        MaxArea maxArea = new MaxArea();
//        int[] heights = {1,8,6,2,5,4,8,3,7};
//        int[] heights = {1,1};
//        int[] heights = {5};
//        int[] heights = {};
        int[] heights = {1,8,6,2,5,4,8,3,7,5};
        System.out.println(maxArea.maxArea(heights));
    }
}
