package com.practice.graph;

import java.util.*;

public class CourseList {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> backtrace = new ArrayList<>();
        Stack<Integer> next = new Stack<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        List<Integer> currentLoop = new ArrayList<>();
        for(int i = 0 ; i < prerequisites.length; i++){
            int key = prerequisites[i][0];
            int value = prerequisites[i][1];
            List<Integer> currentList = graph.containsKey(key)? graph.get(key) : new ArrayList<>();
            currentList.add(value);
            graph.put(key, currentList);
        }
        for(Map.Entry entry : graph.entrySet()){
            if(!backtrace.contains(entry.getKey())){
                next.push((Integer) entry.getKey());
                while(!next.isEmpty()){
                    int key = next.pop();
                    if(currentLoop.contains(key))
                        return new int[0];
                    List<Integer> nextKeys = graph.getOrDefault(key, new ArrayList<>());
                    for(Integer nextKey: nextKeys){
                        if(!backtrace.contains(nextKey))
                            next.push(nextKey);
                    }
                    currentLoop.add(key);
                    backtrace.add(key);
                }
            }
            currentLoop.clear();
        }
        // check if any course missing in backtrace
        // also update to result
        int[] result = new int[numCourses];
        for(int i = 0, inverted = numCourses-1 ; i < numCourses; i++, inverted--){
            if(!backtrace.contains(i))
                backtrace.add(i);
            result[inverted] = backtrace.get(i);
        }
        return result;
    }


    public static void main(String[] arg){
//        int input1 = 2;
        int input1 = 4;
//        int[][] input2 = {{1,0}};
        int[][] input2 = {{1,0},{2,0},{3,1},{3,2}};
        CourseList courseList = new CourseList();
        int[] courseSequence = courseList.findOrder(input1, input2);
        System.out.println(courseSequence);
    }
}
