package business.Control;

import business.DAO.FuncionarioDao;
import business.cadFuncionario;
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
import java.util.regex.Pattern;
import javafx.scene.control.TextFormatter;

public class CadFuncionarioController implements Initializable {

    @FXML
    public TextField tfNomeFuncinario;
    @FXML
    private TextField tfCargoFuncionario;
    @FXML
    private TextField tfSalarioFuncionario;
    @FXML
    private TextField tfTelefoneFuncinario;
    @FXML
    private DatePicker dpDataPagamento;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public void cancelCadFuncionarioButtonAction(ActionEvent event) {
        fecha();
    }

    public void CadFuncionarioButtonAction(ActionEvent event) {
        if (tfNomeFuncinario.getText().isEmpty()
                || tfCargoFuncionario.getText().isEmpty()
                || tfSalarioFuncionario.getText().isEmpty()
                || tfTelefoneFuncinario.getText().isEmpty()
                || dpDataPagamento.getValue() == null) {

            Error("Preencha todos os campos com *");

        } else {
            funcionario p = new funcionario();
            p.setNome(tfNomeFuncinario.getText());
            p.setTelefone(tfTelefoneFuncinario.getText());
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

    public void Error(String strError) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro");
        alert.setHeaderText("Funcionário Não cadastrado!");
        alert.setContentText(strError);
        alert.showAndWait();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        final char seperatorChar = '-';
        final char parenteseEsquerdaChar = '(';
        final char parenteseDireitaChar = ')';
        final Pattern p = Pattern.compile("[0-9" + seperatorChar + parenteseEsquerdaChar + parenteseDireitaChar + "]*");
        tfTelefoneFuncinario.setTextFormatter(new TextFormatter<>(c -> {
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
                        sb.append(parenteseDireitaChar);

                    }
                    if (digits == 12) {
                        return null;
                    }
                }
            }

            if (digits == 4 || digits == 9 || digits == 13) {
                sb.deleteCharAt(sb.length() - 1);
            }
            if (digits == 11) {
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
        
        final char commaChar = ',';
        final char dotChar = '.';
        final Pattern s = Pattern.compile("[0-9" + commaChar + dotChar + "]*");
        tfSalarioFuncionario.setTextFormatter(new TextFormatter<>(sa -> {
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
                    if (digits == 5 || (digits-2) % 3 == 0 && digits > 5) {
                        sb.append(dotChar);

                    }
                    System.out.println(digits);
                }
            }

            if (digits == 2 || digits == 5 || (digits-2) % 3 == 0) {
                sb.deleteCharAt(sb.length() - 1);
            }

            sb.reverse();

            int length = sb.length();

            sa.setRange(0, sa.getRangeEnd());
            sa.setText(sb.toString());
            sa.setCaretPosition(length);
            sa.setAnchor(length);

            return sa;
        }));

    }

}
