/*
 * Ryan Browning
 * CS 2365-001
 * Project 3
 * Spring 2020
 * This file implements a GUI using JavaFX.
 */

package bang;

// imports galore
import static bang.BANG.deathSeq;
import java.util.*;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.event.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextFormatter.*;
import java.util.function.UnaryOperator;
import javafx.scene.text.FontPosture;

public class Bang_fxGUI extends Application {

    //Stage for the window, scenes for all of our scnees(could really just use one)
    Stage window;
    Scene scene1, scene2, scene3, scene4, scene5;
    

    //All images, and the Views that will be used for dice
    Image Img_arrow;
    Image Img_BE1;
    Image Img_BE2;
    Image Img_Beer;
    Image Img_BrokenArrow;
    Image Img_Bullet;
    Image Img_DBE1;
    Image Img_DBE2;
    Image Img_DBeer;
    Image Img_DGatling;
    Image Img_Duel;
    Image Img_Dynamite;
    Image Img_Gatling;
    Image Img_Whiskey;
    Image Img_Loud;
    Image Img_Coward;
    Image Img_Reg;
    Image Img_Black;
    Image img_logo;
    Image img_gif;
    ImageView logo;
    ImageView dice01;
    ImageView dice02;
    ImageView dice03;
    ImageView dice04;
    ImageView dice05;
    ImageView dice06;
    ImageView dice07;
    ImageView table2;
    ImageView dice1;
    ImageView dice2;
    ImageView dice3;
    ImageView dice4;
    ImageView dice5;
    ImageView dice6;
    
    //Media and mediaplayer for our music that we have in the background
    Media media;
    MediaPlayer music;
    
    //Slider used for music volume at the beginning of the game
    Slider musicSlider;
   
    //All Labels/Texts used for characters, prompts, and menu options
    Label Line1 = new Label("");
    Label Line2 = new Label("");
    Label Line3 = new Label("");
    Label Line4 = new Label("");
    Label Line5 = new Label("");
    Label Line6 = new Label("");
    Label Line7 = new Label("");
    Label Line8 = new Label("");
    Label Line9 = new Label("Volume: ");
    Label main1 = new Label("");
    Label main2 = new Label("");
    Label main3 = new Label("");
    Label main4 = new Label("");
    Label main5 = new Label("");
    Label main6 = new Label("");
    Label main7 = new Label("");
    Label main8 = new Label("");
    Label volumeText = new Label("");
    
    //Textfield used to get the name of the player to make it feel more involved
    TextField playerName = new TextField("Enter Name");
    
    //Checkboxes used for characters, music, and dice selection
    ComboBox numPlayers = new ComboBox();
    CheckBox cb1 = new CheckBox("Music in Game");
    CheckBox c1 = new CheckBox("Old Saloon Die");
    CheckBox c2 = new CheckBox("Old Saloon Die");
    CheckBox c3 = new CheckBox("Regular Die");
    CheckBox c4 = new CheckBox("Regular Die");
    CheckBox c5 = new CheckBox("Regular Die");
    CheckBox c6 = new CheckBox("Loudmouth Die");
    CheckBox c7 = new CheckBox("Coward Die");
    CheckBox cd1 = new CheckBox();
    CheckBox cd2 = new CheckBox();
    CheckBox cd3 = new CheckBox();
    CheckBox cd4 = new CheckBox();
    CheckBox cd5 = new CheckBox();
    CheckBox cd6 = new CheckBox();
    CheckBox nc1 = new CheckBox("");
    CheckBox nc2 = new CheckBox("");
    CheckBox nc3 = new CheckBox("");
    CheckBox nc4 = new CheckBox("");
    CheckBox nc5 = new CheckBox("");
    CheckBox nc6 = new CheckBox("");
    CheckBox nc7 = new CheckBox("");
    CheckBox nc8 = new CheckBox("");
    CheckBox slab = new CheckBox("Double Damage");
    
    //Buttons for different stages, rerolling, and game options
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
    Button TTG1 = new Button("Turn to \nGatling");
    Button TTG2 = new Button("Turn to \nGatling");
    Button TTG3 = new Button("Turn to \nGatling");
    Button TTG4 = new Button("Turn to \nGatling");
    Button TTG5 = new Button("Turn to \nGatling");
    Button ChiefArrowButton = new Button("Take the \nChief Arrow");
    
    //All of the ArrayLists used in the game for characters, checkboxes, dice, and game options
    ArrayList<Button> TTG = new ArrayList();
    ArrayList<Button> next = new ArrayList();
    ArrayList<ImageView> IV = new ArrayList();
    ArrayList<Label> lines = new ArrayList();
    ArrayList<CheckBox> checkBoxes = new ArrayList();
    ArrayList<CheckBox> checkBoxes2 = new ArrayList();
    ArrayList<CheckBox> nameCheckBoxes = new ArrayList();
    ArrayList<Integer> list = new ArrayList();
    ArrayList<Character_Cards> char_cards = new ArrayList();
    ArrayList<Dice> dice = new ArrayList();
    ArrayList<Role_Cards> role_cards = new ArrayList();
    static ArrayList<Player> play_order = new ArrayList();
    static ArrayList<Player> temp_play_order = new ArrayList();
    static ArrayList<UndeadCard> undeadCards = new ArrayList();
    static ArrayList<Player> temp_play_order2 = new ArrayList();
    
    //Global creation of game variables
    //All of the intergers(static and non-static)
    int Gat = 0;
    int BE1 = 0;
    int BE2 = 0;
    int DBE1 = 0;
    int DBE2 = 0;
    int duel = 0;
    int temp = 0;
    int Beer = 0;
    int rolls = 0;
    int temp2 = 0;
    int stage = 0;
    int total = 0;
    int total2 = 0;
    int dynamite = 0;
    static int players;
    static int arrow = 10;
    static int turnDead = 0;
    static int undeadTotal = 0;
    
    //All of the Booleans(static and non-static)
    boolean test;
    boolean reroll;
    boolean Slab = false;
    boolean gringo = false;
    boolean gatAttack = false;
    static boolean zombieS = false;
    static boolean chiefArrow = true;
    
    //Dictionary used to hold all the roll values later used for the AI functions
    Dictionary diceOutcome= new Hashtable<String,Integer>();
    
    //Player objects created for easier placesments and temp player holds
    Player left1;
    Player right1;
    Player left2;
    Player right2;
    Player left3;
    Player right3;
    Player current;
    Player tempP;
    Player pick = new Player("NULL", 99, "NULL", true);
    Player temp_player = new Player("NULL", 99, "Temp_role", true);
    
    //Creation of dice, Players, and undead cards
    Dice d1 = new Dice(2, 0, "Indian Arrow", "Dynamite", "Duel", "Duel",
            "Whiskey", "Gatling");                                              //LOOK AT ME DICE
    Dice d2 = new Dice(2, 0, "Indian Arrow", "Dynamite", "Duel", "Duel",
            "Whiskey", "Gatling");                                              //LOOK AT ME DICE
    Dice d3 = new Dice(0, 0, "Indian Arrow", "Dynamite", "Bull's Eye 1",
            "Bull's Eye 2", "Beer", "Gatling");                                 //Regular Dice
    Dice d4 = new Dice(0, 0, "Indian Arrow", "Dynamite", "Bull's Eye 1",
            "Bull's Eye 2", "Beer", "Gatling");                                 //Regular Dice
    Dice d5 = new Dice(0, 0, "Indian Arrow", "Dynamite", "Bull's Eye 1",
            "Bull's Eye 2", "Beer", "Gatling");                                 //Regular Dice
    Dice d6 = new Dice(0, 0, "Indian Arrow", "Dynamite", "Bull's Eye 1",
            "Bull's Eye 2", "Beer", "Gatling");                                 //Regular Dice
    Player human = new Player("NULL", 0, "NULL", false);
    Player ai1 = new Player("NULL", 0, "NULL", true);
    Player ai2 = new Player("NULL", 0, "NULL", true);
    Player ai3 = new Player("NULL", 0, "NULL", true);
    Player ai4 = new Player("NULL", 0, "NULL", true);
    Player ai5 = new Player("NULL", 0, "NULL", true);
    Player ai6 = new Player("NULL", 0, "NULL", true);
    Player ai7 = new Player("NULL", 0, "NULL", true);
    UndeadCard u1 = new UndeadCard(0);
    UndeadCard u2 = new UndeadCard(0);
    UndeadCard u3 = new UndeadCard(0);
    UndeadCard u4 = new UndeadCard(1);
    UndeadCard u5 = new UndeadCard(1);
    UndeadCard u6 = new UndeadCard(1);
    UndeadCard u7 = new UndeadCard(1);
    UndeadCard u8 = new UndeadCard(1);
    UndeadCard u9 = new UndeadCard(2);
    UndeadCard u10 = new UndeadCard(2);
    UndeadCard u11 = new UndeadCard(2);
    
    //Start of the GUI to call the launch
    public static void main(String[] args) {
        launch(args);
    }

    //Start GUI that is called
    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;

        // load images(non-dice)[logo, table, etc.]
        Image img_table = new Image(new FileInputStream(
                "src/bang/media/wood_TableTop.jpg"));
        img_gif = new Image(new FileInputStream("src/bang/media/coffin.gif"));
        img_logo = new Image(new FileInputStream("src/bang/media/bang.png"));
        ImageView table = new ImageView(img_table);
        table2 = new ImageView(img_table);
        logo = new ImageView(img_logo);
        
        
        //Load Images(dice)
        Img_arrow = new Image(new FileInputStream(
                "src/bang/media/Dice/arrow.PNG"));
        Img_BE1 = new Image(new FileInputStream(
                "src/bang/media/Dice/BE1.PNG"));
        Img_BE2 = new Image(new FileInputStream(
                "src/bang/media/Dice/BE2.PNG"));
        Img_Beer = new Image(new FileInputStream(
                "src/bang/media/Dice/Beer.PNG"));
        Img_BrokenArrow = new Image(new FileInputStream(
                "src/bang/media/Dice/BrokenArrow.PNG"));
        Img_Bullet = new Image(new FileInputStream(
                "src/bang/media/Dice/Bullet.PNG"));
        Img_DBE1 = new Image(new FileInputStream(
                "src/bang/media/Dice/DBE1.PNG"));
        Img_DBE2 = new Image(new FileInputStream(
                "src/bang/media/Dice/DBE2.PNG"));
        Img_DBeer = new Image(new FileInputStream(
                "src/bang/media/Dice/DBeer.PNG"));
        Img_DGatling = new Image(new FileInputStream(
                "src/bang/media/Dice/DGatling.PNG"));
        Img_Duel = new Image(new FileInputStream(
                "src/bang/media/Dice/Duel.PNG"));
        Img_Dynamite = new Image(new FileInputStream(
                "src/bang/media/Dice/Dynamite.PNG"));
        Img_Gatling = new Image(new FileInputStream(
                "src/bang/media/Dice/Gatling.PNG"));
        Img_Whiskey = new Image(new FileInputStream(
                "src/bang/media/Dice/Whiskey.PNG"));
        Img_Black = new Image(new FileInputStream(
                "src/bang/media/Dice/B1.PNG"));
        Img_Reg = new Image(new FileInputStream(
                "src/bang/media/Dice/d1.PNG"));
        Img_Loud = new Image(new FileInputStream(
                "src/bang/media/Dice/Loud.PNG"));
        Img_Coward = new Image(new FileInputStream(
                "src/bang/media/Dice/Coward.PNG"));
        dice1 = new ImageView(Img_arrow);
        dice2 = new ImageView(Img_BE1);
        dice3 = new ImageView(Img_BE2);
        dice4 = new ImageView(Img_Beer);
        dice5 = new ImageView(Img_BrokenArrow);
        dice6 = new ImageView(Img_Bullet);
        dice01 = new ImageView(Img_Black);
        dice02 = new ImageView(Img_Black);
        dice03 = new ImageView(Img_Reg);
        dice04 = new ImageView(Img_Reg);
        dice05 = new ImageView(Img_Reg);
        dice06 = new ImageView(Img_Loud);
        dice07 = new ImageView(Img_Coward);
        
        //Music Creation
        media = new Media(this.getClass().getResource(
                "/bang/media/background.mp3").toString());
        music = new MediaPlayer(media);
        music.setAutoPlay(true);
        musicSlider = new Slider(0, 1, .2);
        music.setVolume(musicSlider.getValue());
        musicSlider.setLayoutX(700);
        musicSlider.setLayoutY(525);
        musicSlider.setMinWidth(350);
        musicSlider.setMaxWidth(350);
        musicSlider.valueProperty().addListener(new ChangeListener<Number>(){
            @Override
            public void changed(
            ObservableValue<? extends Number> observableValue, 
            Number oldValue, 
            Number newValue){ 
               music.setVolume(musicSlider.getValue());
            }
        });
        
        //set height and width of images
        table.setFitWidth(1280);
        table.setFitHeight(720);
        table2.setFitWidth(1280);
        table2.setFitHeight(720);
        logo.setFitWidth(540);
        logo.setFitHeight(260);

        //Text for new scene
        textMove(Line1, "Loading Computers...", 400, 100, 24);
        textMove(Line2, "", 400, 140, 24);
        textMove(Line3, "", 400, 180, 24);
        textMove(Line4, "", 400, 220, 24);
        textMove(Line5, "", 400, 260, 24);
        textMove(Line6, "", 400, 300, 24);
        textMove(Line7, "", 400, 340, 24);
        textMove(Line8, "", 400, 380, 24);

        //set position of table image within window
        table.setX(5.75);
        table.setY(5.75);
        table2.setX(5.75);
        table2.setY(5.75);

        // text field for taking user name input
        playerName.setFont(Font.font("Verdana", FontWeight.BOLD, 24));
        playerName.setAlignment(Pos.CENTER);
        playerName.setLayoutX(700);
        playerName.setLayoutY(350);
        UnaryOperator<Change> modifyChange = c -> {
            if (c.isContentChange()) {
                int newLength = c.getControlNewText().length();
                if (newLength > 20) {
                    String tail = c.getControlNewText().substring(0, 20);
                    c.setText(tail);
                    int oldLength = c.getControlText().length();
                    c.setRange(0, oldLength);
                }
            }
            return c;
        };
        playerName.setTextFormatter(new TextFormatter(modifyChange));

        //Label and dropdown menu for selecting number of players
        Label label_numPlayers = new Label("Number of Players: ");
        label_numPlayers.setAlignment(Pos.CENTER);
        label_numPlayers.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        label_numPlayers.setLayoutX(700);
        label_numPlayers.setLayoutY(420);

        //Dropdown box with number of players selection
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
        cb1.selectedProperty().addListener((ObservableValue
                <? extends Boolean> observable, Boolean oldValue,
                Boolean newValue) -> {
            if(cb1.isSelected()){
                musicSlider.setValue(.2);
                music.setVolume(.2);
            }
            else{
                musicSlider.setValue(0);
                music.setVolume(0);
            }
            
        });
        
