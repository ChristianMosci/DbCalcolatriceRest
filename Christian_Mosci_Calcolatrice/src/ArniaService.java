/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MOSCI.CHRISTIAN
 */
import java.sql.*;
import java.util.*;

public class ArniaService {

    public static List<Arnia> getAllArnie() throws Exception {
        List<Arnia> lista = new ArrayList<>();
        
        Connection conn = ConnessioneDb.getConnection();
        Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT * FROM arnia");

while (rs.next()) {
    Arnia a = new Arnia(
        rs.getInt("arn_id"),
        rs.getString("arn_dataInst"),
        rs.getBoolean("arn_piena"),
        rs.getString("arn_MacAddress"),
        rs.getInt("api_id")
    );
    lista.add(a);
        }

        conn.close();
        return lista;
    }

   public static void inserisciArnia(Arnia arnia) throws Exception {
    Connection conn = ConnessioneDb.getConnection();

    String sql = "INSERT INTO arnia (arn_dataInst, arn_piena, arn_MacAddress, api_id) VALUES (?, ?, ?, ?)";
    PreparedStatement ps = conn.prepareStatement(sql);

    ps.setString(1, arnia.getArn_dataInst());
    ps.setBoolean(2, arnia.isArn_piena());
    ps.setString(3, arnia.getArn_MacAddress());
    ps.setInt(4, arnia.getApi_id());

    ps.executeUpdate();
    conn.close();
}
}