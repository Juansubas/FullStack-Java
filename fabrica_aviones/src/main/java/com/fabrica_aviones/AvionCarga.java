package com.fabrica_aviones;

public class AvionCarga extends Avion{

    public AvionCarga(String color, double tamanio){
        //EXTENDER CLASE, RECIBIR EN EL CONSTRUCTOR PARAMETROS DE LA SUPER CLASE
        //ENVIAR A LA SUPER CLASE LOS PARÁMETROS DE SU METODO CONSTRUCTOR
        super(color, tamanio);

    }

    @Override
    public String toString() {
        String info = "------------------Avion de Carga----------------\n";
        info += "Color: " + this.getColor();
        info += "\nTamaño: " + this.getTamanio();
        info += "\n";
        return info;
    }
    //METODOS

    public void cargar(){
        System.out.println("Cargando...");
    }

    public void descargar(){
        System.out.println("Descargando...");
    }
}