        // start button & Action from main menu
        Button startButton = new Button("Start!");
        startButton.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
        startButton.setLayoutX(700);
        startButton.setLayoutY(550);
        startButton.setMinWidth(350);
        startButton.setMaxWidth(350);
        startButton.setOnAction(e -> {
            textMove(Line9, "", 400, 420, 24);
            
            //Add the labels to their ArrayList
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
            
            //Add the Checkboxes to their ArrayList
            checkBoxes.add(c1);
            checkBoxes.add(c2);
            checkBoxes.add(c3);
            checkBoxes.add(c4);
            checkBoxes.add(c5);
            checkBoxes.add(c6);
            checkBoxes.add(c7);
            checkBoxes2.add(cd1);
            checkBoxes2.add(cd2);
            checkBoxes2.add(cd3);
            checkBoxes2.add(cd4);
            checkBoxes2.add(cd5);
            checkBoxes2.add(cd6);
            nameCheckBoxes.add(nc1);
            nameCheckBoxes.add(nc2);
            nameCheckBoxes.add(nc3);
            nameCheckBoxes.add(nc4);
            nameCheckBoxes.add(nc5);
            nameCheckBoxes.add(nc6);
            nameCheckBoxes.add(nc7);
            nameCheckBoxes.add(nc8);
            
            //Add dice imageViews to their ArrayList
            IV.add(dice1);
            IV.add(dice2);
            IV.add(dice3);
            IV.add(dice4);
            IV.add(dice5);
            IV.add(dice6);
            
            //Add the different possibilites to the Dictionary
            diceOutcome.put("Indian Arrow", 0);
            diceOutcome.put("Dynamite", 0);
            diceOutcome.put("Duel", 0);
            diceOutcome.put("Whiskey", 0);
            diceOutcome.put("Gatling", 0);
            diceOutcome.put("Bull's Eye 1", 0);
            diceOutcome.put("Bull's Eye 2", 0);
            diceOutcome.put("Beer", 0);
            diceOutcome.put("Double Bull's Eye 1", 0);
            diceOutcome.put("Double Bull's Eye 2", 0);
            diceOutcome.put("Double Gatling", 0);
            diceOutcome.put("Bullet", 0);
            diceOutcome.put("Broken Indian Arrow", 0);
            diceOutcome.put("Double Beer", 0);
            
            //Add Gameoption buttons to their ArrayList
            TTG.add(TTG1);
            TTG.add(TTG2);
            TTG.add(TTG3);
            TTG.add(TTG4);
            TTG.add(TTG5);
            
            //Add all the next scene buttons to their ArrayList
            next.add(Button2);
            next.add(Button3);
            next.add(Button5);
            next.add(Button6);
            next.add(Button7);
            next.add(Button8);
            next.add(Button9);
            next.add(Button10);
            next.add(Button11);
            next.add(Button12);
            next.add(Button13);
            next.add(Button14);
            next.add(Button15);
            
            //Add all the Undead Cards to their ArrayList
            undeadCards.add(u1);
            undeadCards.add(u2);
            undeadCards.add(u3);
            undeadCards.add(u4);
            undeadCards.add(u5);
            undeadCards.add(u6);
            undeadCards.add(u7);
            undeadCards.add(u8);
            undeadCards.add(u9);
            undeadCards.add(u10);
            undeadCards.add(u11);
            Collections.shuffle(undeadCards);                                   //Shuffles the cards to be random
            
            //Checkbox for Slabs ability Layout
            slab.setLayoutX(875);
            slab.setLayoutY(600);
            slab.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
            
            //Make every checkbox in the ArrayList to false
            for(int i = 0; i < checkBoxes.size(); i++){
                checkBoxes.get(i).setSelected(false);
            }
            
            //Format all buttons in the button ArrayList to have the same font, wording, and layout
            for(int j = 0; j < next.size(); j++){
                next.get(j).setText("Next");
                next.get(j).setFont(Font.font("Verdana", FontWeight.BOLD, 18));
                next.get(j).setLayoutX(1100);
                next.get(j).setLayoutY(600);
            }
            
            //set the main menu scene
            window.setScene(scene2);
            window.show();

            //Call the first game logic function
            go1();
            
            //Move the sheriff to first to go
            for(int i = 0; i < play_order.size() - 1; i++){
                play_order.add(play_order.get(0));
                play_order.remove(play_order.get(0));
            }
        });
        
        //Start of the round button
        nextButton.setOnAction(d -> {
            //Calls the action function
            action();
            
            //Sets round variables to their defualt values
            Slab = false;
            gringo = false;
            
            //Removes old 5th die and replaces it
            dice.remove(d5);
            d5 = new Dice(0, 0, "Indian Arrow", "Dynamite", "Bull's Eye 1",
                    "Bull's Eye 2", "Beer", "Gatling");
            dice.add(d5);
            
            //Resets dice to can re-roll state
            for(int i = 0; i < dice.size(); i++){
                dice.get(i).canRoll = true;
            }
            
            //Resets duel list
            temp_play_order2.clear();
            System.out.println(temp_play_order2.size());
            for(int j = 0; j < play_order.size(); j++){
               temp_play_order2.add(play_order.get(j)); 
            }
            
            //Makes dead players pull a card
            while(turnDead != 0){
                undeadTotal+= undeadCards.get(0).hand;                          //Adds card total to total hand value
                turnDead--;
                undeadCards.remove(undeadCards.get(0));                         //Removes card from 'deck'
            }
            
            //Checks for total number of zombie hands vs total alive players
            if(undeadTotal > play_order.size() && zombieS == false){            //If zombie hands is greater than number of players alive
                BANG.zombieStart();                                               //Call sombieStart function in BANG
                music.stop();                                                     //Stop the music
                media = new Media(this.getClass().getResource(
                        "/bang/media/Zombie.mp3").toString());                    //Change to zombie music for better atmosphere
                music = new MediaPlayer(media);                                   //Makes the song the new music
                music.play();                                                     //Plays the song
                musicSlider.setValue(.1);                                         //Sets the volume to low
                music.setVolume(musicSlider.getValue());                          //Set volume
                music.setCycleCount(100);                                         //Play 100 times so there is always music until the game ends
            }
            
            //Adds last player to the bottom of the ArrayList and next person's turn
            play_order.add(play_order.get(0));
            play_order.remove(0);
            
            //Debugging tool, Start of tun
            System.out.println("Start turn");
            
            //More variable value resets
            turnDead = 0;
            pick = temp_player;
            stage = 0;
            
            //Calls label update function
            updateCharacters();
            
            //cuurent(player object) for easier referencing 
            current = play_order.get(0);
            
            //calls go2 function
            go2();
            
            //Creates new group for next scene
            Group group3 = new Group();
            
            //Statement based on if Sid is current player or not
            if(current.name.equals("Sid Ketchum")){                             //If Sid is current player
                group3.getChildren()
                        .addAll(table2, Button2, Line1, Line2, Line3, Line4,
                                Line5, Line6, Line7, Line8, Line9, main1, main2,
                                main3, main4, main5, main6, main7, main8);        //Make the next button go to his scene
                scene3 = new Scene(group3, 1280, 720, Color.BEIGE);               //Set scene with this group made
            } 
            else {                                                              //If Sid is NOT the current player
                group3.getChildren()
                        .addAll(table2, Button3, Line1, Line2, Line3, Line4,
                                Line5, Line6, Line7, Line8, Line9, main1, main2,
                                main3, main4, main5, main6, main7, main8);        //Make the next utton go to dice selection scene
                scene3 = new Scene(group3, 1280, 720, Color.BEIGE);               //Ser scene with this group made
            }

            //Set the new scene and show it
            window.setScene(scene3);
            window.show();
            
            //Tell player(by their character name) they're up
            Line1.setText(current.name + ", you are up!");
        });
        
        //Button Action that leads to Sid's scene
        Button2.setOnAction(f -> {
            //Set the stage number to -1 so it won't interfere with later functions
            stage = -1;
            
            //Set a player object to pick so no NullPointers happen
            pick = new Player("NULL", 99, "NULL", true);
            
            //Make new group for Sid's scene
            Group group = new Group();
            group.getChildren().clear();
                group.getChildren() 
                    .addAll(table2, Button3, Line1, Line2, Line3, Line4,
                            Line5, Line6, Line7, Line8, Line9, main1, main2,
                            main3, main4, main5, main6, main7, main8,
                            nc1, nc2, nc3, nc4, nc5, nc6, nc7, nc8);            //Includes checkboxes with names
                
            //Make the scene with the new group
            scene4 = new Scene(group, 1280, 720, Color.BEIGE);
            
            //Set this scene as the new scene to show
            window.setScene(scene4);
            window.show();
            
            //Call the update label function
            updateCharacters();
            
            //Sets the format for the checkboxes
            for (int i = 0; i < nameCheckBoxes.size(); i++) {                   //For all the checkboxes for names
                if (i < play_order.size()) {                                      //If the index of the checkboxes is lower than the index of the characters
                    nameCheckBoxes.get(i).setLayoutX(500);                          //Layout X
                    nameCheckBoxes.get(i).setLayoutY(300 + (i * 50));               //Layout Y
                    nameCheckBoxes.get(i).setDisable(play_order.get(0)
                            .computer);                                             //Only enabled if current caracter is not a computer
                    nameCheckBoxes.get(i).setText(play_order.get(i).name);          //Set text to character's names
                    nameCheckBoxes.get(i).setFont(Font.font("Verdana",
                            FontWeight.BOLD, 24));                                  //Set font
                } 
                else {                                                            //If the index of the checkboxes is too high
                    nameCheckBoxes.get(i).setLayoutX(500);                          //Layout X
                    nameCheckBoxes.get(i).setLayoutY(300 + (i * 50));               //Layout Y
                    nameCheckBoxes.get(i).setDisable(true);                         //Always disabled
                    nameCheckBoxes.get(i).setText("");                              //No text
                    nameCheckBoxes.get(i).setFont(Font.font("Verdana",
                            FontWeight.BOLD, 24));                                  //Set Font
                }
            }
            //Set text to who Sid wants to heal
            Line1.setText(current.name + ", who do you want to heal?");
            
            //Call AI function to answer if they are a computer
            if(play_order.get(0).computer){
                //AI FUNCTION HERE(people)
            }
            
            //Call event handler for checkboxes if checked and unchecked
            nc1.setOnAction(eh2);
            nc2.setOnAction(eh2);
            nc3.setOnAction(eh2);
            nc4.setOnAction(eh2);
            nc5.setOnAction(eh2);
            nc6.setOnAction(eh2);
            nc7.setOnAction(eh2);
            nc8.setOnAction(eh2);
        });
        
        //Button Action that leads to Dice Selection scene
        Button3.setOnAction(f -> {
            
            //Sets pick as the selected character
            for(int i = 0; i < play_order.size(); i++){                         //For the size of the playing characters
                if(nameCheckBoxes.get(i).isSelected()){                           //If checkbox is slected
                    pick = play_order.get(i);                                       //Pick is now that character
                    nameCheckBoxes.get(i).setSelected(false);                       //Make tat checkbox false for later use
                    break;
                }
            }
            
            //Tries to do Sid's Action, even if he didn't go
            if(!(pick.name.equals("NULL"))){                                    //If pick's name is not "NULL"                            
                pick.heal(1);                                                     //Gain 1 life
                updateCharacters();                                               //Update labels function
            }
            
            //Removes d6 if it was in the dice ArrayList
            if(dice.size() == 6){
                dice.remove(d6);
            }
            
            //Makes a pick NULL reference
            pick = new Player("NULL", 99, "NULL", true);
            
            //Sets the number of rolls done to zero
            rolls = 0;
            
            //Sets the re-roll button to true for next scene
            Button4.setDisable(false);
            
            
            //Create group for Dice selection scene
            Group group = new Group();
            group.getChildren().clear();
                group.getChildren() 
                    .addAll(table2, Button4, Line1, Line2, Line3, Line4, Line5,
                            Line6, Line7, Line8, Line9, main1, main2, main3,
                            main4, main5, main6, main7, main8, 
                            c1, c2, c3, c4, c5, c6, c7, dice01, dice02, dice03,
                            dice04, dice05, dice06, dice07);                    //Shows dice images, and their checkboxes below them

            //Sets new scene with this group
            scene5 = new Scene(group, 1280, 720, Color.BEIGE);
            
            //Shows the Dice selection scene
            window.setScene(scene5);
            window.show();
            
            //Updates the characters label function
            updateCharacters();
            
            //Prompts user to select dice to use
            Line1.setText(current.name + ", pick the dice you want to use: ");

            //Format dice checkboxes
            for (int i = 0; i < 7; i++) {                                       //For the size of all the check boxes for the dice selection
                checkBoxes.get(i).setSelected(false);                             //Set all to not selected
                checkBoxes.get(i).setLayoutX((i * 100) + 450);                    //Layout X
                checkBoxes.get(i).setLayoutY(400);                                //Layout Y
                checkBoxes.get(i).setDisable(play_order.get(0).computer);         //Only enabled if current player is not a computer
                if (i < 4) {                                                      //For dice 1-4
                    if(current.team != 3 ){                                         //If they aren't team Zombies
                        checkBoxes.get(i).setSelected(true);                          //Set to selected
                        checkBoxes.get(i).setDisable(true);                           //Disable them
                    }
                    else{                                                           //If team Zombies
                        if(i < 2){                                                    //Dice 1-3
                            checkBoxes.get(i).setSelected(false);                       //Set not selected
                            checkBoxes.get(i).setDisable(true);                         //Set disabled
                        }
                        else{                                                         //Dice 4-5
                            checkBoxes.get(i).setSelected(true);                        //Set selected
                            checkBoxes.get(i).setDisable(true);                         //Set disabled
                        }
                    }
                }
            }
            
            //Manually select and disable checkboxes for team zombies
            if(current.team == 3){
               checkBoxes.get(4).setSelected(true);
               checkBoxes.get(4).setDisable(true); 
               checkBoxes.get(5).setSelected(false);
               checkBoxes.get(5).setDisable(true); 
               checkBoxes.get(6).setSelected(false);
               checkBoxes.get(6).setDisable(true); 
            }
            
            //Set text, image, and location for dice 1-7
            c1.setText("Old Saloon");
            imageSet(dice01, 90, 90, Img_Black);
            imageMove(dice01, (int)c1.getLayoutX(),(int)c1.getLayoutY() - 95);
            c2.setText("Old Saloon");
            imageSet(dice02, 90, 90, Img_Black);
            imageMove(dice02, (int)c2.getLayoutX(),(int)c2.getLayoutY() - 95);
            c3.setText("Regular");
            imageSet(dice03, 75, 75, Img_Reg);
            imageMove(dice03, (int)c3.getLayoutX(),(int)c3.getLayoutY() - 90);
            c4.setText("Regular");
            imageSet(dice04, 75, 75, Img_Reg);
            imageMove(dice04, (int)c4.getLayoutX(),(int)c4.getLayoutY() - 90);
            c5.setText("Regular");
            imageSet(dice05, 75, 75, Img_Reg);
            imageMove(dice05, (int)c5.getLayoutX(),(int)c5.getLayoutY() - 90);
            c6.setText("Loudmouth");
            imageSet(dice06, 75, 75, Img_Loud);
            imageMove(dice06, (int)c6.getLayoutX(),(int)c6.getLayoutY() - 92);
            c7.setText("Coward");
            imageSet(dice07, 75, 75, Img_Coward);
            imageMove(dice07, (int)c7.getLayoutX(),(int)c7.getLayoutY() - 92);
            
            //Set total selected die to zero
            total = 0;
            
            //Event handler for checkboxes 5-7
            c5.setOnAction(eh1);
            c6.setOnAction(eh1);
            c7.setOnAction(eh1);
            
            //AI function call if computer
            if(play_order.get(0).computer){
                //AI FUNCTION HERE(dice(last dice)) ie. regular, loudmouth, coward
            }
        });

