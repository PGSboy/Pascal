import java.util.InputMismatchException;
import java.util.Scanner;

public class Pascal {
    private static final String RESET = "\u001B[0m";
    private static  final String ORANGE = "\u001b[38;2;252;129;35m";

    static int fatorial(int n) {
        return (n > 1) ? n * fatorial(n - 1) : 1; 
    }

    static int binomial(int n, int k) {
        return (n >= k) ? fatorial(n) / (fatorial(n - k) * fatorial(k)) : 0;
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int ordem = 0;

        for (int u = 0; u < 1; u++) {
            try {
                System.out.println("Deseja ver quantas linhas do triângulo de pascal? (máx. 13)");
                System.out.print("Resp.: ");
                ordem = scan.nextInt();

                if (ordem < 1 || ordem > 13) {
                    System.err.println(ORANGE + "\nvalor inválido.. tente novamente!\n" + RESET);
                    u--;
                }
            } catch (InputMismatchException ex) {
                System.err.println(ORANGE + "\nvalor inválido.. tente novamente!\n" + RESET);
                scan.nextLine();
                u--;
            }
        }
        scan.close();

        for (int n = 0; n < ordem; n++) {
            for (int k = 0; k < ordem; k++) {
                int nbi = binomial(n, k);

                if (nbi != 0) {
                    System.out.print(String.format("%d\t", nbi));
                }
            }
            System.out.println();
        }
    }
}