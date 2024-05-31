import java.time.LocalDate;
import java.util.*;

public class Reserva {
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private double precioTotal;
    private boolean cocheEntregado;
    private Cliente cliente;
    private List<Coche> coches;
    private Agencia agencia;
    private double litrosGasolina;

    public LocalDate getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(LocalDate fechaInicio) { this.fechaInicio = fechaInicio; }

    public LocalDate getFechaFin() { return fechaFin; }
    public void setFechaFin(LocalDate fechaFin) { this.fechaFin = fechaFin; }

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

    public double getLitrosGasolina() { return litrosGasolina; }
    public void setLitrosGasolina(double litrosGasolina) { this.litrosGasolina = litrosGasolina; }

    public Reserva(LocalDate fechaInicio, LocalDate fechaFin, double precioTotal, boolean cocheEntregado, Cliente cliente, Agencia agencia, double litrosGasolina) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.precioTotal = precioTotal;
        this.cocheEntregado = cocheEntregado;
        this.cliente = cliente;
        this.coches = new ArrayList<>();
        this.agencia = agencia;
        this.litrosGasolina = litrosGasolina;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", precioTotal=" + precioTotal +
                ", cocheEntregado=" + cocheEntregado +
                ", cliente=" + cliente +
                ", coches=" + coches +
                ", agencia=" + agencia +
                ", litrosGasolina=" + litrosGasolina +
                '}';
    }
}
