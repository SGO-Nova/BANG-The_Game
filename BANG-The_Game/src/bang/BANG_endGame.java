/*
* Shafat Rakin & Sagarika KC
* CS 2365
* Project 3 - 4
* Spring 2020
* This file displays a victory scene (GUI) at the end of the Game.
*/

package bang;

// imports galore
import java.io.FileInputStream;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class BANG_endGame extends Application
{
    // main method to launch
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start (Stage stage1) throws Exception
    {   
        // uploads background and logo images
        Image img_table = new Image(new FileInputStream("src/bang/media/wood_TableTop.jpg"));
        ImageView table = new ImageView(img_table);
        Image img_logo = new Image(new FileInputStream("src/bang/media/bang.png"));
        ImageView logo = new ImageView(img_logo);

        // sets fit height and width for table and logo
        table.setFitWidth(1280);
        table.setFitHeight(720);
        logo.setFitWidth(540);
        logo.setFitHeight(260);

        // sets position of table with in window
        table.setX(5.75);
        table.setY(5.75);
        
        // label with formatted text congratulating winner
        Label label_winner = new Label("Congratulations to the winner!!!");
        label_winner.setAlignment(Pos.CENTER);
        label_winner.setFont(Font.font("Verdana", FontWeight.BOLD, 36));
        label_winner.setLayoutX(350);
        label_winner.setLayoutY(375);

        // groups the above together
        Group group1 = new Group();
        group1.getChildren().addAll(table, logo, label_winner);

        // displays scene
        Scene scene1 = new Scene(group1, 1280, 720, Color.BEIGE);
        stage1.setScene(scene1);
        stage1.setResizable(false);
        stage1.show();
    }
}