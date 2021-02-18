package business.Control;

import business.DAO.FuncionarioDao;
import business.editarFuncionario;
import business.shared.Utilities;
import business.shared.funcionario;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class EditarFuncionarioController implements Initializable {
    @FXML
    private TextField tfCargoFuncionario;
    @FXML
    private Button btnEditarFuncionario;
    @FXML
    private TextField tfSalarioFuncionario;
    @FXML
    private DatePicker dpDataPagamento;
    @FXML
    private TextField tfTelefoneFuncionario;
    @FXML
    private TextField tfNomeFuncionario;
    private static funcionario funcionario2;
    
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public static funcionario getFuncionario2() {
        return funcionario2;
        
    }

    public static void setFuncionario2(funcionario funcionario2) {
        EditarFuncionarioController.funcionario2 = funcionario2;
        
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnEditarFuncionario.setDisable(true);
        mostraDetalhes();
        tfTelefoneFuncionario.textProperty().addListener((observable, oldValue, newValue) -> {
            if (enableButton()) {
                btnEditarFuncionario.setDisable(false);

            } else {
                btnEditarFuncionario.setDisable(true);

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
                btnEditarFuncionario.setDisable(false);

            } else {
                btnEditarFuncionario.setDisable(true);

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
                btnEditarFuncionario.setDisable(false);

            } else {
                btnEditarFuncionario.setDisable(true);

            }

            tfNomeFuncionario.setText(newValue.replaceAll("\\d*", ""));
        });

        tfCargoFuncionario.textProperty().addListener((observable, oldValue, newValue) -> {
            if (enableButton()) {
                btnEditarFuncionario.setDisable(false);

            } else {
                btnEditarFuncionario.setDisable(true);

            }
        });

        dpDataPagamento.valueProperty().addListener((ov, oldValue, newValue) -> {
            if (enableButton()) {
                btnEditarFuncionario.setDisable(false);

            } else {
                btnEditarFuncionario.setDisable(true);

            }
        });
    }

    public void fecha() {
        editarFuncionario.getStage().close();
        
    }

    public void cancelEditFuncionarioButtonAction(ActionEvent event) {
        fecha();
        
    }

    public void editFuncionarioButtonAction(ActionEvent event) {
        Atualiza();
        fecha();
        
    }

    public void Atualiza() {
        Long id = funcionario2.getId();
        String nome = tfNomeFuncionario.getText();
        String telefone = tfTelefoneFuncionario.getText();
        String cargo = tfCargoFuncionario.getText();
        String salario = tfSalarioFuncionario.getText();
        String data = formatter.format(dpDataPagamento.getValue());
        
        FuncionarioDao dao = new FuncionarioDao();
        funcionario emp = new funcionario(nome, telefone, data, cargo, salario, id);

        if (dao.update(emp)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Funcionário atualizado");
            alert.setHeaderText("Funcionário atualizado com sucesso!");
            alert.showAndWait();

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Funcionário Não atualizado!");
            alert.setContentText("Funcionario não atualizado");
            alert.showAndWait();
            
        }
    }

    public void mostraDetalhes() {
        Utilities u = new Utilities();
        
        tfNomeFuncionario.setText(funcionario2.getNome());
        tfTelefoneFuncionario.setText(funcionario2.getTelefone());
        tfCargoFuncionario.setText(funcionario2.getCargo());
        tfSalarioFuncionario.setText(funcionario2.getSalario());
        dpDataPagamento.setValue(LocalDate.parse(funcionario2.getData(), formatter));
        
        u.formatterCurrenry(tfSalarioFuncionario);
        u.formatterPhoneNumber(tfTelefoneFuncionario);
    }
}
