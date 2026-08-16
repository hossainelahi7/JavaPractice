package com.practice.data_structure;

import java.io.*;
import java.util.*;

public class Array2D {

    // Complete the hourglassSum function below.
    static int hourglassSum(List<List<Integer>> arr) {
        int maxSum = Integer.MIN_VALUE;

        // Loop through all possible hourglass positions
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                // Calculate the sum of the current hourglass
                int sum = arr.get(i).get(j) + arr.get(i).get(j+1) + arr.get(i).get(j+2) +
                          arr.get(i+1).get(j+1) +
                          arr.get(i+2).get(j) + arr.get(i+2).get(j+1) + arr.get(i+2).get(j+2);

                // Update maximum sum if current sum is greater
                maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        List<List<Integer>> arr = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            List<Integer> row = new ArrayList<>();

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                row.add(arrItem);
            }
            arr.add(row);
        }

        int result = hourglassSum(arr);
        System.out.println(result);

        scanner.close();
    }
}
