/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User 10
 */
public class Main {
    
    public static void main(String[] args) {
        
        // Configurazione porta (default 8080)
        int porta = 8080;
        
        if (args.length > 0) {
            try {
                porta = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.err.println("Porta non valida, uso porta default 8080");
            }
        }
        
        // Creiamo un'istanza del server e lo avviamo
        CalcolatriceServer server = new CalcolatriceServer(porta);
        server.avvia();
    }
}