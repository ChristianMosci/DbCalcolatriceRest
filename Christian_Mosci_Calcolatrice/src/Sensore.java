/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mosci.christian
 */
public class Sensore {

    private int sen_id;
    private boolean sen_stato;
    private float sen_min;
    private float sen_max;
    private int arn_id;
    private int tip_id;

    public Sensore() {}

    public Sensore(int sen_id, boolean sen_stato, float sen_min, float sen_max, int arn_id, int tip_id) {
        this.sen_id = sen_id;
        this.sen_stato = sen_stato;
        this.sen_min = sen_min;
        this.sen_max = sen_max;
        this.arn_id = arn_id;
        this.tip_id = tip_id;
    }

    public int getSen_id() { return sen_id; }
    public void setSen_id(int sen_id) { this.sen_id = sen_id; }

    public boolean isSen_stato() { return sen_stato; }
    public void setSen_stato(boolean sen_stato) { this.sen_stato = sen_stato; }

    public float getSen_min() { return sen_min; }
    public void setSen_min(float sen_min) { this.sen_min = sen_min; }

    public float getSen_max() { return sen_max; }
    public void setSen_max(float sen_max) { this.sen_max = sen_max; }

    public int getArn_id() { return arn_id; }
    public void setArn_id(int arn_id) { this.arn_id = arn_id; }

    public int getTip_id() { return tip_id; }
    public void setTip_id(int tip_id) { this.tip_id = tip_id; }
}
