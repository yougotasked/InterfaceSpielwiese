package sample;

import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.util.ArrayList;
import java.util.List;

public class SearchLayout{
    //Konstanten
    final static String[] OPERATOREN = {"=", "<", "<=", ">", ">=", "ungleich", "enthält"};
    final static String[] KATEGORIEN = {"Autor", "Titel", "Jahr", "Auflagen"};
    final static String[] COLUMNTEST = {"Autor", "Titel", "Jahr", "Stückzahl", "usw"};

    private String titel;
    private TitledPane searchlayout;
    public Button searchbutton = new Button("Suchen!");
    public Button addSearchButton = new Button("+");
    private int i = 0;

    private List<HBox> searchfields = new ArrayList<>();
    private List<TableColumn> resultColumnField = new ArrayList<>();

    private TableView resutlTable = new TableView();

    public SearchLayout(String titel) {
        this.titel = titel;
        createNewSearchLayout();

        addSearchButton.setOnAction(event -> {
            addSearchField();
            System.out.println("addsearchfield");
        });
        searchbutton.setOnAction(event -> {
            search();
        });
    }

    public TitledPane getSearchlayout() {
        return searchlayout;
    }

    private void createNewSearchLayout() {
        searchlayout = new TitledPane();
        searchlayout.setText(titel);
        addSearchField();
    }

    public void addSearchField() {
        HBox tempSearchField = new HBox();
        TextField searchwordInputField = new TextField();
        searchwordInputField.setPromptText(new String("Suchfeld"+ i));
        ComboBox<String> operatorComboBox = new ComboBox();
        operatorComboBox.getItems().addAll(OPERATOREN);
        operatorComboBox.getSelectionModel().selectFirst();
        ComboBox<String> categoryComboBox = new ComboBox<>();
        categoryComboBox.getItems().addAll(KATEGORIEN);
        categoryComboBox.getSelectionModel().selectFirst();
        Button deleteSearchButton = new Button("-");

        //DeleteSearchButton function
        deleteSearchButton.setOnAction(event -> {
            int ij = 0;
            for (HBox hbox : searchfields){
                String hboxChildrenString = hbox.getChildren().get(3).toString();
                String eventsourceString = event.getSource().toString();
               if(hboxChildrenString.toUpperCase().contains(eventsourceString.toUpperCase())){
                   deletesearch(ij);
                   create();
                   break;
               }
                ij++;
            }
                    });

        tempSearchField.getChildren().addAll(searchwordInputField,operatorComboBox, categoryComboBox, deleteSearchButton);
        searchfields.add(tempSearchField);
        i++;
        create();
    }

    private void create() {
        GridPane layout = new GridPane();
        int j= 0;
        for(HBox hbox : searchfields){
            layout.add(hbox, 0, j);
            j++;
        }
        layout.add(searchbutton, 1,0);
        layout.add(addSearchButton,0, j);
        searchlayout.setContent(layout);
    }

    public void addSearch() {
        addSearchField();
    }

    public void deletesearch(int i) {
        searchfields.remove(i);
        i--;
    }

    public void search(){
        for (HBox hbox : searchfields){
            Node searchwordInputField = hbox.getChildren().get(0);
            Node operatorBox = hbox.getChildren().get(1);
            Node categoryBox = hbox.getChildren().get(2);
            //TODO - Verwertung der Eingabe
            if(searchwordInputField instanceof TextField) {
                     System.out.println("Text : " + ((TextField) searchwordInputField).getText());
            }
            if(operatorBox instanceof  ComboBox){
                System.out.println("Gewählter Operator : " +   ((ComboBox) operatorBox).getSelectionModel().getSelectedItem());
            }
            if(categoryBox instanceof ComboBox){
                System.out.println("Gewählte Kategorie : " +   ((ComboBox) categoryBox).getSelectionModel().getSelectedItem());
            }
        }
    }

    public void createTable(){
        for(int f=0; resutlTable.getColumns().size() < f; f++ ){

            //TODO Beschriftung setzen
            TableColumn tableColumnTemp = new TableColumn();
            resultColumnField.add(tableColumnTemp);
        }
        for(int f = 0; resultColumnField.size() < f; f++){
            resutlTable.getColumns().add(resultColumnField.get(f));
        }
    }
}