        //Button Action that leads to reroll scene
        Button4.setOnAction(f -> {
            //Sets dice 5 to default dice if none was selected
            if((!c5.isSelected() && !c6.isSelected() && c7.isSelected()) &&
                    rolls == 0){
                dice.remove(d5);
                d5 = new Dice(0, 0, "Indian Arrow", "Dynamite", "Bull's Eye 1",
                        "Bull's Eye 2", "Beer", "Gatling");
                dice.add(d5);
            }
            
            //Replaces dice 5 with Loudmouth or Coward if regular was not selected
            if(((c6.isSelected() || c7.isSelected()) && !c5.isSelected()) &&
                    rolls == 0){
                dice.remove(d5);
                if(c6.isSelected()){
                    d5 = new Dice(1, 0, "Indian Arrow", "Dynamite",
                            "Double Bull's Eye 1", "Double Bull's Eye 2",
                            "Bullet", "Double Gatling");                        //LOUDMOUTH Dice
                }
                else{
                    d5 = new Dice(1, 0, "Broken Indian Arrow", "Dynamite",
                            "Bull's Eye 1", "Indian Arrow", "Double Beer",
                            "Beer");                                            //COWARD Dice
                }
                dice.add(d5);
            }
            
            //Disables re-roll dice if player takes final roll
            if (rolls >= (play_order.get(0).rolls - 1)) {
                Button4.setDisable(true);
            }
            
            //Updates character label function
            updateCharacters();
            
            //Calls go3 function
            go3();
            
            //Makes group based on number of dice
            if(dice.size() == 5){
                Group group = new Group();
                group.getChildren().clear();
                if(current.health < 1){                                         //If current health is below 1
                    group.getChildren().clear();
                    group.getChildren()        
                            .addAll(table2, dice1, dice2, dice3, dice4, dice5,
                                    nextButton, Button5, Line1, Line2, Line3,
                                    Line4, Line5,Line6, Line7, Line8, Line9,
                                    main1, main2, main3,main4, main5, main6,
                                    main7, main8,cd1, cd2, cd3, cd4, cd5,
                                    ChiefArrowButton);
                }
                else if(current.team != 3){                                     //If current team is not a zombie
                    group.getChildren().clear();
                    group.getChildren()        
                            .addAll(table2, dice1, dice2, dice3, dice4, dice5,
                                    Button4, Button5, Line1, Line2, Line3,
                                    Line4, Line5,Line6, Line7, Line8, Line9,
                                    main1, main2, main3,main4, main5, main6,
                                    main7, main8, cd1, cd2, cd3, cd4, cd5,
                                    ChiefArrowButton);
                }
                else{                                                           //If current team is a zombie
                    group.getChildren().clear();
                    group.getChildren()        
                            .addAll(table2, dice3, dice4, dice5,
                                    Button4, Button5, Line1, Line2, Line3,
                                    Line4, Line5, Line6, Line7, Line8, Line9,
                                    main1, main2, main3,main4, main5, main6,
                                    main7, main8,cd3, cd4, cd5,
                                    ChiefArrowButton);
                }
                
                //Displays Dyno to gat buttons for human player
                if(play_order.get(0).computer == false){
                    group.getChildren().addAll(TTG1, TTG2, TTG3, TTG4, TTG5);
                }
                
                //Sets scene with new group made
                scene5 = new Scene(group, 1280, 720, Color.BEIGE);
                
                //Makes scene and shows
                window.setScene(scene5);
                window.show();
                
                //Calls character label update function
                updateCharacters();
                
                //Sets cyno to gat buttons location, format, and if enabled
                if(play_order.get(0).computer == false){
                    for(int i = 0; i < TTG.size(); i++){
                        TTG.get(i).setLayoutX((i * 100) + 410);
                        TTG.get(i).setLayoutY(250);
                        TTG.get(i).setMinWidth(90);
                        TTG.get(i).setMaxWidth(90);
                        TTG.get(i).setMinHeight(30);
                        TTG.get(i).setFont(Font.font("Verdana",FontWeight.BOLD, 12));
                        TTG.get(i).setDisable(false);
                        if(!(current.name.equals("Belle Star"))){
                            TTG.get(i).setDisable(true);
                        }
                        String side = dice.get(i).sides[dice.get(i).side];
                        if(!side.equals("Dynamite")){
                            TTG.get(i).setDisable(true);
                        }
                        if((int)diceOutcome.get("Dynamite") >= 3){
                           TTG.get(i).setDisable(true); 
                        }
                    }

                }
            }
            else{
                //Makes new group for re-roll scene
                Group group = new Group();
                if(current.health < 1){                                         //If current health is below 1
                  group.getChildren().clear();
                    group.getChildren()
                    .addAll(table2, dice1, dice2, dice3, dice4, dice5, dice6,
                            nextButton, Button5, Line1, Line2, Line3, Line4,
                            Line5, Line6, Line7, Line8, Line9, main1, main2,
                            main3, main4, main5, main6, main7, main8,
                            cd1, cd2, cd3, cd4, cd5, cd6,
                            ChiefArrowButton);  
                }
                else{                                                           //Everyone else
                  group.getChildren().clear();
                    group.getChildren()
                    .addAll(table2, dice1, dice2, dice3, dice4, dice5, dice6,
                            Button4, Button5, Line1, Line2, Line3, Line4, Line5,
                            Line6, Line7, Line8, Line9, main1, main2, main3,
                            main4, main5, main6, main7, main8,
                            cd1, cd2, cd3, cd4, cd5, cd6,
                            ChiefArrowButton);  
                }
                
                //Sets new scene with group made
                scene5 = new Scene(group, 1280, 720, Color.BEIGE);
                
                //Makes new scene and shows
                window.setScene(scene5);
                window.show();
                
                //Calls character label update function
                updateCharacters();
            }
            
            //Sets ChiefArrow Take button 
            ChiefArrowButton.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
            ChiefArrowButton.setLayoutX(600);
            ChiefArrowButton.setLayoutY(590);
            ChiefArrowButton.setDisable(true);
        
            //Prompts to select dice to reroll
            Line1.setText(current.name + ", pick the dice you want to Re-Roll: ");
            
            //Sets the checkboxes and images for dice 
            for (int i = 0; i < dice.size(); i++) {
                checkBoxes2.get(i).setLayoutX((i * 100) + 450);
                checkBoxes2.get(i).setLayoutY(400);
                checkBoxes2.get(i).setText("");
                if (dice.get(i).sides[dice.get(i).side].equals("Dynamite") &&
                        current.dynamiteReroll == false) {                      //If dynomite
                    checkBoxes2.get(i).setSelected(false);
                    checkBoxes2.get(i).setDisable(true);
                    imageSet(IV.get(i), 90, 90, Img_Dynamite);
                    dice.get(i).canRoll = false;
                } 
                else {                                                          //All other dice
                    checkBoxes2.get(i).setSelected(false);
                    checkBoxes2.get(i).setDisable(play_order.get(0).computer);
                    switch (dice.get(i).sides[dice.get(i).side]) {
                        case "Indian Arrow":
                            imageSet(IV.get(i), 90, 90, Img_arrow);
                            break;
                        case "Duel":
                            imageSet(IV.get(i), 90, 90, Img_Duel);
                            break;
                        case "Whiskey":
                            imageSet(IV.get(i), 90, 90, Img_Whiskey);
                            break;
                        case "Gatling":
                            imageSet(IV.get(i), 90, 90, Img_Gatling);
                            break;
                        case "Bull's Eye 1":
                            imageSet(IV.get(i), 90, 90, Img_BE1);
                            break;
                        case "Bull's Eye 2":
                            imageSet(IV.get(i), 90, 90, Img_BE2);
                            break;
                        case "Beer":
                            imageSet(IV.get(i), 90, 90, Img_Beer);
                            break;
                        case "Bullet":
                            imageSet(IV.get(i), 90, 90, Img_Bullet);
                            break;
                        case "Broken Indian Arrow":
                            imageSet(IV.get(i), 90, 90, Img_BrokenArrow);
                            break;
                        case "Double Bull's Eye 1":
                            imageSet(IV.get(i), 90, 90, Img_DBE1);
                            break;
                        case "Double Bull's Eye 2":
                            imageSet(IV.get(i), 90, 90, Img_DBE2);
                            break;
                        case "Double Beer":
                            imageSet(IV.get(i), 90, 90, Img_DBeer);
                            break;
                        case "Double Gatling":
                            imageSet(IV.get(i), 90, 90, Img_DGatling);
                            break;
                        case "Dynamite":
                            imageSet(IV.get(i), 90, 90, Img_Dynamite);
                            break;
                        default:
                            break;
                    }
                }
                
                //Sets the image location
                imageMove(IV.get(i), (i * 100) + 410, 300);
            }
            
            //Sets buttons actions for dyno to gatling
            if(play_order.get(0).computer != true && current.team != 3){
                TTG1.setOnAction(g -> {
                imageSet(IV.get(0), 90, 90, Img_Gatling);
                dice.get(0).side = 5;
                diceOutcome.put("Dynamite", ((int)diceOutcome
                        .get("Dynamite") - 1));
                diceOutcome.put("Gatling", ((int)diceOutcome
                        .get("Gatling") + 1));
                cd1.setDisable(false);
                dice.get(0).canRoll = true;
                });
                TTG2.setOnAction(g -> {
                    imageSet(IV.get(1), 90, 90, Img_Gatling);
                    dice.get(1).side = 5;
                    diceOutcome.put("Dynamite", ((int)diceOutcome
                            .get("Dynamite") - 1));
                    diceOutcome.put("Gatling", ((int)diceOutcome
                            .get("Gatling") + 1));
                    cd2.setDisable(false);
                    dice.get(1).canRoll = true;
                });
                TTG3.setOnAction(g -> {
                    imageSet(IV.get(2), 90, 90, Img_Gatling);
                    dice.get(2).side = 5;
                    diceOutcome.put("Dynamite", ((int)diceOutcome
                            .get("Dynamite") - 1));
                    diceOutcome.put("Gatling", ((int)diceOutcome
                            .get("Gatling") + 1));
                    cd3.setDisable(false);
                    dice.get(2).canRoll = true;
                });
                TTG4.setOnAction(g -> {
                    imageSet(IV.get(3), 90, 90, Img_Gatling);
                    dice.get(3).side = 5;
                    diceOutcome.put("Dynamite", ((int)diceOutcome
                            .get("Dynamite") - 1));
                    diceOutcome.put("Gatling", ((int)diceOutcome
                            .get("Gatling") + 1));
                    cd4.setDisable(false);
                    dice.get(3).canRoll = true;
                });
                
                //Last button is based on if they pick Coward dice or other dice
                switch (dice.get(4).sides[4]) {
                    case "Beer":
                        TTG5.setOnAction(g -> {
                            imageSet(IV.get(4), 90, 90, Img_Gatling);
                            dice.get(4).side = 5;
                            diceOutcome.put("Dynamite", ((int)diceOutcome
                                    .get("Dynamite") - 1));
                            diceOutcome.put("Gatling", ((int)diceOutcome
                                    .get("Gatling") + 1));
                            cd5.setDisable(false);
                            dice.get(4).canRoll = true;
                        }); break;
                    case "Bullet":
                        TTG5.setOnAction(g -> {
                            imageSet(IV.get(4), 90, 90, Img_DGatling);
                            dice.get(4).side = 5;
                            diceOutcome.put("Dynamite", ((int)diceOutcome
                                    .get("Dynamite") - 1));
                            diceOutcome.put("Double Gatling", ((int)diceOutcome
                                    .get("Double Gatling") + 1));
                            cd5.setDisable(false);
                            dice.get(4).canRoll = true;
                        }); break;
                    case "Double Beer":
                        TTG5.setDisable(true);
                        break;
                    default:
                        break;
                }
            }
            
            //Sets Chief Arrow button enable/disable and its action
            if((int)diceOutcome.get("Indian Arrow") >= 1 && (chiefArrow ||
                    current.name.equals("Apache Kid")) && play_order.get(0)
                    .computer == false){
                ChiefArrowButton.setDisable(false);
                
                //Button action
                ChiefArrowButton.setOnAction(g -> {
                    if(chiefArrow){                                             //If chief arrow is in middle
                        chiefArrow = false;
                    }
                    else{                                                       //Case for Apache Kid
                        for(int i = 0; i < play_order.size(); i++){
                            if(play_order.get(i).chiefArrow){
                                play_order.get(i).chiefArrow = false;
                            }
                        }
                    }
                    current.chiefArrow = true;
                    ChiefArrowButton.setDisable(true);
                });
            }
            
            //Makes human player press re-roll button for AI function
            if(play_order.get(0).computer){
                if(rolls < play_order.get(0).rolls && !Button4.isDisable()){
                    Button5.setDisable(true);
                }
                else{
                    Button5.setDisable(false);
                }
                //AI FUNCTION HERE(dice reroll)
            }
        });

