package Activitat6;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Scanner;

public class CuesA4 {
    public static void main(String[] args) {
        String StringAux = null;
        Scanner teclat = new Scanner(System.in);
        System.out.println("Introdueix caracters a la llista, quan vulguis para una string buida i es tancara la llista automaticament");
        LinkedList<String> cua = new LinkedList<>();
        while(true){
            System.out.print("String: ");
            String s = teclat.nextLine();
            s = s.toUpperCase();
            if (s.length() == 0 ) break;
            cua.add(s);
        }

        System.out.println("Quina paraula vols buscar?");
        String word = teclat.nextLine();
        word = word.toUpperCase();
        int contador = 0;
        while(cua.peek() != null){
            StringAux = (cua.remove());
            if (Objects.equals(StringAux, word)) contador++;
        }
        System.out.println(contador);
    }
}
