public class ComputadoresMesa extends Computadores{
    private static final int ALMACENAMIENTO_BASE = 50;

    private int almacenamiento;

    public ComputadoresMesa(double precioBase, int peso, char consumoW, int almacenamiento){
        super(precioBase, peso, consumoW);
        this.almacenamiento = almacenamiento;
    }

    public ComputadoresMesa(double precioBase, int peso){
        this.precioBase = precioBase;
        this.peso = peso;
        this.consumoW = CONSUMO_W;
        this.almacenamiento = ALMACENAMIENTO_BASE;
    }

    public ComputadoresMesa(){
        this.peso = PESO_BASE;
        this.consumoW  = CONSUMO_W;
        this.precioBase = PRECIO_BASE;
        this.almacenamiento = ALMACENAMIENTO_BASE;
    }

    public double calcularPrecio(){
        double adicion = super.calcularPrecio();
        adicion += (almacenamiento > 100) ? 50: 0;
        return adicion;
    }


}
