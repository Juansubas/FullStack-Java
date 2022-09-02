import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionDB {
    //ATTRIBUTES

    private Connection conexion;

    //CONSTRUCTOR

    public ConexionDB(){
        //Generar Conexión
        try{
            conexion = DriverManager.getConnection("jdbc:sqlite:universidad");
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("Eror al conectar con la base de datos");
        }

    }

    //CONSULTOR

    public Connection getConexion(){
        return conexion;
    }

    //METHODS
    //THROWS NOS MANEJA LAS EXCEPCIONES DE LOS MÉTODOS

    public void cerrarConexion() throws SQLException{
        conexion.close();
    }

    public ResultSet consultar(String query){
        ResultSet result;
        try {
            Statement st = conexion.createStatement();
            result = st.executeQuery(query);
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            result = null;
        }
        return result;
    }

    public void actualizar_eliminar(){

    }

}
