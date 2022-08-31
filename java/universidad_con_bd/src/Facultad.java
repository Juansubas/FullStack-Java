public class Facultad {

    //ATTRIBUTES

    private String codigo;
    private String nombre;

    //CONSTRUCTOR
    
    public Facultad(String codigo, String nombre){
        this.codigo = codigo;
        this.nombre = nombre;

    }

    //GETTERS

    public String getCodigo(){
        return codigo;
    }

    public String getNombre(){
        return nombre;
    }

    //SETTERS

    public void setNombre(String nombre){
        this.nombre = nombre;
    }


}
