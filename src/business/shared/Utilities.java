package business.shared;

import java.util.regex.Pattern;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

public class Utilities {
    public void formatterPhoneNumber(TextField nameTextField) {
        final char seperatorChar = '-';
        final char parenteseEsquerdaChar = '(';
        final char parenteseDireitaChar = ')';
        final Pattern p = Pattern.compile("[0-9" + seperatorChar + parenteseEsquerdaChar + parenteseDireitaChar + " ]*");

        nameTextField.setTextFormatter(new TextFormatter<>(c -> {
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

                    } if (digits == 9) {
                        sb.append(" ");
                        digits++;

                    } if (digits == 10) {
                        sb.append(parenteseDireitaChar);

                    } if (digits >= 13) {
                        return null;

                    }
                }
            }

            if (digits == 4 || digits == 10 || digits == 13) {
                sb.deleteCharAt(sb.length() - 1);

                if (digits == 10) {
                    sb.deleteCharAt(sb.length() - 1);

                }
            } if (digits == 12) {
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
    }

    public void formatterCurrenry(TextField Valor) {
        final char commaChar = ',';
        final char dotChar = '.';
        final Pattern s = Pattern.compile("[0-9" + commaChar + dotChar + "R$ ]*");

        Valor.setTextFormatter(new TextFormatter<>(sa -> {
            if (!sa.isContentChange()) {
                return sa;
                
            }

            String newText = sa.getControlNewText();

            if (newText.isEmpty()) {
                return sa;
                
            } if (!s.matcher(newText).matches()) {
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

                    } if (digits == 5 || (digits - 2) % 3 == 0 && digits > 5) {
                        sb.append(dotChar);

                    }
                }
            }

            if (digits == 2 || digits == 5 || (digits - 2) % 3 == 0) {
                sb.deleteCharAt(sb.length() - 1);

            } if (digits > 2) {
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
    }
}
