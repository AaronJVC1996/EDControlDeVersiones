import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //comenzaremos creanndo la liga
        System.out.println("Empiece creando una liga:");
        System.out.println("Escriba el país de la liga:");
        String paisLiga = scanner.nextLine();
        Liga liga = new Liga(paisLiga);
        System.out.println("Liga en " + liga.getPais());
        System.out.println("Número de equipos: " + liga.getNumEquipos());
        //ahora creamos el menu de opciones con un do para que siempre se inicie minimo 1 vez
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
            scanner.nextLine();
            //creamos los cases con los metodos hechos mas adelante
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
                    //saltara esto cuando se inicie un numero que no esta entre estos 6
                    //si tecleamos letras se saldra de el programa
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
        //si la liga no esta llena se creara el equipo, de lo contrario saltara un mensaje de que esta lleno.
        if (liga.getNumEquipos() < liga.getNumMaxEquipos()) {
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
            scanner.nextLine();

            String posicion = null;
            //inicializamos la posicion
            boolean posicionValida = false;
            //la posicion iniciara en false para que pueda entrar el siguiente codigo.
            while (!posicionValida) {
                //Cuando no hay posicion seleccionada añadiremos una
                System.out.println("Indique la posición del jugador (Delantero, Centrocampista, Defensa, Portero):");
                posicion = scanner.nextLine();

                if (posicionValida(posicion)) {
                    posicionValida = true;
                    //validamos si existe la posicion con el metodo posicionValida()
                } else {
                    System.out.println("Posición no válida. Inténtelo de nuevo.");
                    //si no existe la posicion que has escrito saltara este mensaje.
                }
            }
            //si se ha añadido correctamente los requisitos, se añadira el jugador.
            Jugador nuevoJugador = new Jugador(nombreJugador, nacionalidad, edad, posicion);
            //comprobamos si estan lleno de jugadores el equipo
            if (equipo.getNumJugadores() < equipo.getNumMaxJugadores()) {
                equipo.adquirirJugador(nuevoJugador);
                System.out.println("Jugador " + nombreJugador + " insertado en " + nombreEquipo);
            } else {
                System.out.println("El equipo está lleno. No se puede insertar el jugador.");
            }
        } else {
            System.out.println("El equipo indicado no existe.");
        }

    }

    private static boolean posicionValida(String posicion) {
        //es como un enumeration que estamos usando para validar la posicion.
        return posicion.equalsIgnoreCase("DEL") ||
                posicion.equalsIgnoreCase("CTC") ||
                posicion.equalsIgnoreCase("DEF") ||
                posicion.equalsIgnoreCase("POR");
    }
    private static void verLiga(Liga liga) {
        System.out.println("**********COMPOSICIÓN DE LA LIGA*************************");
        System.out.printf("%-25s%-20s%-20s\n", "EQUIPO", "CIUDAD", "NUMERO JUGADORES");
        //nos devolvera solamente los equipos que esten y no los nulls obviamente.
        for (int i = 0; i < liga.getNumEquipos(); i++) {
            Equipo equipo = liga.getListadoEquipos(i);
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
        //cuando el equipo existe iniciara el siguiente codigo.
        if (equipo != null) {
            System.out.println("********* " + equipo.getNombre() + " ****************************");
            System.out.printf("%-15s%-15s%-10s%-10s%-10s\n", "NOMBRE", "POSICIÓN", "EDAD", "NAC", "LESIONADO");
            //recorremos listadejugadores para ver si el jugador existe, si existe se iniciara el siguiente codigo.
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
        //si el equipo existe se iniciara el siguiente codigo
        if (equipo != null) {
            System.out.println("Inserte el nombre del jugador:");
            String nombreJugador = scanner.nextLine();

            Jugador jugador = buscarJugadorEnEquipo(nombreJugador, equipo);
            //si el jugador existe se iniciara el siguiente codigo
            if (jugador != null) {
                equipo.venderJugador(nombreJugador);
                System.out.println("Jugador vendido.");
            } else {
                System.out.println("El jugador no existe.");
                // si el jugador no existe saltara este mensaje
            }
        } else {
            System.out.println("El equipo indicado no existe.");
            //si el equipo no existe saltara este texto.
        }
    }
    private static Jugador buscarJugadorEnEquipo(String nombreJugador, Equipo equipo) {
        //este metodo es un bucle para buscar si existe el jugador o no, acompaña al metodo vender jugador.
        for (int i = 0; i < equipo.ListaJugadores.length; i++) {
            Jugador jugador = equipo.ListaJugadores[i];
            if (jugador != null && jugador.getNombre().equals(nombreJugador)) {
                return jugador;
            }
        }
        return null;
    }
    private static void salir() {
        //este es el metodo para salir del menu y saltara este texto.
        System.out.println("Estas saliendo de esta aplicacion, !!Nos Vemos!!");
    }
}