package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

//import java.awt.*;

public class AltertBox {

    public static void  display(String title, String message) {

        Stage allertWindow = new Stage();

        // Label mit fehlernachricht
        Label fehlerNachricht = new Label();
        fehlerNachricht.setText(message);
        fehlerNachricht.setTextFill(Color.RED);
        fehlerNachricht.setStyle("-fx-font-size: 20");
        int i = message.length();

        //OK Button
        Button okButton = new Button();
        okButton.setText("Verstanden");
        okButton.setOnAction(event -> allertWindow.close());
        okButton.setStyle("-fx-font-size: 20");
        okButton.setStyle("-fx-background-color: forestgreen; -fx-border-color: #000000");
        okButton.setPrefSize(120, 40);

        // LayoutManager
        VBox vertlayout = new VBox();
        vertlayout.setStyle("-fx-background-color: #dfdfdf");
        vertlayout.getChildren().addAll(fehlerNachricht, okButton);
        vertlayout.setAlignment(Pos.BOTTOM_CENTER);

        //Scene/Stage
        Scene scene1 = new Scene(vertlayout);
        allertWindow.initModality(Modality.APPLICATION_MODAL);
        allertWindow.setTitle("Fehler" + title);
        allertWindow.setScene(scene1);
        allertWindow.setMinWidth(i * 8);
        allertWindow.showAndWait();

    }

}
