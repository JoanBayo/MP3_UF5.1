package Activitat4;

import java.util.ArrayList;

public class ClasseExpedinet {

    ArrayList<Integer> llistaModuls = new ArrayList<Integer>();

    int codi;
    String nomAlumne;

    //CONSTRUCTOR
    public ClasseExpedinet(int codi, String nomAlumne) {
        this.codi = codi;
        this.nomAlumne = nomAlumne;
    }


    //GETTERS I SETTERS DE Codi
    public int getCodi() {
        return codi;
    }

    public void setCodi(int codi) {
        this.codi = codi;
    }

    //GETTERS I SETTERS DE NomAlumne
    public String getNomAlumne() {
        return nomAlumne;
    }

    public void setNomAlumne(String nomAlumne) {
        this.nomAlumne = nomAlumne;
    }

    public void crearExpedient() {
    }

    public void modificarExpedient() {
    }

    public void esborrarExpedient() {
    }

    public void llistarExpedient() {
    }
}
