package gonzales.juan.carconversor.program;

import gonzales.juan.carconversor.queries.Queries;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {

    // Constructor
    public Program() {

    }

    // Métodos adicionales
    public void programaEncendido() {
        // Creando variables globales dentro del bucle
        boolean encendido = true;
        Interfaz interfaz = new Interfaz();
        Scanner scan = new Scanner(System.in);
        Queries queries = new Queries();
        while (encendido) {
            try {
                System.out.println((interfaz.getMenu()));
                int opcion = Integer.parseInt((scan.nextLine()));

                switch (opcion) {
                    case 1:
                        queries.consulta("USD", "ARS");
                        break;
                    case 2:
                        queries.consulta("ARS", "USD");
                        break;
                    case 3:
                        queries.consulta("USD", "BRL");
                        break;
                    case 4:
                        queries.consulta("BRL", "USD");
                        break;
                    case 5:
                        queries.consulta("USD", "COP");
                        break;
                    case 6:
                        queries.consulta("COP", "USD");
                        break;
                    case 7:
                        queries.consultaEspecifica();
                        break;
                    case 8:
                        queries.imprimirHistorial();
                        break;
                    case 9:
                        encendido = false;
                        break;
                    default:
                        System.out.println("¡Error! Opción no válida.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error: '" + e.getMessage() + "'");
            } finally {
                if (encendido) {
                    int contador = 0;
                    boolean respuestaValida = false;
                    while (!respuestaValida) {
                        System.out.println("\n¿Quiere realizar alguna otra acción? S / N");
                        String respuesta = scan.nextLine();
                        if (respuesta.equalsIgnoreCase("s") || respuesta.equalsIgnoreCase("n")) {
                            if (respuesta.equalsIgnoreCase("n")) {
                                encendido = false;
                                System.out.println("Finalizando el programa...");
                            }
                            respuestaValida = true;
                        }
                        if (contador > 2) { respuestaValida = true; encendido = false;}
                        contador++;
                    }
                } else { System.out.println("Finalizando el programa..."); }
            }
        }
    }
}
