package org.example;

import java.util.Scanner;

public class CurrencyConverter {
    private APIRequest apiRequest;

    public CurrencyConverter(APIRequest apiRequest) {
        this.apiRequest = apiRequest;
    }

    public void realizarConversion(Scanner scanner) {
        System.out.print("\nIngrese la moneda de origen (código de 3 letras, por ejemplo, USD): ");
        String currencyOrigin = scanner.nextLine().toUpperCase();

        System.out.print("Ingrese la moneda de destino (código de 3 letras, por ejemplo, EUR): ");
        String currencyDestiny = scanner.nextLine().toUpperCase();

        System.out.print("Ingrese la cantidad a convertir: ");
        double amount;
        try {
            amount = Double.parseDouble(scanner.nextLine());
            if (amount <= 0) {
                System.out.println("Por favor, ingrese un valor mayor a 0.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Por favor, ingrese un número válido.");
            return;
        }

        try {
            System.out.println("\nConsultando la tasa de cambio...");
            String jsonResponse = apiRequest.fetchExchangeRates(currencyOrigin, currencyDestiny);
            double changeRatio = ApiParser.parsearTasaCambio(jsonResponse);            // Parsear el JSON para obtener la tasa de cambio
            double result = amount * changeRatio;                                    // Realizar la conversión

            System.out.println(String.format("Tasa de cambio: 1 %s = %.4f %s", currencyOrigin, changeRatio, currencyDestiny));
            System.out.println(String.format("Tasa de cambio: 1 %s = %.4f %s", currencyDestiny, 1/changeRatio, currencyOrigin));
            System.out.printf("Resultado: %.2f %s equivalen a %.2f %s%n",
                    amount, currencyOrigin, result, currencyDestiny);

        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());

        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }
}
