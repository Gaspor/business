package business.Control;

import business.DAO.FuncionarioDao;
import business.cadFuncionario;
import business.shared.Utilities;
import business.shared.funcionario;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

public class CadFuncionarioController implements Initializable {
    @FXML
    public TextField tfNomeFuncionario;
    @FXML
    private TextField tfCargoFuncionario;
    @FXML
    private TextField tfSalarioFuncionario;
    @FXML
    private TextField tfTelefoneFuncionario;
    @FXML
    private DatePicker dpDataPagamento;
    @FXML
    private Button btnCadastrarFuncionario;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public void cancelCadFuncionarioButtonAction(ActionEvent event) {
        fecha();
    }

    public void CadFuncionarioButtonAction(ActionEvent event) {
        if (tfNomeFuncionario.getText().isEmpty()
                || tfCargoFuncionario.getText().isEmpty()
                || tfSalarioFuncionario.getText().isEmpty()
                || tfTelefoneFuncionario.getText().isEmpty()
                || dpDataPagamento.getValue() == null) {

            Error("Preencha todos os campos com *");

        } else {
            funcionario p = new funcionario();
            p.setNome(tfNomeFuncionario.getText());
            p.setTelefone(tfTelefoneFuncionario.getText());
            p.setCargo(tfCargoFuncionario.getText());
            p.setSalario(tfSalarioFuncionario.getText());
            p.setData(formatter.format(dpDataPagamento.getValue()));

            FuncionarioDao dao = new FuncionarioDao();

            if (dao.add(p)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Funcionário cadastrado");
                alert.setHeaderText("Novo Funcionário cadastrado!");
                alert.showAndWait();

            } else {
                Error("Não foi possivel cadastrar o funcionário!");

            }
            fecha();
        }
    }

    public void fecha() {
        cadFuncionario.getStage().close();
    }

    public boolean enableButton() {
        if (tfNomeFuncionario.getText().length() >= 4
                && tfCargoFuncionario.getText().length() >= 4
                && tfSalarioFuncionario.getText().length() >= 3
                && tfTelefoneFuncionario.getText().length() == 15
                && dpDataPagamento.getValue() != null) {
            return true;
        }
        return false;
    }

    public void Error(String strError) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro");
        alert.setHeaderText("Funcionário Não cadastrado!");
        alert.setContentText(strError);
        alert.showAndWait();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnCadastrarFuncionario.setDisable(true);
        
        tfTelefoneFuncionario.textProperty().addListener((observable, oldValue, newValue) -> {
            if (enableButton()) {
                btnCadastrarFuncionario.setDisable(false);

            } else {
                btnCadastrarFuncionario.setDisable(true);

            }

            if (newValue.matches("\\d" + "-" + "(" + ")" + "*")) {
                return;

            }
            tfTelefoneFuncionario.setText(newValue.replaceAll("[^\\d]", ""));

            Utilities t = new Utilities();
            t.formatterPhoneNumber(tfTelefoneFuncionario);
        });

        tfSalarioFuncionario.textProperty().addListener((observable, oldValue, newValue) -> {
            if (enableButton()) {
                btnCadastrarFuncionario.setDisable(false);

            } else {
                btnCadastrarFuncionario.setDisable(true);

            }

            if (newValue.matches("\\d" + "," + "." + "R$ " + "*")) {
                return;

            }
            tfSalarioFuncionario.setText(newValue.replaceAll("[^\\d]", ""));

            Utilities v = new Utilities();
            v.formatterCurrenry(tfSalarioFuncionario);
        });

        tfNomeFuncionario.textProperty().addListener((observable, oldValue, newValue) -> {
            if (enableButton()) {
                btnCadastrarFuncionario.setDisable(false);

            } else {
                btnCadastrarFuncionario.setDisable(true);

            }

            tfNomeFuncionario.setText(newValue.replaceAll("\\d*", ""));
        });

        tfCargoFuncionario.textProperty().addListener((observable, oldValue, newValue) -> {
            if (enableButton()) {
                btnCadastrarFuncionario.setDisable(false);

            } else {
                btnCadastrarFuncionario.setDisable(true);

            }
        });

        dpDataPagamento.valueProperty().addListener((ov, oldValue, newValue) -> {
            if (enableButton()) {
                btnCadastrarFuncionario.setDisable(false);

            } else {
                btnCadastrarFuncionario.setDisable(true);

            }
        });
    }
}
