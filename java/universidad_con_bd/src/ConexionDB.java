import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConexionDB {
    //ATTRIBUTES

    private Connection conexion;

    //CONSTRUCTOR

    public ConexionDB(){
        //Generar Conexión
        try{
            conexion = DriverManager.getConnection("jdbc:sqlite:universidad.db");
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("Eror al conectar con la base de datos");
        }

    }

    //METHODS
    //THROWS NOS MANEJA LAS EXCEPCIONES DE LOS MÉTODOS

    public void cerrarConexion() throws SQLException{
        conexion.close();
    }

    public void consultar(){

    }

    public boolean insertar(String query){
        boolean bandera = false;
        try {
            PreparedStatement ps = conexion.prepareStatement(query);
            bandera = true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return bandera;
    }
}
