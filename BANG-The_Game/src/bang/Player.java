
package bang;

import static bang.BANG.scan;

public class Player {

    String name;
    String displayName;
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
    public boolean chiefArrow = false;

    Character_Cards c; //team assign

    public Player(String name, int health, String role, boolean comp) {
        this.name = name;
        this.displayName = name;
        this.health = health;
        this.maxHealth = health;
        this.role = role;
        this.computer = comp;
        this.s_bul = health % 3;
        this.t_bul = (health - this.s_bul) / 3;
        this.arrows = 0;
        this.shown = false;
        if (this.name.equals("Black Jack")) {
            this.dynamiteReroll = true;
        }
        if (this.name.equals("Lucky Duke")) {
            this.rolls = 4;
        }
        if (this.name.equals("Willy The Kid")) {
            this.gatsNeeded = 2;
        }
        if (this.role.equals("Sheriff") || this.role.equals("Deputy")) {
            this.team = 0;
        } else if (this.role.equals("Outlaw")) {
            this.team = 1;
        } else if (this.role.equals("Renegade")) {
            this.team = 2;
        }
    }

    public Character_Cards getCharacter() { //calling characters class from bang.java
        return this.c;
    }
    
    public void bulletUpdate() {
        this.s_bul = this.health % 3;
        this.t_bul = (this.health - this.s_bul) / 3;
    }

    public void addArrow(int number) {
        if (this.name.equals("Jessie Jones") && this.health < 5) {
            //do nothing 
        } //else
        else {
            this.arrows += number;
        }
    }

    public void removeArrow(int number) {
        this.arrows -= number;
    }

    public void arrowReset() {
        this.arrows = 0;
    }

    public void damage(int damage) {
        if (this.health > damage) {
            this.health -= damage;
        } else {
            this.health = 0;
        }
        bulletUpdate();
    }

//AI assigning  each character roles according to their abilties


       
   public void setMaxHealth(int maxHealth){
       this.maxHealth = maxHealth;
   }
    
    public void heal(int heal) {
        //if jessie jones then heal points + 1
        if (this.health + heal > this.maxHealth) {
            this.health = this.maxHealth;
        } else {
            this.health += heal;
        }
        bulletUpdate();
    }

    public void revealRole() {
        this.shown = true;
    }



