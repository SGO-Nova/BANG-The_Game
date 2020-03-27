/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bang;

import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ryanb
 */
public class BANG {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Create character cards, dice, and role cards
        ArrayList<Character_Cards> char_cards = new ArrayList<Character_Cards>();
        char_cards.add(new Character_Cards("Bart Cassidy", 8));
        char_cards.add(new Character_Cards("Black Jack", 8));
        char_cards.add(new Character_Cards("Calamity Janet", 8));
        char_cards.add(new Character_Cards("El Gringo", 7));
        char_cards.add(new Character_Cards("Jesse Jones", 9));
        char_cards.add(new Character_Cards("Joursonnais", 7));
        char_cards.add(new Character_Cards("Kit Carlson", 7));
        char_cards.add(new Character_Cards("Lucky Duke", 8));
        char_cards.add(new Character_Cards("Paul Regret", 9));
        char_cards.add(new Character_Cards("Pedro Ramirez", 8));
        char_cards.add(new Character_Cards("Rose Doolan", 9));
        char_cards.add(new Character_Cards("Sid Ketchum", 8));
        char_cards.add(new Character_Cards("Slab The Killer", 8));
        char_cards.add(new Character_Cards("Suzy Lafayette", 8));
        char_cards.add(new Character_Cards("Vulture Sam", 9));
        char_cards.add(new Character_Cards("Willy The Kid", 8));
        Collections.shuffle(char_cards);
        
        Dice dice1 = new Dice(0);
        Dice dice2 = new Dice(0);
        Dice dice3 = new Dice(0);
        Dice dice4 = new Dice(0);
        Dice dice5 = new Dice(0);
        
        ArrayList<Role_Cards> role_cards = new ArrayList();

        Scanner scan;
        scan = new Scanner(System.in);
        int players;
        Random rand = new Random();
        Player human = new Player("NULL",0,"NULL",false);
        Player ai1 = new Player("NLUL", 0, "NULL", true);
        Player ai2 = new Player("NLUL", 0, "NULL", true);
        Player ai3 = new Player("NLUL", 0, "NULL", true);
        Player ai4 = new Player("NLUL", 0, "NULL", true);
        Player ai5 = new Player("NLUL", 0, "NULL", true);
        Player ai6 = new Player("NLUL", 0, "NULL", true);
        Player ai7 = new Player("NLUL", 0, "NULL", true);

        
        ArrayList<Player> play_order = new ArrayList();
        ArrayList<Player> temp_play_order = new ArrayList();
        /*Test out character hp damage and heal
        System.out.println("Bart has " + character1.hp);
        System.out.println("Black Jack has " + character2.hp);
        System.out.println("Black Jack shot him");
        character1.damage(1);
        System.out.println("Bart now has " + character1.hp);
        System.out.println("Black Jack still has " + character2.hp);
        System.out.println("Black Jack drank beer");
        character2.heal(1);
        System.out.println("Black Jack now has " + character2.hp);
        */
        /* Testing dice rolls
        System.out.println(dice1.roll()+ ", " +dice2.roll()+ ", " +dice3.roll()+ ", " +dice4.roll()+ ", " +dice5.roll());
        System.out.println("Rerolling dice 4 and 5!");
        System.out.println(dice1.keep() + ", " + dice2.keep() + ", " + dice3.keep() + ", " + dice4.roll() + ", " + dice5.roll());
        */
        /*Test out character object;
        Player human = new Player(character5.name, character5.hp, card2.role, false);
        System.out.println("This player's name is: " + human.name + ", has " + human.health +" hp, and is a " + human.role);
        */
        
