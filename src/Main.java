import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Empiece creando una liga:");
        System.out.println("Escriba el país de la liga:");
        String paisLiga = scanner.nextLine();
        Liga liga = new Liga(paisLiga);
        System.out.println("Liga en " + liga.getPais());
        System.out.println("Número de equipos: " + liga.getNumEquipos());
        int opcion;
        do {
            System.out.println("MENU DE LA LIGA");
            System.out.println("1- Insertar Equipo");
            System.out.println("2- Insertar Jugador");
            System.out.println("3- Ver equipos de la liga");
            System.out.println("4- Ver jugadores de un equipo.");
            System.out.println("5- Vender jugador");
            System.out.println("6- Salir");
            System.out.println("Ingrese la opción deseada:");

            opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir el salto de línea después de nextInt()

            switch (opcion) {
                case 1:
                    insertarEquipo(liga);
                    break;
                case 2:
                    insertarJugador(liga);
                    break;
                case 3:
                    verLiga(liga);
                    break;
                case 4:
                    verJugadores(liga);
                    break;
                case 5:
                    venderJugador(liga);
                    break;
                case 6:
                    salir();
                    break;

                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }

        } while (opcion != 6);
    }
    private static void insertarEquipo(Liga liga) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserte el nombre del equipo:");
        String nombreEquipo = scanner.nextLine();

        System.out.println("Inserte la ciudad del equipo:");
        String ciudadEquipo = scanner.nextLine();

        Equipo nuevoEquipo = new Equipo(nombreEquipo, ciudadEquipo);

        if (liga.getNumEquipos() < liga.numMaxEquipos) {
            liga.añadirEquipo(nuevoEquipo);
            System.out.println("Equipo " + nombreEquipo + " insertado.");
        } else {
            System.out.println("La liga está llena.");
        }
    }
    private static void insertarJugador(Liga liga) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Indique el nombre del equipo donde quiere insertar el jugador:");
        String nombreEquipo = scanner.nextLine();

        Equipo equipo = liga.getEquipo(nombreEquipo);

        if (equipo != null) {
            System.out.println("Indique el nombre del jugador:");
            String nombreJugador = scanner.nextLine();

            System.out.println("Indique la nacionalidad del jugador:");
            String nacionalidad = scanner.nextLine();

            System.out.println("Indique la edad del jugador:");
            int edad = scanner.nextInt();
            scanner.nextLine();  // Consumir la nueva línea después de la edad

            String posicion = null;
            boolean posicionValida = false;

            while (!posicionValida) {
                System.out.println("Indique la posición del jugador (Delantero, Centrocampista, Defensa, Portero):");
                posicion = scanner.nextLine();

                if (posicionValida(posicion)) {
                    posicionValida = true;
                } else {
                    System.out.println("Posición no válida. Inténtelo de nuevo.");
                }
            }

            Jugador nuevoJugador = new Jugador(nombreJugador, nacionalidad, edad, posicion);

            if (equipo.getNumJugadores() < equipo.numMaxJugadores) {
                equipo.adquirirJugador(nuevoJugador);
                System.out.println("Jugador " + nombreJugador + " insertado en " + nombreEquipo);
            } else {
                System.out.println("El equipo está lleno. No se puede insertar el jugador.");
            }
        } else {
            System.out.println("El equipo indicado no existe.");
        }

        // Cerrar el scanner al final
        scanner.close();
    }

    private static boolean posicionValida(String posicion) {
        // Verificar si la posición es una de las cuatro válidas
        return posicion.equalsIgnoreCase("Delantero") ||
                posicion.equalsIgnoreCase("Centrocampista") ||
                posicion.equalsIgnoreCase("Defensa") ||
                posicion.equalsIgnoreCase("Portero");
    }
    private static void verLiga(Liga liga) {
        System.out.println("**********COMPOSICIÓN DE LA LIGA*************************");
        System.out.printf("%-25s%-20s%-20s\n", "EQUIPO", "CIUDAD", "NUMERO JUGADORES");

        for (int i = 0; i < liga.ListadoEquipos.length; i++) {
            Equipo equipo = liga.ListadoEquipos[i];
            if (equipo != null) {
                System.out.printf("%-25s%-20s%-20d\n", equipo.getNombre(), equipo.getCiudad(), equipo.getNumJugadores());
            }
        }
        System.out.println("*********************************************************");
    }
    private static void verJugadores(Liga liga) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Indique el equipo que quiere visualizar:");

        String nombreEquipo = scanner.nextLine();

        Equipo equipo = liga.getEquipo(nombreEquipo);

        if (equipo != null) {
            System.out.println("********* " + equipo.getNombre() + " ****************************");
            System.out.printf("%-15s%-15s%-10s%-10s%-10s\n", "NOMBRE", "POSICIÓN", "EDAD", "NAC", "LESIONADO");

            for (Jugador jugador : equipo.ListaJugadores) {
                if (jugador != null) {
                    System.out.printf("%-15s%-15s%-10d%-10s%-10s\n",
                            jugador.getNombre(), jugador.getPosicion(), jugador.getEdad(),
                            jugador.getNacionalidad(), jugador.getLesionado() ? "SI" : "NO");
                }
            }

            System.out.println("*********************************************");
        } else {
            System.out.println("El equipo indicado no existe.");
        }
    }
    private static void venderJugador(Liga liga) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserte el nombre del equipo donde quiere vender el jugador:");
        String nombreEquipo = scanner.nextLine();

        Equipo equipo = liga.getEquipo(nombreEquipo);

        if (equipo != null) {
            System.out.println("Inserte el nombre del jugador:");
            String nombreJugador = scanner.nextLine();

            Jugador jugador = buscarJugadorEnEquipo(nombreJugador, equipo);

            if (jugador != null) {
                equipo.venderJugador(nombreJugador);
                System.out.println("Jugador vendido.");
            } else {
                System.out.println("El jugador no existe.");
            }
        } else {
            System.out.println("El equipo indicado no existe.");
        }
    }
    private static Jugador buscarJugadorEnEquipo(String nombreJugador, Equipo equipo) {
        for (int i = 0; i < equipo.ListaJugadores.length; i++) {
            Jugador jugador = equipo.ListaJugadores[i];
            if (jugador != null && jugador.getNombre().equals(nombreJugador)) {
                return jugador;
            }
        }
        return null;
    }
    private static void salir() {
        System.out.println("Estas saliendo de esta aplicacion, !!Nos Vemos!!");
    }
}