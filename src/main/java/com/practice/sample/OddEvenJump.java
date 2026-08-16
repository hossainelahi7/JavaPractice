package com.practice.sample;
//https://leetcode.com/explore/interview/card/google/67/sql-2/3045/discuss/2033081/Java-O(n-log-n)-solution-using-DP-and-TreeSet-or-with-stdout-for-debugging

import java.util.TreeSet;

public class OddEvenJump {

    static class Node{
        int index;
        int val;
        boolean even;
        boolean odd;
    }

    public int oddEvenJumps(int[] arr) {
        TreeSet<Node> ts=new TreeSet<>((a, b)->
        {
            if(a.val>b.val)
                return 1;
            else{
                if(a.val==b.val && a.index>b.index)
                    return 1;
                else return -1;
            }
        }
        );
        int result=0;
        for(int i=arr.length-1;i>=0;i--){
            if(i==arr.length-1){
                Node n = new Node();
                n.index=i;
                n.val=arr[i];
                n.even=true;
                n.odd=true;
                result++;
                ts.add(n);
            }else{
                Node n = new Node();
                n.index=i;
                n.val=arr[i];
                Node ceil = ts.ceiling(n);
                Node floor = ts.floor(n);
                if(ceil!=null && ceil.val==arr[i])
                    floor=ceil;
                if(ceil!=null && ceil.even){
                    result++;
                    n.odd=true;
                }
                if(floor!=null){
                    Node nt=new Node();
                    nt.val=floor.val-1;
                    nt.index=-1;
                    floor=ts.higher(nt);
                    if(floor.odd)
                        n.even=true;
                }
                ts.add(n);
            }
        }
        return result;
    }

    public static void main(String[] arg){
        OddEvenJump oddEvenJump = new OddEvenJump();
        int[] arr = {10,13,12,14,15};
        System.out.println(oddEvenJump.oddEvenJumps(arr));
    }
}
