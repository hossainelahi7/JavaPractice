package com.practice.random.algorithm;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int n = in.nextInt();
            int k = in.nextInt();
            int r_q = in.nextInt();
            int c_q = in.nextInt();
            List<List<Integer>> obstacles = new ArrayList<>();
            for (int i = 0; i <= k/2; i++){
                obstacles.add(new ArrayList<Integer>(){{
                    add(in.nextInt());
                    add(in.nextInt());
                }});
            }
            int result = QueenAttack.queensAttack(n, k, r_q, c_q, obstacles);
            System.out.println(result);
        }
        in.close();
    }
}
