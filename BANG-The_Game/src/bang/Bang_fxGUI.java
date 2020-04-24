/*
 * Shafat Rakin
 * CS 2365-001
 * Project 3
 * Spring 2020
 * This file implements a GUI using JavaFX.
 */

package bang;

// imports galore
import static bang.BANG.arrow;
import static bang.BANG.arrowTakeAction;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.event.*;

public class Bang_fxGUI extends Application
{
    public String textField;
    
    Stage window;
    Scene scene1, scene2, scene3, scene4, scene5, scene6, scene7, scene8, scene9;
    static int arrow = 10;
    static boolean chiefArrow = true;
    static Scanner scan;
    static int players;
    
    //Global creation of lines and UI elements
    Label Line1 = new Label(textField);
    Label Line2 = new Label(textField);
    Label Line3 = new Label(textField);
    Label Line4 = new Label(textField);
    Label Line5 = new Label(textField);
    Label Line6 = new Label(textField);
    Label Line7 = new Label(textField);
    Label Line8 = new Label(textField);
    Label Line9 = new Label(textField);
    Label main1 = new Label(textField);
    Label main2 = new Label(textField);
    Label main3 = new Label(textField);
    Label main4 = new Label(textField);
    Label main5 = new Label(textField);
    Label main6 = new Label(textField);
    Label main7 = new Label(textField);
    Label main8 = new Label(textField);
    ArrayList<Label> lines = new ArrayList();
    TextField playerName = new TextField("Enter Name");
    ComboBox numPlayers = new ComboBox();
    CheckBox cb1 = new CheckBox("Music in Game");
    CheckBox c1 = new CheckBox("");
    CheckBox c2 = new CheckBox("");
    CheckBox c3 = new CheckBox("");
    CheckBox c4 = new CheckBox("");
    CheckBox c5 = new CheckBox("");
    CheckBox c6 = new CheckBox("");
    CheckBox c7 = new CheckBox("");
    CheckBox c8 = new CheckBox("");
    ArrayList<CheckBox> checkBoxes = new ArrayList();
    Button nextButton = new Button("Next");
    Button Button2 = new Button("Next");
    Button Button3 = new Button("Next");
    Button Button4 = new Button("Next");
    Button Button5 = new Button("Next");
    Button Button6 = new Button("Next");
    Button Button7 = new Button("Next");
    Button Button8 = new Button("Next");
    Button Button9 = new Button("Next");
    Button Button10 = new Button("Next");
    Button Button11 = new Button("Next");
    Button Button12 = new Button("Next");
    Button Button13 = new Button("Next");
    Button Button14 = new Button("Next");
    Button Button15 = new Button("Next");
    
    
    //Global creation of game variables 
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
    boolean reroll;
    Player left1;
    Player right1;
    Player left2;
    Player right2;
    Player left3;
    Player right3;
    
    //Global creation of game elements
    ArrayList<Character_Cards> char_cards = new ArrayList();
    ArrayList<Dice> dice = new ArrayList();
    ArrayList<Role_Cards> role_cards = new ArrayList();
    Dice d1 = new Dice(2, 0, "Indian Arrow", "Dynamite", "Duel", "Duel", "Whiskey", "Gatling");//LOOK AT ME DICE
    Dice d2 = new Dice(2, 0, "Indian Arrow", "Dynamite", "Duel", "Duel", "Whiskey", "Gatling");//LOOK AT ME DICE
    Dice d3 = new Dice(0, 0, "Indian Arrow", "Dynamite", "Bull's Eye 1", "Bull's Eye 2", "Beer", "Gatling");
    Dice d4 = new Dice(0, 0, "Indian Arrow", "Dynamite", "Bull's Eye 1", "Bull's Eye 2", "Beer", "Gatling");
    Dice d5 = new Dice(0, 0, "Indian Arrow", "Dynamite", "Bull's Eye 1", "Bull's Eye 2", "Beer", "Gatling");
    Player human = new Player("NULL",0,"NULL",false);
    Player ai1 = new Player("NLUL", 0, "NULL", true);
    Player ai2 = new Player("NLUL", 0, "NULL", true);
    Player ai3 = new Player("NLUL", 0, "NULL", true);
    Player ai4 = new Player("NLUL", 0, "NULL", true);
    Player ai5 = new Player("NLUL", 0, "NULL", true);
    Player ai6 = new Player("NLUL", 0, "NULL", true);
    Player ai7 = new Player("NLUL", 0, "NULL", true);


