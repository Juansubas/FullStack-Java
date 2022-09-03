import java.sql.ResultSet;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws Exception {
        ConexionDB objConn = new ConexionDB();
        Universidad universidad_1 = new Universidad("UPB", "12345", "Cra 90 #55-85");
        universidad_1.setEmail("info@upb.edu.co");
        //universidad_1.queryInsert(objConn);
        //universidad_1.crearFacultad("F0O1", "Desarrollo de software UTP misionTic", objConn);
        universidad_1.cargarFacultades(objConn);
        String infoFacultades = "----------FACULTADES------\n";
        for (Facultad facultad : universidad_1.getFacultades()) {
            infoFacultades += "\nCodigo: " + facultad.getCodigo();
            infoFacultades += "\nNombre: " + facultad.getNombre();
        }
        System.out.println(infoFacultades);

        System.out.println("------ESTADO INICIAL--------");
        mostrar(objConn, universidad_1);
        /*
        System.out.println("------UPDATE--------");
        universidad_1.setNombre("Nombre de Prueba");
        universidad_1.queryUpdate(objConn);
        mostrar(objConn, universidad_1);
        System.out.println("------DELETE--------");
        universidad_1.queryDelete(objConn);
        mostrar(objConn, universidad_1);
        */

        //Cerrar Conexión

        objConn.cerrarConexion();

    }

    public static void mostrar(ConexionDB objConn, Universidad universidad) throws SQLException {
        ResultSet result = objConn.consultar( universidad.querySelectAll() );
        String info = "";
        while(result.next()){
            info+= "\nNit: "+result.getString("nit");
            info+= "\nUniversidad: "+result.getString("nombre");
            info+= "\nDireccion: "+result.getString("direccion");
            info+= "\nEmail: "+result.getString("email");
            info+= "\n---------------------------------------------\n";
        }
        System.out.println(info);
    }
}
