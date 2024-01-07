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
}