package com.emily;

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
        if (opponent == you) {
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

        if (win == 1) {
            sum += 6;
        } else if (win == 0) {
            sum += 3;
        } else {
            sum += 0;
        }

        if (move == 'X') {
            sum += 1;
        } else if (move == 'Y') {
            sum += 2;
        } else {
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
}
