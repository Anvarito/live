import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import sun.plugin.javascript.navig.Anchor;

import java.util.Collection;

/**
 * Created by Анварито on 18.02.2017.
 */
public class Main extends Application {
    Field field;
    Timeline timeline;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        int fieldWidth = 50, fieldHeight = 50;
        int cellWidth = 10, cellHeight = 10;

        Pane root = new Pane();
        Scene scene = new Scene(root, 550, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("LIVE");
        primaryStage.show();
        field = new Field(fieldWidth, fieldHeight, cellWidth, cellHeight);
        field.setTranslateX(20);
        field.setTranslateY(20);
        root.getChildren().add(field);

        Button start = new Button("Start");
        start.setTranslateY(fieldHeight * cellHeight + 50);
        start.setOnAction(event -> startLive());
        root.getChildren().add(start);

        Button stop = new Button("Stop");
        stop.setTranslateY(fieldHeight * cellHeight + 50);
        stop.setTranslateX(50);
        stop.setOnAction(event -> stopLive());
        root.getChildren().add(stop);
    }

    private void startLive() {
        timeline  = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);

        timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        field.changeGeneration();
                    }
                }));

        timeline.play();

    }
    private void stopLive() {
        timeline.stop();

    }
}
