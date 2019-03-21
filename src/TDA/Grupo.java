package TDA;

import java.util.ArrayList;

public class Grupo {
    private int llave;
    private int[] idEtiquetas;
    private ArrayList<Etiqueta> etiquetas;

    public Grupo(int llave, int[] idEtiquetas) {
        this.llave = llave;
        this.idEtiquetas = idEtiquetas;
        etiquetas = new ArrayList<>();
    }

    public int getLlave() {
        return llave;
    }

    public void setLlave(int llave) {
        this.llave = llave;
    }

    public int[] getIdEtiquetas() {
        return idEtiquetas;
    }

    public void setIdEtiquetas(int[] idEtiquetas) {
        this.idEtiquetas = idEtiquetas;
    }

    public void setEtiquetas(ArrayList<Etiqueta> etiquetas) {
        this.etiquetas = etiquetas;
    }

    public ArrayList<Etiqueta> getEtiquetas() {
        return etiquetas;
    }
}
