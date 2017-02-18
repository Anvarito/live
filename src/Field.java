import javafx.scene.layout.Pane;

/**
 * Created by Анварито on 18.02.2017.
 */
public class Field extends Pane {
    Cell[][] cells;
    private int CellWidth, CellHight;
    private int fieldHeight, fieldWidth;
    public Field(int fieldWidth, int fieldHeight,int CellWidth, int CellHight){
        this.CellHight = CellHight;
        this.CellWidth = CellWidth;
        this.fieldWidth = fieldWidth;
        this.fieldHeight = fieldHeight;
        cells = new Cell[fieldWidth][fieldHeight];
        for (int i = 0; i < fieldHeight; i++) {
            for (int j = 0; j < fieldWidth; j++) {
                this.getChildren().addAll(new Cell(j*CellWidth,i*CellHight,CellWidth,CellHight));
            }
        }
    }
}
