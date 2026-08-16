package com.practice.random.algorithm;

public class Cost {
    static int getMoneySpent(int[] keyboards, int[] drives, int b) {
        /*
         * Write your code here.
         */
    	int cost = -1;
    	for(int keyboard: keyboards) {
    		for(int drive : drives) {
    			if (keyboard + drive <= b && cost <= keyboard + drive)
    				cost = keyboard + drive;
    		}
    	}
    	return cost;
    }
    
    public static void main(String[] args) {
    	int[] keyboard = {3,10};
    	int[] drives = {5,2,8};
    	System.out.println(Cost.getMoneySpent(keyboard, drives, 10));
    }
}
