package com.practice.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortedSeries2 {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> newList = new ArrayList<>();
        for(int[] interval: intervals){
            newList.add(interval);
        }
        if(newList.size()==0){
            newList.add(newInterval);
            return newList.toArray(new int[newList.size()][]);
        }
        Collections.sort(newList, Comparator.comparingInt(a -> a[0]));
        int newIndex = findIndex(newList, newInterval);
        int lastIndex = findUppderIndex(newList, newInterval, newIndex);
        while (lastIndex > newIndex){
            newList.remove(newIndex);
            lastIndex--;
        }
        if(newList.size()> newIndex){
            if(newList.get(newIndex)[0] <= newInterval[1] && newList.get(newIndex)[1] >= newInterval[1]){
                newInterval[1] = Math.max(newList.get(newIndex)[1], newInterval[1]);
                newList.remove(newIndex);
            }
        }else if(newList.get(newIndex-1)[0] <= newInterval[1] && newList.get(newIndex-1)[1] >= newInterval[1]){
            newInterval[1] = Math.max(newList.get(newIndex-1)[1], newInterval[1]);
            newInterval[0] = Math.min(newList.get(newIndex-1)[0], newInterval[0]);
            newList.remove(newIndex-1);
            newIndex--;
        }
        else if(newList.size()> newIndex && newIndex!=0 && newList.get(newIndex-1)[1] >= newInterval[0]){
            newInterval[0] = Math.min(newList.get(newIndex-1)[0], newInterval[0]);
            newIndex--;
            newList.remove(newIndex);
        }
        newList.add(newIndex, newInterval);
        //convert list to array and return
        return newList.toArray(new int[newList.size()][]);
    }

    private int findIndex(List<int[]> newList, int[] newInterval){
        if(newList.get(0)[0] >= newInterval[0])
            return 0;
        if(newList.get(newList.size()-1)[0] <= newInterval[0])
            return newList.size();
        int low = 0;
        int high = newList.size();
        while(low<=high){
            int mid = (low+high)/2;
            if(mid == 0)
                return 0;
            if(newList.get(mid)[0] >= newInterval[0] && newList.get(mid-1)[0] <= newInterval[0]){
                return mid;
            }else if(newList.get(mid)[0] < newInterval[0]){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return low;
    }

    private int findUppderIndex(List<int[]> newList, int[] newInterval, int start){
        int end = newList.size();
        if(newList.size()<=start ||newList.get(start)[0] > newInterval[1])
            return start;
        if(newList.get(end-1)[1] <= newInterval[1])
            return end;
        while (start<= end){
            int mid = (start + end )/2;
            if(! (mid < newList.size()))
                return end;
            if(newList.get(mid)[0] > newInterval[1] && newList.get(mid-1)[0] <= newInterval[1])
                return mid - 1;
            if(newList.get(mid)[0] > newInterval[1])
                end = mid - 1;
            else
                start = mid + 1;
        }
        return start;
    }


    @Test
    public void validate(){
        int[][] input = {{1,3},{4,6},{8,10},{11, 12},{14,19}};
        int[] input2 = {5,11};
        int[][] expected = {{1,3},{4,12},{14,19}};
        int[][] result = insert(input, input2);
        Assert.assertArrayEquals(expected, result);
    }

    @Test
    public void validate2(){
        int[][] input = {{1,5}};
        int[] input2 = {2,3};
        int[][] expected = {{1,5}};
        int[][] result = insert(input, input2);
        Assert.assertArrayEquals(expected, result);
    }
}
