package Activitat4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class programaExpedients {


    public static void main(String[] args) {
        while (true){
            menuInicial();
        }


    }

    private static void menuInicial() {
        Scanner teclat = new Scanner(System.in);
        System.out.println("Aquestes són les opcions que et proporciona el programa:" +
            "\n1- Treballar amb UFs" +
            "\n2- Treballar amb Moduls" +
            "\n3- Treballar amb Expedinets" +
            "\nAmb que vols treballar? ");

        int opcioMenu = teclat.nextInt();
        if(opcioMenu == 1){
            menuUFs();
        }else if(opcioMenu == 2){
            menuModuls();
        }else if(opcioMenu == 3){
            menuExpedients();
        }else if(opcioMenu<1 || opcioMenu>3){
            System.out.println("Valor incorrecte\n");
        }

    }


    private static void menuUFs() {
        Scanner teclat = new Scanner(System.in);

        int codi = 0;
        String nom = null;
        int hores = 0;
        int nota = 0;

        System.out.println("\nDintre del menu de UFs tens les següents opcions: " +
                "\n1- Crear UF" +
                "\n2- Modificar UF" +
                "\n3- Esborrar UF" +
                "\n4- Mostrar les dades d'una UF" +
                "\n5- Llistar les UFs que hi ha a memòria" +
                "\n6- Guardar la llista de UFs a disc" +
                "\nQue vols fer? ");

        int opcioMenu = teclat.nextInt();
        if(opcioMenu == 1) {
            do {
                try {
                    System.out.println("Introdueix el codi: ");
                    codi = teclat.nextInt();
                    teclat.nextLine();
                    if (codi <= 0) {
                        System.out.println("Valor incorrecte");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Valor incorrecte");
                    teclat.nextLine();
                }
            } while (!validarCodi_Hores(codi));
            do {
                    System.out.println("Introdueix el nom: ");
                    nom = teclat.nextLine();
                    if (nom == null) {
                        System.out.println("Valor incorrecte");
                    }
            } while (!validarNom(nom));
            do {
                try {
                    System.out.println("Introdueix les hores: ");
                    hores = teclat.nextInt();
                    teclat.nextLine();
                    if (hores <= 0) {
                        System.out.println("Valor incorrecte");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Valor incorrecte");
                    teclat.nextLine();
                }
            } while (!validarCodi_Hores(hores));
            do {
                try {
                    System.out.println("Introdueix la nota: ");
                    nota = teclat.nextInt();
                    teclat.nextLine();
                    if (nota <= 0 && nota>10) {
                        System.out.println("Valor incorrecte");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Valor incorrecte");
                    teclat.nextLine();
                }
            } while (!validarNota(nota));

        }else if(opcioMenu == 2){
        }else if(opcioMenu == 3){
        }else if(opcioMenu == 4){
        }else if(opcioMenu == 5){
        }else if(opcioMenu == 6){
        }else if(opcioMenu<1 || opcioMenu>6){
            System.out.println("Valor incorrecte");
        }


    }
    private static boolean validarCodi_Hores(int codi) {
        boolean validat = false;
        if (codi > 0) validat = true;
        return validat;
    }
    private static boolean validarNom(String nom) {
        boolean validat = false;
        if (nom != null) validat = true;
        return validat;
    }
    private static boolean validarNota(int nota) {
        boolean validat = false;
        if (nota > 0 && nota<10 ) validat = true;
        return validat;
    }




    private static void menuModuls() {
        Scanner teclat = new Scanner(System.in);
        System.out.println("\nDintre del menu de Mòduls tens les següents opcions: " +
                "\n1- Crear Modul" +
                "\n2- Modificar Modul" +
                "\n3- Esborrar Modul" +
                "\n4- Llistar Modul" +
                "\n5- Escollir un Modul per llista les seves UFs");

        int opcioMenu = teclat.nextInt();
        if(opcioMenu == 1){
            ClasseModul modul = new ClasseModul(2,"d");
            modul.crearModul();
        }else if(opcioMenu == 2){
            ClasseModul modul = new ClasseModul(2,"d");
            modul.modificarModul();
        }else if(opcioMenu == 3){
            ClasseModul modul = new ClasseModul(2,"d");
            modul.esborrarModul();
        }else if(opcioMenu == 4){
            ClasseModul modul = new ClasseModul(2,"d");
            modul.llistarModul();
        }else if(opcioMenu == 5){
            ClasseModul modul = new ClasseModul(2,"d");
            modul.llistarUFsModuls();
        }else if(opcioMenu<1 || opcioMenu>6){
            System.out.println("Valor incorrecte");
        }
    }

    private static void menuExpedients() {
        Scanner teclat = new Scanner(System.in);

        System.out.println("\nDintre del menu de Expedients tens les següents opcions: " +
                "\n1- Crear Expedient" +
                "\n2- Modificar Expedient" +
                "\n3- Esborrar Expedient" +
                "\n4- Llistar Expedient" +
                "\nQue vols fer? ");

        int opcioMenu = teclat.nextInt();
        if(opcioMenu == 1){
            ClasseExpedinet expedinet = new ClasseExpedinet(2,"d");
            expedinet.crearExpedient();
        }else if(opcioMenu == 2){
            ClasseExpedinet expedinet = new ClasseExpedinet(2,"d");
            expedinet.modificarExpedient();
        }else if(opcioMenu == 3){
            ClasseExpedinet expedinet = new ClasseExpedinet(2,"d");
            expedinet.esborrarExpedient();
        }else if(opcioMenu == 4){
            ClasseExpedinet expedinet = new ClasseExpedinet(2,"d");
            expedinet.llistarExpedient();
        }else if(opcioMenu<1 || opcioMenu>4){
            System.out.println("Valor incorrecte");
        }
    }


}
