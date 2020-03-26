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
public class Player {
    String name;
    int health;
    String role;
    boolean computer;
    
    public Player(String name, int health, String role, boolean comp){
        this.name = name;
        this.health = health;
        this.role = role;
        this.computer = comp;
    }
}
