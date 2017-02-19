import javafx.scene.layout.Pane;

/**
 * Created by Анварито on 18.02.2017.
 */
public class Field extends Pane {
    private Cell[][] cells;
    private int CellWidth, CellHight;
    private int fieldHeight, fieldWidth;

    public Field(int fieldWidth, int fieldHeight, int CellWidth, int CellHight) {
        this.CellHight = CellHight;
        this.CellWidth = CellWidth;
        this.fieldWidth = fieldWidth;
        this.fieldHeight = fieldHeight;
        cells = new Cell[fieldWidth][fieldHeight];
        for (int i = 0; i < fieldHeight; i++) {
            for (int j = 0; j < fieldWidth; j++) {
                cells[i][j] = new Cell(j * CellWidth, i * CellHight, CellWidth, CellHight);
                this.getChildren().add(cells[i][j]);
            }
        }
    }

    public void changeGeneration() {

        for (int i = 0; i < fieldHeight; i++) {
            for (int j = 0; j < fieldWidth; j++) {
                // если клетка мертва
                if (!cells[i][j].isAlive()) {
                    // 3 клетки
                    if (computeSum(i, j) == 3)
                        cells[i][j].setChange(true);
                }
                // если клетка жива
                else {
                    // 2 или 3 клетки
                    if (computeSum(i, j) < 2 || computeSum(i, j) > 3)
                        cells[i][j].setChange(true);
                }
            }
        }
        // применяем новые состояния ко всем клеткам
        for (int i = 0; i < fieldHeight; i++) {
            for (int j = 0; j < fieldWidth; j++) {
                if (cells[i][j].isChange()) {
                    //cells[i][j].setAlive(!cells[i][j].isAlive());
                    cells[i][j].changeState();
                }
                cells[i][j].setChange(false);
            }
        }
    }

    // вычисляет количество живых клеток на соседних клетках
    private int computeSum(int i, int j) {
        int sum = 0;
        for (int k = i - 1; k < i + 2; k++) {
            for (int l = j - 1; l < j + 2; l++) {
                if (!(k == i && l == j)) {
                    int k1, l1;

                    if (k < 0)
                        k1 = k + fieldHeight;
                    else if (k >= fieldHeight)
                        k1 = k - fieldHeight;
                    else
                        k1 = k;
                    if (l < 0)
                        l1 = l + fieldWidth;
                    else if (l >= fieldWidth)
                        l1 = l - fieldWidth;
                    else
                        l1 = l;

                    if (cells[k1][l1].isAlive())
                        sum++;
                }
            }
        }
        return sum;
    }
}
