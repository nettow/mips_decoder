package decoders;

public class Objeto {
    public String decodado;
    public String hexa;
    public int indice;

    public Objeto(String x,String h,int a){
        this.decodado = x;
        this.hexa = h;
        this.indice = a;
    }

    public Objeto(String x){
        this.decodado = x;
    }
}