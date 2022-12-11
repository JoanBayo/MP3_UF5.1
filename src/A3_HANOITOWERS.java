import java.util.Scanner;
import java.util.Stack;


public class A3_HANOITOWERS {

    static String jugador;
    static int columnaDesti;
    static int columnaSelecionada;
    static int moviments;
    static Stack columna1 = new Stack();
    static Stack columna2 = new Stack();
    static Stack columna3 = new Stack();
    static Stack colFinal = new Stack();


    //    static Stack columnaJoc1 = new Stack();
//    static Stack columnaJoc2 = new Stack();
//    static Stack columnaJoc3 = new Stack();
    static int algo;


    public static void main(String[] args) {
        introducio();
        prepararjoc();
        moviments = 0;
        while (true) {
            jugar();
            if (columna3.equals(colFinal)) {
                break;
            }
        }
        end();
    }


    private static void introducio() {
        Scanner teclat = new Scanner(System.in);

        System.out.println("##     ##    ###    ##    ##  #######  ####          ########  #######  ##      ## ######## ########   ######  \n" +
                "##     ##   ## ##   ###   ## ##     ##  ##              ##    ##     ## ##  ##  ## ##       ##     ## ##    ## \n" +
                "##     ##  ##   ##  ####  ## ##     ##  ##              ##    ##     ## ##  ##  ## ##       ##     ## ##       \n" +
                "######### ##     ## ## ## ## ##     ##  ##              ##    ##     ## ##  ##  ## ######   ########   ######  \n" +
                "##     ## ######### ##  #### ##     ##  ##              ##    ##     ## ##  ##  ## ##       ##   ##         ## \n" +
                "##     ## ##     ## ##   ### ##     ##  ##              ##    ##     ## ##  ##  ## ##       ##    ##  ##    ## \n" +
                "##     ## ##     ## ##    ##  #######  ####             ##     #######   ###  ###  ######## ##     ##  ######  ");
        System.out.println("Com jugar: \n" +
                "");
        System.out.println("Introduix el teu nom:");
        jugador = teclat.nextLine();
        System.out.println("Anem a jugar!");
    }

    private static void prepararjoc() {

        //Enregistrem la columna 1, amb el nombre de discos que ens digui l'usuari
        Scanner teclat = new Scanner(System.in);
        System.out.println("En quants de discos vols jugar: ");

        int numoeroDisco = teclat.nextInt();
        for (int i = numoeroDisco; i > 0; i--) {
            columna1.push(i);
            colFinal.push(i);

        }

        //Printejem les columnes
        System.out.println("COLUMNA 1");
        for (int i = columna1.size() - 1; i >= 0; i--) {
            System.out.print(columna1.get(i));
            System.out.println();
        }
        System.out.println();

        System.out.println("COLUMNA 2");
        System.out.println("Columna Buida");
        System.out.println();

        System.out.println("COLUMNA 3");
        System.out.println("Columna Buida");
        System.out.println();

    }

    private static void jugar() {
        Scanner teclat = new Scanner(System.in);

        //Preguntem al usuari de quina columna vol treure el disc
        System.out.println("\nDe quina columna vols treure un disc?");
        columnaSelecionada = teclat.nextInt();

        //I comprovem que aquesta columna estigui dins dels marjes
        while (columnaSelecionada < 1 || columnaSelecionada > 3) {
            System.out.println("Aquesta columna no existeix, prova unaltra");
            System.out.println("De quina columna vols treure un disc?");
            columnaSelecionada = teclat.nextInt();
        }

        //I li preguntem a quina columan vol posar el disc
        System.out.println("A quina columna vols posar el disc?");
        columnaDesti = teclat.nextInt();

        //I comprovem que aquesta columna estigui dins dels marjes
        while (columnaDesti < 1 || columnaDesti > 3) {
            System.out.println("Aquesta columna no existeix, prova unaltra");
            System.out.println("A quina columna vols posar el disc?");
            columnaDesti = teclat.nextInt();
        }
        //Saltem al següent apartat
        moureDiscoes();
    }

