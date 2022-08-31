public class Universidad{
    //ATRIBUTOS
    private String nombre;
    private String nit;
    private String direccion;
    private String[] telefonos;
    private String email;

    //CONSTRUCTOR

    public Universidad(String nombre, String nit, String direccion){
        this.nombre = nombre;
        this.nit = nit;
        this.direccion = direccion;
    }

    //CONSULTORES

    public String getNombre(){
        return nombre;
    }

    public String getNit(){
        return nit;
    }

    public String getDireccion(){
        return direccion;
    }

    public String[] getTelefonos(){
        return telefonos;
    }

    public String getEmail(){
        return email;
    }

    //MODIFICADORES

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setDireccion(String direccion){
        this.direccion = direccion;
    }

    public void setTelefonos(String[] telefonos){
        this.telefonos = telefonos;
    }

    public void setEmail(String email){
        this.email = email;
    }

    //ACCIONES


}