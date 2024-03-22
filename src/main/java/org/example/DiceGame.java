package org.example;

import java.util.Random;
import java.util.Scanner;

public class DiceGame {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter the target number of rounds (1-99): ");
    int targetRounds = scanner.nextInt();
    while (targetRounds < 1 || targetRounds > 99) {
      System.out.print("Please enter a number between 1 and 99: ");
      targetRounds = scanner.nextInt();
    }

    playGame(targetRounds);
  }

  public static void playGame(int targetRounds) {
    Random random = new Random();

    int[] playerPoints = new int[3];

    for (int rounds = 1; rounds <= targetRounds; rounds++) {
      int[] diceValues = {random.nextInt(6) + 1, random.nextInt(6) + 1, random.nextInt(6) + 1};
      int samePlayer1 = -1;
      int samePlayer2 = -1;
      int differentPlayer = -1;

      if (diceValues[0] == diceValues[1] && diceValues[0] > diceValues[2]) {
        samePlayer1 = 0 ;
        samePlayer2 = 1;
        differentPlayer = 2;
      }
      else if (diceValues[0] == diceValues[2] && diceValues[0] > diceValues[1]) {
        samePlayer1 = 0 ;
        samePlayer2 = 2;
        differentPlayer = 1;
      }
      else if (diceValues[1] == diceValues[2] && diceValues[1] > diceValues[0]) {
        samePlayer1 = 1 ;
        samePlayer2 = 2;
        differentPlayer = 0;
      }

      for (int i = 0; i < 3; i++) {
        if (i == samePlayer1 || i == samePlayer2) {
          playerPoints[i] += diceValues[i] * 2;
        } else {
          playerPoints[i] += diceValues[i];
        }
      }

      displayRoundResults(rounds, diceValues, playerPoints);
    }

    System.out.println("+----------------------------------------------------------------+");
    System.out.println("Game Over!");
  }

  public static void displayRoundResults(int round, int[] diceValues, int[] playerPoints) {
    System.out.println("+----------------------------------------------------------------+");
    System.out.println("| Round | Dice 1 | Dice 2 | Dice 3 | Total 1 | Total 2 | Total 3 |");
    System.out.println("+----------------------------------------------------------------+");
    System.out.printf("|   %d   |   %1d   |   %2d   |   %2d   |   %3d   |   %3d   |   %4d   |\n", round, diceValues[0], diceValues[1], diceValues[2],
      playerPoints[0], playerPoints[1], playerPoints[2]);
  }
}
