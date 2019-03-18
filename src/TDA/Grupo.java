package TDA;

public class Grupo {
    private int llave;
    private int[] etiquetas;

    public Grupo(int llave, int[] etiquetas) {
        this.llave = llave;
        this.etiquetas = etiquetas;
    }

    public int getLlave() {
        return llave;
    }

    public void setLlave(int llave) {
        this.llave = llave;
    }

    public int[] getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(int[] etiquetas) {
        this.etiquetas = etiquetas;
    }
}
