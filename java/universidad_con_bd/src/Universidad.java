import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Universidad {
    // ATRIBUTOS
    private String nombre;
    private String nit;
    private String direccion;
    private String[] telefonos;
    private String email;
    private ArrayList<Facultad> facultades;
    private Map<Integer, ArrayList<Estudiante>> matriculas;

    // CONSTRUCTOR
    public Universidad(String nombre, String nit, String direccion) {
        this.nombre = nombre;
        this.nit = nit;
        this.direccion = direccion;
        this.facultades = new ArrayList<Facultad>();
        this.matriculas = new LinkedHashMap<Integer, ArrayList<Estudiante>>();
    }

    // CONSULTORES
    public String getNombre() {
        return nombre;
    }

    public String getNit() {
        return nit;
    }

    public String getDireccion() {
        return direccion;
    }

    public String[] getTelefonos() {
        return telefonos;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<Facultad> getFacultades() {
        return facultades;
    }

    public Map<Integer, ArrayList<Estudiante>> getMatriculas() {
        return matriculas;
    }

    // MODIFICADORES

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefonos(String[] telefonos) {
        this.telefonos = telefonos;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // ACCIONES
    public void cargarFacultades(ConexionDB objConn) {
        // Eliminar todos los datos del array
        facultades.clear();
        try {
            // Cargar toda la información de la BD
            ResultSet result = Facultad.selectByUniversidad(objConn, nit);
            while (result.next()) {
                int id = result.getInt("id");
                String codigo = result.getString("codigo");
                String nombre = result.getString("nombre");
                // Adicionar facultad al arrayList
                facultades.add(new Facultad(id, codigo, nombre));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // -----QUERIES---------

    // Crear facultad
    public void crearFacultad(String codigo, String nombre, ConexionDB objConn) {
        Facultad facultad = new Facultad(codigo, nombre);
        if (facultad.insert(objConn, nit)) {
            // Añadir objeto al arreglo
            this.facultades.add(facultad);
            System.out.println("Facultad creada con exito");
        } else {
            System.out.println("Ups! sucedio un error, intenta mas tarde");
        }

    }

    // Matricular estudiante
    public void matricularEstudiante(int idFacultad, String nombre, String apellido, int edad, String cedula,
            char sexo, String codigoEstudiante, ConexionDB objConn, boolean insertDb) {
        // Crear objeto Estudiante
        Estudiante estudiante = new Estudiante(nombre, apellido, edad, cedula, sexo, codigoEstudiante);
        if (insertDb) {
            estudiante.insert(objConn, idFacultad);
        }
        // Validar si la facultad se encuentra en el Map
        if (matriculas.containsKey(idFacultad)) {
            // Obtener el arrayList y añadir el nuevo objeto
            matriculas.get(idFacultad).add(estudiante);
        } else {
            ArrayList<Estudiante> arrayEstudiante = new ArrayList<Estudiante>();
            arrayEstudiante.add(estudiante);
            matriculas.put(idFacultad, arrayEstudiante);
        }
    }

    public void cargarMatriculas(ConexionDB objConn) {
        if (facultades.size() == 0) {
            cargarFacultades(objConn);
        }
        for (Facultad facultad : facultades) {
            ResultSet estudiantes = Estudiante.selectByFacultad(objConn, facultad.getId());
            try {
                // Iterar estudinates
                while (estudiantes.next()) {
                    String nombre = estudiantes.getString("nombre");
                    String apellido = estudiantes.getString("apellido");
                    int edad = estudiantes.getInt("edad");
                    String cedula = estudiantes.getString("cedula");
                    char sexo = estudiantes.getString("sexo").charAt(0);
                    String codigo = estudiantes.getString("codigo");
                    matricularEstudiante(facultad.getId(), nombre, apellido, edad, cedula, sexo, codigo, objConn,
                            false);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    // Método que retorna query para la inserción de una universidad en BD
    public boolean queryInsert(ConexionDB objConn) {
        boolean resp = false;
        String query = "INSERT INTO Universidades(nit, nombre, direccion, email) VALUES(?, ?, ?, ?)";
        try {
            PreparedStatement pst = objConn.getConexion().prepareStatement(query);
            pst.setString(1, nit);
            pst.setString(2, nombre);
            pst.setString(3, direccion);
            pst.setString(4, email);
            // Ejecutar query
            pst.executeUpdate();
            resp = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resp;
    }

    public String querySelectAll() {
        String query = "SELECT * FROM Universidades";
        return query;
    }

    public boolean queryUpdate(ConexionDB objConn) {
        boolean resp = false;
        try {
            String query = "UPDATE Universidades SET nombre=?, direccion=?, email=?";
            PreparedStatement pst = objConn.getConexion().prepareStatement(query);
            pst.setString(1, nombre);
            pst.setString(2, direccion);
            pst.setString(3, email);
            // Ejecutar query
            pst.executeUpdate();
            resp = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resp;
    }

    public boolean queryDelete(ConexionDB objConn) {
        boolean resp = false;
        try {
            String query = "DELETE FROM Universidades WHERE nit=?";
            PreparedStatement pst = objConn.getConexion().prepareStatement(query);
            pst.setString(1, nit);
            // Ejecutar query
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resp;
    }

}
