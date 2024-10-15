package semafori;

public class Main {
    public static void main(String[] args) {
        Incrocio incrocioCentro = new Incrocio();
        SemaforiATempo est=new SemaforiATempo(incrocioCentro,"Est",4);
        SemaforiATempo ovest=new SemaforiATempo(incrocioCentro,"Ovest",7);
        SemaforoASensore nord=new SemaforoASensore(incrocioCentro,"Nord");

        //Avviamo i threads
        est.start();
        ovest.start();
        nord.start();
    }
}