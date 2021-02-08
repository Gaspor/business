package business.Control;

import business.cadObra;
import business.shared.dataBase;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class CadObraController implements Initializable {
    @FXML private TextField tfBairroCliente;
    @FXML private TextField tfNomeCliente;
    @FXML private TextField tfCadObraNomeFuncionario;
    @FXML private TextField tfValorObra;    
    @FXML private TextField tfRuaCliente;
    @FXML private TextField tfNumeroCasaCliente;
    @FXML private TextField tfTipoObra;
    @FXML private DatePicker dpEntregaObra;
    @FXML private DatePicker dpInicioObra;
    
    String ErrorWarning = "Ocorreu um erro!";
        
    public void cancelCadObra(ActionEvent event) {
        fecha();
    }
    
    public void cadastrarObra(ActionEvent event) {
        if (tfCadObraNomeFuncionario.getText().isEmpty() || 
            tfValorObra.getText().isEmpty() || 
            tfTipoObra.getText().isEmpty() ||
            tfNomeCliente.getText().isEmpty() ||
            tfRuaCliente.getText().isEmpty() ||
            tfNumeroCasaCliente.getText().isEmpty() ||
            tfBairroCliente.getText().isEmpty() ||
            dpEntregaObra.getValue() == null ||
            dpInicioObra.getValue() == null){
            
            ErrorWarning = "Preencha todos os campos com *";
            Error(ErrorWarning);
            
        } else {
            if(dataBase.dbObraConfirmation()){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Obra cadastrada");
                alert.setHeaderText("Nova Obra Cadastrada!");
                alert.showAndWait();     

            } else {
                ErrorWarning = "Não foi possivel cadastrar a obra!";
                Error(ErrorWarning);
                
            }                      
            fecha();
        }
    }
    
    public void fecha(){
        cadObra.getStage().close();
    }
    
    public void Error(String strError){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro");
        alert.setHeaderText("Obra não Cadastrada!");
        alert.setContentText(strError);
        alert.showAndWait(); 
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
}
