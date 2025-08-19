package gonzales.juan.carconversor.program;

import com.google.gson.JsonObject;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Conversor {
    private double valorOriginal;
    private double valorFinal;
    private double equivalencia;
    private String siglasMonedaInicial;
    private String siglasMonedaFinal;
    private String horaActual;

    // Métodos
    public Conversor convertir(JsonObject jsonMonedas, String monedaInicial, String monedaFinal, double cantidad) {
        this.valorOriginal = cantidad;
        this.equivalencia = Double.parseDouble(String.valueOf(jsonMonedas.get(monedaFinal)));
        this.siglasMonedaInicial = monedaInicial;
        this.siglasMonedaFinal = monedaFinal;
        this.valorFinal = this.valorOriginal * this.equivalencia;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        this.horaActual = LocalTime.now().format(formatter);
        return this;
    }

    // Método extractor
    public String extractor(String moneda) {
        try {
            String siglas;

            // Programando el extractor de texto
            Pattern pattern = Pattern.compile("\\((.*?)\\)");
            Matcher matcher = pattern.matcher(moneda);

            if (matcher.find()) {
                siglas = matcher.group(1);
                return siglas;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "";
    }

    @Override
    public String toString() {
        return String.format("Se ha convertido { %.2f %s a %.2f %s a las %s }"
                , this.valorOriginal
                , this.siglasMonedaInicial
                , this.valorFinal
                , this.siglasMonedaFinal
                , this.horaActual);
    }
}
