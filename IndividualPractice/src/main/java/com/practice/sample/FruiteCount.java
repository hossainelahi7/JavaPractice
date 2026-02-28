package com.practice.sample;

public class FruiteCount {
    public int totalFruit(int[] fruits) {
        int a= -1,b = -1;
        int highestCount = 0;
        int loopCount = 0;
        int bIndex = 0;
        int j = 0;
        for(int i = 0; i < fruits.length; i++){
            for(j = i; j <fruits.length; j++){
                if(a<0){
                    a = fruits[j];
                    loopCount++;
                    continue;
                }
                else if(b<0 && fruits[j]!= a){
                    b = fruits[j];
                    loopCount++;
                    bIndex = j;
                    continue;
                }
                else if(fruits[j]==a){
                    loopCount++;
                    continue;
                }else if(fruits[j]==b){
                    loopCount++;
                    continue;
                }else{
                    if(loopCount>highestCount)
                        highestCount = loopCount;
                    a = -1;
                    b= -1;
                    loopCount = 0;
                    i = bIndex-1;
                    break;
                }
            }
            if(j== fruits.length)
                i = j;
        }
        return highestCount>loopCount? highestCount:loopCount;
    }

    public static void main(String[] arg){
        FruiteCount fruiteCount = new FruiteCount();
        int[] fruits = {1,2,3,2,2};
        System.out.println(fruiteCount.totalFruit(fruits));
    }
}
