import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.*;

public class ConfirmBox {

    static boolean answer;

    public static boolean display(String title, String message){

        Stage answerme = new Stage();
        Label frage = new Label(message);


        Button yesButton = new Button("Ja!");
        yesButton.setOnAction(event -> {
            answer = true;
            answerme.close();

        } );

        Button noButton = new Button("Nö!");
        noButton.setOnAction(event -> {
            answer = false;
            answerme.close();
        });



        VBox layout = new VBox();
        layout.getChildren().addAll(frage, yesButton, noButton);
        Scene scene = new Scene(layout);

        answerme.initModality(Modality.APPLICATION_MODAL);
        answerme.setTitle(title);
        answerme.setMinWidth(300);
        answerme.setScene(scene);
        answerme.showAndWait();

        return answer;
    }

}
