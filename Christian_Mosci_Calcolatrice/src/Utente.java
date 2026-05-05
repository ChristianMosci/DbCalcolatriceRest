/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mosci.christian
 */
public class Utente {

    private int ute_id;
    private String ute_username;
    private String ute_password;
    private String ute_token;
    private String ute_scadenzaToken;
    private boolean ute_admin;

    public Utente() {}

    public Utente(int ute_id, String ute_username, String ute_password, String ute_token, String ute_scadenzaToken, boolean ute_admin) {
        this.ute_id = ute_id;
        this.ute_username = ute_username;
        this.ute_password = ute_password;
        this.ute_token = ute_token;
        this.ute_scadenzaToken = ute_scadenzaToken;
        this.ute_admin = ute_admin;
    }

    public int getUte_id() { return ute_id; }
    public void setUte_id(int ute_id) { this.ute_id = ute_id; }

    public String getUte_username() { return ute_username; }
    public void setUte_username(String ute_username) { this.ute_username = ute_username; }

    public String getUte_password() { return ute_password; }
    public void setUte_password(String ute_password) { this.ute_password = ute_password; }

    public String getUte_token() { return ute_token; }
    public void setUte_token(String ute_token) { this.ute_token = ute_token; }

    public String getUte_scadenzaToken() { return ute_scadenzaToken; }
    public void setUte_scadenzaToken(String ute_scadenzaToken) { this.ute_scadenzaToken = ute_scadenzaToken; }

    public boolean isUte_admin() { return ute_admin; }
    public void setUte_admin(boolean ute_admin) { this.ute_admin = ute_admin; }
}