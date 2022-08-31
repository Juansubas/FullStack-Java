public class Computadores {
    //Constantes 
    protected static final char CONSUMO_W = 'F';
    protected static final double PRECIO_BASE = 100.00;
    protected static final int PESO_BASE = 5;

    //Var privadas normales
    protected int peso;
    protected char consumoW;
    protected double precioBase;

    public Computadores(double precioBase, int peso, char consumoW){
        this.peso = peso;
        this.consumoW = consumoW;
        this.precioBase = precioBase;
    }

    public Computadores(double precioBase, int peso){
        this.peso = peso;
        this.consumoW = CONSUMO_W;
        this.precioBase = precioBase;
    }

    public Computadores(){
        this.peso = PESO_BASE;
        this.consumoW = CONSUMO_W;
        this.precioBase = PRECIO_BASE;
    }

    public double calcularConsumoW(){
        return consumoW;
    }

    public double calcularPrecio(){
        double adicion = 0.0;

        //CRITEIROS ESTABLECIDOS CONSUMO ENERGÉTICO

        switch(consumoW){
            case 'A':
                adicion += 100;
                break;
            case 'B':
                adicion += 80;
                break;
            case 'C':
                adicion += 60;
                break;
            case 'D':
                adicion += 50;
                break;
            case 'E':
                adicion += 30;
                break;
            case 'F':
                adicion += 10;
                break;
        } 

        //CRITERIOS ESTABLECDOS ADICION PESO

        if(peso >= 0 && peso < 19){
            adicion += 10;
        }else if(peso >= 20 && peso < 49){
            adicion += 50;
        }else if(peso >= 50 && peso < 79){
            adicion += 80;
        }else if(peso >= 80 ){
            adicion += 100;
        }
        return adicion + precioBase;
    }
    
}
