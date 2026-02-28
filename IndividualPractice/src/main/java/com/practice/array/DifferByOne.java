package com.practice.array;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class DifferByOne {
    public boolean differByOne(String[] dict) {
        List<String> wordDict = new ArrayList<>();
        for(String word : dict){
            List<String> currentList = getDict(word);
            for(String currentWord : currentList){
                if(wordDict.contains(currentWord))
                    return true;
            }
            wordDict.addAll(currentList);
        }
        return false;
    }

    private List<String> getDict(String word){
        List<String> words = new ArrayList<>();
        char[] charList = word.toCharArray();
        for(int i = 0; i < charList.length ; i++){
            words.add(new StringBuilder(word).deleteCharAt(i).insert(i,'*').toString());
        }
        return words;
    }

    public static void main(String[] arg){
//        String[] words = {"ab","cd","yz"};
//        String[] words = {"abcd","cccc","abyd","abab"};
        String[] words = {"da","ae"};
        DifferByOne differByOne = new DifferByOne();
        System.out.println(differByOne.differByOne(words));
    }

}
