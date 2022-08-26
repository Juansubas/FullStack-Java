package com.fabrica_aviones;

public class AvionPasajeros extends Avion{

    private int pasajeros;

    public AvionPasajeros(String color, double tamanio, int pasajeros){
        //EXTENDER CLASE, RECIBIR EN EL CONSTRUCTOR PARAMETROS DE LA SUPER CLASE
        //ENVIAR A LA SUPER CLASE LOS PARÁMETROS DE SU METODO CONSTRUCTOR
        super(color, tamanio);
        this.pasajeros = pasajeros;
    }

    @Override
    public String toString() {
        String info = "------------------Avion Pasajeros----------------\n";
        info += "Color: " + this.getColor();
        info += "\nTamaño: " + this.getTamanio();
        info += "\nPasajeros: " + this.getPasajeros();
        info += "\n";
        return info;
    }

    public int getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(int pasajeros) {
        this.pasajeros = pasajeros;
    }

    public void servir(){

    }
}
