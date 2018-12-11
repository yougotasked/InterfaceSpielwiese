package sample;

import javafx.scene.control.TitledPane;

public class SearchLayout {

    final static String[] OPERATOREN = {"=", "<", "<=", ">", ">=" , "ungleich"};

    private int i, searchcounter;
    private String titel;

    public SearchLayout() {
        this.i = 0;
        this.searchcounter = 0;
        this.titel = "Suchfeld";

    }
    public SearchLayout(int i, int searchcounter, String titel){
        this.i = i;
        this.searchcounter = searchcounter;
        this.titel = titel;
    }

    public TitledPane getSearchLayout(){
        return create(titel, searchcounter);
    }

    private static void addSearch(){
        
    }

    private static TitledPane create(String titel, int searchTermsCounter){
        TitledPane searchlayout = new TitledPane();

        return searchlayout;
    }


}
