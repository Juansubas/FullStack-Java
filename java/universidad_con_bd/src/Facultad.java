import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

    public boolean insert(ConexionDB objConn, String universidad_nit){
        boolean insert = false;
        try {
            String query = "INSERT INTO facultades(codigo, nombre, universidad_nit) VALUES(?, ?, ?)";
            PreparedStatement pst= objConn.getConexion().prepareStatement(query);
            pst.setString(1, codigo);
            pst.setString(2, nombre);
            pst.setString(3, universidad_nit);
            //Ejecutar Consulta pero no retorna nada.
            pst.executeUpdate();
            insert = pst.executeUpdate() == 1 ? true : false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return insert;
    }

    public static ResultSet selectALL(ConexionDB objConn){
        ResultSet result = null;
        try {
            String query = "SELECT * FROM facultades";
            Statement st = objConn.getConexion().createStatement();
            result = st.executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public ResultSet selectByCodigo(ConexionDB objConn, String codigo){
        ResultSet result = null;
        try {
            String query = "SELECT * FROM facultades WHERE codigo = ?";
            PreparedStatement pst = objConn.getConexion().prepareStatement(query);
            pst.setString(1, codigo);
            result = pst.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public ResultSet selectByNombre(ConexionDB objConn, String nombre){
        ResultSet result = null;
        try {
            String query = "SELECT * FROM facultades WHERE nombre '%?%'";
            PreparedStatement pst = objConn.getConexion().prepareStatement(query);
            pst.setString(1, nombre);
            result = pst.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean update(ConexionDB objConn, String codigo, String nombre ){
        boolean update = false;
        try {
            String query = "UPDATE facultades SET nombre = ? WHERE codigo = ?";
            PreparedStatement pst = objConn.getConexion().prepareStatement(query);
            pst.setString(1, nombre);
            pst.setString(2, codigo);
            //Ejecutar
            update = pst.executeUpdate() == 1 ? true : false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return update;
    }

    public boolean delete(ConexionDB objConn, String codigo){
        boolean update = false;
        try {
            String query = "DELETE facultades WHERE codigo = ?";
            PreparedStatement pst = objConn.getConexion().prepareStatement(query);
            pst.setString(1, codigo);
            //Ejecutar
            update = pst.executeUpdate() == 1 ? true : false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return update;
    }
}
