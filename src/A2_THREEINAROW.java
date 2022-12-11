import java.util.Objects;
import java.util.Scanner;

public class A2_THREEINAROW {
    //Declarem les variables estatiques, per poder arrastrarles tot lo projecte
    static int[][] tablero = new int[3][3];
    static int jugada;
    static String jugador1;
    static String jugador2;
    static char lletra;
    static int numero;
    static String casellaRetorna;
    static int end;


    public static void main(String[] args) {
        //Introduiem els dos metodes principals
        introduccio();
        jugarPartida();
    }

    private static void introduccio() {
        Scanner teclat = new Scanner(System.in);
        //Posem el titol i expliquem com es juga al joc i lexplicacio, també aprofitarem per llegir el nom dels usuaris:
        System.out.println("  _____   _  _   ___   ___   ___     ___   _  _       _       ___    ___   __      __\n" +
                " |_   _| | || | | _ \\ | __| | __|   |_ _| | \\| |     /_\\     | _ \\  / _ \\  \\ \\    / /\n" +
                "   | |   | __ | |   / | _|  | _|     | |  | .` |    / _ \\    |   / | (_) |  \\ \\/ \\ /  \n" +
                "   |_|   |_||_| |_|_\\ |___| |___|   |___| |_|\\_|   /_/ \\_\\   |_|_\\  \\___/    \\_/\\_/  \n" +
                "                                                                                     \n");
        System.out.println("Com jugar:\n" +
                "Cada jugador tindra una figura, el jugador 1 tindra la figura \uD83D\uDD35 i el jugador 2 la figura \uD83D\uDD34,al vostre torn teniu de posar la vostra figura dintre del tauler, intentant aconseguir 3 seguides en una línia vertical, horitzontal o diagonal. Un cop s'omplen tots els espais s'acaba la partida, finalitzant en empat si cap no aconsegueix enllaçar tres de les seves fitxes seguides.");
        System.out.println("Anem a jugar!");
        //Demanen als participans els seus noms
        System.out.println("Introdui els vostre noms:");
        System.out.println("Jugador 1: ");
        jugador1 = teclat.nextLine();
        System.out.println("Jugador 2: ");
        jugador2 = teclat.nextLine();

    }

    private static void jugarPartida() {
        //Aquest metode en serviex per no sortir del joc fins que els jugadors vulguen parar de jugar
        printejarTablero();
        //Fiquem jugador == 0 ja que d'aquesta forma en cas de que es reinicie la partida no donara error
        jugada=0;
        do {
            TriarJugador();
        } while (end!=13);
        end=0;
        tornarajugar();
    }


    private static void printejarTablero() {
        System.out.println();
        //Creem una array per posar les lletres en el tauler
        String[] lletres = new String[]{" A ", " B ", " C "};

        //Posem els numeros de les cordenades del tauler
        System.out.println("\uD83C\uDF00 1  2  3");

        //Creem un for per tal de crear una matriu del tauler
        for (int i = 0; i < tablero.length; i++) {
            //Introduim les lletres de les cordenades en el tauler
            System.out.print(lletres[i]);
            for (int j = 0; j < tablero.length; j++) {
                //Donem el valor de 0 ja que aquest sera una casella vuida
                tablero[i][j] = 0;
                if (tablero[i][j] == 0)
                    //amb aquest if podrem donar la imatge que volem al valor de '
                    System.out.print("\uD83D\uDD33 ");
            }
            System.out.println();
        }
        System.out.println();

    }

    private static void TriarJugador() {

            Scanner teclat = new Scanner(System.in);
            //Amb el següent if else tindrem un seguiment continu de quin jugador te el seu torn i els damanarem que seleccionen la casella que volen posar la seva peça
            if (jugada % 2 == 0) {
                System.out.println("Torn de " + jugador1 +
                        "\nOn vols ficar la teva peça? (Exemple: 2B)");
            } else {
                System.out.println("Torn de " + jugador2 +
                        "\nOn vols ficar la teva peça? (Exemple: 2B)");
            }
            //Llegim la poscicio i la passem a la nostra forma de llegir-la
            String casella = teclat.nextLine();
            //La guardem dins d'auqest static per poder tindrela i mostrarla quan vulguesem
            casellaRetorna = casella.toUpperCase();
            lletra = casella.toUpperCase().charAt(0);
            char numeroLletra = casella.charAt(1);
            numero = Integer.parseInt(String.valueOf(numeroLletra)) - 1;
            if (lletra == 'A') {
                lletra = 0;
            } else if (lletra == 'B') {
                lletra = 1;
            } else if (lletra == 'C') {
                lletra = 2;
            }
            //Entrem a la funció de jugar per tal entra al joc
            jugar();

    }

    private static void jugar() {
        int figura;
        //Amb aquest if sabrem en tot moment si es torn del jugador 1 o del jugador dos, ja que el static jugada anira augmentan cada torn, i sempre sera parell o imparell
        if (jugada % 2 == 0) {
            figura = 1;
        } else figura = 2;
        //Amb aquest try veurem si la casella esta ocupada o lliure
        try {
            //Si és == a 0 esta lliurei per tant saltem a l'exepcio vuida
            if (tablero[lletra][numero] == 0) {
                throw new vuidaExeption();
            }
            //Si és igual a 1 o ha 2 esta ocupada i per tant saltem a l'expresio ocupada
            if (tablero[lletra][numero] == 1 || tablero[lletra][numero] == 2) {
                throw new ocupadaExeption();
            }

        } catch (vuidaExeption e) {
            //Si esta buida guardem aquesta posició com 1/2 segons el jugador que esta jugan
            System.out.println("\nHas colocat la teva peça en la posició " + casellaRetorna);
            tablero[lletra][numero] = figura;
            Tablerojoc();
            jugada++;

        } catch (ocupadaExeption e) {
            //Si esta ocupada fem que el jugador tingui que posar una altra poscicio
            System.out.println("Posició ocupada, posa una altra cordenada ");
            TriarJugador();
        } catch (Exception e) {
            //En aquest cas algo a posat malament a l'hora de posar les cordenades
            System.out.println("Ep, algo has ficat malament, fixat en l'exemple i torna-ho a fer");
        }


        comprovarGuanyador();
    }

