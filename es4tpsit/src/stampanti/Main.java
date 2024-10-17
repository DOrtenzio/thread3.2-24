package stampanti;

public class Main {
    public static void main(String[] args) {
        Computer pc=new Computer(35); //Tu crei solo il computer a dopo pensa tutto lui
        pc.start(); //Avvio il pc

        //Avvio le stampanti
        Computer.stampantiBiblioteca[0].start();
        Computer.stampantiBiblioteca[1].start();
        Computer.stampantiBiblioteca[2].start();
        Computer.stampantiBiblioteca[3].start();
    }
}