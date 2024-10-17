package cinema;

public class Main {
    public static void main(String[] args) {
        Coda personeInFila=new Coda(30);
        Cassa c1=new Cassa("Addetto 1",personeInFila);
        Cassa c2=new Cassa("Addetto 2",personeInFila);
        Cassa c3=new Cassa("Addetto 3",personeInFila);

        //Avvio
        c1.start();
        c2.start();
        c3.start();
    }
}