public class Coche {
    private String matricula;
    private String modelo;
    private String color;
    private String marca;
    private String garaje;
    private Agencia agencia;


    public String getMatricula() { return matricula; }
    public void setMatricula(String matricula) { this.matricula = matricula; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getGaraje() { return garaje; }
    public void setGaraje(String garaje) { this.garaje = garaje; }

    public Agencia getAgencia() { return agencia; }
    public void setAgencia(Agencia agencia) { this.agencia = agencia; }

    public Coche(String matricula, String modelo, String color, String marca, String garaje, Agencia agencia) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.color = color;
        this.marca = marca;
        this.garaje = garaje;
        this.agencia = agencia;
    }


    public void asignarACliente(Cliente cliente) {

    }

    @Override
    public String toString() {
        return "Coche{" + "matricula=" + matricula + ", modelo=" + modelo + ", color=" + color + ", marca=" + marca + ", garaje=" + garaje + ", agencia=" + agencia + '}';
    }
}
