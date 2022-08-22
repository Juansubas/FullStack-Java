public class App {
    public static void main(String[] args) throws Exception {
        BecaUniversitaria becaUniversitaria = new BecaUniversitaria();
        System.out.println(becaUniversitaria.calcularInteresSimple());
        System.out.println(becaUniversitaria.calcularInteresCompuesto());
        System.out.println(becaUniversitaria.compararInversion(60,13000,1.4));
        System.out.println(becaUniversitaria.compararInversion(48,10000,2.0));
        System.out.println(becaUniversitaria.compararInversion());
    }
}
