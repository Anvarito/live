import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Created by Анварито on 18.02.2017.
 */
public class Cell extends Pane {
    int x,y;
    boolean isAlive;
    Rectangle rectangle;

    Cell(int x, int y, int width, int height){
        this.x=x;
        this.y=y;
        this.isAlive = false;

        this.rectangle = new Rectangle(x, y,width,height);
        //this.rectangle = rectangle;
        rectangle.setFill(Color.BLUE);
        rectangle.setStroke(Color.BLACK);

        this.getChildren().addAll(rectangle);

        this.setOnMouseClicked(event -> {
            isAlive = true;
            rectangle.setFill(Color.RED);
        });

        //rectangle.setFill(Color.GREEN);
    }





}
