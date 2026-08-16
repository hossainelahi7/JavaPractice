package com.practice.random.string;

import java.util.Stack;

public class StringDecoder {
    public String decodeString(String str){
        Stack<String> sections = new Stack<>();
        String val = "";
        String number = "";
        for(int i = 0 ; i < str.length(); i++){
            char charecter = str.charAt(i);
            if(Character.isDigit(charecter)){
                number = number + charecter;
                continue;
            }if(Character.isAlphabetic(charecter)){
                val = val + charecter;
                continue;
            }if(charecter=='['){
                sections.add(val);
                val = "";
                continue;
            }if(charecter == '}'){
                int count = Integer.valueOf(number);
                String prevSection = sections.pop();
                StringBuilder builder = new StringBuilder();
                while (count>0){
                    builder.append(val);
                    count--;
                }
                val= prevSection + builder;
                number = "";
            }
        }
        StringBuilder result = new StringBuilder();
        while (!sections.empty()){
            result.append(sections.pop());
        }
        result.append(val);
        return result.toString();
    }



    public static void main(String[] arg){
        String input = "def[ab[cd]{2}]{3}ghi";
        StringDecoder stringDecoder = new StringDecoder();
        System.out.println(stringDecoder.decodeString(input));
    }
}
