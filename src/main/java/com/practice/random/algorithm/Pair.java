package com.practice.random.algorithm;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pair {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        int pair = 0;
        List<Integer> temp = new ArrayList<>();
        for(int val : ar) {
        	if (temp.contains(val)) {
        		pair++;
        		temp.remove(temp.indexOf(val));
        	}else {
        		temp.add(val);
        	}
        }
        return pair;
    }

    public static void main(String[] args) throws IOException {
    	int size = 9;
    	int[] pile = {10, 20, 20, 10, 10, 30, 50, 10, 20};
    	System.out.print(sockMerchant(size, pile));
    }
}
