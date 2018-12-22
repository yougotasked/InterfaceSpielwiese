package sample;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    //Konstanten
    private static final String MAIN_NAME = "Buchmeister 2999.84";
    private static final double MAIN_WINDOW_MIN_WIDTH = 1000;
    private static final double MAIN_WINDOW_MIN_HEIGHT = 600;
    //Variablen
    private Stage mainWindow;
    private Scene mainScene;


    public static void main(String[] args) {
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
        //Borderpane oben
        //Borderpane rechts
        //Borderpane unten
        HBox buttomMenue = new HBox();
        Button buttommenuebutton = new Button("buttommenuebutton");
        buttomMenue.getChildren().setAll(buttommenuebutton);
        setStyle(buttomMenue);
        //Borderpane links
        //Borderpane mitte
            //TAB MENUE
        TabPane mainTabMenue = new TabPane();
        Tab hauptübersicht = new Tab("Übersicht");
        Tab leihen = new Tab("Leihen");
        Tab zurueckgeben = new Tab("Zurückgabe");
        Tab mitgliederverwaltung = new Tab("Mitgliederverwaltung");
        Tab buecherverwaltung = new Tab ("Bücherverwaltung");
        Tab rechteverwaltung = new Tab("Rechteverwaltung");
        Tab hilfe = new Tab("HILFEEE!");

        mainTabMenue.getTabs().addAll(hauptübersicht,leihen, zurueckgeben,mitgliederverwaltung, buecherverwaltung, rechteverwaltung, hilfe );
        mainTabMenue.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
            //TabMenue füllung
        ContentCreater hauptübersichtConent = new ContentCreater("asdaf");
        hauptübersicht.setContent(hauptübersichtConent.result);
        setStyle(hauptübersichtConent.result);

        Wizzard wizzard = new Wizzard();
        leihen.setContent(wizzard.getMainLayout());
        mainTabMenue.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Tab>() {
            @Override
            public void changed(ObservableValue<? extends Tab> observable, Tab oldValue, Tab newValue) {
                if (newValue.getText() =="Leihen") System.out.println("augewählter TAB: LEIHEN");
                else System.out.println("augewählter TAB =/= Nicht leihen");
            }
        });

        leihen.setContent(wizzard.show("asdf"));

        root.setCenter(mainTabMenue);
        root.setBottom(buttomMenue);

        //MAIN WINDOW
        mainScene = new Scene(root);
        mainWindow = primaryStage;
        mainWindow.setHeight(MAIN_WINDOW_MIN_HEIGHT);
        mainWindow.setWidth(MAIN_WINDOW_MIN_WIDTH);
        mainWindow.setMinWidth(MAIN_WINDOW_MIN_WIDTH/2);
        mainWindow.setMinHeight(MAIN_WINDOW_MIN_HEIGHT/2);
        mainWindow.setTitle(MAIN_NAME);
        mainWindow.setScene(mainScene);
        mainWindow.show();

        mainWindow.setOnCloseRequest(event -> {
            event.consume();
            closeProgramm();
        });

        mainWindow.heightProperty().addListener((obs, oldVal, newVal) -> {
            hauptübersichtConent.setHeightPref(mainWindow.getHeight());
        });
    }

    private void closeProgramm() {
        Boolean answer = ConfirmBox.display("Programm schließen", "Wollen sie das Programm \nwirklich beenden?");
        if (answer == true) mainWindow.close();
    }


    private void setStyle(javafx.scene.layout.Pane c) {
        try {
            c.setPadding(new Insets(3));
            c.setBorder(new Border(new BorderStroke((Color.LIGHTGRAY),
                    BorderStrokeStyle.DASHED, new CornerRadii(5), BorderWidths.DEFAULT)));
            c.setStyle("-fx-background-color: #dfdfdf");
        } catch (Error error) {
            System.out.println("fehler beim stylen");
        }
    }
}