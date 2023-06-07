package Cliente;

import java.util.*;

public class Supermercado {
    private List<Caja> cajas;
    //private Queue<Cliente> filaEspera;
    private fila_espera<Cliente> filaEspera;
    private List<String> tiposPago;
    private List<String> tiposCliente;


    public Supermercado() {
    }

    //region Getter Setters
    public List<Caja> getCajas() {
        return cajas;
    }

    public void setCajas(List<Caja> cajas) {
        this.cajas = cajas;
    }

    public fila_espera<Cliente> getFilaEspera() {
        return filaEspera;
    }

    public void setFilaEspera(fila_espera<Cliente> filaEspera) {
        this.filaEspera = filaEspera;
    }

    public List<String> getTiposPago() {
        return tiposPago;
    }

    public void setTiposPago(List<String> tiposPago) {
        this.tiposPago = tiposPago;
    }

    public List<String> getTiposCliente() {
        return tiposCliente;
    }

    public void setTiposCliente(List<String> tiposCliente) {
        this.tiposCliente = tiposCliente;
    }

    //endregion
    public Supermercado(int numCajas) {
        cajas = new ArrayList<>();
        filaEspera = new fila_espera<Cliente>();
        tiposPago = new ArrayList<>();
        tiposCliente = new ArrayList<>();
        inicializarCajas(numCajas);
        inicializarTiposPago();
        inicializarTiposCliente();
    }

    private void inicializarCajas(int numCajas) {
        for (int i = 0; i < numCajas; i++) {
            cajas.add(new Caja());
        }
    }

    private void inicializarTiposPago() {
        tiposPago.add("Efectivo");
        tiposPago.add("Tarjeta s/problemas");
        tiposPago.add("Tarjeta c/problemas");
    }

    private void inicializarTiposCliente() {
        tiposCliente.add("Comun");
        tiposCliente.add("Jubilado");
        tiposCliente.add("Embarazada");
    }

    private Cliente generarClienteAleatorio() {
        Random random = new Random();
        String medioPago = tiposPago.get(random.nextInt(tiposPago.size()));
        String tipoCliente = tiposCliente.get(random.nextInt(tiposCliente.size()));
        int cantidadArticulos = random.nextInt(30) + 1;
        return new Cliente(medioPago, tipoCliente, cantidadArticulos);
    }

    public void nuevoCliente() {
        Cliente cliente = generarClienteAleatorio();
        filaEspera.add(cliente);
    }

    public void asignarClientesACajas() throws ExcepcionTarjetaProblemas {
        while (!filaEspera.isEmpty()) {
            Caja cajaMenorFila = obtenerCajaConMenorFila();
            Cliente clienteActual = filaEspera.poll();

/* ACA PDRIAS PONER DIRECTAMENTE EL cajaMenorFila.cantidadDeProblemas() >= 3
 PERO SUPUESTAMENTE NO VERIFICARIA AL ULTIMO CLIENTE
 **/
            if (clienteActual.getMedioPago().equals("Tarjeta c/problemas") && cajaMenorFila.cantidadDeProblemas() >= 3)
            {
                throw new ExcepcionTarjetaProblemas();
            }

            double tiempoCliente = clienteActual.getTiempoEspera();
            cajaMenorFila.setTiempoTotalDeCaja(cajaMenorFila.getTiempoTotalDeCaja() + tiempoCliente);
            cajaMenorFila.agregarCliente(clienteActual);
        }
    }


    /**
     * EL VIEJO SIRVE PARA SUMAR TODU
     * //    public void asignarClientesACajas() {
     * //        Double i = (double) 0;
     * //        while (!filaEspera.isEmpty()) {
     * //            Caja cajaMenorFila = obtenerCajaConMenorFila();
     * //            Cliente clienteActual = filaEspera.poll();
     * //            i += clienteActual.getTiempoEspera();
     * //            cajaMenorFila.setTiempoTotalDeCaja(i);
     * //            cajaMenorFila.agregarCliente(clienteActual);
     * //        }
     * //    }
     **/

    private Caja obtenerCajaConMenorFila() {
        Caja cajaMenorFila = cajas.get(0);
        int menorTamanoFila = cajaMenorFila.estaVacia() ? 0 : cajaMenorFila.getFilaClientes().size();

        for (int i = 1; i < cajas.size(); i++) {
            Caja caja = cajas.get(i);
            int tamanoFila = caja.estaVacia() ? 0 : caja.getFilaClientes().size();
//            if(caja.estaVacia())
//                tamanoFila=0;
//            else
//                tamanoFila=caja.getFilaClientes().size();
            if (tamanoFila < menorTamanoFila) {
                menorTamanoFila = tamanoFila;
                cajaMenorFila = caja;
            }
        }

        return cajaMenorFila;
    }

    @Override
    public String toString() {
        return "Supermercado: cajas: " + cajas +
                "\nfilaEspera: " + filaEspera;
    }

}