        //Button Action leads to Final Result scene
        Button5.setOnAction(f -> {
            //Call go4 function
            go4();
            
            //Call dictionary reset
            resetDictionary();
            
            //Make new group
            Group group = new Group();
            
            //Sets button for next scene based on dice results and current name
            if(dice.size() == 6){
                //Adds keys to dictionary
                for(int roll = 0; roll < dice.size(); roll++){
                    String side = dice.get(roll).sides[dice.get(roll).side];
                    diceOutcome.put(side, ((int)diceOutcome.get(side))+1);
                }
                
                //Sets button from results
                if((int)diceOutcome.get("Bull's Eye 1") > 0){                   //6 Die, leads to BE1
                    group.getChildren().clear();
                    group.getChildren()
                            .addAll(table2, dice3, dice4, dice5, dice6,
                                    Button8, Line1, Line2, Line3, Line4, Line5,
                                    Line6, Line7, Line8, Line9, main1, main2,
                                    main3, main4, main5, main6, main7, main8,
                                    ChiefArrowButton);
                }
                else if((int)diceOutcome.get("Double Bull's Eye 1") > 0){       //6 Die, leads to DBE1
                    group.getChildren().clear();
                    group.getChildren()
                            .addAll(table2, dice3, dice4, dice5, dice6,
                                    Button9, Line1, Line2, Line3, Line4, Line5,
                                    Line6, Line7, Line8, Line9, main1, main2,
                                    main3, main4, main5, main6, main7, main8,
                                    ChiefArrowButton);   
                }
                else if((int)diceOutcome.get("Bull's Eye 2") > 0){              //6 die, leads to E2
                    group.getChildren().clear();
                    group.getChildren()
                            .addAll(table2, dice3, dice4, dice5, dice6,
                                    Button10, Line1, Line2, Line3, Line4, Line5,
                                    Line6, Line7, Line8, Line9, main1, main2,
                                    main3, main4, main5, main6, main7, main8,
                                    ChiefArrowButton); 
                }
                else if((int)diceOutcome.get("Double Bull's Eye 2") > 0){       //6 die, leads to DBE2
                    group.getChildren().clear();
                    group.getChildren()
                            .addAll(table2, dice3, dice4, dice5, dice6, 
                                    Button11, Line1, Line2, Line3, Line4, Line5,
                                    Line6, Line7, Line8, Line9, main1, main2,
                                    main3, main4, main5, main6, main7, main8,
                                    ChiefArrowButton);   
                }
                else if(gatAttack){                                             //6 die, leads to gatling
                    group.getChildren().clear();
                    group.getChildren()
                            .addAll(table2, dice3, dice4, dice5, dice6,
                                    Button13, Line1, Line2, Line3, Line4, Line5,
                                    Line6, Line7, Line8, Line9, main1, main2,
                                    main3, main4, main5, main6, main7, main8,
                                    ChiefArrowButton);   
                }
                else if((int)diceOutcome.get("Beer") + (int)diceOutcome
                        .get("Double Beer") > 0){                               //6 die, leads to beer
                    group.getChildren().clear();
                    group.getChildren()
                            .addAll(table2, dice3, dice4, dice5, dice6,
                                    Button12, Line1, Line2, Line3, Line4, Line5,
                                    Line6, Line7, Line8, Line9, main1, main2,
                                    main3, main4, main5, main6, main7, main8,
                                    ChiefArrowButton);  
                }
                else if((int)diceOutcome.get("Duel") > 0){                      //6 die, leads to duel
                    group.getChildren().clear();
                    group.getChildren()
                            .addAll(table2, dice3, dice4, dice5, dice6,
                                    Button14, Line1, Line2, Line3, Line4, Line5,
                                    Line6, Line7, Line8, Line9, main1, main2,
                                    main3, main4, main5, main6, main7, main8,
                                    ChiefArrowButton);   
                }
                else{                                                           //6 die, leads to next turn
                    group.getChildren().clear();
                    group.getChildren() 
                            .addAll(table2, dice3, dice4, dice5, dice6,
                                    nextButton, Line1, Line2, Line3, Line4, 
                                    Line5, Line6, Line7, Line8, Line9, main1, 
                                    main2, main3, main4, main5, main6, main7, 
                                    main8);  
                }                
            }
            else{
                //Get key values for Dictionary
                if(current.team != 3){                              
                    for(int roll = 0; roll < dice.size(); roll++){
                        String side = dice.get(roll).sides[dice.get(roll).side];
                        diceOutcome.put(side, ((int)diceOutcome.get(side))+1);
                    }
                }
                else{
                    for(int roll = 2; roll < dice.size(); roll++){
                        String side = dice.get(roll).sides[dice.get(roll).side];
                        diceOutcome.put(side, ((int)diceOutcome.get(side))+1);
                        if(current.name.equals("Bill Noface")){
                            if (side.equals("Indian Arrow")) {
                                current.addArrow(1);
                                arrow--;
                                if (arrow <= 0) {
                                    BANG.indianAttack(play_order);
                                }
                            }
                        } 
                    }
                }
                //Temp variable reset 
                temp = 0;
                temp = (int)diceOutcome.get("Gatling") + (int)diceOutcome
                        .get("Double Gatling");
                if(current.name.equals("Kit Carlson") && arrow != 10 &&
                        temp > 0 ){                                             //5 die, leads to Kit
                    group.getChildren().clear();
                    group.getChildren()
                        .addAll(table2, dice3, dice4, dice5,
                                Button6, Line1, Line2, Line3, Line4, Line5,
                                Line6, Line7, Line8, Line9, main1, main2,
                                main3, main4, main5, main6, main7, main8,
                                ChiefArrowButton);
                }
                
                //Temp variable reset
                temp = 0;
                temp2 = 0;
                temp = (int)diceOutcome.get("Bull's Eye 1") + (int)diceOutcome
                        .get("Bull's Eye 2");
                temp2 = ((int)diceOutcome.get("Double Bull's Eye 1") +
                        (int)diceOutcome.get("Double Bull's Eye 2"));
                if(current.name.equals("Calamity Janet") && (temp > 0 ||
                        temp2 > 0)){                                            //5 die, leads to Calamity reg
                    if(temp > 0){
                        group.getChildren().clear();
                        group.getChildren()
                            .addAll(table2, dice3, dice4, dice5,
                                    Button7, Line1, Line2, Line3, Line4, Line5,
                                    Line6,Line7, Line8, Line9, main1, main2,
                                    main3, main4, main5, main6, main7, main8,
                                    ChiefArrowButton);
                    }
                    else{                                                       //5 die, leads to Calamity double
                        group.getChildren().clear();
                        group.getChildren()
                            .addAll(table2, dice3, dice4, dice5,
                                    Button15, Line1, Line2, Line3, Line4, Line5,
                                    Line6, Line7, Line8, Line9, main1, main2,
                                    main3, main4, main5, main6, main7, main8,
                                    ChiefArrowButton);
                    }
                }
                else if((int)diceOutcome.get("Bull's Eye 1") > 0){              //5 die, leads to BE1
                    group.getChildren().clear();
                    group.getChildren()
                        .addAll(table2, dice3, dice4, dice5, 
                                Button8, Line1, Line2, Line3, Line4, Line5,
                                Line6, Line7, Line8, Line9, main1, main2,
                                main3, main4, main5, main6, main7, main8,
                                ChiefArrowButton);

                }
                else if((int)diceOutcome.get("Double Bull's Eye 1") > 0){       //5 die, leads to DBE1
                    group.getChildren().clear();
                    group.getChildren()
                        .addAll(table2, dice3, dice4, dice5,
                                Button9, Line1, Line2, Line3, Line4, Line5,
                                Line6, Line7, Line8, Line9, main1, main2, main3,
                                main4, main5, main6, main7, main8,
                                ChiefArrowButton);   
                }
                else if((int)diceOutcome.get("Bull's Eye 2") > 0){              //5 die, leads to BE2
                    group.getChildren().clear();
                    group.getChildren()
                            .addAll(table2, dice3, dice4, dice5,
                                    Button10, Line1, Line2, Line3, Line4, Line5,
                                    Line6, Line7, Line8, Line9, main1, main2,
                                    main3, main4, main5, main6, main7, main8,
                                    ChiefArrowButton); 
                }
                else if((int)diceOutcome.get("Double Bull's Eye 2") > 0){       //5 die, leads to DBE2
                    group.getChildren().clear();
                    group.getChildren()
                            .addAll(table2, dice3, dice4, dice5,
                                    Button11, Line1, Line2, Line3, Line4, Line5,
                                    Line6, Line7, Line8, Line9, main1, main2,
                                    main3, main4, main5, main6, main7, main8,
                                    ChiefArrowButton);   
                }
                else if(gatAttack){                                             //5 die, leads to gatling
                    group.getChildren().clear();
                    group.getChildren()
                            .addAll(table2, dice3, dice4, dice5,
                                    Button13, Line1, Line2, Line3, Line4, Line5,
                                    Line6,  Line7, Line8, Line9, main1, main2, 
                                    main3, main4, main5, main6, main7, main8,
                                    ChiefArrowButton);   
                }
                else if((int)diceOutcome.get("Beer") + (int)diceOutcome
                        .get("Double Beer") > 0){                               //5 die, leads to beer
                    group.getChildren().clear();
                    group.getChildren()
                            .addAll(table2, dice3, dice4, dice5,
                                    Button12, Line1, Line2, Line3, Line4, Line5,
                                    Line6, Line7, Line8, Line9, main1, main2, 
                                    main3, main4, main5, main6, main7, main8,
                                    ChiefArrowButton);  
                }
                else if((int)diceOutcome.get("Duel") > 0){                      //5 die, leads to Duel
                    group.getChildren().clear();
                    group.getChildren() 
                            .addAll(table2, dice3, dice4, dice5,
                                    Button14, Line1, Line2, Line3, Line4, Line5,
                                    Line6, Line7, Line8, Line9, main1, main2, 
                                    main3, main4, main5, main6, main7, main8,
                                    ChiefArrowButton);   
                }
                else{                                                           //5 die, leads to next turn
                    group.getChildren().clear();
                    group.getChildren() 
                            .addAll(table2, dice3, dice4, dice5,
                                    nextButton, Line1, Line2, Line3, Line4, 
                                    Line5, Line6, Line7, Line8, Line9, main1, 
                                    main2, main3, main4, main5, main6, main7, 
                                    main8);  
                }
            }
            
            //Adds dice 1 & 2 if not a zombie
            if(current.team != 3){
                group.getChildren().addAll(
                    dice1, dice2);
            }
            
            //Sets scene with group made
            scene5 = new Scene(group, 1280, 720, Color.BEIGE);
            
            //Makes scene and shows
            window.setScene(scene5);
            window.show();
            
            //Prompts new Final results
            Line1.setText("Final Results: ");
            
            //Calls character label update function
            updateCharacters();
        });
        
        //Button Action leads to Kit's Scene
        Button6.setOnAction(f -> {
            //Subs 1 from temp stored from last scene
            temp--;
            
            //Calls action function
            action();
            
            //Makes new group for next scene
            Group group = new Group();
            group = stageSet(group);
            
            //Sets new scene
            scene5 = new Scene(group, 1280, 720, Color.BEIGE);
            
            //Makes new scene and shows
            window.setScene(scene5);
            window.show(); 
            
            //Calls character label update function
            updateCharacters();
            
            //Prompts who kit wants to remove arrow from
            Line1.setText(
                    "Kit Carlson, Who do you want to remove an arrow from: ");
            
            //Formats name checkboxes 
            for (int i = 0; i < nameCheckBoxes.size(); i++) {
                nameCheckBoxes.get(i).setSelected(false);
                if (i < play_order.size()) {
                    nameCheckBoxes.get(i).setText(play_order.get(i).name);
                    nameCheckBoxes.get(i).setLayoutX(500);
                    nameCheckBoxes.get(i).setLayoutY(300 + (i * 50));
                    if(play_order.get(i).arrows > 0){
                       nameCheckBoxes.get(i).setDisable(play_order.get(0)
                               .computer); 
                    }
                    else{
                        nameCheckBoxes.get(i).setDisable(true);
                    }
                    nameCheckBoxes.get(i).setFont(Font.font("Verdana",
                            FontWeight.BOLD, 24));
                } else {
                    nameCheckBoxes.get(i).setLayoutX(500);
                    nameCheckBoxes.get(i).setLayoutY(300 + (i * 50));
                    nameCheckBoxes.get(i).setDisable(true);
                    nameCheckBoxes.get(i).setText("");
                    nameCheckBoxes.get(i).setFont(Font.font("Verdana",
                            FontWeight.BOLD, 24));
                }
            }
            
            //Calls character label update function
            updateCharacters();
            
            //Sets stage as 1 for action function
            stage = 1;
            
            //AI funciton
            if(play_order.get(0).computer){
                //AI FUNCTION HERE(people)
            }
        });
        
        //Button Action leads to Calamity(single)
        Button7.setOnAction(f -> {
            //Subs 1 from temp from past scene
            temp--;
            
            //Calls action funciton
            action();
            
            //Calls character label update function
            updateCharacters();
            
            //Makes group for next scene
            Group group = new Group();
            group = stageSet(group);
            
            //Sets scene from group just made
            scene5 = new Scene(group, 1280, 720, Color.BEIGE);
            
            //Makes scene and shows
            window.setScene(scene5);
            window.show();
            
            //Prompts who calamity whats to shoot
            Line1.setText("Calamity, Who do you want to shoot: ");
            
            //Sets name checkboxes 
            for (int i = 0; i < nameCheckBoxes.size(); i++) {
                nameCheckBoxes.get(i).setSelected(false);
                if (i < play_order.size()) {
                    nameCheckBoxes.get(i).setText(play_order.get(i).name);
                    nameCheckBoxes.get(i).setLayoutX(500);
                    nameCheckBoxes.get(i).setLayoutY(300 + (i * 50));
                    if(play_order.get(i) == left1 || play_order.get(i) == left2 
                            || play_order.get(i) == right1 || play_order.get(i) 
                            == right2){
                       nameCheckBoxes.get(i).setDisable(play_order.get(0)
                               .computer); 
                    }
                    else{
                        nameCheckBoxes.get(i).setDisable(true);
                    }
                    nameCheckBoxes.get(i).setFont(Font.font("Verdana",
                            FontWeight.BOLD, 24));
                } else {
                    nameCheckBoxes.get(i).setLayoutX(500);
                    nameCheckBoxes.get(i).setLayoutY(300 + (i * 50));
                    nameCheckBoxes.get(i).setDisable(true);
                    nameCheckBoxes.get(i).setText("");
                    nameCheckBoxes.get(i).setFont(Font.font("Verdana",
                            FontWeight.BOLD, 24));
                }
            }
            
            //Calls character label update function
            updateCharacters();
            
            //Sets stage for action function
            stage = 2;
            
            //AI function
            if(play_order.get(0).computer){
                //AI FUNCTION HERE(people)
            }
        });
        
        //Button Action leads to Calamity(double)
        Button15.setOnAction(f -> {
            //Subs 1 from temp2 from past scene
            temp2--;
            
            //Calls action function
            action();
            
            //Calls character label update function
            updateCharacters();
            
            //Makes group for next scene
            Group group = new Group();
            group = stageSet(group);
            
            //Sets scene
            scene5 = new Scene(group, 1280, 720, Color.BEIGE);
            
            //Makes scene and shows
            window.setScene(scene5);
            window.show();
            
            
            //Prompts Calamity who she wants to shoot
            Line1.setText(
                    "Calamity, Who do you want to shoot (Double damage): ");
            
            //Set name checkboxes
            for (int i = 0; i < nameCheckBoxes.size(); i++) {
                nameCheckBoxes.get(i).setSelected(false);
                if (i < play_order.size()) {
                    nameCheckBoxes.get(i).setText(play_order.get(i).name);
                    nameCheckBoxes.get(i).setLayoutX(500);
                    nameCheckBoxes.get(i).setLayoutY(300 + (i * 50));
                    if(play_order.get(i) == left1 || play_order.get(i) == left2 
                            || play_order.get(i) == right1 || play_order.get(i)
                            == right2){
                       nameCheckBoxes.get(i).setDisable(play_order.get(0)
                               .computer); 
                    }
                    else{
                        nameCheckBoxes.get(i).setDisable(true);
                    }
                    nameCheckBoxes.get(i).setFont(Font.font("Verdana",
                            FontWeight.BOLD, 24));
                } else {
                    nameCheckBoxes.get(i).setLayoutX(500);
                    nameCheckBoxes.get(i).setLayoutY(300 + (i * 50));
                    nameCheckBoxes.get(i).setDisable(true);
                    nameCheckBoxes.get(i).setText("");
                    nameCheckBoxes.get(i).setFont(Font.font("Verdana",
                            FontWeight.BOLD, 24));
                }
            }
            
            //Calls character label update function
            updateCharacters();
            
            //Stages stage for action function
            stage = 3;
            
            //AI Function
            if(play_order.get(0).computer){
                //AI FUNCTION HERE(people)
            }
        });
        
