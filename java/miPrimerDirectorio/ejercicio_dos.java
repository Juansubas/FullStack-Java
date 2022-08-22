package miPrimerDirectorio;

import java.util.Scanner;

public class ejercicio_dos {
    public static void main(String[] args){
        var sc = new Scanner(System.in);
        System.out.println("Ingrese un numero entero");
        var numero = sc.nextInt();
        //nextLine para string y nextInt para un entero, nextFloa
        var resultado = cuentaCifras(numero);

        System.out.println("Su número tiene " + resultado + " cifras");

    }

    public static int cuentaCifras(int numero){
        var contador = 0;

        while (numero != 0){
            contador ++;
            numero /= 10;
        }

        return contador;
    }
}
