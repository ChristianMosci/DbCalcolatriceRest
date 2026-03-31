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
        ResultSet rs = stmt.executeQuery("SELECT * FROM arnie");

        while (rs.next()) {
            Arnia a = new Arnia(
                rs.getInt("id"),
                rs.getString("nome"),
                rs.getString("posizione"),
                rs.getInt("numero_api"),
                rs.getString("stato")
            );
            lista.add(a);
        }

        conn.close();
        return lista;
    }

    public static void inserisciArnia(Arnia arnia) throws Exception {
        Connection conn = ConnessioneDb.getConnection();

        String sql = "INSERT INTO arnie (nome, posizione, numero_api, stato) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, arnia.getNome());
        ps.setString(2, arnia.getPosizione());
        ps.setInt(3, arnia.getNumeroApi());
        ps.setString(4, arnia.getStato());

        ps.executeUpdate();
        conn.close();
    }
}