package sample;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class LayoutBox {




    public static VBox createInfoLayout(double INFO_LAYOUT_MIN_WIDHT, double INFO_LAYOUT_MIN_HEIGHT, String kategorieText){
        VBox infoLayout = new VBox();
        infoLayout.setMinSize(INFO_LAYOUT_MIN_WIDHT, INFO_LAYOUT_MIN_HEIGHT);
        Label label = new Label(kategorieText);
        infoLayout.getChildren().addAll(label, new Label("askllkasgkjlasdkjlaskldlasdjklasd", new Label("askjgkjasgkjlasjklklajsgkjlasdkjlaskjlgkjlakjlsd")));

        return infoLayout;

    }

    public static Pane createAuswahlLayout(double RESULT_LAYOUT_MIN_WIDHT,double RESULT_LAYOUT_MIN_HEIGHT, String text){
        Pane auswahlLayout = new Pane();
        TableView table = new TableView();
        table.setMinSize(RESULT_LAYOUT_MIN_WIDHT, RESULT_LAYOUT_MIN_HEIGHT);
        auswahlLayout.getChildren().addAll(table);




        return  auswahlLayout;
    }


}

