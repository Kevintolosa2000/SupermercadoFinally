import Cliente.Supermercado;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.swing.*;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Supermercado disco = new Supermercado(1);
        for (int i = 0; i < 2; i++)
            disco.nuevoCliente();
       // try {
            disco.asignarClientesACajas();
       // } catch (NullPointerException e) {
           // e.fillInStackTrace();
            System.out.println("pero che...");
       // } finally {
           System.out.println(disco.toString());
        //}
    }
}