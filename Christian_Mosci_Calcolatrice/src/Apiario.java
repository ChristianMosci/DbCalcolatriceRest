/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mosci.christian
 */
public class Apiario {

    private int api_id;
    private String api_nome;
    private String api_luogo;
    private String api_lat;
    private String api_lon;

    public Apiario() {}

    public Apiario(int api_id, String api_nome, String api_luogo, String api_lat, String api_lon) {
        this.api_id = api_id;
        this.api_nome = api_nome;
        this.api_luogo = api_luogo;
        this.api_lat = api_lat;
        this.api_lon = api_lon;
    }

    public int getApi_id() { return api_id; }
    public void setApi_id(int api_id) { this.api_id = api_id; }

    public String getApi_nome() { return api_nome; }
    public void setApi_nome(String api_nome) { this.api_nome = api_nome; }

    public String getApi_luogo() { return api_luogo; }
    public void setApi_luogo(String api_luogo) { this.api_luogo = api_luogo; }

    public String getApi_lat() { return api_lat; }
    public void setApi_lat(String api_lat) { this.api_lat = api_lat; }

    public String getApi_lon() { return api_lon; }
    public void setApi_lon(String api_lon) { this.api_lon = api_lon; }
}