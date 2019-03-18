package TDA;

public class Etiqueta {
    private int llave;
    private String nombre;

    public Etiqueta(int llave, String nombre) {
        this.llave = llave;
        this.nombre = nombre;
    }

    public int getllave() {
        return llave;
    }

    public void setllave(int llave) {
        this.llave = llave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
