package com.emily;

import java.io.BufferedReader;
import java.io.FileReader;


public class RPStourney {
    //Rock =    A,X     = 1 Point
    //Paper =   B,Y     = 2 Points
    //Scissors =C,Z     = 3 Points

    //Losing            = 0 Points
    //Draw              = 3 Points
    //Winning           = 6 Points

    //truth table function
    public static int didIWin(char opponent, char you) {
        //1 = victory, 0 = draw, -1 = loss
        if ((opponent == 'A' && you == 'X') || (opponent == 'B' && you == 'Y') || (opponent == 'C' && you == 'Z')) {
            return 0;
        }
        
        if ((opponent == 'A' && you == 'Y') || (opponent == 'B' && you == 'Z') || (opponent == 'C' && you == 'X')) {
            return 1;
        } else {
            return -1;
        }
    }

    //point calculator
    public static int pointCalc(int win, char move) {
        int sum= 0;

        if (win == 1) {//win
            sum += 6;
        } else if (win == 0) {//draw
            sum += 3;
        } else { //loss
            sum += 0;
        }

        if (move == 'X') {//Rock
            sum += 1;
        } else if (move == 'Y') {//Paper
            sum += 2;
        } else {//Scissors
            sum += 3;
        }
        return sum;
    }

    public static void exeStratGuide() {
        char[][] stratGuide = {
            {'A','Y'},
            {'B','X'},
            {'C','Z'}
        };
        int totalPoints = 0;
        for (int i = 0; i < stratGuide.length; i++) {
            totalPoints += pointCalc(didIWin(stratGuide[i][0], stratGuide[i][1]), stratGuide[i][1]);
        }
        System.out.println("Strategy Guide results in: " + totalPoints + " points");
    }

    public static void fileInPointsOut() {
        int totalPoints = 0;
        String line = "";

            try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/input2.txt"));
            
            while (line != null) {
                line = reader.readLine();
                if (line == null) {
                    break;
                }
                totalPoints += pointCalc(didIWin(line.charAt(0), line.charAt(2)), line.charAt(2));
            }
            //until end of file
            reader.close();
        } catch (Exception e) {
            System.out.println("Exception"+e);
        }
        System.out.println("Strategy Guide results in: " + totalPoints + " points");
    }
}
