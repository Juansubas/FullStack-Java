public class Estudiante extends Persona{

    //ATTRIBUTES

    private String codigo;


    //CONSTRUCTOR

    public Estudiante(String nombre, String apellido, int edad, String cedula, char sexo, String codigo){
        super(nombre, apellido, edad, cedula, sexo);
        this.codigo = codigo;
    }

    //GETTERS

    public String getCodigo(){
        return codigo;
    }

    //SETTERS

    public void setCodigo(String codigo){
        this.codigo = codigo;
    }

}
