
//Las clases empiezan con 
//throws Exception es el Try Except de python
public class App {
    public static void main(String[] args) throws Exception {
        //Construir un objeto de tipo Persona
        //Para pasar un char debe ser en comilla solitaria
        Persona objPersona1 = new Persona("Juan", "Páez", 23, "1116449128", 'M');
        //Obtener el nombre y apellido
        String nombre = objPersona1.getNombre();
        String apellido = objPersona1.getApellido();
        //Imprimir en consola
        System.out.println("Nombre: " +nombre+ "\nApellido: " + apellido);
        
        //Cambiar nombre 
        objPersona1.setNombre("Pepe");
        objPersona1.setApellido("Peréz");
        //Asignando esos cambios a las variables de este main para imprimir
        nombre = objPersona1.getNombre();
        apellido = objPersona1.getApellido();
        //Imprimir en consola
        System.out.println("Nombre: " +nombre+ "\nApellido: " + apellido);

        //Crear mas personas

        Persona objPersona2 = new Persona("Martha", "Leonor", 15, "666680664", 'F');

        //Asignando datos

        //A persona 2
        objPersona2.setTelefono("3176211094");
        objPersona2.setEmail("Marthaleonor_99@hotmail.com");

        //A la persona 1
        objPersona1.setTelefono("3187952957");
        objPersona2.setEmail("juansubas@gmail.com");

        //Creando otra persona

        Persona objPersona3 = new Persona("Diarledy", "Brito", 19, "66680667", 'F');
        objPersona1.setTelefono("3117952917");
        objPersona2.setEmail("diarledys@gmail.com");

        // Dividir valores
        
        System.out.println("--------------------------------------------\n--------------------------------------------");

        //Obtener valor nomina
        double nomina;
        apellido = objPersona1.getApellido();
        nomina = objPersona1.calcular_nomina(10);
        System.out.println(apellido+" -- Nomina: " +nomina);

        apellido = objPersona2.getApellido();
        nomina = objPersona2.calcular_nomina(10);
        System.out.println(apellido+" -- Nomina: " +nomina);
        
        apellido = objPersona3.getApellido();
        nomina = objPersona3.calcular_nomina(10);
        System.out.println(apellido+" -- Nomina: " +nomina);

        Persona objPersona4 = new Persona("Luis", "Hernandez", 35, "123456", 'M');
        Persona objPersona5 = new Persona("Edward", "Quintana", 55, "111111", 'M');

        apellido = objPersona4.getApellido();
        nomina = objPersona4.calcular_nomina(10);
        System.out.println(apellido+" -- Nomina: " +nomina);
        
        apellido = objPersona5.getApellido();
        nomina = objPersona5.calcular_nomina(10);
        System.out.println(apellido+" -- Nomina: " +nomina);

        objPersona1.crear_carro();

    }

    

}
