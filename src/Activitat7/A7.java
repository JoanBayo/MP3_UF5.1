package Activitat7;

import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class A7 implements Serializable {
    static ArrayList<String> cartes = new ArrayList<String>();
    static ArrayList<String> cartes2 = new ArrayList<String>();



    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner teclat = new Scanner(System.in);


        File fitxer = new File("cartes.txt");
        carta b;

        for (int i = 1; i <= 12; i++) {
            carta a = new carta(i, "ORS");
            ObjectOutputStream fluxeEscriptura = new ObjectOutputStream(new FileOutputStream(fitxer));
            fluxeEscriptura.writeObject(a);
            fluxeEscriptura.close();        //lectura:
            ObjectInputStream fluxeLectura = new ObjectInputStream(new FileInputStream(fitxer));
            b = (carta) fluxeLectura.readObject();
            fluxeLectura.close();
            cartes.add(b.pal + " " + b.numero);
        }
        for (int i = 1; i <= 12; i++) {
            carta a = new carta(i, "COPES");
            ObjectOutputStream fluxeEscriptura = new ObjectOutputStream(new FileOutputStream(fitxer));
            fluxeEscriptura.writeObject(a);
            fluxeEscriptura.close();        //lectura:
            ObjectInputStream fluxeLectura = new ObjectInputStream(new FileInputStream(fitxer));
            b = (carta) fluxeLectura.readObject();
            fluxeLectura.close();
            cartes.add(b.pal + " " + b.numero);
        }
        for (int i = 1; i <= 12; i++) {
            carta a = new carta(i, "ESPASES");
            ObjectOutputStream fluxeEscriptura = new ObjectOutputStream(new FileOutputStream(fitxer));
            fluxeEscriptura.writeObject(a);
            fluxeEscriptura.close();        //lectura:
            ObjectInputStream fluxeLectura = new ObjectInputStream(new FileInputStream(fitxer));
            b = (carta) fluxeLectura.readObject();
            fluxeLectura.close();
            cartes.add(b.pal + " " + b.numero);
        }
        for (int i = 1; i <= 12; i++) {
            carta a = new carta(i, "BASTOS");
            ObjectOutputStream fluxeEscriptura = new ObjectOutputStream(new FileOutputStream(fitxer));
            fluxeEscriptura.writeObject(a);
            fluxeEscriptura.close();        //lectura:
            ObjectInputStream fluxeLectura = new ObjectInputStream(new FileInputStream(fitxer));
            b = (carta) fluxeLectura.readObject();
            fluxeLectura.close();
            cartes.add(b.pal + " " + b.numero);
        }

        System.out.println("Jugador 1: ");
        String jugador1 = teclat.nextLine();
        System.out.println("Jugador 2: ");
        String jugador2 = teclat.nextLine();

        while (!cartes.isEmpty()){
            partiada();

        }
    }

    private static void partiada() {
        Scanner teclat = new Scanner(System.in);

        System.out.println("Prem enter per jugar");
        teclat.next();
        for (int i = 0; i < 2; i++) {
            int numero = (int) (Math.random()*(cartes.size())+0);
            String pepe = cartes.remove(numero);
            cartes2.add(pepe);
            carta1 =

        }
    }
}