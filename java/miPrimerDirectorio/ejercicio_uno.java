package miPrimerDirectorio;

public class ejercicio_uno {
    
    public static void main(String[] args){
        String name = "Juan";
        var resultado = saludo(name);
        System.out.println(resultado);
    }

    public static String saludo(String nombre) {
        return "Hola " + nombre + " bienvenido a java.";
    }
}
