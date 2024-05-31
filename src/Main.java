import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
            System.out.println("6. Realizar una reserva");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    crudAgencias(sc);
                    break;
                case 2:
                    crudAutomoviles(sc);
                    break;
                case 3:
                    crudClientes(sc);
                    break;
                case 4:
                    crudReservas(sc);
                    break;
                case 5:
                    listarAlquileresDeUnCliente(sc);
                    break;
                case 6:
                    realizarReserva(sc);
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
            System.out.println("Cliente no encontrado.");
        }
    }

    private static void crudAgencias(Scanner sc) {
        // Implementar CRUD para Agencias
    }

    private static void crudAutomoviles(Scanner sc) {
        // Implementar CRUD para Automóviles
    }

    private static void crudClientes(Scanner sc) {
        int opcion;
        do {
            System.out.println("Menú CRUD Clientes:");
            System.out.println("1. Crear Cliente");
            System.out.println("2. Leer Clientes");
            System.out.println("3. Actualizar Cliente");
            System.out.println("4. Eliminar Cliente");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    crearCliente(sc);
                    break;
                case 2:
                    leerClientes();
                    break;
                case 3:
                    actualizarCliente(sc);
                    break;
                case 4:
                    eliminarCliente(sc);
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    private static void crearCliente(Scanner sc) {
        System.out.print("Ingrese DNI: ");
        String DNI = sc.next();
        System.out.print("Ingrese nombre: ");
        String nombre = sc.next();
        System.out.print("Ingrese dirección: ");
        String direccion = sc.next();
        System.out.print("Ingrese teléfono: ");
        String telefono = sc.next();
        System.out.print("Ingrese código único: ");
        String codigoUnico = sc.next();
        Cliente cliente = new Cliente(DNI, nombre, direccion, telefono, codigoUnico);
        clientes.add(cliente);
        System.out.println("Cliente creado exitosamente.");
    }

    private static void leerClientes() {
        clientes.forEach(System.out::println);
    }

    private static void actualizarCliente(Scanner sc) {
        System.out.print("Ingrese el código único del cliente a actualizar: ");
        String codigoUnico = sc.next();
        Cliente cliente = clientes.stream()
                .filter(c -> c.getCodigoUnico().equals(codigoUnico))
                .findFirst()
                .orElse(null);
        if (cliente != null) {
            System.out.print("Ingrese nuevo DNI: ");
            cliente.setDNI(sc.next());
            System.out.print("Ingrese nuevo nombre: ");
            cliente.setNombre(sc.next());
            System.out.print("Ingrese nueva dirección: ");
            cliente.setDireccion(sc.next());
            System.out.print("Ingrese nuevo teléfono: ");
            cliente.setTelefono(sc.next());
            System.out.println("Cliente actualizado exitosamente.");
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    private static void eliminarCliente(Scanner sc) {
        System.out.print("Ingrese el código único del cliente a eliminar: ");
        String codigoUnico = sc.next();
        Cliente cliente = clientes.stream()
                .filter(c -> c.getCodigoUnico().equals(codigoUnico))
                .findFirst()
                .orElse(null);
        if (cliente != null) {
            clientes.remove(cliente);
            System.out.println("Cliente eliminado exitosamente.");
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    private static void crudReservas(Scanner sc) {
        // Implementar CRUD para Reservas
    }

    private static void realizarReserva(Scanner sc) {
        System.out.print("Ingrese el código único del cliente: ");
        String codigoUnico = sc.next();
        Cliente cliente = clientes.stream()
                .filter(c -> c.getCodigoUnico().equals(codigoUnico))
                .findFirst()
                .orElse(null);
        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        System.out.print("Ingrese el nombre de la agencia: ");
        String nombreAgencia = sc.next();
        Agencia agencia = agencias.stream()
                .filter(a -> a.getNombre().equals(nombreAgencia))
                .findFirst()
                .orElse(null);
        if (agencia == null) {
            System.out.println("Agencia no encontrada.");
            return;
        }

        List<Coche> cochesReservados = new ArrayList<>();
        System.out.println("Ingrese las matrículas de los coches a reservar (Ingrese 'fin' para terminar):");
        while (true) {
            System.out.print("Matrícula: ");
            String matricula = sc.next();
            if (matricula.equals("fin")) break;
            Coche coche = coches.stream()
                    .filter(c -> c.getMatricula().equals(matricula))
                    .findFirst()
                    .orElse(null);
            if (coche == null) {
                System.out.println("Coche no encontrado.");
            } else {
                cochesReservados.add(coche);
            }
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        System.out.print("Ingrese la fecha de inicio (YYYY-MM-DD): ");
        String fechaInicioStr = sc.next();
        LocalDate fechaInicio = LocalDate.parse(fechaInicioStr, formatter);

        System.out.print("Ingrese la fecha de fin (YYYY-MM-DD): ");
        String fechaFinStr = sc.next();
        LocalDate fechaFin = LocalDate.parse(fechaFinStr, formatter);

        System.out.print("Ingrese los litros de gasolina: ");
        double litrosGasolina = sc.nextDouble();

        System.out.print("Ingrese el precio total: ");
        double precioTotal = sc.nextDouble();

        Reserva reserva = new Reserva(fechaInicio, fechaFin, precioTotal, false, cliente, agencia, litrosGasolina);
        reserva.setCoches(cochesReservados);
        reservas.add(reserva);
        cliente.realizarReserva(reserva);
        agencia.getListaReservas().add(reserva);

        System.out.println("Reserva realizada exitosamente.");
    }
}
