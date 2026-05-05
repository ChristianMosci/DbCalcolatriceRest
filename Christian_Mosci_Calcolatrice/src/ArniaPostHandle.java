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
import com.google.gson.JsonSyntaxException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class ArniaPostHandle implements HttpHandler {

    private final Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    @Override
    public void handle(HttpExchange exchange) throws IOException {

        // CORS
        if (exchange.getRequestMethod().equalsIgnoreCase("OPTIONS")) {
            exchange.getResponseHeaders().set("Access-Control-Allow-Origin", "*");
            exchange.getResponseHeaders().set("Access-Control-Allow-Methods", "POST, OPTIONS");
            exchange.getResponseHeaders().set("Access-Control-Allow-Headers", "Content-Type");
            exchange.sendResponseHeaders(204, -1);
            return;
        }

        // Solo POST
        if (!exchange.getRequestMethod().equalsIgnoreCase("POST")) {
            inviaErrore(exchange, 405, "Metodo non consentito. Usa POST");
            return;
        }

        try {
            // Legge JSON
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(exchange.getRequestBody(), StandardCharsets.UTF_8)
            );

            Arnia arnia = gson.fromJson(reader, Arnia.class);
            reader.close();

            // VALIDAZIONE
            if (arnia == null) {
                inviaErrore(exchange, 400, "Body vuoto o non valido");
                return;
            }

            if (arnia.getArn_MacAddress() == null || arnia.getArn_MacAddress().isEmpty()) {
                inviaErrore(exchange, 400, "MAC Address obbligatorio");
                return;
            }

            if (arnia.getApi_id() == 0) {
                inviaErrore(exchange, 400, "api_id obbligatorio (foreign key)");
                return;
            }

            // SALVATAGGIO
            ArniaService.inserisciArnia(arnia);

            // RISPOSTA
            Map<String, Object> risposta = new HashMap<>();
            risposta.put("messaggio", "Arnia inserita con successo");
            risposta.put("arnia", arnia);

            String jsonRisposta = gson.toJson(risposta);

            inviaRisposta(exchange, 200, jsonRisposta);

        } catch (JsonSyntaxException e) {
            inviaErrore(exchange, 400, "JSON non valido");
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


