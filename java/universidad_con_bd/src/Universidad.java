import java.util.ArrayList;

//Los arreglos nativos tienen tamaño dinámico por lo tanto vamos a importar libreria de arrays dinámicos

public class Universidad{
    //ATRIBUTOS
    private String nombre;
    private String nit;
    private String direccion;
    private String[] telefonos;
    private String email;
    private ArrayList<Facultad> facultades;

    //CONSTRUCTOR

    public Universidad(String nombre, String nit, String direccion){
        this.nombre = nombre;
        this.nit = nit;
        this.direccion = direccion;
        this.facultades = new ArrayList<Facultad>();
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

    //METHODS

    //Crear facultad

    public void crearFacultad(String codigo, String nombre){
        //Al llamar esta función resulta que va a inicializar el constructor
        //de Facultad por eso se pone que esta variable es de Facultad
        //Posteriormente almacenamos el objeto en la variable que luego será añadida
        //al array
        Facultad facultad = new Facultad(codigo, nombre);
        //Añadir objeto al arreglo
        this.facultades.add(facultad);
    }

    //Método que retorna query para la inserción de una universidad en BD

    public String queryInsert(){
        String query = "INSER INTO Universidades(nit, nombre, direccion, email) VALUES(?, ?, ?, ?)";
        return query;
    }

    public String querySelect(){
        String query = "SELECT * FROM Universidades ";
        return query;
    }

    public String queryUpdate(){
        String query = "UPDATE Universidades SET nombre =?, apellido =?, direccion=?, email=?";
        return query;
    } 

    public String queryDelete(){
        String query = "DELETE FROM Universidades WHERE nit = ?";
        return query;
    }
}