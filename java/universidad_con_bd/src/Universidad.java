import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

//Los arreglos nativos tienen tamaño dinámico por lo tanto vamos a importar libreria de arrays dinámicos

public class Universidad{
    //ATRIBUTOS
    private String nombre;
    private String nit;
    private String direccion;
    private String[] telefonos;
    private String email;
    //Permite usar Arrays dinámicas
    private ArrayList<Facultad> facultades;
    //Con map podemos tener estructura tipo diccionarios en python
    //Con map podemos tener estructura tipo objetos en JavaScript
    private Map<String, ArrayList<Estudiante>> estudiantes;

    //CONSTRUCTOR

    public Universidad(String nombre, String nit, String direccion){
        this.nombre = nombre;
        this.nit = nit;
        this.direccion = direccion;
        this.facultades = new ArrayList<Facultad>();
        //Inserta de forma ordenada las arrays.
        this.estudiantes = new LinkedHashMap<String, ArrayList<Estudiante>>();
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
    //Matricular Estudiante

    public void matricularEstudiante(String codigoFacultad, String nombre, String apellido, int edad, String cedula, char sexo, String codigoEstudiante){
        //Crear Objeto Estudiante
        Estudiante estudiante = new Estudiante(nombre, apellido, edad, cedula, sexo, codigoEstudiante);
        // Validar si la facultad se encuentra en el map
        if(estudiantes.containsKey(codigoFacultad)){
            //Obtener el arrayList y añadir el nuevo obj
            estudiantes.get(codigoFacultad).add(estudiante);
        }else{
            //Aquí primero creamos el array list que tenga todos los estudiante de una facultad
            ArrayList<Estudiante> arrayEstudiante = new ArrayList<Estudiante>();
            //Despúes vamos a adicionar un estudiante a dicho array
            arrayEstudiante.add(estudiante);
            //Posteriormente vamos a adicionar de una forma distinta y es con key y valor mediante put
            estudiantes.put(codigoFacultad, arrayEstudiante);
        }
    }

    //Método que retorna query para la inserción de una universidad en BD

    public boolean queryInsert(ConexionDB objConn){
        boolean resp = false;
        String query = "INSERT INTO Universidades(nit, nombre, direccion, email) VALUES(?, ?, ?, ?)";
        try {
            PreparedStatement pst = objConn.getConexion().prepareStatement(query);
            pst.setString(1, nit);
            pst.setString(2, nombre);
            pst.setString(3, direccion);
            pst.setString(4, email);
            //Ejecutar Query
            pst.executeUpdate();
            resp = true;
        } catch (Exception e) {
            //Permite continuar con el programa pero además muestra lo que genera el error
            e.printStackTrace();
        }
        return resp;
    }

    public String querySelectAll(){
        String query = "SELECT * FROM Universidades";
        return query;
    }

    public boolean queryUpdate(ConexionDB objConn){
        boolean resp = false;
        try {
            String query = "UPDATE Universidades SET nombre =?, direccion=?, email=?";
            PreparedStatement pst = objConn.getConexion().prepareStatement(query);
            pst.setString(1, nombre);
            pst.setString(2, direccion);
            pst.setString(3, email);
            //Ejecutar Query
            pst.executeUpdate();
            resp = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    } 

    public boolean queryDelete(ConexionDB objConn){
        boolean resp = false;
        try {
            String query = "DELETE FROM Universidades WHERE nit = ?";
            PreparedStatement pst = objConn.getConexion().prepareStatement(query);
            pst.setString(1, nit);
            //Ejecutar Query
            pst.executeUpdate();
            resp = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
}