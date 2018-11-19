import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class Main extends Application  {

    //Variablen
    private static final String MAIN_NAME = "ask's Finanztool";
    private static final String COMMIT_BUTTON_TEXT = "commit!";
    Button close;
    Button test1, test2;
    Stage mainWindow;
    Scene scene1, scene2;


    public static void  main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Label label = new Label("Gib was ein");
        test1= new Button("Allertbox Test");
        test2= new Button("Confirmboxtest");
        close = new Button("hex dich weg");


        test1.setOnAction(e -> AltertBox.display("FehlerNachricht:  ","asdasfgasg1123125123123234"));
        test2.setOnAction(event -> {
            boolean ergebnis = ConfirmBox.display("Frage: ", "bist du jünger als 30");
            label.setText(String.valueOf(ergebnis));
        } );
        close.setOnAction(event -> {
            closeProgramm();
        });

        GridPane layout = new GridPane();
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.setVgap(8);
        layout.setHgap(10);

        GridPane.setConstraints(label, 0, 0 );
        TextField input = new TextField();
        GridPane.setConstraints(input, 1, 0);
        scene1 = new Scene(layout, 300, 300);

        mainWindow = primaryStage;
        mainWindow.setScene(scene1);
        mainWindow.show();
        mainWindow.setOnCloseRequest(event ->{
            event.consume();
            closeProgramm();
        });
        mainWindow.setTitle(MAIN_NAME);

    }

    private void closeProgramm(){

        Boolean answer = ConfirmBox.display("Close the Programm", "sicher?!");
        if (answer ==true) mainWindow.close();



    }

}
