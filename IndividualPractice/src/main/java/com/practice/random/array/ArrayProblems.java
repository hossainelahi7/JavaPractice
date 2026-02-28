package com.practice.random.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayProblems {

	static int simpleArraySum(int[] ar) {
		int size = ar.length;
		int result = 0;
		for (int i = 0; i < size; i++) {
			result += ar[i];
		}
		return result;
	}

	static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
		if (a.size() != b.size()) {
			return Collections.EMPTY_LIST;
		}
		Integer person1 = 0;
		Integer person2 = 0;
		for (int i = 0; i < a.size(); i++) {
			if (a.get(i) > b.get(i))
				person1++;
			else if (a.get(i) < b.get(i))
				person2++;
		}
		return Arrays.asList(person1, person2);
	}

	static long aVeryBigSum(long[] ar) {
		int size = ar.length;
		long result = 0;
		for (int i = 0; i < size; i++) {
			result += ar[i];
		}
		return result;
	}

	public static int diagonalDifference(List<List<Integer>> arr) {
		// Write your code here
		int size = arr.size();
		Integer sum1 = 0;
		Integer sum2 = 0;
		for (int i = 0; i < size; i++) {
			sum1 += arr.get(i).get(i);
			sum2 += arr.get(i).get(size - (i + 1));
		}
		if (sum1 > sum2)
			return sum1 - sum2;
		else
			return sum2 - sum1;
	}

	static int formingMagicSquare(int[][] s) {
		if(is_magic_square(s))
			return 0;
		int diff = Integer.MAX_VALUE;
		int temp = 0;
		int[][][] validMagics = getmagicarray();
		for (int[][] valid: validMagics) {
			temp = findExpense(s, valid);
			if(temp<diff)
				diff = temp;
		}
		return diff;
	}
	
	static int[][][] getmagicarray(){
		return new int[][][] {
			{{8,1,6},{3, 5, 7},{4,9,2}},
			{{6,1,8},{7,5,3},{2,9,4}},
			{{8,3,4},{1,5,9},{6,7,2}},
			{{4,3,8},{9,5,1},{2,7,6}},
			{{6,7,2},{1,5,9},{8,3,4}},
			{{2,7,6},{9,5,1},{4,3,8}},
			{{4,9,2},{3,5,7},{8,1,6}},
			{{2,9,4},{7,5,3},{6,1,8}}
		};
	}
	
	static int findExpense(int[][] original, int[][] created) {
		int cost = 0;
		int size = original.length;
		for(int i = 0; i< size; i++)
			for(int j = 0; j<size; j++)
				cost+=Math.abs(original[i][j]-created[i][j]);
		return cost;
	}
	
	static boolean is_magic_square(int[][] v) {
		int row = v.length;
		int total = row * (row ^ 2 + 1) / 2;
		int sum1 = 0;
		int sum2 = 0;
		for (int i = 0; i < row; ++i) {
			for (int j = 0; i < row; j++) {
				sum1 += v[i][j];
				if (sum1 != total)
					return false;
				sum2 += v[j][i];
				if (sum2 != total)
					return false;
			}
			sum1 = 0;
			sum2 = 0;
		}
		for (int i = 0; i <= row; ++i) {
			sum1 += v[i][i];
			sum2 += v[row - 1 - i][row - 1 - i];
			if (sum1 != total)
				return false;
			if (sum2 != total)
				return false;
		}
		return true;
	}

}
