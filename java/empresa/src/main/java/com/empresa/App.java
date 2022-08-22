package com.empresa;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //Primero creamos una empresa
        Scanner leer = new Scanner(System.in);
        Empresa objEmpresa = new Empresa("Tesla");
        objEmpresa.crearEmpleado(leer);
        System.out.println( objEmpresa.getEmpleado() );
        //Luego esa empresa creará un empleado
        //Posterior debemos tener un cliente
        Cliente objcliente = objEmpresa.registrarCliente(leer);
        System.out.println( objcliente );

        //Empleado emp = new Empleado("Juan", 20);
        //System.out.println(emp);
    }
}
