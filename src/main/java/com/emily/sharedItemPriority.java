package com.emily;

import java.io.BufferedReader;
import java.io.FileReader;

public class sharedItemPriority {
    public static void process() {
        int sum = 0;
        String bag1, bag2 = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/input3.txt"));
            // loop line by line, split each line in half, look for repeating values between
            // halves and add their priorities
            while (true) {
                // perline logic
                try {
                    bag1 = reader.readLine();
                    bag2 = bag1.substring(bag1.length() / 2);
                    bag1 = bag1.substring(0, bag1.length() / 2);
                } catch (Exception e) {
                    break;
                }

                // end of counted logic
                if (bag1 == null || bag2 == null) {
                    break;
                }
                // per line logic
                for (int i = 0; i < bag1.length(); i++) {
                    if (bag2.indexOf(bag1.charAt(i)) != -1) {
                        sum += asciiToElf(bag1.charAt(i));
                        bag2 = bag2.replace(bag1.charAt(i), ' ');
                    }
                }
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Exception" + e);
        }
        System.out.println("The sum of the values of misplaced presents in Santa's sack are: " + sum);
    }

    /*
     * Converts ascii characters to elf priorities.
     * Lowercase item types a through z have priorities 1 through 26.
     * 
     * Uppercase item types A through Z have priorities 27 through 52.
     */
    public static int asciiToElf(char elf) {
        if (elf <= 'z' && elf >= 'a') {
            return elf - 'a' + 1;
        } else {
            return elf - 'A' + 27;
        }
    }
}
