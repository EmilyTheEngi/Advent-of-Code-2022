package com.emily;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

/*
 * Advent of Code 2022
 * Emily's submission
 * 
 */

public class FileIn {

    public static void elves() {
        System.out.println("The most any elf is carrying is: "+ biggestInFile());
        int[] largest = nLargestNums(3);
        System.out.println("The 3 elves carrying the most are carrying: "+ Arrays.toString(largest));
        System.out.println("They are in total carrying: " + sumOfAll(largest));
    }

    public static int biggestInFile() {
        int largest = 0, count = 0, currentNum = 0;
        //read file
        try{
            BufferedReader reader = new BufferedReader(new FileReader("src/main/java/com/emily/input.txt"));
            boolean prevNull = false;
            //sum each group of integers in the file and compare to largest
            while (true) {
                //perline logic
                try {
                    currentNum = Integer.parseInt(reader.readLine());
                } catch (Exception e) {
                    currentNum = 0;
                }
                
                //end of counted logic 
                if (currentNum == 0) {
                    //checks for end of file
                    if (prevNull) {
                        break;
                    }
                    
                    if (count > largest) {
                        largest = count;
                    }
                    //resets count, preps prevNull for next iteration
                    count = 0;
                    prevNull = true;
                } else {
                    prevNull = false;
                }

                //per line logic
                count += currentNum;
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Exception"+e);
        }
        
        System.out.println(largest);
        return largest;
    }


    public static int[] nLargestNums(int n) {
        int[] largest = new int[n];
        //[0] is largest, [1] is 2nd largest, etc
        int count = 0, currentNum = 0;
        boolean prevNull = false;

        try{
            BufferedReader reader = new BufferedReader(new FileReader("src/main/java/com/emily/input.txt"));
            
            //main loop
            while (true) {
                //perline str to int
                try {
                    currentNum = Integer.parseInt(reader.readLine());
                } catch (Exception e) {
                    //just so happens to run at end of counted
                    currentNum = 0;
                    //checks for end of file
                    if (prevNull) {
                        break;
                    }
                    
                    //checks if current count is larger than any in largest[]
                    for (int i = 0; i < n; i++) {
                        if (count > largest[i]) {
                            //shifts all larger values down
                            for (int j = n-1; j > i; j--) {
                                largest[j] = largest[j-1];
                            }
                            //inserts current count
                            largest[i] = count;
                            break;
                        }
                    }

                    //resets count, preps prevNull for next iteration
                    count = 0;
                    prevNull = true;
                }
                //else replacement
                if (currentNum != 0) {
                    prevNull = false;
                }


                //per line logic
                count += currentNum;
            }


            reader.close();
        } catch (Exception e) {
            System.out.println("Exception"+e);
        }
        return largest;
    }
    public static int sumOfAll(int[] addMe) {
        int sum = 0;
        for (int i = 0; i < addMe.length; i++) {
            sum += addMe[i];
        }
        return sum;
    }
}
