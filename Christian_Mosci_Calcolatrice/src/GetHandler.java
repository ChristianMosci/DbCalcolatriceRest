/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User 10
 */
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;


public class GetHandler implements HttpHandler {
    
    private final Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();
    
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        
        // Controllo metodo
        if (!exchange.getRequestMethod().equalsIgnoreCase("GET")) {
            inviaErrore(exchange, 405, "Metodo non consentito. Usa GET");
            return;
        }
        
        try {
            // 🔥 PRENDO LE ARNIE DAL DATABASE
            List<Arnia> lista = ArniaService.getAllArnie();
            
            // 🔥 CONVERSIONE JSON CON GSON
            String jsonRisposta = gson.toJson(lista);
            
            inviaRisposta(exchange, 200, jsonRisposta);
            
        } catch (Exception e) {
            inviaErrore(exchange, 500, "Errore server: " + e.getMessage());
        }
    }
    
    private void inviaRisposta(HttpExchange exchange, int codice, String jsonRisposta) 
            throws IOException {
        
        exchange.getResponseHeaders().set("Content-Type", "application/json; charset=UTF-8");
        exchange.getResponseHeaders().set("Access-Control-Allow-Origin", "*");
        
        byte[] bytes = jsonRisposta.getBytes(StandardCharsets.UTF_8);
        exchange.sendResponseHeaders(codice, bytes.length);
        
        OutputStream os = exchange.getResponseBody();
        os.write(bytes);
        os.close();
    }
    
    private void inviaErrore(HttpExchange exchange, int codice, String messaggio) 
            throws IOException {
        
        String jsonErrore = gson.toJson(new Errore(messaggio, codice));
        inviaRisposta(exchange, codice, jsonErrore);
    }
}