
package bang;

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
    
     //Assigning health of each characters
    public void setHealth(int health1) {
        health = health1;
    }

    public int getHealth() {
        return health;
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

//AI assigning  each character roles according to their abilties
 
if (this.getCharacter().name == " bart cassidy "){
    this.setHealth(8);
            int playerChoice;
            System.out.print("You want to choose arrow instead of losing a life point? (except to indians or dynamite) ");
            Scanner object = new Scanner(System.in);
            playerChoice = object.nextInt();
// (8) you may take an arrow instead of losing a life point (except to indians or dynamite). 
// you cannot use this ability if you lose a life point to indian or dynamite, only for , , or gatling guns. 
//you may not use this ability to take the last arrow remaining in the pile.
  }

if (this.getCharacter().name == " paul regret "){
    this.setHealth(9);
// (9) you never lose life points to the gatling gun.
}


if (this.getCharacter().name == " black once "){
    this.setHealth(8);
 //(or in total if you didn’t re-roll them), follow the usual rules (your turn ends, etc.)
}

if (this.getCharacter().name == "pedro ramirez"){
     this.setHealth(8);
        if (setHealth(getHealth - 1)) {

            System.out.print("Do you want to discard one of your arrows? If Yes enter 1 :");
            Scanner object = new Scanner(System.in);
            int playerChoice = object.nextInt();

            switch (playerChoice) {
                case 1: {
                    this.removeArrow(1);
                }
              
                }

           
//8) each time you lose a life point, you may discard one of your arrows. you still lose the life 
//point when you use this ability
}

if (this.getCharacter().name == "calamity janet"){
      this.setHealth(8);
// (8) you can use as 1& 2 and vice-versa
}

if (this.getCharacter().name == " rose doolan ") {
      this.setHealth(9);
// (9) you may use or for players sitting one place further. with you may hit a player sitting up to
//two /places away, and with you may h
}

if (this.getCharacter().name == " el gringo "){
      this.setHealth(7);
 //(7) when a player makes you lose one or more life points, he must take an arrow. life points 
//lost to indians or dynamite are not affected
}


if (this.getCharacter().name == " sid ketchum "){
      this.setHealth(8);
 //(8) at the beginning of your turn, any player of your choice gains one life point. you may also 
//choose yourself
}


if (this.getCharacter().name == " jesse jones "){
      this.setHealth(9);
 //(9) if you have four life points or less, you gain two if you use for yourself. for example, if you
 //have four life points and use two beers, you get four life points.
}


if (this.getCharacter().name == " slab the killer "){
      this.setHealth(8);
 //(8) once per turn, you can use a to double a or . the dice you double takes two life points away
 //from the same player (you can’t choose two different players). the in this case does not provide any life points.
}


if (this.getCharacter().name == " jourdonnais "){
      this.setHealth(7);
 //(7) you never lose more than one life point to indians.
}

if (this.getCharacter().name == " suzy lafayette "){
      this.setHealth(8);
 //(8) if you didn’t roll any or , you gain two life points. this only applies at the end of your turn,  
 //not during your re-rolls.
}

if (this.getCharacter().name == " kit carlson "){
      this.setHealth(7);
 //(7) for each you may discard one arrow from any player. you may choose to discard your own
 //arrows. if you roll three , you discard all your own arrows, plus three from any player(s) (of 
//course, you still deal one damage to each other player).
}

if (this.getCharacter().name == " vulture sam "){
      this.setHealth(9);
 //(9) each time another player is eliminated, you gain two life points.
}

if (this.getCharacter().name == " lucky duke "){
      this.setHealth(8);
 //(8) you may make one extra re-roll. you may roll the dice a total of four times on your turn.
}

if (this.getCharacter().name == " willy the kid "){
      this.setHealth(8);
//(8) you only need to use the gatling gun. you can activate the gatling gun only once per turn,
//even if you roll more than two results.
}

       
    }
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
}
