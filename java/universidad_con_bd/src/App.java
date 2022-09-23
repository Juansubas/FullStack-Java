import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {

        ConexionDB objConn = new ConexionDB();
        Universidad universidad_1 = new Universidad("UPB", "54321", "Cra 90 #55-85");
        universidad_1.setEmail("info@upb.edu.co");
        // universidad_1.queryInsert(objConn);
        // universidad_1.crearFacultad("F001", "Desarrollo de software UTP misionTic",
        // objConn);
        universidad_1.cargarFacultades(objConn);
        String infoFacultades = "----------FACULTADES------\n";
        for (Facultad facultad : universidad_1.getFacultades()) {
            infoFacultades += "Codigo: " + facultad.getCodigo();
            infoFacultades += "\nNombre: " + facultad.getNombre();
        }

        universidad_1.matricularEstudiante(universidad_1.getFacultades().get(0).getId(), "Ana", "Perez", 30,
                "987654321", 'F', "AP321", objConn, true);

        universidad_1.cargarMatriculas(objConn);
        mostrarMatriculas(universidad_1.getMatriculas());

        System.out.println(infoFacultades);

        System.out.println("-----------ESTADO INICIAL-------");
        mostrar(objConn, universidad_1);
        /*
         * System.out.println("-----------UPDATE-------");
         * universidad_1.setNombre("Nombre de Prueba");
         * universidad_1.queryUpdate(objConn);
         * mostrar(objConn, universidad_1);
         * System.out.println("-----------DELETE-------");
         * universidad_1.queryDelete(objConn);
         * mostrar(objConn, universidad_1);
         */

        // Cerrar conexion
        objConn.cerrarConexion();

    }

    public static void mostrarMatriculas(Map<Integer, ArrayList<Estudiante>> matriculas) {
        // Iterar las matriculas (facultad-estudiantes)
        for (ArrayList<Estudiante> estudiantes : matriculas.values()) {
            String info = "";
            // Iterar los estudiantes
            for (Estudiante estudiante : estudiantes) {
                info += "------------------------------\n";
                info += "\nCedula: " + estudiante.getCedula();
                info += "\nNombre: " + estudiante.getNombre();
                info += "\nApellido: " + estudiante.getApellido();
                info += "\nEdad: " + estudiante.getEdad();
                info += "\n------------------------------\n";

            }
            System.out.println(info);
        }
    }

    public static void mostrar(ConexionDB objConn, Universidad universidad) throws SQLException {
        ResultSet result = objConn.consultar(universidad.querySelectAll());
        String info = "";
        while (result.next()) {
            info += "Nit: " + result.getString("nit");
            info += "\nUniversidad: " + result.getString("nombre");
            info += "\nDireccion: " + result.getString("direccion");
            info += "\nEmail: " + result.getString("email");
            info += "\n----------------------------------\n";
        }
        System.out.println(info);
    }

}
