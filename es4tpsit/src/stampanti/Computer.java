package stampanti;

public class Computer extends Thread{
    public static Stampante [] stampantiBiblioteca;
    private static Documento [] codaDiStampa;
    private static String [] tipi={"jpg","pdf","img","jpeg"};
    private int numeroDocumenti;
    private static int indiceInCodaDiStampa=0;

    //Set e get
    public static Documento getDocumento(int indice) { return codaDiStampa[indice]; }
    public void setNumeroDocumenti(int numeroDocumenti) {
        if (numeroDocumenti < 0)
            this.numeroDocumenti = 1; //Default
        else
            this.numeroDocumenti = numeroDocumenti;
    }

    //Costruttore
    public Computer (int numeroDocumenti){
        setNumeroDocumenti(numeroDocumenti);
        codaDiStampa=new Documento[numeroDocumenti];
        stampantiBiblioteca = new Stampante[4];
        inizializzaStampanti();
        inizializzaCodaDiStampa();
    }

    //Metodi inizializzazione stampanti x simulare la presenza di 4 diverse stampanti con caratteristiche diverse
    private void inizializzaStampanti(){
        for (int i=0; i<stampantiBiblioteca.length;i++){
            stampantiBiblioteca[i]=new Stampante("S"+i,isColoredEstrazione(),(Math.random()*1)+1);
        }
    }
    private boolean isColoredEstrazione(){
        if (Math.random()*10 > 5)
            return true;
        else
            return false;
    }

    //Metodi creazione finta coda di stampa
    private void inizializzaCodaDiStampa (){
        for (int i=0; i<numeroDocumenti;i++){
            codaDiStampa[i]=new Documento(isColoredEstrazione(),(int) (Math.random()*5),tipi[(int) (Math.random()*3)],(int) ((Math.random()*10)+1));
        }
    }

    //Metodi di stampa e decisione su quale stampante stampare
    public void ricercaStampanteCorretta(int indiceInCodaDiStampa) {
        Stampante stampanteSelezionataPerStampa = null;
        int minCompitiAssegnati = Integer.MAX_VALUE; // Inizialmente impostato a un valore molto alto

        // Scorri tutte le stampanti per trovare quella supportata con meno compiti assegnati
        for (Stampante stampante : stampantiBiblioteca) {
            if (stampante.isSupported(codaDiStampa[indiceInCodaDiStampa])) {
                // Se questa stampante ha meno compiti assegnati, aggiorna la selezione
                if (stampante.getCompitiAssegnati() < minCompitiAssegnati) {
                    minCompitiAssegnati = stampante.getCompitiAssegnati();
                    stampanteSelezionataPerStampa = stampante;
                }
            }
        }

        // Se è stata trovata una stampante supportata, assegnale il documento
        if (stampanteSelezionataPerStampa != null) {
            stampanteSelezionataPerStampa.addCodaDiStampaPersonale(indiceInCodaDiStampa);
            } else {
            System.out.println("Trovato documento senza supporto da alcuna stampante presente.");
        }

    }

    //Riordina in base alla priorità
    public void riordinaInBaseAllaPriorità(){
        int min;
        Documento temp;
        for (int i=0;i<codaDiStampa.length-1;i++){ //Selection Sort
            min=i;
            for (int l=i+1;l<codaDiStampa.length;l++){
                if (codaDiStampa[min].getPriorità()>codaDiStampa[l].getPriorità())
                    min=l;
            }
            temp=codaDiStampa[min];
            codaDiStampa[min]=codaDiStampa[i];
            codaDiStampa[i]=temp;
        }
    }

    //Assegno documenti alle stampanti
    public void run() {
        riordinaInBaseAllaPriorità();
        while (indiceInCodaDiStampa<codaDiStampa.length){
            ricercaStampanteCorretta(indiceInCodaDiStampa);
            indiceInCodaDiStampa++;
        }
    }
}
