/*
 * Shafat Rakin
 * Collaborator : Ryan Browning
 * CS 2365-001
 * Project 3
 * Spring 2020
 * This file implements a GUI using JavaFX.
 */

package bang;

// imports galore
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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.event.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextFormatter.*;
import java.util.function.UnaryOperator;

public class Bang_fxGUI extends Application {

    public String textField;

    Stage window;
    Scene scene1, scene2, scene3, scene4, scene5, scene6, scene7, scene8, scene9;
    static int arrow = 10;
    static boolean chiefArrow = true;
    static Scanner scan;
    static int players;

    //Global dice images
    // also, images galore
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
    ImageView dice1;
    ImageView dice2;
    ImageView dice3;
    ImageView dice4;
    ImageView dice5;
    ImageView dice6;
    Image Img_Loud;
    Image Img_Coward;
    Image Img_Reg;
    Image Img_Black;
    ImageView dice01;
    ImageView dice02;
    ImageView dice03;
    ImageView dice04;
    ImageView dice05;
    ImageView dice06;
    ImageView dice07;
    ArrayList<ImageView> IV = new ArrayList();
    Media media;
    MediaPlayer music;
   
    //Global creation of lines and UI elements
    // also, labels and buttons galore
    Label Line1 = new Label(textField);
    Label Line2 = new Label(textField);
    Label Line3 = new Label(textField);
    Label Line4 = new Label(textField);
    Label Line5 = new Label(textField);
    Label Line6 = new Label(textField);
    Label Line7 = new Label(textField);
    Label Line8 = new Label(textField);
    Label Line9 = new Label("Volume: ");
    Label main1 = new Label(textField);
    Label main2 = new Label(textField);
    Label main3 = new Label(textField);
    Label main4 = new Label(textField);
    Label main5 = new Label(textField);
    Label main6 = new Label(textField);
    Label main7 = new Label(textField);
    Label main8 = new Label(textField);
    Label volumeText = new Label(textField);
    ArrayList<Label> lines = new ArrayList();
    TextField playerName = new TextField("Enter Name");
    ComboBox numPlayers = new ComboBox();
    CheckBox cb1 = new CheckBox("Music in Game");
    CheckBox c1 = new CheckBox("Old Saloon Die");
    CheckBox c2 = new CheckBox("Old Saloon Die");
    CheckBox c3 = new CheckBox("Regular Die");
    CheckBox c4 = new CheckBox("Regular Die");
    CheckBox c5 = new CheckBox("Regular Die");
    CheckBox c6 = new CheckBox("Loudmouth Die");
    CheckBox c7 = new CheckBox("Coawrd Die");
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
    ArrayList<CheckBox> checkBoxes = new ArrayList();
    ArrayList<CheckBox> checkBoxes2 = new ArrayList();
    ArrayList<CheckBox> nameCheckBoxes = new ArrayList();
    ArrayList<Integer> list = new ArrayList();
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
    Slider musicSlider;
    
    
    //Global creation of game variables 
    int Gat = 0;
    int BE1 = 0;
    int BE2 = 0;
    int DBE1 = 0;
    int DBE2 = 0;
    int duel = 0;
    int total = 0;
    int Beer = 0;
    int rolls = 0;
    int dynamite = 0;
    boolean gringo = false;
    boolean gatAttack = false;
    boolean reroll;
    boolean test;
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
    Dice d6 = new Dice(0, 0, "Indian Arrow", "Dynamite", "Bull's Eye 1", "Bull's Eye 2", "Beer", "Gatling");
    Player human = new Player("NULL", 0, "NULL", false);
    Player ai1 = new Player("NULL", 0, "NULL", true);
    Player ai2 = new Player("NULL", 0, "NULL", true);
    Player ai3 = new Player("NULL", 0, "NULL", true);
    Player ai4 = new Player("NULL", 0, "NULL", true);
    Player ai5 = new Player("NULL", 0, "NULL", true);
    Player ai6 = new Player("NULL", 0, "NULL", true);
    Player ai7 = new Player("NULL", 0, "NULL", true);

    ArrayList<Player> play_order = new ArrayList();
    ArrayList<Player> temp_play_order = new ArrayList();

