package sample;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Wizzard {

    public static void show(String type){

        Button nextButton = new Button("weiter");
        Button backButton = new Button("zurück");
        Button cancelButton = new Button("Wizzard beenden");

        BorderPane mainLayout = new BorderPane();
        VBox mainLayoutMiddle = new VBox();
        mainLayoutMiddle.getChildren().addAll(LayoutBox.searchLayout("Kunde", 0), nextButton, backButton, cancelButton);
        mainLayout.setCenter(mainLayoutMiddle);

        mainLayout.setStyle("-fx-background-color: #dfdfdf");
        Stage wizzard = new Stage();
        Scene scene = new Scene(mainLayout);
        wizzard.initModality(Modality.APPLICATION_MODAL); //Fenster im hintergrund sind gefreezet
        wizzard.setMinWidth(400);
        wizzard.setMaxWidth(200);
        wizzard.setScene(scene);
        wizzard.show();
        wizzard.centerOnScreen();

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
        wizzard.setOnCloseRequest(event -> {
            event.consume();
            Boolean answer = ConfirmBox.display("Eingabe Abbrechen", "Wollen sie den Wizzard wirklich verlassen?2 \n Alle eingegebenen Daten gehen dabei verloren!");
            if (answer ==true) wizzard.close();
        });


    }
}
