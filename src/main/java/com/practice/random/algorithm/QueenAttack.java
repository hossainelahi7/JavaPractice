package com.practice.random.algorithm;

import java.util.*;
import java.util.List;

public class QueenAttack {

    /*
     * Complete the 'queensAttack' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER k
     *  3. INTEGER r_q
     *  4. INTEGER c_q
     *  5. 2D_INTEGER_ARRAY obstacles
     */
    private static class Keys{
        public static String top ="TOP", bottom="BOTTOM", left="LEFT", right="RIGHT", topRight="TOPRIGHT",
            topLeft="TOPLEFT", botLeft="BOTLEFT", botRight = "BOTRIGHT";
    }

    public static int queensAttack(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles) {
        // Write your code here
        Map<String, Integer> obstaclesMap = new HashMap<>();
        int count = 4 * (n - 1) - Math.abs(r_q - c_q) - Math.abs(r_q + c_q - n - 1);
        for(List<Integer> obstacle : obstacles){
            getBlockedCells(r_q, c_q, obstacle.get(0), obstacle.get(1), n, obstaclesMap);
        }
        for(String entry: obstaclesMap.keySet()){
            count-=obstaclesMap.get(entry);
        }
        return count;
    }

    public static int getBlockedCells(int queenX, int queenY, int pawnX, int pawnY, int boardSize, Map<String, Integer> obstacles){
        int difx = queenX - pawnX;
        int dify = queenY - pawnY;
        int blocks = 0;
        int oldval;
        if(queenX == pawnX && queenY == pawnY)
            return 0;
        else if(difx == 0 ){
            blocks = Math.min(pawnY, boardSize-pawnY+1);
            if( dify > 0 ){
                oldval = obstacles.getOrDefault(Keys.bottom, 0);
                if(oldval<=blocks)
                    obstacles.put(Keys.bottom, blocks);
                else
                    blocks = oldval;
            }else{
                oldval = obstacles.getOrDefault(Keys.top, 0);
                if(oldval<=blocks)
                    obstacles.put(Keys.top, blocks);
                else
                    blocks = oldval;
            }
            return blocks;
        } else if( dify == 0 ){
            blocks = Math.min(pawnX, boardSize-pawnX+1);
            if( difx > 0 ){
                oldval = obstacles.getOrDefault(Keys.left, 0);
                if(oldval<=blocks)
                    obstacles.put(Keys.left, blocks);
                else
                    blocks = oldval;
            }else{
                oldval = obstacles.getOrDefault(Keys.right, 0);
                if(oldval<=blocks)
                    obstacles.put(Keys.right, blocks);
                else
                    blocks = oldval;
            }
            return blocks;
        } else if(Math.abs(difx) == Math.abs(dify)){
            blocks = Math.min(Math.min(pawnX, pawnY), Math.min(boardSize-pawnX+1, boardSize-pawnY+1));
            if( difx > 0){
                if(dify > 0){
                    oldval = obstacles.getOrDefault(Keys.botLeft, 0);
                    if(oldval<=blocks)
                        obstacles.put(Keys.botLeft, blocks);
                    else
                        blocks = oldval;
                }else {
                    oldval = obstacles.getOrDefault(Keys.botRight, 0);
                    if (oldval <= blocks)
                        obstacles.put(Keys.botRight, blocks);
                    else
                        blocks = oldval;
                }
            }else {
                if (dify > 0) {
                    oldval = obstacles.getOrDefault(Keys.topLeft, 0);
                    if (oldval <= blocks)
                        obstacles.put(Keys.topLeft, blocks);
                    else
                        blocks = oldval;
                } else {
                    oldval = obstacles.getOrDefault(Keys.topRight, 0);
                    if (oldval <= blocks)
                        obstacles.put(Keys.topRight, blocks);
                    else
                        blocks = oldval;
                }
            }
            return blocks;
        } else{
            return 0;
        }
    }

    public static void main(String[] arg){
        List<List<Integer>> obsticles = new ArrayList<>();
        int boardSize = 100;
        int obstacles = 100;
        int queenX = 48 ;
        int queenY = 81;
        obsticles.add(new ArrayList<Integer>(){{
            add(4);
            add(3);
        }});
        obsticles.add(new ArrayList<Integer>(){{
            add(3);
            add(2);
        }});
        System.out.println(queensAttack(boardSize, obstacles, queenX, queenY , obsticles));
    }

}
