package cinema;

public class Coda {
    private int numPersone;
    private Persona [] codaDiPersone;
    private static Integer personeServite;

    //Get e set
    public Persona[] getCoda1() { return codaDiPersone; }
    public int getNumPersone() { return numPersone; }
    public int getPersoneDaServire(){ return getNumPersone()-personeServite; }
    public Integer getPersoneServite (){ return personeServite; }
    public Persona getPersona(int indice){ return codaDiPersone[indice]; }

    public void setCoda1(Persona[] coda1) { this.codaDiPersone = coda1; }
    public void setNumPersone(int numPersone) {
        if (numPersone<0)
            this.numPersone = 0;
        else
            this.numPersone = numPersone;
    }

    //Incremento e chiamata
    public void plusContatoreServiti(){ personeServite++; }

    //Costruttore
    public Coda(int numPersone){
        personeServite=0;
        setNumPersone(numPersone);
        codaDiPersone =new Persona[this.numPersone];
        popolaCoda();
    }

    //Popola coda
    public void popolaCoda(){
        for (int i=0;i<this.codaDiPersone.length;i++){
            this.codaDiPersone[i]=new Persona();
        }
    }
}
