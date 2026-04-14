/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mosci.christian
 */
import com.sun.net.httpserver.HttpServer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;


public class CalcolatriceServer {
    
    private final int porta;

    // Costruttore per impostare la porta
    public CalcolatriceServer(int porta) {
        this.porta = porta;
    }

    public void avvia() {
        try {
            // Crea il server sulla porta specificata
            HttpServer server = HttpServer.create(new InetSocketAddress(porta), 0);
            
            // Registra gli handler per gli endpoint
            // ATTENZIONE: Affinché non dia errore, assicurati di avere i file 
            // PostHandler.java e GetHandler.java nella stessa cartella (package)
            
            // arnie
            server.createContext("/api/arnie", new ArniaGetHandle());
            server.createContext("/api/arnie/add", new ArniaPostHandle());
            
            // Endpoint di benvenuto
            server.createContext("/", exchange -> {
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                
                Map<String, Object> info = new HashMap<>();
                info.put("messaggio", "Benvenuto alla Calcolatrice REST API");
                info.put("versione", "2.0.0");
                info.put("tecnologia", "Java + GSON");
                
                Map<String, String> endpoints = new HashMap<>();
                endpoints.put("POST", "/api/calcola/post");
                endpoints.put("GET", "/api/calcola/get?operando1=X&operando2=Y&operatore=OP");
                info.put("endpoints", endpoints);
                
                Map<String, String> operatori = new HashMap<>();
                operatori.put("somma", "SOMMA o +");
                operatori.put("sottrazione", "SOTTRAZIONE o -");
                operatori.put("moltiplicazione", "MOLTIPLICAZIONE o * o X");
                operatori.put("divisione", "DIVISIONE o /");
                info.put("operatori_supportati", operatori);
                
                String jsonRisposta = gson.toJson(info);
                
                exchange.getResponseHeaders().set("Content-Type", "application/json; charset=UTF-8");
                byte[] bytes = jsonRisposta.getBytes();
                exchange.sendResponseHeaders(200, bytes.length);
                exchange.getResponseBody().write(bytes);
                exchange.getResponseBody().close();
            });
            
            // Avvia il server
            server.setExecutor(null); // Usa il default executor
            server.start();
            
            // Messaggi di conferma
            System.out.println("==============================================");
            System.out.println("  Server REST con GSON avviato!");
            System.out.println("==============================================");
            System.out.println("Porta: " + porta);
            System.out.println("\nEndpoint disponibili:");
            System.out.println("  - POST: http://localhost:" + porta + "/api/calcola/post");
            System.out.println("  - GET:  http://localhost:" + porta + "/api/calcola/get");
            System.out.println("  - Info: http://localhost:" + porta + "/");
            System.out.println("\nPremi Ctrl+C per fermare il server");
            System.out.println("==============================================");
            
        } catch (IOException e) {
            System.err.println("Errore nell'avvio del server: " + e.getMessage());
            e.printStackTrace();
        }
    }
}