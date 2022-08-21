//Empaquetando el directorio
package miPrimerPirectorio;

public class HolaMundo {
    public static void main(String[] args){
        //Imprimiendo mensaje en consola
        //Se puede con println o print
        //con println da un salto de linea y sin este no
        //xd

        System.out.print("Hola Mundo");
        System.out.println("Otra Línea");
        
        //VARIABLES
        int entero;
        entero = 10;
        double decimales = 5.5;
        boolean bandera = true;
        String nombre = "Andrés Quintero";
        //char siempre pide un carácter, por eso no podemos dejarlo vacio
        char caracter = 'a';

        //Concatenando variables dentro de un print
        //Salto de línea \n
        System.out.println("Entero-> " + entero );
        System.out.println("Decimales-> " + decimales );
        System.out.println("Bandera-> " + bandera );
        System.out.println("Nombre-> " + nombre );
        System.out.println("Caracter-> " + caracter );

        //OPERACIONES
        double suma;
        suma = 10+10;
        double multiplicacion = 5+10;
        int modulo = 10*2;
        double division = 10/2;
        int resta = 10-5;

        suma += 10;
        multiplicacion *= 2;
        modulo %= 2;
        division /= 2;
        resta -= 2;

        System.out.println("La suma es: " + resta + "\nLa resta es: " + resta);

        System.out.println("Suma ->"+suma);
        //Incrmenta una unidad
        suma++;
        System.out.println("Suma->"+suma);

        System.out.println("Resta->"+resta);
        //Decrementa una unidad
        resta--;
        System.out.println("Resta->"+resta);

        incremental();
        decremental();
        operadores_logicos();
    }

    //Creando una función es void porque no retornará ningún dato
    //Tipo return en python pues
    // de lo contrario escribir lo que retornara

    public static void incremental(){
        System.out.println("----------------Incremental---------");
        int x= 0;
        //Imprimir valor inicial de "x"
        System.out.println(x);
        //INCREMENTAL
        System.out.println("INCREMENTAL");
        System.out.println(++x);
        //POST INCREMENTAL (LO QUE HACE ES QUE LA IMPRIME Y DESPUÉS LE ASIGNA EL INCREMENTO, ASÍ QUE FALTARÍA LUEGO IMPRIMIRLA PARA VERLA ACTUALIZADA)
        System.out.println("POSTINCREMENTAL");
        System.out.println(x++);
        System.out.println(x);
    }

    public static void decremental(){
        System.out.println("---------------DECREMENTAL-----------------");
        int x = 10;
        //Imprimir valor inicial de "x"
        System.out.println(--x);
        System.out.println(x);
        System.out.println(x--);
        System.out.println(x);
    }

    public static void operadores_logicos(){
        int n1 = 10;
        int n2 = 10;
        int n3 = 5;
        int n4 = 8;
        boolean resultado;

        resultado = n1 == n2;
        System.out.println(resultado);
        resultado = n1 > n3;
        System.out.println(resultado);
        resultado = n4 <= n2;
        System.out.println(resultado);
        resultado = n4 != n3;
        System.out.println(resultado);
        //
    }


}
