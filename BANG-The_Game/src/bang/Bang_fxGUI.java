/*
 * Shafat Rakin
 * CS 2365-001
 * Project 3
 * Spring 2020
 * This file implements a GUI using JavaFX.
 */

package bang;

// imports galore
import java.io.FileInputStream;
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

public class Bang_fxGUI extends Application
{
    Stage window;
    Scene scene1, scene2;
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
        
        //set position of table image within window
        table.setX(5.75);
        table.setY(5.75);
        table2.setX(5.75);
        table2.setY(5.75);
        
        // text field for taking user name input
        TextField playerName = new TextField("Enter Name");
        playerName.setFont(Font.font("Verdana", FontWeight.BOLD, 24));
        //playerName.setMinSize(125, 30);
        playerName.setAlignment(Pos.CENTER);
        playerName.setLayoutX(700);
        playerName.setLayoutY(350);
        
        // label and dropdown menu for selecting number of players (defaults to 3)
        Label label_numPlayers = new Label("Number of Players: ");
        label_numPlayers.setAlignment(Pos.CENTER);
        label_numPlayers.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        label_numPlayers.setLayoutX(700);
        label_numPlayers.setLayoutY(420);
        
        ComboBox numPlayers = new ComboBox();
        numPlayers.getItems().add(4);
        numPlayers.getItems().add(5);
        numPlayers.getItems().add(6);
        numPlayers.getItems().add(7);
        numPlayers.getItems().add(8);
        numPlayers.getSelectionModel().select(0);
        numPlayers.setLayoutX(925);
        numPlayers.setLayoutY(420);
        
        // Music check box
        CheckBox cb1 = new CheckBox("Music in Game");
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
            if(cb1.isSelected()){
                music.setAutoPlay(true);
            }
            window.setScene(scene2);
            window.show();
            BANG.setPlayers(((int) numPlayers.getValue()) - 1);
            //System.out.println(playerName.getText());
            //System.out.println(numPlayers.getValue());
        });
        
        // group all the above together
        Group group1 = new Group();
        group1.getChildren()
                .addAll(table, logo, playerName, numPlayers, label_numPlayers,
                        startButton, cb1);
        
        // group all the above together
        Group group2 = new Group();
        group2.getChildren()
                .addAll(table2);
        
        
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
}
