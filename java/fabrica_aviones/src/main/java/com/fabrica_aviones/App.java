package com.fabrica_aviones;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Fabrica objFabrica = new Fabrica();
        objFabrica.fabricar_avion(TipoAvion.AVION_CARGA);
        //System.out.println( objFabrica.getAviones(0).getColor());
        objFabrica.fabricar_avion(TipoAvion.AVION_COMERCIAL);
        objFabrica.fabricar_avion(TipoAvion.AVION_MILITAR);
        objFabrica.mostrar_aviones();
        /*AvionCarga avionCarga = new AvionCarga("Blanco", 50.5);
        System.out.println("----------------ATRIBUTOS--------------------");
        String color = avionCarga.getColor();
        double tamanio = avionCarga.getTamanio();
        System.out.println("Color: " + color + "\ntamaño: "  +tamanio);
        System.out.println("----------------ACCIONES--------------------");
        avionCarga.cargar();
        avionCarga.despegar();
        avionCarga.aterrizar();
        avionCarga.frenar();
        avionCarga.descargar();*/
        //condicionales();
    }

    public static void condicionales(){
        int numero = 10;
        if (numero==1){
            System.out.println("Es igual a 1");
        }else if(numero == 2){
            System.out.println("Es igual a 2");
        }else{
            System.out.println("No es ninguno de los anteriores");
        }

        switch(numero){
            case 1:
                System.out.println("Es igual a 1");
                break;
            case 2:
                System.out.println("Es igual a 2");
                break; 
            case 3:
                System.out.println("Es igual a 3");
                break;
            default:
                System.out.println("No es ninguno de los anteriores");       
            }
    }
}
