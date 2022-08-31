public class BecaUniversitaria{
    
    private double pMonto;
    private double pInteres;
    private int pTiempo;

    public BecaUniversitaria(){
        this.pTiempo = 0;
        this.pMonto = 0;
        this.pInteres = 0;
    }

    public BecaUniversitaria(int pTiempo, double pMonto, double pInteres){
        this.pTiempo = pTiempo;
        this.pMonto = pMonto;
        this.pInteres = pInteres;
    }

    // Getters

    public int getPTiempo(){
        return pTiempo;
    }

    public double getPInteres(){
        return pInteres;
    }

    public double getPMonto(){
        return pMonto;
    }

    // Setters

    public void setPTiempo(int pTiempo){
        this.pTiempo = pTiempo;
    }

    public void setPMonto(double pMonto) {
        this.pMonto = pMonto;
    }

    public void setPInteres(double pInteres) {
        this.pInteres = pInteres;
    }

    public double calcularInteresSimple(){
        double interesSimple = pMonto*(pInteres/100)*pTiempo;
        return Math.round(interesSimple);
    }

    public double calcularInteresCompuesto(){
        double interesCompuesto = pMonto*(Math.pow(1+pInteres/100, pTiempo)-1);
        return Math.round(interesCompuesto);
    }
    
    public String compararInversion(int pTiempo, double pMonto, double pInteres){
        setPTiempo(pTiempo);
        setPMonto(pMonto);
        setPInteres(pInteres);
        double interesCompuesto = calcularInteresCompuesto();
        double interesSimple = calcularInteresSimple();
        double compararInversion = interesCompuesto-interesSimple;
        return "La diferencia entre la proyección de interés compuesto e interés simple es: $" + compararInversion;
    }

    public String compararInversion(){
        double interesCompuesto = calcularInteresCompuesto();
        double interesSimple = calcularInteresSimple();
        double compararInversion = interesCompuesto-interesSimple;
        if(compararInversion == 0){
            return "No se obtuvo diferencia entre las proyecciones, revisar los parámetros de entrada.";
        }else {
            return "La diferencia entre la proyección de interés compuesto e interés simple es: $" + compararInversion;
        }
    }
}