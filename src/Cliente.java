import java.io.Serializable;

public class Cliente implements Serializable {
    private String nombre;
    private String apellido;
    private Integer idCliente;
    private static Integer totalClientes=1;

    private Integer turnosAcumulados=40;

    private String telefono;

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getTotalClientes() {
        return totalClientes;
    }

    public Integer getTurnosAcumulados() {
        return turnosAcumulados;
    }

    public void setTurnosAcumulados(Integer turnosAcumulados) {
        this.turnosAcumulados = turnosAcumulados;
    }

    public Cliente() {
    }

    public Cliente(String nombre, String apellido, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.idCliente = totalClientes;
        totalClientes++;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", idCliente=" + idCliente +
                ", telefono='" + telefono + '\'' +
                '}';
    }

    public Boolean verificarTurnosCliente()
    {
        boolean flag = false;

        if (turnosAcumulados>=20)
        {
            //System.out.println("hay " + turnosAcumulados);
            turnosAcumulados=turnosAcumulados-20;
            flag=true;
           // System.out.println("hay " + turnosAcumulados);

        }
        else
        {
            turnosAcumulados ++;
            //System.out.println("hay " + turnosAcumulados);
        }
        return flag;
    }
}
