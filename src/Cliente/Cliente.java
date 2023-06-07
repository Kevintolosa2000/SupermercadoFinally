package Cliente;

public class Cliente {
    private String medioPago;
    private String tipoCliente;
    private Integer cantidadArticulos;
    private Double tiempoEspera;

    public Cliente(String medioPago, String tipoCliente, int cantidadArticulos) {
        this.medioPago = medioPago;
        this.tipoCliente = tipoCliente;
        this.cantidadArticulos = cantidadArticulos;
        this.tiempoEspera = calcularTiempo();
    }

    public Cliente() {
    }

    public String getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(String medioPago) {
        this.medioPago = medioPago;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public Integer getCantidadArticulos() {
        return cantidadArticulos;
    }

    public void setCantidadArticulos(Integer cantidadArticulos) {
        this.cantidadArticulos = cantidadArticulos;
    }

    public Double getTiempoEspera() {
        return tiempoEspera;
    }

    public void setTiempoEspera(Double tiempoEspera) {
        this.tiempoEspera = tiempoEspera;
    }

    @Override
    public String toString() {
        return "Cliente: medioPago:" + medioPago;
       /* return "Cliente: medioPago:" + medioPago +
                " tipoCliente: " + tipoCliente + " cantidadArticulos: " + cantidadArticulos + " tiempo de espera del cliente: "+ tiempoEspera;*/
    }

    private double calcularTiempo() {

        double tiempoEspera = cantidadArticulos * 30;
        double tiempoBase = tiempoEspera;

        switch (tipoCliente) {
            case "Comun":
                tiempoBase += tiempoEspera * 0.15;
                break;
            case "Embarazada":
                tiempoBase += tiempoEspera * 0.20;
                break;
            case "Jubilado":
                tiempoBase += tiempoEspera * 0.25;
                break;
            default:
                System.out.println("Flaheaste cualquiera, no existe ese cliente forro ");
        }

        switch (medioPago) {
            case "Efectivo":
                tiempoBase += tiempoEspera * 0.10;
                break;
            case "Tarjeta s/problemas":
                tiempoBase += tiempoEspera * 0.15;
                break;
            case "Tarjeta c/problemas":
                tiempoBase += tiempoEspera * 0.50;
                break;
            default:
                System.out.println("Flaheaste cualquiera, no existe ese metodo de pago");
        }
        return tiempoBase;
    }


}
