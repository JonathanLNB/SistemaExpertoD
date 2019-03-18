package TDA;

public class Variable {
    private int llave;
    private String nombre;
    private int grupo;
    private int depende;

    public Variable(int llave, String nombre, int grupo, int depende) {
        this.llave = llave;
        this.nombre = nombre;
        this.grupo = grupo;
        this.depende = depende;
    }

    public int getLlave() {
        return llave;
    }

    public void setLlave(int llave) {
        this.llave = llave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getGrupo() {
        return grupo;
    }

    public void setGrupo(int grupo) {
        this.grupo = grupo;
    }

    public int getDepende() {
        return depende;
    }

    public void setDepende(int depende) {
        this.depende = depende;
    }
}
