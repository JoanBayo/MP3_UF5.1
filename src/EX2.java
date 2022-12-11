import java.util.Scanner;

public class EX2 {

    public static void main(String[] args) {
        Scanner teclat = new Scanner(System.in);
        System.out.println("Quans elements posaras a la llista?");
        String numeroElements = teclat.nextLine();
        int llista = Integer.parseInt(numeroElements);
        String[] elements = new String[llista];
        for (int j = 0; j < llista; j++) {
            System.out.println("Nombra l'element " + (j+1) +":");
            elements[j] = teclat.nextLine();
        }


        System.out.println("Aquest son els elements que vols posar:");
        for (int j = 0; j < llista; j++) {
            System.out.println((j+1) + "." + " " + elements[j]);

        }

    }
}
