//Authors:Ryan Browning

package bang;

import java.io.FileInputStream; 
import javafx.animation.FadeTransition;
import javafx.application.Application; 
import javafx.scene.Scene; 
import javafx.scene.layout.*; 
import javafx.stage.Stage;  
import javafx.scene.image.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.Group; 
import javafx.scene.paint.*;
import javafx.util.Duration;  


public class Bang_GUI extends Application
{

    
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Image table = new Image(new FileInputStream("src/bang/media/Top_down_table.jpg"));
        ImageView imageView_table = new ImageView(table);
        Image logo = new Image(new FileInputStream("src/bang/media/bang.png"));
        ImageView imageView_logo = new ImageView(logo);
        
        imageView_table.setX(5);
        imageView_table.setY(15);
        imageView_logo.setX(500/2);
        imageView_logo.setY(300/2);
        
        FadeTransition fade = new FadeTransition();
        fade.setDuration(Duration.millis(5000));
        fade.setFromValue(0);  
        fade.setToValue(10);
        fade.setCycleCount(500);
        fade.setAutoReverse(true); 
        fade.setNode(imageView_logo);
        fade.stop();
        fade.setCycleCount(1);
        fade.play();

        //setting the fit height and width of the image view 
        imageView_table.setFitHeight(698); 
        imageView_table.setFitWidth(1280); 
        imageView_table.setPreserveRatio(false);
        imageView_logo.setFitHeight(474/2); 
        imageView_logo.setFitWidth(820/2); 
        imageView_logo.setPreserveRatio(false);
        
        Group root = new Group(imageView_table, imageView_logo);
        
        //String path = Bang_GUI.class.getResource("/media.mp3").toString();

        Media media = new Media(this.getClass().getResource("/bang/media/background.mp3").toString());
        MediaPlayer music = new MediaPlayer(media);
        music.setVolume(.5);
        music.setAutoPlay(true);
        
        
        primaryStage.setTitle("BANG!:The Dice Game");
        StackPane layout = new StackPane();
        
        Scene scene = new Scene(root, 1280, 720, Color.GREEN);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
    
    }
}
