import java.util.Objects;
import java.util.Scanner;

public class A1_BATTLESHIP {

    //Creem un array per fer el tauler amb numeros
    static int[][] tablero = new int[10][10];

    static int[][] tablerojoc = new int[10][10];
    static int missil;


    static int contador;
    static int victoria;


    public static void main(String[] args) {
        Scanner teclat = new Scanner(System.in);
        int end = 0;
        while (end == 0) {
            contador = 50;
            victoria = 0;
            System.out.println(".______        ___      .___________..___________. __       _______      _______. __    __   __  .______   \n" +
                    "|   _  \\      /   \\     |           ||           ||  |     |   ____|    /       ||  |  |  | |  | |   _  \\  \n" +
                    "|  |_)  |    /  ^  \\    `---|  |----``---|  |----`|  |     |  |__      |   (----`|  |__|  | |  | |  |_)  | \n" +
                    "|   _  <    /  /_\\  \\       |  |         |  |     |  |     |   __|      \\   \\    |   __   | |  | |   ___/  \n" +
                    "|  |_)  |  /  _____  \\      |  |         |  |     |  `----.|  |____ .----)   |   |  |  |  | |  | |  |      \n" +
                    "|______/  /__/     \\__\\     |__|         |__|     |_______||_______||_______/    |__|  |__| |__| | _|      \n" +
                    "                                                                                                           ");
            System.out.println("Ben vingut a BATTLESHIP el joc en el qual tens que afonar la flota enemiga, els barcos per afonar son els següents:\n" +
                    "- 1 Porta avions (ocupa 6 caselles) ⛵\n" +
                    "- 1 Porta carregues (ocupa 5 caselles) \uD83D\uDEA4\n" +
                    "- 1 Submari (ocupen 3 caselles) \uD83D\uDEF6\n" +
                    "- 1 Creuer (ocupa 3 caselles) \uD83D\uDEE5\n" +
                    "- 1 llanxa (ocupa 2 caselles) \uD83D\uDEA3\uD83C\uDFFB\n" +
                    "Tindras que ficar les cordenades(B9) per tal de llençar els missil n el seüent tauler fins derrumbar tots els barcos rivals\n" +
                    "Prem ENTER per començar el joc!\n");

            barco1();
            barco2();
            barco3();
            barco4();
            barco5();
            creartablerojoc();
            teclat.nextLine();
            //mostrarbarcos();
            jugar();
            System.out.println("Vols tornar a jugar? (SI/NO)");
            String resposta = teclat.nextLine();
            if (Objects.equals(resposta, "SI")) {
                end = 0;
            } else if (Objects.equals(resposta, "NO")) {
                end = 1;
                System.out.println("Gracies per jugar!");
            }
        }


    }


    private static void creartablerojoc() {
        //Creem una array per posar les lletres en el tauler
        String[] lletres = new String[]{" A ", " B ", " C ", " D ", " E ", " F ", " G ", " H ", " I ", " J "};

        //Posem els numeros de les cordenades del tauler
        System.out.println("\uD83E\uDDED 1  2  3  4  5  6  7  8  9  10");

        //Creem un for per tal de crear una matriu del tauler
        for (int i = 0; i < tablerojoc.length; i++) {
            //Introduim les lletres de les cordenades en el tauler
            System.out.print(lletres[i]);
            for (int j = 0; j < tablerojoc.length; j++) {
                //Creem el tauler amb 0
                if (tablerojoc[i][j] >= 0) {
                    System.out.print("💦 ");
                } else if (tablerojoc[i][j] == 1) {
                    System.out.println("⛵");
                }
            }
            System.out.println();
        }
    }

    public static void tauler() {
        //Creem una array per posar les lletres en el tauler
        String[] lletres = new String[]{" A ", " B ", " C ", " D ", " E ", " F ", " G ", " H ", " I ", " J "};

        //Posem els numeros de les cordenades del tauler
        System.out.println("\uD83E\uDDED 1  2  3  4  5  6  7  8  9  10");

        //Creem un for per tal de crear una matriu del tauler
        for (int i = 0; i < tablero.length; i++) {
            //Introduim les lletres de les cordenades en el tauler
            System.out.print(lletres[i]);
            for (int j = 0; j < tablero.length; j++) {
                //Creem el tauler amb 0
                if (tablero[i][j] == 0) {
                    System.out.print("💦 ");
                }
            }
            System.out.println();
        }
    }

    public static void barco1() {
        //PRIMER BARCO I OCUPA 6 LLOCS
        int tamany = 5;
        int tipusbarco = 1;
        //En cas que sigui igual a 1 serà vertical
        if (direcciobarcos() == 1) {
            colocarbarcohoritzontal(tamany, tipusbarco);
        } else {
            colocarbarcovertical(tamany, tipusbarco);
        }
    }


