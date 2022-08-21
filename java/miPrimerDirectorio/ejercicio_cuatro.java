package miPrimerPirectorio;
import java.util.Scanner;

public class ejercicio_cuatro {
    
    public static void main(String[] args){
        var sc = new Scanner(System.in);
        System.out.println("Ingrese sus grado celsius");
        var celsius = sc.nextDouble(); 
        var resultado = farenheit(celsius);
        System.out.println("Sus grados farenheit son " + resultado);
    }   

    public static double farenheit(double gradoscelsius) {
        var farenheit= 32 + (9*(gradoscelsius/5));
        return farenheit
        ;
    }
}
