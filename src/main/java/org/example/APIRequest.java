package org.example;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;
import java.net.URI;

public class APIRequest {
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/";
    private static final String API_KEY = "288f06cfc991ea89ed942655";

    public String fetchExchangeRates(String currencyOrigin, String currencyDestiny) throws IOException, InterruptedException {
        // Validar las entradas
        if (currencyOrigin == null || currencyDestiny == null ||
                currencyOrigin.length() != 3 || currencyDestiny.length() != 3) {
            throw new IllegalArgumentException("Las monedas deben ser códigos de 3 letras.");
        }

        // Convertir a mayúsculas
        currencyOrigin = currencyOrigin.toUpperCase();
        currencyDestiny = currencyDestiny.toUpperCase();

        // Construir la URI
        String uri = API_URL + API_KEY + "/pair/" + currencyOrigin + "/" + currencyDestiny;

        // Crear el cliente y la solicitud
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .GET()
                .build();

        try {
            // Enviar la solicitud y obtener la respuesta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Verificar el código de estado HTTP
            if (response.statusCode() != 200) {
                throw new RuntimeException("Error en la API: Código " + response.statusCode());
            }

            return response.body(); // Retornar el cuerpo de la respuesta JSON
        } catch (IOException | InterruptedException e) {
            // Manejar errores de red
            throw new RuntimeException("Error al conectar con la API: " + e.getMessage(), e);
        }
    }
}