package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.List;

public class Main extends Application  {

    //Konstanten
    private static final String MAIN_NAME = "Buchmeister 2999.84";
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
    private int searchTermsCounter = 0;
    private List<String> searchTerms;


    public static void  main(String[] args){

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        //Buttons
            //Menue Oben / Main Menu / topmenue
            Button borrowButton = new Button("Leihen");
            borrowButton.setTooltip(new Tooltip("Leihen Wizzard starten"));
            Button helpButton = new Button("Hilfe");
            helpButton.setTooltip(new Tooltip("Hier wird ihnen geholfen!"));
            Button returnButton = new Button("Zurücknehmen");
            returnButton.setTooltip(new Tooltip("Zurückgeben Wizzard starten"));


        //Root Borderpane
        BorderPane root = new BorderPane();

            //Menü oben
            AnchorPane topMenue = new AnchorPane();
            topMenue.setPadding(new Insets(3));
            //topmenue.setBorder(new Border(new BorderStroke((Color.LIGHTGRAY),
               // BorderStrokeStyle.DASHED, new CornerRadii(5), BorderWidths.DEFAULT)));
                //links
                HBox topmenuelinks = new HBox ();
                topmenuelinks.getChildren().addAll(borrowButton,returnButton);
                //rechts
                HBox topmenuerechts = new HBox();
                topmenuerechts.getChildren().addAll(helpButton);

            AnchorPane.setLeftAnchor(topmenuelinks, 0.0);
            AnchorPane.setRightAnchor(topmenuerechts, 0.0);
            topMenue.getChildren().addAll(topmenuelinks,topmenuerechts);
            topMenue.autosize();

            //Menü rechts
            //Menü unten
            HBox buttomMenue = new HBox();
            Button buttommenuebutton = new Button("buttommenuebutton");
            buttomMenue.getChildren().setAll(buttommenuebutton);
            //Menü links
            //Menü mitte
                GridPane midMenue = new GridPane();
                    //Links Hauptfeld
                    VBox midmenuleft = new VBox();
                    midmenuleft.setPadding(new Insets(3));
                    //midmenuleft.setBorder(new Border(new BorderStroke((Color.LIGHTGRAY),
                    //BorderStrokeStyle.DASHED, new CornerRadii(5), BorderWidths.DEFAULT)));


                        ColumnConstraints col1 = new ColumnConstraints();
                        col1.setPercentWidth(65);
                        TitledPane searchlayout = LayoutBox.searchLayout("Suche", searchTermsCounter);
                       // SearchLayout sltest = new SearchLayout();
                        TabPane chooselayout = new TabPane();
                        chooselayout.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
                        chooselayout.autosize();

                        //TODO (ScrollPane ??)
                        //TAB BÜCHER
                        //ScrollPane scrollPanebooksleftside = new ScrollPane();
                        Tab books = new Tab("Bücher");

                            TableView leasedBooks = new TableView();
                            TableColumn colt1 = new TableColumn("ISBN");
                            TableColumn colt2 = new TableColumn("Autor ");
                            TableColumn colt3 = new TableColumn("Titel");
                            TableColumn colt4 = new TableColumn("Rüggabetermin");
                            leasedBooks.getColumns().addAll(colt1, colt2, colt3, colt4);



                            leasedBooks.autosize();
                            //leasedBooks.setPrefHeight(9999999.9);
                            //scrollPanebooksleftside.setContent(leasedBooks);
                            books.setContent(leasedBooks);
                        //TAB Kunden
                        Tab customers = new Tab("Kunden");

                        //TAB Bücherverwaltung
                        Tab bookManagement = new Tab("Bücherverwaltung");
                        chooselayout.getTabs().addAll(books, customers,bookManagement);

                    midmenuleft.getChildren().addAll(searchlayout, chooselayout);
                    midmenuleft.autosize();


                    //Rechts Infofeld
                    VBox midmenuright = new VBox();
                    midmenuright.setPadding(new Insets(3));
                    midmenuright.setBorder(new Border(new BorderStroke((Color.LIGHTGRAY),
                            BorderStrokeStyle.DASHED, new CornerRadii(5), BorderWidths.DEFAULT)));
                    midmenuright.setStyle("-fx-background-color: #dfdfdf");

                        ColumnConstraints col2 = new ColumnConstraints();
                        col2.setPercentWidth(35);
                        TitledPane searchlayout2 = LayoutBox.searchLayout("Kundensuche", searchTermsCounter);

                        GridPane customerInfo = new GridPane();
                        Label infolabel = new Label("---KUNDENINFORMATIONEN---");
                        Label name = new Label("Name: " + " Max Musterman");
                        Label adresse = new Label("Adresse: " + "Arstalkajasdljk 23, 512434 asdasd");
                        Label bookcount = new Label("Ausgeliehene Bücher :" + "12");
                        Label trustfactor = new Label("Trustfactor: "+ "20");
                        customerInfo.add(infolabel, 0, 0);
                        customerInfo.add(name, 0, 1 );
                        customerInfo.add(adresse, 0, 2);
                        customerInfo.add(trustfactor, 0, 3);
                        customerInfo.add(bookcount, 0, 4);

                        //TODO (ScrollPane ??)
                        //ScrollPane scrollPanebooksrightside = new ScrollPane();
                        TableView leasedBooks2 = new TableView();
                        leasedBooks2.getColumns().addAll(colt1, colt2, colt3, colt4);
                        leasedBooks2.autosize();


                        AnchorPane saveMenue = new AnchorPane();
                        Button save = new Button("Änderungen übernehmen");
                        AnchorPane.setRightAnchor(save, 3.0);
                        saveMenue.getChildren().addAll(save);


                        midmenuright.getChildren().addAll(searchlayout2, customerInfo, leasedBooks2, saveMenue);
                        midmenuright.autosize();

                //TODO wenn eingeklappt nicht auf gleicher höhe

                midMenue.getColumnConstraints().addAll(col1,col2);
                midMenue.add(midmenuleft, 0, 0);
                midMenue.add(midmenuright, 1, 0);
                midMenue.autosize();


        BorderPane.setAlignment(topMenue, Pos.TOP_CENTER);
        root.autosize();
        root.setTop(topMenue);
        root.setCenter(midMenue);
        root.setBottom(buttomMenue);


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
        Boolean answer = ConfirmBox.display("Programm schließen", "Wollen sie das Programm \nwirklich beenden?");
        if (answer ==true) mainWindow.close();
    }



}