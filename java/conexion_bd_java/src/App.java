import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App {
    public static void main(String[] args) throws Exception {

        Connection conn = conectar_bd();
        mostrarEmpleados(conn);
        //crearPuestoTrabajo(conn, "Marketing", 2000, 8000);
        System.out.println("\n------------JOBS------------\n");
        //eliminarPuestoTrabajoXid(conn, 17);
        //updatePuestoTrabajo(conn, 16, "Industrial Engineering", 2000, 8000);
        mostarPuestosTrabajos(conn);
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

        }catch(SQLException error){
            conn = null;
            error.printStackTrace();
            System.out.println(error.getMessage());
        }
        return conn;
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

    public static void crearPuestoTrabajo(Connection conn, String job_title, int min_salary, int max_salary){
        try {
                //ejemplo asignando valores -- iNICIALIZAR VARIABLES PARA EL QUERY
                //Connection conn= "Developer";
                //int min_salary= 5000;
                //int max_salary = 10000;
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
        } catch (SQLException error) {
            System.out.println(error.getMessage());
        }
    }

    public static void mostarPuestosTrabajos(Connection conn){
        try{
            Statement st = conn.createStatement();
            ResultSet result = st.executeQuery("SELECT * FROM jobs");
            while(result.next()){
                System.out.println("Job Title: " + result.getString("job_title"));
            }
            //Statement es cuando ya tenemos Querys Fijos
            //PreparedStatement es para concatenar variables
            //Como en este caso solo es la Query Usaremos Statement

        }catch(SQLException error){
            System.out.println(error.getMessage());
        }
    }
    
    //Método para eliminar un puesto de trabajo por id
    public static void eliminarPuestoTrabajoXid(Connection conn, int id){
        try {
            String query = "DELETE FROM jobs WHERE job_id = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        //Desarrrollar este método, desde sus parámetros hasta su lógica
    }

    //Desarollar método par actualizar por id los valores de la tabla "jobs"
    public static void updatePuestoTrabajo(Connection conn, int job_id, String job_title, int min_salary, int max_salary ){
        try{
            String query = "UPDATE jobs SET job_title = ?, min_salary = ?, max_salary = ? WHERE job_id= ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1,job_title);
            ps.setDouble(2, min_salary);
            ps.setDouble(3, max_salary);
            ps.setInt(4, job_id);
            ps.executeUpdate();

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}


