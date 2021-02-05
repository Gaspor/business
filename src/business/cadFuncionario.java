package business;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class cadFuncionario extends Application {
    private static Stage stage;
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("View/cadFuncionario.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setTitle("Cadastrar funcionário");
        stage.setScene(scene);
        stage.show();
        setStage(stage);
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    public static Stage getStage(){
        return stage;
    }
    
    public static void setStage(Stage stage){
        cadFuncionario.stage = stage;
    }
}    