        //Button Action leads to Bull's Eye 1
        Button8.setOnAction(f -> {
            //Calls action function
            action();
            
            //Subs the amount of Bull's eyes left
            diceOutcome.put("Bull's Eye 1",(int)diceOutcome
                    .get("Bull's Eye 1") - 1);
            
            //Calls character label update function
            updateCharacters();
            
            
            //Makes a group for the next scene
            Group group = new Group();
            group = stageSet(group);
            
            //Enables slab's checkbox for damage for slab and non-computers
            if(current.name.equals("Slab The Killer")){
                group.getChildren().addAll(slab);
                if(Slab || current.computer){
                    slab.setDisable(true);
                }
                else{
                    slab.setDisable(false);
                }
                slab.setSelected(false);
            }
            
            //Sets scene
            scene5 = new Scene(group, 1280, 720, Color.BEIGE);
            
            //Makes scene and shows
            window.setScene(scene5);
            window.show();
            
            //Prompts who they want to shoot
            Line1.setText(current.name + ", who do you want to shoot: ");
            
            //Sets checkboxes
            for (int i = 0; i < nameCheckBoxes.size(); i++) {
                nameCheckBoxes.get(i).setSelected(false);
                if (i < play_order.size() && i != 0) {
                    nameCheckBoxes.get(i).setLayoutX(500);
                    nameCheckBoxes.get(i).setLayoutY(300 + (i * 50));
                    if(current.name.equals("Rose Dulan")){
                      if(play_order.get(i) == left1 || play_order.get(i) == 
                              right1 || play_order.get(i) == left2 || play_order
                                      .get(i) == right2){
                           nameCheckBoxes.get(i).setDisable(play_order.get(0)
                                   .computer); 
                        }
                        else{
                            nameCheckBoxes.get(i).setDisable(true);
                        }  
                    }
                    else{
                        if(play_order.get(i) == left1 || play_order.get(i) == 
                                right1){
                           nameCheckBoxes.get(i).setDisable(play_order.get(0)
                                   .computer); 
                        }
                        else{
                            nameCheckBoxes.get(i).setDisable(true);
                        }
                    }
                    nameCheckBoxes.get(i).setText(play_order.get(i).name);
                    nameCheckBoxes.get(i).setFont(Font.font("Verdana",
                            FontWeight.BOLD, 24));
                } else {
                    nameCheckBoxes.get(i).setLayoutX(500);
                    nameCheckBoxes.get(i).setLayoutY(300 + (i * 50));
                    nameCheckBoxes.get(i).setDisable(true);
                    nameCheckBoxes.get(i).setText("");
                    nameCheckBoxes.get(i).setFont(Font.font("Verdana",
                            FontWeight.BOLD, 24));
                }
            }
            
            //Sets name for current player
            nameCheckBoxes.get(0).setText(play_order.get(0).name);
            
            //Calls character label update function
            updateCharacters();
            
            //Sets stage for action function
            stage = 4;
            
            //AI Function
            if(play_order.get(0).computer){
                //AI FUNCTION HERE (people)
            }
        });
        
        //Button action leads to Double Bull's Eye 1
        Button9.setOnAction(f -> {
            //Calls action function
            action();
            
            //Subs 1 from Bull's eye doubles left
            diceOutcome.put("Double Bull's Eye 1",(int)diceOutcome
                    .get("Double Bull's Eye 1") - 1);
            
            //Calls character label update function
            updateCharacters();
            
            //Makes group for next scene
            Group group = new Group();
            group = stageSet(group);
            
            //Sets Slab's checkbox
            if(current.name.equals("Slab The Killer")){
                group.getChildren().addAll(slab);
                if(Slab || current.computer){
                    slab.setDisable(true);
                }
                else{
                    slab.setDisable(false);
                }
                slab.setSelected(false);
            }
            
            //Sets scene 
            scene5 = new Scene(group, 1280, 720, Color.BEIGE);
            
            //Makes sence and shows
            window.setScene(scene5);
            window.show();
            
            //Prompts who to shoot
            Line1.setText(current.name +
                    ", who do you want to shoot (Double damage): ");
            
            //Format Checkboxes
            for (int i = 0; i < nameCheckBoxes.size(); i++) {
                nameCheckBoxes.get(i).setSelected(false);
                if (i < play_order.size() && i != 0) {
                    nameCheckBoxes.get(i).setLayoutX(500);
                    nameCheckBoxes.get(i).setLayoutY(300 + (i * 50));
                    if(current.name.equals("Rose Dulan")){
                      if(play_order.get(i) == left1 || play_order.get(i) == 
                              right1 || play_order.get(i) == left2 || play_order
                                      .get(i) == right2){
                           nameCheckBoxes.get(i).setDisable(play_order.get(0)
                                   .computer); 
                        }
                        else{
                            nameCheckBoxes.get(i).setDisable(true);
                        }  
                    }
                    else{
                        if(play_order.get(i) == left1 || play_order.get(i) == 
                                right1){
                           nameCheckBoxes.get(i).setDisable(play_order.get(0)
                                   .computer); 
                        }
                        else{
                            nameCheckBoxes.get(i).setDisable(true);
                        }
                    }
                    nameCheckBoxes.get(i).setText(play_order.get(i).name);
                    nameCheckBoxes.get(i).setFont(Font.font("Verdana",
                            FontWeight.BOLD, 24));
                } else {
                    nameCheckBoxes.get(i).setLayoutX(500);
                    nameCheckBoxes.get(i).setLayoutY(300 + (i * 50));
                    nameCheckBoxes.get(i).setDisable(true);
                    nameCheckBoxes.get(i).setText("");
                    nameCheckBoxes.get(i).setFont(Font.font("Verdana",
                            FontWeight.BOLD, 24));
                }
            }
            
            //Sets current players name on check box
            nameCheckBoxes.get(0).setText(play_order.get(0).name);
            
            //Calls character label update function
            updateCharacters();
            
            //Sets stage for Action function
            stage = 5;
            
            //AI Function
            if(play_order.get(0).computer){
                //AI FUNCTION HERE (people)
            }
        });
        
        //Button Action leads to Bull's Eye 2
        Button10.setOnAction(f -> {
            //Calls action function
            action();
            
            //Subs 1 from Bull's Eye 2
            diceOutcome.put("Bull's Eye 2",(int)diceOutcome
                    .get("Bull's Eye 2") - 1);
            
            //Calls character label update function
            updateCharacters();
            
            //Makes a group for the next scene
            Group group = new Group();
            group = stageSet(group);
            
            //Sets slab's checkbox
            if(current.name.equals("Slab The Killer")){
                group.getChildren().addAll(slab);
                if(Slab || current.computer){
                    slab.setDisable(true);
                }
                else{
                    slab.setDisable(false);
                }
                slab.setSelected(false);
            }
            
            //Sets scene
            scene5 = new Scene(group, 1280, 720, Color.BEIGE);
            
            //Makes scene and shows
            window.setScene(scene5);
            window.show();
            
            //Prompts who to shoot
            Line1.setText(current.name + ", who do you want to shoot: ");
            
            //Format Checkboxes
            for (int i = 0; i < nameCheckBoxes.size(); i++) {
                nameCheckBoxes.get(i).setSelected(false);
                if (i < play_order.size() && i != 0) {
                    nameCheckBoxes.get(i).setLayoutX(500);
                    nameCheckBoxes.get(i).setLayoutY(300 + (i * 50));
                    if(current.name.equals("Rose Dulan")){
                      if(play_order.get(i) == left2 || play_order.get(i) == 
                              right2 || play_order.get(i) == left3 || play_order
                                      .get(i) == right3){
                           nameCheckBoxes.get(i).setDisable(play_order.get(0)
                                   .computer); 
                        }
                        else{
                            nameCheckBoxes.get(i).setDisable(true);
                        }  
                    }
                    else{
                        if(play_order.get(i) == left2 || play_order.get(i) == 
                                right2){
                           nameCheckBoxes.get(i).setDisable(play_order.get(0)
                                   .computer); 
                        }
                        else{
                            nameCheckBoxes.get(i).setDisable(true);
                        }
                    }
                    nameCheckBoxes.get(i).setText(play_order.get(i).name);
                    nameCheckBoxes.get(i).setFont(Font.font("Verdana",
                            FontWeight.BOLD, 24));
                } else {
                    nameCheckBoxes.get(i).setLayoutX(500);
                    nameCheckBoxes.get(i).setLayoutY(300 + (i * 50));
                    nameCheckBoxes.get(i).setDisable(true);
                    nameCheckBoxes.get(i).setText("");
                    nameCheckBoxes.get(i).setFont(Font.font("Verdana",
                            FontWeight.BOLD, 24));
                }
            }
            
            //Put name for current on check box
            nameCheckBoxes.get(0).setText(play_order.get(0).name);
            
            //Calls character label update function
            updateCharacters();
            
            //Sets stage for action function
            stage = 6;
            
            //AI Function
            if(play_order.get(0).computer){
                //AI FUNCTION HERE (people)
            }
        });
        
        //Button action leads to Bull's Eye 2 Double
        Button11.setOnAction(f -> {
            //Calls action function
            action();
            
            //Subs 1 from Bull's Eye 2 double
            diceOutcome.put("Double Bull's Eye 2",(int)diceOutcome
                    .get("Double Bull's Eye 2") - 1);
            
            //Calls character label update function
            updateCharacters();
            
            //Make group for next scene
            Group group = new Group();
            group = stageSet(group);
            
            //Sets Slab's checkbox
            if(current.name.equals("Slab The Killer")){
                group.getChildren().addAll(slab);
                if(Slab || current.computer){
                    slab.setDisable(true);
                }
                else{
                    slab.setDisable(false);
                }
                slab.setSelected(false);
            }
            
            //Sets Scene
            scene5 = new Scene(group, 1280, 720, Color.BEIGE);
            
            //Makes scene
            window.setScene(scene5);
            window.show();
            
            //Prompts who to shoot
            Line1.setText(current.name +
                    ", who do you want to shoot (Double damage): ");
            
            //Format checkboxes
            for (int i = 0; i < nameCheckBoxes.size(); i++) {
                nameCheckBoxes.get(i).setSelected(false);
                if (i < play_order.size() && i != 0) {
                    nameCheckBoxes.get(i).setLayoutX(500);
                    nameCheckBoxes.get(i).setLayoutY(300 + (i * 50));
                    if(current.name.equals("Rose Dulan")){
                      if(play_order.get(i) == left2 || play_order.get(i) == 
                              right2 || play_order.get(i) == left3 || play_order
                                      .get(i) == right3){
                           nameCheckBoxes.get(i).setDisable(play_order.get(0)
                                   .computer); 
                        }
                        else{
                            nameCheckBoxes.get(i).setDisable(true);
                        }  
                    }
                    else{
                        if(play_order.get(i) == left2 || play_order.get(i) == 
                                right2){
                           nameCheckBoxes.get(i).setDisable(play_order.get(0)
                                   .computer); 
                        }
                        else{
                            nameCheckBoxes.get(i).setDisable(true);
                        }
                    }
                    nameCheckBoxes.get(i).setText(play_order.get(i).name);
                    nameCheckBoxes.get(i).setFont(Font.font("Verdana",
                            FontWeight.BOLD, 24));
                } else {
                    nameCheckBoxes.get(i).setLayoutX(500);
                    nameCheckBoxes.get(i).setLayoutY(300 + (i * 50));
                    nameCheckBoxes.get(i).setDisable(true);
                    nameCheckBoxes.get(i).setText("");
                    nameCheckBoxes.get(i).setFont(Font.font("Verdana",
                            FontWeight.BOLD, 24));
                }
            }
            
            //Sets name in checkbox for current
            nameCheckBoxes.get(0).setText(play_order.get(0).name);
            
            //Calls character label update function
            updateCharacters();
            
            //Sets stage for action function
            stage = 7;
            
            //AI Function
            if(play_order.get(0).computer){
                //AI FUNCTION HERE (people)
            }
        });
        
        //Button action leads to beer
        Button12.setOnAction(f -> {
            //Calls action funciton
            action();
            
            //Subs 1 from beer total
            diceOutcome.put("Beer",(int)diceOutcome.get("Beer") - 1);
            
            //Calls character label update function
            updateCharacters();
            
            //Makes group for next scene
            Group group = new Group();
            group = stageSet(group);
            
            //Sets scene
            scene5 = new Scene(group, 1280, 720, Color.BEIGE);
            
            //Makes scene and shows
            window.setScene(scene5);
            window.show();
            
            //Prompts who to heal
            Line1.setText(current.name + ", who do you want to heal: ");
            
            //Formats Checkboxes
            for (int i = 0; i < nameCheckBoxes.size(); i++) {
                nameCheckBoxes.get(i).setSelected(false);
                if (i < play_order.size()) {
                    nameCheckBoxes.get(i).setLayoutX(500);
                    nameCheckBoxes.get(i).setLayoutY(300 + (i * 50));
                    if(play_order.get(i).health != play_order.get(i)
                            .maxHealth){
                        nameCheckBoxes.get(i).setDisable(play_order.get(0)
                                .computer); 
                     }
                     else{
                         nameCheckBoxes.get(i).setDisable(true);
                     }  
                    nameCheckBoxes.get(i).setText(play_order.get(i).name);
                    nameCheckBoxes.get(i).setFont(Font.font("Verdana",
                            FontWeight.BOLD, 24));
                } else {
                    nameCheckBoxes.get(i).setLayoutX(500);
                    nameCheckBoxes.get(i).setLayoutY(300 + (i * 50));
                    nameCheckBoxes.get(i).setDisable(true);
                    nameCheckBoxes.get(i).setText("");
                    nameCheckBoxes.get(i).setFont(Font.font("Verdana",
                            FontWeight.BOLD, 24));
                }
            }
            
            //Calls character label update function
            updateCharacters();
            
            //Sets stage for action function
            stage = 8;
            
            //AI Function
            if(play_order.get(0).computer){
                //AI FUNCTION HERE (people)
            }
        });
        
