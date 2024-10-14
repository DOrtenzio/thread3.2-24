package semafori;

import semafori.util.Escape;

import java.util.Scanner;

public class Incrocio extends Thread{
    private static Scanner in=new Scanner(System.in);
    private static String semaforoAttivo="Avvio In Corso";
    private static String semaforoPassato="Avvio In Corso";
    private static String [] tuttiSemafori;

    public static void inserisciSemafori(int numeroSemafori){
        tuttiSemafori=new String[numeroSemafori];
        for (int i=0; i<numeroSemafori;i++){
            System.out.println("Inserire nome semaforo n° "+(i+1)+"/"+numeroSemafori);
            tuttiSemafori[i]=in.next();
        }
    }
    public String altriSemafori(String semaforoAttivo, String semaforoPassato){
        String s=" ";
        for (int i=0; i< tuttiSemafori.length;i++){
            if (!tuttiSemafori[i].equalsIgnoreCase(semaforoAttivo) && !tuttiSemafori[i].equalsIgnoreCase(semaforoPassato))
                s=s+tuttiSemafori[i] + " " + Escape.BG_GRAY + Escape.RED + " ● " + Escape.RESET_TEXT +"● ● " + Escape.RESET;
        }
        return s;
    }

    public static String pulisci() {
        return "\033[2J";
    }

    public synchronized void cambioSemaforo(String semaforoNuovo){ //Per essere sicuri di eventuali problemi si può sincronizzare tutto il metodo ma non è necessario
        semaforoPassato=semaforoAttivo;
        semaforoAttivo=semaforoNuovo;
        System.out.println(pulisci());
        System.out.println(semaforoAttivo + " " + Escape.BG_GRAY + " ● ● " + Escape.GREEN +"● " + Escape.RESET + "\t" + semaforoPassato + " " + Escape.BG_GRAY + Escape.RED + " ● " + Escape.YELLOW +"●" + Escape.RESET_TEXT + " ● " + Escape.RESET+altriSemafori(semaforoAttivo,semaforoPassato));
    }
}
