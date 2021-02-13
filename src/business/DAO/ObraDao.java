package business.DAO;

import business.JDBC.ConnectionBd;
import business.shared.obra;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ObraDao {
    private Connection con;

    public ObraDao() {
        this.con = new ConnectionBd().getConnection();
    }

    public List<obra> getList() {
        List<obra> obras = new ArrayList<>();
        String sql = "SELECT * FROM obra";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                obra p = new obra();
                p.setId(rs.getLong("id"));
                p.setNomeFuncionario(rs.getString("funcionario"));
                p.setDataInicio(rs.getString("inicioobra"));
                p.setDataFim(rs.getString("fimobra"));
                p.setValor(rs.getString("valorobra"));
                p.setTipo(rs.getString("tipoobra"));
                p.setDescObra(rs.getString("descobra"));
                p.setNomeCliente(rs.getString("nomecliente"));
                p.setRuaCliente(rs.getString("ruacliente"));
                p.setNumCasaCliente(rs.getString("ncasacliente"));
                p.setBairroCliente(rs.getString("bairrocliente"));
                p.setEmailCliente(rs.getString("emailcliente"));
                p.setTelefoneCliente(rs.getString("telefonecliente"));
                obras.add(p);
            }
            stmt.close();
            rs.close();
            con.close();
            
        } catch (SQLException ex) {
            System.out.println("Lista não retornada");
            return null; 
        }
        return obras;
    }

    public boolean add(obra p) {

        String sql = "INSERT INTO obra(funcionario, inicioobra, fimobra, valorobra, tipoobra, descobra,"
                + " nomecliente, ruacliente, ncasacliente, bairrocliente, emailcliente, telefonecliente) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, p.getNomeFuncionario());
            stmt.setString(2, p.getDataInicio());
            stmt.setString(3, p.getDataFim());
            stmt.setString(4, p.getValor());
            stmt.setString(5, p.getTipo());
            stmt.setString(6, p.getDescObra());
            stmt.setString(7, p.getNomeCliente());
            stmt.setString(8, p.getRuaCliente());
            stmt.setString(9, p.getNumCasaCliente());
            stmt.setString(10, p.getBairroCliente());
            stmt.setString(11, p.getEmailCliente());
            stmt.setString(12, p.getTelefoneCliente());
            stmt.executeUpdate();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
