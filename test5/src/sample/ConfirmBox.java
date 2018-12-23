package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmBox {

    static boolean answer;

    public static boolean display(String title, String message) {
        Stage answerme = new Stage();

        Label frage = new Label(message);
        frage.setTextAlignment(TextAlignment.CENTER);
        frage.setStyle("-fx-font-size: 20");

        Button yesButton = new Button("Ja!");
        yesButton.setStyle("-fx-background-color: forestgreen; -fx-border-color: #000000");
        yesButton.setPrefSize(60, 40);

        Button noButton = new Button("Nö!");
        noButton.setStyle("-fx-background-color: indianred; -fx-border-color: #000000");
        noButton.setPrefSize(60, 40);

        yesButton.setOnAction(event -> {
            answer = true;
            answerme.close();
        });
        noButton.setOnAction(event -> {
            answer = false;
            answerme.close();
        });

        HBox buttonLayout = new HBox();
        buttonLayout.getChildren().addAll(yesButton, noButton);
        buttonLayout.setAlignment(Pos.CENTER);
        buttonLayout.setSpacing(5);

        VBox mainLayout = new VBox();
        mainLayout.getChildren().addAll(frage, buttonLayout);
        mainLayout.setAlignment(Pos.CENTER);
        mainLayout.setStyle("-fx-background-color: #dfdfdf");

        Scene scene = new Scene(mainLayout);
        answerme.initModality(Modality.APPLICATION_MODAL);
        answerme.setTitle(title);
        answerme.setMinWidth(400);
        answerme.setMaxWidth(400);
        answerme.setMinHeight(150);
        answerme.setMaxHeight(150);
        answerme.setScene(scene);
        answerme.showAndWait();
        answerme.centerOnScreen();

        return answer;
    }

}
