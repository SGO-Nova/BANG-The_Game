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

public class Role_Cards {
    public String role;
    public boolean shown;
    
    public Role_Cards(String role){
        this.role = role;
        this.shown = false;
    }
    
    public void revealRole(){
        this.shown = true;
        
    }
}
