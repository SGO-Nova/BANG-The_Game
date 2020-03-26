/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bang;

/**
 *
 * @author ryanb
 */
public class BANG {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create all the character cards with the names and HP. Attributes to come later!
        Character_Cards character1 = new Character_Cards("Bart Cassidy", 8);
        Character_Cards character2 = new Character_Cards("Black Jack", 8);
        Character_Cards character3 = new Character_Cards("Calamity Janet", 8);
        Character_Cards character4 = new Character_Cards("El Gringo", 7);
        Character_Cards character5 = new Character_Cards("Jesse Jones", 9);
        Character_Cards character6 = new Character_Cards("Joursonnais", 7);
        Character_Cards character7 = new Character_Cards("Kit Carlson", 7);
        Character_Cards character8 = new Character_Cards("Lucky Duke", 8);
        Character_Cards character9 = new Character_Cards("Paul Regret", 9);
        Character_Cards character10 = new Character_Cards("Pedro Ramirez", 8);
        Character_Cards character11 = new Character_Cards("Rose Doolan", 9);
        Character_Cards character12 = new Character_Cards("Sid Ketchum", 8);
        Character_Cards character13 = new Character_Cards("Slab The Killer", 8);
        Character_Cards character14 = new Character_Cards("Suzy Lafayette", 8);
        Character_Cards character15 = new Character_Cards("Vulture Sam", 9);
        Character_Cards character16 = new Character_Cards("Willy The Kid", 8);
        
        //Test out character hp damage and heal
        System.out.println("Bart has " + character1.hp);
        System.out.println("Black Jack has " + character2.hp);
        System.out.println("Black Jack shot him");
        character1.damage(1);
        System.out.println("Bart now has " + character1.hp);
        System.out.println("Black Jack still has " + character2.hp);
        System.out.println("Black Jack drank beer");
        character2.heal(1);
        System.out.println("Black Jack now has " + character2.hp);
        
        Dice dice1 = new Dice(0);
        Dice dice2 = new Dice(0);
        Dice dice3 = new Dice(0);
        Dice dice4 = new Dice(0);
        Dice dice5 = new Dice(0);
        System.out.println(dice1.roll()+ ", " +dice2.roll()+ ", " +dice3.roll()+ ", " +dice4.roll()+ ", " +dice5.roll());
        System.out.println("Rerolling dice 4 and 5!");
        System.out.println(dice1.keep() + ", " + dice2.keep() + ", " + dice3.keep() + ", " + dice4.roll() + ", " + dice5.roll());
        
        //Create role cards
        Role_Cards card0 = new Role_Cards("Sheriff");
        Role_Cards card1 = new Role_Cards("Renegade");
        Role_Cards card2 = new Role_Cards("Outlaw");
        Role_Cards card3 = new Role_Cards("Outlaw");
        Role_Cards card4 = new Role_Cards("Deputy");
        Role_Cards card5 = new Role_Cards("Outlaw");
        Role_Cards card6 = new Role_Cards("Deputy");
        Role_Cards card7 = new Role_Cards("Renegade");
        
        //Test out character object;
        Player human = new Player(character5.name, character5.hp, card2.role, false);
        System.out.println("This player's name is: " + human.name + ", has " + human.health +" hp, and is a " + human.role);
    }
    
}