    public static void barco2() {
        //SEGON BARCO I OCUPA 5 LLOCS
        int tamany = 4;
        int tipusbarco = 2;
        //En cas de que sigui igual a 1 serà vertical
        if (direcciobarcos() == 1) {
            colocarbarcohoritzontal(tamany, tipusbarco);
        } else {
            colocarbarcovertical(tamany, tipusbarco);
        }
    }


    public static void barco3() {
        //TERCER BARCO I OCUPA 3 LLOCS
        int tamany = 2;
        int tipusbarco = 3;
        //En cas de que sigui igual a 1 serà vertical
        if (direcciobarcos() == 1) {
            colocarbarcohoritzontal(tamany, tipusbarco);
        } else {
            colocarbarcovertical(tamany, tipusbarco);
        }
    }


    public static void barco4() {
        //QUART BARCO I OCUPA 3 LLOCS
        int tamany = 2;
        int tipusbarco = 4;
        //En cas de que sigui igual a 1 serà vertical
        if (direcciobarcos() == 1) {
            colocarbarcohoritzontal(tamany, tipusbarco);
        } else {
            colocarbarcovertical(tamany, tipusbarco);
        }
    }


    public static void barco5() {
        //CINQUE BARCO I OCUPA 2 LLOCS
        int tamany = 1;
        int tipusbarco = 5;
        //En cas que sigui igual a 1 serà vertical
        if (direcciobarcos() == 1) {
            colocarbarcohoritzontal(tamany, tipusbarco);
        } else {
            colocarbarcovertical(tamany, tipusbarco);
        }
    }

    public static int direcciobarcos() {
        //Generem de forma aleatoria com serà la direcció del nostre barco ja sigui horitzontal o vertical
        int direccio = (int) (Math.random() * 2);
        return direccio;
    }

    private static void colocarbarcohoritzontal(int tamany, int tipusbarco) {
        //generem numeros aleatoris per tal de saber les cordenades X i Y del cap del barco
        int capfiles = (int) (Math.random() * 10);
        int capcolumnes = (int) (Math.random() * 10);
        int suma = 0;
        //En aquest cas posarem un do while per tal de que ho fase abans de comprovar el que li demanem amb el while
        do {
            //En aquest cas posem un do while per tal de que quan torne a repetir el do while anterior també ho faci aquest
            do {
                //Comprovem que alhora de fer la creació del barco per complet es trobi dintre del tauler
                capfiles = (int) (Math.random() * 10);
                capcolumnes = (int) (Math.random() * 10);
            } while (capcolumnes + tamany >= 10);
            suma = 0;
            for (int j = capcolumnes; j <= capcolumnes + tamany; j++) {
                suma = suma + tablero[capfiles][j];
            }
        } while (suma != 0);
        //printejem el barco en el tauler
        for (int j = capcolumnes; j <= capcolumnes + tamany; j++) {
            tablero[capfiles][j] = tipusbarco;
        }
    }

    private static void colocarbarcovertical(int tamany, int tipusbarco) {
        //generem numeros aleatoris per tal de saber les cordenades X i Y del cap del barco
        int capfiles = (int) (Math.random() * 10);
        int capcolumnes = (int) (Math.random() * 10);

        int suma = 0;
        //En aquest cas posarem un do while per tal de que ho fase abans de comprovar el que li demanem amb el while
        do {
            //En aquest cas posem un do while per tal de que quan torne a repetir el do while anterior també ho faci aquest
            do {
                //Comprovem que alhora de fer la creació del barco per complet es trobi dintre del tauler
                capfiles = (int) (Math.random() * 10);
                capcolumnes = (int) (Math.random() * 10);
            } while (capfiles + tamany >= 10);
            suma = 0;
            for (int i = capfiles; i <= capfiles + tamany; i++) {
                suma = suma + tablero[i][capcolumnes];
            }
        } while (suma != 0);

        //printejem el barco en el tauler
        for (int i = capfiles; i <= capfiles + tamany; i++) {
            tablero[i][capcolumnes] = tipusbarco;
        }
    }

