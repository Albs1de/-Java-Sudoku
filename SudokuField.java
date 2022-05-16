public class SudokuField {
    private int value;
    private int x, y;
    private boolean fixedValue;
    static SudokuGUI gui;

    SudokuField(int x, int y) {
        this.x = x;
        this.y = y;
        value = 0;
        fixedValue = false;
    }

    SudokuField(int x, int y, int number) {
        this(x, y);
        if (number > 0 && number < 10) {
            this.value = number;
            fixedValue = true;
        }
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        if (!fixedValue && value > 0 && value < 10) {
            this.value = value;
            if (gui != null) {
                gui.field[x][y].setText("" + value);
            }
        }
    }

    public void incrementValue() {
        if (!fixedValue && value < 9) {
            value++;
        }
    }

    public void clear() {
        if (!fixedValue) {
            value = 0;
            /*if (gui != null) {
                gui.field[x][y].setText("");
            }*/
        }
    }

    public boolean isEmpty() {
        return value == 0;
    }
    
    public boolean isFixed() {
        return fixedValue;
    }


}
