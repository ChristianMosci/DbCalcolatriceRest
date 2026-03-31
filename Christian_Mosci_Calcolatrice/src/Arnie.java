/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MOSCI.CHRISTIAN
 */
public class Arnie {
    private int id;
    private String nome;
    private String posizione;
    private int numeroApi;
    private String stato;

    public Arnie() {}

    public Arnie(int id, String nome, String posizione, int numeroApi, String stato) {
        this.id = id;
        this.nome = nome;
        this.posizione = posizione;
        this.numeroApi = numeroApi;
        this.stato = stato;
    }

    // Getter e Setter
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getPosizione() { return posizione; }
    public void setPosizione(String posizione) { this.posizione = posizione; }

    public int getNumeroApi() { return numeroApi; }
    public void setNumeroApi(int numeroApi) { this.numeroApi = numeroApi; }

    public String getStato() { return stato; }
    public void setStato(String stato) { this.stato = stato; }
}