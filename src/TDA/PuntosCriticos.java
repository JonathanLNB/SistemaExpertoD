package TDA;

public class PuntosCriticos {
    private int llave;
    private int punto1[];
    private int punto2[];
    private int punto3[];
    private int punto4[];
    private int punto5[];
    private int punto6[];
    private int punto7[];
    private int punto8[];

    public PuntosCriticos(int llave, int[] punto1, int[] punto2, int[] punto3, int[] punto4, int[] punto5, int[] punto6, int[] punto7, int[] punto8) {
        this.llave = llave;
        this.punto1 = punto1;
        this.punto2 = punto2;
        this.punto3 = punto3;
        this.punto4 = punto4;
        this.punto5 = punto5;
        this.punto6 = punto6;
        this.punto7 = punto7;
        this.punto8 = punto8;
    }

    public int getLlave() {
        return llave;
    }

    public void setLlave(int llave) {
        this.llave = llave;
    }

    public int[] getPunto1() {
        return punto1;
    }

    public void setPunto1(int[] punto1) {
        this.punto1 = punto1;
    }

    public int[] getPunto2() {
        return punto2;
    }

    public void setPunto2(int[] punto2) {
        this.punto2 = punto2;
    }

    public int[] getPunto3() {
        return punto3;
    }

    public void setPunto3(int[] punto3) {
        this.punto3 = punto3;
    }

    public int[] getPunto4() {
        return punto4;
    }

    public void setPunto4(int[] punto4) {
        this.punto4 = punto4;
    }

    public int[] getPunto5() {
        return punto5;
    }

    public void setPunto5(int[] punto5) {
        this.punto5 = punto5;
    }

    public int[] getPunto6() {
        return punto6;
    }

    public void setPunto6(int[] punto6) {
        this.punto6 = punto6;
    }

    public int[] getPunto7() {
        return punto7;
    }

    public void setPunto7(int[] punto7) {
        this.punto7 = punto7;
    }

    public int[] getPunto8() {
        return punto8;
    }

    public void setPunto8(int[] punto8) {
        this.punto8 = punto8;
    }
}
