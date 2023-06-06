package Cliente;

import java.util.LinkedList;
import java.util.Queue;

public class Caja {
    private Queue<Cliente> filaClientes;
    private Double tiempoTotalDeCaja;

    public Caja() {
        filaClientes = new LinkedList<>();
        tiempoTotalDeCaja = sumarTiempoTotal();
    }

    public Queue<Cliente> getFilaClientes() {
        return filaClientes;
    }

    public void setFilaClientes(Queue<Cliente> filaClientes) {
        this.filaClientes = filaClientes;
    }

    public void agregarCliente(Cliente cliente) {
        filaClientes.add(cliente);
    }

    public Cliente atenderCliente() {
        return filaClientes.poll();
    }

    public boolean estaVacia() {
        return filaClientes.isEmpty();
    }

    public Double getTiempoTotalDeCaja() {
        return tiempoTotalDeCaja;
    }

    public void setTiempoTotalDeCaja(Double tiempoTotalDeCaja) {
        this.tiempoTotalDeCaja = tiempoTotalDeCaja;
    }

    @Override
    public String toString() {
        return "\nCaja: fila de Clientes: " + filaClientes + " Tiempo de total de la caja " + tiempoTotalDeCaja;
    }

    public double sumarTiempoTotal() {
        double i = 0;
        for (Cliente c : filaClientes)
            i += c.getTiempoEspera();
        return i;
    }


}
