package semafori;

public class Incrocio extends Thread{
    private String semaforoAttivo="Avvio In Corso";
    private String semaforoPassato="Avvio In Corso";

    public void cambioSemaforo(String semaforoNuovo){
        semaforoPassato=semaforoAttivo;
        semaforoAttivo=semaforoNuovo;
        System.out.println("Il semaforo attivo ora è: "+semaforoAttivo+" invece "+semaforoPassato+" è tornato rosso.");
    }

}
