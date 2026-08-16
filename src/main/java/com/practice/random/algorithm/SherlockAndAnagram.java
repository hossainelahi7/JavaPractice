package com.practice.random.algorithm;

import java.lang.reflect.Array;
import java.util.*;

public class SherlockAndAnagram {

    public static int getNumberOfAnnagram(String text){
        Map<String, Integer> frequencylist = getSubStringList(text);
        int count = 0;
        for(String entry : frequencylist.keySet()){
            count+=frequencylist.get(entry);
        }
        return count;
    }


    private static Map<String, Integer> getSubStringList(String text){
        Map<String, Integer> substrings = new HashMap<>();
        int size = text.length();
        for(int i = 1 ; i < size ; i++){
//            for( int j = 0 ; j <= (size - i) ; j++){
                for( int k = i ; k <= (size-i ); k++){
                    char[] charset = text.substring(k, k+i).toCharArray();
                    Arrays.sort(charset);
                    String converted = charToString(charset);
                    if(substrings.containsKey(converted))
                        substrings.put(converted, substrings.get(converted)+1);
                    else
                        substrings.put(converted, 0);
                }
//            }
        }
        return substrings;
    }


    private static String charToString(char[] input){
        StringBuffer buffer = new StringBuffer();
        for(int i = 0 ; i < input.length; i++){
            buffer.append(input[i]);
        }
        return buffer.toString();
    }

    public static void main(String[] arg){
        System.out.println(getNumberOfAnnagram("kkkk"));
    }
    /**
     * Sample Input 0
     *
     * 2
     * abba
     * abcd
     * Sample Output 0
     *
     * 4
     * 0
     *
     * Sample Input 1
     *
     * 2
     * ifailuhkqq
     * kkkk
     * Sample Output 1
     *
     * 3
     * 10
     *
     * Sample Input 2
     *
     * 1
     * cdcd
     * Sample Output 2
     *
     * 5
     *
     * */
}
