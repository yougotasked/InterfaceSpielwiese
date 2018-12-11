package sample;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.GridPane;

public class LayoutBox {
    final static String[] OPERATOREN = {"=", "<", "<=", ">", ">=" , "ungleich"};

    public static TitledPane searchLayout(String titel, int searchTermsCounter){
        TitledPane searchlayout = new TitledPane();
        GridPane layout = new GridPane();
        ComboBox<String> operatorbox = new ComboBox<>();
        operatorbox.getItems().addAll(OPERATOREN);
        operatorbox.getSelectionModel().selectFirst();
        //TODO - Erstellen der LöschButtons, Such und Operator felder - Dynamische Anzahl
        int i = 0;
        if (i < searchTermsCounter){
            for (i = 0; i <= searchTermsCounter; i++) {
                TextField textFieldinc = new TextField();
                Button searchButtoninc = new Button(Integer.toString(i));
                ComboBox<String> operatorhelper = new ComboBox<>();
                operatorhelper.getItems().addAll("=", "<", "<=", ">", ">=" , "ungleich");
                operatorbox.getSelectionModel().selectFirst();
                textFieldinc.setPromptText(Integer.toString(i));
                layout.add(textFieldinc,0, i );
                layout.add(operatorhelper, 1, i);
            }
        }
        TextField testfield = new TextField();

        testfield.setPromptText("Suchbegriff");

        Button searchButton = new Button("Suchen");
        Button addSearchButton = new Button("+");
        layout.add(testfield, 0,0);
        layout.add(operatorbox, 1, 0);
        layout.add(searchButton, 2, 0);
        layout.add(addSearchButton, 0, i+1);

        searchlayout.setContent(layout);
        searchlayout.autosize();
        searchlayout.setText(titel);

        addSearchButton.setOnAction(event -> {

        });

        searchButton.setOnAction(event -> {

        });

        return searchlayout;
    }


}