        do{
            System.out.println("How many people do you want to play against? (2-7 AIs)");
            System.out.print("> ");
            players = scan.nextInt();

            switch(players){
                case 2: 
                    role_cards.add(new Role_Cards("Outlaw"));
                    role_cards.add(new Role_Cards("Deputy"));
                    role_cards.add(new Role_Cards("Renegade"));
                    Collections.shuffle(role_cards);
                    human = new Player(char_cards.get(0).name, char_cards.get(0).hp, role_cards.get(0).role, false);
                    ai1 = new Player(char_cards.get(1).name, char_cards.get(1).hp, role_cards.get(1).role, true);
                    ai2 = new Player(char_cards.get(2).name, char_cards.get(2).hp, role_cards.get(2).role, true);
                    break;
                case 3:
                    role_cards.add(new Role_Cards("Sheriff"));
                    role_cards.add(new Role_Cards("Renegade"));
                    role_cards.add(new Role_Cards("Outlaw"));
                    role_cards.add(new Role_Cards("Outlaw"));
                    Collections.shuffle(role_cards);
                    human = new Player(char_cards.get(0).name, char_cards.get(0).hp, role_cards.get(0).role, false);
                    ai1 = new Player(char_cards.get(1).name, char_cards.get(1).hp, role_cards.get(1).role, true);
                    ai2 = new Player(char_cards.get(2).name, char_cards.get(2).hp, role_cards.get(2).role, true);
                    ai3 = new Player(char_cards.get(3).name, char_cards.get(3).hp, role_cards.get(3).role, true);
                    break;
                case 4:
                    role_cards.add(new Role_Cards("Sheriff"));
                    role_cards.add(new Role_Cards("Renegade"));
                    role_cards.add(new Role_Cards("Outlaw"));
                    role_cards.add(new Role_Cards("Outlaw"));
                    role_cards.add(new Role_Cards("Deputy"));
                    Collections.shuffle(role_cards);
                    human = new Player(char_cards.get(0).name, char_cards.get(0).hp, role_cards.get(0).role, false);
                    ai1 = new Player(char_cards.get(1).name, char_cards.get(1).hp, role_cards.get(1).role, true);
                    ai2 = new Player(char_cards.get(2).name, char_cards.get(2).hp, role_cards.get(2).role, true);
                    ai3 = new Player(char_cards.get(3).name, char_cards.get(3).hp, role_cards.get(3).role, true);
                    ai4 = new Player(char_cards.get(4).name, char_cards.get(4).hp, role_cards.get(4).role, true);
                    break;
                case 5:
                    role_cards.add(new Role_Cards("Sheriff"));
                    role_cards.add(new Role_Cards("Renegade"));
                    role_cards.add(new Role_Cards("Outlaw"));
                    role_cards.add(new Role_Cards("Outlaw"));
                    role_cards.add(new Role_Cards("Deputy"));
                    role_cards.add(new Role_Cards("Outlaw"));
                    Collections.shuffle(role_cards);
                    human = new Player(char_cards.get(0).name, char_cards.get(0).hp, role_cards.get(0).role, false);
                    ai1 = new Player(char_cards.get(1).name, char_cards.get(1).hp, role_cards.get(1).role, true);
                    ai2 = new Player(char_cards.get(2).name, char_cards.get(2).hp, role_cards.get(2).role, true);
                    ai3 = new Player(char_cards.get(3).name, char_cards.get(3).hp, role_cards.get(3).role, true);
                    ai4 = new Player(char_cards.get(4).name, char_cards.get(4).hp, role_cards.get(4).role, true);
                    ai5 = new Player(char_cards.get(5).name, char_cards.get(5).hp, role_cards.get(5).role, true);
                    break;
                case 6:
                    role_cards.add(new Role_Cards("Sheriff"));
                    role_cards.add(new Role_Cards("Renegade"));
                    role_cards.add(new Role_Cards("Outlaw"));
                    role_cards.add(new Role_Cards("Outlaw"));
                    role_cards.add(new Role_Cards("Deputy"));
                    role_cards.add(new Role_Cards("Outlaw"));
                    role_cards.add(new Role_Cards("Deputy"));
                    Collections.shuffle(role_cards);
                    human = new Player(char_cards.get(0).name, char_cards.get(0).hp, role_cards.get(0).role, false);
                    ai1 = new Player(char_cards.get(1).name, char_cards.get(1).hp, role_cards.get(1).role, true);
                    ai2 = new Player(char_cards.get(2).name, char_cards.get(2).hp, role_cards.get(2).role, true);
                    ai3 = new Player(char_cards.get(3).name, char_cards.get(3).hp, role_cards.get(3).role, true);
                    ai4 = new Player(char_cards.get(4).name, char_cards.get(4).hp, role_cards.get(4).role, true);
                    ai5 = new Player(char_cards.get(5).name, char_cards.get(5).hp, role_cards.get(5).role, true);
                    ai6 = new Player(char_cards.get(6).name, char_cards.get(6).hp, role_cards.get(6).role, true);
                    break;
                case 7:
                    role_cards.add(new Role_Cards("Sheriff"));
                    role_cards.add(new Role_Cards("Renegade"));
                    role_cards.add(new Role_Cards("Outlaw"));
                    role_cards.add(new Role_Cards("Outlaw"));
                    role_cards.add(new Role_Cards("Deputy"));
                    role_cards.add(new Role_Cards("Outlaw"));
                    role_cards.add(new Role_Cards("Deputy"));
                    role_cards.add(new Role_Cards("Renegade"));
                    Collections.shuffle(role_cards);
                    human = new Player(char_cards.get(0).name, char_cards.get(0).hp, role_cards.get(0).role, false);
                    ai1 = new Player(char_cards.get(1).name, char_cards.get(1).hp, role_cards.get(1).role, true);
                    ai2 = new Player(char_cards.get(2).name, char_cards.get(2).hp, role_cards.get(2).role, true);
                    ai3 = new Player(char_cards.get(3).name, char_cards.get(3).hp, role_cards.get(3).role, true);
                    ai4 = new Player(char_cards.get(4).name, char_cards.get(4).hp, role_cards.get(4).role, true);
                    ai5 = new Player(char_cards.get(5).name, char_cards.get(5).hp, role_cards.get(5).role, true);
                    ai6 = new Player(char_cards.get(6).name, char_cards.get(6).hp, role_cards.get(6).role, true);
                    ai7 = new Player(char_cards.get(7).name, char_cards.get(7).hp, role_cards.get(7).role, true);
                    break;
                default:
                    System.out.println("Please pick a number between 2 and 7!");
                    break;
            }
        }while(players < 2 || players > 7);
        System.out.println("_________________________________________________________");
        System.out.println("Human is " + human.name + ", has " + human.health + ", and is a " + human.role);
        System.out.println("AI1 is " + ai1.name + ", has " + ai1.health + ", and is a " + ai1.role);
        System.out.println("AI2 is " + ai2.name + ", has " + ai2.health + ", and is a " + ai2.role);
        System.out.println("AI3 is " + ai3.name + ", has " + ai3.health + ", and is a " + ai3.role);
        System.out.println("AI4 is " + ai4.name + ", has " + ai4.health + ", and is a " + ai4.role);
        System.out.println("AI5 is " + ai5.name + ", has " + ai5.health + ", and is a " + ai5.role);
        System.out.println("AI6 is " + ai6.name + ", has " + ai6.health + ", and is a " + ai6.role);
        System.out.println("AI7 is " + ai7.name + ", has " + ai7.health + ", and is a " + ai7.role);
        System.out.println("_________________________________________________________");
        
        temp_play_order.add(human);
        temp_play_order.add(ai1);
        temp_play_order.add(ai2);
        temp_play_order.add(ai3);
        temp_play_order.add(ai4);
        temp_play_order.add(ai5);
        temp_play_order.add(ai6);
        temp_play_order.add(ai7);
        
        int stop = -1;
        boolean sher = false;
        
        for(int i = 0; i < 16; i++){
            if(!(temp_play_order.get(i%8).role.equals("NULL"))){
                if(sher == true){
                    if(i%7 == stop){
                        break;
                    }
                    else{
                        play_order.add(temp_play_order.get(i%8));
                    }
                }
                if(sher == false){
                  if(temp_play_order.get(i%8).role.equals("Sheriff")){
                    play_order.add(temp_play_order.get(i%8));
                    stop = i;
                    sher = true;
                    }  
                }
                
            }
        }
        System.out.println("The play order is: ");
        for(int j = 0; j < play_order.size(); j++){
            System.out.println((j+1) + ") " + play_order.get(j).name);
        }
        
        
    }
    
}
