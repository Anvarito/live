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

        this.setHeight(height);
        this.setWidth(width);


        this.setTranslateX(x);
        this.setTranslateY(y);

        rectangle = new Rectangle(0, 0, width, height);
        //this.rectangle = rectangle;
        rectangle.setFill(Color.BLUE);
        rectangle.setStroke(Color.BLACK);


        //this.setStyle("-fx-background-color: #795548;");
        this.getChildren().add(rectangle);

        rectangle.setTranslateX(0);
        rectangle.setTranslateY(0);

        this.setOnMouseClicked(event -> {

            //this.setStyle("-fx-background-color: #795548;");
            isAlive = !isAlive;
            if(isAlive)
                rectangle.setFill(Color.RED);
            else
                rectangle.setFill(Color.BLUE);
        });

        //rectangle.setFill(Color.GREEN);
    }





}
