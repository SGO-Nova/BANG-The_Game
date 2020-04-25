
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
 
if (this.getcharacter().name == " bart cassidy "){
// (8) you may take an arrow instead of losing a life point (except to indians or dynamite). 
// you cannot use this ability if you lose a life point to indian or dynamite, only for , , or gatling guns. 
//you may not use this ability to take the last arrow remaining in the pile.
  }

if (this.getcharacter().name == " paul regret "){
// (9) you never lose life points to the gatling gun.
}


if (this.getcharacter().name == " black once "){
 //(or in total if you didn’t re-roll them), follow the usual rules (your turn ends, etc.)
}

if (this.getcharacter().name == "pedro ramirez"){
//8) each time you lose a life point, you may discard one of your arrows. you still lose the life 
//point when you use this ability
}

if (this.getcharacter().name == "calamity janet"){
// (8) you can use as 1& 2 and vice-versa
}

if (this.getcharacter().name == " rose doolan ") {
// (9) you may use or for players sitting one place further. with you may hit a player sitting up to
//two /places away, and with you may h
}

if (this.getcharacter().name == " el gringo "){
 //(7) when a player makes you lose one or more life points, he must take an arrow. life points 
//lost to indians or dynamite are not affected
}


if (this.getcharacter().name == " sid ketchum "){
 //(8) at the beginning of your turn, any player of your choice gains one life point. you may also 
//choose yourself
}


if (this.getcharacter().name == " jesse jones "){
 //(9) if you have four life points or less, you gain two if you use for yourself. for example, if you
 //have four life points and use two beers, you get four life points.
}


if (this.getcharacter().name == " slab the killer "){
 //(8) once per turn, you can use a to double a or . the dice you double takes two life points away
 //from the same player (you can’t choose two different players). the in this case does not provide any life points.
}


if (this.getcharacter().name == " jourdonnais "){
 //(7) you never lose more than one life point to indians.
}

if (this.getcharacter().name == " suzy lafayette "){
 //(8) if you didn’t roll any or , you gain two life points. this only applies at the end of your turn,  
 //not during your re-rolls.
}

if (this.getcharacter().name == " kit carlson "){
 //(7) for each you may discard one arrow from any player. you may choose to discard your own
 //arrows. if you roll three , you discard all your own arrows, plus three from any player(s) (of 
//course, you still deal one damage to each other player).
}

if (this.getcharacter().name == " vulture sam "){
 //(9) each time another player is eliminated, you gain two life points.
}

if (this.getcharacter().name == " lucky duke "){
 //(8) you may make one extra re-roll. you may roll the dice a total of four times on your turn.
}

if (this.getcharacter().name == " willy the kid "){
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
