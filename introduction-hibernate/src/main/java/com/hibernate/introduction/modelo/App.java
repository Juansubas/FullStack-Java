package com.hibernate.introduction.modelo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.introduction.modelo.modelo.Mascota;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // Crear objeto fabricante de sesiones lo importamos de hibernate
        // Para que nos permita interactuar con nuestra entidad mascotas
        // le damos la configuración respecto a la BD 
        SessionFactory factory = new Configuration() //Importar configuration de Hibernate
        .configure("cfg.xml") //Agregamos la confiracuión
        .addAnnotatedClass(Mascota.class) //Necesitamos agregar la clase de la entidad mascotas
        .buildSessionFactory(); //Fabricamos el objeto Sesión

        // Abrir sesión una sesion es como un tunel donde vamos a enviar y recibir data
        //Importamos todo de hibernate
        Session session = factory.openSession();

        // Preparar la sesión para realizar transacciones
        // Como podemos 
        session.beginTransaction();

        // Generar transacciones...
        // Al pedirle pueden existir errores entonces usamos try catch
        try {
            //CRUD

            //Create
            Mascota mascota = new Mascota("niño", "Quintero", "perro", "Chandinez", 6, "Ninguna");
            //Vamos a decirle a la sessión que prepare la mascota para ser guardada
            session.persist(mascota);
            //Ahora vamos guardar realmente los cambios como en git, solicitamos la transacción de los cambios guardados
            session.getTransaction().commit();

        } catch (Exception e) {
            // TODO: handle exception
        }


        // Cerrar sesión
        session.close();
    }
}
