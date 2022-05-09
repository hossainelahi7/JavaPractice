package com.practice.random;

import java.util.ArrayList;
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

    public static int queensAttack(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles) {
        // Write your code here
        int count = 4 * (n - 1) - Math.abs(r_q - c_q) - Math.abs(r_q + c_q - n - 1);
        for(List<Integer> obstacle : obstacles){
            count = count - getBlockedCells(r_q, c_q, obstacle.get(0), obstacle.get(1), n);
        };
        return count;
    }

    public static int getBlockedCells(int queenX, int queenY, int pawnX, int pawnY, int boardSize){
        int difx = queenX - pawnX;
        int dify = queenY - pawnY;
        if(difx == 0 ){
            return Math.min(pawnY, boardSize-pawnY+1);
        } else if( dify == 0 ){
            return Math.min(pawnX, boardSize-pawnX+1);
        } else if(Math.abs(difx) == Math.abs(dify)){
            return Math.min(Math.min(pawnX, pawnY), Math.min(boardSize-pawnX+1, boardSize-pawnY+1));
        } else{
            return 0;
        }
    }

    public static void main(String[] arg){
        List<List<Integer>> obsticles = new ArrayList<>();
        int boardSize = 4;
        int obstacles = 1;
        int queenX = 3 ;
        int queenY = 4;
        obsticles.add(new ArrayList<Integer>(){{
            add(2);
            add(2);
        }});
        System.out.println(queensAttack(boardSize, obstacles, queenX, queenY , obsticles));
    }

}
