package cinema;

public class Persona {
    private static final String [] nomi = {
            "Luca", "Giulia", "Marco", "Sara", "Francesco",
            "Valentina", "Matteo", "Elena", "Alessandro", "Martina"
    };
    private String nome;
    private int numBiglietti;
    private int salaCheVuole;

    //Set e get
    public String getNome() { return this.nome; }
    public int getNumBiglietti() { return this.numBiglietti; }
    public int getSalaCheVuole() { return this.salaCheVuole; }

    public void setNumBiglietti(int numBiglietti) { this.numBiglietti = numBiglietti; }
    public void setSalaCheVuole(int salaCheVuole) { this.salaCheVuole = salaCheVuole; }
    public void setNome(String nome) { this.nome = nome; }

    //Costruttore
    public Persona(){
        this.nome = nomi[(int) (Math.random()*10)];
        this.numBiglietti = (int) ((Math.random()*8)+1);
        this.salaCheVuole = (int) ((Math.random()*Cassa.getSale()));
    }
}
