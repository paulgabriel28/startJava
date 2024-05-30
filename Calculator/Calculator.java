import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continua = true;

        while (continua) {
            System.out.println("Alege operatia: ");
            System.out.println("1. Adunare");
            System.out.println("2. Scadere");
            System.out.println("3. Inmultire");
            System.out.println("4. Impartire");
            System.out.println("5. Iesire");

            System.out.print("Optiunea ta: ");
            int optiune = scanner.nextInt();

            switch (optiune) {
                case 1:
                    adunare();
                    break;
                case 2:
                    scadere();
                    break;
                case 3:
                    inmultire();
                    break;
                case 4:
                    impartire();
                    break;
                case 5:
                    continua = false;
                    break;
                default:
                    System.err.println("Optiune invalida!");
            }

            System.out.println("Doresti sa faci o alta operatie? (da/nu)");
            String raspuns = scanner.next();
            if (raspuns.equals("nu")) {
                continua = false;
            }
        }
        
        scanner.close();
    }

    public static int[] citesteNumere() {
        Scanner scanner = new Scanner(System.in);
        
        int numere[] = new int[2];


        System.out.print("Introdu primul numar: ");
        numere[0] = scanner.nextInt();

        System.out.print("Introdu al doilea numar: ");
        numere[1] = scanner.nextInt();

        scanner.close();

        return numere;
    }

    public static void adunare() {
        int numere[] = citesteNumere();
        int suma = numere[0] + numere[1];
        System.out.println("Suma este: " + suma);
    }

    public static void scadere() {
        int numere[] = citesteNumere();
        int diferenta = numere[0] - numere[1];
        System.out.println("Diferenta este: " + diferenta);
    }

    public static void inmultire() {
        int numere[] = citesteNumere();
        int produs = numere[0] * numere[1];
        System.out.println("Produsul este: " + produs);
    }

    public static void impartire() {
        int numere[] = citesteNumere();
        if (numere[1] == 0) {
            System.err.println("Impartire la 0 nu este posibila!");
        } else {
            double cat = (double) numere[0] / numere[1];
            System.out.println("Catul este: " + cat);
        }
    }
}
