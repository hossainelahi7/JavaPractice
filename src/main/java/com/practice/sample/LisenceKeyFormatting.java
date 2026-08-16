package com.practice.sample;

import java.util.Locale;

public class LisenceKeyFormatting {
 /*   public String licenseKeyFormatting(String s, int k) {
        String newString = s.contains("-")? String.join("",s.toUpperCase(Locale.ENGLISH).split("-")) : s;

        return newString;
    }*/
 public String licenseKeyFormatting(String s, int k) {
     if(null == s || s.length()<=0)
         return s;
     StringBuilder stringBuilder = new StringBuilder(s.toUpperCase(Locale.ENGLISH));
     int length = s.length();
     int sections = 1;
     for(int i = length-1 ; i>=0 ; i--){
         if(stringBuilder.charAt(i) == '-'){
             stringBuilder.deleteCharAt(i);
             length--;
             continue;
         }
         if(length - i == sections * k && i!= 0){
             stringBuilder.insert(i, '-');
             sections++;
         }
     }
     if(stringBuilder.length()>0 && stringBuilder.charAt(0)=='-')
         stringBuilder.deleteCharAt(0);
     return stringBuilder.toString();
 }

    public static void main(String[] args){
        LisenceKeyFormatting lisenceKeyFormatting = new LisenceKeyFormatting();
        System.out.println(lisenceKeyFormatting.licenseKeyFormatting("--a-a-a-a--", 2));
    }

}