        //Button Actions leads to Gatling
        Button13.setOnAction(f -> {
            //Calls action function
            action();
            
            //Sets variable to default variable
            gatAttack = false;
            
            //Calls character label update function
            updateCharacters();
            
            //Makes group for next scene
            Group group = new Group();
            group = stageSet(group);
            
            //Sets scene
            scene5 = new Scene(group, 1280, 720, Color.BEIGE);
            
            //Makes scene and shows
            window.setScene(scene5);
            window.show();
            
            //Formats checkboxes
            for (int i = 0; i < nameCheckBoxes.size(); i++) {
                if (i < play_order.size()) {
                    nameCheckBoxes.get(i).setLayoutX(500);
                    nameCheckBoxes.get(i).setLayoutY(300 + (i * 50));
                    nameCheckBoxes.get(i).setDisable(true); 
                    nameCheckBoxes.get(i).setText(play_order.get(i).name);
                    nameCheckBoxes.get(i).setFont(Font.font("Verdana",
                            FontWeight.BOLD, 24));
                } else {
                    nameCheckBoxes.get(i).setLayoutX(500);
                    nameCheckBoxes.get(i).setLayoutY(300 + (i * 50));
                    nameCheckBoxes.get(i).setDisable(true);
                    nameCheckBoxes.get(i).setText("");
                    nameCheckBoxes.get(i).setFont(Font.font("Verdana",
                            FontWeight.BOLD, 24));
                }
            }
            
            //Prompts they have a gatling gun
            Line1.setText(current.name + ", you have used a Gatling Gun!");
            
            //Calls character label update function
            updateCharacters();
            
            //Sets stage for action function
            stage = 9;
        });
        
        //Button Action leads to duel
        Button14.setOnAction(f -> {
            //Calls action function
            action();
            
            //Subs 1 from dictionary for total
            diceOutcome.put("Duel",(int)diceOutcome.get("Duel") - 1);
            
            //Calls character label update function
            updateCharacters();
            
            //Makes group for next scene
            Group group = new Group();
            group = stageSet(group);
            
            //Sets scene
            scene5 = new Scene(group, 1280, 720, Color.BEIGE);
            
            //Makes scene and shows
            window.setScene(scene5);
            window.show();
            
            //Formats checkboxes
            for (int i = 0; i < nameCheckBoxes.size(); i++) {
                nameCheckBoxes.get(i).setDisable(false);
                if (i < play_order.size()) {
                    nameCheckBoxes.get(i).setLayoutX(500);
                    nameCheckBoxes.get(i).setLayoutY(300 + (i * 50));
                    System.out.println(temp_play_order.get(i).name);
                    if(i != 0 && i < play_order.size()){
                        if(temp_play_order2.contains(play_order.get(i))){
                            nameCheckBoxes.get(i).setDisable(play_order.get(0)
                                    .computer); 
                        }
                        else{
                            nameCheckBoxes.get(i).setDisable(true);
                        }
                    }
                    else{
                        nameCheckBoxes.get(i).setDisable(true);
                    }  
                    nameCheckBoxes.get(i).setText(play_order.get(i).name);
                    nameCheckBoxes.get(i).setFont(Font.font("Verdana",
                            FontWeight.BOLD, 24));
                } else {
                    nameCheckBoxes.get(i).setLayoutX(500);
                    nameCheckBoxes.get(i).setLayoutY(300 + (i * 50));
                    nameCheckBoxes.get(i).setDisable(true);
                    nameCheckBoxes.get(i).setText("");
                    nameCheckBoxes.get(i).setFont(Font.font("Verdana",
                            FontWeight.BOLD, 24));
                }
            }
            
            //Prompts who to duel
            Line1.setText(current.name + ", who do you want to duel: ");
            
            //Calls character label update function
            updateCharacters();
            
            //Updates stage for action function
            stage = 10;
            
            //AI Function
            if(play_order.get(0).computer){
                //AI FUNCTION HERE(people)
            }
        });
        
        //Text for Volume on Main Menu
        volumeText.setText("Volume: ");
        textMove(volumeText, "Volume: ", 700, 495, 22);

        //Makes group for main menu scene
        Group group1 = new Group();
        
        // <easterEgg>
        //logo.setPickOnBounds(true);
        logo.setOnMouseClicked((MouseEvent easterEgg) -> { 
            System.out.println("Clicked on logo! Easter egg displayed.");
            
            Label label_easterEgg = new Label("This project SUCKS!!!\n"
                    + "Like seriously, f*ck this class and f*ck this project.\n"
                    + "Oh, and f*ck COVID-19.");
            label_easterEgg.setAlignment(Pos.CENTER_LEFT);
            label_easterEgg.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
            label_easterEgg.setLayoutX(50);
            label_easterEgg.setLayoutY(350);
            
            Label label_easterEgg2 = new Label("With lots of f\u2764cking love,"
                    + "\n\u2764 Coronavirus\n" + "\u2764 Jorge Carlos\n" + 
                    "\u2764 Mihir Patel\n" + "\u2764 Ryan Browning\n" + 
                    "\u2764 Sagarika KC\n" + "\u2764 Shafat Rakin\n");
            label_easterEgg2.setAlignment(Pos.CENTER_LEFT);
            label_easterEgg2.setFont(Font.font("Verdana", FontWeight.BOLD,
                                    FontPosture.ITALIC, 18));
            label_easterEgg2.setLayoutX(50);
            label_easterEgg2.setLayoutY(475);
            music.stop();
            media = new Media(this.getClass().getResource(
                    "/bang/media/coffin.mp3").toString());
            music = new MediaPlayer(media); 
            music.play();
            musicSlider.setValue(.1);
            music.setVolume(musicSlider.getValue());
            music.setCycleCount(100);
            logo.setImage(img_gif);
            playerName.setText("Name for Obituary");
            startButton.setText("ENTER THE COFFIN!");
            
            group1.getChildren().addAll(label_easterEgg, label_easterEgg2);
        });
        // </easterEgg>
        
        //Sets group
        Group group2 = new Group();
        group1.getChildren()
                .addAll(table, logo, playerName, numPlayers, label_numPlayers,
                        startButton, cb1, musicSlider, volumeText);
        
        // group all the above together
        group2.getChildren()
                .addAll(table2, nextButton, Line1, Line2, Line3, Line4, Line5,
                        Line6, Line7, Line8, Line9, main1, main2, main3, main4,
                        main5, main6, main7, main8);

        //Sets scene
        scene1 = new Scene(group1, 1280, 720, Color.BEIGE);
        //Sets icon, title, and non-resizeable
        window.getIcons().add(img_logo);
        window.setTitle("BANG! Dice Game");
        window.setResizable(false);
        
        //Makes scene and shows
        window.setScene(scene1);
        window.show();

