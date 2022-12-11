package Activitat7;

import java.io.*;

public class carta implements Serializable{
    enum pals{
        ORS,
        COPES,
        ESPASES,
        BASTOS
    }
    int numero;
    String pal;

    public int getNumero() {
        return numero;
    }
    public String getPal(){
        return pal;
    }

    public carta(int n, String p){
        this.numero = n;
        this.pal = String.valueOf(pals.valueOf(p));
    }
}