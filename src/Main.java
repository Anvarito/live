import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
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
        Pane root = new Pane();
        Scene scene = new Scene(root,100,100);
        primaryStage.setScene(scene);
        primaryStage.setTitle("LIVE");
        primaryStage.show();
        field = new Field(2,2,50,50);
        root.getChildren().addAll(field);
    }
}
