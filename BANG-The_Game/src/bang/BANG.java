//Ryan Browning
//CS 2365
//Project 3
//main function authors: Ryan Browning
package bang;

import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BANG {

    static int arrow = 10;
    static boolean chiefArrow = true;
    static Scanner scan;

    public static void main(String[] args) {
        System.out.println("How many players: ");
        int players = 0;
        scan = new Scanner(System.in);

        do {
            try {
                players = scan.nextInt();
            } catch (Exception a) {
                System.out.println("Please give a number");
            }
        } while (players < 4 || players > 8);

        players--;

        //Create character cards, dice, and role cards
        ArrayList<Character_Cards> char_cards = new ArrayList();
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
        char_cards.add(new Character_Cards("Belle Star", 8));
        char_cards.add(new Character_Cards("Greg Digger", 7));
        Collections.shuffle(char_cards);

        ArrayList<Dice> dice = new ArrayList();
        Dice d1 = new Dice(2, 0, "Indian Arrow", "Dynamite", "Duel", "Duel", "Whiskey", "Gatling");//LOOK AT ME DICE
        Dice d2 = new Dice(2, 0, "Indian Arrow", "Dynamite", "Duel", "Duel", "Whiskey", "Gatling");//LOOK AT ME DICE
        Dice d3 = new Dice(0, 0, "Indian Arrow", "Dynamite", "Bull's Eye 1", "Bull's Eye 2", "Beer", "Gatling");
        Dice d4 = new Dice(0, 0, "Indian Arrow", "Dynamite", "Bull's Eye 1", "Bull's Eye 2", "Beer", "Gatling");
        Dice d5 = new Dice(0, 0, "Indian Arrow", "Dynamite", "Bull's Eye 1", "Bull's Eye 2", "Beer", "Gatling");
        dice.add(d1);
        dice.add(d2);
        dice.add(d3);
        dice.add(d4);
        dice.add(d5);

        ArrayList<Role_Cards> role_cards = new ArrayList();

        scan = new Scanner(System.in);
        boolean test = false;
        Random rand = new Random();
        Player human = new Player("NULL", 0, "NULL", false);
        Player ai1 = new Player("NULL", 0, "NULL", true);
        Player ai2 = new Player("NULL", 0, "NULL", true);
        Player ai3 = new Player("NULL", 0, "NULL", true);
        Player ai4 = new Player("NULL", 0, "NULL", true);
        Player ai5 = new Player("NULL", 0, "NULL", true);
        Player ai6 = new Player("NULL", 0, "NULL", true);
        Player ai7 = new Player("NULL", 0, "NULL", true);

        ArrayList<Player> play_order = new ArrayList();
        ArrayList<Player> temp_play_order = new ArrayList();

        switch (players) {
            case 7:
                role_cards.add(new Role_Cards("Renegade"));
            case 6:
                role_cards.add(new Role_Cards("Deputy"));
            case 5:
                role_cards.add(new Role_Cards("Outlaw"));
            case 4:
                role_cards.add(new Role_Cards("Deputy"));
            case 3:
                role_cards.add(new Role_Cards("Sheriff"));
                role_cards.add(new Role_Cards("Renegade"));
                role_cards.add(new Role_Cards("Outlaw"));
                role_cards.add(new Role_Cards("Outlaw"));
                Collections.shuffle(role_cards);
        }
        switch (players) {
            case 7:
                ai7 = new Player(char_cards.get(7).name, char_cards.get(7).hp, role_cards.get(7).role, true);
            case 6:
                ai6 = new Player(char_cards.get(6).name, char_cards.get(6).hp, role_cards.get(6).role, true);
            case 5:
                ai5 = new Player(char_cards.get(5).name, char_cards.get(5).hp, role_cards.get(5).role, true);
            case 4:
                ai4 = new Player(char_cards.get(4).name, char_cards.get(4).hp, role_cards.get(4).role, true);
            case 3:
                human = new Player(char_cards.get(0).name, char_cards.get(0).hp, role_cards.get(0).role, true); //MAKE THIS TRUE TO LET AI DO ALL THE PLAYING
                ai1 = new Player(char_cards.get(1).name, char_cards.get(1).hp, role_cards.get(1).role, true);
                ai2 = new Player(char_cards.get(2).name, char_cards.get(2).hp, role_cards.get(2).role, true);
                ai3 = new Player(char_cards.get(3).name, char_cards.get(3).hp, role_cards.get(3).role, true);
        }

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

        if (players != 2) {
            for (int i = 0; i < 16; i++) {
                if (!(temp_play_order.get(i % 8).role.equals("NULL"))) {
                    if (sher == true) {
                        if (i % 8 == stop) {
                            break;
                        } else {
                            play_order.add(temp_play_order.get(i % 8));
                        }
                    }
                    if (sher == false) {
                        if (temp_play_order.get(i % 8).role.equals("Sheriff")) {
                            temp_play_order.get(i % 8).heal(2);
                            temp_play_order.get(i % 8).shown = true;
                            play_order.add(temp_play_order.get(i % 8));
                            stop = i;
                            sher = true;
                        }
                    }

                }
            }
        } else {
            for (int i = 0; i < 16; i++) {
                if (!(temp_play_order.get(i % 8).role.equals("NULL"))) {
                    if (sher == true) {
                        if (i % 8 == stop) {
                            break;
                        } else {
                            temp_play_order.get(i % 8).shown = true;
                            play_order.add(temp_play_order.get(i % 8));
                        }
                    }
                    if (sher == false) {
                        if (temp_play_order.get(i % 8).role.equals("Deputy")) {
                            temp_play_order.get(i % 8).shown = true;
                            play_order.add(temp_play_order.get(i % 8));
                            stop = i;
                            sher = true;
                        }
                    }

                }
            }
        }
        System.out.println("The play order is: ");
        for (int j = 0; j < play_order.size(); j++) {
            System.out.println((j + 1) + ") " + play_order.get(j).name);
        }
        System.out.println("_________________________________________________________");

        boolean reroll;
        ArrayList<Integer> list = new ArrayList();

        int total_players = play_order.size();

        try {
            System.out.println("LET'S PLAY!!!");
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        while (true) {
            int Gat = 0;
            int BE1 = 0;
            int BE2 = 0;
            int DBE1 = 0;
            int DBE2 = 0;
            int duel = 0;
            int total = 0;
            int Beer = 0;
            int dynamite = 0;
            boolean gringo = false;
            boolean gatAttack = false;
            Player left1 = play_order.get(1);
            Player right1 = play_order.get(play_order.size() - 1);
            Player left2;
            Player right2;
            Player left3;
            Player right3;
            try {
                left2 = play_order.get(2);
            } catch (Exception a) {
                left2 = play_order.get(0);
            }
            try {
                left3 = play_order.get(3);
            } catch (Exception a) {
                left3 = play_order.get(0);
            }
            try {
                right2 = play_order.get(play_order.size() - 2);
            } catch (Exception a) {
                right2 = play_order.get(0);
            }
            try {
                right3 = play_order.get(play_order.size() - 3);
            } catch (Exception a) {
                right3 = play_order.get(0);
            }

            System.out.println("_________________________________________________________");
            for (int i = 0; i < total_players; i++) {
                System.out.println(temp_play_order.get(i).name + ": ");
                System.out.print("\tHealth: " + temp_play_order.get(i).health + ", Triple: " + temp_play_order.get(i).t_bul + ", Single: " + temp_play_order.get(i).s_bul + ", Arrows: " + temp_play_order.get(i).arrows + ", Shown: " + temp_play_order.get(i).shown);
                if (temp_play_order.get(i).shown == true) {
                    System.out.println(" Role: " + temp_play_order.get(i).role);
                } else {
                    System.out.println("");
                }
            }
            System.out.println("Arrows in the middle: " + arrow);
            System.out.print("Chief arrow: ");
            if (chiefArrow == true) {
                System.out.println("Middle");
            } else {
                for (int i = 0; i < play_order.size(); i++) {
                    if (play_order.get(i).chiefArrow) {
                        System.out.println(play_order.get(i).name);
                        break;
                    }
                }
            }

            System.out.println("_________________________________________________________");
            String answer;
            System.out.println(play_order.get(0).name + ", It is your turn!");
            list.clear();
            if (play_order.get(0).name.equals("Sid Ketchum")) {
                System.out.println("Choose who you want to gain a health point: ");
                for (int i = 0; i < play_order.size(); i++) {
                    System.out.println((i + 1) + ") " + play_order.get(i).name);
                    list.add(i + 1);
                }
                System.out.print("> ");
                do {
                    try {
                        if (play_order.get(0).computer == true) {
                            Random random = new Random();
                            players = (random.nextInt(10000000) % list.size());
                            players = list.get(players);
                            System.out.println(players);
                        } else {
                            players = scan.nextInt();
                        }
                        test = true;
                    } catch (Exception a) {
                        System.out.println("Please give a number");
                    }
                } while (!test);
                play_order.get(players - 1).heal(1);
                System.out.println("Sid healed: " + play_order.get(players - 1).name);
            }

            test = false;
            System.out.println("Do you want to change out one of your dice for the COWARD die or LOUDMOUTH die?");
            System.out.print("> ");
            answer = "n";
            do {
                try {
                    if (play_order.get(0).computer == true) {
                        Random random = new Random();
                        int random_int = (random.nextInt(10000000) % 2);
                        if (random_int == 1) {
                            answer = "y";
                        }
                        System.out.println(answer);
                    } else {
                        answer = scan.next();
                    }
                    test = true;
                } catch (Exception a) {
                    System.out.println("Please give a y or n");
                }
            } while (!test);
            if (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes")) {
                test = false;
                System.out.println("Do you want to change out one of your dice for the COWARD die?");
                System.out.print("> ");
                answer = "n";
                do {
                    try {
                        if (play_order.get(0).computer == true) {
                            Random random = new Random();
                            int random_int = (random.nextInt(10000000) % 2);
                            if (random_int == 1) {
                                answer = "y";
                            }
                            System.out.println(answer);
                        } else {
                            answer = scan.next();
                        }
                        test = true;
                    } catch (Exception a) {
                        System.out.println("Please give a y or n");
                    }
                } while (!test);
                if (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes")) {
                    dice.remove(d5);
                    d5 = new Dice(1, 0, "Broken Indian Arrow", "Dynamite", "Bull's Eye 1", "Indian Arrow", "Double Beer", "Beer"); //COWARD
                    dice.add(d5);
                } else {
                    dice.remove(d5);
                    d5 = new Dice(1, 0, "Indian Arrow", "Dynamite", "Double Bull's Eye 1", "Double Bull's Eye 2", "Bullet", "Double Gatling"); //LOUDMOUTH
                    dice.add(d5);
                }
            } else {
                dice.remove(d5);
                d5 = new Dice(0, 0, "Indian Arrow", "Dynamite", "Bull's Eye 1", "Bull's Eye 2", "Beer", "Gatling");
                dice.add(d5);
            }

            for (int roll = 0; roll < 5; roll++) {
                dice.get(roll).roll();
            }

            for (int rolls = 0; rolls < play_order.get(0).rolls - 1; rolls++) {
                dynamite = 0;
                reroll = false;
                System.out.println("Roll " + (rolls + 1) + " results:");
                System.out.println("Dice 1 : " + d1.sides[d1.side]);
                System.out.println("Dice 2 : " + d2.sides[d2.side]);
                System.out.println("Dice 3 : " + d3.sides[d3.side]);
                System.out.println("Dice 4 : " + d4.sides[d4.side]);
                System.out.println("Dice 5 : " + d5.sides[d5.side]);
                for (int i = 0; i < 5; i++) {
                    if (dice.get(i).sides[dice.get(i).side].equals("Dynamite")) {
                        dynamite++;
                    }
                    if (dice.get(i).sides[dice.get(i).side].equals("Indian Arrow")) {
                        arrowTakeAction(play_order, 0);
                        play_order.get(0).addArrow(1);
                        if (arrow == 0) {
                            indianAttack(play_order);
                        }
                    }
                    if (dice.get(i).sides[dice.get(i).side].equals("Broken Indian Arrow")) {
                        play_order.get(0).removeArrow(1);
                    }
                    if (dice.get(i).sides[dice.get(i).side].equals("Bullet")) {
                        play_order.get(0).damage(1);
                    }
                }
                for (int roll = 0; roll < 5; roll++) {
                    if (dynamite >= 3) {
                        break;
                    }
                    if (dice.get(roll).sides[dice.get(roll).side].equals("Dynamite") && play_order.get(0).name.equals("Belle Star")) {
                        System.out.println("Do you want to change dice" + (roll + 1) + " to a gatling gun? (y/n)");
                        answer = "n";
                        if (play_order.get(0).computer == true) {
                            Random random = new Random();
                            int random_int = (random.nextInt(10000000) % 2);
                            if (random_int == 1) {
                                answer = "y";
                            }
                            System.out.println(answer);
                        } else {
                            answer = scan.next();
                        }
                        if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y")) {
                            for (int i = 0; i < 6; i++) {
                                dice.get(roll).side = i;
                                if (dice.get(roll).sides[dice.get(roll).side].equals("Gatling") || dice.get(roll).sides[dice.get(roll).side].equals("Double Gatling")) {
                                    break;
                                }
                            }
                        }
                    } else if (!(dice.get(roll).sides[dice.get(roll).side].equals("Dynamite")) || play_order.get(0).dynamiteReroll == true) {
                        System.out.println("Do you want to reroll dice " + (roll + 1) + "? (y/n)");
                        answer = "n";
                        if (play_order.get(0).computer == true) {
                            Random random = new Random();
                            int random_int = (random.nextInt(10000000) % 2);
                            if (random_int == 1) {
                                answer = "y";
                            }
                            System.out.println(answer);
                        } else {
                            answer = scan.next();
                        }
                        if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y")) {
                            reroll = true;
                            dice.get(roll).roll();
                        }
                    } else {
                        //Testing purposes
                        System.out.println((roll + 1) + ") " + dice.get(roll).sides[dice.get(roll).side]);
                    }

                }
                if (reroll == false) {
                    break;
                }
            }

            System.out.println("Final results: ");
            for (int count = 0; count < 5; count++) {
                System.out.println("Dice " + (count + 1) + ": " + dice.get(count).sides[dice.get(count).side]);
                if (dice.get(count).sides[dice.get(count).side].equals("Double Gat")) {
                    Gat += 2;
                    if (Gat >= play_order.get(0).gatsNeeded) {
                        gatAttack = true;
                    }
                    if (play_order.get(0).name.equals("Kit Carlson") && arrow != 9) {
                        System.out.println("Who do you want to remove an arrow from? ");
                        list.clear();
                        for (int j = 0; j < play_order.size(); j++) {
                            if (play_order.get(j).arrows > 0) {
                                System.out.println((j + 1) + ") " + play_order.get(j).name);
                                list.add(j);
                            }
                        }
                        System.out.print("> ");
                        do {
                            try {
                                if (play_order.get(0).computer == true) {
                                    Random random = new Random();
                                    players = (random.nextInt(10000000) % list.size());
                                    players = list.get(players);
                                    System.out.println(players);
                                } else {
                                    players = scan.nextInt();
                                }
                                test = true;
                            } catch (Exception a) {
                                System.out.println("Please give a number");
                            }
                        } while (!test);
                        play_order.get(players - 1).removeArrow(1);
                        System.out.println("Kit removed an arrow from: " + play_order.get(players - 1));
                        arrow++;
                    }
                }
                if (dice.get(count).sides[dice.get(count).side].equals("Gatling")) {
                    Gat++;
                    if (Gat >= play_order.get(0).gatsNeeded) {
                        gatAttack = true;
                    }
                    if (play_order.get(0).name.equals("Kit Carlson") && arrow != 9) {
                        System.out.println("Who do you want to remove an arrow from? ");
                        list.clear();
                        for (int j = 0; j < play_order.size(); j++) {
                            if (play_order.get(j).arrows > 0) {
                                System.out.println((j + 1) + ") " + play_order.get(j).name);
                                list.add(j);
                            }
                        }
                        System.out.print("> ");
                        do {
                            try {
                                if (play_order.get(0).computer == true) {
                                    Random random = new Random();
                                    players = ((random.nextInt(10000000) % list.size()) + 1);
                                    players = list.get(players);
                                    System.out.println(players);
                                } else {
                                    players = scan.nextInt();
                                }
                                test = true;
                            } catch (Exception a) {
                                System.out.println("Please give a number");
                            }
                        } while (!test);
                        play_order.get(players - 1).removeArrow(1);
                        System.out.println("Kit removed an arrow from: " + play_order.get(players - 1));
                        arrow++;
                    }
                }
                if (dice.get(count).sides[dice.get(count).side].equals("Bull's Eye 1")) {
                    BE1++;
                    total++;
                }
                if (dice.get(count).sides[dice.get(count).side].equals("Bull's Eye 2")) {
                    BE2++;
                    total++;
                }
                if (dice.get(count).sides[dice.get(count).side].equals("Beer")) {
                    Beer++;
                }
                if (dice.get(count).sides[dice.get(count).side].equals("Duel")) {
                    duel++;
                }
                if (dice.get(count).sides[dice.get(count).side].equals("Whiskey")) {
                    play_order.get(0).heal(1);
                    if (play_order.get(0).name.equals("Greg Digger")) {
                        play_order.get(0).heal(1);
                    }
                }
                if (dice.get(count).sides[dice.get(count).side].equals("Double Bull's Eye 1")) {
                    DBE1++;
                }
                if (dice.get(count).sides[dice.get(count).side].equals("Double Bull's Eye 2")) {
                    DBE2++;
                }
                if (dice.get(count).sides[dice.get(count).side].equals("Double Beer")) {
                    Beer += 2;
                }
            }
            if (dynamite >= 3) {
                play_order.get(0).damage(1);
                if (play_order.get(0).health <= 0) {
                    deathSeq(play_order, 0);
                    continue;
                }
            }
            if (gatAttack == true) {
                for (int i = 1; i < play_order.size(); i++) {
                    if (!(play_order.get(i).name.equals("Paul Regret"))) {
                        if (play_order.get(i).name.equals("Bart Cassidy")) {
                            bartAction(play_order, i, 1);
                        } else {
                            notBart(play_order, i, gringo, 1);
                        }
                        if (play_order.get(i).health <= 0) {
                            deathSeq(play_order, i);
                        }
                    }
                }
            }

            int arr[];
            if (play_order.get(0).name.equals("Calamity Janet")) {
                System.out.println("You have " + total + " shots!");
                arr = new int[total];
                for (int i = 0; i < total; i++) {
                    System.out.println("Where do you want shot number " + (i + 1) + " to go?");
                    list.clear();
                    System.out.println("1) " + left1.name);
                    list.add(1);
                    if (play_order.size() > 2 && left1 != left2 && play_order.get(0) != left2) {
                        System.out.println("2) " + left2.name);
                        list.add(2);
                    }
                    if (play_order.size() > 2 && right1 != left2 && right1 != left1 && right1 != play_order.get(0)) {
                        System.out.println(play_order.size() - 1 + ") " + right1.name);
                        list.add(play_order.size() - 1);
                    }
                    if (play_order.size() > 2 && right2 != left2 && right2 != left1 && right2 != play_order.get(0) && right2 != right1) {
                        System.out.println(play_order.size() - 2 + ") " + right2.name);
                        list.add(play_order.size() - 2);
                    }
                    System.out.print("> ");
                    do {
                        try {
                            if (play_order.get(0).computer == true) {
                                Random random = new Random();
                                players = (random.nextInt(10000000) % list.size());
                                players = list.get(players);
                                System.out.println(players);
                            } else {
                                players = scan.nextInt();
                            }
                            test = true;
                        } catch (Exception a) {
                            System.out.println("Please give a number");
                        }
                    } while (!test);
                    arr[i] = players;
                }
                for (int j = 0; j < arr.length; j++) {
                    if (play_order.size() > 1 && play_order.get(arr[j]).name.equals("Bart Cassidy")) {
                        bartAction(play_order, arr[j], 1);
                    } else {
                        notBart(play_order, arr[j], gringo, 1);
                    }
                }
            } else {
                if (BE1 > 0) {
                    if (play_order.get(0).name.equals("Rose Doolan")) {
                        System.out.println("You have " + BE1 + " one/two distance shots!");
                        arr = new int[BE1];
                        for (int i = 0; i < BE1; i++) {
                            System.out.println("Where do you want shot number " + (i + 1) + " to go?");
                            list.clear();
                            System.out.println("1) " + left1.name);
                            list.add(1);
                            if (play_order.size() > 2 && left1 != left2 && play_order.get(0) != left2) {
                                System.out.println("2) " + left2.name);
                                list.add(2);
                            }
                            if (play_order.size() > 2 && right1 != left2 && right1 != left1 && right1 != play_order.get(0)) {
                                System.out.println(play_order.size() - 1 + ") " + right1.name);
                                list.add(play_order.size() - 1);
                            }
                            if (play_order.size() > 2 && right2 != left2 && right2 != left1 && right2 != play_order.get(0) && right2 != right1) {
                                System.out.println((play_order.size() - 2) + ") " + right2.name);
                                list.add(play_order.size() - 2);
                            }
                            System.out.print("> ");
                            do {
                                try {
                                    if (play_order.get(0).computer == true) {
                                        Random random = new Random();
                                        players = (random.nextInt(10000000) % list.size());
                                        players = list.get(players);
                                        System.out.println(players);
                                    } else {
                                        players = scan.nextInt();
                                    }
                                    test = true;
                                } catch (Exception a) {
                                    System.out.println("Please give a number");
                                }
                            } while (!test);
                            arr[i] = players;
                        }
                        for (int j = 0; j < arr.length; j++) {
                            if (play_order.size() > 1 && play_order.get(arr[j]).name.equals("Bart Cassidy")) {
                                bartAction(play_order, arr[j], 1);
                            } else {
                                if (play_order.get(0).name.equals("Slab The Killer") && Beer > 0) {
                                    System.out.println("Slab: Do you want to use a Beer for double damage on " + play_order.get(arr[j]).name + "?");
                                    System.out.print("> ");
                                    answer = "n";
                                    if (play_order.get(0).computer == true) {
                                        Random random = new Random();
                                        int random_int = (random.nextInt(10000000) % 2);
                                        if (random_int == 1) {
                                            answer = "y";
                                        }
                                        System.out.println(answer);
                                    } else {
                                        answer = scan.next();
                                    }
                                    if (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes")) {
                                        notBart(play_order, arr[j], gringo, 2);
                                        Beer--;
                                    } else {
                                        notBart(play_order, arr[j], gringo, 1);
                                    }
                                } else {
                                    notBart(play_order, arr[j], gringo, 1);
                                }
                            }
                        }
                    } else {
                        System.out.println("You have " + BE1 + " one distance shots!");
                        arr = new int[BE1];
                        for (int i = 0; i < BE1; i++) {
                            System.out.println("Where do you want shot number " + (i + 1) + " to go?");
                            list.clear();
                            System.out.println("1) " + left1.name);
                            list.add(1);
                            if (right1 != left1 && right1 != play_order.get(0)) {
                                System.out.println((play_order.size() - 1) + ") " + right1.name);
                                list.add(play_order.size() - 1);
                            }
                            System.out.print("> ");
                            do {
                                try {
                                    if (play_order.get(0).computer == true) {
                                        Random random = new Random();
                                        players = (random.nextInt(10000000) % list.size());
                                        players = list.get(players);
                                        System.out.println(players);
                                    } else {
                                        players = scan.nextInt();
                                    }
                                    test = true;
                                } catch (Exception a) {
                                    System.out.println("Please give a number");
                                }
                            } while (!test);
                            arr[i] = players;
                        }
                        for (int j = 0; j < arr.length; j++) {
                            if (play_order.size() > 1 && play_order.get(arr[j]).name.equals("Bart Cassidy")) {
                                bartAction(play_order, arr[j], 1);
                            } else {
                                notBart(play_order, arr[j], gringo, 1);
                            }
                        }
                    }

                }
                if (BE2 > 0 && play_order.size() > 2) {
                    if (play_order.get(0).name.equals("Rose Doolan")) {
                        System.out.println("You have " + BE2 + " two/three distance shots!");
                        arr = new int[BE2];
                        for (int i = 0; i < BE2; i++) {
                            System.out.println("Where do you want shot number " + (i + 1) + " to go?");
                            list.clear();
                            System.out.println("2) " + left2.name);
                            list.add(2);
                            if (play_order.size() > 2 && left2 != left3 && play_order.get(0) != left3) {
                                System.out.println("3) " + left3.name);
                                list.add(3);
                            }
                            if (play_order.size() > 2 && right2 != left3 && right2 != left2 && right2 != play_order.get(0)) {
                                System.out.println((play_order.size() - 2) + ") " + right2.name);
                                list.add(play_order.size() - 2);
                            }
                            if (play_order.size() > 2 && right3 != left3 && right3 != left2 && right3 != play_order.get(0) && right3 != right2) {
                                System.out.println((play_order.size() - 3) + ") " + right3.name);
                                list.add(play_order.size() - 3);
                            }
                            System.out.print("> ");
                            do {
                                try {
                                    if (play_order.get(0).computer == true) {
                                        Random random = new Random();
                                        players = (random.nextInt(10000000) % list.size());
                                        players = list.get(players);
                                        System.out.println(players);
                                    } else {
                                        players = scan.nextInt();
                                    }
                                    test = true;
                                } catch (Exception a) {
                                    System.out.println("Please give a number");
                                }
                            } while (!test);
                            arr[i] = players;
                        }
                        for (int j = 0; j < arr.length; j++) {
                            if (play_order.size() > 1 && play_order.get(arr[j]).name.equals("Bart Cassidy")) {
                                bartAction(play_order, arr[j], 1);
                            } else {
                                notBart(play_order, arr[j], gringo, 1);
                            }
                        }
                    } else {
                        System.out.println("You have " + BE2 + " two distance shots!");
                        arr = new int[BE2];
                        for (int i = 0; i < BE2; i++) {
                            System.out.println("Where do you want shot number " + (i + 1) + " to go?");
                            list.clear();
                            System.out.println("2) " + left2.name);
                            list.add(2);
                            if (right2 != left2 && right2 != play_order.get(0)) {
                                System.out.println((play_order.size() - 2) + ") " + right2.name);
                                list.add(play_order.size() - 2);
                            }
                            System.out.print("> ");
                            do {
                                try {
                                    if (play_order.get(0).computer == true) {
                                        Random random = new Random();
                                        players = (random.nextInt(10000000) % list.size());
                                        players = list.get(players);
                                        System.out.println(players);
                                    } else {
                                        players = scan.nextInt();
                                    }
                                    test = true;
                                } catch (Exception a) {
                                    System.out.println("Please give a number");
                                }
                            } while (!test);
                            arr[i] = players;
                        }
                        for (int j = 0; j < arr.length; j++) {
                            if (play_order.size() > 1 && play_order.get(arr[j]).name.equals("Bart Cassidy")) {
                                bartAction(play_order, arr[j], 1);
                            } else {
                                if (play_order.get(0).name.equals("Slab The Killer") && Beer > 0) {
                                    System.out.println("Slab: Do you want to use a Beer for double damage on " + play_order.get(arr[j]).name + "?");
                                    System.out.print("> ");
                                    answer = "n";
                                    if (play_order.get(0).computer == true) {
                                        Random random = new Random();
                                        int random_int = (random.nextInt(10000000) % 2);
                                        if (random_int == 1) {
                                            answer = "y";
                                        }
                                        System.out.println(answer);
                                    } else {
                                        answer = scan.next();
                                    }
                                    if (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes")) {
                                        notBart(play_order, arr[j], gringo, 2);
                                        Beer--;
                                    } else {
                                        notBart(play_order, arr[j], gringo, 1);
                                        if (play_order.get(arr[j]).health <= 0) {
                                            deathSeq(play_order, arr[j]);

                                        }
                                    }
                                } else {
                                    notBart(play_order, arr[j], gringo, 1);
                                }
                            }
                        }
                    }
                }
            }
            if (DBE1 > 0) {
                if (play_order.get(0).name.equals("Rose Doolan")) {
                    System.out.println("You have " + DBE1 + " one/two distance shots!");
                    arr = new int[DBE1];
                    for (int i = 0; i < DBE1; i++) {
                        System.out.println("Where do you want shot number " + (i + 1) + " to go?");
                        list.clear();
                        System.out.println("1) " + left1.name);
                        list.add(1);
                        if (play_order.size() > 2 && left1 != left2 && play_order.get(0) != left2) {
                            System.out.println("2) " + left2.name);
                            list.add(2);
                        }
                        if (play_order.size() > 2 && right1 != left2 && right1 != left1 && right1 != play_order.get(0)) {
                            System.out.println(play_order.size() - 1 + ") " + right1.name);
                            list.add(play_order.size() - 1);
                        }
                        if (play_order.size() > 2 && right2 != left2 && right2 != left1 && right2 != play_order.get(0) && right2 != right1) {
                            System.out.println((play_order.size() - 2) + ") " + right2.name);
                            list.add(play_order.size() - 2);
                        }
                        System.out.print("> ");
                        do {
                            try {
                                if (play_order.get(0).computer == true) {
                                    Random random = new Random();
                                    players = (random.nextInt(10000000) % list.size());
                                    players = list.get(players);
                                    System.out.println(players);
                                } else {
                                    players = scan.nextInt();
                                }
                                test = true;
                            } catch (Exception a) {
                                System.out.println("Please give a number");
                            }
                        } while (!test);
                        arr[i] = players;
                    }
                    for (int j = 0; j < arr.length; j++) {
                        if (play_order.size() > 1 && play_order.get(arr[j]).name.equals("Bart Cassidy")) {
                            bartAction(play_order, arr[j], 2);
                        } else {
                            if (play_order.get(0).name.equals("Slab The Killer") && Beer > 0) {
                                System.out.println("Slab: Do you want to use a Beer for double damage on " + play_order.get(arr[j]).name + "?");
                                System.out.print("> ");
                                answer = "n";
                                if (play_order.get(0).computer == true) {
                                    Random random = new Random();
                                    int random_int = (random.nextInt(10000000) % 2);
                                    if (random_int == 1) {
                                        answer = "y";
                                    }
                                    System.out.println(answer);
                                } else {
                                    answer = scan.next();
                                }
                                if (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes")) {
                                    notBart(play_order, arr[j], gringo, 4);
                                    Beer--;
                                } else {
                                    play_order.get(arr[j]).damage(1);
                                    notBart(play_order, arr[j], gringo, 2);
                                }
                            } else {
                                play_order.get(arr[j]).damage(1);
                                notBart(play_order, arr[j], gringo, 2);
                            }
                        }
                    }
                } else {
                    System.out.println("You have " + DBE1 + " one distance shots!");
                    arr = new int[DBE1];
                    for (int i = 0; i < DBE1; i++) {
                        System.out.println("Where do you want shot number " + (i + 1) + " to go?");
                        list.clear();
                        System.out.println("1) " + left1.name);
                        list.add(1);
                        if (right1 != left1 && right1 != play_order.get(0)) {
                            System.out.println((play_order.size() - 1) + ") " + right1.name);
                            list.add(play_order.size() - 1);
                        }
                        System.out.print("> ");
                        do {
                            try {
                                if (play_order.get(0).computer == true) {
                                    Random random = new Random();
                                    players = (random.nextInt(10000000) % list.size());
                                    players = list.get(players);
                                    System.out.println(players);
                                } else {
                                    players = scan.nextInt();
                                }
                                test = true;
                            } catch (Exception a) {
                                System.out.println("Please give a number");
                            }
                        } while (!test);
                        arr[i] = players;
                    }
                    for (int j = 0; j < arr.length; j++) {
                        if (play_order.size() > 1 && play_order.get(arr[j]).name.equals("Bart Cassidy")) {
                            bartAction(play_order, arr[j], 2);
                        } else {
                            notBart(play_order, arr[j], gringo, 2);
                        }
                    }
                }

            }
            if (DBE2 > 0 && play_order.size() > 2) {
                if (play_order.get(0).name.equals("Rose Doolan")) {
                    System.out.println("You have " + DBE2 + " two/three distance shots!");
                    arr = new int[DBE2];
                    for (int i = 0; i < DBE2; i++) {
                        System.out.println("Where do you want shot number " + (i + 1) + " to go?");
                        list.clear();
                        System.out.println("2) " + left2.name);
                        list.add(2);
                        if (play_order.size() > 2 && left2 != left3 && play_order.get(0) != left3) {
                            System.out.println("3) " + left3.name);
                            list.add(3);
                        }
                        if (play_order.size() > 2 && right2 != left3 && right2 != left2 && right2 != play_order.get(0)) {
                            System.out.println((play_order.size() - 2) + ") " + right2.name);
                            list.add(play_order.size() - 2);
                        }
                        if (play_order.size() > 2 && right3 != left3 && right3 != left2 && right3 != play_order.get(0) && right3 != right2) {
                            System.out.println((play_order.size() - 3) + ") " + right3.name);
                            list.add(play_order.size() - 3);
                        }
                        System.out.print("> ");
                        do {
                            try {
                                if (play_order.get(0).computer == true) {
                                    Random random = new Random();
                                    players = (random.nextInt(10000000) % list.size());
                                    players = list.get(players);
                                    System.out.println(players);
                                } else {
                                    players = scan.nextInt();
                                }
                                test = true;
                            } catch (Exception a) {
                                System.out.println("Please give a number");
                            }
                        } while (!test);
                        arr[i] = players;
                    }
                    for (int j = 0; j < arr.length; j++) {
                        if (play_order.size() > 1 && play_order.get(arr[j]).name.equals("Bart Cassidy")) {
                            bartAction(play_order, arr[j], 2);
                        } else {
                            notBart(play_order, arr[j], gringo, 2);
                        }
                    }
                } else {
                    System.out.println("You have " + DBE2 + " two distance shots!");
                    arr = new int[DBE2];
                    for (int i = 0; i < DBE2; i++) {
                        System.out.println("Where do you want shot number " + (i + 1) + " to go?");
                        list.clear();
                        System.out.println("2) " + left2.name);
                        list.add(2);
                        if (right2 != left2 && right2 != play_order.get(0)) {
                            System.out.println((play_order.size() - 2) + ") " + right2.name);
                            list.add(play_order.size() - 2);
                        }
                        System.out.print("> ");
                        do {
                            try {
                                if (play_order.get(0).computer == true) {
                                    Random random = new Random();
                                    players = (random.nextInt(10000000) % list.size());
                                    players = list.get(players);
                                    System.out.println(players);
                                } else {
                                    players = scan.nextInt();
                                }
                                test = true;
                            } catch (Exception a) {
                                System.out.println("Please give a number");
                            }
                        } while (!test);
                        arr[i] = players;
                    }
                    for (int j = 0; j < arr.length; j++) {
                        if (play_order.size() > 1 && play_order.get(arr[j]).name.equals("Bart Cassidy")) {
                            bartAction(play_order, arr[j], 2);
                        } else {
                            if (play_order.get(0).name.equals("Slab The Killer") && Beer > 0) {
                                System.out.println("Slab: Do you want to use a Beer for double damage on " + play_order.get(arr[j]).name + "?");
                                System.out.print("> ");
                                answer = "n";
                                if (play_order.get(0).computer == true) {
                                    Random random = new Random();
                                    int random_int = (random.nextInt(10000000) % 2);
                                    if (random_int == 1) {
                                        answer = "y";
                                    }
                                    System.out.println(answer);
                                } else {
                                    answer = scan.next();
                                }
                                if (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes")) {
                                    notBart(play_order, arr[j], gringo, 4);

                                    Beer--;
                                } else {
                                    notBart(play_order, arr[j], gringo, 2);

                                }
                            } else {
                                notBart(play_order, arr[j], gringo, 2);

                            }
                        }
                    }
                }
            }
            if (play_order.get(0).name.equals("Jesse Jones") && play_order.get(0).health <= 4) {
                Beer *= 2;
            }
            play_order.get(0).heal(Beer);
            if (duel > 0) {
                ArrayList<Player> duelList = new ArrayList();
                for (int i = 1; i < play_order.size(); i++) {

                    duelList.add(play_order.get(i));
                }
                while (duel > 0 && duelList.size() > 0) {
                    Player turn;
                    turn = play_order.get(0);
                    for (int j = 0; j < duelList.size(); j++) {
                        System.out.println((j + 1) + ") " + duelList.get(j).name);
                    }
                    System.out.println("Who do you want to duel?");
                    System.out.print("> ");
                    test = false;
                    do {
                        try {
                            if (play_order.get(0).computer == true) {
                                Random random = new Random();
                                players = ((random.nextInt(10000000) % duelList.size()) + 1);
                                System.out.println(players);
                            } else {
                                players = scan.nextInt();
                            }
                        } catch (Exception a) {
                            System.out.println("Please give a number");
                        }
                        test = true;
                    } while (!test);

                    System.out.println("Do you want to roll first? (y/n)");
                    answer = "n";
                    if (play_order.get(0).computer == true) {
                        Random random = new Random();
                        int random_int = (random.nextInt(10000000) % 2);
                        if (random_int == 1) {
                            answer = "y";
                        }
                        System.out.println(answer);
                    } else {
                        answer = scan.next();
                    }
                    if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y")) {
                        turn = play_order.get(0);
                        dice.get(0).roll();
                        if (dice.get(0).sides[dice.get(0).side].equals("Duel")) {
                            while (dice.get(0).sides[dice.get(0).side].equals("Duel")) {
                                turn = duelList.get((players - 1));
                                dice.get(0).roll();
                                if (!(dice.get(0).sides[dice.get(0).side].equals("Duel"))) {
                                    break;
                                }
                                turn = play_order.get(0);
                                dice.get(0).roll();
                            }
                        }
                    } else {
                        while (dice.get(0).sides[dice.get(0).side].equals("Duel")) {
                            turn = duelList.get((players - 1));
                            dice.get(0).roll();
                            if (!(dice.get(0).sides[dice.get(0).side].equals("Duel"))) {
                                break;
                            }
                            turn = play_order.get(0);
                            dice.get(0).roll();
                        }
                    }
                    duelList.remove(duelList.get((players - 1)));
                    turn.damage(1);
                    System.out.println(turn.name + " has lost the duel and has picked up a duel wound card and lost 1 health!");
                    if (turn.health <= 0) {
                        deathSeq(play_order, players);
                    }
                    //turn (player), gains duel fail card

                    duel--;
                }
            }
            if (BE1 == 0 && BE2 == 0 && DBE1 == 0 && DBE2 == 0) {
                if (play_order.get(0).name.equals("Suzy Lafayette")) {
                    play_order.get(0).heal(2);
                }
            }

            play_order.add(play_order.get(0));
            play_order.remove(play_order.get(0));
        }

    }

    public static void bartAction(ArrayList<Player> play_order, int i, int dam) {
        System.out.println("Bart Cassidy: Would you like to take an arrow instead of damage? (y/n)");
        System.out.print("> ");
        String answer = "n";
        if (play_order.get(i).computer == true) {
            Random random = new Random();
            int random_int = (random.nextInt(10000000) % 2);
            if (random_int == 1) {
                answer = "y";
            }
            System.out.println(answer);
        } else {
            answer = scan.next();
        }
        if (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes")) {
            play_order.get(i).addArrow(1);
            arrowTakeAction(play_order, 1);
            if (arrow == 0) {
                indianAttack(play_order);
            }
        } else {
            play_order.get(i).damage(dam);
            if (play_order.get(i).health <= 0) {
                deathSeq(play_order, i);
            }
        }
    }

    public static void indianAttack(ArrayList<Player> play_order) {
        System.out.println("The Indians have attacked!");
        int most = 0;
        int index = 0;
        for (int i = 0; i < play_order.size(); i++) {
            if (play_order.get(i).arrows > most) {
                most = play_order.get(i).arrows;
                index = i;
            }
            if (play_order.get(i).arrows == most) {
                index = 10;
            }
        }
        for (int j = 0; j < play_order.size(); j++) {
            if (play_order.get(j).chiefArrow == false || j != index) {
                if (play_order.get(j).name.equals("Joursonnais") && play_order.get(j).arrows > 0) {
                    play_order.get(j).arrows = 1;
                }
                play_order.get(j).damage(play_order.get(j).arrows);
                if (play_order.get(j).chiefArrow == true) {
                    play_order.get(j).damage(1);
                }
                play_order.get(j).arrowReset();
                play_order.get(j).chiefArrow = false;
                if (play_order.get(j).health <= 0) {
                    deathSeq(play_order, j);
                }
            } else {
                play_order.get(j).arrowReset();
                play_order.get(j).chiefArrow = false;
            }
        }
        Bang_fxGUI.arrow = 10;
        Bang_fxGUI.chiefArrow = true;
    }

    public static void deathSeq(ArrayList<Player> play_order, int i) {
        System.out.println(play_order.get(i).name + " has died!");
        play_order.get(i).shown = true;
        for (int l = 0; l < play_order.size(); l++) {
            if (play_order.get(l).name.equals("Vulture Sam") && !(play_order.get(i).name.equals("Vulture Sam"))) {
                play_order.get(l).heal(2);
            }
        }
        play_order.remove(i);
        int t0 = 0;
        int t1 = 0;
        int t2 = 0;
        for (int j = 0; j < play_order.size(); j++) {
            int team = play_order.get(j).team;
            if (team == 0) {
                t0++;
            }
            if (team == 1) {
                t1++;
            }
            if (team == 2) {
                t2++;
            }
        }
        if (t0 == 0 && t1 == 0) {
            endGame(2);
        } else if (t0 == 0) {
            endGame(1);
        } else if (t1 == 0 && t2 == 0) {
            endGame(0);
        }

    }

    public static boolean notBart(ArrayList<Player> play_order, int i, boolean gringo, int damage) {
        try {
            play_order.get(i).damage(damage);
        } catch (Exception e) {
            return gringo;
        }

        if (play_order.get(i).name.equals("Pedro Ramirez") && play_order.get(i).arrows > 0 && play_order.get(i).health != 0) {
            play_order.get(i).removeArrow(1);
        }
        if (play_order.get(i).name.equals("El Gringo") && play_order.get(i).health != 0) {
            play_order.get(0).addArrow(1);
            arrowTakeAction(play_order, 0);
            if (arrow == 0) {
                indianAttack(play_order);
            }
            gringo = true;
        }
        if (play_order.get(i).health <= 0) {
            deathSeq(play_order, i);
        }
        return gringo;
    }

    public static void endGame(int team) {
        System.out.println("CONGRATS!");
        System.out.print("Team ");
        switch (team) {
            case 0:
                System.out.print("Sheriff/Deputy have won!");
                break;
            case 1:
                System.out.print("Outlaws have won!");
                break;
            case 2:
                System.out.print("Renegades have won!");
                break;
        }
        System.exit(0);
    }

    public static void arrowTakeAction(ArrayList<Player> play_order, int order) {
        String answer;
        if (chiefArrow == true) {
            System.out.println("Do you want to take the chief arrow?");
            answer = "n";
            if (play_order.get(order).computer == true) {
                Random random = new Random();
                int random_int = (random.nextInt(10000000) % 2);
                if (random_int == 1) {
                    answer = "y";
                }
                System.out.println(answer);
            } else {
                answer = scan.next();
            }
            if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y")) {
                chiefArrow = false;
                play_order.get(order).chiefArrow = true;
                arrow--;
            }
        } else {
            arrow--;
        }
    }

}

// TO DO
/*

1. Impliment actual AI and not randomness
3. Fix 2-distance shots
4. Fix bull's eye numbering

*
*/
