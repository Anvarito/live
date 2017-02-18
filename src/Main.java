import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sun.plugin.javascript.navig.Anchor;

import java.util.Collection;

/**
 * Created by Анварито on 18.02.2017.
 */
public class Main extends Application {
    Field field;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        int fieldWidth = 50, fieldHeight = 50;
        int cellWidth = 10, cellHeight = 10;

        Pane root = new Pane();
        Scene scene = new Scene(root,1100, 1100);
        primaryStage.setScene(scene);
        primaryStage.setTitle("LIVE");
        primaryStage.show();
        field = new Field(fieldWidth, fieldHeight, cellWidth, cellHeight);
        root.getChildren().add(field);

        Button start = new Button("Start");
        start.setTranslateY(fieldHeight * cellHeight + 20);
        start.setOnAction(event -> startLive());
        root.getChildren().add(start);
    }

    private void startLive() {

    }
}
