package miPrimerDirectorio;
import java.util.Scanner;

public class ejercicio_cinco {
    public static void main(String[] args){
        var sc = new Scanner(System.in);
        System.out.println("Ingrese un valor para indicarle si es par o impar");
        var numero = sc.nextInt();
        var resultado = (numero % 2 == 0)? "Par" : "No par";
        System.out.println("El " + numero + " Es " + resultado);
    }
}
