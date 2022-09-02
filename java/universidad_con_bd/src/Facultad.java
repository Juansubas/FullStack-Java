import java.sql.PreparedStatement;
import java.sql.SQLException;

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

    //QUERIES
    /***
     * Metodo para la inserción de una facultad
     * Retorna un booleano (true en el caso de insert, false en caso contrario)
     * @param objConn
     * @return
     */
    /*

     */

    public boolean insert(ConexionDB objConn){
        boolean insert = false;
        try {
            String query = "INSER INTO facultades(codigo, nombre) VALUES(?, ?)";
            PreparedStatement pst= objConn.getConexion().prepareStatement(query);
            pst.setString(1, codigo);
            pst.setString(2, nombre);
            //Ejecutar Consulta pero no retorna nada.
            pst.executeUpdate();
            insert = pst.executeUpdate() == 1 ? true : false;
        } catch (SQLException e) {

        }
        return insert;
    }


}
