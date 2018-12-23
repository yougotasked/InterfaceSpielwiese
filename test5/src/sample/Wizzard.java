package sample;

import javafx.scene.Scene;
import javafx.scene.control.Button;
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

        Button nextButton = new Button("weiter");
        Button backButton = new Button("zurück");
        Button cancelButton = new Button("Wizzard beenden");
        HBox buttonMenue = new HBox();
        buttonMenue.getChildren().addAll(nextButton,backButton,cancelButton);

        BorderPane mainLayout = new BorderPane();
        VBox mainLayoutMiddle = new VBox();

        mainLayout.setCenter(mainLayoutMiddle);
        mainLayoutMiddle.getChildren().addAll(buttonMenue);
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

        return mainLayout;
    }

}
