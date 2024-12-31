package org.example;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ApiParser {

    public static double parsearTasaCambio(String jsonResponse) {
        // Usar Gson para parsear el JSON
        JsonObject jsonObject = JsonParser.parseString(jsonResponse).getAsJsonObject();
        double tasaCambio = jsonObject.get("conversion_rate").getAsDouble();
        return tasaCambio;
    }
}
