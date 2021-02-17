package business;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class cadObra extends Application {
    private static Stage stage;
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("View/cadObra.fxml"));
        
        stage.setTitle("Cadastrar obra");
        stage.setScene(new Scene(root));
        stage.initModality(Modality.APPLICATION_MODAL);
        setStage(stage);
        stage.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }    
    
    public static Stage getStage(){
        return stage;
    }
    
    public static void setStage(Stage stage){
        cadObra.stage = stage;
    }
}
