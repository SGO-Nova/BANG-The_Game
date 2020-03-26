/* CS 2365 OOP Spring 2020
Mihir Patel 
 */
 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example_dice;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author Mihir
 */
public class Game {

    int[] dice;
    Scanner Scn;
    Random randGen;
    int num_players;
    ArrayList<String> players = new ArrayList(); // to store the players name
    //ArrayList<String> sum = new ArrayList();

    Game() {
        dice = new int[5]; // 5 dice in Array
        Scn = new Scanner(System.in);
        randGen = new Random();

    }

    public void displayDice() {

        do {
            System.out.println("Welcome to the BANG: Dice Game ");
            System.out.println("How many players? (2 to 7):"); //Ask user how many players.
            num_players = Scn.nextInt();
        } while (num_players < 2 || num_players > 7);

        /* Creates a loop that prompts the players for their names and than
        add those names to the appropriate Arraylist. 
         */
        for (int i = 0; i < num_players; i++) {
            System.out.println("Enter Player " + (i + 1) + " 's name:"); //Asking player name.
            players.add(Scn.next()); // adding to postion to index 0 1...

        }
        for (int j = 0; j < players.size(); j++) {
            String name = players.get(j);
            char c;

            System.out.println(name + ", it's ur turn.");
            System.out.println();
            System.out.println("Rolling the dice");
            System.out.println("Number of Dice \tDiceValue");
            for (int i = 0; i < dice.length; i++) {
                dice[i] = randGen.nextInt(6) + 1;
                System.out.println(i + "\t\t" + dice[i]);

            }
            reRoll();// once the dice is roll it's reRoll if user decide to reroll the dice 
            System.out.println("Number of Dice \tDiceValue"); // this will dislay the dice of the value for all 5 die after reRoll 
            for (int i = 0; i < dice.length; i++) {

                System.out.println(i + "\t\t" + dice[i]);

            }
            reRoll(); // Same here if user decide to reRoll the dice.
            System.out.println("Number of Dice \tDiceValue");  // this will dislay the dice of the value for all 5 die reRoll.
            for (int i = 0; i < dice.length; i++) {

                System.out.println(i + "\t\t" + dice[i]);
            }

            //c = Scn.next().charAt(0);
            //if(c =='r' || c == 'R'){
            // System.out.println(c + " is equal to " + c);
            //}
            //else{
            //System.out.println(c + " is not equal to 'r' or 'R' " );
            //}
            //System.out.println("Number of players "  +  num_players);
            //System.out.println("Number of Dice \tDiceValue");
            //for (int i = 0; i < dice.length; i++) {
            //dice[i] = randGen.nextInt(6) + 1;
            // System.out.println(i + "\t\t" + dice[i]);
            //}
        }

    }

    public void playGame() {

        if (dice.length == 1) {
            System.out.println("Bull's eye");
        }
        displayDice();
        reRoll();
        System.out.println("Final rolls are : ");
        System.out.println("Number of Dice \tDiceValue");

        for (int i = 0; i < dice.length; i++) {

            System.out.println(i + "\t\t" + dice[i]);
        }

        System.out.println("Do you want to play again? (y/n) "); //" + i + " which is a (whose value is) " + dice[i] + " (y/n)?");
        String answer = Scn.next();
        if (answer.equalsIgnoreCase("y")) {
            displayDice();
        } else if (answer.equalsIgnoreCase("n")) {
            System.out.println("Bye bye! ");

        }

    }

    public void reRoll() {
// re-rolling
        String answer;
        int i;
        for (i = 0; i < dice.length; i++) {
            System.out.println("Re-roll die " + i + " which is a (whose value is) " + dice[i] + " (y/n)?");
            answer = Scn.next();

            if (answer.equalsIgnoreCase("y")) {
                System.out.println("REROLLING THIS DIE!!!");
                dice[i] = randGen.nextInt(6) + 1;

            }
        }
    }
}
