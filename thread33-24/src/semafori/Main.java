package semafori;

public class Main extends Thread{
    public static void main(String[] args) {
        Incrocio incrocioPonteCurno = new Incrocio();
        int semaforiInseriti=0;
        SemaforiATempo est=new SemaforiATempo(incrocioPonteCurno,"Est",4);
        semaforiInseriti++;
        SemaforiATempo ovest=new SemaforiATempo(incrocioPonteCurno,"Ovest",7);
        semaforiInseriti++;
        SemaforiASensore nord=new SemaforiASensore(incrocioPonteCurno,"Nord");
        semaforiInseriti++;
        Incrocio.inserisciSemafori(semaforiInseriti);

        //Inizio programma
        est.start();
        ovest.start();
        nord.start();
    }
}