    //Scene scene1 = new Scene(group1, 1280, 720, Color.BEIGE);
    public static void main(String[] args) {
        // lauches the whole thing
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;

        // load images
        Image img_table = new Image(new FileInputStream("src/bang/media/wood_TableTop.jpg"));
        ImageView table = new ImageView(img_table);
        //Image img_table2 = new Image(new FileInputStream("src/bang/media/wood_TableTop.jpg"));
        ImageView table2 = new ImageView(img_table);
        Image img_logo = new Image(new FileInputStream("src/bang/media/bang.png"));
        ImageView logo = new ImageView(img_logo);

        //Images
        Img_arrow = new Image(new FileInputStream("src/bang/media/Dice/arrow.PNG"));
        Img_BE1 = new Image(new FileInputStream("src/bang/media/Dice/BE1.PNG"));
        Img_BE2 = new Image(new FileInputStream("src/bang/media/Dice/BE2.PNG"));
        Img_Beer = new Image(new FileInputStream("src/bang/media/Dice/Beer.PNG"));
        Img_BrokenArrow = new Image(new FileInputStream("src/bang/media/Dice/BrokenArrow.PNG"));
        Img_Bullet = new Image(new FileInputStream("src/bang/media/Dice/Bullet.PNG"));
        Img_DBE1 = new Image(new FileInputStream("src/bang/media/Dice/DBE1.PNG"));
        Img_DBE2 = new Image(new FileInputStream("src/bang/media/Dice/DBE2.PNG"));
        Img_DBeer = new Image(new FileInputStream("src/bang/media/Dice/DBeer.PNG"));
        Img_DGatling = new Image(new FileInputStream("src/bang/media/Dice/DGatling.PNG"));
        Img_Duel = new Image(new FileInputStream("src/bang/media/Dice/Duel.PNG"));
        Img_Dynamite = new Image(new FileInputStream("src/bang/media/Dice/Dynamite.PNG"));
        Img_Gatling = new Image(new FileInputStream("src/bang/media/Dice/Gatling.PNG"));
        Img_Whiskey = new Image(new FileInputStream("src/bang/media/Dice/Whiskey.PNG"));
        Img_Black = new Image(new FileInputStream("src/bang/media/Dice/B1.PNG"));
        Img_Reg = new Image(new FileInputStream("src/bang/media/Dice/d1.PNG"));
        Img_Loud = new Image(new FileInputStream("src/bang/media/Dice/Loud.PNG"));
        Img_Coward = new Image(new FileInputStream("src/bang/media/Dice/Coward.PNG"));
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
        
        
        //Music
        media = new Media(this.getClass().getResource("/bang/media/background.mp3").toString());
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
        //playerName.setMinSize(125, 30);
        playerName.setAlignment(Pos.CENTER);
        playerName.setLayoutX(700);
        playerName.setLayoutY(350);
        UnaryOperator<Change> modifyChange = c -> {
            if (c.isContentChange()) {
                int newLength = c.getControlNewText().length();
                if (newLength > 16) {
                    // replace the input text with the last len chars
                    String tail = c.getControlNewText().substring(0, 16);
                    c.setText(tail);
                    // replace the range to complete text
                    // valid coordinates for range is in terms of old text
                    int oldLength = c.getControlText().length();
                    c.setRange(0, oldLength);
                }
            }
            return c;
        };
        playerName.setTextFormatter(new TextFormatter(modifyChange));


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
        cb1.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                music.setMute(!cb1.isSelected());
            }
        });
        
        
        // start button & Action
        Button startButton = new Button("Start!");
        startButton.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
        startButton.setLayoutX(700);
        startButton.setLayoutY(550);
        startButton.setMinWidth(350);
        startButton.setMaxWidth(350);
        startButton.setOnAction(e -> {
            textMove(Line9, "", 400, 420, 24);
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
            IV.add(dice1);
            IV.add(dice2);
            IV.add(dice3);
            IV.add(dice4);
            IV.add(dice5);
            IV.add(dice6);

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
                    
                    if((i < (players+1)*2) && temp_play_order.get((i+1)/2).shown && (i+1)%2 == 1)
                    {
                        lines.get(i).setText(temp_play_order.get((i+1)/2).displayName + "(" + temp_play_order.get((i+1)/2).role + ")");
                        lines.get(i+1).setText("HP: " + temp_play_order.get((i+1)/2).health + " Arrows: " + temp_play_order.get((i+1)/2).arrows);
                    }
                    else if(i < ((players+1)*2) && (i+1)%2 == 1)
                    {
                        lines.get(i).setText(temp_play_order.get((i+1)/2).displayName + "(Unknown)");
                        lines.get(i+1).setText("HP: " + temp_play_order.get((i+1)/2).health + " Arrows: " + temp_play_order.get((i+1)/2).arrows);
                    }
                } 
             // group all the above together
             if(play_order.get(0).name.equals("Sid Ketchum"))
             {
                Group group3 = new Group();
                group3.getChildren()
                        .addAll(table2, Button2, Line1, Line2, Line3, Line4, Line5, Line6, Line7, Line8, Line9, main1, main2, main3, main4, main5, main6, main7, main8);
                scene3 = new Scene(group3, 1280, 720, Color.BEIGE);
            } else {
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
                            nc1, nc2, nc3, nc4, nc5, nc6, nc7, nc8);
            scene4 = new Scene(group, 1280, 720, Color.BEIGE);
            window.setScene(scene4);
            window.show();
            for (int i = 0; i < nameCheckBoxes.size(); i++) {
                if (i < play_order.size()) {
                    nameCheckBoxes.get(i).setLayoutX(500);
                    nameCheckBoxes.get(i).setLayoutY(300 + (i * 50));
                    nameCheckBoxes.get(i).setDisable(false);
                    nameCheckBoxes.get(i).setText(play_order.get(i).name);
                    nameCheckBoxes.get(i).setFont(Font.font("Verdana", FontWeight.BOLD, 24));
                } else {
                    nameCheckBoxes.get(i).setLayoutX(500);
                    nameCheckBoxes.get(i).setLayoutY(300 + (i * 50));
                    nameCheckBoxes.get(i).setDisable(true);
                    nameCheckBoxes.get(i).setText("");
                    nameCheckBoxes.get(i).setFont(Font.font("Verdana", FontWeight.BOLD, 24));
                }

            }
            Line1.setText(play_order.get(0).name + ", who do you want to heal?");
            nc1.setOnAction(eh2);
            nc2.setOnAction(eh2);
            nc3.setOnAction(eh2);
            nc4.setOnAction(eh2);
            nc5.setOnAction(eh2);
            nc6.setOnAction(eh2);
            nc7.setOnAction(eh2);
            nc8.setOnAction(eh2);

        });
        // button & Action Without Sid K
        Button3 = new Button("Next");
        Button3.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
        Button3.setLayoutX(1100);
        Button3.setLayoutY(600);
        Button3.setOnAction(f -> {
            rolls = 0;
            Button4.setDisable(false);
            // group all the above together
            Group group = new Group();
            group.getChildren()

                    .addAll(table2, Button4, Line1, Line2, Line3, Line4, Line5, Line6, Line7, Line8, Line9, main1, main2, main3, main4, main5, main6, main7, main8, 
                            c1, c2, c3, c4, c5, c6, c7, dice01, dice02, dice03, dice04, dice05, dice06, dice07);

            scene5 = new Scene(group, 1280, 720, Color.BEIGE);
            window.setScene(scene5);
            window.show();
            Line1.setText("Pick the dice you want to use: ");


            for (int i = 0; i < 7; i++) {
                checkBoxes.get(i).setLayoutX((i * 100) + 450);
                checkBoxes.get(i).setLayoutY(400);
                if (i < 4) {
                    checkBoxes.get(i).setSelected(true);
                    checkBoxes.get(i).setDisable(true);
                }
            }
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
            c7.setText("Coawrd");
            imageSet(dice07, 75, 75, Img_Coward);
            imageMove(dice07, (int)c7.getLayoutX(),(int)c7.getLayoutY() - 92);
            total = 0;
            switch (play_order.get(0).name) {
                case "Jose Delgado":
                    c5.selectedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
                        if(c5.isSelected()){
                            c7.setDisable(true);
                            dice.remove(d5);
                            d5 = new Dice(0, 0, "Indian Arrow", "Dynamite", "Bull's Eye 1", "Bull's Eye 2", "Beer", "Gatling"); //regular die
                            dice.add(d5);
                            total++;
                        }
                        else{
                            if(!c6.isSelected()){
                                c7.setDisable(false);
                            }
                            total--;
                        }
                    }); 
                    c7.selectedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
                        if(c7.isSelected()){
                            c5.setDisable(true);
                            c6.setDisable(true);
                            dice.remove(d5);
                            d5 = new Dice(1, 0, "Indian Arrow", "Dynamite", "Double Bull's Eye 1", "Double Bull's Eye 2", "Bullet", "Double Gatling"); //LOUDMOUTH
                            dice.add(d5);
                            total++;
                        }
                        else{
                            c5.setDisable(false);
                            c6.setDisable(false);
                            total--;
                        }
                    }); 
                    c6.selectedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
                        if(c6.isSelected()){
                            if(dice.contains(d6)){
                                dice.remove(d6);
                            }
                            d6 = new Dice(1, 0, "Broken Indian Arrow", "Dynamite", "Bull's Eye 1", "Indian Arrow", "Double Beer", "Beer");
                            dice.add(d6);
                            c7.setDisable(true);
                            total++;
                        }
                        else{
                            if(!c5.isSelected()){
                                c7.setDisable(false);
                            }
                            if(dice.contains(d6)){
                                dice.remove(d6);
                            }
                            total--;
                        }
                    }); 
                    break;
                case "Tequila Joe":
                    c5.selectedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
                        if(c5.isSelected()){
                            c6.setDisable(true);
                            dice.remove(d5);
                            d5 = new Dice(0, 0, "Indian Arrow", "Dynamite", "Bull's Eye 1", "Bull's Eye 2", "Beer", "Gatling"); //regular die
                            dice.add(d5);
                            total++;
                        }
                        else{
                            if(!c7.isSelected()){
                                c6.setDisable(false);
                            }
                            total--;
                        }
                    }); 
                    c6.selectedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
                        if(c6.isSelected()){
                            c5.setDisable(true);
                            c7.setDisable(true);
                            dice.remove(d5);
                            d5 = new Dice(1, 0, "Indian Arrow", "Dynamite", "Double Bull's Eye 1", "Double Bull's Eye 2", "Bullet", "Double Gatling"); //LOUDMOUTH
                            dice.add(d5);
                            total++;
                        }
                        else{
                            c5.setDisable(false);
                            c7.setDisable(false);
                            total--;
                        }
                    }); 
                    c7.selectedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
                        if(c7.isSelected()){
                            if(dice.contains(d6)){
                                dice.remove(d6);
                            }
                            d6 = new Dice(1, 0, "Broken Indian Arrow", "Dynamite", "Bull's Eye 1", "Indian Arrow", "Double Beer", "Beer");
                            dice.add(d6);
                            c6.setDisable(true);
                            total++;
                        }
                        else{
                            if(!c5.isSelected()){
                                c6.setDisable(false);
                            }
                            if(dice.contains(d6)){
                                dice.remove(d6);
                            }
                            total--;
                            
                        }
                    }); 
                    break;
                default:
                    c5.selectedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
                        if(c5.isSelected()){
                            c6.setDisable(true);
                            c7.setDisable(true);
                            dice.remove(d5);
                            d5 = new Dice(0, 0, "Indian Arrow", "Dynamite", "Bull's Eye 1", "Bull's Eye 2", "Beer", "Gatling"); //regular die
                            dice.add(d5);
                        }
                        else{
                            c6.setDisable(false);
                            c7.setDisable(false);
                        }
                    }); 
                    c6.selectedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
                        if(c6.isSelected()){
                            c5.setDisable(true);
                            c7.setDisable(true);
                            dice.remove(d5);
                            d5 = new Dice(1, 0, "Indian Arrow", "Dynamite", "Double Bull's Eye 1", "Double Bull's Eye 2", "Bullet", "Double Gatling"); //LOUDMOUTH
                            dice.add(d5);
                        }
                        else{
                            c5.setDisable(false);
                            c7.setDisable(false);
                        }
                    }); 
                    c7.selectedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
                        if(c7.isSelected()){
                            c6.setDisable(true);
                            c5.setDisable(true);
                            dice.remove(d5);
                            d5 = new Dice(1, 0, "Broken Indian Arrow", "Dynamite", "Bull's Eye 1", "Indian Arrow", "Double Beer", "Beer"); //COWARD
                            dice.add(d5);
                        }
                        else{
                            c5.setDisable(false);
                            c6.setDisable(false);
                        }
                    });
                    break;
            }
        });
        // REROLL SCENE
        Button4 = new Button("ROLL");
        Button4.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
        Button4.setLayoutX(1000);
        Button4.setLayoutY(600);
        Button4.setOnAction(f -> {
            if(total == 1 && dice.contains(d6)){
                dice.remove(d6);
                dice.remove(d5);
                d5 = d6;
                dice.add(d5);
            }
            if (rolls >= 2) {
                Button4.setDisable(true);
            }
            go3();
            // group all the above together
            if(dice.size() == 5){
                Group group = new Group();
                group.getChildren()
                        .addAll(table2, dice1, dice2, dice3, dice4, dice5,
                                Button4, Button5, Line1, Line2, Line3, Line4, Line5,
                                Line6, Line7, Line8, Line9, main1, main2, main3,
                                main4, main5, main6, main7, main8,
                                cd1, cd2, cd3, cd4, cd5);
                scene5 = new Scene(group, 1280, 720, Color.BEIGE);
                window.setScene(scene5);
                window.show();
            }
            else{
                
                Group group = new Group();
                group.getChildren()
                        .addAll(table2, dice1, dice2, dice3, dice4, dice5, dice6,
                                Button4, Button5, Line1, Line2, Line3, Line4, Line5,
                                Line6, Line7, Line8, Line9, main1, main2, main3,
                                main4, main5, main6, main7, main8,
                                cd1, cd2, cd3, cd4, cd5, cd6);
                scene5 = new Scene(group, 1280, 720, Color.BEIGE);
                window.setScene(scene5);
                window.show();
            }
                Line1.setText("Pick the dice you want to Re-Roll: ");
                System.out.println(dice.size());
                for (int i = 0; i < dice.size(); i++) {
                    checkBoxes2.get(i).setLayoutX((i * 100) + 450);
                    checkBoxes2.get(i).setLayoutY(400);
                    checkBoxes2.get(i).setText("");
                    if (dice.get(i).sides[dice.get(i).side].equals("Dynamite") && play_order.get(0).dynamiteReroll == false) {
                        checkBoxes2.get(i).setSelected(false);
                        checkBoxes2.get(i).setDisable(true);
                        imageSet(IV.get(i), 90, 90, Img_Dynamite);
                        dice.get(i).canRoll = false;
                    } else {
                        checkBoxes2.get(i).setSelected(false);
                        checkBoxes2.get(i).setDisable(false);
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
                    imageMove(IV.get(i), (i * 100) + 410, 300);
                }
                

        });
        // FINAL DICE SCENE
        Button5 = new Button("Next");
        Button5.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
        Button5.setLayoutX(1100);
        Button5.setLayoutY(600);
        Button5.setOnAction(f -> {
            go3();
            // group all the above together
            if(dice.contains(d6)){
               Group group = new Group();
                group.getChildren()
                        .addAll(table2, dice1, dice2, dice3, dice4, dice5, dice6,
                                Button6, Line1, Line2, Line3, Line4, Line5, Line6,
                                Line7, Line8, Line9, main1, main2, main3, main4, main5, main6, main7, main8);
                scene5 = new Scene(group, 1280, 720, Color.BEIGE);
                window.setScene(scene5);
                window.show(); 
            }
            else{
               Group group = new Group();
                group.getChildren()
                        .addAll(table2, dice1, dice2, dice3, dice4, dice5, dice6,
                                Button6, Line1, Line2, Line3, Line4, Line5, Line6,
                                Line7, Line8, Line9, main1, main2, main3, main4, main5, main6, main7, main8);
                scene5 = new Scene(group, 1280, 720, Color.BEIGE);
                window.setScene(scene5);
                window.show();  
            }
            
            Line1.setText("Final Results: ");
        });
        // after FINAL DICE SCENE
        Button6 = new Button("Next");
        Button6.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
        Button6.setLayoutX(1100);
        Button6.setLayoutY(600);
        Button6.setOnAction(f -> {
            go3();
            // group all the above together
            Group group = new Group();
            group.getChildren()
                    .addAll(table2, Button6, dice1, dice2, dice3, dice4, dice5,
                            Line1, Line2, Line3, Line4, Line5, Line6,
                            Line7, Line8, Line9, main1, main2, main3, main4, main5, main6, main7, main8);
            scene5 = new Scene(group, 1280, 720, Color.BEIGE);
            window.setScene(scene5);
            window.show();
            Line1.setText("NEXT PAGE, TO DO \n Final Results: ");

        });

        volumeText.setText("Volume: ");
        textMove(volumeText, "Volume: ", 700, 495, 22);

        // group all the above together
        Group group1 = new Group();
        group1.getChildren()
                .addAll(table, logo, playerName, numPlayers, label_numPlayers,
                        startButton, cb1, musicSlider, volumeText);
        
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

    EventHandler eh2 = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            if (event.getSource() instanceof CheckBox) {
                for (int j = 0; j < nameCheckBoxes.size(); j++) {
                    if (nameCheckBoxes.get(j).isSelected()) {
                        for (int i = 0; i < nameCheckBoxes.size(); i++) {
                            nameCheckBoxes.get(i).setDisable(true);
                            if (nameCheckBoxes.get(i) == nameCheckBoxes.get(j)) {
                                nameCheckBoxes.get(i).setDisable(false);
                            }
                        }
                    } else {
                        for (int i = 0; i < play_order.size(); i++) {
                            nameCheckBoxes.get(i).setDisable(false);
                        }

                    }
                }

            }
        }
    };
    EventHandler eh3 = new EventHandler<ActionEvent>() {    
    @Override
    public void handle(ActionEvent event) {
        if (event.getSource() instanceof CheckBox) {
            if (cb1.isSelected()) {
               music.setAutoPlay(true); 
            } 
            else {
               music.setAutoPlay(true); 
            }
        }
        if (event.getSource() instanceof Slider) {
            music.setVolume(musicSlider.getValue());
        }
        System.out.println("ACTION");
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
        char_cards.add(new Character_Cards("Jose Delgado", 7));
        char_cards.add(new Character_Cards("Tequila Joe", 7));
        Collections.shuffle(char_cards);

        dice.add(d1);
        dice.add(d2);
        dice.add(d3);
        dice.add(d4);
        dice.add(d5);

        scan = new Scanner(System.in);
        boolean test = false;
        Random rand = new Random();
        
        

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
                    human = new Player(char_cards.get(0).name, char_cards.get(0).hp, role_cards.get(0).role, false);//MAKE THIS TRUE TO LET AI DO ALL THE PLAYING
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

        if (players != 2) {
            for (int i = 0; i < 16; i++) {
                if (!(temp_play_order.get(i % 8).role.equals("NULL"))) {
                    if (sher == true) {
                        if (i % 8 == stop) {
                            break;
                        } else {
                            play_order.add(temp_play_order.get(i % 8));
                        }
                    }
                    if (sher == false) {
                        if (temp_play_order.get(i % 8).role.equals("Sheriff")) {
                            temp_play_order.get(i % 8).setMaxHealth(temp_play_order.get(i % 8).maxHealth + 2);
                            temp_play_order.get(i % 8).heal(2);
                            temp_play_order.get(i % 8).shown = true;
                            play_order.add(temp_play_order.get(i % 8));
                            stop = i;
                            sher = true;
                        }
                    }

                }
            }
        } else {
            for (int i = 0; i < 16; i++) {
                if (!(temp_play_order.get(i % 8).role.equals("NULL"))) {
                    if (sher == true) {
                        if (i % 8 == stop) {
                            break;
                        } else {
                            temp_play_order.get(i % 8).shown = true;
                            play_order.add(temp_play_order.get(i % 8));
                        }
                    }
                    if (sher == false) {
                        if (temp_play_order.get(i % 8).role.equals("Deputy")) {
                            temp_play_order.get(i % 8).shown = true;
                            play_order.add(temp_play_order.get(i % 8));
                            stop = i;
                            sher = true;
                        }
                    }

                }
            }
        }
        System.out.println("The play order is: ");
        for (int j = 0; j < play_order.size(); j++) {
            System.out.println((j + 1) + ") " + play_order.get(j).name);
        }
        System.out.println("_________________________________________________________");

        boolean reroll;

        int total_players = play_order.size();

        try {
            Line1.setText("LET'S PLAY!!!");
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        for(int i = 0; i < play_order.size(); i++)
        {
            if(play_order.get(i).computer == false)
            {
                play_order.get(i).displayName = playerName.getText();
                play_order.get(i).displayName = play_order.get(i).displayName.concat(" (");
                play_order.get(i).displayName = play_order.get(i).displayName.concat(play_order.get(i).name);
                play_order.get(i).displayName = play_order.get(i).displayName.concat(")");
            }
        }
            Line1.setText("Playing turn:");
            Line2.setText("1) " + play_order.get(0).displayName);
            Line3.setText("2) " + play_order.get(1).displayName);
            Line4.setText("3) " + play_order.get(2).displayName);
            Line5.setText("4) " + play_order.get(3).displayName);
            if(play_order.size() > 4)
            {
                Line6.setText("5) " + play_order.get(4).displayName);
            }
            if(play_order.size() > 5)
            {
                Line7.setText("6) " + play_order.get(5).displayName);
            }
            if(play_order.size() > 6)
            {
                Line8.setText("7) " + play_order.get(6).displayName);
            }
            if(play_order.size() > 7)
            {
                Line9.setText("8) " + play_order.get(7).displayName);
            }
    }

    public void go2() {
        left1 = play_order.get(1);
        right1 = play_order.get(play_order.size() - 1);
        try {
            left2 = play_order.get(2);
        } catch (Exception a) {
            left2 = play_order.get(0);
        }
        try {
            left3 = play_order.get(3);
        } catch (Exception a) {
            left3 = play_order.get(0);
        }
        try {
            right2 = play_order.get(play_order.size() - 2);
        } catch (Exception a) {
            right2 = play_order.get(0);
        }
        try {
            right3 = play_order.get(play_order.size() - 3);
        } catch (Exception a) {
            right3 = play_order.get(0);
        }

    }

    public void go3() {
        for (int roll = 0; roll < dice.size(); roll++) {
            if (dice.get(roll).canRoll == true) {
                if (rolls == 0) {
                    dice.get(roll).roll();
                } else {
                    if (checkBoxes2.get(roll).isSelected()) {
                        dice.get(roll).roll();
                    }
                }
            }
        }
        dynamite = 0;
        reroll = false;
        System.out.println("Roll results:");
        System.out.println("Dice 1 : " + d1.sides[d1.side]);
        System.out.println("Dice 2 : " + d2.sides[d2.side]);
        System.out.println("Dice 3 : " + d3.sides[d3.side]);
        System.out.println("Dice 4 : " + d4.sides[d4.side]);
        System.out.println("Dice 5 : " + d5.sides[d5.side]);
        for (int i = 0; i < 5; i++) {
            if (dice.get(i).sides[dice.get(i).side].equals("Dynamite")) {
                dynamite++;
            }
            if (dice.get(i).sides[dice.get(i).side].equals("Indian Arrow")) {
                //ADD ARROW PICS HERE AND ALLOW USER TO CHOOSE WHICH ARROW THEY WANT!
                play_order.get(0).addArrow(1);
                if (arrow == 0) {
                    BANG.indianAttack(play_order);
                }
            }
            if (dice.get(i).sides[dice.get(i).side].equals("Broken Indian Arrow")) {
                play_order.get(0).removeArrow(1);
            }
            if (dice.get(i).sides[dice.get(i).side].equals("Bullet")) {
                play_order.get(0).damage(1);
            }
        }
        for (int roll = 0; roll < 5; roll++) {
            if (dynamite >= 3) {
                Button4.setDisable(true);
            }
            if (dice.get(roll).sides[dice.get(roll).side].equals("Dynamite") && play_order.get(0).name.equals("Belle Star")) {
                //Turn this dice into gatling gun if yes button pressed(need to make yes nutton)
            }
        }
        rolls++;
    }

    public void go4() {
        total = 0;
        System.out.println("Final results: ");
        for (int count = 0; count < dice.size(); count++) {
            System.out.println("Dice " + (count + 1) + ": " + dice.get(count).sides[dice.get(count).side]);
            if (dice.get(count).sides[dice.get(count).side].equals("Double Gat")) {
                Gat += 2;
                if (Gat >= play_order.get(0).gatsNeeded) {
                    gatAttack = true;
                }
                if (play_order.get(0).name.equals("Kit Carlson") && arrow != 9) {
                    System.out.println("Who do you want to remove an arrow from? ");
                    list.clear();
                    for (int j = 0; j < play_order.size(); j++) {
                        if (play_order.get(j).arrows > 0) {
                            System.out.println((j + 1) + ") " + play_order.get(j).name);
                            list.add(j);
                        }
                    }
                    System.out.print("> ");
                    do {
                        try {
                            if (play_order.get(0).computer == true) {
                                Random random = new Random();
                                players = (random.nextInt(10000000) % list.size());
                                players = list.get(players);
                                System.out.println(players);
                            } else {
                                players = scan.nextInt();
                            }
                            test = true;
                        } catch (Exception a) {
                            System.out.println("Please give a number");
                        }
                    } while (!test);
                    play_order.get(players - 1).removeArrow(1);
                    System.out.println("Kit removed an arrow from: " + play_order.get(players - 1));
                    arrow++;
                }
            }
            if (dice.get(count).sides[dice.get(count).side].equals("Gatling")) {
                Gat++;
                if (Gat >= play_order.get(0).gatsNeeded) {
                    gatAttack = true;
                }
                if (play_order.get(0).name.equals("Kit Carlson") && arrow != 9) {
                    System.out.println("Who do you want to remove an arrow from? ");
                    list.clear();
                    for (int j = 0; j < play_order.size(); j++) {
                        if (play_order.get(j).arrows > 0) {
                            System.out.println((j + 1) + ") " + play_order.get(j).name);
                            list.add(j);
                        }
                    }
                    System.out.print("> ");
                    do {
                        try {
                            if (play_order.get(0).computer == true) {
                                Random random = new Random();
                                players = ((random.nextInt(10000000) % list.size()) + 1);
                                players = list.get(players);
                                System.out.println(players);
                            } else {
                                players = scan.nextInt();
                            }
                            test = true;
                        } catch (Exception a) {
                            System.out.println("Please give a number");
                        }
                    } while (!test);
                    play_order.get(players - 1).removeArrow(1);
                    System.out.println("Kit removed an arrow from: " + play_order.get(players - 1));
                    arrow++;
                }
            }
            if (dice.get(count).sides[dice.get(count).side].equals("Bull's Eye 1")) {
                BE1++;
                total++;
            }
            if (dice.get(count).sides[dice.get(count).side].equals("Bull's Eye 2")) {
                BE2++;
                total++;
            }
            if (dice.get(count).sides[dice.get(count).side].equals("Beer")) {
                Beer++;
            }
            if (dice.get(count).sides[dice.get(count).side].equals("Duel")) {
                duel++;
            }
            if (dice.get(count).sides[dice.get(count).side].equals("Whiskey")) {
                play_order.get(0).heal(1);
                if (play_order.get(0).name.equals("Greg Digger")) {
                    play_order.get(0).heal(1);
                }
            }
            if (dice.get(count).sides[dice.get(count).side].equals("Double Bull's Eye 1")) {
                DBE1++;
            }
            if (dice.get(count).sides[dice.get(count).side].equals("Double Bull's Eye 2")) {
                DBE2++;
            }
            if (dice.get(count).sides[dice.get(count).side].equals("Double Beer")) {
                Beer += 2;
            }
        }
    }

}
