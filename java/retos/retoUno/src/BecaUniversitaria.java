public class BecaUniversitaria {

    int pTiempo;
    double pMonto;
    double pInteres;
    
    public BecaUniversitaria(){
        pTiempo = 0;
        pMonto = 0;
        pInteres = 0;
    }

    public BecaUniversitaria(int pTiempo, double pMonto, double pInteres){
        this.pTiempo = pTiempo;  
        this.pMonto = pMonto;
        this.pInteres = pInteres;
    }


    //Métodos
    
    public double calcularInteresSimple(){
        double interesSimple = pMonto * (pInteres/100) * pTiempo;
        return Math.round(interesSimple);
    }

    public double calcularInteresCompuesto(){
        double interesCompuesto = pMonto * (Math.pow((1+(pInteres/100)), pTiempo)-1);
        return Math.round(interesCompuesto);
    }

    public String compararInversion(int pTiempo, double pMonto, double pInteres){

        this.pTiempo = pTiempo;  
        this.pMonto = pMonto;
        this.pInteres = pInteres;

        double diferencia = calcularInteresCompuesto() - calcularInteresSimple();

        if (diferencia != 0){
            return "La diferencia entre la proyección de interés compuesto e interés simple es: $" + diferencia;
        }else {
            return "No se obtuvo diferencia entre las proyecciones, revisar los parámetros de entrada.";
        }
        
    }

    public String compararInversion(){
        double diferencia = calcularInteresCompuesto() - calcularInteresSimple();

        if (diferencia != 0){
            return "La diferencia entre la proyección de interés compuesto e interés simple es: $" + diferencia;
        }else {
            return "No se obtuvo diferencia entre las proyecciones, revisar los parámetros de entrada.";
        }
        
    }
}