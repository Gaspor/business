package business.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Conexão ao Banco de dados
public class ConnectionBd {

    public Connection getConnection() {
        String nomeUsuario = "postgres"; //Usuário do servidor padrão
        String senhaUsuario = "gasdatabasepor"; // Senha do servidor
        String enderecoServidor = "localhost:5433";
        String nomeBanco = "business";

        try {
            return DriverManager.getConnection("jdbc:postgresql://" + enderecoServidor + 
                    "/" + nomeBanco, nomeUsuario, senhaUsuario);
            
        } catch (SQLException ex) {
            System.out.println("Erro, sem conexão com o banco de dados");
            throw new RuntimeException(ex);
        }
    }

}
