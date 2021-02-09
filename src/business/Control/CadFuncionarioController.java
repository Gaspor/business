package business.Control;

import business.cadFuncionario;
import business.shared.funcionario;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class CadFuncionarioController implements Initializable {
    @FXML public TextField tfNomeFuncinario;
    @FXML private TextField tfCargoFuncionario;
    @FXML private TextField tfSalarioFuncionario;
    @FXML private TextField tfTelefoneFuncinario;
    @FXML private DatePicker dpDataPagamento;
    
    String ErrorWarning = "Ocorreu um erro!";

    public void cancelCadFuncionarioButtonAction(ActionEvent event) {        
        fecha();
    }
    
    public void CadFuncionarioButtonAction(ActionEvent event) {
        if (tfNomeFuncinario.getText().isEmpty() ||
            tfCargoFuncionario.getText().isEmpty() ||
            tfSalarioFuncionario.getText().isEmpty() ||
            tfTelefoneFuncinario.getText().isEmpty() ||
            dpDataPagamento.getValue() == null) {
            
            ErrorWarning = "Preencha todos os campos com *";
            Error(ErrorWarning);
            
        } else {
            if(funcionario.dbFuncionarioConfirmation()){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Funcionário cadastrado");
                alert.setHeaderText("Novo Funcionário cadastrado!");
                alert.showAndWait();
                
            } else {
                ErrorWarning = "Não foi possivel cadastrar o funcionário!";
                Error(ErrorWarning);
                
            }
            fecha();  
        }              
    }
    
    public void fecha(){
        cadFuncionario.getStage().close();
    }
    
    public void Error(String strError){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro");
        alert.setHeaderText("Funcionário Não cadastrado!");
        alert.setContentText(strError);
        alert.showAndWait();    
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
}        

