package sample;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Wizzard {

    public static void show(String type, String title, String message){

        if (type == "return"){
            //Starte Rückgabe
        }
        else{
            //Starte Verleih

        }

        Button nextButton = new Button("weiter");
        Button backButton = new Button("zurück");
        Button cancelButton = new Button("Wizzard beenden");

        BorderPane mainLayout = new BorderPane();
        VBox mainLayoutMiddle = new VBox();
        mainLayoutMiddle.getChildren().addAll(LayoutBox.searchLayout("Kunde", 0));
        mainLayout.setCenter(mainLayoutMiddle);

        Stage wizzard = new Stage();
        Scene scene = new Scene(mainLayout);
        wizzard.initModality(Modality.APPLICATION_MODAL);
        wizzard.setTitle(title);
        wizzard.setMinWidth(400);
        wizzard.setMaxWidth(400);
        wizzard.setMinHeight(150);
        wizzard.setMaxHeight(150);
        wizzard.setScene(scene);
        wizzard.showAndWait();
        wizzard.centerOnScreen();

        //Button funktionen
        cancelButton.setOnAction(event -> {
            Boolean answer = ConfirmBox.display("Eingabe Abbrechen", "Wollen sie den Wizzard wirklich verlassen?2 \n Alle eingegebenen Daten gehen dabei verloren!");
            if (answer ==true) wizzard.close();

        } );


    }
}
