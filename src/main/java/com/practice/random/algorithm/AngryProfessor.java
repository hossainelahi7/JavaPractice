package com.practice.random.algorithm;

public class AngryProfessor {
	
    static String angryProfessor(int k, int[] a) {
        int count = 0;
        for(int value : a){
            if(value >= 0)
            	count++;
        }
        return count>=k ? "YES" : "NO";
    }

}
