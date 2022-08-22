
public class Carro {
    
    //ATRIBUTOS

    private String color;
    private String matricula;
    private String modelo;
    private double cap_maxima;
    private String tipo_carro;
    private double vel_maxima;
    private boolean gasolina;
    
    //CONSTRUCTOR

    public Carro(String color, String matricula, String modelo, double cap_maxima, String tipo_carro, double vel_maxima, boolean gasolina){

        this.color = color;
        this.matricula = matricula;
        this.modelo = modelo;
        this.cap_maxima = cap_maxima;
        this.tipo_carro = tipo_carro;
        this.vel_maxima = vel_maxima;
        this.gasolina = gasolina;

    }


    //CONSULTORES

    public String getColor(){
        return color;
    }

    public String getMatricula(){
        return matricula;
    }    

    public String getModelo(){
        return modelo;
    }

    public double getCap_maxima(){
        return cap_maxima;
    }

    public String getTipocarro(){
        return tipo_carro;
    }

    public double getVel_maxima() {
        return vel_maxima;
    }

    public boolean getGasolina() {
        return gasolina;
    }

    //MODIFICADORES

    public void setColor(String color){
        this.color = color;
    }

    public void setMatricula(String matricula){
        this.matricula = matricula;
    }

    public void setModelo(String modelo){
        this.modelo = modelo;
    }

    public void setCap_maxima(double cap_maxima){
        this.cap_maxima = cap_maxima;
    }
    
    public void setTipo_carro(String tipo_carro){
        this.tipo_carro = tipo_carro;
    }

    public void setVel_maxima(double vel_maxima){
        this.vel_maxima = vel_maxima;
    }

    public void setGasolina(boolean gasolina){
        this.gasolina = gasolina;
    }

    //ACCIONES

    public void acelerar(){
        System.out.println("Acelerando...");
    }

    public void frenar(){
        System.out.println("Frenando...");
    }

    public void girar_dere(){
        System.out.println("Girando a la derecha...");
    }

    public void girar_izq(){
        System.out.println("Girando a la izquierda...");
    }

}
