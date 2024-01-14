public class Equipo {
    private String Nombre;
    private String Ciudad;
    private final int numMaxJugadores = 22;
    private Jugador[] ListaJugadores;

    public Equipo (String nombr, String ciuda){
        Nombre = nombr;
        Ciudad = ciuda;
        ListaJugadores = new Jugador[numMaxJugadores];
        // Al crear una lista de jugadores tiene como maximo de jugadores numMaxJugadores que serian 22
    }
    public String getNombre (){ // Este es el get para el nombre del Equipo
        return Nombre;
    }
    public String getCiudad(){ // Este es el get para la ciudad del Equipo
        return Ciudad;
    }
    public int getNumJugadores(){ // Este es el get de numero de Jugadores registrados, no cuenta los espacios vacios
        int contador = 0;
        for (int i = 0; i < ListaJugadores.length; i++) {
            if (ListaJugadores[i] != null) {
                // Recorremos lista de jugadores y si no es null, osea el jugador existe,
                // se añade +1 al contador de este metodo.
                contador++;
            }
        }
        return contador; // Retorna los jugadores contador existentes, retornara un int.
    }
    public void adquirirJugador (Jugador jugador){ // Este es el metodo para Añadir un jugador al Equipo
        for (int i = 0; i < ListaJugadores.length; i++) {
            if (ListaJugadores[i] == null) { // Recorre listaJugadores y si el espacio es null crea ahi el jugador
                ListaJugadores[i] = jugador; //  <<<<<------- Ahi
                break;
            }
        }
    }
    public void venderJugador(String nombreJugador) { // Este es el metodo para vender un jugador o borrarlo de la liga
        for (int i = 0; i < ListaJugadores.length; i++) {
            if (ListaJugadores[i] != null && ListaJugadores[i].getNombre().equals(nombreJugador)) {
                // Recorremos listaJugadores y si no es null y el nombre insertado es el mismo, lo transforma a null
                // Es decir, este jugador deja de existir
                ListaJugadores[i] = null;
                for (int u = i; u < ListaJugadores.length - 1; u++) {
                    // Recorre hasta la penultima posicion del array por que luego añade +1 por lo cual lo dejara en
                    // la ultima posicion
                    ListaJugadores[u] = ListaJugadores[u + 1];
                    // Apartir de ese numero de listaJugadores, mueve todos los siguientes elementos hacia atras
                    // ese elemento se vuelve null u y le da las estadisticas del de la siguiente posicion u+1
                }
                // Vuelve al ultimo elemento del array Null para evitar duplicados,
                // Por que hasta ahi no llega el bucle, ya que recorre hasta la penultima posicion y copia la ultima,
                // Si no hago esto tendria la la penultima posicion igual que la ultima.
                ListaJugadores[ListaJugadores.length - 1] = null;
                break;
            }
        }
    }
    public int getNumMaxJugadores(){ // Este es un get del atributo constante numMaxJugadores,
        return numMaxJugadores;      // Para poder usarlo en otras clases sin ponerlo en public.
    }
    public Jugador getListaJugadoresPos(int posicion){ // Este es un metodo para tener la posicion del array sin tener
        return ListaJugadores[posicion];               // que volver este array a public y usarlo en otras cosas
    }                                                  // Puse parametro de int para poder usarlo con la variable
}                                                      // que me da el for ejemplo for (int i = 0; i......
                                                       // este i puedo meterlo dentro de este metodo y usarlo
                                                       // de la misma manera que lo haria con un array
