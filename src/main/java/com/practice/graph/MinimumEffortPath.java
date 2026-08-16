package com.practice.graph;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class MinimumEffortPath {
//https://leetcode.com/problems/path-with-minimum-effort/

    public static class Point{
        int x, y, value;
        public Point(int x, int y, int value){
            this.x = x;
            this.y = y;
            this.value = value;
        }

    }

    PriorityQueue<Point> nextPoints;
    boolean[][] vested;
    int[][] heightDiff;
    int leastPath;

    int[][] neibours = {{0,-1},{-1,0},{1,0},{0, 1}};

    public int minimumEffortPath(int[][] heights) {
        if(heights== null || (heights.length <=1 && heights[0].length<=1))
            return 0;
        int matWidth = heights[0].length;
        int matHight = heights.length;
        //A stack to hold next points
        //A matrix to hold current difference
        //A set to list already calculated
        vested = new boolean[matHight][matWidth];
        heightDiff = new int[matHight][matWidth];
        nextPoints = new PriorityQueue<Point>((a,b)->a.value-b.value);
        leastPath = Integer.MAX_VALUE;
        for (int i = 0; i < matHight; i++){
            for(int j = 0 ; j < matWidth; j++){
                vested[i][j] = false;
                heightDiff[i][j] = Integer.MAX_VALUE;
            }
        }
        heightDiff[0][0] = 0;
        calculateLeastPath(heights, new Point(0,0,0));
        //From starting point get all possible next points

        //Pick one next point get all possible next points from it

        // keep going till reaching destination

        // keep doing this loop till there is no more possible path

        // least path is answer;
        return leastPath;
    }

    private void calculateLeastPath (int[][] height, Point point){
        if (point.x == height[0].length-1 && point.y == height.length-1){
            if(point.value < leastPath)
                leastPath = point.value;
            return;
        }
        nextPoints.addAll(getNeibours(height, point));
        while (!nextPoints.isEmpty()){
            Point nextPoint = nextPoints.poll();
            calculateLeastPath(height, nextPoint);
        }
    }

    private List<Point> getNeibours(int[][] height, Point point){
        List<Point> validList = new ArrayList<>();
        for(int i = 0; i< neibours.length; i++){
            int locX = point.x + neibours[i][1];
            int locY = point.y + neibours[i][0];
            if(locX<0 || locY<0 || height[0].length == locX || height.length== locY || vested[locY][locX]){
                continue;
            }
            int diff = Math.abs(height[point.y][point.x]-height[locY][locX]);
            if(diff > heightDiff[locY][locX])
                continue;
            heightDiff[locY][locX] = diff;
            validList.add(new Point(locX, locY, Math.max(diff, point.value)));
        }
        vested[point.y][point.x] = true;
        return validList;
    }

    @Test
    public void validate(){
        int[][] testData = {{1,2,2},{3,8,2},{5,3,5}};
        int expected = 2;
        Assert.assertEquals(expected, minimumEffortPath(testData));
        int[][] testData2 = {{1, 2, 3}, {3, 8, 4}, {5, 3, 5}};
        int expected2 = 1;
        Assert.assertEquals(expected2, minimumEffortPath(testData2));
        int[][] testData3 = {{1,2,1,1,1},{1,2,1,2,1},{1,2,1,2,1},{1,2,1,2,1},{1,1,1,2,1}};
        int expected3 = 0;
        Assert.assertEquals(expected3, minimumEffortPath(testData3));
        int[][] testData4 = {{1,10,6,7,9,10,4,9}};
        int expected4 = 9;
        Assert.assertEquals(expected4, minimumEffortPath(testData4));
    }


}
