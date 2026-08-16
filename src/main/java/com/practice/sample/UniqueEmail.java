package com.practice.sample;

import java.util.ArrayList;
import java.util.List;

public class UniqueEmail {
    public int numUniqueEmails(String[] emails) {
        List<String> emailList = new ArrayList<>();
        for(int i = 0 ; i < emails.length; i++){
            String email = convertEmail(emails[i]);
            if(!emailList.contains(email)){
                emailList.add(email);
            }
        }
        return emailList.size();
    }

    private String convertEmail(String email){
        String[] subEmail = email.split("@");
        if(subEmail.length<=0)
            return "";
        if(subEmail[0].contains("+"))
            subEmail[0] = subEmail[0].split("\\+")[0];
        while(subEmail[0].contains(".")){
            int position = subEmail[0].indexOf(".");
            subEmail[0] = subEmail[0].substring(0, position)+ subEmail[0].substring(position+1);
        }
        return subEmail[0]+"@"+subEmail[1];
    }

    public static void main(String[] arg){
        UniqueEmail uniqueEmail = new UniqueEmail();
        String[] emails = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        System.out.println(uniqueEmail.numUniqueEmails(emails));
    }
}
