# Conversor de Divisas

Este es un conversor de divisas simple desarrollado en Java, que utiliza una API para obtener tasas de cambio en tiempo real y realizar conversiones entre diferentes monedas. El programa funciona en la consola y permite al usuario consultar tasas de cambio y realizar conversiones entre monedas.

## Requisitos

- Java 8 o superior
- Conexión a Internet (para obtener las tasas de cambio desde la API)

## Dependencias

El proyecto utiliza las siguientes dependencias:

- **Gson**: Para parsear el JSON de la API y convertirlo a objetos Java.
- **HttpClient**: Para realizar las solicitudes HTTP a la API.

Si estás usando **Maven**, estas dependencias están gestionadas automáticamente a través del archivo `pom.xml`.

## API Utilizada

El conversor utiliza la API de [ExchangeRate-API](https://www.exchangerate-api.com/) para obtener tasas de cambio entre divisas. Se requiere una clave de API para realizar las solicitudes. Puedes obtener una clave gratuita registrándote en el sitio de la API.

## Funcionalidades

### 1. Consultar las divisas disponibles
El usuario puede consultar las divisas disponibles que se pueden utilizar para la conversión.

### 2. Realizar la conversión de divisas
El usuario puede ingresar una cantidad en una moneda de origen, seleccionar una moneda de destino y ver el resultado de la conversión.

### 3. Salir
El usuario puede cerrar el programa en cualquier momento.

## Cómo ejecutar el programa

1. Clona o descarga el repositorio.
2. Abre una terminal y navega a la carpeta del proyecto.
3. Compila y ejecuta el programa con los siguientes comandos:

   ```bash
   mvn clean install
   mvn exec:java

