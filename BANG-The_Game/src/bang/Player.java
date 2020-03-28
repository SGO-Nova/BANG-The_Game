//Authors:Ryan Browning

package bang;


public class Player {
    String name;
    int health;
    int maxHealth;
    String role;
    boolean computer;
    public int t_bul;
    public int s_bul;
    public int arrows;
    boolean dynamiteReroll = false;
    int rolls = 3;
    int gatsNeeded = 3;
    int team;
    public boolean shown;
    
    public Player(String name, int health, String role, boolean comp){
        this.name = name;
        this.health = health;
        this.maxHealth = health;
        this.role = role;
        this.computer = comp;
        this.s_bul = health%3;
        this.t_bul = (health - this.s_bul) / 3;
        this.arrows = 0;
        this.shown = false;
        if(this.name.equals("Black Jack")){
            this.dynamiteReroll = true;
        }
        if(this.name.equals("Lucky Duke")){
            this.rolls = 4;
        }
        if(this.name.equals("Willy The Kid")){
            this.gatsNeeded = 2;
        }
        if(this.role.equals("Sheriff") || this.role.equals("Deputy")){
            this.team = 0;
        }
        else if(this.role.equals("Outlaw")){
            this.team = 1;
        }
        else if(this.role.equals("Renegade")){
            this.team = 2;
        }
    }
    
    public void bulletUpdate(){
        this.s_bul = this.health%3;
        this.t_bul = (this.health - this.s_bul) / 3;
    }
    
    public void addArrow(int number){
        this.arrows += number;
    }
    
    public void removeArrow(int number){
        this.arrows -= number;
    }
    
    public void arrowReset(){
        this.arrows = 0;
    }
    
    public void damage(int damage){
        if(this.health > damage){
            this.health -= damage;
        }
        else{
            this.health = 0;
        }
        bulletUpdate();
        
    }
    
    public void heal(int heal){
        if(this.health + heal > this.maxHealth){
            this.health = this.maxHealth;
        }
        else{
           this.health += heal; 
        }
        bulletUpdate();
    }
    
    public void revealRole(){
        this.shown = true;   
    }
}