    ArrayList<Player> play_order = new ArrayList();
    ArrayList<Player> temp_play_order = new ArrayList();
    
    //Scene scene1 = new Scene(group1, 1280, 720, Color.BEIGE);
    
    public static void main(String[] args)
    {
        // lauches the whole thing
        launch(args);
    }
    
    @Override
    public void start (Stage primaryStage) throws Exception
    {
        window = primaryStage;
        
        // load images
        Image img_table = new Image(new FileInputStream("src/bang/media/wood_TableTop.jpg"));
        ImageView table = new ImageView(img_table);
        //Image img_table2 = new Image(new FileInputStream("src/bang/media/wood_TableTop.jpg"));
        ImageView table2 = new ImageView(img_table);
        Image img_logo = new Image(new FileInputStream("src/bang/media/bang.png"));
        ImageView logo = new ImageView(img_logo);
        
        //Music
        Media media = new Media(this.getClass().getResource("/bang/media/background.mp3").toString());
        MediaPlayer music = new MediaPlayer(media);
        music.setVolume(.5);
        music.setAutoPlay(false);
        
        //set height and width of images
        table.setFitWidth(1280);
        table.setFitHeight(720);
        table2.setFitWidth(1280);
        table2.setFitHeight(720);
        logo.setFitWidth(540);
        logo.setFitHeight(260);
        
        //Text for new scene
        textMove(Line1, "Loading Computers...", 500, 100, 24);
        textMove(Line2, "", 500, 140, 24);
        textMove(Line3, "", 500, 180, 24);
        textMove(Line4, "", 500, 220, 24);
        textMove(Line5, "", 500, 260, 24);
        textMove(Line6, "", 500, 300, 24);
        textMove(Line7, "", 500, 340, 24);
        textMove(Line8, "", 500, 380, 24);
        textMove(Line9, "", 500, 420, 24);

        
        
        //set position of table image within window
        table.setX(5.75);
        table.setY(5.75);
        table2.setX(5.75);
        table2.setY(5.75);
        
        // text field for taking user name input
        
        playerName.setFont(Font.font("Verdana", FontWeight.BOLD, 24));
        //playerName.setMinSize(125, 30);
        playerName.setAlignment(Pos.CENTER);
        playerName.setLayoutX(700);
        playerName.setLayoutY(350);
        
        // label and dropdown menu for selecting number of players (defaults to 4)
        Label label_numPlayers = new Label("Number of Players: ");
        label_numPlayers.setAlignment(Pos.CENTER);
        label_numPlayers.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        label_numPlayers.setLayoutX(700);
        label_numPlayers.setLayoutY(420);
        
        
        numPlayers.getItems().add(4);
        numPlayers.getItems().add(5);
        numPlayers.getItems().add(6);
        numPlayers.getItems().add(7);
        numPlayers.getItems().add(8);
        numPlayers.getSelectionModel().select(0);
        numPlayers.setLayoutX(925);
        numPlayers.setLayoutY(420);
        
        // Music check box
        cb1 = new CheckBox("Music in Game");
        cb1.setSelected(true);
        cb1.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
        cb1.setLayoutX(700);
        cb1.setLayoutY(460);
        
        
        // start button & Action
        Button startButton = new Button("Start!");
        startButton.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
        startButton.setLayoutX(850);
        startButton.setLayoutY(490);
        startButton.setOnAction(e -> {
            lines.add(Line2);
            lines.add(Line3);
            lines.add(Line4);
            lines.add(Line5);
            lines.add(Line6);
            lines.add(Line7);
            lines.add(Line8);
            lines.add(Line9);
            lines.add(main1);
            lines.add(main2);
            lines.add(main3);
            lines.add(main4);
            lines.add(main5);
            lines.add(main6);
            lines.add(main7);
            lines.add(main8);
            checkBoxes.add(c1);
            checkBoxes.add(c2);
            checkBoxes.add(c3);
            checkBoxes.add(c4);
            checkBoxes.add(c5);
            checkBoxes.add(c6);
            checkBoxes.add(c7);
            checkBoxes.add(c8);
            if(cb1.isSelected()){
                music.setAutoPlay(true);
            }
            window.setScene(scene2);
            window.show();
               
            go1();
            //BANG.setPlayers(((int) numPlayers.getValue()) - 1, Updates);
            //System.out.println(playerName.getText());
            //System.out.println(numPlayers.getValue());
        });
        
        // button & Action
        nextButton = new Button("Next");
        nextButton.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
        nextButton.setLayoutX(1100);
        nextButton.setLayoutY(600);
        nextButton.setOnAction(d -> {
            //Move player texts
            for(int i = 0; i< lines.size(); i += 2){

                lines.get(i).setLayoutX(20);
                lines.get(i).setLayoutY((i+1) * 20);
                lines.get(i).setFont(Font.font("Verdana", FontWeight.BOLD, 18));
                lines.get(i+1).setLayoutX(20);
                lines.get(i+1).setLayoutY((int)lines.get(i).getLayoutY() + 16);
                lines.get(i+1).setFont(Font.font("Verdana", FontWeight.BOLD, 18));

                if((i < (players+1)*2) && temp_play_order.get((i+1)/2).shown && (i+1)%2 == 1){
                    lines.get(i).setText(temp_play_order.get((i+1)/2).name + "(" + temp_play_order.get((i+1)/2).role + ")");
                    lines.get(i+1).setText("HP: " + temp_play_order.get((i+1)/2).health + " Arrows: " + temp_play_order.get((i+1)/2).arrows);
                }
                else if(i < ((players+1)*2) && (i+1)%2 == 1){
                    lines.get(i).setText(temp_play_order.get((i+1)/2).name + "(Unknown)");
                    lines.get(i+1).setText("HP: " + temp_play_order.get((i+1)/2).health + " Arrows: " + temp_play_order.get((i+1)/2).arrows);
                }
            }
               
                
             // group all the above together
             if(play_order.get(0).name.equals("Sid Ketchum")){
                Group group3 = new Group();
                group3.getChildren()
                    .addAll(table2, Button2, Line1, Line2, Line3, Line4, Line5, Line6, Line7, Line8, Line9, main1, main2, main3, main4, main5, main6, main7, main8);
                scene3 = new Scene(group3, 1280, 720, Color.BEIGE);  
             }
             else{
                Group group3 = new Group();
                group3.getChildren()
                    .addAll(table2, Button3, Line1, Line2, Line3, Line4, Line5, Line6, Line7, Line8, Line9, main1, main2, main3, main4, main5, main6, main7, main8);
                scene3 = new Scene(group3, 1280, 720, Color.BEIGE);
             }
            
            window.setScene(scene3);
            window.show();
            Line1.setText(play_order.get(0).name + ", you are up!");
            
        });
        // button & Action With Sid K
        Button2 = new Button("Next");
        Button2.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
        Button2.setLayoutX(1100);
        Button2.setLayoutY(600);
        Button2.setOnAction(f -> {
             // group all the above together
            Group group = new Group();
            group.getChildren()
                    .addAll(table2, Button3, Line1, Line2, Line3, Line4, Line5, Line6, Line7, Line8, Line9, main1, main2, main3, main4, main5, main6, main7, main8,
                            c1, c2, c3, c4, c5, c6, c7, c8);
            scene4 = new Scene(group, 1280, 720, Color.BEIGE);
            window.setScene(scene4);
            window.show();
            for(int i = 0; i < checkBoxes.size(); i++){
                if(i < play_order.size()){
                    checkBoxes.get(i).setLayoutX(500);
                    checkBoxes.get(i).setLayoutY(300 + (i*50));
                    checkBoxes.get(i).setDisable(false); 
                }
                else{
                    checkBoxes.get(i).setLayoutX(500);
                    checkBoxes.get(i).setLayoutY(300 + (i*50));
                    checkBoxes.get(i).setDisable(true); 
                }
                
            }
            Line1.setText(play_order.get(0).name + ", who do you want to heal?");
            c1.setOnAction(eh2);
            c2.setOnAction(eh2);
            c3.setOnAction(eh2);
            c4.setOnAction(eh2);
            c5.setOnAction(eh2);
            c6.setOnAction(eh2);
            c7.setOnAction(eh2);

        });
        // button & Action Without Sid K
        Button3 = new Button("Next");
        Button3.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
        Button3.setLayoutX(1100);
        Button3.setLayoutY(600);
        Button3.setOnAction(f -> {

             // group all the above together
            Group group = new Group();
            group.getChildren()
                    .addAll(table2, Button4, Line1, Line2, Line3, Line4, Line5, Line6, Line7, Line8, Line9, main1, main2, main3, main4, main5, main6, main7, main8, 
                            c1, c2, c3, c4, c5, c6, c7);
            scene5 = new Scene(group, 1280, 720, Color.BEIGE);
            window.setScene(scene5);
            window.show();
            Line1.setText("Pick the dice you want to use: ");
            for(int i = 0; i < 7; i++){
                checkBoxes.get(i).setLayoutX((i*100) + 400);
                checkBoxes.get(i).setLayoutY(400);
                if(i < 4){
                    checkBoxes.get(i).setSelected(true);
                    checkBoxes.get(i).setDisable(true);
                }
            }
            c5.setOnAction(eh);
            c6.setOnAction(eh);
            c7.setOnAction(eh);
        });
        // REROLL SCENE
        Button4 = new Button("Next");
        Button4.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
        Button4.setLayoutX(1100);
        Button4.setLayoutY(600);
        Button4.setOnAction(f -> {
            go3();
             // group all the above together
            Group group = new Group();
            group.getChildren()
                    .addAll(table2, Button4, Button5, Line1, Line2, Line3, Line4, Line5, Line6, Line7, Line8, Line9, main1, main2, main3, main4, main5, main6, main7, main8, 
                            c1, c2, c3, c4, c5, c6, c7);
            scene5 = new Scene(group, 1280, 720, Color.BEIGE);
            window.setScene(scene5);
            window.show();
            Line1.setText("Pick the dice you want to Re-Roll: ");
            for(int i = 0; i < 5; i++){
                checkBoxes.get(i).setLayoutX((i*100) + 400);
                checkBoxes.get(i).setLayoutY(400);
                if(dice.get(i).sides[dice.get(i).side].equals("Dynamite")){
                    checkBoxes.get(i).setSelected(false);
                    checkBoxes.get(i).setDisable(true);
                }
                else{
                    checkBoxes.get(i).setSelected(false);
                    checkBoxes.get(i).setDisable(false);
                }
            }
            
        });
        
        
        
        
       
        
        
        // group all the above together
        Group group1 = new Group();
        group1.getChildren()
                .addAll(table, logo, playerName, numPlayers, label_numPlayers,
                        startButton, cb1);
        
        // group all the above together
        Group group2 = new Group();
        group2.getChildren()
                .addAll(table2, nextButton, Line1, Line2, Line3, Line4, Line5, Line6, Line7, Line8, Line9, main1, main2, main3, main4, main5, main6, main7, main8);
       

        
        
        
        // display the stuff; window size, icon, title
        //Scene1
        scene1 = new Scene(group1, 1280, 720, Color.BEIGE);
        window.getIcons().add(img_logo);
        window.setTitle("BANG! Dice Game");
        window.setResizable(false);
        window.setScene(scene1);
        window.show();
        
        //Scene2
        scene2 = new Scene(group2, 1280, 720, Color.BEIGE);
        

        
    }
    
