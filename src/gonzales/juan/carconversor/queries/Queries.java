package gonzales.juan.carconversor.queries;

import gonzales.juan.carconversor.program.Conversor;
import gonzales.juan.carconversor.program.Interfaz;
import gonzales.juan.carconversor.program.LimpiarPantalla;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.FileWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Queries {
    private String apiKEY = "cee2d2565059c189cd680511";
    private String direccion;
    private List<Conversor> historial = new ArrayList<>();

    // Constructor
    public Queries() {
        this.direccion = "https://v6.exchangerate-api.com/v6/" + this.apiKEY + "/latest/";
    }

    // Métodos adicionales

    // Consultas
    public void consulta(String monedaInicial, String monedaFinal) {
        try {
            // Creamos un scanner y una variable double que contendra la cantidad a convertir
            Scanner scan = new Scanner(System.in);
            double cantidadAConsultar = 0;
            Conversor datosConvertidos = new Conversor();

            // Creamos los objetos cliente, solicitud y respuesta para realizar la consulta
            HttpClient cliente = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(this.direccion + monedaInicial))
                    .build();
            HttpResponse<String> response = cliente
                    .send(request, HttpResponse.BodyHandlers.ofString());

            // Creamos un objeto Gson para poder generar el archivo json
            Gson gson = new Gson();
            String json = response.body();

            // Filtramos el archivo para obtener solo el json que nos interesa
            ApiJsonObject jsonConversiones = gson.fromJson(json, ApiJsonObject.class);

            /*
             * Enviamos el objeto ApiJsonObject el cual contiene un atributo del tipo json
             * con la información que nos interesa junto a la cantidad que queremos convertir
             * y las siglas de ambas monedas a nuestra clase Conversor para extraer la información
             * relevante
            */
            Conversor conversor = new Conversor();
            System.out.print("Ingrese la cantidad de " + monedaInicial + " que desea convertir a " +
                    monedaFinal + ": ");
            cantidadAConsultar = scan.nextDouble();
            datosConvertidos = conversor.convertir(jsonConversiones.conversion_rates(),
                    monedaInicial,
                    monedaFinal,
                    cantidadAConsultar);
            System.out.println(datosConvertidos);
            this.historial.add(datosConvertidos);
        } catch (Exception e) {
            System.out.println("¡Error!\n" + e.getMessage());
        }
    }

    // Consultas específicas
    public void consultaEspecifica() {
        Interfaz interfaz = new Interfaz();
        Conversor conver = new Conversor();
        Scanner scan = new Scanner(System.in);

        List<String> listaMonedasDisponibles = interfaz.getListaDeMonedasDisponibles();
        for (int i = 0; i < interfaz.getListaDeMonedasDisponibles().size(); i++) {
            System.out.println((i + 1) + " - " + listaMonedasDisponibles.get(i));
        }

        System.out.println("Seleccione el número de lista de la moneda que quiere convertir: ");
        int opcion1 = Integer.parseInt(scan.nextLine());

        System.out.println("Seleccione el número de lista de la moneda en la que se convertira: ");
        int opcion2 = Integer.parseInt(scan.nextLine());

        consulta(conver.extractor(listaMonedasDisponibles.get(opcion1 - 1))
                , conver.extractor(listaMonedasDisponibles.get(opcion2 - 1)));
    }

    public void imprimirHistorial() {
        if (!this.historial.isEmpty()) {
            System.out.println("Historial de conversiones: ");
            for (int i = 0; i < this.historial.size(); i++) {
                System.out.println((i + 1) + " - " + this.historial.get(i));
            }
            crearDocumentoConHistorial();
        } else {
            System.out.println("Historial vacío, aún no se realiza ninguna conversión.");
        }
    }

    private void crearDocumentoConHistorial() {
        try {
            FileWriter escritura = new FileWriter("Historial-de-busquedas.txt");

            for (int i = 0; i < historial.size(); i++) {
                escritura.write((i + 1) + " - " + historial.get(i) + "\n");
            }
            escritura.close();
        } catch (Exception e) {
            System.out.println("Error: '" + e.getMessage() + "'");
        }
    }
}
