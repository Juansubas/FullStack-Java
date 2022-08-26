package com.fabrica_aviones;

public class AvionMilitar extends Avion{

    private double misiles;

    public AvionMilitar(String color, double tamanio, double misiles){
        //EXTENDER CLASE, RECIBIR EN EL CONSTRUCTOR PARAMETROS DE LA SUPER CLASE
        //ENVIAR A LA SUPER CLASE LOS PARÁMETROS DE SU METODO CONSTRUCTOR
        super(color, tamanio);
        this.misiles = misiles;

    }

    @Override
    public String toString() {
        String info = "------------------Avion Militar----------------\n";
        info += "Color: " + this.getColor();
        info += "\nTamaño: " + this.getTamanio();
        info += "\nMisiles: " + this.getMisiles();
        info += "\n";
        return info;
    }

    public double getMisiles() {
        return misiles;
    }

    public void setMisiles(double misiles) {
        this.misiles = misiles;
    }

    private void disparar(){
        System.out.println("Disparar----");
    }



}
