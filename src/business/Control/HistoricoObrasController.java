package business.Control;

import business.DAO.HistoricoDao;
import business.shared.Utilities;
import business.shared.historico;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class HistoricoObrasController implements Initializable {

    @FXML
    private TableColumn<historico, String> tbValor;

    @FXML
    private TableView<historico> tvTabela;

    @FXML
    private TableColumn<historico, String> tbCliente;

    @FXML
    private TableColumn<historico, String> tbDesc;

    @FXML
    private TableColumn<historico, String> tbTipo;

    @FXML
    private TableColumn<historico, String> tbFim;

    @FXML
    private TableColumn<historico, String> tbStatus;

    @FXML
    private TableColumn<historico, Long> tbId;

    @FXML
    private TableColumn<historico, String> tbInicio;

    public void deleteHistoricoButtonAction(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmação");
        alert.setHeaderText("Tem certesa que deseja apagar todo o histórico ?");
        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == ButtonType.OK) {
            HistoricoDao dao = new HistoricoDao();
            dao.delete();
        }
        initTable();

    }

    @Override

    public void initialize(URL url, ResourceBundle rb) {
        initTable();
    }

    public void initTable() {
        Utilities u = new Utilities();
        tbId.setCellValueFactory(new PropertyValueFactory("id"));
        tbCliente.setCellValueFactory(new PropertyValueFactory("nomeCliente"));
        tbTipo.setCellValueFactory(new PropertyValueFactory("tipo"));
        tbValor.setCellValueFactory(new PropertyValueFactory("valor"));
        tbDesc.setCellValueFactory(new PropertyValueFactory("descObra"));
        tbFim.setCellValueFactory(new PropertyValueFactory("dataFim"));
        tbInicio.setCellValueFactory(new PropertyValueFactory("dataInicio"));
        tbStatus.setCellValueFactory(new PropertyValueFactory("status"));
        u.setColor(tbStatus);
        tvTabela.setItems(atualizaTabela());

    }

    public ObservableList<historico> atualizaTabela() {
        HistoricoDao dao = new HistoricoDao();
        return FXCollections.observableArrayList(dao.getList());

    }
}
