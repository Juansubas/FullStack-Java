package com.animales;

public class Perro extends Animal {

    private String raza;

    public Perro(String color, double tamanio, int edad, String especie, String raza){
        super(color, tamanio, edad, especie);
        this.raza = raza;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    @Override
    public void avanzar() {
        System.out.println("Correr ");
    }

}
