package com.practice.random.algorithm;

public class HikeCount {
	
    public static int countingValleys(int steps, String path) {
    // Write your code here
        int v = 0;     // # of valleys
        int lvl = 0;   // current level
        for(char c : path.toCharArray()){
            if(c == 'U') ++lvl;
            if(c == 'D') --lvl;
            
            // if we just came UP to sea level
            if(lvl == 0 && c == 'U')
                ++v;
        }
        return v;
    }

    public static void main(String[] arg) {
    	int steps = 12;
    	String path = "DDUUDDUDUUUD";
    	System.out.println(countingValleys(steps, path));
    }

}
