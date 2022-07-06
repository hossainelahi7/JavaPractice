package com.practice.array;

import java.util.Locale;

public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        return stringToInt(num1)*stringToInt(num2)+"";
    }

    private long stringToInt(String number){
        long value = 0;
        char[] numbers = number.toCharArray();
        boolean negetive = false;
        for(int i = 0; i < numbers.length; i++){
            if(numbers[i]=='-'){
                negetive = true;
                continue;
            }
            value += (numbers[i]-48)*Math.pow(10, numbers.length-i-1);
        }
        return negetive? value*-1 : value;
    }


    public static void main(String[] arg){
        MultiplyStrings multiplyStrings = new MultiplyStrings();
        System.out.println(multiplyStrings.multiply("123456789", "987654321"));
    }
}
