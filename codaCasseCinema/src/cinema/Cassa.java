package cinema;

import java.util.concurrent.TimeUnit;

public class Cassa extends Thread{
    private static Sala [] sale=new Sala[7];
    private static Coda coda;
    private String nome;

    //Get e set
    public static int getSale() { return sale.length; }
    public String getNome() { return this.nome; }

    public void setNome(String nome) { this.nome = nome; }

    //Costruttore
    public Cassa(String nome, Coda codaN){
        this.nome=nome;
        coda=codaN;
        inizializzaSale();
    }

    //Richiamo
    public int richiamoNumeroCliente(){
        int clienteServito;
        synchronized (coda){
            clienteServito=coda.getPersoneServite();
            coda.plusContatoreServiti();
        }
        return clienteServito;
    }

    //Inizializza sale
    public void inizializzaSale(){
        for (int i=0;i<sale.length;i++){
            sale[i]=new Sala(i);
        }
    }
    //Ricerca posto
    public int ricercaPosto(int salaCliente){
        int posto;
        synchronized (sale[salaCliente]){
            do {
                posto = (int) (Math.random() * sale[salaCliente].getPosti());
            } while (sale[salaCliente].controllaOccupazione(posto));
            sale[salaCliente].prenotaPosto(posto);
        }
        return posto;
    }

    //Azioni con cliente
    public void stampaRicevuta(){
        int numeroClienteServito=richiamoNumeroCliente();
        double prezzo=0;
        Persona clienteAttuale=coda.getPersona(numeroClienteServito);
        String s="";

        //Costituzione della ricevuta
        s=s+"Cliente servito: "+clienteAttuale.getNome()+" servito da: "+this.nome;
        for (int i=0;i<clienteAttuale.getNumBiglietti();i++){
            int posto=ricercaPosto(clienteAttuale.getSalaCheVuole());
            prezzo+=sale[clienteAttuale.getSalaCheVuole()].getPrezzo();
            s=s+"\n\tBiglietto per: "+sale[clienteAttuale.getSalaCheVuole()].getFilm()+" sala:"+clienteAttuale.getSalaCheVuole()+ "Posto: "+posto+" Fila: "+((int) (posto/10));
        }
        s=s+"\nTotale: "+prezzo+"\tBuon Film!";

        System.out.println(s);
    }

    public void run() {
        while (coda.getPersoneDaServire()>0){
            stampaRicevuta();
            try {
                TimeUnit.SECONDS.sleep(3);
            }catch (Exception e){
                System.out.println(e);
            }
        }
    }
}
