package business.Control;

import business.cadFuncionario;
import business.historicoObras;
import business.editarObra;
import business.cadObra;
import business.initial;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

public class initialController implements Initializable {    
    public void cadObraButtonAction(ActionEvent event) {
        cadObra p = new cadObra();        
        
        try {
            p.start(new Stage());
            
        } catch (Exception ex) {
            Logger.getLogger(initialController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void editarObraButtonAction(ActionEvent event) {
        editarObra p = new editarObra();        
        
        try {
            p.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(initialController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void historicoObrasButtonAction(ActionEvent event) {
        historicoObras p = new historicoObras();        
        
        try {
            p.start(new Stage());
        } catch (Exception ex) {
            Logger.getLogger(initialController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void cadFuncionarioButtonAction(ActionEvent event) {
        cadFuncionario p = new cadFuncionario();
        
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
        initial.getStage().close();
    }
}
