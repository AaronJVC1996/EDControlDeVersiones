public class Equipo {
    private String Nombre;
    private String Ciudad;
    private final int numMaxJugadores = 22;
    private Jugador[] ListaJugadores;

    public Equipo (String nombr, String ciuda){
        Nombre = nombr;
        Ciudad = ciuda;
    }
}
