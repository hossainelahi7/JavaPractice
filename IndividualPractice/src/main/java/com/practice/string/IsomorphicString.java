package com.practice.string;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/explore/interview/card/google/66/others-4/3098/

public class IsomorphicString {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> sToT = new HashMap<>();
        Map<Character, Character> tToS = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            Character key = s.charAt(i);
            Character value = t.charAt(i);
            if (sToT.containsKey(key)){
                if(sToT.get(key) != value)
                    return false;
            }else {
                sToT.put(key, value);
            }
            if(tToS.containsKey(value)){
                if(tToS.get(value) != key )
                    return false;
            }else {
                tToS.put(value, key);
            }
        }
        return true;
    }
}
