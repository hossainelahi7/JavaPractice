package com.practice.random.array;



import java.util.List;
import java.util.Set;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;



public class NumberofIslands {
    private Set<List<Integer>> checked;

    public void getIslandArea(char[][] grid, int x, int y){
        // create a queue
        Queue<List<Integer>> islandMap= new ArrayDeque<>();
        List<Integer> currentPosition = new ArrayList<>();
        currentPosition.add(x);
        currentPosition.add(y);
        islandMap.add(new ArrayList<>(currentPosition));
        currentPosition.clear();
        // loop till que is empty
        while (!islandMap.isEmpty()){
            // inside loop pop que find next with val == 1 and store them in que
            currentPosition = islandMap.poll();
            checked.add(currentPosition);
            int locX = currentPosition.get(0);
            int locY = currentPosition.get(1);
            //left
            currentPosition.clear();
            currentPosition.add(locX-1);
            currentPosition.add(locY);
            if(!islandMap.contains(currentPosition) && locX > 0 &&  grid[locY][locX-1] == '1'){
                islandMap.add(new ArrayList<>(currentPosition));
                checked.add(new ArrayList<>(currentPosition));
            }
            //right
            currentPosition.clear();
            currentPosition.add(locX+1);
            currentPosition.add(locY);
            if(!islandMap.contains(currentPosition) && (grid[0].length - locX) > 1 &&  grid[locY][locX+1] == '1'){
                islandMap.add(new ArrayList<>(currentPosition));
                checked.add(new ArrayList<>(currentPosition));
            }
            //top
            currentPosition.clear();
            currentPosition.add(locX);
            currentPosition.add(locY-1);
            if(!islandMap.contains(currentPosition) && locY > 0 &&  grid[locY-1][locX] == '1'){
                islandMap.add(new ArrayList<>(currentPosition));
                checked.add(new ArrayList<>(currentPosition));
            }
            //bottom
            currentPosition.clear();
            currentPosition.add(locX);
            currentPosition.add(locY+1);
            if(!islandMap.contains(currentPosition) && (grid.length - locY) > 1 &&  grid[locY+1][locX] == '1'){
                islandMap.add(new ArrayList<>(currentPosition));
                checked.add(new ArrayList<>(currentPosition));
            }
        }
    }


    public int numIslands2(char[][] grid) {
        checked = new HashSet<>();
        List<Integer> currentLocation = new ArrayList<>();
        int islands = 0 ;
        for(int i = 0; i < grid.length; i++ ){
            for(int j = 0 ; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    currentLocation.clear();
                    currentLocation.add(j);
                    currentLocation.add(i);
                    if(checked.isEmpty()){
                        getIslandArea(grid, j, i);
                        islands++;
                    } else if (!checked.contains(currentLocation)){
                        getIslandArea(grid, j, i);
                        islands++;
                    }
                }
            }
        }
        return islands;
    }


    void dfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;

        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    ++num_islands;
                    dfs(grid, r, c);
                }
            }
        }

        return num_islands;
    }


    public static void main(String[] arg){
        char[][] grid = {
                {'1','1','1','1','0'},
                {'0','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        NumberofIslands numberofIslands = new NumberofIslands();
        System.out.println(numberofIslands.numIslands(grid));
    }
}
