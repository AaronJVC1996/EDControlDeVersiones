public class Equipo {
    private String Nombre;
    private String Ciudad;
    private final int numMaxJugadores = 22;
    private Jugador[] ListaJugadores;

    public Equipo (String nombr, String ciuda){
        Nombre = nombr;
        Ciudad = ciuda;
        ListaJugadores = new Jugador[numMaxJugadores];
    }
    public String getNombre (){
        return Nombre;
    }
    public String getCiudad(){
        return Ciudad;
    }
    public int getNumJugadores(){
        int contador = 0;
        for (int i = 0; i < ListaJugadores.length; i++) {
            if (ListaJugadores[i] != null) {
                contador++;
            }
        }
        return contador;
    }
    public void adquirirJugador (Jugador jugador){
        for (int i = 0; i < ListaJugadores.length; i++) {
            if (ListaJugadores[i] == null) {
                ListaJugadores[i] = jugador;
                break;
            }
        }
    }
    public void venderJugador(String nombreJugador) {
        for (int i = 0; i < ListaJugadores.length; i++) {
            if (ListaJugadores[i] != null && ListaJugadores[i].getNombre().equals(nombreJugador)) {

                ListaJugadores[i] = null;

                for (int u = i; u < ListaJugadores.length - 1; u++) {
                    ListaJugadores[u] = ListaJugadores[u + 1];
                }

                ListaJugadores[ListaJugadores.length - 1] = null;

                break;
            }
        }
    }
    public int getNumMaxJugadores(){
        return numMaxJugadores;
    }
    public Jugador getListaJugadoresPos(int posicion){
        return ListaJugadores[posicion];
    }
}
