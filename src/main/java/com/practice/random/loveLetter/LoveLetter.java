package com.practice.random.loveLetter;

import java.util.Locale;

public class LoveLetter {

    public static int theLoveLetterMystery(String s) {
        char[] charSequence = s.toLowerCase(Locale.ROOT).toCharArray();
        int halfLength = charSequence.length/2;
        int even = (charSequence.length+1)%2;
        int totalOperation = 0;
        for(int i = 1 ; i <= halfLength ; i++){
            totalOperation += Math.abs(charSequence[halfLength-i] - charSequence[halfLength+i-even]);
        }
        return totalOperation;
    }

    public static void main(String[] args){
        System.out.println(theLoveLetterMystery("abc"));
    }
}
