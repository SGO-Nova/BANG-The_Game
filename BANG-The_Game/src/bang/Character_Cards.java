//Ryan Browning

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bang;

/**
 *
 * @author Ryan
 */
public class Character_Cards {
    public String name;
    public int hp;

    public Character_Cards(String name, int hp){
        this.name = name;
        this.hp = hp;
    }
    
    public void damage(int damage){
        this.hp -= damage;
    }
    
    public void heal(int heal){
        this.hp += heal;
    }
    
}
