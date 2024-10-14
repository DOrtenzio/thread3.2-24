package semafori;

import java.util.concurrent.TimeUnit;

public class SemaforiASensore extends Thread{
    private final String nome;
    private final Incrocio in;

    //Costruttore
    public SemaforiASensore (Incrocio in, String nome){
        this.nome=nome;
        this.in=in;
    }

    public void run() {
        while (true){
            // Simula il rilevamento della presenza di un veicolo con un'attesa casuale
            try {
                TimeUnit.SECONDS.sleep((int) (Math.random() * 5) + 1); // Attendi tra 1 e 5 secondi
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (in){
                in.cambioSemaforo(nome);
                try {
                    TimeUnit.SECONDS.sleep(3); // Il semaforo rimane verde per 3 secondi
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
