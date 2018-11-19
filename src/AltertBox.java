import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.*;

public class AltertBox {

    public static void  display(String title, String message){
        Stage allertWindow = new Stage();
        // Label mit fehlernachricht
        Label fehlerNachricht = new Label();
        fehlerNachricht.setText(message);
        Label test = new Label();
        int i = message.length();
        test.setText(String.valueOf(i));

        //OK Button
        Button okButton = new Button();
        okButton.setText("Okydoki");
        okButton.setOnAction(event -> allertWindow.close());

        // LayoutManager
        VBox vertlayout = new VBox();
        vertlayout.getChildren().addAll(fehlerNachricht, okButton,test);
        vertlayout.setAlignment(Pos.BOTTOM_CENTER);



        Scene scene1 = new Scene(vertlayout);


        allertWindow.initModality(Modality.APPLICATION_MODAL);
        allertWindow.setTitle("Fehler" + title);
        allertWindow.setScene(scene1);
        allertWindow.setMinWidth(i*8);
        allertWindow.showAndWait();


    }

}
