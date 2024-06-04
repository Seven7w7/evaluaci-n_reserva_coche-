import java.util.*;

public class Agencia {
    private String nombre;
    private String direccion;
    private List<Cliente> listaClientes;
    private List<Coche> listaCoches;
    private List<Reserva> listaReservas;

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public List<Cliente> getListaClientes() { return listaClientes; }
    public void setListaClientes(List<Cliente> listaClientes) { this.listaClientes = listaClientes; }

    public List<Coche> getListaCoches() { return listaCoches; }
    public void setListaCoches(List<Coche> listaCoches) { this.listaCoches = listaCoches; }

    public List<Reserva> getListaReservas() { return listaReservas; }
    public void setListaReservas(List<Reserva> listaReservas) { this.listaReservas = listaReservas; }

    public Agencia(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.listaClientes = new ArrayList<>();
        this.listaCoches = new ArrayList<>();
        this.listaReservas = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Agencia{" +
                "nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", listaClientes=" + listaClientes +
                ", listaCoches=" + listaCoches +
                ", listaReservas=" + listaReservas +
                '}';
    }
}