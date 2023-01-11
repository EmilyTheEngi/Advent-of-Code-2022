package com.emily;

import java.io.BufferedReader;
import java.io.FileReader;


public class RPStourney {
    //Rock =    A,X     = 1 Point
    //Paper =   B,Y     = 2 Points
    //Scissors =C,Z     = 3 Points

    //Losing    X       = 0 Points
    //Draw      Y       = 3 Points
    //Winning   Z       = 6 Points

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
    public static char needForResult(char opponent, char you) {
        //I find what move you need to make to to get your desired outcome
        if(you == 'Y') {//need to draw
            if(opponent == 'A') {
                return 'X';
            } else if (opponent == 'B') {
                return 'Y';
            } else {
                return 'Z';
            }
        } else if (you == 'Z') {//need to win
            if (opponent == 'A') { //If opponent is Rock, Paper is needed to win
                return 'Y';
            } else if (opponent == 'B') { //If opponent is Paper, Scissors is needed to win
                return 'Z';
            } else { //If opponent is Scissors, Rock is needed to win
                return 'X';
            }
        } else {//need to lose
            if (opponent == 'A') { //If opponent is Rock, Scissors is needed to lose
                return 'Z';
            } else if (opponent == 'B') { //If opponent is Paper, Rock is needed to lose
                return 'X';
            } else { //If opponent is Scissors, Paper is needed to lose
                return 'Y';
            }
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
/* Test code
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
 */
    public static void fileInPointsOut() {
        int totalPoints = 0;
        String line = "";
        char myMove, opponentMove;


            try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/input2.txt"));
            
            while (line != null) {
                line = reader.readLine();
                if (line == null) {
                    break;
                }
                opponentMove = line.charAt(0);
                totalPoints += pointCalc(didIWin(opponentMove, line.charAt(2)), line.charAt(2));
            }
            //until end of file
            reader.close();
        } catch (Exception e) {
            System.out.println("Exception"+e);
        }
        System.out.println("Strategy Guide results in: " + totalPoints + " points");
    }

    public static void updatedStratGuide() {
        int totalPoints = 0;
        String line = "";

        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/input2.txt"));
            char yourMove, opponentMove;
            line = reader.readLine();
            while (line != null) {
                opponentMove = line.charAt(0);
                //first I calculate what move I need to make to be in line with the guide
                yourMove = needForResult(opponentMove, line.charAt(2));
                //then I calculate the amount of points I get for that match and add them to the total
                totalPoints += pointCalc(didIWin(opponentMove, yourMove), yourMove);
                //read nextLine
                System.out.println("Opponent: " + opponentMove + " Your Move: " + yourMove);
                line = reader.readLine();
            }
            //until end of file
            reader.close();
        } catch (Exception e) {
            System.out.println("Exception"+e);
        }
        System.out.println("Correct Strategy Guide results in: " + totalPoints + " points");
    }
}
