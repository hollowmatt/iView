import com.blackbelt.brewing.algorithms.*;
import com.blackbelt.brewing.services.FizzBangBoom;
import com.blackbelt.brewing.patterns.*;

import java.lang.reflect.Array;
import java.util.*;

public class Interviews {

    public static void main (String[] args) {
        Interviews iView = new Interviews();
//        iView.startBlock("Search");
//        iView.searchRunner();
//        iView.startBlock("Fizzle");
//        iView.fizzle();
//        iView.startBlock("Singleton");
//        iView.single();
//        int[] arry = {1,2,3,4,5,6,7,8,9,10};
//        iView.forLoop(arry);
//        iView.forEachLoop(arry);
        iView.startBlock("Quick Sort");
        iView.quickSort();
    }

    private void searchRunner() {
        //PART 1: BINARY SEARCH

        // Create a list of 1,000,000 numbers to find a value in
        List<Integer> hayStack = new ArrayList<Integer>();
        for (int value = 1; value < 1000001; value++) {
            hayStack.add(value);
        }

        // number to pass to binary search
        int needle = 1000000;

        BinarySearch bs = new BinarySearch(hayStack.size());
        bs.loopSearch(hayStack, needle);
        System.out.println("*** While Loop ***");
        if (bs.isFound()) {
            System.out.println("Found " + needle + " at position " + bs.getPosition() + " in " + bs.getTime() + " nanoseconds.  It took " + bs.getAttempts() + " tries.");
        } else {
            System.out.println("The value " + needle +  " was not found in the list.");
        }

        BinarySearch bs2 = new BinarySearch(hayStack.size());
        bs2.recursiveSearch(hayStack, needle);

        System.out.println("*** Recursion ***");
        if (bs2.isFound()) {
            System.out.println("Found " + needle + " at position " + bs2.getPosition() + " in " + bs2.getTime() + " nanoseconds.  It took " + bs2.getAttempts() + " tries.");
        } else {
            System.out.println("The value " + needle +  " was not found in the list.");
        }

        SimpleSearch ss = new SimpleSearch();
        ss.search(hayStack, needle);
        System.out.println("*** Simple Search ***");
        if (bs.isFound()) {
            System.out.println("Found " + needle + " at position " + ss.getPosition() + " in " + ss.getTime() + " nanoseconds.  It took " + ss.getAttempts() + " tries.");
        } else {
            System.out.println("The value " + needle +  " was not found in the list.");
        }
    }

    private void selectSort() {
        SelectionSort select = new SelectionSort();
        int[] unsorted = {3, 1, 7, 2, 11, 8, 6, 5, 10, 9, 4, 100, 78, 93, 63, 123, 33, 3124, 1321, 99};
        System.out.print("Unsorted: [");
        for (int i : unsorted) {
            System.out.print(i + " ");
        }
        System.out.println("]");
        int[] sorted = select.sort(unsorted);
        System.out.print("Sorted: [");
        for (int i : sorted) {
            System.out.print(i + " ");
        }
        System.out.println("]");
        System.out.println("Sort of " + unsorted.length + " item array took " + select.getCounter() + " iterations, with a time of " + select.getTimer() + " nanoseconds.");
    }

    private void quickSort() {
        QuickSort qs = new QuickSort();
        int[] unsorted = {3, 1, 7, 2, 11, 8, 6, 5, 10, 9, 4, 100, 78, 93, 63, 123, 33, 3124, 1321, 99};
        System.out.print("Unsorted: [");
        for (int i : unsorted) {
            System.out.print(i + " ");
        }
        System.out.println("]");
        int[] sorted = qs.quickSort(unsorted);
        System.out.print("Sorted: [");
        for (int i : sorted) {
            System.out.print(i + " ");
        }
        System.out.println("]");
        System.out.println("Sort of " + unsorted.length + " item array took " + qs.getAttempts() + " operations, with a time of " + qs.getTimer() + " nanoseconds.");
    }

    private void fizzle() {
        FizzBangBoom fizz = new FizzBangBoom();
        System.out.println("*** Loop ***");
        fizz.loop();
        System.out.println("*** Recurse ***");
        fizz.recurse(0);
    }

    private void single() {
        Singleton ss = Singleton.getInstance();
        System.out.println("Singleton: " + ss.toString());
        Singleton ssTwo = Singleton.getInstance();
        System.out.println("Singleton two: " + ssTwo.toString());
        Singleton third = Singleton.getInstance();
        System.out.println("Singleton three: " + third.toString());
    }

    private void forLoop(int[] data) {
        System.out.println("print out array with for loop");
        for(int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    private void forEachLoop(int[] data) {
        System.out.println("print out array with forEach loop");
        for(int i : data) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    //** LEAVE THIS METHOD AT THE END **
    private void startBlock(String blockName) {
        System.out.println();
        System.out.println("**********");
        System.out.println("Starting: " + blockName);
        System.out.println("**********");
        System.out.println();
    }

}