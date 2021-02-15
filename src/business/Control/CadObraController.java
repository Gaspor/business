package business.Control;

import business.cadObra;
import business.DAO.ObraDao;
import business.shared.obra;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

public class CadObraController implements Initializable {

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
    private Button btnCadObra;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    DateTimeFormatter formatterDay = DateTimeFormatter.ofPattern("dd");
    DateTimeFormatter formatterMonth = DateTimeFormatter.ofPattern("MM");
    DateTimeFormatter formatterYear = DateTimeFormatter.ofPattern("yyyy");

    public void cancelCadObra(ActionEvent event) {
        fecha();
    }

    public void cadastrarObra(ActionEvent event) {
        if (tfCadObraNomeFuncionario.getText().isEmpty()
                || tfValorObra.getText().isEmpty()
                || tfTipoObra.getText().isEmpty()
                || tfNomeCliente.getText().isEmpty()
                || tfRuaCliente.getText().isEmpty()
                || tfNumeroCasaCliente.getText().isEmpty()
                || tfBairroCliente.getText().isEmpty()
                || tfTelefoneCliente.getText().isEmpty()
                || dpEntregaObra.getValue() == null
                || dpInicioObra.getValue() == null) {

            Error("Preencha todos os campos com *");

        } else {
            int diaInicio = Integer.parseInt(formatterDay.format(dpInicioObra.getValue())),
                    mesInicio = Integer.parseInt(formatterMonth.format(dpInicioObra.getValue())),
                    anoInicio = Integer.parseInt(formatterYear.format(dpInicioObra.getValue())),
                    diaFim = Integer.parseInt(formatterDay.format(dpEntregaObra.getValue())),
                    mesFim = Integer.parseInt(formatterMonth.format(dpEntregaObra.getValue())),
                    anoFim = Integer.parseInt(formatterYear.format(dpEntregaObra.getValue()));

            System.out.println("Dia Inicio:" + diaInicio + "\nDia Fim:" + diaFim
                    + "\nMes Inicio:" + mesInicio + "\nMes Fim: " + mesFim
                    + "\nAno Inicio: " + anoInicio + "\nAno Fim: " + anoFim);

            if (anoFim >= anoInicio) {
                if (mesFim < mesInicio && anoFim > anoInicio || mesFim >= mesInicio) {
                    if (diaFim > diaInicio && mesFim >= mesInicio ||
                        diaFim <= diaInicio && mesFim <= mesInicio && anoFim > anoInicio ||
                        diaFim <= diaInicio && mesFim > mesInicio) {
                        
                        obra p = new obra();
                        p.setNomeFuncionario(tfCadObraNomeFuncionario.getText());
                        p.setDataInicio(formatter.format(dpInicioObra.getValue()));
                        p.setDataFim(formatter.format(dpEntregaObra.getValue()));
                        p.setValor(tfValorObra.getText());
                        p.setTipo(tfTipoObra.getText());
                        p.setDescObra(tfDescricaoObra.getText());
                        p.setNomeCliente(tfNomeCliente.getText());
                        p.setRuaCliente(tfRuaCliente.getText());
                        p.setNumCasaCliente(tfNumeroCasaCliente.getText());
                        p.setBairroCliente(tfBairroCliente.getText());
                        p.setEmailCliente(tfEmailCliente.getText());
                        p.setTelefoneCliente(tfTelefoneCliente.getText());

                        ObraDao dao = new ObraDao();

                        if (dao.add(p)) {
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Obra cadastrada");
                            alert.setHeaderText("Nova Obra Cadastrada!");
                            alert.showAndWait();

                        } else {
                            Error("Não foi possivel cadastrar a obra!");

                        }
                        fecha();

                    } else {
                        Error("O dia de fim da obra é menor que o dia de inicio!");
                    }
                } else {
                    Error("O mês de fim da obra é menor que o mês de inicio!");
                }

            } else {
                Error("O ano de fim da obra é menor que o ano de inicio!");
            }

        }
    }

