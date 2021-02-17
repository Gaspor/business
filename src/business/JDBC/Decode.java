package business.JDBC;

public class Decode {
    public static String decode(String frase) {
        String strRetorno = "";

        for (int i = 0; i < frase.length(); i++) {
            strRetorno += String.valueOf(Character.toChars(frase.charAt(i) - (int) (Math.sin(i + 3) * 10)));
            
        }

        return strRetorno;
    }
}
