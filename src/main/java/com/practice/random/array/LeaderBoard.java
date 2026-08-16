package com.practice.random.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class LeaderBoard {
	
    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
    	List<Integer> ranking = new ArrayList<Integer>();
    	for(Integer score: player) {
    		ranking.add(getCurrentRank(ranked, score));
    	}
    	return ranking;
    }
    
    public static Integer getCurrentRank(List<Integer> rankBoard, Integer score) {
    	List<Integer> newBoard = new ArrayList<Integer>(rankBoard);
    	newBoard.add(score);
//		List<Integer> cleanedList = new ArrayList<Integer>(new HashSet<Integer>(newBoard));
    	List<Integer> cleanedList = newBoard.stream()
			     .distinct()
			     .collect(Collectors.toList());
    	newBoard.clear();
//    	removeDuplicates(newBoard);
		Collections.sort(cleanedList, Collections.reverseOrder());
		return cleanedList.indexOf(score)+1;
    }
    
    public static void removeDuplicates(List<Integer> list) {
    	for(int i = 0; i < list.size(); i++) {
    		if(list.indexOf(list.get(i))!= i)
    			list.remove(list.get(i));
    	}
//    	return list;
    }

    
	/*
	 * public static void solution2(List<Integer> scores, List<Integer> alice) {
	 * List<Integer> array = new ArrayList<Integer>(new HashSet<Integer>(scores));
	 * // (Integer[]) java.util.stream.Stream.of(scores).distinct().toArray(); int i
	 * = array.length-1; for(Integer score: alice) { while(i>=0) {
	 * if(score>=array[i]) i--; else {System.out.println(i+2); break;} } if(i<0)
	 * System.out.println(1); } }
	 */

    
    public static void main(String[] args) {
    	List<Integer> scores = new ArrayList<Integer>();
    	List<Integer> player = new ArrayList<Integer>();
    	scores = Arrays.asList(100, 90, 90, 80, 75, 60);
    	player = Arrays.asList(50,65,77,90,102);
    	System.out.println(climbingLeaderboard(scores, player));
//    	solution2(scores, player);
    }

}
