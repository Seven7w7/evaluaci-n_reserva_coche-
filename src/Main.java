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
        int opcion;
        do {
            System.out.println("Menú CRUD Agencias:");
            System.out.println("1. Crear Agencia");
            System.out.println("2. Leer Agencias");
            System.out.println("3. Actualizar Agencia");
            System.out.println("4. Eliminar Agencia");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            try {
                opcion = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error: Input debe ser un número entero.");
                sc.next();
                opcion = -1;
            }

            switch (opcion) {
                case 1:
                    crearAgencia(sc);
                    break;
                case 2:
                    leerAgencias();
                    break;
                case 3:
                    actualizarAgencia(sc);
                    break;
                case 4:
                    eliminarAgencia(sc);
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }


    private static void crearAgencia(Scanner sc) {
        System.out.print("Ingrese nombre: ");
        String nombre = sc.next();
        sc.nextLine(); // Consumir el carácter de nueva línea pendiente
        System.out.print("Ingrese dirección: ");
        String direccion = sc.nextLine(); // Utilizar nextLine() para leer la dirección completa
        Agencia agencia = new Agencia(nombre, direccion);
        agencias.add(agencia);
        System.out.println("Agencia creada exitosamente.");
    }

    private static void leerAgencias() {
        agencias.forEach(System.out::println);
    }

    private static void actualizarAgencia(Scanner sc) {
        System.out.print("Ingrese el nombre de la agencia a actualizar: ");
        String nombre = sc.next();
        Agencia agencia = agencias.stream()
                .filter(a -> a.getNombre().equals(nombre))
                .findFirst()
                .orElse(null);
        if (agencia != null) {
            System.out.print("Ingrese nueva dirección: ");
            agencia.setDireccion(sc.next());
            System.out.println("Agencia actualizada exitosamente.");
        } else {
            System.out.println("Agencia no encontrada.");
        }
    }

    private static void eliminarAgencia(Scanner sc) {
        System.out.print("Ingrese el nombre de la agencia a eliminar: ");
        String nombre = sc.next();
        Agencia agencia = agencias.stream()
                .filter(a -> a.getNombre().equals(nombre))
                .findFirst()
                .orElse(null);
        if (agencia != null) {
            agencias.remove(agencia);
            System.out.println("Agencia eliminada exitosamente.");
        } else {
            System.out.println("Agencia no encontrada.");
        }
    }

    private static void crudAutomoviles(Scanner sc) {
        int opcion;
        do {
            System.out.println("Menú CRUD Automóviles:");
            System.out.println("1. Crear Automóvil");
            System.out.println("2. Leer Automóviles");
            System.out.println("3. Actualizar Automóvil");
            System.out.println("4. Eliminar Automóvil");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    crearAutomovil(sc);
                    break;
                case 2:
                    leerAutomoviles();
                    break;
                case 3:
                    actualizarAutomovil(sc);
                    break;
                case 4:
                    eliminarAutomovil(sc);
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    private static void crearAutomovil(Scanner sc) {
        System.out.print("Ingrese matrícula: ");
        String matricula = sc.next();
        System.out.print("Ingrese modelo: ");
        String modelo = sc.next();
        System.out.print("Ingrese color: ");
        String color = sc.next();
        System.out.print("Ingrese marca: ");
        String marca = sc.next();
        System.out.print("Ingrese nombre de la agencia: ");
        String nombreAgencia = sc.next();
        Agencia agencia = agencias.stream()
                .filter(a -> a.getNombre().equals(nombreAgencia))
                .findFirst()
                .orElse(null);
        if (agencia == null) {
            System.out.println("Agencia no encontrada. Automóvil no puede ser creado.");
            return;
        }
        Coche coche = new Coche(matricula, modelo, color, marca, nombreAgencia, agencia);
        coches.add(coche);
        agencia.getListaCoches().add(coche);
        System.out.println("Automóvil creado exitosamente.");
    }

    private static void leerAutomoviles() {
        coches.forEach(System.out::println);
    }

    private static void actualizarAutomovil(Scanner sc) {
        System.out.print("Ingrese la matrícula del automóvil a actualizar: ");
        String matricula = sc.next();
        Coche coche = coches.stream()
                .filter(c -> c.getMatricula().equals(matricula))
                .findFirst()
                .orElse(null);
        if (coche != null) {
            System.out.print("Ingrese nuevo modelo: ");
            coche.setModelo(sc.next());
            System.out.print("Ingrese nuevo color: ");
            coche.setColor(sc.next());
            System.out.print("Ingrese nueva marca: ");
            coche.setMarca(sc.next());
            System.out.println("Automóvil actualizado exitosamente.");
        } else {
            System.out.println("Automóvil no encontrado.");
        }
    }

    private static void eliminarAutomovil(Scanner sc) {
        System.out.print("Ingrese la matrícula del automóvil a eliminar: ");
        String matricula = sc.next();
        Coche coche = coches.stream()
                .filter(c -> c.getMatricula().equals(matricula))
                .findFirst()
                .orElse(null);
        if (coche != null) {
            coches.remove(coche);
            coche.getAgencia().getListaCoches().remove(coche);
            System.out.println("Automóvil eliminado exitosamente.");
        } else {
            System.out.println("Automóvil no encontrado.");
        }
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
        int opcion;
        do {
            System.out.println("Menú CRUD Reservas:");
            System.out.println("1. Crear Reserva");
            System.out.println("2. Leer Reservas");
            System.out.println("3. Actualizar Reserva");
            System.out.println("4. Eliminar Reserva");
            System.out.println("0. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    crearReserva(sc);
                    break;
                case 2:
                    leerReservas();
                    break;
                case 3:
                    actualizarReserva(sc);
                    break;
                case 4:
                    eliminarReserva(sc);
                    break;
                case 0:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    private static void crearReserva(Scanner sc) {
        realizarReserva(sc);
    }

    private static void leerReservas() {
        reservas.forEach(System.out::println);
    }

    private static void actualizarReserva(Scanner sc) {
        System.out.print("Ingrese el código único del cliente de la reserva a actualizar: ");
        String codigoUnico = sc.next();
        Cliente cliente = clientes.stream()
                .filter(c -> c.getCodigoUnico().equals(codigoUnico))
                .findFirst()
                .orElse(null);
        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        System.out.print("Ingrese la fecha de inicio de la reserva (YYYY-MM-DD): ");
        String fechaInicioStr = sc.next();
        LocalDate fechaInicio = LocalDate.parse(fechaInicioStr);

        Reserva reserva = reservas.stream()
                .filter(r -> r.getCliente().equals(cliente) && r.getFechaInicio().equals(fechaInicio))
                .findFirst()
                .orElse(null);
        if (reserva != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            System.out.print("Ingrese nueva fecha de fin (YYYY-MM-DD): ");
            String fechaFinStr = sc.next();
            LocalDate fechaFin = LocalDate.parse(fechaFinStr, formatter);
            reserva.setFechaFin(fechaFin);

            System.out.print("Ingrese nuevo precio total: ");
            double precioTotal = sc.nextDouble();
            reserva.setPrecioTotal(precioTotal);

            System.out.print("Ingrese nuevos litros de gasolina: ");
            double litrosGasolina = sc.nextDouble();
            reserva.setLitrosGasolina(litrosGasolina);

            System.out.print("¿Coche entregado? (true/false): ");
            boolean cocheEntregado = sc.nextBoolean();
            reserva.setCocheEntregado(cocheEntregado);

            System.out.println("Reserva actualizada exitosamente.");
        } else {
            System.out.println("Reserva no encontrada.");
        }
    }

    private static void eliminarReserva(Scanner sc) {
        System.out.print("Ingrese el código único del cliente de la reserva a eliminar: ");
        String codigoUnico = sc.next();
        Cliente cliente = clientes.stream()
                .filter(c -> c.getCodigoUnico().equals(codigoUnico))
                .findFirst()
                .orElse(null);
        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        System.out.print("Ingrese la fecha de inicio de la reserva (YYYY-MM-DD): ");
        String fechaInicioStr = sc.next();
        LocalDate fechaInicio = LocalDate.parse(fechaInicioStr);

        Reserva reserva = reservas.stream()
                .filter(r -> r.getCliente().equals(cliente) && r.getFechaInicio().equals(fechaInicio))
                .findFirst()
                .orElse(null);
        if (reserva != null) {
            reservas.remove(reserva);
            cliente.getReservas().remove(reserva);
            reserva.getAgencia().getListaReservas().remove(reserva);
            System.out.println("Reserva eliminada exitosamente.");
        } else {
            System.out.println("Reserva no encontrada.");
        }
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
