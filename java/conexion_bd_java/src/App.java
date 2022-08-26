import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App {
    public static void main(String[] args) throws Exception {
        conectar_bd();
    }

    public static Connection conectar_bd(){

        Connection conn;
        //Vamos primero a crear un objeto que será el encargado de conectarse a la BD, y a partir de este objeto
        //creamos otro objeto que hace peticiones tipo SQL al primer objeto que esta conectado a la DB
        //El primer objeto nos retorna datos y el segundo objeto nos retorna otro objeto que nos va a mostrar el resultado 
        //Siendo una tabla, hay que iterar para acceder a los valores

        //Usaremos try catch
        try {

            //Objeto tipo Connection, hay que importarlo
            //Nuestro objeto para conectar a la Db es conn 
            //El objeto DriverManager con el metodo conección nos permité 
            //Manejar la conexión mediante el archivo que descargamos (driver para usar la db y java)
            //Al declarar el Connection por fuera del try podemos solo llamar el objeto
            //Connection conn = DriverManager.getConnection("jdbc:sqlite:hr.db");
            conn = DriverManager.getConnection("jdbc:sqlite:hr.db");

            if(conn != null){
                
                } 

            //iNICIALIZAR VARIABLES PARA EL QUERY
            String job_title = "Developer";
            int min_salary = 5000;
            int max_salary = 10000;
            //Estructura del QUERY
            String query = "INSERT INTO jobs(job_title, min_salary, max_salary) VALUES(?, ?, ?)";
            //Prepare la consulta
            PreparedStatement ps = conn.prepareStatement(query);
            //Setear los signos de interrogación / Indicar los valores que tendrá el query
            ps.setString(1, job_title);
            ps.setDouble( 2, min_salary);
            ps.setDouble(3, max_salary);
            
            //Vamos a actualizar cuando no esperamos ningún retorno, pues estamos insertando valores
            ps.executeUpdate();
            //Execute Query es para cuando si esperamos un retorno

            //Cerrar conexión
            conn.close();

        }catch(SQLException error){
            error.printStackTrace();
            System.out.println(error.getMessage());
        }
    }

    public static void mostrarEmpleados(Connection conn){
        try {

            System.out.println("Conexion exitosa a la base de datos");
            // Crear objeto Statement
            Statement statement = conn.createStatement();
            // Ejecutar consulta sql
            ResultSet result = statement.executeQuery("SELECT * FROM employees");
            // Iterar mientras tenga registros
            while (result.next()) {

                // Obtener los datos del ResultSet
                int id = result.getInt("employee_id");
                String nombre = result.getString("first_name");
                String apellido = result.getString("last_name");
                // Mostrar información en consola
                String info = "Id: " + id;
                info += "\nNombre: " + nombre;
                info += "\nApellido: " + apellido;
                info += "\n-------------------------------\n";
                System.out.println(info); 
            }
        } catch (SQLException error) {
            System.out.println(error.getMessage());
        }
    }
}


