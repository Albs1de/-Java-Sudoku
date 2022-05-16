import java.security.DrbgParameters.NextBytes;

/**
 * Sudoku game.
 * 
 * @author Tobias Lauer
 */
public class SudokuGame {

    SudokuField[][] grid;

    public static void main(String[] args) {
        SudokuGameWithGUI sudoku = new SudokuGameWithGUI();

        // Insert some initial values
        sudoku.insertFixed(0, 0, 8);
        sudoku.insertFixed(8, 8, 8);



        // Show Sudoku in console
        sudoku.showSudoku();

        // Try to solve the Sudoku
        if (sudoku.solveRecursively(0, 0)) {
            sudoku.showSudoku();
        } else {
            System.out.println("Sudoku cannot be solved.");
        }
        
    }

    public SudokuGame() {
        grid = new SudokuField[9][9];
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                grid[x][y] = new SudokuField(x, y);
            }
        }
    }

    public void showSudoku() {
        System.out.println("-------------------------");
        for (int x = 0; x < 9; x++) {
            System.out.print("| ");
            for (int y = 0; y < 9; y++) {
                if (grid[x][y].getValue() == 0) {
                    System.out.print(".");
                } else {
                    System.out.print(grid[x][y].getValue());
                }
                System.out.print(" ");
                if (y % 3 == 2) {
                    System.out.print("| ");
                }
            }
            System.out.println();
            if (x % 3 == 2) {
                System.out.println("-------------------------");
            }
        }
    }

    void insert(int x, int y, int zahl) {
        if (!(x < 0 || x > 8 || y < 0 || y > 8 || zahl < 1 || zahl > 9) && !grid[x][y].isFixed()) {
            grid[x][y].setValue(zahl);
            // System.out.println("Inserting ("+x+","+y+") = " + zahl);
        } else {
            // Do nothing
            System.out.println(y + " " + x + ": No change ("+grid[x][y].getValue()+")");
        }
    }

    void insertFixed(int x, int y, int zahl) {
        if (!(x < 0 || x > 8 || y < 0 || y > 8 || zahl < 1 || zahl > 9)) {
            grid[x][y] = new SudokuField(x, y, zahl);
        } 
    }

    private boolean anyConflict(int x, int y) {
        if (x==9 || y==9) {
            System.out.println("x = "+x);
            System.out.println("y = "+y);
            showSudoku();
        }
        return conflictInRow(x, y) || conflictInColumn(x, y) || conflictInSquare(x, y);
    }

    private boolean conflictInRow(int x, int y) {
        if (!grid[x][y].isEmpty()) {
            for (int col = 0; col < 9; col++) {
                if (col != x && grid[col][y].getValue() == grid[x][y].getValue()) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean conflictInColumn(int x, int y) {
        if (!grid[x][y].isEmpty()) {
            for (int row = 0; row < 9; row++) {
                if (row != y && grid[x][row].getValue() == grid[x][y].getValue()) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean conflictInSquare(int x, int y) {
        if (!grid[x][y].isEmpty()) {
            int columnStart = x - x % 3;
            int rowStart = y - y % 3;
            // System.out.println(columnStart + " " + rowStart);
            for (int col = columnStart; col < columnStart + 3; col++) {
                for (int row = rowStart; row < rowStart + 3; row++) {
                    // System.out.println(col + " " + row + " " + grid[col][row]);
                    if ((col != x || row != y) && grid[col][row].getValue() == grid[x][y].getValue()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean tryNumber(int x, int y, int zahl) {
        insert(x, y, zahl);
        if (anyConflict(x, y)) {
            grid[x][y].clear();
            return false;
        } else {
            return true;
        }
    }


    /**
     * Solves this Sudoku recursively.
     * 
     * @param x the column of the field to start with
     * @param y the row of the field to start with
     * @return true iff a solcution starting from (x, y) was found
     */
    public boolean solveRecursively(int x, int y) {
        
        // TODO (Blatt 9)
        if (grid[x][y].getValue() != 0 ) {
            next(x, y);
        }
        else {
            for (int numR = 1; numR < 10; numR++) {
                if (conflictInRow(x, y) && conflictInColumn(x, y) && tryNumber(x, y, numR)) {
                    grid[x][y].setValue(numR);
                    showSudoku();

                    next(x, y);

                }
            }
            grid[x][y].clear();
            showSudoku();
        }

        return false;
    }
    /**
     * @param nextX the column of the field
     * @param nextY the row of the field
     */
    public void next(int nextX, int nextY) {
        if (nextX < 8)
        solveRecursively(nextY, nextX +1);
    
    else {
        solveRecursively(nextY + 1, 0);
    }
} 
   
}
