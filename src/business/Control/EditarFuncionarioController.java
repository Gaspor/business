/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Control;

import business.DAO.FuncionarioDao;
import business.cadFuncionario;
import business.editarFuncionario;
import business.shared.funcionario;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class EditarFuncionarioController implements Initializable {

    @FXML
    private TextField tfCargoFuncionario;

    @FXML
    private Button btnEditarFuncionario;

    @FXML
    private TextField tfSalarioFuncionario;

    @FXML
    private DatePicker dpDataPagamento;

    @FXML
    private TextField tfTelefoneFuncionario;

    @FXML
    private Button btnCancelCadFuncionario;

    @FXML
    private TextField tfNomeFuncionario;

    private static funcionario funcionario2;

    public static funcionario getFuncionario2() {
        return funcionario2;
    }

    public static void setFuncionario2(funcionario funcionario2) {
        EditarFuncionarioController.funcionario2 = funcionario2;
    }



    @Override
    public void initialize(URL url, ResourceBundle rb) {
       mostraDetalhes();
    }

    public void fecha() {
        editarFuncionario.getStage().close();
    }

    public void cancelEditFuncionarioButtonAction(ActionEvent event) {
        fecha();
    }

    public void editFuncionarioButtonAction(ActionEvent event) {
        Atualiza();
        fecha(); 
    }

    public void Atualiza() {
        Long id = funcionario2.getId();
        String nome = tfNomeFuncionario.getText();
        String telefone = tfTelefoneFuncionario.getText();
        String cargo = tfCargoFuncionario.getText();
        String salario = tfSalarioFuncionario.getText();
        FuncionarioDao dao = new FuncionarioDao();
        funcionario emp = new funcionario(nome, telefone, cargo, salario, id);

        if (dao.update(emp)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Funcionário atualizado");
            alert.setHeaderText("Funcionário atualizado com sucesso!");
            alert.showAndWait();
           
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Funcionário Não atualizado!");
            alert.setContentText("Funcionario não atualizado");
            alert.showAndWait();
        }
    }

    public void mostraDetalhes() {
        tfNomeFuncionario.setText(funcionario2.getNome());
        tfTelefoneFuncionario.setText(funcionario2.getTelefone());
        tfCargoFuncionario.setText(funcionario2.getCargo());
        tfSalarioFuncionario.setText(funcionario2.getSalario());
        // dpDataPagamento.setText(funcionario2.getData());
    }
}
