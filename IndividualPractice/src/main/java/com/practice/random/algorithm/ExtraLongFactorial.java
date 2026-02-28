package com.practice.random.algorithm;

import java.math.BigInteger;

public class ExtraLongFactorial {
	
    static void extraLongFactorials(int n) {
    	System.out.println(getFactorial(n));
    }
    
    public static BigInteger getFactorial(int n) {
    	BigInteger total = BigInteger.valueOf(1);
    	for(int i = n ; i>0; i--) {
    		total = total.multiply(BigInteger.valueOf(i));
    	}
    	return total;
    }
    
    
    public static void main(String[] arg) {
    	extraLongFactorials(25);
    }

}
