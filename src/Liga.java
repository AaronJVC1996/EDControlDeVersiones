// Aaron Jaffet Vasquez Carrera 1B DAM
public class Liga {
    private String pais;
    private final int numMaxEquipos = 22;
    private Equipo[] listadoEquipos;

    public Liga(String pai) {
        pais = pai;
        listadoEquipos = new Equipo[numMaxEquipos];
    }

    public void mostrarListadoEquipos() { // Este metodo sirve para mostrar la lista de equipos que hay en la liga
        for (int i = 0; i < listadoEquipos.length; i++) { // Podria haber hecho completo aqui el metodo del main
            System.out.println(listadoEquipos[i]);        // Preferi hacerlo con los getters.
        }
    }
    public int getNumEquipos(){ // Me devuelve el numero real de equipos creados en la liga.
        int contador = 0;
        for (int i = 0; i < listadoEquipos.length; i++) {
            if (listadoEquipos[i] != null) { // Si el equipo no es null, es decir, existe, contador se añadira +1
                contador++;
            }
        }
        return contador;    // Retorna los equipos contados
    }
    public Equipo getEquipo(String nombreEquipo){ // Es el getter de Equipo, se escribe el nombre y comprueba si existe
        for (int i = 0; i < listadoEquipos.length; i++) {
            if (listadoEquipos[i] != null && listadoEquipos[i].getNombre().equals(nombreEquipo)) {
                return listadoEquipos[i]; // Si existe retornara el listadoequipo
            }
        }
        return null; // Si no existe no retorna nada
    }
    public String getPais(){ // Es el getter del pais de la liga
        return pais;
    }
    public int getNumMaxEquipos() { // Es el getter del numMaxEquipos que se pueden registrar que seran 20 maximo
        return numMaxEquipos;
    }
    public void añadirEquipo(Equipo equipo){ // Metodo para añadir un equipo en la liga
        for (int i = 0; i < listadoEquipos.length; i++) { // Pedira Nombre y Ciudad para añadir uno donde halle espacio
            if (listadoEquipos[i] == null) {
                listadoEquipos[i] = equipo; // En esa posicion de array donde halle espacio se creara el equipo
                break;
            }
        }
    }
    public Equipo getListadoEquipos(int posicion) {
            //he creado este getter para llamarlo facilmente desde el main, ademas es mas facil de entender.
            // Se usa como se usan los arrays para recorrerlos, puede ir el i=0 del for dentro de este metodo.
            return listadoEquipos[posicion];
        }


}


//Este es un comentario hecho por Aaron