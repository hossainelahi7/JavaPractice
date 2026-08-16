package com.practice.string;

import java.util.Arrays;

public class BullsAndCows {
    public String getHint(String secret, String guess) {
        int[] frequency1 = new int[10];
        int[] frequency2 = new int[10];
        Arrays.fill(frequency1, 0);
        Arrays.fill(frequency2, 0);
        int bull = 0, cow = 0;
        for(int i = 0 ; i < secret.length(); i++){
            char number = secret.charAt(i);
            char given = guess.charAt(i);
            if(number == given){
                bull++;
            }else{
                frequency1[number - '0']++;
                frequency2[given - '0']++;
            }
        }
        for(int i = 0; i < frequency1.length; i++){
            cow += Math.min(frequency1[i], frequency2[i]);
        }
        return bull+"A"+cow+"B";
    }
}
