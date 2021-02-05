package business.Control;

import business.cadFuncionario;
import business.folhaPagamento;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

public class CadFuncionarioController implements Initializable {
    public void cancelCadFuncionarioButtonAction(ActionEvent event) {
        Folha();
    }
    
    public void CadFuncionarioButtonAction(ActionEvent event) {
        Folha();
    }
    
    public void Folha(){
        folhaPagamento p = new folhaPagamento();
        fecha();
        try {
            p.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(initialController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void fecha(){
        cadFuncionario.getStage().close();
    }   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }        
}
