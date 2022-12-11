package Activitat6;

import java.util.LinkedList;
import java.util.Scanner;

public class CuesA1 {
    public static void main(String[] args) {
        int intAux = 0;
        Scanner teclat = new Scanner(System.in);
        System.out.println("Introdueix números a la llista, quan vulguis para fican un de negatiu i es tancara la llista automaticament");
        LinkedList<Integer> cua = new LinkedList<>();
        while(true){
            System.out.print("Numero: ");
            int n = teclat.nextInt();
            if (n < 0 ) break;
            cua.add(n);
        }

        while(cua.peek()!= null){
            System.out.println(cua.remove());
        }
    }
}
