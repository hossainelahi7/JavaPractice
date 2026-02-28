package com.practice.random.algorithm;

import java.awt.Point;
import java.util.*;


public class ShortestBinaryPath {


    private Map<Point, Integer> path;

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int width = grid[0].length - 1;
        int length = grid.length - 1;
        if (grid[0][0] != 0 || grid[length][width] != 0)
            return -1;
        path = new HashMap<>();
        path.put(new Point(0, 0), 1);
        getPath(grid);
        return path.getOrDefault(new Point(width, length), -1);
    }

    private void getPath(int[][] grid) {
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(0, 0));
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            if (path.containsKey(point)) {
                queue.addAll(getAdjesents(grid, point.x, point.y));
                continue;
            }
            List<Integer> values = new ArrayList<>();
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    int posX = point.x + j;
                    int posY = point.y + i;
                    if (posX < 0 || posY < 0 || posY == grid.length || posX == grid[0].length || (i == 0 && j == 0)) {
                        continue;
                    }
                    Point adjasentPoint = new Point(posX, posY);
                    if (path.containsKey(adjasentPoint)) {
                        int value = path.get(adjasentPoint);
                        values.add(value);
                    } else if (grid[posY][posX] == 0) {
                        queue.add(adjasentPoint);
                    }
                }
            }
            if (!values.isEmpty())
                path.put(point, Collections.min(values) + 1);
        }
    }

    private Queue<Point> getAdjesents(int[][] grid, int x, int y) {
        Queue<Point> points = new ArrayDeque<>();
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                int posX = x + j;
                int posY = y + i;
                Point point = new Point(posX, posY);
                if (posX < 0 || posY < 0 || posY == grid.length || posX == grid[0].length || (i == 0 && j == 0) || path.containsKey(point)) {
                    continue;
                }
                if (grid[posY][posX] == 0) {
                    points.add(point);
                }
            }
        }
        return points;
    }

    public static void main(String[] arg) {
//        int[][] mat = {{0, 1}, {1, 0}};
//        int[][] mat = {{1,0,0},{1,1,0},{1,1,0}};
        int[][] mat = {{0,0,0},{1,1,0},{1,1,0}};
        ShortestBinaryPath shortestBinaryPath = new ShortestBinaryPath();
        System.out.println(shortestBinaryPath.shortestPathBinaryMatrix(mat));
    }

}
