package com.practice.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlusOne {
    //https://leetcode.com/explore/interview/card/google/59/array-and-strings/339/

    public int[] plusOne(int[] digits) {
        int carry = 0;
        int index = digits.length-1;
        digits[index]++;
        if(digits[index]>9){
            carry = digits[index]/10;
            digits[index] = (digits[index]%10);
        }
        index--;
        while (carry>0 && index>=0){
            digits[index]++;
            carry =digits[index]/10;
            if(carry>0)
                digits[index] = (digits[index]%10);
            index--;
        }
        if(carry>0) {
            int[] newDigits = new int[digits.length+1];
            newDigits[0] = carry;
            for(int i = 0 ; i < digits.length; i++){
                newDigits[i+1] = digits[i];
            }
            return newDigits;
        }
        return digits;
    }

    public static void main(String[] arg){
//        int[] input = {1,2,3};
        int[] input = {9,9};
        PlusOne plusOne = new PlusOne();
        int[] result = plusOne.plusOne(input);
    }
}
