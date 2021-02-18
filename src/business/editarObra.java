package business;

import business.Control.EditarObraController;
import business.shared.obra;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class editarObra extends Application {
    private static Stage stage;

     public editarObra(obra p1){
        EditarObraController.setObra2(p1);
    
    }    
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("View/editarObra.fxml"));
        
        stage.setTitle("Editar Obra");
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
        editarObra.stage = stage;
    }
}
