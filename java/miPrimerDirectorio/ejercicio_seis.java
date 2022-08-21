package miPrimerPirectorio;

import java.util.Scanner;

public class ejercicio_seis {
    public static void main(String[] args){
        var sc = new Scanner(System.in);
        System.out.println("Ingrese su Día de nacimiento: ");
        int dia = sc.nextInt();
        System.out.println("Ingrese su Mes de nacimiento: ");
        int mes = sc.nextInt();
        System.out.println("Ingrese su Año de nacimiento: ");
        int año = sc.nextInt();
        String resultado_uno = "" + (dia + mes + año);

        int resultado_dos = Integer.parseInt(""+resultado_uno.charAt(0));
        resultado_dos += Integer.parseInt(""+resultado_uno.charAt(1));
        resultado_dos += Integer.parseInt(""+resultado_uno.charAt(2));
        resultado_dos += Integer.parseInt(""+resultado_uno.charAt(3));
        
        System.out.println("Su número de la suerte es: " + resultado_dos);

    }
}
