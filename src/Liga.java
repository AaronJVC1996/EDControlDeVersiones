public class Liga {
    private String Pais;
    private final int numMaxEquipos = 20;
    private Equipo[] ListadoEquipos;

    public Liga(String pai) {
        Pais = pai;
        ListadoEquipos = new Equipo[numMaxEquipos];
    }

    public void mostrarListadoEquipos() {
        for (int i = 0; i < ListadoEquipos.length; i++) {
            System.out.println(ListadoEquipos[i]);
        }
    }
    public int getNumEquipos(){
        int contador = 0;
        for (int i = 0; i < ListadoEquipos.length; i++) {
            if (ListadoEquipos[i] != null) {
                contador++;
            }
        }
        return contador;
    }
    public Equipo getEquipo(String nombreEquipo){
        for (int i = 0; i < ListadoEquipos.length; i++) {
            if (ListadoEquipos[i] != null && ListadoEquipos[i].getNombre().equals(nombreEquipo)) {
                return ListadoEquipos[i];
            }
        }
        return null;
    }
    public String getPais(){
        return Pais;
    }
    public int getNumMaxEquipos() {
        return numMaxEquipos;
    }
    public void añadirEquipo(Equipo equipo){
        for (int i = 0; i < ListadoEquipos.length; i++) {
            if (ListadoEquipos[i] == null) {
                ListadoEquipos[i] = equipo;
                break;
            }
        }
    }
}