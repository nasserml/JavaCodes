package audioclipplayer;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.net.URL;
import javafx.scene.layout.HBox;
import javafx.scene.media.AudioClip;

public class AudioClipPlayer extends Application {
    
    private AudioClip audioClip;
    
    @Override
    public void init() {
        URL mediaUrl = this.getClass()
                           .getClassLoader()
                .getResource("resources/media/chimes.wav");
        // Create an AudioClip, which loads the audio data synchronously
        audioClip = new AudioClip( mediaUrl.toExternalForm());
    }
    
    
    @Override
    public void start(Stage primaryStage) {
        Button  playBtn = new Button("Play");
        Button stopBtn = new Button("Stop");
        
        // set event handlers for buttons
        playBtn.setOnAction(e -> audioClip.play());
        stopBtn.setOnAction(e -> audioClip.stop());
        
        HBox root = new HBox(5, playBtn, stopBtn);
        
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    
    public static void main(String[] args) {
        Application.launch(args);
    }
    
}
