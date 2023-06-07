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
        Supermercado disco = new Supermercado(2);

        try {
            for (int i = 0; i < 2; i++) {
                disco.nuevoCliente();
                disco.asignarClientesACajas();
            }
            System.out.println(disco.toString());

        } catch (ExcepcionTarjetaProblemas e) {
            System.out.println("Error");
        }
    }


}