/* CS 2365 OOP Spring 2020
Mihir Patel 
 */
 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bang;

import java.util.Random;

/**
 *
 * @author Mihir
 */
public class Old_Dice1 {

    String Old_sides[] = new String[6]; //Old Saloon dice 1
    int Old_side;

    public Old_Dice1(int Old_side) {  //dice 1 sides
        this.Old_side = Old_side;
        Old_sides[0] = "Indian Arrow";
        Old_sides[1] = "Broken Arrow";
        Old_sides[2] = "Bull's Eye 1";
        Old_sides[3] = "Beer";
        Old_sides[4] = " Dynamite";
        Old_sides[5] = "Double Beer";
    }

    public String Old_diceR() {
        return this.Old_sides[this.Old_side];

    }

    public String roll() {
        Random rn = new Random();
        this.Old_side = (rn.nextInt(10000000) % 6);
        return Old_sides[Old_side];

    }

}
