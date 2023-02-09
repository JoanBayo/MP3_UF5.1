package Activitat7;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class A7 implements Serializable {
    static ArrayList<String> cartes = new ArrayList<String>();
    static ArrayList<String> cartes2 = new ArrayList<String>();


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner teclat = new Scanner(System.in);

        try {
            while (true) {
                ArrayList<carta> barallaCartes = new ArrayList<carta>();
                ArrayList<carta> barallaCartesMesclada = new ArrayList<carta>();
                File file = new File("cartes.txt");
                ObjectInputStream read = new ObjectInputStream(new FileInputStream(file));
                ObjectOutputStream write = new ObjectOutputStream(new FileOutputStream(file));

                String finalitzarPartida;
                for (int i = 1; i <= 12; i++) {
                    carta o = new carta(i, "ORS");
                    carta c = new carta(i, "COPES");
                    carta e = new carta(i, "ESPASES");
                    carta b = new carta(i, "BASTOS");

                    barallaCartes.add(o);
                    barallaCartes.add(e);
                    barallaCartes.add(c);
                    barallaCartes.add(b);
                }

                for (int i = 0; i < barallaCartes.size(); i++) {
                    //System.out.print(barallaCartes.get(i).numero + barallaCartes.get(i).pal + "\n");
                }

                for (int i = 0; i < 48; i++) {
                    int numero = (int) (Math.random() * barallaCartes.size() + 0);
                    barallaCartesMesclada.add(barallaCartes.remove(numero));
                }

                int mida = barallaCartesMesclada.size();
                for (int f = 0; f < mida; f++) {
                    write.writeObject(barallaCartesMesclada.remove(0));
                }


                for (int j = 0; j < mida; j++) {
                    barallaCartesMesclada.add((carta) read.readObject());
                    //System.out.println(barallaCartesMesclada.get(j).pal + barallaCartesMesclada.get(j).pal);
                }
                //System.out.println(barallaCartesMesclada.size());

                read.close();
                int puntsJugador1 = 0;
                int puntsJugador2 = 0;

                System.out.print("Jugador 1: ");
                String nomJugador1 = teclat.nextLine();

                System.out.print("Jugador 2: ");
                String nomJugador2 = teclat.nextLine();
                System.out.println();
                System.out.println("Inici partida: ");
                while (barallaCartesMesclada.size() != 0) {
                    System.out.println("Carta " + nomJugador1 + ":");
                    carta cartesJugador1 = barallaCartesMesclada.remove(0);
                    System.out.println(cartesJugador1.numero + " " + cartesJugador1.pal);

                    System.out.println("Carta " + nomJugador2 + ":");
                    carta cartesJugador2 = barallaCartesMesclada.remove(0);
                    System.out.println(cartesJugador2.numero + " " + cartesJugador2.pal);


                    if (cartesJugador1.numero > cartesJugador2.numero) {
                        puntsJugador1++;
                    } else if (cartesJugador1.numero < cartesJugador2.numero) {
                        puntsJugador2++;
                    } else {
                        puntsJugador1++;
                        puntsJugador2++;
                    }
                    System.out.println("Recompte de punts: ");
                    System.out.println(nomJugador1 + " aquest són els teus punts: " + puntsJugador1);
                    System.out.println(nomJugador2 + " aquest són els teus punts: " + puntsJugador2);
                    System.out.println();
                }
                System.out.println("FINAL DE LA PARTIDA");
                System.out.println("Puntuació final: ");
                System.out.println(nomJugador1 + " aquest són els teus punts: " + puntsJugador1);
                System.out.println(nomJugador2 + " aquest són els teus punts: " + puntsJugador2);

                System.out.println();
                System.out.println();
                if (puntsJugador1 > puntsJugador2) {
                    System.out.println("Enhorabona " + nomJugador1 + ", has guanyat la partida");
                } else if (puntsJugador1 < puntsJugador2) {
                    System.out.println("Enhorabona " + nomJugador2 + ", has guanyat la partida");
                } else {
                    System.out.println("La partida a quedat en empat");
                }
                System.out.println();
                System.out.println();

                System.out.println("""
                        Vols tornar a jugar?
                        - Si
                        - No
                        Resposta:\s""");
                finalitzarPartida = teclat.nextLine();
                finalitzarPartida = finalitzarPartida.toUpperCase();
                if (finalitzarPartida.equals("NO")) {
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("Algo a fallat, tornar a provar-ho");
        }
    }
}