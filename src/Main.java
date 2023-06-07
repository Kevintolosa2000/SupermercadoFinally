import Cliente.Supermercado;

public class Main {
    public static void main(String[] args) {
        Supermercado disco = new Supermercado(2);
        for (int i = 0; i < 4; i++)
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