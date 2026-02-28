package com.practice.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class StackBasic {
    public static Map<Character, Character> matchingList;

    public static void main(String []argh) {
        matchingList = new HashMap<>();
//        matchingList.put('(', ')');
        matchingList.put(')', '(');
//        matchingList.put('{', '}');
        matchingList.put('}', '{');
//        matchingList.put('[', ']');
        matchingList.put(']', '[');
        String input = "({()})";
        System.out.println(isBalanced(input));
    }

    public static boolean isBalanced(String input){
        Stack<Character> stack = new Stack<Character>();
        for(char charInput : input.toCharArray()){
            if(stack.size() > 0 && stack.peek() == matchingList.get(charInput))
                stack.pop();
            else
                stack.push(charInput);
        }
        return stack.size() == 0;
    }
}
