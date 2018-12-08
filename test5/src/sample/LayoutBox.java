package sample;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class LayoutBox {


    public static GridPane createSearchlayout(double SEARCH_LAYOUT_MIN_WIDHT, double SEARCH_LAYOUT_MIN_HEIGHT, String topic, String promt ){
        //Elements
        Label label = new Label(topic);

        TextField input = new TextField();
        input.setMinWidth(500);
        input.setMaxWidth(650);
        input.setPromptText(promt);
        Button commitButton = new Button("Suchen!");

        GridPane searchLayout = new GridPane();
        HBox searchbox = new HBox();
        searchbox.setAlignment(Pos.CENTER);
        //TODO
        GridPane.setFillWidth(searchbox, true);
        GridPane.setHalignment(searchbox, HPos.CENTER);
        searchbox.getChildren().setAll(label, input, commitButton);
        searchLayout.getChildren().addAll(searchbox);
        searchLayout.setMinSize(SEARCH_LAYOUT_MIN_WIDHT, SEARCH_LAYOUT_MIN_HEIGHT);
        searchLayout.setBorder(new Border(new BorderStroke(Color.ROSYBROWN,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        return searchLayout;

    }

   // public static VBox createLeftSideMenue

    /**
     *
     */
    public static GridPane createInfoLayout(double INFO_LAYOUT_MIN_HEIGHT,double INFO_LAYOUT_MIN_WIDHT, String kategorieText){
        Label kategorie = new Label(kategorieText);
        GridPane infoLayout = new GridPane();
        infoLayout.setMinSize(INFO_LAYOUT_MIN_WIDHT, INFO_LAYOUT_MIN_HEIGHT);
        infoLayout.getChildren().addAll(kategorie);
        infoLayout.setBorder(new Border(new BorderStroke(Color.CYAN,
                BorderStrokeStyle.DASHED, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        return infoLayout;

    }

    public static VBox createAuswahlLayout(double AUSWAHL_LAYOUT_MIN_WIDHT, double AUSWAHL_LAYOUT_MIN_HEIGHT, String text){
        Label ueberschrift = new Label(text);
        VBox auswahlLayout = new VBox();
        GridPane.setConstraints(ueberschrift, 0,0);
        auswahlLayout.setMinSize(AUSWAHL_LAYOUT_MIN_WIDHT, AUSWAHL_LAYOUT_MIN_HEIGHT);
        auswahlLayout.getChildren().addAll(ueberschrift);
        auswahlLayout.setBorder(new Border(new BorderStroke(Color.CYAN,
                BorderStrokeStyle.DASHED, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

        return  auswahlLayout;
    }
}

