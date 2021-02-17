package business.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Conexão ao Banco de dados
public class ConnectionBd {

    public Connection getConnection() {
        String nomeUsuario = "postgres"; //Usuário do servidor padrão
        String senhaUsuario = "hZjbg}e]Xniyup"; // Senha do servidor
        String enderecoServidor = "localhost:5433";
        String nomeBanco = "business";

        try {
            System.out.println("Tentando conexão com o banco Gaspor");
            return DriverManager.getConnection("jdbc:postgresql://" + enderecoServidor
                    + "/" + nomeBanco, nomeUsuario, Decode.decode(senhaUsuario));

        } catch (SQLException ex) {
            System.out.println("Sem conexão com o banco Gaspor");
            
            
            try {
                senhaUsuario = "4*+/;B61,.9B";
                System.out.println("Tentando conexão com o banco Friday");
                return DriverManager.getConnection("jdbc:postgresql://" + enderecoServidor
                        + "/" + nomeBanco, nomeUsuario, Decode.decode(senhaUsuario));

            } catch (SQLException e) {
                System.out.println("Erro, sem conexão com o banco de dados");
                throw new RuntimeException(e);
            }
        }
    }

}