    private static void moureDiscoes() {
        int casEmpty1 = 1000;
        int casEmpty2 = 1000;
        int casEmpty3 = 1000;

        //donem valors a les columnes per tal de compararles en cas de que estiguin buides
        if (!columna1.empty())
            casEmpty1 = (int) columna1.peek();
        if (!columna2.empty())
            casEmpty2 = (int) columna2.peek();
        if (!columna3.empty())
            casEmpty3 = (int) columna3.peek();

        //En aquest apartat comprovarem per tots els casos possibles la poscicio on volem posar els discos, comprovan si la columna seleccionada esta buida i per tant no es pot treure el disc, i si el disc de la columna desti es menor que el disc que tenim i per tal no es pot posar en aquesta columna
        if (columnaSelecionada == 1 && columnaDesti == 2) {
            if (columna1.empty()) {
                System.out.println("La columna 1 esta buida, prova una altra");
            } else {
                if (casEmpty1 < casEmpty2) {
                    columna2.push(columna1.pop());
                } else {
                    System.out.println("Aquest moviment no és possible ja que, el disc de baix és més petit");
                }
            }
        }
        if (columnaSelecionada == 1 && columnaDesti == 3) {
            if (columna1.empty()) {
                System.out.println("La columna 1 esta buida, prova una altra");
            } else {
                if (casEmpty1 < casEmpty3) {
                    columna3.push(columna1.pop());
                } else {
                    System.out.println("Aquest moviment no és possible ja que, el disc de baix és més petit");
                }
            }
        }
        if (columnaSelecionada == 2 && columnaDesti == 1) {
            if (columna2.empty()) {
                System.out.println("La columna 2 esta buida, prova una altra");
            } else {
                if (casEmpty2 < casEmpty1) {
                    columna1.push(columna2.pop());
                } else {
                    System.out.println("Aquest moviment no és possible ja que, el disc de baix és més petit");
                }
            }
        }
        if (columnaSelecionada == 2 && columnaDesti == 3) {
            if (columna2.empty()) {
                System.out.println("La columna 2 esta buida, prova una altra");
            } else {
                if (casEmpty2 < casEmpty3) {
                    columna3.push(columna2.pop());
                } else {
                    System.out.println("MAquest moviment no és possible ja que, el disc de baix és més petit");
                }
            }
        }
        if (columnaSelecionada == 3 && columnaDesti == 1) {
            if (columna3.empty()) {
                System.out.println("La columna 3 esta buida, prova una altra");
            } else {
                if (casEmpty3 < casEmpty1) {
                    columna1.push(columna3.pop());
                } else {
                    System.out.println("Aquest moviment no és possible ja que, el disc de baix és més petit");
                }
            }
        }
        if (columnaSelecionada == 3 && columnaDesti == 2) {
            if (columna3.empty()) {
                System.out.println("La columna 3 esta buida, prova una altra");
            } else {
                if (casEmpty3 < casEmpty2) {
                    columna2.push(columna3.pop());
                } else {
                    System.out.println("Aquest moviment no és possible ja que, el disc de baix és més petit");
                }
            }
        }

        //Finalment printejem totes 3 columnes amb l'informació obringuda anteriorment
        System.out.println("COLUMNA 1");
        if (columna1.empty()) {
            System.out.println("Columna Buida");
        } else
            for (int i = columna1.size() - 1; i >= 0; i--) {
                System.out.print(columna1.get(i));
                System.out.println();
            }
        System.out.println();

        System.out.println("COLUMNA 2");
        if (columna2.empty()) {
            System.out.println("Columna Buida");
        } else
            for (int i = columna2.size() - 1; i >= 0; i--) {
                System.out.print(columna2.get(i));
                System.out.println();
            }
        System.out.println();

        System.out.println("COLUMNA 3");
        if (columna3.empty()) {
            System.out.println("Columna Buida");
        } else
            for (int i = columna3.size() - 1; i >= 0; i--) {
                System.out.print(columna3.get(i));
                System.out.println();
            }
        System.out.println();
        moviments++;
    }

    private static void end() {
        //Printejem el nom del jugador juntament amb els moviments que a necessitat per a fer
        Scanner teclat = new Scanner(System.in);
        System.out.println("Enorabona, " + jugador +" has completat el joc amb " + moviments + " intents!!");
        System.out.println("vols tornar a jugar?");
        String tornarJugar = teclat.nextLine();
        tornarJugar = tornarJugar.toUpperCase();
        if (tornarJugar.equals("SI")) {
            //NO SE COM FER PER A QUE ES PUGUI TORNAR A JUGAR, PERO HE PUGUT ARRIBAR FINS AQUEST PUNT
            prepararjoc();
        } else if (tornarJugar.equals("NO")) {
            System.out.println("Anudsiau!!");
        } else System.out.println("Aquesta resposta no és correcta");

    }
}

