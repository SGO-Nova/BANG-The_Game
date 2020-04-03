/*
 * Shafat Rakin
 * CS 2365-001
 * Project 3
 * Spring 2020
 * This file implements a GUI using JavaFX.
 */

package bang;

import java.io.FileInputStream;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Bang_fxGUI extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }
    
    @Override
    public void start (Stage stage1) throws Exception
    {
        Image img_table = new Image(new FileInputStream("src/bang/media/wood_TableTop.jpg"));
        ImageView table = new ImageView(img_table);
        Image img_logo = new Image(new FileInputStream("src/bang/media/bang.png"));
        ImageView logo = new ImageView(img_logo);
        
        table.setFitWidth(1280);
        table.setFitHeight(720);
        logo.setFitWidth(540);
        logo.setFitHeight(260);
        
        table.setX(5.75);
        table.setY(5.75);
        
        Group group1 = new Group();
        group1.getChildren().addAll(table, logo);
        
        Scene scene1 = new Scene(group1, 1280, 720, Color.BEIGE);
        stage1.setScene(scene1);
        stage1.setResizable(false);
        stage1.show();
    }
}
