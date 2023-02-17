package quickmediaplayer;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.Media;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import static javafx.scene.media.MediaPlayer.Status.PLAYING;

public class QuickMediaPlayer extends Application {
    
    @Override
    public void start(Stage stage) {
        // Locate the media content in the CLASSPATH
        String mediaStringUrl  = "file::///E:/downloadeds/Downloads/Video/flashXtv.mp4";
        
        // create a media
        Media media = new Media( mediaStringUrl);
        
        // create a media playe
        MediaPlayer player = new MediaPlayer( media );
        
        // Automatically begin the playback
        player.setAutoPlay( true );
        
        // create a 400x300 MediaView
        MediaView mediaView = new MediaView(player);
        mediaView.setFitWidth( 400 );
        mediaView.setFitHeight( 300 );
        
        // create play and stop player control buttons and add action
        // event handlers to them
        Button playBtn = new Button( "play" );
        playBtn.setOnAction(e -> {
            if ( player.getStatus() == PLAYING ) {
                player.stop();
                player.play();
            } else {
                player.play();   
            }
               
        });
        
        Button stopBtn = new Button("Stop");
        stopBtn.setOnAction(e -> player.stop());
        
        // add an error handler
        player.setOnError(() -> System.out.println(player.getError().getMessage()));
        
        HBox controlBox = new HBox(5, playBtn, stopBtn);
        BorderPane root = new BorderPane();
        
        // Add the MediaView and player contorls to the scene graph
        root.setCenter(mediaView);
        root.setBottom(controlBox);
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Playing Media");
        stage.show();
    }

    
    public static void main(String[] args) {
        Application.launch(args);
    }
    
}