    private static void Tablerojoc() {

        String[] lletres = new String[]{" A ", " B ", " C "};

        //Posem els numeros de les cordenades del tauler
        System.out.println("\uD83C\uDF00 1  2  3");

        //Creem un for per tal de crear una matriu del tauler
        for (int i = 0; i < tablero.length; i++) {
            //Introduim les lletres de les cordenades en el tauler
            System.out.print(lletres[i]);
            for (int j = 0; j < tablero.length; j++) {
                if (tablero[i][j] == 0) {
                    System.out.print("\uD83D\uDD33 ");
                } else if (tablero[i][j] == 1) {
                    System.out.print("\uD83D\uDD35 ");
                } else if (tablero[i][j] == 2) {
                    System.out.print("\uD83D\uDD34 ");
                }

            }
            System.out.println();
        }
        System.out.println();
    }


    private static void comprovarGuanyador() {
        //Amb aquest try comprovarem tots els casos de victoria que hi ha possibles en el tres en ralla tant per al jugador 1 com per a jugador 2, vertical, horitzonatal i diagonal, mi9ran que els valors siguin igualss
        try {
            if (tablero[0][0] == 1 && tablero[1][0] == 1 && tablero[2][0] == 1 || tablero[0][1] == 1 && tablero[1][1] == 1 && tablero[2][1] == 1 || tablero[0][2] == 1 && tablero[1][2] == 1 && tablero[2][2] == 1) {
                throw new guanyador1Exeption();
            } else if (tablero[0][0] == 2 && tablero[1][0] == 2 && tablero[2][0] == 2 || tablero[0][1] == 2 && tablero[1][1] == 2 && tablero[2][1] == 2 || tablero[0][2] == 2 && tablero[1][2] == 2 && tablero[2][2] == 2) {
                throw new guanyador2Exeption();
            }
            if (tablero[0][0] == 1 && tablero[0][1] == 1 && tablero[0][2] == 1 || tablero[1][0] == 1 && tablero[1][1] == 1 && tablero[1][2] == 1 || tablero[2][0] == 1 && tablero[2][1] == 1 && tablero[2][2] == 1) {
                throw new guanyador1Exeption();
            } else if (tablero[0][0] == 2 && tablero[0][1] == 2 && tablero[0][2] == 2 || tablero[1][0] == 2 && tablero[1][1] == 2 && tablero[1][2] == 2 || tablero[2][0] == 2 && tablero[2][1] == 2 && tablero[2][2] == 2) {
                throw new guanyador2Exeption();
            }
            if (tablero[0][0] == 1 && tablero[1][1] == 1 && tablero[2][2] == 1 || tablero[2][0] == 1 && tablero[1][1] == 1 && tablero[0][2] == 1) {
                throw new guanyador1Exeption();
            } else if (tablero[0][0] == 2 && tablero[1][1] == 2 && tablero[2][2] == 2 || tablero[2][0] == 2 && tablero[1][1] == 2 && tablero[0][2] == 2) {
                throw new guanyador2Exeption();
            }

        } catch (guanyador1Exeption e) {
            //En cas de que guanye el jugador 1 saltara aquesta exepcio que li donara la vicotria al jugador 1
            System.out.println("FELICITATS " + jugador1 + "!!! Has gunyat la partida!!!");
            end=13;
        } catch (guanyador2Exeption e) {
            //En cas de que guanye el jugador 2 saltara aquesta exepcio que li donara la vicotria al jugador 2
            System.out.println("FELICITATS, " + jugador2 + "!!! has gunyat la partida!!!");
            end=13;
        }

        int resultat = 0;
        //Amb aquest try comrpovarem que totes les caselles estiguin ocupades i per tant la partida quede en empat
        try {
            for (int i = 0; i < tablero.length; i++) {
                for (int j = 0; j < tablero.length; j++) {
                    resultat = resultat + tablero[i][j];
                }
            }
            //Quan la casilla esta complet, com els nostres jugadors tenen el valor de 1 i 2 si el total de la suma de les caselles es == a 13 vol dir que estan totes plenes i per tant es un empat
            if (resultat == 13)
                throw new empatExeption();

        } catch (empatExeption e) {
            System.out.println("\nPARTIDA EMPADATA!");
            end=13;
        }
    }


    private static void tornarajugar() {
        Scanner teclat = new Scanner(System.in);

        System.out.println("Voleu tornar a jugar? (SI/NO)");
        String repetirPartida = teclat.nextLine();
        repetirPartida = repetirPartida.toUpperCase();
        //Si els usuaris volen tornar a jugar tornaran a jugar amb els mateixos noms una partida des de 0, en cas que no s'acabara la partida
            if (Objects.equals(repetirPartida, "SI")) {
                jugarPartida();
            } else if(Objects.equals(repetirPartida, "NO")){
                System.out.println("Que vaigue bé, ens veiem aviat!");
            }else {
            System.out.println("Aquesta resposta no és correcta, torna a provar.");
            tornarajugar();
        }


    }



    public static class vuidaExeption extends Exception {
    }

    public static class ocupadaExeption extends Exception {
    }

    public static class guanyador1Exeption extends Exception {
    }

    public static class guanyador2Exeption extends Exception {
    }

    public static class empatExeption extends Exception {
    }


}
