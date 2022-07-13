package com.practice.graph;


import java.awt.*;
import java.util.*;
import java.util.List;

public class MinArea {
//https://leetcode.com/explore/interview/card/google/66/others-4/3105/
    List<Point> visited = new ArrayList<>();



    public int minAreaRect(int[][] points) {
        // create a map x -> all y and y -> all x; Sort all keys and also the values.
        if(points.length<=1){
            return 0;
        }
        int minArea = Integer.MAX_VALUE;
        Map<Integer, List<Integer>> xValues = new TreeMap<>();
        Map<Integer, List<Integer>> yValues = new TreeMap<>();
        for(int[] point: points){
            xValues.getOrDefault(point[0], new ArrayList<>()).add(point[1]);
            yValues.getOrDefault(point[1], new ArrayList<>()).add(point[0]);
        }
        for(List<Integer> values : xValues.values()){
            Collections.sort(values);
        }
        for(List<Integer> values : yValues.values()){
            Collections.sort(values);
        }

        // Loop through x and then y, for each value of x1-> y1, pic x -> y2 where there is a y1 -> x2 and y2 -> x2
        // get area Math.abs ((x1-x2)*(y1-y2)) is less then min area update min area
        //
        for(Integer key : xValues.keySet()){
            int size = xValues.get(key).size();
            if(size<2)
                continue;
            Queue<Point> next = new ArrayDeque<>();
            next.addAll(getNeibours(key, xValues.get(key)));
            while (!next.isEmpty()){
                Point point1 =
            }
        }

        //end of loop min area is min area;
        return minArea == Integer.MAX_VALUE? 0 : minArea;
    }

    private List<Point> getNeibours(int x, List<Integer> values){
        List<Point> pointList= new ArrayList<>();
        values.forEach(value ->{
            Point point = new Point(x, value);
            if(!visited.contains(point)){
                pointList.add(point);
                visited.add(point);
            }
        });
        return pointList;
    }
}
