import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * JavaFX Sudoku GUI
 * 
 * @author [Ihr Name]
 */
public class SudokuGUI extends Application {
    
    TextField[][] field = new TextField[9][9];  // 9x9 TextField-Array für die Zellen

    private GridPane gridPane;                  // GridPane als Layout für das Sudoku-Gitter
    private Stage primaryStage;                 

    private SudokuGame sudoku;                  // Verbindung zum eigentlichen Sudoku-Spiel

    public static void main(String[] args) {
        System.out.println("Starte JavaFX-Programm... ");
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        System.out.println("JavaFX Anwendung gestartet.");
        this.primaryStage = primaryStage;       // Setzt primaryStage
        initView();                             // Aufruf der Initialisierung
    }

    /**
     * Initialisiert ein neues SudokuGame und die GUI-Komponenten.
     * Kann auch zum Reset verwendet werden.
     */
    private void initView() {
        // Initialisiere ein GridPane. Darin sollen alle Komponenten gesammelt werden.
        gridPane = new GridPane();
        // Initialisiere ein SudokuGame, das zu diesem GUI gehören soll
        sudoku = new SudokuGame();      // Hier muss man in SudokuGame evtl. den Konstruktor ändern,
                                        // um eine Referenz auf das GUIzu übergeben zu können,
                                        // damit das SudokuGame sein GUI "kennt" (falls nötig)

        // TODO:
        // Alle GUI-Komponenten (Felder, Buttons etc.) erstellen und initialisieren 
        // und zum gridPane hinzufügen. Ggfs. gridPanes ineinanderschachteln.




        // Setze einen Titel für das Hauptfenster, ...
        primaryStage.setTitle("Sudoku");
        // ... baue das gridPane in das Fenster ein ...
        primaryStage.setScene(new Scene(gridPane, 400, 420));
        // ... und zeige das Fenster an
        primaryStage.show();
    }

    /**
     * Bereitet die Lösung des Sudokus vor und startet diese dann.
     * Wird ausgeführt, wenn der Button zum Lösen gedrückt wird.
     */
    private void solve() {
        
        // TODO:
        // Eingegebene Werte aus GUI auslesen (dabei fehlerhafte Werte löschen)
        // und in SudokuGame als Startfelder eintragen

        // Dann das Sudoku per solveRecursively(...) lösen lassen
        // und Ergebnis in GUI anzeigen.

    }

}