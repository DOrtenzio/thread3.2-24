package stampanti;

public class Documento extends Thread{
    private String tipo;
    private int priorità; //Da 0 a 5; dove 0 è la + elevata; 5 la meno elevata
    private boolean isColored;
    private int numeroDiPagine;

    //Set e get
    public boolean isColored() { return isColored; }
    public int getNumeroDiPagine() { return numeroDiPagine; }
    public int getPriorità() { return priorità; }
    public String getTipo() { return tipo; }

    //Costruttore
    public Documento(boolean colored,int priorità,String tipo,int numeroDiPagine){
        this.isColored = colored;
        this.numeroDiPagine = numeroDiPagine;
        this.priorità = priorità;
        this.tipo = tipo;
    }
}
