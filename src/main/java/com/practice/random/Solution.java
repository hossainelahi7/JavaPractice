package com.practice.random;

import java.util.Random;

public class Solution {
    private int[] localSum;
    private int totalSum;
    private Random rand;

    public Solution(int[] w) {
        this.localSum = new int[w.length];
        this.totalSum = 0;
        rand = new Random();
        for(int i = 0 ; i < w.length ; i++){
            totalSum+=w[i];
            localSum[i] = totalSum;
        }
    }

    public int pickIndex() {
        double random = this.totalSum * Math.random();
        for(int i = localSum.length-2; i >=0 ; i--){
            if(localSum[i] < random)
                return i+1;
        }
        return 0;
    }}