    public void fecha() {
        cadObra.getStage().close();
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

            if (tfEmailCliente.getText().length() >= 10 && tfTelefoneCliente.getText().length() >= 15 ||
                tfEmailCliente.getText().length() == 0 && tfTelefoneCliente.getText().length() >= 15 ||
                tfEmailCliente.getText().length() >= 10 && tfTelefoneCliente.getText().length() == 0) {
                return true;

            }
        }
        return false;
    }

    public void Error(String strError) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro");
        alert.setHeaderText("Obra não Cadastrada!");
        alert.setContentText(strError);
        alert.showAndWait();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnCadObra.setDisable(true);

        tfCadObraNomeFuncionario.textProperty().addListener((observable, oldValue, newValue) -> {
            if (enableButton()) {
                btnCadObra.setDisable(false);

            } else {
                btnCadObra.setDisable(true);

            }
            
            tfCadObraNomeFuncionario.setText(newValue.replaceAll("\\d*", ""));
        });

        dpInicioObra.valueProperty().addListener((ov, oldValue, newValue) -> {
            if (enableButton()) {
                btnCadObra.setDisable(false);

            } else {
                btnCadObra.setDisable(true);

            }
        });

        dpEntregaObra.valueProperty().addListener((ov, oldValue, newValue) -> {
            if (enableButton()) {
                btnCadObra.setDisable(false);

            } else {
                btnCadObra.setDisable(true);

            }
        });

        tfValorObra.textProperty().addListener((observable, oldValue, newValue) -> {
            if (enableButton()) {
                btnCadObra.setDisable(false);

            } else {
                btnCadObra.setDisable(true);

            }

            final char commaChar = ',';
            final char dotChar = '.';
            final Pattern s = Pattern.compile("[0-9" + commaChar + dotChar + "R$ ]*");

            if (newValue.matches("\\d" + commaChar + dotChar + "R$ " + "*")) {
                return;

            }
            tfValorObra.setText(newValue.replaceAll("[^\\d]", ""));

            tfValorObra.setTextFormatter(new TextFormatter<>(sa -> {
                if (!sa.isContentChange()) {
                    return sa;
                }

                String newText = sa.getControlNewText();

                if (newText.isEmpty()) {
                    return sa;
                }
                if (!s.matcher(newText).matches()) {
                    return null;
                }

                int digits = 0;
                StringBuilder sb = new StringBuilder();

                for (int i = sa.getRangeStart() + sa.getText().length() - 1; i >= 0; i--) {
                    char letter = newText.charAt(i);

                    if (Character.isDigit(letter)) {
                        sb.append(letter);
                        digits++;

                        if (digits == 2) {
                            sb.append(commaChar);

                        }
                        if (digits == 5 || (digits - 2) % 3 == 0 && digits > 5) {
                            sb.append(dotChar);

                        }
                    }
                }

                if (digits == 2 || digits == 5 || (digits - 2) % 3 == 0) {
                    sb.deleteCharAt(sb.length() - 1);

                }
                if (digits > 2) {
                    sb.append(" ");
                    sb.append("$");
                    sb.append("R");

                }

                sb.reverse();
                int length = sb.length();

                sa.setRange(0, sa.getRangeEnd());
                sa.setText(sb.toString());
                sa.setCaretPosition(length);
                sa.setAnchor(length);

                return sa;
            }));
        });

        tfTipoObra.textProperty().addListener((observable, oldValue, newValue) -> {
            if (enableButton()) {
                btnCadObra.setDisable(false);

            } else {
                btnCadObra.setDisable(true);

            }
        });

        tfDescricaoObra.textProperty().addListener((observable, oldValue, newValue) -> {
            if (enableButton()) {
                btnCadObra.setDisable(false);

            } else {
                btnCadObra.setDisable(true);

            }
        });

        tfNomeCliente.textProperty().addListener((observable, oldValue, newValue) -> {
            if (enableButton()) {
                btnCadObra.setDisable(false);

            } else {
                btnCadObra.setDisable(true);

            }
            
            tfNomeCliente.setText(newValue.replaceAll("\\d*", ""));
        });

        tfRuaCliente.textProperty().addListener((observable, oldValue, newValue) -> {
            if (enableButton()) {
                btnCadObra.setDisable(false);

            } else {
                btnCadObra.setDisable(true);

            }
        });

        tfNumeroCasaCliente.textProperty().addListener((observable, oldValue, newValue) -> {
            if (enableButton()) {
                btnCadObra.setDisable(false);

            } else {
                btnCadObra.setDisable(true);

            }
            if (newValue.matches("\\d*")) {
                return;
            }
            tfNumeroCasaCliente.setText(newValue.replaceAll("[^\\d]", ""));
            
        });

        tfBairroCliente.textProperty().addListener((observable, oldValue, newValue) -> {
            if (enableButton()) {
                btnCadObra.setDisable(false);

            } else {
                btnCadObra.setDisable(true);

            }
        });

        tfEmailCliente.textProperty().addListener((observable, oldValue, newValue) -> {
            if (enableButton()) {
                btnCadObra.setDisable(false);

            } else {
                btnCadObra.setDisable(true);

            }
        });

        tfTelefoneCliente.textProperty().addListener((observable, oldValue, newValue) -> {
            if (enableButton()) {
                btnCadObra.setDisable(false);

            } else {
                btnCadObra.setDisable(true);

            }

            final char seperatorChar = '-';
            final char parenteseEsquerdaChar = '(';
            final char parenteseDireitaChar = ')';
            final Pattern p = Pattern.compile("[0-9" + seperatorChar + parenteseEsquerdaChar + parenteseDireitaChar + " ]*");

            if (newValue.matches("\\d" + seperatorChar + parenteseEsquerdaChar + parenteseDireitaChar + "*")) {
                return;

            }
            tfTelefoneCliente.setText(newValue.replaceAll("[^\\d]", ""));

            tfTelefoneCliente.setTextFormatter(new TextFormatter<>(c -> {
                if (!c.isContentChange()) {
                    return c;

                }

                String newText = c.getControlNewText();

                if (newText.isEmpty()) {
                    return c;

                }
                if (!p.matcher(newText).matches()) {
                    return null;

                }

                int digits = 0;
                StringBuilder sb = new StringBuilder();

                for (int i = c.getRangeStart() + c.getText().length() - 1; i >= 0; i--) {
                    char letter = newText.charAt(i);

                    if (Character.isDigit(letter)) {
                        sb.append(letter);
                        digits++;

                        if (digits == 4) {
                            sb.append(seperatorChar);

                        }
                        if (digits == 9) {
                            sb.append(" ");
                            digits++;

                        }
                        if (digits == 10) {
                            sb.append(parenteseDireitaChar);

                        }
                        if (digits >= 13) {
                            return null;

                        }
                    }
                }

                if (digits == 4 || digits == 10 || digits == 13) {
                    sb.deleteCharAt(sb.length() - 1);

                    if (digits == 10) {
                        sb.deleteCharAt(sb.length() - 1);

                    }
                }

                if (digits == 12) {
                    sb.append(parenteseEsquerdaChar);

                }

                sb.reverse();
                int length = sb.length();

                c.setRange(0, c.getRangeEnd());
                c.setText(sb.toString());
                c.setCaretPosition(length);
                c.setAnchor(length);

                return c;
            }));
        });

    }
}
