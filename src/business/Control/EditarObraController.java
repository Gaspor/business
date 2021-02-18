package business.Control;

import business.DAO.ObraDao;
import business.editarObra;
import business.shared.Utilities;
import business.shared.obra;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
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
    @FXML
    private Button btnConfirmEdit;
    private static obra obra2;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    DateTimeFormatter formatterDay = DateTimeFormatter.ofPattern("dd");
    DateTimeFormatter formatterMonth = DateTimeFormatter.ofPattern("MM");
    DateTimeFormatter formatterYear = DateTimeFormatter.ofPattern("yyyy");

    public static obra getObra2() {
        return obra2;
        
    }

    public static void setObra2(obra obra2) {
        EditarObraController.obra2 = obra2;
        
    }

    public boolean enableButton() {
        if (tfCadObraNomeFuncionario.getText().length() >= 3
                && tfValorObra.getText().length() >= 3
                && tfTipoObra.getText().length() >= 3
                && tfNomeCliente.getText().length() >= 3
                && tfRuaCliente.getText().length() >= 3
                && tfNumeroCasaCliente.getText().length() >= 1
                && tfBairroCliente.getText().length() >= 3
                && dpEntregaObra.getValue() != null
                && dpInicioObra.getValue() != null) {

            if (tfEmailCliente.getText().length() >= 10 && tfTelefoneCliente.getText().length() == 15
                    || tfEmailCliente.getText().length() == 0 && tfTelefoneCliente.getText().length() == 15
                    || tfEmailCliente.getText().length() >= 10 && tfTelefoneCliente.getText().length() == 0) {
                return true;

            }
        }
        
        return false;
    }

    public void mostraDetalhes() {
        Utilities u = new Utilities();

        tfCadObraNomeFuncionario.setText(obra2.getNomeFuncionario());
        tfValorObra.setText(obra2.getValor());
        tfTipoObra.setText(obra2.getTipo());
        tfDescricaoObra.setText(obra2.getDescObra());
        tfNomeCliente.setText(obra2.getNomeCliente());
        tfRuaCliente.setText(obra2.getRuaCliente());
        tfNumeroCasaCliente.setText(obra2.getNumCasaCliente());
        tfBairroCliente.setText(obra2.getBairroCliente());
        tfEmailCliente.setText(obra2.getEmailCliente());
        tfTelefoneCliente.setText(obra2.getTelefoneCliente());
        dpInicioObra.setValue(LocalDate.parse(obra2.getDataInicio(), formatter));
        dpEntregaObra.setValue(LocalDate.parse(obra2.getDataFim(), formatter));

        u.formatterCurrenry(tfValorObra);
        u.formatterPhoneNumber(tfTelefoneCliente);
    }

    public void Atualiza() {
        int diaInicio = Integer.parseInt(formatterDay.format(dpInicioObra.getValue())),
                mesInicio = Integer.parseInt(formatterMonth.format(dpInicioObra.getValue())),
                anoInicio = Integer.parseInt(formatterYear.format(dpInicioObra.getValue())),
                diaFim = Integer.parseInt(formatterDay.format(dpEntregaObra.getValue())),
                mesFim = Integer.parseInt(formatterMonth.format(dpEntregaObra.getValue())),
                anoFim = Integer.parseInt(formatterYear.format(dpEntregaObra.getValue()));

        if (anoFim >= anoInicio) {
            if (mesFim < mesInicio && anoFim > anoInicio || mesFim >= mesInicio) {
                if (diaFim > diaInicio && mesFim >= mesInicio
                        || diaFim <= diaInicio && mesFim <= mesInicio && anoFim > anoInicio
                        || diaFim <= diaInicio && mesFim > mesInicio) {
                    
                    Long id = obra2.getId();
                    String nomeFuncionario = tfCadObraNomeFuncionario.getText();
                    String valorObra = tfValorObra.getText();
                    String tipoObra = tfTipoObra.getText();
                    String descObra = tfDescricaoObra.getText();
                    String nomeCliente = tfNomeCliente.getText();
                    String ruaCliente = tfRuaCliente.getText();
                    String numCasaCliente = tfNumeroCasaCliente.getText();
                    String bairroCliente = tfBairroCliente.getText();
                    String emailCliente = tfEmailCliente.getText();
                    String telefoneCliente = tfTelefoneCliente.getText();
                    String dataInicio = formatter.format(dpInicioObra.getValue());
                    String dataFim = formatter.format(dpEntregaObra.getValue());
                    String status = obra2.getStatus();
                    ObraDao dao = new ObraDao();
                    obra emp = new obra(nomeFuncionario, dataInicio, dataFim, valorObra, tipoObra, descObra, nomeCliente, ruaCliente, numCasaCliente, bairroCliente, emailCliente, telefoneCliente, status, id);

                    if (dao.update(emp)) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Obra atualizada");
                        alert.setHeaderText("Obra atualizada com sucesso!");
                        alert.showAndWait();

                    } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Erro");
                        alert.setHeaderText("Não foi possível atualizar obra!");
                        alert.setContentText("Obra não atualizada");
                        alert.showAndWait();
                        
                    }
                    
                    fecha();
                    
                }else {
                        Error("O dia de fim da obra é menor que o dia de inicio!");
                    }
            }else {
                    Error("O mês de fim da obra é menor que o mês de inicio!");
                }
        }else {
                Error("O ano de fim da obra é menor que o ano de inicio!");
        }
    }

    

    public void cancelEditObraButtonAction(ActionEvent event) {
        fecha();
        
    }

    public void editObraButtonAction(ActionEvent event) {
        Atualiza();
        
    }

    public void fecha() {
        editarObra.getStage().close();
        
    }
    
    public void Error(String strError) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro");
        alert.setHeaderText("Obra não atualizada!");
        alert.setContentText(strError);
        alert.showAndWait();
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnConfirmEdit.setDisable(true);
        mostraDetalhes();

        tfCadObraNomeFuncionario.textProperty().addListener((observable, oldValue, newValue) -> {
            if (enableButton()) {
                btnConfirmEdit.setDisable(false);

            } else {
                btnConfirmEdit.setDisable(true);

            }

            tfCadObraNomeFuncionario.setText(newValue.replaceAll("\\d*", ""));
        });

        dpInicioObra.valueProperty().addListener((ov, oldValue, newValue) -> {
            if (enableButton()) {
                btnConfirmEdit.setDisable(false);

            } else {
                btnConfirmEdit.setDisable(true);

            }
        });

        dpEntregaObra.valueProperty().addListener((ov, oldValue, newValue) -> {
            if (enableButton()) {
                btnConfirmEdit.setDisable(false);

            } else {
                btnConfirmEdit.setDisable(true);

            }
        });

        tfValorObra.textProperty().addListener((observable, oldValue, newValue) -> {
            if (enableButton()) {
                btnConfirmEdit.setDisable(false);

            } else {
                btnConfirmEdit.setDisable(true);

            }

            if (newValue.matches("\\d" + "," + "." + "R$ " + "*")) {
                return;

            }
            
            tfValorObra.setText(newValue.replaceAll("[^\\d]", ""));

            Utilities v = new Utilities();
            v.formatterCurrenry(tfValorObra);
        });

        tfTipoObra.textProperty().addListener((observable, oldValue, newValue) -> {
            if (enableButton()) {
                btnConfirmEdit.setDisable(false);

            } else {
                btnConfirmEdit.setDisable(true);

            }
        });

        tfDescricaoObra.textProperty().addListener((observable, oldValue, newValue) -> {
            if (enableButton()) {
                btnConfirmEdit.setDisable(false);

            } else {
                btnConfirmEdit.setDisable(true);

            }
        });

        tfNomeCliente.textProperty().addListener((observable, oldValue, newValue) -> {
            if (enableButton()) {
                btnConfirmEdit.setDisable(false);

            } else {
                btnConfirmEdit.setDisable(true);

            }

            tfNomeCliente.setText(newValue.replaceAll("\\d*", ""));
        });

        tfRuaCliente.textProperty().addListener((observable, oldValue, newValue) -> {
            if (enableButton()) {
                btnConfirmEdit.setDisable(false);

            } else {
                btnConfirmEdit.setDisable(true);

            }
        });

        tfNumeroCasaCliente.textProperty().addListener((observable, oldValue, newValue) -> {
            if (enableButton()) {
                btnConfirmEdit.setDisable(false);

            } else {
                btnConfirmEdit.setDisable(true);

            }

            if (newValue.matches("\\d*")) {
                return;
            }
            
            tfNumeroCasaCliente.setText(newValue.replaceAll("[^\\d]", ""));
        });

        tfBairroCliente.textProperty().addListener((observable, oldValue, newValue) -> {
            if (enableButton()) {
                btnConfirmEdit.setDisable(false);

            } else {
                btnConfirmEdit.setDisable(true);

            }
        });

        tfEmailCliente.textProperty().addListener((observable, oldValue, newValue) -> {
            if (enableButton()) {
                btnConfirmEdit.setDisable(false);

            } else {
                btnConfirmEdit.setDisable(true);

            }
        });

        tfTelefoneCliente.textProperty().addListener((observable, oldValue, newValue) -> {
            if (enableButton()) {
                btnConfirmEdit.setDisable(false);

            } else {
                btnConfirmEdit.setDisable(true);

            }

            if (newValue.matches("\\d" + "-" + "(" + ")" + "*")) {
                return;

            }
            
            tfTelefoneCliente.setText(newValue.replaceAll("[^\\d]", ""));

            Utilities t = new Utilities();
            t.formatterPhoneNumber(tfTelefoneCliente);
        });
    }
}
