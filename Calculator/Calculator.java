import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean continua = true;        

            while (continua) {
                System.out.println("Alege operatia: ");
                System.out.println("1. Adunare");
                System.out.println("2. Scadere");
                System.out.println("3. Inmultire");
                System.out.println("4. Impartire");
                System.out.println("5. Iesire");

                System.out.print("Optiunea ta: ");
                int optiune;

                do {
                    optiune = scanner.nextInt();

                    if (optiune < 1 || optiune > 5) {
                        System.err.println("Optiune invalida! Optiunea trebuie sa fie intre 1 si 5.");
                        System.err.print("Optiune: ");
                    }

                } while (optiune < 1 || optiune > 5);

                switch (optiune) {
                    case 1 -> adunare(scanner);
                    case 2 -> scadere(scanner);
                    case 3 -> inmultire(scanner);
                    case 4 -> impartire(scanner);
                    case 5 -> continua = false;
                    default -> System.err.println("Optiune invalida!");
                }

                if (continua == true) {
                    System.out.print("Doresti sa faci o alta operatie? (da/nu): ");
                    String raspuns;
                    do { 
                        raspuns = scanner.next();

                        if (!raspuns.equals("da") && !raspuns.equals("nu")) {
                            System.err.println("Raspuns invalid! Te rog sa alegi intre 'da' si 'nu'.");
                            System.err.print("Valoare: ");
                        }

                    } while (!raspuns.equals("da") && !raspuns.equals("nu"));

                    if (raspuns.equals("nu")) {
                        continua = false;
                    }
                }
            }

            System.err.println("Programul s-a inchis!");
            
            scanner.close();
        }
    }

    public static int[] citesteNumere(Scanner scanner) {
        int numere[] = new int[2];
    
        System.out.print("Introdu primul numar: ");
        numere[0] = scanner.nextInt();
    
        System.out.print("Introdu al doilea numar: ");
        numere[1] = scanner.nextInt();
    
        return numere;
    }

    public static void adunare(Scanner scanner) {
        int numere[] = citesteNumere(scanner);
        int suma = numere[0] + numere[1];
        System.out.println("Suma este: " + suma);
    }

    public static void scadere(Scanner scanner) {
        int numere[] = citesteNumere(scanner);
        int diferenta = numere[0] - numere[1];
        System.out.println("Diferenta este: " + diferenta);
    }

    public static void inmultire(Scanner scanner) {
        int numere[] = citesteNumere(scanner);
        int produs = numere[0] * numere[1];
        System.out.println("Produsul este: " + produs);
    }

    public static void impartire(Scanner scanner) {
        int numere[] = citesteNumere(scanner);
        if (numere[1] == 0) {
            System.err.println("Impartire la 0 nu este posibila!");
        } else {
            double cat = (double) numere[0] / numere[1];
            System.out.println("Catul este: " + cat);
        }
    }
}
