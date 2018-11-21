import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Main extends Application  {

    //Variablen
    private static final String MAIN_NAME = "ask's InterfaceTest";
    private static final String COMMIT_BUTTON_TEXT = "commit!";
    Button close;
    Button allertboxButton, confirmboxButton, commitButton;
    Stage mainWindow;
    Scene mainScene, searchScene, bookItScene;



    public static void  main(String[] args){

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        //Input
        TextField input = new TextField();
        input.setPromptText("Do you like ROSYBROWN??");


        //Labels
        Label label = new Label("Frage: Toll!");
        Label label1 = new Label("Das ist der Inhallt des Buchungssystems\n aslkasfkjlakljgkjlagkjlag" +
                "\n askjlghjaghjkajhskdj");

        // Buttons
        allertboxButton= new Button("Allertbox Test");
        confirmboxButton = new Button("Confirmboxtest");
        commitButton = new Button(COMMIT_BUTTON_TEXT);
        close = new Button("close");
        Button searchButton = new Button("Suche");
        Button bookItButton = new Button("Buchungssystem");

        bookItButton.setStyle("-fx-background-color: #5F9EA0; -fx-border-color: #000000");
        searchButton.setStyle("-fx-background-color: #FFC1C1; -fx-border-color: #000000");


        //Menuelayout
        HBox menuLayout = new HBox();
        menuLayout.setSpacing(3);
        menuLayout.getChildren().addAll(searchButton, bookItButton);

        //Searchlayout
        GridPane searchLayout = new GridPane();
        HBox searchbox = new HBox();
        input.setMinWidth(500);
        input.setMaxWidth(650);
        searchbox.getChildren().setAll(label, input, commitButton);

        GridPane.setConstraints(searchbox, 0, 0 );

        searchLayout.getChildren().addAll(searchbox);

        searchLayout.setMinSize(650, 200);
        searchLayout.setBorder(new Border(new BorderStroke(Color.ROSYBROWN,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));


        //BuchenLayout
        GridPane bookItLayout = new GridPane();
        GridPane.setConstraints(label1, 0,0);
        bookItLayout.getChildren().addAll(label1);
        bookItLayout.setMinSize(650, 200);
        bookItLayout.setBorder(new Border(new BorderStroke(Color.CYAN,
                BorderStrokeStyle.DASHED, CornerRadii.EMPTY, BorderWidths.DEFAULT)));


        //HeadLayout
        GridPane layout = new GridPane();
        layout.setPadding(new Insets(3, 3, 3, 3));
        layout.setVgap(8);
        layout.setHgap(10);


        //Elementzuweisug fürs HeadLayout
        //GridPane.setConstraints(searchButton, 0, 0);
        //GridPane.setConstraints(bookItButton, 1, 0);
        //GridPane.setHalignment(bookItButton, HPos.RIGHT);
        //GridPane.setHalignment(searchButton, HPos.LEFT);
        GridPane.setHalignment(menuLayout, HPos.LEFT);
        GridPane.setConstraints(allertboxButton, 0,10);
        GridPane.setConstraints(bookItLayout, 0, 2);
        GridPane.setConstraints(searchLayout, 0,2);

        layout.getChildren().addAll(allertboxButton, searchLayout, menuLayout);

        //Button functions
        allertboxButton.setOnAction(e -> AltertBox.display("FehlerNachricht:  ","45782"));
        confirmboxButton.setOnAction(event -> {
            boolean ergebnis = ConfirmBox.display("Frage: ", "ja/nö");
            label.setText(String.valueOf(ergebnis));
        } );
        close.setOnAction(event -> {
            closeProgramm();
        });
        commitButton.setOnAction(event -> {
            System.out.println("Input:");
            System.out.println(input.getText());
        });

        searchButton.setOnAction(event -> {
            layout.getChildren().remove(bookItLayout);
            layout.getChildren().setAll(allertboxButton ,searchLayout,menuLayout);
        });

        bookItButton.setOnAction(event -> {
            layout.getChildren().remove(searchLayout);
            layout.getChildren().setAll(allertboxButton , bookItLayout, menuLayout);
        });

        //MainframegamepaingainMain
        mainScene = new Scene(layout);
        mainWindow = primaryStage;
        mainWindow.setScene(mainScene);
        mainWindow.show();
        mainWindow.setOnCloseRequest(event ->{
            event.consume();
            closeProgramm();
        });
        mainWindow.setTitle(MAIN_NAME);

    }

    private void closeProgramm(){

        Boolean answer = ConfirmBox.display("Close the Programm", "sicher?! then get to zhe tschoopper");
        if (answer ==true) mainWindow.close();



    }

}
