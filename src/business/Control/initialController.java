package business.Control;

import business.DAO.FuncionarioDao;
import business.DAO.ObraDao;
import business.cadFuncionario;
import business.historicoObras;
import business.editarObra;
import business.cadObra;
import business.initial;
import business.shared.funcionario;
import business.shared.obra;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
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
    @FXML private Button btnExcluirFuncionario;
    
    @FXML private TableView<obra> tabelaObras;
    @FXML private TableColumn<obra, String> tbNomeCliente;
    @FXML private TableColumn<obra, String> tbTelefoneCliente;
    @FXML private TableColumn<obra, String> tbEmailCliente;    
    @FXML private TableColumn<obra, String> tbTipoObra;
    @FXML private TableColumn<obra, String> tbDescricao;
    @FXML private TableColumn<obra, String> tbDataFim;
    @FXML private TableColumn<obra, String> tbDataInicio;
    @FXML private TableColumn<obra, String> tbValor;
    @FXML private TableColumn<obra, Long> tbIdObra;
    
    public void cadObraButtonAction(ActionEvent event) {
        cadObra p = new cadObra();

        try {
            p.start(new Stage());

        } catch (Exception ex) {
            Logger.getLogger(initialController.class.getName()).log(Level.SEVERE, null, ex);
        }
        initTableObra();
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
        initTableFuncionario();
    }
    
    public void deleteFuncionarioButtonAction(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmação");
        alert.setHeaderText("Certeza que gostaria de excluir o Funcionario NOMEFUNCIONARIO");
        alert.showAndWait();
        
        initTableFuncionario();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initTableFuncionario();
        initTableObra();
    }

    public void fecha() {
        initial.getStage().close();
    }
    
    public void initTableFuncionario(){
        tbID.setCellValueFactory(new PropertyValueFactory("id"));
        tbNome.setCellValueFactory(new PropertyValueFactory("nome"));
        tbTelefone.setCellValueFactory(new PropertyValueFactory("telefone"));
        tbCargo.setCellValueFactory(new PropertyValueFactory("cargo"));
        tbSalario.setCellValueFactory(new PropertyValueFactory("salario"));
        tbData.setCellValueFactory(new PropertyValueFactory("data"));   
        tabela.setItems(atualizaTabelaFuncionario());
    
    }
    
    public ObservableList<funcionario> atualizaTabelaFuncionario(){
        FuncionarioDao dao = new FuncionarioDao(); 
        return FXCollections.observableArrayList(dao.getList());
        
    }
    
    public void initTableObra(){
        tbIdObra.setCellValueFactory(new PropertyValueFactory("id"));
        tbNomeCliente.setCellValueFactory(new PropertyValueFactory("nomeCliente"));
        tbTelefoneCliente.setCellValueFactory(new PropertyValueFactory("telefoneCliente"));
        tbEmailCliente.setCellValueFactory(new PropertyValueFactory("emailCliente"));
        tbTipoObra.setCellValueFactory(new PropertyValueFactory("tipo"));
        tbValor.setCellValueFactory(new PropertyValueFactory("valor"));
        tbDescricao.setCellValueFactory(new PropertyValueFactory("descObra"));
        tbDataFim.setCellValueFactory(new PropertyValueFactory("dataFim")); 
        tbDataInicio.setCellValueFactory(new PropertyValueFactory("dataInicio")); 
        tabelaObras.setItems(atualizaTabelaObra());    
        
    }
    
    public ObservableList<obra> atualizaTabelaObra(){
        ObraDao dao = new ObraDao(); 
        return FXCollections.observableArrayList(dao.getList());        
    }
}
