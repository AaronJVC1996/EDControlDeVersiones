// Aaron Jaffet Vasquez Carrera 1B DAM
public class Jugador {
    private String Nombre;
    private String Nacionalidad;
    private int Edad;
    private String Posicion;
    private Boolean Lesionado;

    public Jugador (String nombr, String Nac, int eda, String posicio){
        Nombre = nombr;
        Nacionalidad = Nac;
        Edad = eda;
        Posicion = posicio;
        Lesionado = false;
    }
    public String getNombre(){ // Este es el get del nombre del jugador
        return Nombre;
    }
    public String getNacionalidad(){ // Este es el get de la nacionalidad del jugador
        return Nacionalidad;
    }
    public int getEdad(){ // Este es el get de la edad del jugador
        return Edad;
    }
    public String getPosicion(){ // Este es el get de la posicion del jugador
        return Posicion;
    }
    public Boolean getLesionado(){ // Este es el get para saber si el jugador esta lesionado o no
        return Lesionado;
    }
    public void Lesionarse(){ // Este es el metodo para lesionar al jugador
        Lesionado = true;
    }
    public void Recuperarse(){ // Este es el metodo para quitar la lesion al jugador
        Lesionado = false;
    }
}
