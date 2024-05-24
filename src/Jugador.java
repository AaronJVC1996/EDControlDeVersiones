// Aaron Jaffet Vasquez Carrera 1B DAM
public class Jugador {
    private String nombre;
    private String nacionalidad;
    private int edad;
    private String posicion;
    private boolean lesionado;

    public Jugador (String nombr, String nac, int eda, String posicio){
        nombre = nombr;
        nacionalidad = nac;
        edad = eda;
        posicio = posicio;
        lesionado = false;
    }
    public String getNombre(){ // Este es el get del nombre del jugador
        return nombre;
    }
    public String getNacionalidad(){ // Este es el get de la nacionalidad del jugador
        return nacionalidad;
    }
    public int getEdad(){ // Este es el get de la edad del jugador
        return edad;
    }
    public String getPosicion(){ // Este es el get de la posicion del jugador
        return posicion;
    }
    public boolean getLesionado(){ // Este es el get para saber si el jugador esta lesionado o no
        return lesionado;
    }
    public void Lesionarse(){ // Este es el metodo para lesionar al jugador
        lesionado = true;
    }
    public void Recuperarse(){ // Este es el metodo para quitar la lesion al jugador
        lesionado = false;
    }
}


//Este es un comentario hecho por Aaron