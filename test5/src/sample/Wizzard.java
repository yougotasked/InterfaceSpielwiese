package sample;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Wizzard {

    private BorderPane mainLayout;
    private int step;
    SearchLayout searchLayout;

    public BorderPane getMainLayout() {
        return mainLayout;
    }

    public BorderPane show(String type){
        step = 0;
        TitledPane customerSearch = (new SearchLayout("Kunde")).getSearchlayout();
        TitledPane bookSearch = (new SearchLayout("Büchersuche")).getSearchlayout();
        bookSearch.setDisable(true);
        bookSearch.setExpanded(false);

        //TODO not working
        customerSearch.setStyle("-fx-background-color: lightgreen");
        bookSearch.setStyle("-fx-background-color: ROSYBROWN ");

        Button nextButton = new Button("weiter");
        Button backButton = new Button("zurück");
        Button cancelButton = new Button("Wizzard beenden");
        HBox buttonMenue = new HBox();
        buttonMenue.getChildren().addAll(backButton,nextButton,cancelButton);

        BorderPane mainLayout = new BorderPane();
        VBox mainLayoutMiddle = new VBox();

        mainLayoutMiddle.getChildren().addAll(customerSearch, bookSearch);
        mainLayout.setCenter(mainLayoutMiddle);
        mainLayout.setBottom(buttonMenue);
        mainLayout.setStyle("-fx-background-color: #dfdfdf");

        Stage wizzard = new Stage();
        Scene scene = new Scene(mainLayout);
        wizzard.setMinWidth(400);
        wizzard.setMaxWidth(200);
        wizzard.setScene(scene);

        if (type == "return"){
            //Starte Rückgabe
            wizzard.setTitle("Rückgabe Wizzard!");
        }
        else{
            wizzard.setTitle("Ausleihen Wizzard!");
        }

        //Button funktionen
        cancelButton.setOnAction(event -> {
            Boolean answer = ConfirmBox.display("Eingabe abbrechen", "Wollen sie den Wizzard wirklich verlassen?2 \n Alle eingegebenen Daten gehen dabei verloren!");
            if (answer ==true) wizzard.close();
        } );

        nextButton.setOnAction(event -> {
            if(step == 0){
                customerSearch.setExpanded(false);
                bookSearch.setExpanded(true);
                customerSearch.setDisable(true);
                bookSearch.setDisable(false);

                //TODO not working
                customerSearch.setStyle("-fx-background-color: ROSYBROWN");
                bookSearch.setStyle("-fx-background-color: lightgreen");

                step++;
                System.out.println("nextButton with step : " + step );
            }
            if(step ==1){
                System.out.println("nextButton with step : " + step );
            }

        });
        backButton.setOnAction(event -> {
            if(step == 0){
                AltertBox.display("Bereits am Anfang", "Sie sind bereits am Anfang und können nicht zurück gehen");
                System.out.println("backButton with step : " + step);
            }
            if(step == 1){
                customerSearch.setExpanded(true);
                bookSearch.setExpanded(false);
                customerSearch.setDisable(false);
                bookSearch.setDisable(true);

                //TODO not working
                customerSearch.setStyle("-fx-background-color: lightgreen");
                bookSearch.setStyle("-fx-background-color: ROSYBROWN");

                System.out.println("backButton with step : " + step);
                step --;
            }
        });
        return mainLayout;
    }

}