    public int personChoice()
    {
        //we want to get to the point of returning the index of play_order.get to know who the ai wants to attack
        
        
        return 0;
    }
    public boolean diceChoice()
    {
         if(play_order.get(0).role.equals("Deputy"))
                            {
                                //Check where the sheriff is at in the game
                                if(play_order.get(1).shown==true)
                                {
                                    sheriff = 1;
                                }
                                else if (play_order.get(2).shown==true)
                                {
                                    sheriff = 2;
                                }
                                else if ((play_order.get(play_order.size()-1).shown)==true)
                                {
                                    //1 to the opposite side 
                                    sheriff=play_order.size()-1;
                                }
                                else if ((play_order.get(play_order.size()-2).shown)==true)
                                {
                                    //2 to the opposite side
                                    sheriff = play_order.size()-2;
                                }
                                //Reroll Gats unless you roll two

                                //Reroll Arrows and Dynomite if blackjack
                                //So if player is BlackJack reroll dynomite otherwise must stay 
                                //if(play_order)
                                if(Gat>=(play_order.get(0).gatsNeeded)-1)
                                {
                                    answer= scan.next();
                                }
                                    else
                                    {
                                        //reroll= true;
                                        answer= "y";
                                        //dice.get(roll).roll();
                                    }
                                //
                                if(dice.get(roll).sides[dice.get(roll).side].equals("Indian Arrow"))
                                {
                                    reroll=true;
                                    dice.get(roll).roll();
                                }
                                //keep beers if player has low health 
                                if(dice.get(roll).sides[dice.get(roll).side].equals("Beer"))
                                {
                                    //loop this to see all sides 
                                    int playerMaxHealth= play_order.get(0).maxHealth;
                                    //want to reroll if current health is less than max 
                                    if((play_order.get(0).health)>=playerMaxHealth-2)
                                    {
                                        answer= "y";
                                        //reroll=true;
                                    }
                                    else if ((play_order.get(0).health)>=playerMaxHealth-2 && (play_order.get(0).health)<=playerMaxHealth-4)
                                    {
                                        //want to keep one beer 
                                        answer = scan.next();

                                    }
                                    else if((play_order.get(0).health)>=playerMaxHealth-4 && (play_order.get(0).health)<=playerMaxHealth-6)
                                    {
                                        //want to keep two beers
                                        answer = scan.next();

                                    }
                                    else 
                                    {
                                        //keep all beers 
                                        //reroll= false;
                                        answer = scan.next();
                                    }
                                }
                                int sheriffHealth=play_order.get(sheriff).health;
                                //Want to heal the sherriff if they are hurt, any type of hurt they are feeling we will give them the beers
                                if(sheriffHealth<=play_order.get(sheriff).maxHealth)
                                {
                                    //keep beers 
                                    answer= scan.next();
                                    //reroll= false;
                                }
                                else
                                {
                                    answer= "y";
                                }
                                //Also need to keep/reroll BE1 and BE2
                                if(dice.get(roll).sides[dice.get(roll).side].equals("BE1"))
                                {
                                    if(sheriff!=(play_order.size()-1))
                                    {
                                        //Want to keep BE1 unless it will hurt Sheriff
                                    }
                                }
                                    else if(dice.get(roll).sides[dice.get(roll).side].equals("BE2"))
                                    {
                                        if(sheriff!=((play_order.size())-1))
                                        {
                                            //Want to keep BE2 unless it will hurt Sheriff

                                        }                                      

                                    }
                                    else
                                    {

                                    }
                            }
                            else if (play_order.get(0).role.equals("Renegade"))
                            {
                                //want to avoid sheriff but kill everyone else until the sheriff is dead too 
                                if(Gat>=(play_order.get(0).gatsNeeded)-1)
                                {
                                    answer= scan.next();
                                }
                                    else
                                    {
                                        //reroll= true;
                                        answer= "y";
                                        //dice.get(roll).roll();
                                    }
                                if(dice.get(roll).sides[dice.get(roll).side].equals("Beer"))
                                {
                                //loop this to see all sides 
                                    int playerMaxHealth= play_order.get(0).maxHealth;
                                    //want to reroll if current health is less than max 
                                    if((play_order.get(0).health)>=playerMaxHealth-2)
                                    {
                                        answer= "y";
                                        //reroll=true;
                                    }
                                        else if ((play_order.get(0).health)>=playerMaxHealth-2 && (play_order.get(0).health)<=playerMaxHealth-4)
                                        {
                                            //want to keep one beer 
                                            answer = scan.next();

                                        }
                                        else if((play_order.get(0).health)>=playerMaxHealth-4 && (play_order.get(0).health)<=playerMaxHealth-6)
                                        {
                                            //want to keep two beers
                                            answer = scan.next();

                                        }
                                        else 
                                        {
                                            //keep all beers 
                                            //reroll= false;
                                            answer = scan.next();
                                        }
                                }
                            }
                            else
                            {
                                //Everyone else play as normal
                                //Sheriff can hurt deputy we don't care about them 
                                if(Gat>=(play_order.get(0).gatsNeeded)-1)
                                {
                                    answer= scan.next();
                                }
                                    else
                                    {
                                        //reroll= true;
                                        answer= "y";
                                        //dice.get(roll).roll();
                                    }
                                if(dice.get(roll).sides[dice.get(roll).side].equals("Beer"))
                                {
                                    //loop this to see all sides 
                                    int playerMaxHealth= play_order.get(0).maxHealth;
                                    //want to reroll if current health is less than max 
                                    if((play_order.get(0).health)>=playerMaxHealth-2)
                                    {
                                        answer= "y";
                                        //reroll=true;
                                    }
                                    else if ((play_order.get(0).health)>=playerMaxHealth-2 && (play_order.get(0).health)<=playerMaxHealth-4)
                                    {
                                        //want to keep one beer 
                                        answer = scan.next();

                                    }
                                    else if((play_order.get(0).health)>=playerMaxHealth-4 && (play_order.get(0).health)<=playerMaxHealth-6)
                                    {
                                        //want to keep two beers
                                        answer = scan.next();

                                    }
                                    else 
                                    {
                                        //keep all beers 
                                        //reroll= false;
                                        answer = scan.next();
                                    }
                                }
                            }
        
        
        return true;
    }
    
}
