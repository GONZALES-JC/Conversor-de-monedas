package gonzales.juan.carconversor.program;

import java.util.ArrayList;
import java.util.List;

public class Interfaz {
    private String Menu;
    private List<String> listaDeMonedasDisponibles;

    // Constructor
    public Interfaz() {
        Menu = """
            **********************************************
            * Sea bienvenido/a al conversor de Monedas
            * 1) Dólar --> Peso argentino
            * 2) Peso argetino --> Dólar
            * 3) Dólar --> Real brasileño
            * 4) Real brasileño --> Dólar
            * 5) Dólar --> Peso colombiano
            * 6) Peso colombiano --> Dólar
            * 7) Conversión específica
            * 8) Revisar historial
            * 9) Salir
            **********************************************
            * Elija una opción válida: """;
        this.listaDeMonedasDisponibles = new ArrayList<>();
        listaDeMonedasDisponibles.add("Argentina: Peso argentino (ARS)");
        listaDeMonedasDisponibles.add("Bolivia: Boliviano (BOB)");
        listaDeMonedasDisponibles.add("Brasil: Real brasileño (BRL)");
        listaDeMonedasDisponibles.add("Chile: Peso chileno (CLP)");
        listaDeMonedasDisponibles.add("Colombia: Peso colombiano (COP)");
        listaDeMonedasDisponibles.add("Costa Rica: Colón costarricense (CRC)");
        listaDeMonedasDisponibles.add("Cuba: Peso cubano (CUP)");
        listaDeMonedasDisponibles.add("Ecuador: Dólar estadounidense (USD)");
        listaDeMonedasDisponibles.add("El Salvador: Dólar estadounidense (USD)");
        listaDeMonedasDisponibles.add("Guatemala: Quetzal guatemalteco (GTQ)");
        listaDeMonedasDisponibles.add("Honduras: Lempira hondureña (HNL)");
        listaDeMonedasDisponibles.add("México: Peso mexicano (MXN)");
        listaDeMonedasDisponibles.add("Nicaragua: Córdoba nicaragüense (NIO)");
        listaDeMonedasDisponibles.add("Panamá: Balboa panameño (PAB)");
        listaDeMonedasDisponibles.add("Paraguay: Guaraní paraguayo (PYG)");
        listaDeMonedasDisponibles.add("Perú: Sol peruano (PEN)");
        listaDeMonedasDisponibles.add("Uruguay: Peso uruguayo (UYU)");
        listaDeMonedasDisponibles.add("Venezuela: Bolívar soberano (VES)");
    }

    // Métodos Getter y Setter
    public String getMenu() {
        return Menu;
    }

    public List<String> getListaDeMonedasDisponibles() {
        return listaDeMonedasDisponibles;
    }

    // Métodos adicionales
}
