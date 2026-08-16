package com.practice.string;

import java.util.HashMap;
import java.util.Map;

public class MinimumSubString {
//    https://leetcode.com/explore/interview/card/google/59/array-and-strings/345/

    public String minWindow(String s, String t) {
        if(t.length() == 0 || s.length() < t.length())
            return "";
        // create a dictionary map of t
        Map<Character, Integer> tMap = new HashMap<>();
        for(Character character: t.toCharArray()){
            tMap.put(character, tMap.getOrDefault(character, 0)+1);
        }
        //Create a map for s
        Map<Character, Integer> sMap = new HashMap<>();
        // going to find left position
        int left =0 , right = 0;
        boolean contains = false;
        while (right< s.length() && !contains){
            Character character = s.charAt(right);
            sMap.put(character, sMap.getOrDefault(character, 0)+1);
            contains = contains(sMap, tMap);
            right++;
        }
        if(right == s.length() && !contains)
            return "";
        while (left < right && contains){
            Character character = s.charAt(left);
            sMap.put(character, sMap.get(character)-1);
            contains = contains(sMap,tMap);
            left++;
        }
        return s.substring(left-1, right);
    }

    private boolean contains(Map<Character, Integer> sMap, Map<Character, Integer> tMap){
        if(sMap.size() < tMap.size())
            return false;
        for(Map.Entry entry: tMap.entrySet()){
            if(sMap.getOrDefault(entry.getKey(), 0) < (Integer) entry.getValue())
                return false;
        }
        return true;
    }

    public static void main(String[] arg){
        String s = "ADOBECODEBANC";
        String t = "ABC";
        MinimumSubString minimumSubString = new MinimumSubString();
        System.out.println(minimumSubString.minWindow(s,t));
    }

}
