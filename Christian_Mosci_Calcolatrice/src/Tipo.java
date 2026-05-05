/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mosci.christian
 */
public class Tipo {

    private int tip_id;
    private String tip_descrizione;

    public Tipo() {}

    public Tipo(int tip_id, String tip_descrizione) {
        this.tip_id = tip_id;
        this.tip_descrizione = tip_descrizione;
    }

    public int getTip_id() { return tip_id; }
    public void setTip_id(int tip_id) { this.tip_id = tip_id; }

    public String getTip_descrizione() { return tip_descrizione; }
    public void setTip_descrizione(String tip_descrizione) { this.tip_descrizione = tip_descrizione; }
}