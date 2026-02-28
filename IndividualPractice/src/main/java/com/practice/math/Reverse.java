package com.practice.math;

public class Reverse {

    public int reverse(int x) {
        int newNumber = 0;
        while (x != 0) {
            int reminder = x % 10;
            x /= 10;
            if (newNumber > Integer.MAX_VALUE/10 || (newNumber == Integer.MAX_VALUE / 10 && reminder > 7))
                return 0;
            if (newNumber < Integer.MIN_VALUE/10 || (newNumber == Integer.MIN_VALUE / 10 && reminder < -8))
                return 0;
            newNumber = newNumber * 10 + reminder;
        }
        return newNumber;
    }


    public static void main(String[] arg){
        Reverse reverse = new Reverse();
        System.out.println(reverse.reverse(167));
    }
}
