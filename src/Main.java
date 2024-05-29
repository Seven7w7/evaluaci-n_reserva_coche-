import java.util.*;

public class Main {
    private static List<Agencia> agencias = new ArrayList<>();
    private static List<Coche> coches = new ArrayList<>();
    private static List<Cliente> clientes = new ArrayList<>();
    private static List<Reserva> reservas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Menú de Opciones:");
            System.out.println("1. CRUD Agencias");
            System.out.println("2. CRUD Automóviles");
            System.out.println("3. CRUD Clientes");
            System.out.println("4. CRUD Reservas");
            System.out.println("5. Listar alquileres de un cliente");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    listarAlquileresDeUnCliente(sc);
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    private static void listarAlquileresDeUnCliente(Scanner sc) {
        System.out.print("Ingrese el código único del cliente: ");
        String codigoUnico = sc.next();
        Cliente cliente = clientes.stream()
                .filter(c -> c.getCodigoUnico().equals(codigoUnico))
                .findFirst()
                .orElse(null);
        if (cliente != null) {
            List<Reserva> reservasCliente = reservas.stream()
                    .filter(r -> r.getCliente().equals(cliente))
                    .toList();
            reservasCliente.forEach(System.out::println);
        } else {
            System.out.println("Cliente no encontrado .");
        }
    }
}
