package Activitat4;

import java.util.ArrayList;

public class Classe_UF {
    int codi;
    String nom;
    int hores;
    int nota;

    //CONSTRUCTOR
    public Classe_UF(int codi, String nom, int hores, int nota) {
        this.codi = codi;
        this.nom = nom;
        this.hores = hores;
        this.nota = nota;
    }

    //GETTERS I SETTERS DE codi
    public int getCodi() {
        return codi;
    }

    public void setCodi(int codi) {
        this.codi = codi;
    }


    //GETTERS I SETTERS DE nom
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    //GETTERS I SETTERS DE hores
    public int getHores() {
        return hores;
    }

    public void setHores(int hores) {
        this.hores = hores;
    }


    //GETTERS I SETTERS DE nota
    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }


    public void crearUF() {
        Classe_UF uf = new Classe_UF(codi,nom,hores,nota);
        uf.crearUF();
    }
    public void modificarUF() {
    }
    public void borrarUF() {
    }


}
