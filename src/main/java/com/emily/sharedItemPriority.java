package com.emily;

public class sharedItemPriority {
    //Reads the file line by line using a bufferedReader for processing
    public static void read() {
        System.out.println("I read");
    }
    //I split each line into two compartments for comparison
    public static void compare() {
        System.out.println("I compare");
    }

    //I sum the priorities of the items that are shared between the two compartments in each sack (line)
    public static void sumOfPriorities() {
        System.out.println("I sum");
    }

    /*
     * Converts ascii characters to elf priorities.
     * Lowercase item types a through z have priorities 1 through 26.
     * 
     * Uppercase item types A through Z have priorities 27 through 52.
     */
    public static int asciiToElf(char elf) {
        if (elf <= 'z' && elf >= 'a'){
            return elf - 'a' + 1;
        } else {
            return elf - 'A' + 27;
        }
    }
}
