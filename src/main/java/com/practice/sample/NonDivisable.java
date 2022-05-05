package com.practice.sample;

import java.util.Arrays;
import java.util.List;

public class NonDivisable {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(278, 576, 496, 727, 410, 124, 338, 149, 209, 702, 282, 718, 771, 575, 436);
        System.out.println(nonDivisibleSubset(7, list));
    }


    public static int nonDivisibleSubset(int k, List<Integer> s) {

        int[] remainderArr = new int[k];
        for (Integer each : s) {
            remainderArr[each % k]++;
        }
        int zeroRemainder = remainderArr[0];
        int maxNumberOfDivisibleSet = zeroRemainder > 0 ? 1 : 0;
        for (int i = 1; i <= (k / 2); i++) {
            if (i != k - i)
                maxNumberOfDivisibleSet += Math.max(remainderArr[i], remainderArr[k - i]);
            else
                maxNumberOfDivisibleSet ++;
        }
        return maxNumberOfDivisibleSet;
    }


}
