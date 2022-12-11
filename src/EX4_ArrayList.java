import java.util.Scanner;
import java.util.*;
public class EX4_ArrayList {



        public static void main(String[] args) {
            ArrayList<Integer> llistaA = new ArrayList<Integer>();
            LinkedList<Integer> llistaB = new LinkedList<Integer>();


//EJERCICIS 1,2,3,4,5
//            for (int i = 0; i < 10; i++) {
//
//                llistaA.add(i);
//            }
//            llistaA.add(10);
//
//            for (int i = 0; i < llistaA.size(); i++) {
//                System.out.print(llistaA.get(i) + " ");
//            }
//
//            System.out.println();
//            //D'aquesta forma borrem el 0 el 1 i 5 ja que tal com anem borran van movent la seva posicio
//            llistaA.remove(0);
//            llistaA.remove(0);
//            llistaA.remove(3);
//
//
//            for (int i = 0; i < llistaA.size(); i++) {
//                System.out.print(llistaA.get(i) + " ");
//            }
//

//            for (int i = 0; i < 101; i++) {
//
//                llistaA.add(i);
//            }



//EJERCICIS 6,7
//            //Amb aquest for anem fican i borran i daqueta forma deixem sols els numeros sencers
//            for (int i = 1; i < llistaA.size(); i++) {
//                llistaA.remove(i);
//            }
//
//            for (int i = 0; i < llistaA.size(); i++) {
//                System.out.print(llistaA.get(i) + " ");
//            }
//
//



//EJERCICIS 8,9
            //Ara creem un ArrayList i un LinkedList de 1 000 000 i mirem quan tarda cada un
//
//            long t1 =System.currentTimeMillis();
//
//            for (int i = 0; i < 1000000; i++) {
//
//                llistaA.add(i);
//            }
//            long t2 =System.currentTimeMillis();
//
//            long t3 = t2-t1;
//            System.out.println("ArrayList: " + t3);
//
//            long t1L =System.currentTimeMillis();
//
//            for (int i = 0; i < 1000000; i++) {
//
//                llistaB.add(i);
//            }
//            long t2L =System.currentTimeMillis();
//
//            long t3L = t2L-t1L;
//            System.out.println("LinkedList: " + t3L);
//
//            long t1 =System.currentTimeMillis();
//
//            for (int i = 0; i < 10000000; i++) {
//
//                llistaA.add(i);
//            }
//            long t2 =System.currentTimeMillis();
//
//            long t3 = t2-t1;
//            System.out.println("ArrayList: " + t3);
//
//            long t1L =System.currentTimeMillis();
//
//            for (int i = 0; i < 10000000; i++) {
//
//                llistaB.add(i);
//            }
//            long t2L =System.currentTimeMillis();
//
//            long t3L = t2L-t1L;
//            System.out.println("LinkedList: " + t3L);
//
//            System.out.println("Larraylist ho crea " + (t3L-t3) + " milisegons més rapid que el Linkedlist");
        }
}





