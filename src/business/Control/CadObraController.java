package business.Control;

import business.cadObra;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

public class CadObraController implements Initializable {
    public void cancelCadObra(ActionEvent event) {
        fecha();
    }
    
    public void cadastrarObra(ActionEvent event) {
        fecha();
    }
    
    public void fecha(){
        cadObra.getStage().close();
    } 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
}
