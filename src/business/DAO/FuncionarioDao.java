package business.DAO;

import business.JDBC.ConnectionBd;
import business.shared.funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FuncionarioDao {

    private Connection con;

    public FuncionarioDao() {
        this.con = new ConnectionBd().getConnection();
    }

    public List<funcionario> getList() {
        List<funcionario> funcionarios = new ArrayList<>();
        String sql = "SELECT * FROM funcionario";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                funcionario p = new funcionario();
                p.setId(rs.getLong("id"));
                p.setNome(rs.getString("nome"));
                p.setTelefone(rs.getString("telefone"));
                p.setCargo(rs.getString("cargo"));
                p.setSalario(rs.getString("salario"));
                p.setData(rs.getString("datap"));
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

    public boolean add(funcionario p) {

        String sql = "INSERT INTO funcionario(nome, telefone, cargo, salario, datap) VALUES (?,?,?,?,?);";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getTelefone());
            stmt.setString(3, p.getCargo());
            stmt.setString(4, p.getSalario());
            stmt.setString(5, p.getData());
            stmt.executeUpdate();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

}
