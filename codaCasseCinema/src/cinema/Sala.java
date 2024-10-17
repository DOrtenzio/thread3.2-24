package cinema;

public class Sala {
    private boolean [] posti;
    private int postiDisponibili;
    private double prezzo;
    private String film;

    // Array di film casuali
    private static final String [] nomiFilm = {
            "It", "Don Matteo: La vendetta contro Raul Bova", "Altrimenti ci arrabiamo", "Et", "Topolino e l'evasione del fisco",
            "Tutti tranne l'inps", "How I meet your debt", "Elena", "Achille dal tallone magico", "Ok"
    };

    //Costruttori
    public Sala(int posizione){
        this.postiDisponibili=(int) ((Math.random()*30)+80);
        this.posti =new boolean[this.postiDisponibili];
        this.prezzo=(Math.random()*9)+1;
        this.film=nomiFilm[posizione];
    }

    //Get e set
    public double getPrezzo() { return prezzo; }
    public int getPostiDisponibili() { return postiDisponibili; }
    public String getFilm() { return film; }
    public void setPostiDisponibili(int postiDisponibili) { this.postiDisponibili = postiDisponibili; }
    public void setPrezzo(double prezzo) { this.prezzo = prezzo; }
    public int getPosti(){ return posti.length; }

    //Prenotazione di un posto
    public void prenotaPosto(int posizionePosto){
        posti[posizionePosto]=true;
        this.postiDisponibili--;
    }

    //Controlla occupazione posto
    public boolean controllaOccupazione(int posizionePosto){
        return posti[posizionePosto];
    }


}
