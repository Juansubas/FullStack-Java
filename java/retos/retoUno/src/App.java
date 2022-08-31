public class App{
    public static void main(String[] args){
        //Caso 1
        //BecaUniversitaria becaUniversitaria = new BecaUniversitaria(48,10000,2.0);
        //Caso 2
        //BecaUniversitaria becaUniversitaria = new BecaUniversitaria();
        //Caso 3
        BecaUniversitaria becaUniversitaria = new BecaUniversitaria();
        System.out.println(becaUniversitaria.calcularInteresSimple());
        System.out.println(becaUniversitaria.calcularInteresCompuesto());
        //Caso 1
        //System.out.println(becaUniversitaria.compararInversion());
        //Caso 2
        //System.out.println(becaUniversitaria.compararInversion(60,13000,1.4));
        //Caso 3
        System.out.println(becaUniversitaria.compararInversion());
    }
}