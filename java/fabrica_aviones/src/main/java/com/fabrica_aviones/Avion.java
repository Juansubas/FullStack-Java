package com.fabrica_aviones;

public class Avion {
    private String color;
    private double tamanio;

    public Avion(String color, double tamanio){
        this.color = color;
        this.tamanio = tamanio;

    }

    //GETTERS
    public String getColor() {
        return color;
    }

    public double getTamanio() {
        return tamanio;
    }

    //MODIFICADORES
    //SETTERS
    public void setColor(String color) {
        this.color = color;
    }

    public void setTamanio(double tamanio) {
        this.tamanio = tamanio;
    }

    //ACCIONES
    public void despegar(){
        System.out.println("Despegando...");
    }

    public void aterrizar(){
        System.out.println("Aterrizando...");
    } 

    public void frenar(){
        System.out.println("Frenando...");
    }

    
    
}
