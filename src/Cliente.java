import java.util.*;

public class Cliente {
    private String DNI;
    private String nombre;
    private String direccion;
    private String telefono;
    private String codigoUnico;
    private Cliente clienteAvalador;
    private List<Reserva> reservas;

    public String getDNI() { return DNI; }
    public void setDNI(String DNI) { this.DNI = DNI; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getCodigoUnico() { return codigoUnico; }
    public void setCodigoUnico(String codigoUnico) { this.codigoUnico = codigoUnico; }

    public Cliente getClienteAvalador() { return clienteAvalador; }
    public void setClienteAvalador(Cliente clienteAvalador) { this.clienteAvalador = clienteAvalador; }

    public List<Reserva> getReservas() { return reservas; }
    public void setReservas(List<Reserva> reservas) { this.reservas = reservas; }

    public Cliente(String DNI, String nombre, String direccion, String telefono, String codigoUnico) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.codigoUnico = codigoUnico;
        this.reservas = new ArrayList<>();
    }

    public void realizarReserva(Reserva reserva) {
        this.reservas.add(reserva);
    }

    @Override
    public String toString() {
        return "Cliente{" + "DNI=" + DNI + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono + ", codigoUnico=" + codigoUnico + '}';
    }
}
