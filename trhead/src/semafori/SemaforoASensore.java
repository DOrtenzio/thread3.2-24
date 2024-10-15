package semafori;

import java.util.concurrent.TimeUnit;

public class SemaforoASensore extends Thread{
    //Attributi
    private final String nome;
    private final Incrocio in;

    //Costruttore
    public SemaforoASensore (Incrocio in, String nome){
        this.nome=nome;
        this.in=in;
    }

    public void run() {
        while (true){
            // Simula il rilevamento della presenza di un veicolo con un'attesa casuale
            try {
                TimeUnit.SECONDS.sleep((int) (Math.random() * 5) + 1); // Attendi tra 1 e 5 secondi
            } catch (Exception e) {
                System.out.println(e);
            }
            synchronized (in){
                in.cambioSemaforo(nome);
                try {
                    TimeUnit.SECONDS.sleep(3); // Il semaforo rimane verde per 3 secondi
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
    }
}
