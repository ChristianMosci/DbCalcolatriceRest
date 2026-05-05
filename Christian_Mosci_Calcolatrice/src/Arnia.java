/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MOSCI.CHRISTIAN
 */
public class Arnia {

    private int arn_id;
    private String arn_dataInst;
    private boolean arn_piena;
    private String arn_MacAddress;
    private int api_id;

    public Arnia(int arn_id, String arn_dataInst, boolean arn_piena, String arn_MacAddress, int api_id) {
        this.arn_id = arn_id;
        this.arn_dataInst = arn_dataInst;
        this.arn_piena = arn_piena;
        this.arn_MacAddress = arn_MacAddress;
        this.api_id = api_id;
    }

    public int getArn_id() { return arn_id; }
    public void setArn_id(int arn_id) { this.arn_id = arn_id; }

    public String getArn_dataInst() { return arn_dataInst; }
    public void setArn_dataInst(String arn_dataInst) { this.arn_dataInst = arn_dataInst; }

    public boolean isArn_piena() { return arn_piena; }
    public void setArn_piena(boolean arn_piena) { this.arn_piena = arn_piena; }

    public String getArn_MacAddress() { return arn_MacAddress; }
    public void setArn_MacAddress(String arn_MacAddress) { this.arn_MacAddress = arn_MacAddress; }

    public int getApi_id() { return api_id; }
    public void setApi_id(int api_id) { this.api_id = api_id; }
}