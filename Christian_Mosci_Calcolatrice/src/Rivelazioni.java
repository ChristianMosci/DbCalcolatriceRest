/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mosci.christian
 */
public class Rivelazioni {

    private int ril_id;
    private float ril_dato;
    private String ril_dataOra;
    private int sen_id;

    public Rivelazioni() {}

    public Rivelazioni(int ril_id, float ril_dato, String ril_dataOra, int sen_id) {
        this.ril_id = ril_id;
        this.ril_dato = ril_dato;
        this.ril_dataOra = ril_dataOra;
        this.sen_id = sen_id;
    }

    public int getRil_id() { return ril_id; }
    public void setRil_id(int ril_id) { this.ril_id = ril_id; }

    public float getRil_dato() { return ril_dato; }
    public void setRil_dato(float ril_dato) { this.ril_dato = ril_dato; }

    public String getRil_dataOra() { return ril_dataOra; }
    public void setRil_dataOra(String ril_dataOra) { this.ril_dataOra = ril_dataOra; }

    public int getSen_id() { return sen_id; }
    public void setSen_id(int sen_id) { this.sen_id = sen_id; }
}