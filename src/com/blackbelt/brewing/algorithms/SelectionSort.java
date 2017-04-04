package com.blackbelt.brewing.algorithms;
import java.util.*;

/**
 * Created by mholloway on 3/30/17.
 * Big O: O(n2)
 */
public class SelectionSort {

    int counter;
    long timer;

    public int getCounter() {
        return this.counter;
    }

    public long getTimer() {
        return this.timer;
    }

    public int[] sort(int[] uList) {
        long startTime = System.nanoTime();
        int min;
        for(int i = 0; i < uList.length; i++) {
            min = i;
            for (int j = i + 1; j < uList.length; j++) {
                if(uList[j] < uList[min]) { min = j; }
                this.counter++;
            }
            int temp = uList[i];
            uList[i] = uList[min];
            uList[min] = temp;
        }
        long stopTime = System.nanoTime();
        this.timer = stopTime - startTime;
        return uList;
    }

}
