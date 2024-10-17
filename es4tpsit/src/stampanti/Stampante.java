package stampanti;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Stampante extends Thread{

    private String nome;
    private boolean isSupportedColor;
    private double tempoXPagina;
    private final ArrayList <Integer> codaDiStampaPersonale=new ArrayList<>(); //Mia lista di file da stampare

    //Get, set ed add
    public String getNome() { return nome; }
    public int getCompitiAssegnati (){
        return codaDiStampaPersonale.size();
    }


    public void setTempoXPagina(double tempoXPagina) {
        if (tempoXPagina<=0)
            this.tempoXPagina = 2; //Tempo di default
        else
            this.tempoXPagina = tempoXPagina;
    }

    public void addCodaDiStampaPersonale(int indice){
        this.codaDiStampaPersonale.add(indice);
    }
    public void removeCodaDiStampaPersonale(int indice){
        this.codaDiStampaPersonale.remove(indice);
    }

    //Costruttore
    public Stampante(String nome, boolean supportedColor, double tempoXPagina){
        this.nome = nome;
        isSupportedColor = supportedColor;
        setTempoXPagina(tempoXPagina);
    }

    //Metodo controllo supporto
    public boolean isSupported(Documento example){
        return example.isColored() == this.isSupportedColor;
    }

    //Metodo stampa
    public void stampa(Documento example){
            try {
                TimeUnit.SECONDS.sleep((long) (example.getNumeroDiPagine() *this.tempoXPagina)); //Fingo tempo di stampa
            }catch(Exception e) {
                System.out.println(e);
            }
            System.out.println("Stampante: "+this.nome+" ha completato stampa di: Documento."+example.getTipo()+" di pagine "+example.getNumeroDiPagine()+" con priorità nella scaletta di stampa in base alle caratteristiche del file di: "+example.getPriorità());
    }

    public void run() {
        while (true) {
            if (!codaDiStampaPersonale.isEmpty()) {
                stampa(Computer.getDocumento(codaDiStampaPersonale.get(0)));
                removeCodaDiStampaPersonale(0);
            }
            try {
                TimeUnit.SECONDS.sleep(1); // Attendere un breve intervallo prima di rincominciare a
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
