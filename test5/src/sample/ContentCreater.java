package sample;

import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class ContentCreater{

    private final double PRESET_HEIGHT = 3000.0;

    public GridPane result;
    public TableView leasedBooks2, leaseBooks;
    private double prefheight, prefwidth;
    private String type;
    int searchTermsCounter = 0;

    public ContentCreater(String type) {
        this.type = type;
        start();
    }

    private void start(){
        //TODO
        if (type == ""){
        }
        result = getSelectedTabMainMenue("test");
    }

    private GridPane getSelectedTabMainMenue(String auswahl){
        //GRIDPANE
        GridPane midMenue = new GridPane();
        midMenue.setVgap(0);

        //Links Hauptfeld
        VBox midmenuleft = new VBox();

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(65);

       // TitledPane searchlayout = LayoutBox.searchLayout("Suche",searchTermsCounter );
        SearchLayout sl = new SearchLayout( "Büchersuche");
        TitledPane searchlayout = sl.getSearchlayout();

        TableView leasedBooks = new TableView();
        TableColumn colt1 = new TableColumn("ISBN");
        TableColumn colt2 = new TableColumn("Autor ");
        TableColumn colt3 = new TableColumn("Titel");
        TableColumn colt4 = new TableColumn("Rüggabetermin");
        leasedBooks.getColumns().addAll(colt1, colt2, colt3, colt4);
        leasedBooks.autosize();


        ButtonBar buttonMenueLeftSide = new ButtonBar();

        Button submitselected = new Button("Hinzufügen");
        buttonMenueLeftSide.getButtons().addAll(submitselected);
        midmenuleft.getChildren().addAll(searchlayout, leasedBooks, buttonMenueLeftSide);
        midmenuleft.autosize();

        //Rechts Infofeld
        VBox midmenuright = new VBox();


        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(35);
       // TitledPane searchlayout2 = LayoutBox.searchLayout("Kundensuche", searchTermsCounter);

        TitledPane searchlayout2 = (new SearchLayout("Kundensuche")).getSearchlayout();
        GridPane customerInfo = new GridPane();
        Label infolabel = new Label("---KUNDENINFORMATIONEN---");
        Label name = new Label("Name: " + " Max Musterman");
        Label adresse = new Label("Adresse: " + "Arstalkajasdljk 23, 512434 asdasd");
        Label bookcount = new Label("Ausgeliehene Bücher :" + "12");
        Label trustfactor = new Label("Trustfactor: " + "20");
        customerInfo.add(infolabel, 0, 0);
        customerInfo.add(name, 0, 1);
        customerInfo.add(adresse, 0, 2);
        customerInfo.add(trustfactor, 0, 3);
        customerInfo.add(bookcount, 0, 4);

        //TODO (ScrollPane ??)
        //ScrollPane scrollPanebooksrightside = new ScrollPane();
        TableView leasedBooks2 = new TableView();
        leasedBooks2.getColumns().addAll(colt1, colt2, colt3, colt4);
        leasedBooks2.autosize();

        AnchorPane saveMenue = new AnchorPane();
        Button save = new Button("Änderungen übernehmen");
        AnchorPane.setRightAnchor(save, 3.0);
        saveMenue.getChildren().addAll(save);

        midmenuright.getChildren().addAll(searchlayout2, customerInfo, leasedBooks2, saveMenue);
        midmenuright.autosize();



        midMenue.getColumnConstraints().addAll(col1, col2);
        midMenue.add(midmenuleft, 0, 0);
        midMenue.add(midmenuright, 1, 0);
        midMenue.autosize();


        leasedBooks.setPrefHeight(PRESET_HEIGHT);
        leasedBooks2.setPrefHeight(PRESET_HEIGHT);

        return midMenue;
    }

    public void setHeightPref(double h){
        result.setPrefHeight(h);

    }


}
