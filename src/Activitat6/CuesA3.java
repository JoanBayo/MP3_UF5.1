package Activitat6;

import java.util.LinkedList;
import java.util.Scanner;

public class CuesA3 {
    public static void main(String[] args) {
        String stringAux = null;
        Scanner teclat = new Scanner(System.in);
        System.out.println("Introdueix paraules a la llista, quan vulguis para fican espai buid i es tancara la llista automaticament");
        LinkedList<String> cua = new LinkedList<>();
        while (true) {
            System.out.print("String: ");
            String s = teclat.nextLine();
            if (s.length() == 0) break;
            cua.add(s);
        }

        while (cua.peek() != null) {
            stringAux = cua.remove();
            int length = stringAux.length();
            System.out.println(length);
        }
    }
}


