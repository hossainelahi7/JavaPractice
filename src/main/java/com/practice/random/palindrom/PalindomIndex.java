package com.practice.random.palindrom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class PalindomIndex {


/*    public static boolean inPalindrom(String input){
        //avg of occurrence index of all char will be same
        Map<Character, List<Integer>> charIndex = new HashMap<>();
        List<Integer> currentList;
        for(int i = 0 ; i<input.length(); i++){
            Character character = input.charAt(i);
            if(charIndex.containsKey(character))
                currentList = charIndex.get(character);
            else
                currentList = new ArrayList<>();
            currentList.add(i+1);
            charIndex.put(input.toLowerCase(Locale.ROOT).charAt(i), currentList);
        }
        int avgIndex = (input.length()+1)/2;
        for(Character character: charIndex.keySet() ){
            Math charIndex.get(character)
        }
        return false;
    }*/

    public static int palindromeIndex(String s) {
        // Write your code here
        int size = s.length();
        int midIndex = size/2;
        boolean changedOnce = false;
        int polIndex = -1;
        char[] inputText = s.toLowerCase(Locale.ROOT).toCharArray();
        for(int i = 0, j = size-1; i<midIndex && j>=midIndex; i++, j--){
            if(inputText[i] != inputText[j]){
                if(changedOnce)
                    return -2;
                else{
                    changedOnce = true;
                    if(inputText[i+1] == inputText[j] && inputText[i+2] == inputText[j-1]) {
                        polIndex = i;
                        midIndex++;
                        i++;
                    }
                    else if(inputText[i] == inputText[j-1] && inputText[i+1] == inputText[j-2]) {
                        polIndex = j;
                        midIndex--;
                        j--;
                    }
                }
            }
        }
        return polIndex;
    }


    public static boolean isPolidrom2(String input){
        // split in half
        // reverse the second half
        // both list should be same
        char[] subString = input.toLowerCase(Locale.ROOT).substring(0, input.length()/2).toCharArray();
        List<Character> firstHalf = new ArrayList<>();
        for( char charecter : subString){
            firstHalf.add(charecter);
        }
        subString = input.toLowerCase(Locale.ROOT).substring((input.length()+1)/2).toCharArray();
        List<Character> secondHalf = new ArrayList<>();
        for(int i = subString.length-1; i >=0 ; i--){
            secondHalf.add(subString[i]);
        }
        return firstHalf.equals(secondHalf);
    }

    public static void main(String[] arg){
//        System.out.println(isPolidrom2("bacacab"));
        System.out.println(System.currentTimeMillis());
        System.out.println(palindromeIndex("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaacacabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
        System.out.println(System.currentTimeMillis());
    }

}
