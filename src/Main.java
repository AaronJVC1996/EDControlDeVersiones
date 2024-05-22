// Aaron Jaffet Vasquez Carrera 1B DAM
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Scanner para escribir en el menu
        //Comenzaremos creando la liga
        System.out.println("Empiece creando una liga:");
        System.out.println("Escriba el país de la liga:");
        String paisLiga = scanner.nextLine(); // Variable que guardara lo que escribamos para el nombre de liga
        Liga liga = new Liga(paisLiga); // Se crea un objeto Liga con la variable que lleva el nombre escrito antes
        System.out.println("Liga en " + liga.getPais()); // Llamamos al get del nombre de liga para llamarlo a pantalla
        System.out.println("Número de equipos: " + liga.getNumEquipos()); // Llamamos al getter de numero de equipos para saber el numero de equipos existentes

        int opcion; // Ahora creamos el menu de opciones con un do para que siempre se inicie minimo 1 vez
        do { // Con do para que almenos se inicie una vez
            System.out.println("MENU DE LA LIGA");
            System.out.println("1- Insertar Equipo");
            System.out.println("2- Insertar Jugador");
            System.out.println("3- Ver equipos de la liga");
            System.out.println("4- Ver jugadores de un equipo.");
            System.out.println("5- Vender jugador");
            System.out.println("6- Salir");
            System.out.println("Ingrese la opción deseada:");

            opcion = scanner.nextInt(); // Variable que guardara lo que escribamos en esta parte del codigo

            switch (opcion) { // Segun la opcion que hayamos escrito iniciara cierto metodo.
                case 1: // Si presionamos 1
                    insertarEquipo(liga);
                    break;
                case 2: // Si presionamos 2
                    insertarJugador(liga);
                    break;
                case 3: // Si presionamos 3
                    verLiga(liga);
                    break;
                case 4: // Si presionamos 4
                    verJugadores(liga);
                    break;
                case 5: // Si presionamos 5
                    venderJugador(liga);
                    break;
                case 6: // Si presionamos 6
                    salir();
                    break;

                default: // Si presionamos algo distinto a alguna de los anteriores
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
                    // Saltara esto cuando se inicie un numero que no esta entre estos 6
                    // Si tecleamos letras se saldra de el programa
            }

        } while (opcion != 6); // Solo saldra cuando el numero sea 6, si es otro este seguira ejecutandose en bucle.
    }
    private static void insertarEquipo(Liga liga) { // Metodo para crear un equipo en la liga
        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserte el nombre del equipo:");
        String nombreEquipo = scanner.nextLine(); // Creamos la variable para guardar el nombre del equipo que escribamos

        System.out.println("Inserte la ciudad del equipo:");
        String ciudadEquipo = scanner.nextLine(); // Creamos la variable para guardar la ciudad del equipo que estamos creando

        Equipo nuevoEquipo = new Equipo(nombreEquipo, ciudadEquipo); // Creamos el objeto equipo con las variables anteriores
        if (liga.getNumEquipos() < liga.getNumMaxEquipos()) { // Si la liga no esta llena se creara el equipo
            liga.añadirEquipo(nuevoEquipo); // Creando Equipo...
            System.out.println("Equipo " + nombreEquipo + " insertado."); // Aviso de texto con su nombre del equipo recien creado
        } else {
            System.out.println("La liga está llena."); // Si la liga esta llena saltara un mensaje de que esta lleno
        }
    }
    private static void insertarJugador(Liga liga) { // Metodo para añadir un jugador a un equipo
        Scanner scanner = new Scanner(System.in);

        System.out.println("Indique el nombre del equipo donde quiere insertar el jugador:");
        String nombreEquipo = scanner.nextLine(); // Nombre del equipo donde queremos crear el jugador

        Equipo equipo = liga.getEquipo(nombreEquipo); // Entrando al equipo escrito...

        if (equipo != null) { // Si el equipo escrito existe seguira este codigo...
            System.out.println("Indique el nombre del jugador:");
            String nombreJugador = scanner.nextLine(); // Escribimos el nombre del jugador que estamos añadiendo al equipo

            System.out.println("Indique la nacionalidad del jugador:");
            String nacionalidad = scanner.nextLine(); // Escribimos la nacionalidad del jugador que estamos añadiendo al equipo

            System.out.println("Indique la edad del jugador:");
            int edad = scanner.nextInt(); // Escribimos la edad del jugador que estamos añadiendo al equipo
            scanner.nextLine();

            String posicion = null; // Creamos la variable de posicion para añadir una
            //inicializamos la posicion
            boolean posicionValida = false; // Indicamos que aun no se le ha otorgado ninguna posicion
            //la posicion iniciara en false para que pueda entrar el siguiente codigo.
            while (!posicionValida) { // Si no tiene posicion inicia este metodo creado mas abajo para validar entre 4 posiciones existentes
                System.out.println("Indique la posición del jugador (DEL, CTC, DEF, POR):");
                posicion = scanner.nextLine();
                // Tenemos un metodo posicionValida() la cual hace que al escribir algo distinto a lo dado, dara false
                // Si escribimos una de las 4 opciones como nos las da escritas o en minusculas, dara true
                if (posicionValida(posicion)) {
                    posicionValida = true;
                    // Validamos si existe la posicion con el metodo posicionValida()
                } else {
                    System.out.println("Posición no válida. Inténtelo de nuevo.");
                    // Si no existe la posicion que has escrito saltara este mensaje.
                }
            }// Si se ha añadido correctamente los requisitos, se añadira el jugador.

            Jugador nuevoJugador = new Jugador(nombreJugador, nacionalidad, edad, posicion); // Crea el jugador con los datos dados.

            if (equipo.getNumJugadores() < equipo.getNumMaxJugadores()) { // Comprobamos si estan lleno de jugadores el equipo
                equipo.adquirirJugador(nuevoJugador); // Si no esta lleno se creara el jugador
                System.out.println("Jugador " + nombreJugador + " insertado en " + nombreEquipo); // Indica los datos del jugador ya creado
            } else {
                System.out.println("El equipo está lleno. No se puede insertar el jugador."); // Esto salta si el equipo esta lleno de jugadores
            }
        } else {
            System.out.println("El equipo indicado no existe."); // Esto salta si el equipo escrito no existe
        }

    }

    private static boolean posicionValida(String posicion) { // Metodo usado para la posicion cuando añades un jugador
        // Es como un enumeration que estamos usando para validar la posicion.
        return posicion.equalsIgnoreCase("DEL") ||
                posicion.equalsIgnoreCase("CTC") ||
                posicion.equalsIgnoreCase("DEF") ||
                posicion.equalsIgnoreCase("POR");
    }
    private static void verLiga(Liga liga) { // Con este metodo veremos los equipos creados en la liga
        System.out.println("**********COMPOSICIÓN DE LA LIGA*************************");
        System.out.printf("%-25s%-20s%-20s\n", "EQUIPO", "CIUDAD", "NUMERO JUGADORES");
        // PrintFormat para añadir separaciones bien hechas, saltos de linea puestos correctamente \nº
        for (int i = 0; i < liga.getNumEquipos(); i++) { // Recorremos los equipos existentes
            Equipo equipo = liga.getListadoEquipos(i); // Recorrera todos los equipos pero solo podran salir a pantalla los existentes
            if (equipo != null) { // Solo los equipos existentes saldran en pantalla, los nulls no saldran en pantalla obviamente
                System.out.printf("%-25s%-20s%-20d\n", equipo.getNombre(), equipo.getCiudad(), equipo.getNumJugadores());
            } // Aqui esta las llamadas a los getters con la informacion del equipo que saldra en pantalla
        }
        System.out.println("*********************************************************");
    }
    private static void verJugadores(Liga liga) { // Este metodo nos hara ver los jugadores de un equipo
        Scanner scanner = new Scanner(System.in);
        System.out.println("Indique el equipo que quiere visualizar:");
        String nombreEquipo = scanner.nextLine(); // Escribiremos el nombre del equipo y se guardara en una variable
        Equipo equipo = liga.getEquipo(nombreEquipo); // Hacemos que equipo sea el del nombre que hayamos escrito
        if (equipo != null) { // Cuando el equipo existe iniciara el siguiente codigo.
            System.out.println("********* " + equipo.getNombre() + " ****************************");
            System.out.printf("%-15s%-15s%-10s%-10s%-10s\n", "NOMBRE", "POSICIÓN", "EDAD", "NAC", "LESIONADO");
            // Recorremos ListaJugadores para ver si el jugador existe, si existe se iniciara el siguiente codigo.
            for (int i = 0; i < equipo.getNumMaxJugadores(); i++) { // Recorremos toda la lista de jugadores del equipo
                Jugador jugador = equipo.getListaJugadoresPos(i); // Tendremos el objeto jugador con cada jugador del equipo
                if (jugador != null) { // Solo los jugadores existentes saldran en pantalla
                    System.out.printf("%-15s%-15s%-10d%-10s%-10s\n",
                            jugador.getNombre(), jugador.getPosicion(), jugador.getEdad(),
                            jugador.getNacionalidad(), jugador.getLesionado() ? "SI" : "NO");
                }           // Datos del jugador llamado actualmente, el true y el false reciben el nombre de Si y No
            }

            System.out.println("*********************************************");
        } else {
            System.out.println("El equipo indicado no existe."); // Si el nombre del equipo dado no existe salta este mensaje
        }
    }
    private static void venderJugador(Liga liga) { // Este metodo es para vender o borrar un jugador
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserte el nombre del equipo donde quiere vender el jugador:");
        String nombreEquipo = scanner.nextLine(); // Creamos la variable con el nombre del equipo que escribamos
        Equipo equipo = liga.getEquipo(nombreEquipo); // Hacemos que equipo sea el del nombre que hayamos escrito

        if (equipo != null) { // Si el equipo existe se iniciara el siguiente codigo
            System.out.println("Inserte el nombre del jugador:");
            String nombreJugador = scanner.nextLine();
            Jugador jugador = buscarJugadorEnEquipo(nombreJugador, equipo); // Metodo para comprobar que el jugador existe en este equipo

            if (jugador != null) { // Si el jugador existe se iniciara el siguiente codigo
                equipo.venderJugador(nombreJugador); // Volvera a este jugador null y movera todos los demas jugadores para que no haya nulls entremedias
                System.out.println("Jugador vendido.");
            }
            else { // Si el jugador no existe
                System.out.println("El jugador no existe.");
                // si el jugador no existe saltara este mensaje
            }
        }
        else { // Si el equipo escrito no existe
            System.out.println("El equipo indicado no existe.");
        }
    }
    private static Jugador buscarJugadorEnEquipo(String nombreJugador, Equipo equipo) { // Metodo para validar si el jugador existe
        // Este metodo es un bucle para buscar si existe el jugador o no, acompaña al metodo vender jugador.
        for (int i = 0; i < equipo.getNumJugadores(); i++) { // Recorremos la lista de jugadores existentes
            Jugador jugador = equipo.getListaJugadoresPos(i); // Nos colocamos en las posiciones de los jugadores
            if (jugador != null && jugador.getNombre().equals(nombreJugador)) { // Y si el nombre y el equipo escrito existen en esa lista, retornara al jugador
                return jugador;
            }
        }
        return null; // Si el jugador no esta en la lista sera null
    }
    private static void salir() { // Metodo para salir del programa (Mas que nada es un mensaje)
        // Este es el metodo para salir del menu y saltara este texto.
        System.out.println("Estas saliendo de esta aplicacion, !!Hasta luego!!");
    }
}


//Este es un comentario hecho por Aaron