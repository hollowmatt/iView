package com.blackbelt.brewing.algorithms;
import java.util.*;

/**
 * Created by mholloway on 4/3/17.
 */
public class SimpleSearch {
    int position;
    int attempts;
    long startTime;
    long endTime;
    boolean found = false;

    private void setPosition(int pos) {
        this.position = pos;
    }

    public int getPosition() {
        return this.position;
    }

    private void addAttempt() {
        attempts++;
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

    public void search(List<Integer> list, int item) {
        setPosition(0);
        this.setStartTime(System.nanoTime());
        while (!isFound() || position >= list.size()) {
            this.addAttempt();
            if (list.get(position) == item) {
                this.setEndTime(System.nanoTime());
                found = true;
                this.setPosition(position);
            } else {
                position++;
            }
        }
    }


}
