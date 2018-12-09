

package sample;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Fckthatshit extends Application  {
/*
    //Konstanten
    private static final String MAIN_NAME = "ask's & elm0s InterfaceTest";
    private static final String COMMIT_BUTTON_TEXT = "commit!";

    private static final double MAIN_WINDOW_MIN_WIDTH = 1300;
    private static final double MAIN_WINDOW_MIN_HEIGHT = 800;
    private static final double SEARCH_LAYOUT_MIN_WIDHT = 500;
    private static final double SEARCH_LAYOUT_MIN_HEIGHT = 200;
    private static final double BUCHEN_LAYOUT_MIN_WIDHT = 500;
    private static final double BUCHEN_LAYOUT_MIN_HEIGHT = 200;
    private static final double INFO_LAYOUT_MIN_WIDHT = 500;
    private static final double INFO_LAYOUT_MIN_HEIGHT = 200;




    Button close;
    Button allertboxButton, confirmboxButton, commitButton;
    Stage mainWindow;
    Scene mainScene;




*/
    public static void  main(String[] args){

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {}
/*
        //Input
        TextField input = new TextField();
        input.setPromptText("Do you like ROSYBROWN??");


        //Labels
        Label label = new Label("Frage: Super?");

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
        GridPane searchLayout = LayoutBox.createSearchlayout(SEARCH_LAYOUT_MIN_WIDHT, SEARCH_LAYOUT_MIN_HEIGHT, "DArum gehts", "asdkjlaskjldjkalsd");

        //AuswahlLayout
        VBox auswahlLayout = LayoutBox.createAuswahlLayout(BUCHEN_LAYOUT_MIN_WIDHT, BUCHEN_LAYOUT_MIN_HEIGHT, "DArum gehts\n" +
                "aslkdajskdjklasd" +
                "\n" +
                "aslkjdjkasldkjlasdkjlaskljdkjlasdjklajksfjkasd" +
                "kajsdjklajklsdjklasd");

        //InfoLayout
        GridPane infoLayout = LayoutBox.createInfoLayout(INFO_LAYOUT_MIN_HEIGHT, INFO_LAYOUT_MIN_WIDHT, "KATEGORIE \n asdkjasklgfklasd");



        //LeftsideMenü
        VBox leftside = new VBox();
        leftside.setMinSize(500,600);
        leftside.getChildren().addAll(searchLayout, auswahlLayout);


        //HeadLayout
        GridPane layout = new GridPane();
        layout.setPadding(new Insets(3, 3, 3, 3));
        layout.setVgap(8);
        layout.setHgap(10);


        //Grid Constraints für die dynamische Haftung am Fensterrand
        RowConstraints row1 = new RowConstraints();
        row1.setPercentHeight(10);
        RowConstraints row2 = new RowConstraints();
        row2.setPercentHeight(90);
        RowConstraints row3 = new RowConstraints();
        row3.setPercentHeight(5);
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(65);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(35);

        layout.getRowConstraints().addAll(row1,row2,row3);
        layout.getColumnConstraints().addAll(col1,col2);


        layout.add(menuLayout, 0,0);
        layout.add(leftside,0,1);
        layout.add(infoLayout, 1, 1);
        layout.add(allertboxButton, 0, 2);


        //Button functions
        allertboxButton.setOnAction(e -> AltertBox.display("FehlerNachricht:  ","ACHTUNG ACHTUNG DIESES PROGRAMM IST NICHT MEHR SICHER"));
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
            leftside.getChildren().remove(auswahlLayout);
            auswahlLayout.setMinSize(500, 300);
            searchLayout.setMinSize(500, 300);
            leftside.getChildren().addAll(searchLayout, auswahlLayout);

        });

        bookItButton.setOnAction(event -> {
            leftside.getChildren().remove(searchLayout);
            auswahlLayout.setMinSize(500, 600);
            leftside.getChildren().addAll(auswahlLayout);

        });

        //Main
        mainScene = new Scene(layout);
        mainWindow = primaryStage;
        mainWindow.setMinWidth(MAIN_WINDOW_MIN_WIDTH);
        mainWindow.setMinHeight(MAIN_WINDOW_MIN_HEIGHT);
        mainWindow.setScene(mainScene);
        mainWindow.show();
        mainWindow.setOnCloseRequest(event ->{
            event.consume();
            closeProgramm();
        });
        mainWindow.setTitle(MAIN_NAME);

    }

    private void closeProgramm(){

        Boolean answer = ConfirmBox.display("Close the Programm", "Machs aus!");
        if (answer ==true) mainWindow.close();
    }


}


    public static GridPane createSearchlayout(double SEARCH_LAYOUT_MIN_WIDHT, double SEARCH_LAYOUT_MIN_HEIGHT, String topic, String promt ){
        //Elements
        Label label = new Label(topic);

        TextField input = new TextField();
        input.setMinWidth(500);
        input.setMaxWidth(650);
        input.setPromptText(promt);
        Button commitButton = new Button("Suchen!");

        GridPane searchLayout = new GridPane();
        HBox searchbox = new HBox();
        searchbox.setAlignment(Pos.CENTER);
        //TODO
        GridPane.setFillWidth(searchbox, true);
        GridPane.setHalignment(searchbox, HPos.CENTER);
        searchbox.getChildren().setAll(label, input, commitButton);
        searchLayout.getChildren().addAll(searchbox);
        searchLayout.setMinSize(SEARCH_LAYOUT_MIN_WIDHT, SEARCH_LAYOUT_MIN_HEIGHT);
        searchLayout.setBorder(new Border(new BorderStroke(Color.ROSYBROWN,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        return searchLayout;

    }

     public static GridPane createInfoLayout(double INFO_LAYOUT_MIN_HEIGHT,double INFO_LAYOUT_MIN_WIDHT, String kategorieText){
        Label kategorie = new Label(kategorieText);
        GridPane infoLayout = new GridPane();
        infoLayout.setMinSize(INFO_LAYOUT_MIN_WIDHT, INFO_LAYOUT_MIN_HEIGHT);
        infoLayout.getChildren().addAll(kategorie);
        infoLayout.setBorder(new Border(new BorderStroke(Color.CYAN,
                BorderStrokeStyle.DASHED, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        return infoLayout;

    }



    public static VBox createAuswahlLayout(double AUSWAHL_LAYOUT_MIN_WIDHT, double AUSWAHL_LAYOUT_MIN_HEIGHT, String text){
        Label ueberschrift = new Label(text);
        VBox auswahlLayout = new VBox();
        GridPane.setConstraints(ueberschrift, 0,0);
        auswahlLayout.setMinSize(AUSWAHL_LAYOUT_MIN_WIDHT, AUSWAHL_LAYOUT_MIN_HEIGHT);
        auswahlLayout.getChildren().addAll(ueberschrift);
        auswahlLayout.setBorder(new Border(new BorderStroke(Color.CYAN,
                BorderStrokeStyle.DASHED, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        return  auswahlLayout;
    }
    */
}

