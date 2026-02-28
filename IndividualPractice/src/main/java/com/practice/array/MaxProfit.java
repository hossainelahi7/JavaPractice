package com.practice.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MaxProfit {
    public int maxProfit(int[] prices) {
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

    //https://leetcode.com/explore/interview/card/top-interview-questions-easy/97/dynamic-programming/572/

    public int maxProfit2(int[] prices) {
        if(prices.length<2){
            return 0;
        }
        List<Integer> priceList = Arrays.stream(prices)
                .boxed()
                .collect(Collectors.toList());
        int minValue = Collections.min(priceList.subList(0, priceList.size()-1));
        int minIndex = priceList.indexOf(minValue);
        int maxValue = Collections.max(priceList.subList(minIndex, priceList.size()));
        return maxValue - minValue;
    }



    public static void main(String[] arg){
//        int[] prices = {7,1,5,3,6,4};
//        int[] prices = {7,6,4,3,1};
//        int[] prices = {1,2,3,4,5};
        int[] prices = {2,1,2,0,1};
        MaxProfit maxProfit = new MaxProfit();
        System.out.println(maxProfit.maxProfit2(prices));
    }
}
