/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mosci.christian
 */
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
import java.util.List;
import java.util.Map;


public class ArniaGetHandle implements HttpHandler {
    
    private final Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();
    
    @Override
public void handle(HttpExchange exchange) throws IOException {

    if (!exchange.getRequestMethod().equalsIgnoreCase("GET")) {
        inviaErrore(exchange, 405, "Metodo non consentito. Usa GET");
        return;
    }

    try {
        String query = exchange.getRequestURI().getQuery();

        // 👉 CASO 1: GET con ID
        if (query != null && query.contains("id=")) {

            int id = Integer.parseInt(query.split("=")[1]);

            Arnia arnia = ArniaService.getArniaById(id);

            if (arnia == null) {
                inviaErrore(exchange, 404, "Arnia non trovata");
                return;
            }

            String json = gson.toJson(arnia);
            inviaRisposta(exchange, 200, json);

        } 
        // 👉 CASO 2: GET TUTTE
        else {
            List<Arnia> lista = ArniaService.getAllArnie();
            String json = gson.toJson(lista);
            inviaRisposta(exchange, 200, json);
        }

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

    Map<String, Object> errore = new HashMap<>();
    errore.put("errore", messaggio);
    errore.put("status", codice);

    String jsonErrore = gson.toJson(errore);
    inviaRisposta(exchange, codice, jsonErrore);
}
}