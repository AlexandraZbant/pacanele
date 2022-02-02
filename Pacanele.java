import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Pacanele {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<String> posibilitati = new ArrayList<>(Arrays.asList("DIAMANT", "CIREASA", "7", "JOKER", "RUBIN"));
    static double buget = 1000.0;
    static Random generator = new Random();

    public static void main(String[] args) {
        while (true) {
            double miza = introduMiza();
            if (miza > buget) {
                System.out.println("Nu ai suficienti bani!");
            } else {
                buget -= miza;
                ArrayList<String> valoriAlese = new ArrayList<>();
                shuffle(posibilitati, valoriAlese);
                printList(valoriAlese);
                decideOutcome(miza, valoriAlese);
                if (buget < 1) {
                    System.out.println("Ai pierdut jocul! Nu mai ai suficienti bani.");
                    break;
                }
            }
        }
    }

    private static double introduMiza() {
        System.out.println("Cat doriti sa mizati? \n (Buget= " + buget + ")");
        double miza = sc.nextDouble();
        return miza;
    }

    private static void decideOutcome(double miza, ArrayList<String> valoriAlese) {
        String primul = valoriAlese.get(0);
        String alDoilea = valoriAlese.get(1);
        String alTreilea = valoriAlese.get(2);
        String alPatrulea = valoriAlese.get(3);
        String alCincilea = valoriAlese.get(4);
        if (primul.equals(alDoilea) && alDoilea.equals(alTreilea) && alTreilea.equals(alPatrulea) && alPatrulea.equals(alCincilea)) {
            System.out.println(" JACKPOT!!!");
            buget += (miza + (miza / 3.0));
        } else if (primul.equals(alDoilea) && primul.equals(alTreilea) && primul.equals(alPatrulea) ||
                alDoilea.equals(alTreilea) && alDoilea.equals(alPatrulea) && alDoilea.equals(alCincilea) ||
                alTreilea.equals(alPatrulea) && alTreilea.equals(alCincilea) && alTreilea.equals(primul) ||
                alPatrulea.equals(alCincilea) && alPatrulea.equals(primul) && alPatrulea.equals(alDoilea) ||
                alCincilea.equals(primul) && alCincilea.equals(alDoilea) && alCincilea.equals(alTreilea)
        ) {
            System.out.println(" SEMI - JACKPOT!");
            buget += (miza + (miza / 1.5));
        } else if (primul.equals(alDoilea) && primul.equals(alTreilea) ||
                primul.equals(alPatrulea) && primul.equals(alCincilea) ||
                alDoilea.equals(alTreilea) && alDoilea.equals(alPatrulea) ||
                alDoilea.equals(alCincilea) && alDoilea.equals(primul) ||
                alTreilea.equals(alPatrulea) && alTreilea.equals(alCincilea)
        ) {
            System.out.println("SEMI-SEMI JACKPOT!");
            buget += (0.75 * miza);

        } else if (primul.equals(alDoilea) ||
                primul.equals(alTreilea) ||
                primul.equals(alPatrulea) ||
                primul.equals(alCincilea) ||
                alDoilea.equals(alTreilea) ||
                alDoilea.equals(alPatrulea) ||
                alDoilea.equals(alCincilea) ||
                alTreilea.equals(alPatrulea) ||
                alTreilea.equals(alCincilea) ||
                alPatrulea.equals(alCincilea)) {
            System.out.println(" SEMI-SEMI-SEMI - JACKPOT!");
            buget += (0.25 * miza);
        } else {
            System.out.println("Ai pierdut!");
        }
    }

    private static void shuffle(ArrayList<String> posibilitati, ArrayList<String> valoriAlese) {
        adaugaValoriAlese(posibilitati, valoriAlese);
        adaugaValoriAlese(posibilitati, valoriAlese);
        adaugaValoriAlese(posibilitati, valoriAlese);
        adaugaValoriAlese(posibilitati, valoriAlese);
        adaugaValoriAlese(posibilitati, valoriAlese);
    }

    private static void adaugaValoriAlese(ArrayList<String> posibilitati, ArrayList<String> valoriAlese) {
        valoriAlese.add(posibilitati.get(generator.nextInt(posibilitati.size())));
    }

    public static void printList(ArrayList<String> lista) {
        System.out.printf(" [%s] [%s] [%s] [%s] [%s] \n", lista.get(0), lista.get(1), lista.get(2), lista.get(3), lista.get(4));
    }
}
