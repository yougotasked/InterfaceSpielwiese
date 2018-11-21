import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Fckthatshit extends Application {

    Stage mainwindow;
    Scene scene;
    Label label, label2, label3;
    GridPane layout;



    public static void  main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        label = new Label("TEst1gfhjfghkfdgsfsgfthsgfdhfgsh");
        label2 = new Label("TEst2");
        label3 = new Label("TEst3");

        //VBox layout = new VBox();
        GridPane layout = new GridPane();
        layout.setHgap(15);
        layout.setVgap(15);
        layout.setPadding(new Insets(10, 10 , 10, 10 ));

        GridPane.setConstraints(label, 0, 0);
        GridPane.setConstraints(label2, 1, 0);
        GridPane.setConstraints(label3, 2, 0);


        layout.getChildren().addAll(label, label2, label3);


        scene = new Scene(layout, 500, 500);

        mainwindow = primaryStage;
        mainwindow.setScene(scene);
        mainwindow.show();
        mainwindow.setTitle("asagasgfas");



    }

}
