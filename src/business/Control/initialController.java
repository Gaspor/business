package business.Control;

import business.DAO.FuncionarioDao;
import business.cadFuncionario;
import business.historicoObras;
import business.editarObra;
import business.cadObra;
import business.initial;
import business.shared.funcionario;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class initialController implements Initializable {
    
    @FXML private TableView<funcionario> tabela;
    @FXML private TableColumn<funcionario, String> tbTelefone;
    @FXML private TableColumn<funcionario, String> tbCargo;
    @FXML private TableColumn<funcionario, String> tbSalario;
    @FXML private TableColumn<funcionario, String> tbNome;
    @FXML private TableColumn<funcionario, Long> tbID;
    @FXML private TableColumn<funcionario, String> tbData;

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
        initTable();
    }

    public void fecha() {
        initial.getStage().close();
    }
    
    public void initTable(){
        tbID.setCellValueFactory(new PropertyValueFactory("id"));
        tbNome.setCellValueFactory(new PropertyValueFactory("nome"));
        tbTelefone.setCellValueFactory(new PropertyValueFactory("telefone"));
        tbCargo.setCellValueFactory(new PropertyValueFactory("cargo"));
        tbSalario.setCellValueFactory(new PropertyValueFactory("salario"));
        tbData.setCellValueFactory(new PropertyValueFactory("data"));   
        tabela.setItems(atualizaTabela());
    
    }
    
    public ObservableList<funcionario>atualizaTabela(){
        FuncionarioDao dao = new FuncionarioDao(); 
        return FXCollections.observableArrayList(dao.getList());
        
    }
}
