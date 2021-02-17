package business.Control;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class EditarObraController implements Initializable {
    @FXML
    private TextField tfEmailCliente;
    @FXML
    private TextField tfBairroCliente;
    @FXML
    private TextField tfNomeCliente;
    @FXML
    private TextField tfCadObraNomeFuncionario;
    @FXML
    private TextField tfValorObra;
    @FXML
    private TextField tfRuaCliente;
    @FXML
    private TextField tfNumeroCasaCliente;
    @FXML
    private TextField tfTipoObra;
    @FXML
    private TextField tfTelefoneCliente;
    @FXML
    private DatePicker dpEntregaObra;
    @FXML
    private DatePicker dpInicioObra;
    @FXML
    private TextArea tfDescricaoObra;
    
    public void setInfos(){
        //tfCadObraNomeFuncionario.setText(o.getNomeFuncionario());
        tfCadObraNomeFuncionario.setText("Bazuca");
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setInfos();
    }    
}
