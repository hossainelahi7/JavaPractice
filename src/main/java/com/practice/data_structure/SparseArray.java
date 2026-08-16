package com.practice.data_structure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class SparseArray {

    /*
     * Complete the 'matchingStrings' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY stringList
     *  2. STRING_ARRAY queries
     */

    public static List<Integer> matchingStrings(List<String> stringList, List<String> queries) {
        // Write your code here
        Map<String, Integer> stringFrequency = new HashMap<>();
        for (String string : stringList) {
            stringFrequency.put(string, stringFrequency.getOrDefault(string, 0) + 1);
        }
        List<Integer> result = new ArrayList<>();
        for (String query : queries) {
            result.add(stringFrequency.getOrDefault(query, 0));
        }
        return result;
    }


    public static void main(String[] args) {
        List<String> stringList = List.of("aba", "baba", "aba", "xzxb");
        List<String> queries = List.of("aba", "xzxb", "ab");
        List<Integer> result = List.of(2, 1, 0); // Expected output
        assertEquals(result, matchingStrings(stringList, queries));
    }



}
