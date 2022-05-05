package com.practice.random.algorithm;

import java.util.List;

public class Algorithm {

    public static int pickingNumbers(List<Integer> a) {
        int longest = 0, temp = 1;
        for (int i = 1; i < a.size(); i++) {
            if(Math.abs(a.get(i)-a.get(i-1))<=1)
                temp ++;
            if(temp>longest)
                longest = temp;                
        }
        return longest;
    }

	
	public static void main(String[] args) {
//		List<Integer> valus = new ArrayList<>();
//		valus.add(1);
//		valus.add(2);
//		valus.add(2);
//		valus.add(3);
//		valus.add(1);
//		valus.add(2);
//		pickingNumbers(valus);
	}

}
