
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
}
