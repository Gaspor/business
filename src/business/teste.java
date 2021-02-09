/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import business.JDBC.ConnectionBd;
import static javafx.application.Application.launch;

/**
 *
 * @author victo
 */
public class teste {
     public static void main(String[] args) {
         new ConnectionBd().getConnection();
        launch(args);
    }
    
}
