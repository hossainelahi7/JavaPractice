package com.practice.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class JumpGame {
    List<Integer>visited;
    public boolean canJump(int[] nums) {
        if(nums.length <= 1)
            return true;
        boolean reached = false;
        Stack<Integer> nextPositions = new Stack<>();
        visited = new ArrayList<>();
        visited.add(0);
        nextPositions.addAll(nextPosibilities(nums, nums.length-1));
        while (!nextPositions.empty()){
            Integer next = nextPositions.pop();
            if(next<= 0)
                return true;
            visited.add(next);
            nextPositions.addAll(nextPosibilities(nums, next));
        }
        return reached;
    }

    private List<Integer> nextPosibilities(int[] nums, int position){
        List<Integer> posibilities = new ArrayList<>();
        for(int i = nums[position] ; i > 0 ; i--){
            int index = position + i+1;
            if(!visited.contains(index))
                posibilities.add(index);
        }
        return posibilities;
    }

    public static void main(String[] args){
        JumpGame jumpGame = new JumpGame();
        int[] input = {2,3,1,1,4};
        System.out.println(jumpGame.canJump(input));
    }
}
