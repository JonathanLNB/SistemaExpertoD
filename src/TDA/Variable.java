package TDA;

public class Variable {
    private int llave;
    private String nombre;
    private int idGrupo;
    private int depende;
    private double calificacion;
    private Grupo grupo;

    public Variable(int llave, String nombre, int idGrupo, int depende) {
        this.llave = llave;
        this.nombre = nombre;
        this.idGrupo = idGrupo;
        this.depende = depende;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
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

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }

    public int getDepende() {
        return depende;
    }

    public void setDepende(int depende) {
        this.depende = depende;
    }
}
