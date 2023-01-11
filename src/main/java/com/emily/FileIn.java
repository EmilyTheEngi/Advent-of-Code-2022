package com.emily;

import java.io.BufferedReader;
import java.io.FileReader;

/*
 * Advent of Code 2022
 * Emily's submission
 * 
 */

public class FileIn {

    public static void elfs() {
        System.out.println("The most any elf is carrying is: "+ biggestInFile());
        System.out.println("The 2nd largest is: "+ ndLargest(2));
        System.out.println("The 3rd largest is: "+ ndLargest(3));
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


    public static int ndLargest(int n) {
        return 0;
    }
}
