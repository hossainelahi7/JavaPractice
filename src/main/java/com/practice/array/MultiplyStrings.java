package com.practice.array;

import java.util.Locale;

public class MultiplyStrings {
/*
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
*/

    public String multiply(String num1, String num2) {
        if(num2.length()>num1.length()){
            return sum(num2, num1);
        }
        // loop for num2 length
        // each loop sum = sum + (num2.index * num1)
        String reminder = "";
        String result = "0";
        for(int i = num2.length()-1; i >= 0 ; i--){
            result = sum(result,  multiply(num1, Integer.parseInt(num2.charAt(i) + reminder)));
            reminder = reminder + "0";
        }
        // return result
        return result;
    }

    public String multiply(String num1, Integer number){
        int carry = 0;
        StringBuilder result = new StringBuilder();
        for(int i = num1.length()-1; i>=0; i--){
            int multi = (Integer.parseInt(num1.charAt(i)+"")) * number + carry;
            carry = multi/10;
            multi = multi%10;
            result.insert(0, multi);
        }
        if(carry >0)
            result.insert(0, carry);
        return result.toString();
    }

    public String sum(String num1, String num2){
        if(num2.length()>num1.length()){
            return sum(num2, num1);
        }
        StringBuilder result = new StringBuilder();
        int dif = num1.length() - num2.length();
        int carry = 0;
        for(int i = num2.length()-1; i >= 0; i--){
            int sum = (Integer.parseInt(num2.charAt(i)+"")) + (Integer.parseInt(num1.charAt(dif + i)+"")) + carry;
            carry = sum/10;
            sum = sum%10;
            result.insert(0, sum);
        }
        for(int i = dif; i >=0; i--){
            int sum = Integer.parseInt(num1.charAt(i)+"");
            carry = sum/10;
            sum = sum%10;
            result.insert(0, sum);
        }
        if(carry >0)
            result.insert(0, carry);
        return result.toString();
    }


    public static void main(String[] arg){
        MultiplyStrings multiplyStrings = new MultiplyStrings();
        System.out.println(multiplyStrings.multiply("123", "456"));
//        System.out.println(multiplyStrings.multiply("123456789", "987654321"));
    }
}
