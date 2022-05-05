package com.practice.random.algorithm;

public class DrowingBook {
	public static int pageCount(int n, int p) {
		// Write your code here
		if (n / 2 >= p) {
			return p / 2;
		} else {
			return (n - p) / 2;
		}
	}

	public static int pageCount2(int n, int p) {
		// Write your code here
		int totalCount = n/2;
		int countFront = p/2;
		int countBack = totalCount - countFront;
		return Math.min(countFront, countBack);
	}
	
	
	public static void main(String[] arg) {
		System.out.println(DrowingBook.pageCount2(5, 4));
	}
}
