import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Empiece creando una liga:");
        System.out.println("Escriba el país de la liga:");
        String paisLiga = scanner.nextLine();
        Liga liga = new Liga(paisLiga);
        System.out.println("Liga en " + liga.getPais());
        System.out.println("Número de equipos: " + liga.getNumEquipos());
    }
}