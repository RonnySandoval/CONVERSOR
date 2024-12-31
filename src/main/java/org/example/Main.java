package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        APIRequest apiRequest = new APIRequest();
        CurrencyConverter converter = new CurrencyConverter(apiRequest);

        while (true) {
            System.out.println("\n====================== CONVERSOR DE DIVISAS ======================");

            String[] mensajes = {
                    "Seleccione una opción: ",
                    "1. Ver divisas disponibles",
                    "2. Convertir divisas",
                    "3. Salir",
                    "================================================================="
            };

            for (String mensaje : mensajes) { System.out.println(mensaje); }

            int opcion;
            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido.");
                continue;
            }

            switch (opcion) {
                case 1:// Mostrar las divisas disponibles
                    showCurrencies();
                    break;

                case 2:// Realizar la conversión de divisas
                    converter.realizarConversion(scanner);
                    break;

                case 3: // Salir del programa
                    System.out.println("¡Hasta pronto!");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }

    private static void showCurrencies() {
        System.out.println("\nDivisas disponibles:");

        String[] divisas = {
                "USD - Dólar Estadounidense",
                "EUR - Euro",
                "COP - Peso Colombiano",
                "ARS - Peso Argentino",
                "CLP - Peso Chileno",
                "MXN - Peso Mexicano",
                "GBP - Libra Esterlina",
                "JPY - Yen Japonés",
                "AUD - Dólar Australiano"
        };

        for (String divisa : divisas) {
            System.out.println(divisa);
        }
    }
}

