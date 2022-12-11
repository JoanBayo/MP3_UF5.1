import java.util.Objects;
import java.util.Scanner;
import java.util.Stack;

public class EX3_PILA {
    public static void main(String[] args) {
        Scanner teclat = new Scanner(System.in);
        Stack stk = new Stack();
        System.out.println("Indrdoueix paraules fins que et cances, per finalitzar escriu ADEU");
        String paraula;
        int numeroparaula=0;


        while(true){
            numeroparaula++;
            System.out.println("Intrudueix la paraula "+ numeroparaula + ":");
            paraula= teclat.nextLine();
            paraula= paraula.toUpperCase();
            if(paraula.equals("ADEU")){
                break;
            }
            stk.push(paraula);
        }
            while(!stk.empty()){
            System.out.println(stk.pop());
            }

    }
}
