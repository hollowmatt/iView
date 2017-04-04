package com.blackbelt.brewing.services;

/**
 * Created by mholloway on 4/2/17.
 */
public class FizzBangBoom {

    public void loop() {
        for (int count = 0; count < 10; count ++) {
            if (count > 0) {
                System.out.print(", ");
            }
            System.out.print(count);
        }
        System.out.println("  - Fizz - Bang - BOOM!");
    }

    public void recurse(int count) {
        if (count < 10) {
            if (count > 0) {
                System.out.print(", ");
            }
            System.out.print(count);
            count++;
            recurse(count);
        } else {
            System.out.println("  - Fizz - Bang - BOOM!");
        }
    }
}