        //Sets scene 2
        scene2 = new Scene(group2, 1280, 720, Color.BEIGE);

    }

    public void resetDictionary(){
        //Adds dice names to dictionary and sets key to zero
        diceOutcome.put("Indian Arrow", 0);
        diceOutcome.put("Dynamite", 0);
        diceOutcome.put("Duel", 0);
        diceOutcome.put("Whiskey", 0);
        diceOutcome.put("Gatling", 0);
        diceOutcome.put("Bull's Eye 1", 0);
        diceOutcome.put("Bull's Eye 2", 0);
        diceOutcome.put("Beer", 0);
        diceOutcome.put("Double Bull's Eye 1", 0);
        diceOutcome.put("Double Bull's Eye 2", 0);
        diceOutcome.put("Double Gatling", 0);
        diceOutcome.put("Bullet", 0);
        diceOutcome.put("Broken Indian Arrow", 0);
        diceOutcome.put("Double Beer", 0);
    }
    
    public void action(){
        //Switch on stage
        switch(stage){
            case 1:
                //Kit actions
                for(int i = 0; i < play_order.size(); i++){
                    if(nameCheckBoxes.get(i).isSelected()){
                        pick = play_order.get(i);
                        System.out.println(i);
                        nameCheckBoxes.get(i).setSelected(false);
                        break;
                    }
                }
                if(!(pick.name.equals("NULL"))){
                    System.out.println(pick.name);
                    System.out.println("Minus arrow");
                    pick.arrows--;
                    arrow++;
                    updateCharacters();
                }
                pick = new Player("NULL", 99, "NULL", true);
                break;
            case 2:
                //Calamity action
                for(int i = 0; i < play_order.size(); i++){
                    if(nameCheckBoxes.get(i).isSelected()){
                        pick = play_order.get(i);
                        nameCheckBoxes.get(i).setSelected(false);
                        break;
                    }
                }
                if(!(pick.name.equals("NULL"))){
                    pick.damage(1);
                    if(!gringo && pick.name.equals("El Gringo")){
                        gringo = true;
                        current.addArrow(1);
                        arrow--;
                        if(arrow <= 0){
                            BANG.indianAttack(play_order);
                        }
                    }
                    if(pick.name.equals("Pedro Ramirez") && pick.arrows > 0){
                        pick.removeArrow(1);
                        arrow++;
                    }
                    if (pick.health <= 0) {
                        arrow += pick.arrows;
                        pick.arrows = 0;
                        deathSeq(play_order, pick);
                    }
                    updateCharacters();
                }
                pick = new Player("NULL", 99, "NULL", true);
                break;
            case 3:
                //Calamity action (Double)
                for(int i = 0; i < play_order.size(); i++){
                    if(nameCheckBoxes.get(i).isSelected()){
                        pick = play_order.get(i);
                        nameCheckBoxes.get(i).setSelected(false);
                        break;
                    }
                }
                if(!(pick.name.equals("NULL"))){
                    pick.damage(2);
                    if(!gringo && pick.name.equals("El Gringo")){
                        gringo = true;
                        current.addArrow(1);
                        arrow--;
                        if(arrow <= 0){
                            BANG.indianAttack(play_order);
                        }
                    }
                    if(pick.name.equals("Pedro Ramirez") && pick.arrows > 0){
                        pick.removeArrow(1);
                        arrow++;
                    }
                    if (pick.health <= 0) {
                        arrow += pick.arrows;
                        pick.arrows = 0;
                        deathSeq(play_order, pick);
                    }
                    updateCharacters();
                }
                pick = new Player("NULL", 99, "NULL", true);
                temp2--;
                break;
            case 4:
                //BE1
                for(int i = 0; i < play_order.size(); i++){
                    if(nameCheckBoxes.get(i).isSelected()){
                        pick = play_order.get(i);
                        nameCheckBoxes.get(i).setSelected(false);
                        break;
                    }
                }
                if(!(pick.name.equals("NULL"))){
                    if(slab.isSelected()){
                        Slab = true;
                        pick.damage(2);
                    }
                    else{
                      pick.damage(1);  
                    }
                    if(!gringo && pick.name.equals("El Gringo")){
                        gringo = true;
                        current.addArrow(1);
                        arrow--;
                        if(arrow <= 0){
                            BANG.indianAttack(play_order);
                        }
                    }
                    if(pick.name.equals("Pedro Ramirez") && pick.arrows > 0){
                        pick.removeArrow(1);
                        arrow++;
                    }
                    if (pick.health <= 0) {
                        arrow += pick.arrows;
                        pick.arrows = 0;
                        deathSeq(play_order, pick);
                    }
                    updateCharacters();
                }
                pick = new Player("NULL", 99, "NULL", true);
                break;
            case 5:
                //DBE1
                for(int i = 0; i < play_order.size(); i++){
                    if(nameCheckBoxes.get(i).isSelected()){
                        pick = play_order.get(i);
                        nameCheckBoxes.get(i).setSelected(false);
                        break;
                    }
                }
                if(!(pick.name.equals("NULL"))){
                    if(slab.isSelected()){
                        Slab = true;
                        pick.damage(4);
                    }
                    else{
                      pick.damage(2);  
                    }
                    if(!gringo && pick.name.equals("El Gringo")){
                        gringo = true;
                        current.addArrow(1);
                        arrow--;
                        if(arrow <= 0){
                            BANG.indianAttack(play_order);
                        }
                    }
                    if(pick.name.equals("Pedro Ramirez") && pick.arrows > 0){
                        pick.removeArrow(1);
                        arrow++;
                    }
                    if (pick.health <= 0) {
                        arrow += pick.arrows;
                        pick.arrows = 0;
                        deathSeq(play_order, pick);
                    }
                    updateCharacters();
                }
                pick = new Player("NULL", 99, "NULL", true);
                break;
            case 6:
                //BE2
                for(int i = 0; i < play_order.size(); i++){
                    if(nameCheckBoxes.get(i).isSelected()){
                        pick = play_order.get(i);
                        nameCheckBoxes.get(i).setSelected(false);
                        break;
                    }
                }
                if(!(pick.name.equals("NULL"))){
                    if(slab.isSelected()){
                        Slab = true;
                        pick.damage(2);
                    }
                    else{
                      pick.damage(1);  
                    }
                    if(!gringo && pick.name.equals("El Gringo")){
                        gringo = true;
                        current.addArrow(1);
                        arrow--;
                        if(arrow <= 0){
                            BANG.indianAttack(play_order);
                        }
                    }
                    if(pick.name.equals("Pedro Ramirez") && pick.arrows > 0){
                        pick.removeArrow(1);
                        arrow++;
                    }
                    if (pick.health <= 0) {
                        arrow += pick.arrows;
                        pick.arrows = 0;
                        deathSeq(play_order, pick);
                    }
                    updateCharacters();
                }
                pick = new Player("NULL", 99, "NULL", true);
                break;
            case 7:
                //DBE2
                for(int i = 0; i < play_order.size(); i++){
                    if(nameCheckBoxes.get(i).isSelected()){
                        pick = play_order.get(i);
                        nameCheckBoxes.get(i).setSelected(false);
                        break;
                    }
                }
                if(!(pick.name.equals("NULL"))){
                    if(slab.isSelected()){
                        Slab = true;
                        pick.damage(4);
                    }
                    else{
                      pick.damage(2);  
                    }
                    if(!gringo && pick.name.equals("El Gringo")){
                        gringo = true;
                        current.addArrow(1);
                        arrow--;
                        if(arrow <= 0){
                            BANG.indianAttack(play_order);
                        }
                    }
                    if(pick.name.equals("Pedro Ramirez") && pick.arrows > 0){
                        pick.removeArrow(1);
                        arrow++;
                    }
                    if (pick.health <= 0) {
                        arrow += pick.arrows;
                        pick.arrows = 0;
                        deathSeq(play_order, pick);
                    }
                    updateCharacters();
                }
                pick = new Player("NULL", 99, "NULL", true);
                break;
            case 8:
                //Beer
                for(int i = 0; i < play_order.size(); i++){
                    if(nameCheckBoxes.get(i).isSelected()){
                        pick = play_order.get(i);
                        nameCheckBoxes.get(i).setSelected(false);
                        break;
                    }
                }
                if(!(pick.name.equals("NULL"))){
                    pick.heal(1);
                    updateCharacters();
                }
                pick = new Player("NULL", 99, "NULL", true);
                break;
            case 9:
                //Gatling
                for(int i = 1; i < play_order.size(); i++){
                    if(!play_order.get(i).name.equals("Paul Regret")){
                       play_order.get(i).damage(1); 
                    }
                    if(!gringo && play_order.get(i).name.equals("El Gringo")){
                        gringo = true;
                        current.addArrow(1);
                        arrow--;
                        if(arrow <= 0){
                            BANG.indianAttack(play_order);
                        }
                    }
                    if(play_order.get(i).name.equals("Pedro Ramirez") && 
                            play_order.get(i).arrows > 0){
                        play_order.get(i).removeArrow(1);
                        arrow++;
                    }
                    if (play_order.get(i).health <= 0) {
                        arrow += play_order.get(i).arrows;
                        play_order.get(i).arrows = 0;
                        deathSeq(play_order, i);
                    }
                    
                }
                break;
            case 10:
                //Duel
                for(int i = 0; i < play_order.size(); i++){
                    if(nameCheckBoxes.get(i).isSelected()){
                        pick = play_order.get(i);
                        System.out.println(pick.name + " was picked for duel");
                        nameCheckBoxes.get(i).setSelected(false);
                        break;
                    }
                }
                if(!(pick.name.equals("NULL"))){
                    tempP = pick;
                    temp_play_order2.remove(tempP);
                    if(!play_order.get(0).computer){
                        System.out.println(tempP.name +
                                " was removed from the list");
                    }
                    while (dice.get(0).sides[dice.get(0).side].equals("Duel")) {
                        tempP = pick;
                        dice.get(0).roll();
                        if (!(dice.get(0).sides[dice.get(0).side]
                                .equals("Duel"))) {
                            break;
                        }
                        tempP = play_order.get(0);
                        dice.get(0).roll();
                    }
                    tempP.damage(1);
                    if(!gringo && pick.name.equals("El Gringo")){
                        gringo = true;
                        current.addArrow(1);
                        arrow--;
                        if(arrow <= 0){
                            BANG.indianAttack(play_order);
                        }
                    }
                    if(pick.name.equals("Pedro Ramirez") && pick.arrows > 0){
                        pick.removeArrow(1);
                        arrow++;
                    }
                    if (tempP.health <= 0) {
                        arrow += tempP.arrows;
                        tempP.arrows = 0;
                        deathSeq(play_order, tempP);
                    }
                    System.out.println(tempP.name + "Lost the duel!");
                    updateCharacters();
                }
                
                pick = new Player("NULL", 99, "NULL", true);
                break;
            default:
                System.out.println("Stage 0");
        }
    }
    
    public Group stageSet(Group group){
        System.out.println("Stage: " + stage);
        if(current.name.equals("Kit Carlson") && temp > 0 && arrow <= 8 &&
                stage <= 1){
            group.getChildren().clear();
                group.getChildren()
                    .addAll(table2,
                            Button6, Line1, Line2, Line3, Line4, Line5, Line6,
                            Line7, Line8, Line9, main1, main2, main3, main4,
                            main5, main6, main7, main8,
                            nc1, nc2, nc3, nc4, nc5, nc6, nc7, nc8);

        }
        else if(play_order.get(0).name.equals("Calamity Janet") && temp > 0 &&
                stage <= 2){
            group.getChildren().clear();
                group.getChildren()
                    .addAll(table2,
                            Button7, Line1, Line2, Line3, Line4, Line5, Line6,
                            Line7, Line8, Line9, main1, main2, main3, main4,
                            main5, main6, main7, main8,
                            nc1, nc2, nc3, nc4, nc5, nc6, nc7, nc8);

        }
        else if(play_order.get(0).name.equals("Calamity Janet") && temp2 > 0 &&
                stage <= 3){
            group.getChildren().clear();
                group.getChildren()
                    .addAll(table2,
                            Button15, Line1, Line2, Line3, Line4, Line5, Line6,
                            Line7, Line8, Line9, main1, main2, main3, main4,
                            main5, main6, main7, main8,
                            nc1, nc2, nc3, nc4, nc5, nc6, nc7, nc8);

        }
        else if((int)diceOutcome.get("Bull's Eye 1") > 0 && stage <= 4 &&
                !current.name.equals("Calamity Janet")){
            System.out.println("SLAB DD!");
            group.getChildren().clear();
                group.getChildren()
                    .addAll(table2, 
                            Button8, Line1, Line2, Line3, Line4, Line5, Line6,
                            Line7, Line8, Line9, main1, main2, main3, main4, 
                            main5, main6, main7, main8,
                            nc1, nc2, nc3, nc4, nc5, nc6, nc7, nc8);

        }
        else if((int)diceOutcome.get("Double Bull's Eye 1") > 0 && stage < 5 &&
                !current.name.equals("Calamity Janet")){
            System.out.println("SLAB DD!");
            group.getChildren().clear();
                group.getChildren()
                    .addAll(table2,
                            Button9, Line1, Line2, Line3, Line4, Line5, Line6,
                            Line7, Line8, Line9, main1, main2, main3, main4,
                            main5, main6, main7, main8,
                            nc1, nc2, nc3, nc4, nc5, nc6, nc7, nc8);  
        }
        else if((int)diceOutcome.get("Bull's Eye 2") > 0 && stage <= 6 &&
                !current.name.equals("Calamity Janet")){
            System.out.println("SLAB DD!");
            group.getChildren().clear();
                group.getChildren()
                    .addAll(table2, 
                            Button10, Line1, Line2, Line3, Line4, Line5, Line6,
                            Line7, Line8, Line9, main1, main2, main3, main4,
                            main5, main6, main7, main8,
                            nc1, nc2, nc3, nc4, nc5, nc6, nc7, nc8); 
        }
        else if((int)diceOutcome.get("Double Bull's Eye 2") > 0 && stage < 7 &&
                !current.name.equals("Calamity Janet")){
            System.out.println("SLAB DD!");
            group.getChildren().clear();
                group.getChildren()
                    .addAll(table2,
                            Button11, Line1, Line2, Line3, Line4, Line5, Line6,
                            Line7, Line8, Line9, main1, main2, main3, main4,
                            main5, main6, main7, main8,
                            nc1, nc2, nc3, nc4, nc5, nc6, nc7, nc8);   
        }
        else if((int)diceOutcome.get("Beer") + (int)diceOutcome.get(
                "Double Beer") > 0 && stage < 8){
            group.getChildren().clear();
                group.getChildren()
                    .addAll(table2,
                            Button12, Line1, Line2, Line3, Line4, Line5, Line6,
                            Line7, Line8, Line9, main1, main2, main3, main4,
                            main5, main6, main7, main8,
                            nc1, nc2, nc3, nc4, nc5, nc6, nc7, nc8); 
        }
        else if(gatAttack && stage < 9){
            group.getChildren().clear();
                group.getChildren()
                    .addAll(table2,
                            Button13, Line1, Line2, Line3, Line4, Line5, Line6,
                            Line7, Line8, Line9, main1, main2, main3, main4,
                            main5, main6, main7, main8,
                            nc1, nc2, nc3, nc4, nc5, nc6, nc7, nc8);   
        }
        
        else if(((int)diceOutcome.get("Duel") > 0) && stage <= 10){
            group.getChildren().clear();
                group.getChildren()
                    .addAll(table2,
                            Button14, Line1, Line2, Line3, Line4, Line5, Line6,
                            Line7, Line8, Line9, main1, main2, main3, main4,
                            main5, main6, main7, main8,
                            nc1, nc2, nc3, nc4, nc5, nc6, nc7, nc8);   
        }
        else{
            group.getChildren().clear();
                group.getChildren()
                    .addAll(table2,
                            nextButton, Line1, Line2, Line3, Line4, Line5, Line6,
                            Line7, Line8, Line9, main1, main2, main3, main4, 
                            main5, main6, main7, main8,
                            nc1, nc2, nc3, nc4, nc5, nc6, nc7, nc8);
            
        }
        return group;
    }
    
    public void textMove(Label line, String text, int x, int y, int fontSize) {
        line.setText(text);
        line.setLayoutX(x);
        line.setLayoutY(y);
        line.setFont(Font.font("Verdana", FontWeight.BOLD, fontSize));
    }

    public void imageSet(ImageView img, int width, int height, Image imgage) {
        img.setImage(imgage);
        img.setFitWidth(width);
        img.setFitHeight(height);
    }

    public void imageMove(ImageView img, int x, int y) {
        img.setLayoutX(x);
        img.setLayoutY(y);
    }
    
    public void updateCharacters(){
       for(int i = 0; i< lines.size(); i += 2){
            lines.get(i).setLayoutX(20);
            lines.get(i).setLayoutY((i+1) * 20);
            lines.get(i).setFont(Font.font("Verdana", FontWeight.BOLD, 18));
            lines.get(i+1).setLayoutX(20);
            lines.get(i+1).setLayoutY((int)lines.get(i).getLayoutY() + 16);
            lines.get(i+1).setFont(Font.font("Verdana", FontWeight.BOLD, 18));

            if((i < (players+1)*2) && temp_play_order.get((i+1)/2).shown && 
                    (i+1)%2 == 1)
            {
                lines.get(i).setText(temp_play_order.get((i+1)/2).displayName + 
                        "(" + temp_play_order.get((i+1)/2).role + ")");
                lines.get(i+1).setText("HP: " + temp_play_order.get((i+1)/2)
                        .health + " Arrows: " + temp_play_order.get((i+1)/2)
                                .arrows);
            }
            else if(i < ((players+1)*2) && (i+1)%2 == 1)
            {
                lines.get(i).setText(temp_play_order.get((i+1)/2).displayName 
                        + "(Unknown)");
                lines.get(i+1).setText("HP: " + temp_play_order.get((i+1)/2)
                        .health + " Arrows: " + temp_play_order.get((i+1)/2)
                                .arrows);
            }
        }  
    }

    EventHandler eh2 = new EventHandler<ActionEvent>() {                        //Event handler for character selected
        @Override
        public void handle(ActionEvent event) {
            if (event.getSource() instanceof CheckBox) {
                for (int j = 0; j < nameCheckBoxes.size(); j++) {               //For the size of the nameCheckboxes ArrayList    
                    if (nameCheckBoxes.get(j).isSelected()) {                     //If the checkbox is checked
                        for (int i = 0; i < nameCheckBoxes.size(); i++) {           //For the the size of the ArrayList
                            nameCheckBoxes.get(i).setDisable(true);                   //Disable the checkboxes
                        }
                        nameCheckBoxes.get(j).setDisable(false);                    //Set the selected one to enabled
                    } 
                    else {                                                        //If none are selected
                        switch (stage) {                                          //Switch based on the stage
                            case -1:                                                //If Sid's stage
                                for (int i = 0; i < play_order.size(); i++) {         //For all players
                                    nameCheckBoxes.get(i).setDisable(false);            //Set enabled
                                }   break;
                            case 4:
                            case 5:                                                   //For Bull's Eye 1 and Bull's eye 1 Double
                                nameCheckBoxes.get(1).setDisable(false);                //Set one away enabled
                                nameCheckBoxes.get(nameCheckBoxes.size()-1)
                                        .setDisable(false);                             //Set one away enabled
                                break;
                            case 6:
                            case 7:                                                   //For Bull's Eye 2 and Bull's eye 2 Double
                                nameCheckBoxes.get(2).setDisable(false);                //Set two away enabled
                                nameCheckBoxes.get(nameCheckBoxes.size()-2)
                                        .setDisable(false);                             //Set two away enabled
                                break;
                            default:                                              //I have this here just in case, never needed it ¯\_(ツ)_/¯
                                break;
                        }
                    }
                }
            }
        }
    };
    
    EventHandler eh1 = new EventHandler<ActionEvent>() {                        //Event Handler for dice selected
        @Override
        public void handle(ActionEvent event) {
            if (event.getSource() instanceof CheckBox) {                        
                //Switch based on the current name of the character
                switch (current.name) {
                case "Jose Delgado":                                            //If current Jose Delgado
                    if(c5.isSelected()){                                          //If c5 is selected
                        c7.setDisable(true);                                        //Set c7 to disable
                    }
                    else if (!c5.isSelected()){                                   //If c5 is not selected
                        if(!c6.isSelected()){                                       //If c6 is not selected
                            c7.setDisable(play_order.get(0).computer);                //Don't disable if not a computer
                        }
                    }
                    if(c7.isSelected()){                                          //If c7 is slected
                        c5.setDisable(true);                                        //set c5 disabled
                        c6.setDisable(true);                                        //set c6 disabled
                    }
                    else if (!c7.isSelected()){                                   //If c7 is not selected
                        c5.setDisable(play_order.get(0).computer);                  //Don't disable if not a computer
                        c6.setDisable(play_order.get(0).computer);                  //Don't disable if not a computer
                    }
                    if(c6.isSelected()){                                          //If c6 is selected
                        c7.setDisable(true);                                        //Disable c7
                    }
                    else if(!c6.isSelected()){                                    //If c6 is not sleected
                        if(!c5.isSelected()){                                       //If c5 is not selected
                            c7.setDisable(play_order.get(0).computer);                //Don't disable if not a computer
                        }
                        if(dice.contains(d6)){                                    //If d6 was in dice
                            dice.remove(d6);                                        //Remove it
                        }
                    }
                    break;
                case "Tequila Joe":                                             //If current is Tequila Joe
                    if(c5.isSelected()){                                          //If c5 is selected
                        c6.setDisable(true);                                        //Disable c6
                    }
                    else if(!c5.isSelected()){                                    //If c5 is not selected
                        if(!c7.isSelected()){                                       //If c7 is not selected
                            c6.setDisable(play_order.get(0).computer);                //Don't disable if not a computer
                        }
                    }
                    if(c6.isSelected()){                                          //If c6 is selected
                        c5.setDisable(true);                                        //Diable c5
                        c7.setDisable(true);                                        //Disable c7
                    }
                    else if(!c6.isSelected()){                                    //If c6 is not selected
                        c5.setDisable(play_order.get(0).computer);                  //Don't disable if not a computer
                        c7.setDisable(play_order.get(0).computer);                  //Don't disable if not a computer
                    }
                    if(c7.isSelected()){                                          //If c7 is selected
                        c6.setDisable(true);                                        //Disable c6
                    }
                    else if(!c7.isSelected()){                                    //If c7 is not selected
                        if(!c5.isSelected()){                                       //If c5 is not selected
                            c6.setDisable(play_order.get(0).computer);                //Don't disable if not a computer
                        }
                        if(dice.contains(d6)){                                      //If d6 was in dice
                            dice.remove(d6);                                          //Remove it
                        }
                    }
                    break;
                default:                                                        //If current is anyone else
                        if(c5.isSelected()){                                      //If c5 is selected
                            c6.setDisable(true);                                    //Disable c6
                            c7.setDisable(true);                                    //Disable c7
                        }
                        else if(c6.isSelected()){                                 //If c6 is selected
                            c5.setDisable(true);                                    //Disable c5
                            c7.setDisable(true);                                    //Disable c7
                        }
                        else if(c7.isSelected()){                                 //If c7 is selected
                            c6.setDisable(true);                                    //Disable c6
                            c5.setDisable(true);                                    //Disable c5
                        }
                        else{                                                     //If non are selected
                            c5.setDisable(play_order.get(0).computer);              //Don't disable if not a computer
                            c6.setDisable(play_order.get(0).computer);              //Don't disable if not a computer
                            c7.setDisable(play_order.get(0).computer);              //Don't disable if not a computer
                        }
                    break;
                } 
            }
        }
    };
    
    public void go1(){
        //Sets the number of players in the game to how many AI there are going to be
        players = (int)numPlayers.getValue() - 1; 
        
        //Create Character Cards and adds them to characterCard ArrayList
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
        char_cards.add(new Character_Cards("Jose Delgado", 7));
        char_cards.add(new Character_Cards("Tequila Joe", 7));
        char_cards.add(new Character_Cards("Apache Kid", 9));
        char_cards.add(new Character_Cards("Bill Noface", 9));
        Collections.shuffle(char_cards);                                        //Shuffles to make characters random

        //Adds dice to their ArrayList
        dice.add(d1);
        dice.add(d2);
        dice.add(d3);
        dice.add(d4);
        dice.add(d5);
        
        //A switch to add specific cards based on how many players there are
        switch(players)
        {
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
                Collections.shuffle(role_cards);                                //Shuffles the cards to make roles random
        }
        
        //A switch to give all players(including AI) random characters and rolls
        switch(players){
            case 7:
                ai7 = new Player(char_cards.get(7).name, char_cards.get(7).hp,
                        role_cards.get(7).role, true);
            case 6:
                ai6 = new Player(char_cards.get(6).name, char_cards.get(6).hp,
                        role_cards.get(6).role, true);
            case 5:
                ai5 = new Player(char_cards.get(5).name, char_cards.get(5).hp,
                        role_cards.get(5).role, true);
            case 4:
                ai4 = new Player(char_cards.get(4).name, char_cards.get(4).hp,
                        role_cards.get(4).role, true);
            case 3:
                human = new Player(char_cards.get(0).name, char_cards.get(0).hp,
                        role_cards.get(0).role, false);
                ai1 = new Player(char_cards.get(1).name, char_cards.get(1).hp,
                        role_cards.get(1).role, true);
                ai2 = new Player(char_cards.get(2).name, char_cards.get(2).hp,
                        role_cards.get(2).role, true);
                ai3 = new Player(char_cards.get(3).name, char_cards.get(3).hp,
                        role_cards.get(3).role, true);
        }

        //A debugging tool to show the current players, their health, and their role
        System.out.println
        ("_________________________________________________________");
        System.out.println("Human is " + human.name + ", has " + human.health + 
                ", and is a " + human.role);
        System.out.println("AI1 is " + ai1.name + ", has " + ai1.health + 
                ", and is a " + ai1.role);
        System.out.println("AI2 is " + ai2.name + ", has " + ai2.health + 
                ", and is a " + ai2.role);
        System.out.println("AI3 is " + ai3.name + ", has " + ai3.health +
                ", and is a " + ai3.role);
        System.out.println("AI4 is " + ai4.name + ", has " + ai4.health + 
                ", and is a " + ai4.role);
        System.out.println("AI5 is " + ai5.name + ", has " + ai5.health + 
                ", and is a " + ai5.role);
        System.out.println("AI6 is " + ai6.name + ", has " + ai6.health + 
                ", and is a " + ai6.role);
        System.out.println("AI7 is " + ai7.name + ", has " + ai7.health + 
                ", and is a " + ai7.role);
        System.out.println
        ("_________________________________________________________");

        //A temp list to store all players for UI, game mechanics, and more
        temp_play_order.add(human);
        temp_play_order.add(ai1);
        temp_play_order.add(ai2);
        temp_play_order.add(ai3);
        temp_play_order.add(ai4);
        temp_play_order.add(ai5);
        temp_play_order.add(ai6);
        temp_play_order.add(ai7);

        //Temp variables for helping with making the play order
        int stop = -1;
        boolean sher = false;

        //Making the human's role shown so they know which team they are on
        temp_play_order.get(0).shown = true;
        
        //This figures out who's the Sheriff and the correct playing order
        for (int i = 0; i < 16; i++) {                                          //Does it out of 16 so it goes through the list twice(by using modulo)
            if (!(temp_play_order.get(i % 8).role.equals("NULL"))) {              //If there is an actual player(human or AI)
                if (sher == true) {                                                 //If the sheriff role has been found
                    if (i % 8 == stop) {                                              //If the stopping index has been hit
                        break;                                                          //Stop
                    } 
                    else {                                                            //If not
                        play_order.add(temp_play_order.get(i % 8));                     //Add player to play_order ArryList
                    }
                }
                if (sher == false) {                                                //If the sherrif role hasn't been found yet
                    if (temp_play_order.get(i % 8).role.equals("Sheriff")) {          //Only if that player is the Sheriff
                        temp_play_order.get(i % 8).setMaxHealth(
                                temp_play_order.get(i % 8).maxHealth + 2);            //Add 2 to their max health
                        temp_play_order.get(i % 8).heal(2);                           //Add 2 to their current health
                        temp_play_order.get(i % 8).shown = true;                      //Shown for GUI purpose
                        temp_play_order.get(i % 8).known = true;                      //Known for AI puroise
                        play_order.add(temp_play_order.get(i % 8));                   //Adds them to play_order ArrayList
                        stop = i;                                                     //Stopping index
                        sher = true;                                                  //Sheriff is found
                    }
                }

            }
        }
        
        //Start of play order
        System.out.println("The play order is: ");
        
        //Prints out the play order, starting with sheriff
        for (int j = 0; j < play_order.size(); j++) {
            System.out.println((j + 1) + ") " + play_order.get(j).name);
        }
        
        //End of play order
        System.out.println(
                "_________________________________________________________");

        //Prints out Let's play (Debug)
        try {
            Line1.setText("LET'S PLAY!!!");
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        
        //Creating the Display name(string given at main menu)
        for(int i = 0; i < play_order.size(); i++){                             //For the size of the play_order
            if(play_order.get(i).computer == false){                              //If the player is not a computer{
                play_order.get(i).displayName = playerName.getText();               //Display name is now the String given
                play_order.get(i).displayName = play_order.get(i).displayName.
                        concat(" (");                                               //Concatinates '(' to Display name 
                play_order.get(i).displayName = play_order.get(i).displayName.
                        concat(play_order.get(i).name);                             //Concatinates The character name to the display name
                play_order.get(i).displayName = play_order.get(i).displayName.
                        concat(")");                                                //Concatinates ')' to Display name
            }
        }
        
        //Sets the text for the playing order
        Line1.setText("Playing turn:");
        Line2.setText("1) " + play_order.get(0).displayName);
        Line3.setText("2) " + play_order.get(1).displayName);
        Line4.setText("3) " + play_order.get(2).displayName);
        Line5.setText("4) " + play_order.get(3).displayName);
        if(play_order.size() > 4){                                              //If there are more than 4 players
            Line6.setText("5) " + play_order.get(4).displayName);
        }
        if(play_order.size() > 5){                                              //If there are more than 5 players
            Line7.setText("6) " + play_order.get(5).displayName);
        }
        if(play_order.size() > 6){                                              //If there are more than 6 players
            Line8.setText("7) " + play_order.get(6).displayName);
        }
        if(play_order.size() > 7){                                              //If there are more than 7 players
            Line9.setText("8) " + play_order.get(7).displayName);
        }
    }

    public void go2() {
        
        //Create a Left1 and Right1 player object reference for easier calling later on
        left1 = play_order.get(1);
        right1 = play_order.get(play_order.size() - 1);
        
        //For 2&3 places away, try to make the reference or make the reference the current player
        try {
            left2 = play_order.get(2);
        } catch (Exception a) {
            left2 = current;
        }
        try {
            left3 = play_order.get(3);
        } catch (Exception a) {
            left3 = current;
        }
        try {
            right2 = play_order.get(play_order.size() - 2);
        } catch (Exception a) {
            right2 = current;
        }
        try {
            right3 = play_order.get(play_order.size() - 3);
        } catch (Exception a) {
            right3 = current;
        }

    }

    public void go3() {
        //Set dynamite counter to zero
        dynamite = 0;
        
        //Reset the dictionary and its' keys
        resetDictionary();
        
        //Count up the roll outcomes
        if(current.team != 3){                                                  //If current team is not zombie
            for (int roll = 0; roll < dice.size(); roll++) {                      //For dice 1-5
                if (dice.get(roll).canRoll == true || rolls == 0) {                 //If the dice can be re-rolled or if first time rolling
                    if (checkBoxes2.get(roll).isSelected() || rolls == 0) {           //If the checkbox to re-roll is selected or it's first time rolling
                        dice.get(roll).roll();                                          //Reroll die method
                        String side = dice.get(roll).sides[dice.get(roll).side];        //Store that side's String value
                        diceOutcome.put(side, ((int)diceOutcome.get(side))+1);          //Add that value to the Dictionary
                        if (side.equals("Indian Arrow") && !(current.name
                                .equals("Bill Noface"))) {                              //If the dice is an arrow and current is not Bill Noface
                            current.addArrow(1);                                          //Add arrow to current
                            arrow--;                                                      //Subtract arrow from middle pile
                            if (arrow <= 0) {                                             //If the middle is out of arrows
                                BANG.indianAttack(play_order);                              //Call indian Attack Function
                            }
                        }
                        if (side.equals("Broken Indian Arrow") && current               
                                .arrows != 0) {                                         //If the dice is a broken arrow
                            current.removeArrow(1);                                       //Remove arrow from current player
                        }
                        if (side.equals("Bullet")) {                                    //If the dice is a bullet
                            current.damage(1);                                            //Damage current player
                            if(current.name.equals("Pedro Ramirez") && current
                                    .arrows > 0){                                         //If current is Pedro
                                current.removeArrow(1);                                     //Remove arrow
                                arrow++;                                                    //Add arrow back to the middle
                            }
                            if (current.health <= 0) {                                    //If the current player has less than 1 health
                                arrow += play_order.get(0).arrows;                          //Add all their arrows back to the middle
                                play_order.get(0).arrows = 0;                               //Set their arrows to zero
                                deathSeq(play_order, current);                              //Call the death function
                            }
                        }
                    }
                    else{                                                             //If the dice wasn't selected to be rerolled
                        String side = dice.get(roll).sides[dice.get(roll).side];        //Store the string value
                        diceOutcome.put(side, ((int)diceOutcome.get(side))+1);          //Add to dictionary
                    }
                }
                else{                                                               //If the dice could not be rerolled
                    String side = dice.get(roll).sides[dice.get(roll).side];          //Store String value
                    diceOutcome.put(side, ((int)diceOutcome.get(side))+1);            //Add to dictionary
                }
            }
        }
        else{                                                                     //If they are a part of team zombies
           for (int roll = 2; roll < dice.size(); roll++) {                         //For dice 3-5
                if (dice.get(roll).canRoll == true || rolls == 0) {                   //If the dice can be rerolled or if first roll
                    if (checkBoxes2.get(roll).isSelected() || rolls == 0) {             //If the checkbox was selected or if first roll
                        dice.get(roll).roll();                                            //Reroll the dice
                        String side = dice.get(roll).sides[dice.get(roll).side];          //Store the string value of dice
                        diceOutcome.put(side, ((int)diceOutcome.get(side))+1);            //Add to dictionary
                        if (side.equals("Indian Arrow")) {                                //If dice is an arrow
                            current.addArrow(1);                                            //Add arrow to current
                            arrow--;                                                        //Sub arrow from middle
                            if (arrow <= 0) {                                               //If there are no arrows left
                                BANG.indianAttack(play_order);                                //Indian attack function
                            }
                        }
                        if (side.equals("Broken Indian Arrow") &&                         
                                current.arrows != 0) {                                    //If dice is a broken arrow
                            current.removeArrow(1);                                         //Remove arrow from current
                            arrow++;                                                        //Add arrow back to middle
                        }
                        if (side.equals("Bullet")) {                                      //If the dice is a bullet
                            current.damage(1);                                              //Damage current
                            if(current.name.equals("Pedro Ramirez") &&   
                                    current.arrows > 0){                                    //If current is pedro
                                current.removeArrow(1);                                       //Remove an arrow from current
                                arrow++;                                                      //Add arrow back to middle
                            }
                            if (current.health <= 0) {                                      //If current health is below 1
                                arrow += play_order.get(0).arrows;                            //Add all their arrows back to the middle
                                play_order.get(0).arrows = 0;                                 //Set current arrows to zero
                                deathSeq(play_order, current);                                //Call the death function
                            }
                        }
                    }
                    else{                                                               //If the checkbox is not selected
                        String side = dice.get(roll).sides[dice.get(roll).side];          //Store the string value
                        diceOutcome.put(side, ((int)diceOutcome.get(side))+1);            //Add to dictionary
                    }
                }
                else{                                                                 //If the dice could not be rerolled
                    String side = dice.get(roll).sides[dice.get(roll).side];            //Store string value
                    diceOutcome.put(side, ((int)diceOutcome.get(side))+1);              //Add to dictionary
                }
            }
        }
        
        if((int)diceOutcome.get("Dynamite") >= 3){                              //If the dictionary key for Dynamite is more than 2
            current.damage(1);                                                    //Damage current
            if(current.name.equals("Pedro Ramirez") && current.arrows > 0){       //If current is pedro
                current.removeArrow(1);                                             //Remove an arrow from current
                arrow++;                                                            //Add arrow back to middle
            }
            if (current.health <= 0) {                                            //If current health is below 1
                arrow += play_order.get(0).arrows;                                  //Add arrows back to middle 
                play_order.get(0).arrows = 0;                                       //Set current's arrows to zero
                deathSeq(play_order, current);                                      //Call death function
            }
            
            //Set the re-roll button to disabled
            Button4.setDisable(true);
        }

        //Add a number to the number of re-rolls done
        rolls++;
        
        //Update the character labels
        updateCharacters();
    }

    public void go4() {
        //Set all variables to the default values
        total = 0;
        total2 = 0;
        Gat = 0;
        gatAttack = false;
        
        //Count the number of Whiskey
        if(current.team != 3){                                                  //If not a zombie
            for (int count = 0; count < dice.size(); count++) {                   //for dice 1-5
                String side = dice.get(count).sides[dice.get(count).side];          //Get string value
                if (side.equals("Whiskey")) {                                       //If the dice is whiskey
                    current.heal(1);                                                  //Heal one
                    if (current.name.equals("Greg Digger")) {                         //If gret Digger
                        current.heal(1);                                                //Heal an extra
                    }
                }
            } 
        }
        else{                                                                   //If a zombie
            for (int count = 2; count < dice.size(); count++) {                   //For dice 3-5
                String side = dice.get(count).sides[dice.get(count).side];          //Get string value
                if (side.equals("Whiskey")) {                                       //If the dice is whiskey
                    current.heal(1);                                                  //Heal one
                }
            }
        }
        
        //Store the values of Gatling and total for single and double damage
        Gat = ((int)diceOutcome.get("Gatling")) + (2 * ((int)diceOutcome
                .get("Double Gatling")));
        total = ((int)diceOutcome.get("Bull's Eye 1")) + ((int)diceOutcome
                .get("Bull's Eye 2"));
        total2 = ((int)diceOutcome.get("Double Bull's Eye 2")) +
                ((int)diceOutcome.get("Double Bull's Eye 1"));
        
        //Tell if there is enough gatlings for a gatling gun
        if (Gat >= current.gatsNeeded) {
            gatAttack = true;
        }
    }
}

/*
Things to fix:

ADD: 
Whether they want to use the expansion or not (Fuck this option)
*/