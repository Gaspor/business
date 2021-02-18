package business.DAO;

import business.JDBC.ConnectionBd;
import business.shared.historico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HistoricoDao {
    private Connection con;

    public HistoricoDao() {
        this.con = new ConnectionBd().getConnection();
        
    }

    public List<historico> getList() {
        List<historico> funcionarios = new ArrayList<>();
        String sql = "SELECT * FROM historico";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                historico p = new historico();
                funcionarios.add(p);
            }
            stmt.close();
            rs.close();
            con.close();

        } catch (SQLException ex) {
            System.out.println("Lista não retornada");
            return null;
            
        }
        
        return funcionarios;
    }

    public boolean add(historico p) {
        String sql = "INSERT INTO historico(nome) VALUES (?);";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);

            
            
            stmt.executeUpdate();
            stmt.close();       
            con.close();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
            
        }
    }
    

    public boolean delete(historico p) {
        String sql = "DELETE FROM historico WHERE id = ?;";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);

            
            
            
            stmt.executeUpdate();
            stmt.close();
            con.close();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
            
        }
    }
}
