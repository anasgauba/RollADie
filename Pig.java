/**
 * @version date ( in_ISO_8601 format : 2017 - 02 - 02 )
 * @author Muhammad Anas Gauba
 */
// The import statement tells Java that we'll be using the Scanner class.
// Eclipse will offer to put an import line in for you when you use another class.
import java.util.Scanner;
import java.util.Random;

public class Pig {
    /**
     * In this lab, I have created a simple program of pig which rolls a die between 2 players.
     * Whoever reaches 100 points first will be the winner.
     * If a player rolls a 1, all of its points will be lost. 
     * I have also created some variables for keeping track of the player and its scores.
     * Also, some strings to compare the user input value.
     * @param args
     */

    // static final variables are called constants and don't change value
    // We use constants to give names to "magic numbers", messages, etc.
    public static final int TO_WIN = 100;

    public static void main(String[] args) {
        int playerScore = 0; // for turning player score.
        int totalPoint1 = 0; // total score for player 1.
        int totalPoint2 = 0; // total score for player 2.
        int track = 1; // keeping track of the score for both player
        String score = "Score";
        String positiveAnswer = "y";
        String negativeAnswer = "n";
        char answer;
        
                
        // This line creates a Scanner object to read from the console.
        Scanner userInput = new Scanner(System.in);
                
        System.out.println(score + " " + totalPoint1 + "-" + totalPoint2);
        System.out.print("Player 1" + ", " + "It's your turn.");
        
        Random randomNumber = new Random();
        int dieRoll = 0;
        
        //loop for the game between player 1 and player 2.
        while (totalPoint1 < TO_WIN && totalPoint2 < TO_WIN) {
            dieRoll = randomNumber.nextInt(6) + 1;
            System.out.println();
            System.out.println("You rolled a " + dieRoll);
                        
            if (dieRoll == 1) {
                /**
                if (track == 1) {
                    totalPoint1 = 0;
                }
                else {
                    totalPoint2 = 0;                    
                }
                */               
                if (track == 1) {
                    track = 2;
                }
                else {
                    track = 1;
                }
                
                playerScore = 0;
                System.out.println();
                System.out.println(score + " " + totalPoint1 + "-" + totalPoint2);
                System.out.println("Player " + track + ", " + "It's your turn.");
            }
            else {
                playerScore += dieRoll;
                System.out.println("You have " + playerScore + " points.");
                System.out.println("Keep going? " + "(y/n)");
                positiveAnswer = userInput.nextLine();
                answer = positiveAnswer.charAt(0);         
                
                if (answer == 'n') {
                    if (track == 1) {
                        totalPoint1 += playerScore;
                    }
                    else {
                        totalPoint2 += playerScore;
                    }
                    playerScore = 0;
                    
                    if (track == 1) {
                        track = 2;
                    }
                    else {
                        track = 1;
                    }
                    System.out.println(score + " " + totalPoint1 + "-" + totalPoint2); 
                    System.out.println("Player " + track + ", " + "It's your turn.");                        
                } 
            }
    } 
        if (totalPoint1 >= TO_WIN) {
            playerScore = totalPoint1;
            System.out.println("Game Over. Final Score: " + totalPoint1 + "-" + totalPoint2);
            
        }
        else if (totalPoint2 >= TO_WIN) {
            playerScore = totalPoint2;
            System.out.println("Game Over. Final Score: " + totalPoint1 + "-" + totalPoint2);
            
        }
    }      
}
