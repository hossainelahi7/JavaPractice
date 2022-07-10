package com.practice.random.algorithm;

import java.awt.*;
import java.util.List;
import java.util.Queue;
import java.util.*;


public class ShortestBinaryPath2 {

    int[][] neibours = {{-1,-1},{0,-1},{1,-1},{-1,0},{1,0},{-1,1},{0, 1}, {1, 1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        int path = 1;
        //other edge conditions
        if(grid== null || grid.length<=0 || grid[0].length <=0 || grid[0][0]!=0 || grid[grid.length-1][grid[0].length-1]!=0)
            return -1;
        // BTS start from one end of the path: this case from begening
        Queue<int[]> nextList = new ArrayDeque<>();
        nextList.add(new int[]{0, 0});
        grid[0][0] = path;
        while(!nextList.isEmpty()){
            int[] currentLocation = nextList.poll();
            path = grid[currentLocation[0]][currentLocation[1]];
            if(grid.length - currentLocation[0] == 1 && grid[0].length - currentLocation[1] == 1){
                return grid[currentLocation[0]][currentLocation[1]];
            }
            path++;
            // get all possible next paths: get neibours
            for(int[] neibour : getNeibours(grid, currentLocation[1], currentLocation[0])){
                // if next is already calculated return calculated, if not add +1 to current and set to neibours val
                grid[neibour[0]][neibour[1]]  = path;
                // loop last two lines till reach end of path
                nextList.add(neibour);
            }
        }
        return -1;
    }

    private List<int[]> getNeibours(int[][] grid, int x, int y){
        List<int[]> validList = new ArrayList<>();
        for(int i = 0; i< neibours.length; i++){
            int locX = x + neibours[i][1];
            int locY = y + neibours[i][0];
            if(locX<0 || locY<0 || grid[0].length == locX || grid.length== locY || grid[locY][locX]!=0){
                continue;
            }
            validList.add(new int[]{locY, locX});
        }
        return validList;
    }

    public static void main(String[] arg) {
//        int[][] mat = {{0, 1}, {1, 0}};
//        int[][] mat = {{1,0,0},{1,1,0},{1,1,0}};
        int[][] mat = {{0,0,0},{1,1,0},{1,1,0}};
        ShortestBinaryPath2 shortestBinaryPath = new ShortestBinaryPath2();
        System.out.println(shortestBinaryPath.shortestPathBinaryMatrix(mat));
    }

}
