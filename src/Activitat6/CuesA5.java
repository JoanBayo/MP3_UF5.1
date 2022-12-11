package Activitat6;

import java.util.IllegalFormatCodePointException;
import java.util.LinkedList;
import java.util.Scanner;

public class CuesA5 {
    public static void main(String[] args) {
        String stringAux = null;
        int intAux = 0;
        Scanner teclat = new Scanner(System.in);
        System.out.println("Introdueix caracters a la llista, quan vulguis para una string buida i es tancara la llista automaticament");
        LinkedList<String> cuaString = new LinkedList<>();
        LinkedList<Integer> cuaInt = new LinkedList<>();
        while(true){
            System.out.print("String: ");
            String s = teclat.nextLine();
            if (s.length() == 0 ) {
                System.out.println();
                break;
            }
            System.out.print("Numero: ");
            int n = teclat.nextInt();

            cuaString.add(s);
            cuaInt.add(n);

        }

        while(cuaString.peek() != null){
            stringAux = (cuaString.remove());
            intAux = (cuaInt.remove());
            for (int i = 0; i < stringAux.length(); i++) {
                char lletra = stringAux.charAt(i);
                lletra =  (char) (lletra + intAux);
                System.out.print(lletra);
            }
            System.out.println();
        }
    }
}
