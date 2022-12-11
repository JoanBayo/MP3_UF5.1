package Activitat5;

import java.io.BufferedWriter;
import java.io.File;
import java.io.*;
import java.io.IOException;
import java.util.*;
import java.util.Collection;
import java.util.Scanner;

public class OrdenarPelis {
    static ArrayList<String> pelis = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {
        Scanner teclat = new Scanner(System.in);
        while (true){
            System.out.println("1. Introduir una peli\n" +
                    "2. LListar les pelis\n" +
                    "3. Sortir\n" +
                    "Que vols fer? ");
            int resposta = teclat.nextInt();

            if (resposta == 3){
                System.out.println("Andusiauu!");
                break;
            }

            if (resposta == 1) {

                llegirPelis();

//                    FileReader fileReader = new FileReader("pelis.txt");
//                    BufferedReader bufferedReader = new BufferedReader(fileReader);
//                    String fraseActual ="";
//                    while ((fraseActual = bufferedReader.readLine())!=null){
//                        pelis.add(titul);
//                        bufferedWriter.write(titul);
//                        bufferedWriter.newLine();
//                        bufferedWriter.close();
//                    }
//                    bufferedReader.close();
//                    Collections.sort(pelis);
//
//
//                }catch (IOException e){
//                    e.printStackTrace();
//                }
//            }
            }

            if (resposta == 2) {
                try {
                    FileReader fileReader = new FileReader("pelis.txt");
                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    String fraseActual = "";
                    while ((fraseActual = bufferedReader.readLine()) != null) {
                        System.out.println(fraseActual);
                    }

                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }

    }




    private static void llegirPelis(){
        Scanner teclat = new Scanner(System.in);

            System.out.println("Introdueix el titul de la peli: ");
            String titul = teclat.next();
            pelis.add(titul);
            Collections.sort(pelis);
            System.out.println(pelis);



//            FileWriter FileWriter = new FileWriter("pelis.txt");
//            BufferedWriter bufferedWriter = new BufferedWriter(FileWriter);
//            System.out.println("Introdueix el titul de la peli: ");
//            String titul = teclat.next();
//            bufferedWriter.write(titul);
//            bufferedWriter.newLine();

    }


}


