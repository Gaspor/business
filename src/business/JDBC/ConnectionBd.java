package business.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Conexão ao Banco de dados
public class ConnectionBd {
    public Connection getConnection() {
        try {
            env env = new env();
            System.out.println("Tentando conexão com o banco de dados");
            return DriverManager.getConnection("jdbc:postgresql://" + env.enderecoServidor + ":" + env.port
                    + "/" + env.nomeBanco, env.nomeUsuario, env.senhaUsuario);

        } catch (SQLException e) {
            System.out.println("Erro, sem conexão com o banco de dados");
            throw new RuntimeException(e);
        }
    }

}
