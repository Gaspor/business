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

public class FolhaPagamentoController implements Initializable {
    public void cadFuncionarioButtonAction(ActionEvent event) {
        cadFuncionario p = new cadFuncionario();
        fecha();
        try {
            p.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(initialController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    public void fecha(){
        folhaPagamento.getStage().close();
    }        
}
