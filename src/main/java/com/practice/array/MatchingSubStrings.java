package com.practice.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MatchingSubStrings {
    public int numMatchingSubseq(String s, String[] words) {
        List<String>[] holds = new ArrayList[26];
        for (int i = 0; i < 26; ++i)
            holds[i] = new ArrayList<String>();

        for(String word : words){
            word = word.toLowerCase(Locale.ENGLISH);
            holds[word.charAt(0) - 'a'].add(word);
        }
        int matches = 0;
        for(char letter : s.toCharArray()){
            int index = letter-'a';
            List<String> temps = holds[index];
            holds[index] = new ArrayList<>();
            for(String temp: temps){
                if(temp.length()==1)
                    matches++;
                else {
                    int newIndex = temp.charAt(1) - 'a';
                    holds[newIndex].add(temp.substring(1));
                }
            }
        }
        return matches;
    }


    public static void main(String[] args){
//        String s = "abcde";
        String s = "dsahjpjauf";
//        String[] words = {"a","bb","acd","ace"};
        String[] words = {"ahjpjau","ja","ahbwzgqnuk","tnmlanowax"};
        MatchingSubStrings matchingSubStrings = new MatchingSubStrings();
        System.out.println(matchingSubStrings.numMatchingSubseq(s, words));
    }
}
