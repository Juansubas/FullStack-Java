public class ComputadoresPortatiles extends Computadores{
    private final int PULGADAS_BASE = 20;
    private int pulgadas;
    private boolean camaraITG;

    public ComputadoresPortatiles(double precioBase, int peso, char consumoW, int pulgadas, boolean camaraITG){
        super(precioBase, peso, consumoW);
        this.pulgadas = pulgadas;
        this.camaraITG = camaraITG;
    }

    public ComputadoresPortatiles(double precioBase, int peso, char consumoW, int pulgadas){
        super(precioBase, peso, consumoW);
        this.pulgadas = PULGADAS_BASE;
    }

    public ComputadoresPortatiles(){
        this.peso = PESO_BASE;
        this.consumoW = CONSUMO_W;
        this.precioBase = PRECIO_BASE;
        this.pulgadas = PULGADAS_BASE;
        this.camaraITG = false;
    }

    public double calcularPrecio(){
        double adicion = super.calcularPrecio();
        if(pulgadas > 40){
            adicion += precioBase * 0.3;
        }
        if(camaraITG){
            adicion += 50;
        }
        return adicion;
    }

}
