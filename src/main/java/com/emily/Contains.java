package com.emily;

import java.io.BufferedReader;
import java.io.FileReader;
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
        System.out.println(sum);
    }

    public static void flags() {
        int overlapping = 0;

    }
}
