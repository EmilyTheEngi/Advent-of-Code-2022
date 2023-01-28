package com.emily;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class Contains {

    public static void cry() {
        int sum = 0;
        int[] nums = new int[4];
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/input4.txt"));
            while (true) {
                nums = Stream.of(reader.readLine().split("[,-]", 4)).mapToInt(Integer::parseInt).toArray();
                if ((nums[0] <= nums[2] && nums[1] >= nums[3]) || (nums[0] >= nums[2] && nums[1] <= nums[3])) {
                    sum++;
                }
            }
        } catch (Exception e) {
            // System.out.println("Exception" + e);
        }
        System.out.println("Time Wasted within pairs with total overlap: "+sum);
    }

    public static void flags() {
        //Regular Array Solution
        int[] nums = new int[4];
        int overlapping = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/input4.txt"));
            while (true) {
                nums = Stream.of(reader.readLine().split("[,-]", 4)).mapToInt(Integer::parseInt).toArray();
                if (nums[0] <= nums[2] && nums[1] >= nums[2] || nums[0] >= nums[2] && nums[0] <= nums[3]) {
                    overlapping++;
                }
            }
        } catch (Exception e) {
            // System.out.println("Exception" + e);
        }
        System.out.println("Time wasted in total with partial overlap: " + overlapping);
    }
}
