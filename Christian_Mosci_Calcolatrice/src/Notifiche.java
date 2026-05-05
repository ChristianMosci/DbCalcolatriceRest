/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mosci.christian
 */
public class Notifiche{

    private int not_id;
    private String not_titolo;
    private String not_desc;
    private int ril_id;

    public Notifiche() {}

    public Notifiche(int not_id, String not_titolo, String not_desc, int ril_id) {
        this.not_id = not_id;
        this.not_titolo = not_titolo;
        this.not_desc = not_desc;
        this.ril_id = ril_id;
    }

    public int getNot_id() { return not_id; }
    public void setNot_id(int not_id) { this.not_id = not_id; }

    public String getNot_titolo() { return not_titolo; }
    public void setNot_titolo(String not_titolo) { this.not_titolo = not_titolo; }

    public String getNot_desc() { return not_desc; }
    public void setNot_desc(String not_desc) { this.not_desc = not_desc; }

    public int getRil_id() { return ril_id; }
    public void setRil_id(int ril_id) { this.ril_id = ril_id; }
}
