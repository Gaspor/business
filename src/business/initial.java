package business;

import business.JDBC.ConnectionBd;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class initial extends Application {
    private static Stage stage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        new ConnectionBd().getConnection();
        Parent root = FXMLLoader.load(getClass().getResource("View/initial.fxml"));

        Scene scene = new Scene(root);

        stage.setTitle("Obras em aberto");
        stage.setScene(scene);
        stage.show();
        setStage(stage);
        stage.setOnCloseRequest(event -> {
            System.exit(0);
        });
        
    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        initial.stage = stage;
    }

}
