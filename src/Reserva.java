import java.util.*;

public class Reserva {
    private Date fechaInicio;
    private Date fechaFin;
    private double precioTotal;
    private boolean cocheEntregado;
    private Cliente cliente;
    private List<Coche> coches;
    private Agencia agencia;


    public Date getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(Date fechaInicio) { this.fechaInicio = fechaInicio; }

    public Date getFechaFin() { return fechaFin; }
    public void setFechaFin(Date fechaFin) { this.fechaFin = fechaFin; }

    public double getPrecioTotal() { return precioTotal; }
    public void setPrecioTotal(double precioTotal) { this.precioTotal = precioTotal; }

    public boolean isCocheEntregado() { return cocheEntregado; }
    public void setCocheEntregado(boolean cocheEntregado) { this.cocheEntregado = cocheEntregado; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public List<Coche> getCoches() { return coches; }
    public void setCoches(List<Coche> coches) { this.coches = coches; }

    public Agencia getAgencia() { return agencia; }
    public void setAgencia(Agencia agencia) { this.agencia = agencia; }

    public Reserva(Date fechaInicio, Date fechaFin, double precioTotal, boolean cocheEntregado, Cliente cliente, Agencia agencia) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.precioTotal = precioTotal;
        this.cocheEntregado = cocheEntregado;
        this.cliente = cliente;
        this.coches = new ArrayList<>();
        this.agencia = agencia;
    }


    public void registrarReserva() {

    }

    @Override
    public String toString() {
        return "Reserva{" + "fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", precioTotal=" + precioTotal + ", cocheEntregado=" + cocheEntregado + ", cliente=" + cliente + ", coches=" + coches + ", agencia=" + agencia + '}';
    }
}
