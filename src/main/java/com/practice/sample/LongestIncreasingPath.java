package com.practice.sample;

import java.awt.Point;
import java.util.*;

public class LongestIncreasingPath {

    public int longestIncreasingPath(int[][] matrix) {
        Map<Point, Integer> checkedForward = new HashMap<>();
        int n = matrix.length;
        int m = matrix[0].length;
        for(int j = 0 ; j<n; j++){
            for(int i = 0; i<m; i++){
                Point point = new Point(i, j);
                if(!checkedForward.containsKey(point))
                    getPath(matrix, i,j, m,n,checkedForward);
            }
        }
        return checkedForward.size()>0? Collections.max(checkedForward.values()):1;
    }


    private int getPath(int[][] matrix, int x, int y, int m, int n, Map<Point, Integer> difMap){
        Point point = new Point(x,y);
        if(difMap.containsKey(point))
            return difMap.get(point);
        List<Integer> path = new ArrayList<>();
        if(x != 0 && matrix[y][x] < matrix[y][x-1]){
            // move next
            path.add(getPath(matrix, x-1,y,m,n, difMap)+1);
        }
        if(m-x > 1 && matrix[y][x] < matrix[y][x+1]){
            // move next
            path.add(getPath(matrix, x+1,y,m,n, difMap)+1);
        }
        if(y != 0 && matrix[y][x] < matrix[y-1][x]){
            // move next
            path.add(getPath(matrix, x,y-1,m,n, difMap)+1);
        }
        if(n-y > 1 && matrix[y][x] < matrix[y+1][x]){
            // move next
            path.add(getPath(matrix, x,y+1,m,n, difMap)+1);
        }
        int maxPath = path.size()>0? Collections.max(path): 1;
        difMap.put(point, maxPath);
        return maxPath;
    }

    public static void main(String[] arg){
        LongestIncreasingPath longestIncreasingPath = new LongestIncreasingPath();
        int[][] matrix = {{3,4,5},{3,2,6},{2,2,1}};
/*        int[][] matrix = {{1}};
        int[][] matrix = {{9,9,4},{6,6,8},{2,1,1}};
        int[][] matrix = {{6,8},{7,2}};*/
        System.out.println(longestIncreasingPath.longestIncreasingPath(matrix));
    }
}
