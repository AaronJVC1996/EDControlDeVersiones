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
    public String getNombre(){
        return Nombre;
    }
    public String getNacionalidad(){
        return Nacionalidad;
    }
    public int getEdad(){
        return Edad;
    }
    public String getPosicion(){
        return Posicion;
    }
    public Boolean getLesionado(){
        return Lesionado;
    }
}
