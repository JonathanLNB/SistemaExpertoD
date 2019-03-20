package TDA;

public class Etiqueta {
    private int llave;
    private String nombre;
    private double gradoM;

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

    public int getLlave() {
        return llave;
    }

    public void setLlave(int llave) {
        this.llave = llave;
    }

    public double getGradoM() {
        return gradoM;
    }

    public void setGradoM(double gradoM) {
        this.gradoM = gradoM;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
