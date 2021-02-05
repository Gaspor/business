package business.Control;

import business.cadFuncionario;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

public class CadFuncionarioController implements Initializable {
    public void cancelCadFuncionarioButtonAction(ActionEvent event) {
        
        fecha();
    }
    
    public void CadFuncionarioButtonAction(ActionEvent event) {
        
        fecha();
    }
    
    public void fecha(){
        cadFuncionario.getStage().close();
    }   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }        
}
