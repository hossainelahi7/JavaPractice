package com.practice.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class MaxSubString {

    public String longestWord(String[] words) {
        Set<String> wordSet = new HashSet<>();
        Collections.addAll(wordSet, words);
        Arrays.sort(words, (a,b)->
                a.length()==b.length()? a.compareTo(b) : b.length()-a.length());
        for(int i = 0 ; i < words.length; i++){
            if(canBuild(words[i], wordSet)){
                return words[i];
            }
        }
        return "";
    }

    private boolean canBuild(String word, Set<String>wordList){
        for(int j = 0 ; j < word.length()-1; j++){
            if(!wordList.contains(word.substring(0, j+1)))
                return false;
        }
        return true;
    }


    public static void main(String[] arg){
//        String[] words = {"w","wo","wor","worl","world"};
        String[] words = {"a","banana","app","appl","ap","apply","apple"};
        MaxSubString maxSubString = new MaxSubString();
        System.out.println(maxSubString.longestWord(words));
    }

}