    public void textMove(Label line, String text, int x, int y, int fontSize){
        line.setText(text);
        line.setLayoutX(x);
        line.setLayoutY(y);
        line.setFont(Font.font("Verdana", FontWeight.BOLD, fontSize));
    }
    
    EventHandler eh = new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent event) {
        if (event.getSource() instanceof CheckBox) {
            if (c5.isSelected()) {
                c7.setDisable(true);
                c6.setDisable(true);
                dice.remove(d5);
                d5 = new Dice(0, 0, "Indian Arrow", "Dynamite", "Bull's Eye 1", "Bull's Eye 2", "Beer", "Gatling"); //regular die
                dice.add(d5);
            } 
            else if(c6.isSelected()){
                c7.setDisable(true);
                c5.setDisable(true);
                dice.remove(d5);
                d5 = new Dice(1, 0, "Indian Arrow", "Dynamite", "Double Bull's Eye 1", "Double Bull's Eye 2", "Bullet", "Double Gatling"); //LOUDMOUTH
                dice.add(d5);
            }
            else if(c7.isSelected()){
                c5.setDisable(true);
                c6.setDisable(true);
                dice.remove(d5);
                d5 = new Dice(1, 0, "Broken Indian Arrow", "Dynamite", "Bull's Eye 1", "Indian Arrow", "Double Beer", "Beer"); //COWARD
                dice.add(d5);
            }
            else {
                for(int i = 0; i < 3; i ++){
                    checkBoxes.get(i+4).setDisable(false);
                }
                dice.remove(d5);
                d5 = new Dice(0, 0, "Indian Arrow", "Dynamite", "Bull's Eye 1", "Bull's Eye 2", "Beer", "Gatling"); //regular die
                dice.add(d5);    
            }
            
        }
    }
    };
    
    EventHandler eh2 = new EventHandler<ActionEvent>() {    
    @Override
    public void handle(ActionEvent event) {
        if (event.getSource() instanceof CheckBox) {
            for(int j = 0; j < checkBoxes.size(); j++){
                if (checkBoxes.get(j).isSelected()) {
                    for(int i = 0; i < checkBoxes.size(); i ++){
                        checkBoxes.get(i).setDisable(true);
                        if(checkBoxes.get(i) == checkBoxes.get(j)){
                           checkBoxes.get(i).setDisable(false); 
                        }
                    }
                } 
                else {
                    for(int i = 0; i < checkBoxes.size(); i ++){
                        checkBoxes.get(i).setDisable(false);
                    }

                }
            }
            
        }
    }
    };
    
    public void go1(){
        players = (int)numPlayers.getValue() - 1; 
            //Create character cards, dice, and role cards
        
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
        
        
        
        dice.add(d1);
        dice.add(d2);
        dice.add(d3);
        dice.add(d4);
        dice.add(d5);
        
        

        
        scan = new Scanner(System.in);
        boolean test = false;
        Random rand = new Random();
        
        

            switch(players){
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
            switch(players){
                case 7:
                    ai7 = new Player(char_cards.get(7).name, char_cards.get(7).hp, role_cards.get(7).role, true);
                case 6:
                    ai6 = new Player(char_cards.get(6).name, char_cards.get(6).hp, role_cards.get(6).role, true);
                case 5:
                    ai5 = new Player(char_cards.get(5).name, char_cards.get(5).hp, role_cards.get(5).role, true);
                case 4:
                    ai4 = new Player(char_cards.get(4).name, char_cards.get(4).hp, role_cards.get(4).role, true);
                case 3:
                    human = new Player(char_cards.get(0).name, char_cards.get(0).hp, role_cards.get(0).role, false); //MAKE THIS TRUE TO LET AI DO ALL THE PLAYING
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
        
        
        if(players != 2){
            for(int i = 0; i < 16; i++){
                if(!(temp_play_order.get(i%8).role.equals("NULL"))){
                    if(sher == true){
                        if(i%8 == stop){
                            break;
                        }
                        else{
                            play_order.add(temp_play_order.get(i%8));
                        }
                    }
                    if(sher == false){
                      if(temp_play_order.get(i%8).role.equals("Sheriff")){
                        temp_play_order.get(i%8).setMaxHealth(temp_play_order.get(i%8).maxHealth + 2);
                        temp_play_order.get(i%8).heal(2);
                        temp_play_order.get(i%8).shown = true;
                        play_order.add(temp_play_order.get(i%8));
                        stop = i;
                        sher = true;
                        }  
                    }

                }
            }
        }
        else{
            for(int i = 0; i < 16; i++){
                if(!(temp_play_order.get(i%8).role.equals("NULL"))){
                    if(sher == true){
                        if(i%8 == stop){
                            break;
                        }
                        else{
                            temp_play_order.get(i%8).shown = true;
                            play_order.add(temp_play_order.get(i%8));
                        }
                    }
                    if(sher == false){
                      if(temp_play_order.get(i%8).role.equals("Deputy")){
                        temp_play_order.get(i%8).shown = true;
                        play_order.add(temp_play_order.get(i%8));
                        stop = i;
                        sher = true;
                        }  
                    }

                }
            }
        }
        System.out.println("The play order is: ");
        for(int j = 0; j < play_order.size(); j++){
            System.out.println((j+1) + ") " + play_order.get(j).name);
        }
        System.out.println("_________________________________________________________");
        
        
        
        boolean reroll;
        ArrayList<Integer> list = new ArrayList();
        
        
        int total_players = play_order.size();
        
        try{
            Line1.setText("LET'S PLAY!!!");
            TimeUnit.SECONDS.sleep(3);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
        for(int i = 0; i < play_order.size(); i++){
            if(play_order.get(i).computer == false){
                play_order.get(i).name = playerName.getText();
            }
        }
            Line1.setText("Playing turn:");
            Line2.setText("1) " + play_order.get(0).name);
            Line3.setText("2) " + play_order.get(1).name);
            Line4.setText("3) " + play_order.get(2).name);
            Line5.setText("4) " + play_order.get(3).name);
            if(play_order.size() > 4){
                Line6.setText("5) " + play_order.get(4).name);
            }
            if(play_order.size() > 5){
                Line7.setText("6) " + play_order.get(5).name);
            }
            if(play_order.size() > 6){
                Line8.setText("7) " + play_order.get(6).name);
            }
            if(play_order.size() > 7){
                Line9.setText("8) " + play_order.get(7).name);
            }
    }
    
    public void go2(){
        left1 = play_order.get(1);
        right1 = play_order.get(play_order.size()-1);
        try{
            left2 = play_order.get(2);
        }
        catch (Exception a){
            left2 = play_order.get(0);
        }
        try{
            left3 = play_order.get(3);
        }
        catch (Exception a){
            left3 = play_order.get(0);
        }
        try{
            right2 = play_order.get(play_order.size()-2);
        }
        catch (Exception a){
            right2 = play_order.get(0);
        }
        try{
            right3 = play_order.get(play_order.size()-3);
        }
        catch (Exception a){
            right3 = play_order.get(0);
        }
        
    }
    
    public void go3(){
        for(int roll = 0; roll < 5; roll++){
            dice.get(roll).roll();
        }
        dynamite = 0;
        reroll = false;
        System.out.println("Roll results:");
        System.out.println("Dice 1 : " + d1.sides[d1.side]);
        System.out.println("Dice 2 : " + d2.sides[d2.side]);
        System.out.println("Dice 3 : " + d3.sides[d3.side]);
        System.out.println("Dice 4 : " + d4.sides[d4.side]);
        System.out.println("Dice 5 : " + d5.sides[d5.side]);
        for(int i = 0; i < 5; i++){
            if(dice.get(i).sides[dice.get(i).side].equals("Dynamite")){
                dynamite++;
            }
            if(dice.get(i).sides[dice.get(i).side].equals("Indian Arrow")){
                //ADD ARROW PICS HERE AND ALLOW USER TO CHOOSE WHICH ARROW THEY WANT!
                play_order.get(0).addArrow(1);
                if(arrow == 0){
                    BANG.indianAttack(play_order);
                }
            }
            if(dice.get(i).sides[dice.get(i).side].equals("Broken Indian Arrow")){
                play_order.get(0).removeArrow(1);
            }
            if(dice.get(i).sides[dice.get(i).side].equals("Bullet")){
                play_order.get(0).damage(1);
            }
        }
        for(int roll = 0; roll < 5; roll++){
            if(dynamite >= 3){
                break;
            }
            if(dice.get(roll).sides[dice.get(roll).side].equals("Dynamite") && play_order.get(0).name.equals("Belle Star")){
                //Turn this dice into gatling gun if yes button pressed(need to make yes nutton)
            }
            else if(!(dice.get(roll).sides[dice.get(roll).side].equals("Dynamite")) || play_order.get(0).dynamiteReroll == true){

            }
        }
    }
    
}
