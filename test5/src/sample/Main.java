package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.List;
import java.util.zip.GZIPInputStream;

public class Main extends Application  {

    //Konstanten
    private static final String MAIN_NAME = "Test - Alles könner";
    private static final String COMMIT_BUTTON_TEXT = "Commit";

    private static final double MAIN_WINDOW_MIN_WIDTH = 800;
    private static final double MAIN_WINDOW_MIN_HEIGHT = 600;
    private static final double SEARCH_LAYOUT_MIN_WIDHT = 300;
    private static final double SEARCH_LAYOUT_MIN_HEIGHT = 450;
    private static final double RESULT_LAYOUT_MIN_WIDHT = 300;
    private static final double RESULT_LAYOUT_MIN_HEIGHT = 450;
    private static final double INFO_LAYOUT_MIN_WIDHT = 300;
    private static final double INFO_LAYOUT_MIN_HEIGHT = 450;

    //Variablen
    private Stage mainWindow;
    private Scene mainScene;
    private int searchTermsCounter;
    private List<String> searchTerms;


    public static void  main(String[] args){

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        //Buttons
            //Menue Oben / Main Menu / topmenue
            Button searchButton = new Button("Leihen");
            Button closeButton = new Button("Hilfe");
            Button testButton = new Button("Zurücknehmen");


        //Root Borderpane
        BorderPane root = new BorderPane();

            //Menü oben
            AnchorPane topmenue = new AnchorPane();
                //links
                HBox topmenuelinks = new HBox ();
                topmenuelinks.getChildren().addAll(searchButton,testButton);
                //rechts
                HBox topmenuerechts = new HBox();
                topmenuerechts.getChildren().addAll(closeButton);

            topmenue.setLeftAnchor(topmenuelinks, 0.0);
            topmenue.setRightAnchor(topmenuerechts, 0.0);
            topmenue.getChildren().addAll(topmenuelinks,topmenuerechts);
            topmenue.autosize();

            //Menü rechts
            //Menü unten
            //Menü links
            //Menü mitte
                GridPane midmenue = new GridPane();
                    //Links Hauptfeld
                    VBox midmenuleft = new VBox();

                        ColumnConstraints col1 = new ColumnConstraints();
                        col1.setPercentWidth(65);
                        TitledPane searchlayout = searchLayout();

                        TabPane chooselayout = new TabPane();
                        chooselayout.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
                        chooselayout.autosize();

                        //TAB BÜCHER
                        Tab books = new Tab("Bücher");

                            TableView leasedBooks = new TableView();
                            TableColumn colt1 = new TableColumn("ISBN");
                            TableColumn colt2 = new TableColumn("Author ");
                            TableColumn colt3 = new TableColumn("Titel");
                            TableColumn colt4 = new TableColumn("Return-date");
                            leasedBooks.getColumns().addAll(colt1, colt2, colt3, colt4);

                            leasedBooks.autosize();
                            leasedBooks.setPrefHeight(9999999.9);
                            books.setContent(leasedBooks);
                        //TAB Kunden
                        Tab customers = new Tab("Customer");

                        //TAB Bücherverwaltung
                        Tab bookManagement = new Tab("Bücherverwaltung");
                        chooselayout.getTabs().addAll(books, customers,bookManagement);

                    midmenuleft.getChildren().addAll(searchlayout, chooselayout);
                    midmenuleft.autosize();


                    //Rechts Infofeld
                    VBox midmenuright = new VBox();
                        ColumnConstraints col2 = new ColumnConstraints();
                        col2.setPercentWidth(35);
                        TitledPane searchlayout2 = searchLayout();

                        GridPane customerInfo = new GridPane();
                        Label infolabel = new Label("---KUNDENINFORMATIONEN---");
                        Label name = new Label("Name: " + " Max Musterman");
                        Label adresse = new Label("Adresse: " + "Arstalkajasdljk 23, 512434 asdasd");
                        Label bookcount = new Label("Ausgeliehene Bücher :" + "12");
                        Label trustfactor = new Label("Trustfactor: "+ "KEINE WEITEREN BÜCHER AUSLEIHEN");
                        customerInfo.add(infolabel, 0, 0);
                        customerInfo.add(name, 0, 1 );
                        customerInfo.add(adresse, 0, 2);
                        customerInfo.add(bookcount, 0, 3);

                        //TODO
                        TableView leasedBooks2 = new TableView();
                        leasedBooks2.getColumns().addAll(colt1, colt2, colt3, colt4);
                        leasedBooks2.autosize();
                        leasedBooks2.setPrefHeight(9999999.9);
                        midmenuright.getChildren().addAll(searchlayout2, customerInfo, leasedBooks2);
                        midmenuright.autosize();

                //TODO wenn eingeklappt nicht auf gleicher höhe

                midmenue.getColumnConstraints().addAll(col1,col2);
                midmenue.add(midmenuleft, 0, 0);
                midmenue.add(midmenuright, 1, 0);
                midmenue.autosize();


        BorderPane.setAlignment(topmenue, Pos.TOP_CENTER);
        root.autosize();
        root.setTop(topmenue);
        root.setCenter(midmenue);


        //MAIN WINDOW
        mainScene = new Scene(root);
        mainWindow = primaryStage;
        mainWindow.setHeight(MAIN_WINDOW_MIN_HEIGHT);
        mainWindow.setWidth(MAIN_WINDOW_MIN_WIDTH);
        mainWindow.setTitle(MAIN_NAME);
        mainWindow.setScene(mainScene);
        mainWindow.show();

        mainWindow.setOnCloseRequest(event -> {
            event.consume();
            closeProgramm();
        });
    }


    private void closeProgramm(){
        Boolean answer = ConfirmBox.display("Close the Programm", "Machs aus!");
        if (answer ==true) mainWindow.close();
    }

    private TitledPane searchLayout(){


        TitledPane searchlayout = new TitledPane();
            GridPane layout = new GridPane();

            //TODO - Erstellen der LöschButtons, Such und Operator felder - Dynamische Anzahl
            if (searchTermsCounter>1) {
                for (int i = 0; i <= searchTerms.size(); i++) {

                }
            }
            TextField testfield = new TextField();
            testfield.setPromptText("Suchbegriff");
            ComboBox<String> operatorbox = new ComboBox<>();

            operatorbox.getItems().addAll("=", "<", "<=", ">", ">=" , "ungleich");
            operatorbox.getSelectionModel().selectFirst();
            Button searchButton = new Button("Suchen");
            Button addSearchButton = new Button("+");
            layout.add(testfield, 0,0);
            layout.add(operatorbox, 1, 0);
            layout.add(searchButton, 2, 0);
            layout.add(addSearchButton, 0, 1);

        searchlayout.setContent(layout);
        searchlayout.autosize();

        return searchlayout;
    }

}