    public static void mostrarbarcos() {
        String[] lletres = new String[]{" A ", " B ", " C ", " D ", " E ", " F ", " G ", " H ", " I ", " J "};

        //Posem els numeros de les cordenades del tauler
        System.out.println("\uD83E\uDDED 1  2  3  4  5  6  7  8  9  10");

        //Creem un for per tal de crear una matriu del tauler
        for (int i = 0; i < tablero.length; i++) {
            //Introduim les lletres de les cordenades en el tauler
            System.out.print(lletres[i]);
            for (int j = 0; j < tablero.length; j++) {
                //Creem el tauler amb 0
                if (tablero[i][j] == 0) {
                    System.out.print("\uD83D\uDCA6");
                } else if (tablero[i][j] == 1) {
                    System.out.print("⛵");
                } else if (tablero[i][j] == 2) {
                    System.out.print("\uD83D\uDEA4");
                } else if (tablero[i][j] == 3) {
                    System.out.print("\uD83D\uDEF6");
                } else if (tablero[i][j] == 4) {
                    System.out.print("\uD83D\uDEE5");
                } else if (tablero[i][j] == 5) {
                    System.out.print("\uD83D\uDEA3\uD83C\uDFFB");
                }

                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }

    public static void jugar() {
        while (contador > 0 && victoria < 19) {
            if (lleguirCordenades() > 0) {
                System.out.println("TOCAT!");
                contador--;
                victoria++;
                tocat();
            } else {
                System.out.println("AIGUA!");
                contador--;
            }
        }
        if (contador==0){
            System.out.println("\nOHHHH\n" +
                    "Has perdut, no et queden mes missils!\n");
        } else System.out.println("\nFELICITATS!\n" +
                "HAS AFONAT LA FLOTA RIBAL!\n");
    }

    private static int lleguirCordenades() {
        Scanner teclat = new Scanner(System.in);
        int lletranumero = 0;
        System.out.println("\nOn vols tirar el missil? (Exempre: D4)\n" +
                "Et queden " + contador + " missils");
        //lleguim les cordenades en una sola linea
        String cordenades = teclat.nextLine();
        //Agafem el caracter de la primera part de la String
        char lletra = cordenades.charAt(0);
        //descartem la primera part de la String i agafem el resto
        String numeroenlletra = cordenades.substring(1);
        //passem a numero el que ens queda de String
        int numero = Integer.parseInt(numeroenlletra) - 1;

        //leguim la string com un número per tal de poder-la situar en el tauler
        if (lletra == 'A') {
            lletranumero = 0;
        } else if (lletra == 'B') {
            lletranumero = 1;
        } else if (lletra == 'C') {
            lletranumero = 2;
        } else if (lletra == 'D') {
            lletranumero = 3;
        } else if (lletra == 'E') {
            lletranumero = 4;
        } else if (lletra == 'F') {
            lletranumero = 5;
        } else if (lletra == 'G') {
            lletranumero = 6;
        } else if (lletra == 'H') {
            lletranumero = 7;
        } else if (lletra == 'I') {
            lletranumero = 8;
        } else if (lletra == 'J') {
            lletranumero = 9;
        }
        //retornem la poscio donada en el tablero
        missil = tablero[lletranumero][numero];
        if (missil == 0) {
            missil = 6;
        }
        tablerojoc[lletranumero][numero] = missil;
        System.out.println();
        //Creem una array per posar les lletres en el tauler
        String[] lletres = new String[]{" A ", " B ", " C ", " D ", " E ", " F ", " G ", " H ", " I ", " J "};

        //Posem els numeros de les cordenades del tauler
        System.out.println("\uD83E\uDDED 1  2  3  4  5  6  7  8  9  10");

        //Creem un for per tal de crear una matriu del tauler
        for (int i = 0; i < tablerojoc.length; i++) {
            //Introduim les lletres de les cordenades en el tauler
            System.out.print(lletres[i]);
            for (int j = 0; j < tablerojoc.length; j++) {
                //Creem el tauler amb 0
                if (tablerojoc[i][j] == 6) {
                    System.out.print("\uD83D\uDD34 ");
                } else if (tablerojoc[i][j] == 1) {
                    System.out.print("⛵ ");
                } else if (tablerojoc[i][j] == 2) {
                    System.out.print("\uD83D\uDEA4 ");
                } else if (tablerojoc[i][j] == 3) {
                    System.out.print("\uD83D\uDEF6 ");
                } else if (tablerojoc[i][j] == 4) {
                    System.out.print("\uD83D\uDEE5️");
                } else if (tablerojoc[i][j] == 5) {
                    System.out.print("\uD83D\uDEA3\uD83C\uDFFB ");
                } else if (tablerojoc[i][j] == 0) {
                    System.out.print("💦 ");
                }
            }
            System.out.println();
        }
        System.out.println();

        return tablero[lletranumero][numero];

    }

    private static void tocat() {
        if (missil == 1) {
            System.out.println("En la posició seleccionada és troba el PORTA AVIONS");
        } else if (missil == 2) {
            System.out.println("En la posició seleccionada és troba el PORTA CARREGUES");
        } else if (missil == 3) {
            System.out.println("En la posició seleccionada és troba el SUBMARI");
        } else if (missil == 4) {
            System.out.println("En la posició seleccionada és troba el CREUER");
        } else if (missil == 5) {
            System.out.println("En la posició seleccionada és troba la LANXA");
        }
    }


}
