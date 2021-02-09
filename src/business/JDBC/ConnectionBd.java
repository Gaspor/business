/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author victor
 */
//Conexão ao Banco de dados
public class ConnectionBd {

    public Connection getConnection() {
        String nomeUsuario = "postgres"; //Usuário do servidor padrão
        String senhaUsuario = "314159265359"; // Senha do servidor
        String enderecoServidor = "localhost";
        String nomeBanco = "business";

        try {

            return DriverManager.getConnection("jdbc:postgresql://"+enderecoServidor+
                    "/"+nomeBanco, nomeUsuario, senhaUsuario);

        } catch (SQLException ex) {
            System.out.println("ERRO, SEM CONEXÃO");
            throw new RuntimeException(ex);
        }
    }

}
