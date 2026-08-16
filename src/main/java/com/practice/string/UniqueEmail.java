package com.practice.string;

import java.util.ArrayList;
import java.util.List;

public class UniqueEmail {


    public int numUniqueEmails(String[] emails) {
        List<String> emailLocalName = new ArrayList<>();
        for(String email:emails){
            String localName = getEmailLocalName(email);
            if(!emailLocalName.contains(localName))
                emailLocalName.add(localName);
        }
        return emailLocalName.size();
    }

    private String getEmailLocalName(String email){
        String[] emailSections = email.split("@");
        if(emailSections[0].contains("+"))
            emailSections[0] = emailSections[0].split("\\+")[0];
        return emailSections[0].replaceAll("\\.", "") +'@'+ emailSections[1];
    }

    public static void main(String[] arg){
        String[] input = {"a@leetcode.com","b@leetcode.com","c@leetcode.com"};
        UniqueEmail uniqueEmail = new UniqueEmail();
        System.out.println(uniqueEmail.numUniqueEmails(input));
    }
}
