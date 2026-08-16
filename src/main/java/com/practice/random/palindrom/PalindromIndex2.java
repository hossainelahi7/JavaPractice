package com.practice.random.palindrom;

import java.util.ArrayList;
import java.util.List;

public class PalindromIndex2 {

    public static void main(String[] arg){
//        System.out.println(isPolidrom2("bacacab"));
        System.out.println(System.currentTimeMillis());
        System.out.println(palindromeIndex("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaacacabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
//        System.out.println(palindromeIndex("baa"));
        System.out.println(System.currentTimeMillis());
    }

    public static int palindromeIndex(String s) {
        for(int i = 0; i < s.length(); i++){
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(s);
            if(isPalidrom(stringBuilder.deleteCharAt(i).toString()))
                return i;
        }
        return -1;
    }

    public static boolean isPalidrom(String s){
        String firstPart = s.substring(0, s.length()/2);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(s.substring(s.length()/2+s.length()%2));
        String secondPart = stringBuilder.reverse().toString();
        return firstPart.equals(secondPart);
    }

//    public static getSum(String[] ops){
//        int result = Integer.MIN_VALUE;
//        char[] output  = new char[ops[]]
//
//        List<Integer> pros = new ArrayList<>();
//        for(int i = 0; i < ops.length ; i++){
//            if(ops[i].equalsIgnoreCase("C")){
//                ops[i-1]
//            }
//        }
//    }



}
