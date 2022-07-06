package com.practice.array;

public class MaxProfit {
    public static int maxProfit(int[] prices) {
        int profit = 0;
        boolean stock = false;
        int diff = 0;
        int loop = prices.length - 1;
        for(int i = 0; i <  loop; i++){
            diff = prices[i+1]-prices[i];
            if(diff<0 && !stock){
                stock = true;
                continue;
            } else if(i == 0 ){
                stock = true;
            }
            if( stock && diff>0)
                profit+=diff;
        }
        return profit;
    }


    public static void main(String[] arg){
//        int[] prices = {7,1,5,3,6,4};
        int[] prices = {7,6,4,3,1};
//        int[] prices = {1,2,3,4,5};

        System.out.println(maxProfit(prices));
    }
}
