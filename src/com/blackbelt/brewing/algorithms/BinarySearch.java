package com.blackbelt.brewing.algorithms;
import java.util.*;

/**
 * Created by mholloway on 3/30/17.
 * Big O: O(log n)
 */
public class BinarySearch {
    int low;
    int high;
    int mid;
    int position;
    int attempts;
    long startTime;
    long endTime;
    boolean found = false;

    public BinarySearch(int size) {
        this.high = size - 1;
        this.attempts = 0;
        this.low = 0;
    }

    //getters + setters: some private
    private void setPosition(int pos) {
        this.position = pos;
    }

    public int getPosition() {
        return this.position;
    }

    private void addAttempt() {
        this.attempts++;
    }

    public int getAttempts() {
        return this.attempts;
    }

    private void setStartTime(long time) {
        this.startTime = time;
    }

    private void setEndTime(long time) {
        this.endTime = time;
    }

    public long getTime() {
        return this.endTime - this.startTime;
    }

    public boolean isFound() {
        return found;
    }

    //Typical loop based search construct
    public void loopSearch(List<Integer> list, int item) {
        this.setStartTime(System.nanoTime());
        while (low <= high) {
            mid = (low + high) / 2;
            this.addAttempt();
            if (list.get(mid) == item) {
                this.setEndTime(System.nanoTime());
                found = true;
                this.setPosition(mid);
                low = high + 1;
            } else if (list.get(mid) > item) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
    }

    //Recursive version of search
    public void recursiveSearch(List<Integer> list, int item) {
        if (startTime == 0L) {
            this.setStartTime(System.nanoTime());
        }
        if (low <= high) {
            mid = (low + high) / 2;
            this.addAttempt();
            //if we are on the item
            if (list.get(mid) == item) {
                found = true;
                this.setPosition(mid);
                this.setEndTime(System.nanoTime());
            } else if (list.get(mid) > item) {
                high = mid - 1;
                recursiveSearch(list, item);
            } else {
                low = mid + 1;
                recursiveSearch(list, item);
            }
        }
    }

}
