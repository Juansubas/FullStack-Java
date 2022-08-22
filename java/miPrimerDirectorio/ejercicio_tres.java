package miPrimerDirectorio;

import java.util.Scanner;

public class ejercicio_tres {
    public static void main(String[] args){
        var sc = new Scanner(System.in);
        System.out.println("Ingrese número entero");
        var numero = sc.nextInt();
        System.out.println("El número es: " + numero + "\nEl doble de ese número es: " + numero*2 + "\nEl triple de ese número es " + numero*3);
    }
}
