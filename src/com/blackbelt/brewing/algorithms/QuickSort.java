package com.blackbelt.brewing.algorithms;

/**
 * Created by mholloway on 4/3/17.
 * Big O: O(n log n)
 */
public class QuickSort {
    long startTime;
    long endTime;
    int attempts;


    private void setStartTime(long time){
        this.startTime = time;
    }

    private void setEndTime(long time) {
        this.endTime = time;
    }

    public long getTimer() {
        return this.endTime - this.startTime;
    }

    private void addAttempt() {
        this.attempts++;
    }

    public int getAttempts() {
        return this.attempts;
    }

    public int[] quickSort(int[] unsorted) {
        this.setStartTime(System.nanoTime());
        int[] sorted = quick(unsorted, 0, unsorted.length - 1);
        this.setEndTime(System.nanoTime());
        return sorted;
    }

    private int[] quick(int[] unsorted, int low, int high) {
        //no need to sort
        if (unsorted.length < 2) {
            return unsorted;
        } else {
            int pivot = unsorted[(low + high)/2];

            int i = low, j = high;
            int temp;

            /** partition **/
            while (i <= j)
            {
                addAttempt();
                while (unsorted[i] < pivot) {
                    i++;
                    addAttempt();
                }
                while (unsorted[j] > pivot) {
                    j--;
                    addAttempt();
                }

                if (i <= j)
                {
                    /** swap **/
                    temp = unsorted[i];
                    unsorted[i] = unsorted[j];
                    unsorted[j] = temp;

                    i++;
                    j--;
                }
            }

            /** recursively sort lower half **/
            if (low < j) {
                quick(unsorted, low, j);
            }
            /** recursively sort upper half **/
            if (i < high) {
                quick(unsorted, i, high);
            }

        }
        return unsorted;
    }
}
