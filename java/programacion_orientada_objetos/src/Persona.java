import java.util.Scanner;

/*
 * Consultores para todos los atributos
 * Modificadores para todos excepto para cédula.
 */

public class Persona {

    //ATRIBUTOS

    private String nombre;
    private String apellido;
    private int edad;
    private String cedula;
    private String telefono;
    private String email;
    private char genero;

    //METODO CONSTRUCTOR
    public Persona(String nombre, String apellido, int edad, String cedula, char genero){
        //Con this referencio a la clase
        //this.nombre -> Atributo
        //nombre -> Parámetro
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.cedula = cedula;
        this.genero = genero;
    }

    //METODOS CONSULTORES
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public String getCedula() {
        return cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public char getGenero() {
        return genero;
    }

    //METODOS MODIFICADORES
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //ACCIONES
    public double calcular_nomina(double cant_horas){
        int valor_horas = 0;
        double nomina = 0;

        if(edad < 20 && edad >= 18){
            valor_horas = 10;
        }else if(edad >= 20 && edad <= 30){
            valor_horas = 15;
        }else if(edad > 30 && edad<= 50){
            valor_horas = 20;
        }else if(edad > 20){
            valor_horas = 25;
        }

        nomina = valor_horas * cant_horas;

        return nomina;
    }

    public void crear_carro(){
        Scanner leer = new Scanner(System.in);
        //SOLICITAR LOS DATOS PARA CREAR UN CARRO
        System.out.println("¿Qué color desea para vehículo");
        String color = leer.nextLine();

        System.out.println("Matricula del vehiculo ");
        String matricula = leer.nextLine();

        System.out.println("Modelo del vehículo ");
        String modelo = leer.nextLine();

        System.out.println("¿Qué capacidad de personas desea que tenga el vehículo? (ej:4 ): ");
        double cap_personas = leer.nextDouble();

        System.out.println("Tipo de vehículo: ");
        String tipo_carro = leer.nextLine();

        System.out.println("Velocidad máxima del vehículo (Ej: 200): ");
        double vel_maxima = leer.nextDouble();

        System.out.println("¿Desea que el vehículo sea a gasolina? (s->Sí / 0->n) ");
        String str_gasolina = leer.next();
        boolean gasolina = false;
        if(str_gasolina.equalsIgnoreCase("s") ){
            gasolina = true;
        }


        //Crear carro
        Carro carro = new Carro(color, matricula, modelo, cap_personas, tipo_carro, vel_maxima, gasolina);

        System.out.println( carro.toString());

        //CERRAR EL OBJETO
        leer.close();
    }
}
