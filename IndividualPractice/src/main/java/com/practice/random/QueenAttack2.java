package com.practice.random;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QueenAttack2 {

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
        int[][] obsArray = new int[k][2];
        for(int i = 0; i < obstacles.size(); i++){
            obsArray [i][0] = obstacles.get(i).get(0);
            obsArray [i][1] = obstacles.get(i).get(1);
        }
        int l = 0,r = 0 ,u=0,b=0,lu=0,lb=0,ru=0,rb=0;
        int boxes = 0;
        //up
        if(r_q > 1)
        {
            for(int i = r_q ; i>= 2 ; i--){
                if(validMove(obsArray,i-1,c_q))
                    ++boxes;
                else
                    break;
            }
        }
        //down
        if(r_q < n){
            for(int i = r_q ; i <= n-1 ; i++){
                if(validMove(obsArray,i+1,c_q))
                    ++boxes;
                else
                    break;
            }
        }
        //right
        if(c_q < n){
            for(int i = c_q ; i <= n-1 ; i++){
                if(validMove(obsArray,r_q,i+1))
                    ++boxes;
                else
                    break;
            }
        }
        //left
        if(c_q > 1){
            for(int i = c_q ; i>=2 ; i--){
                if(validMove(obsArray,r_q,i-1))
                    ++boxes;
                else
                    break;
            }
        }
        //diagonalrightup
        if(c_q < n && r_q > 1){
            for(int i = r_q , j = c_q ; (i >= 2) && (j <= n-1) ; i-- , j++){
                if(validMove(obsArray,i-1,j+1))
                    ++boxes;
                else
                    break;
            }
        }
        //diagonalrightdown
        if(c_q > 1 && r_q < n){
            for(int i = r_q , j = c_q ; (i <= n-1) && (j >= 2) ; i++ , j--){
                if(validMove(obsArray , i+1 , j-1))
                    ++boxes;
                else
                    break;
            }
        }
        //diagonalleftup
        if(c_q > 1 && r_q > 1){
            for(int i = r_q , j = c_q ; (i >= 2) && (j >= 2) ; i-- , j--){
                if(validMove(obsArray,i-1 , j-1))
                    ++boxes;
                else
                    break;
            }
        }
        //diagonalleftdown
        if(c_q < n && r_q < n){
            for(int i = r_q , j = c_q ; (i <= n-1) && (j <= n-1) ; i++ , j++){
                if(validMove(obsArray,i+1,j+1))
                    ++boxes;
                else
                    break;
            }
        }
        return boxes;
    }
    public static boolean validMove(int obstacles[][] , int row , int column){
        for(int i = 0 ; i < obstacles.length ; i++){
            if(obstacles[i][0] == row && obstacles[i][1] == column){
                return false;
            }
        }
        return true;
    }




    public static void main(String[] arg){
        List<List<Integer>> obsticles = new ArrayList<>();
        int boardSize = 4;
        int obstacles = 2;
        int queenX = 3;
        int queenY = 3;
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
