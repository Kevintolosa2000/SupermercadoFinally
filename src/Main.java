import Cliente.Caja;
import Cliente.ExcepcionTarjetaProblemas;
import Cliente.Supermercado;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Supermercado disco = new Supermercado(3);

        try {
            for (int i = 0; i < 9; i++) {
                disco.nuevoCliente();
                disco.asignarClientesACajas();
            }

            System.out.println(disco.toString());

        } catch (ExcepcionTarjetaProblemas e) {
            System.out.println("Error");
        } finally {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("archivoAEscribir.json"))) {
                gson.toJson(disco, Supermercado.class, bufferedWriter);
            } catch (IOException e) {
                System.out.println("Error al escribir en el archivo JSON");
            }

            /** Esto borra todu**/

            disco.atender();
            if (disco.getCajas().isEmpty()) {
                System.out.println("Vacia :D");
            } else {
                System.out.println("No funca :c");
            }
            System.out.println(disco.toString());

        }
    }
}