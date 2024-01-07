public class Liga {
    private String Pais;
    private final int numMaxEquipos = 20;
    private Equipo[] ListadoEquipos;

    public Liga (String pai){
        Pais = pai;
        ListadoEquipos = new Equipo[numMaxEquipos];
    }
}
