package com.empresa;

public class Cliente {
    private String nombre;
    private String apellido;
    private String telefono;

    //CONSTRUCTORES
    public Cliente (String nombre, String apellido, String telefono){
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }

    public Cliente (String nombre, String apellido){
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = "";
    }

    public Cliente (){
        this.nombre = "";
        this.apellido = "";
        this.telefono = "";
    }

    @Override
    public String toString() {
        String info = "------------------------EMPLEADO----------------------\n";
        info += "Nombre: " + nombre;
        info += "\nEdad: "+ apellido;
        info += "\nTelefono : "+telefono+"\n";
        info += "------------------------------------------------------------\n";
        return info;
    }

    //Getters 

    public String getNombre(){
        return nombre;
    }
    public String getApellido(){
        return apellido;
    }
    public String getTelefono(){
        return telefono;
    }

    //Setters

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setEdad(String apellido){
        this.apellido = apellido;
    }

    public void setTelefono(String telefono){
        this.telefono = telefono;
    }

    //Método

    public void mostrar(){
        return;
    }


}
