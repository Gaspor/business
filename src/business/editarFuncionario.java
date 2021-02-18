/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import business.Control.EditarFuncionarioController;
import business.shared.funcionario;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author victor
 */
public class editarFuncionario extends Application {

    private static Stage stage;

    public static void main(String[] args) {
        launch(args);
    }

    public editarFuncionario(funcionario p1) {
        EditarFuncionarioController.setFuncionario2(p1);

    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("View/editarFuncionario.fxml"));

        Scene scene = new Scene(root);

        stage.setTitle("Editar Funcionario");
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        setStage(stage);
        stage.showAndWait();
    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        editarFuncionario.stage = stage;
    }
}
