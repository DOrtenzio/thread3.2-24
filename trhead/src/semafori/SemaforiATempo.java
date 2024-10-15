package semafori;

import java.util.concurrent.TimeUnit;

public class SemaforiATempo extends Thread {
    private final String nome;
    private final int tempo;
    private final Incrocio in;

    //Costruttori
    public SemaforiATempo (Incrocio in, String nome, int tempo){
        this.nome=nome;
        this.tempo=tempo;
        this.in=in;
    }

    public void run() {
        while(true){
            synchronized (in){
                in.cambioSemaforo(this.nome);
                try {
                    TimeUnit.SECONDS.sleep(tempo); //Attivo n secondi
                }catch(Exception e) {
                    System.out.println(e);
                }
            }
            try {
                TimeUnit.SECONDS.sleep(5); //Rosso per almeno 5 secondi o più
            }catch(Exception e) {
                System.out.println(e);
            }
        }
    }
}
