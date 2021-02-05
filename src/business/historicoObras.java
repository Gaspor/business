package business;

import static business.cadFuncionario.setStage;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class historicoObras extends Application {    
    private static Stage stage;
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("View/historicoObras.fxml"));
        
        stage.setTitle("Histórico de Obras");
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
        historicoObras.stage = stage;
    }
}
