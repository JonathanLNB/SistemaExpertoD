package Archivos.PuntosCriticos;

import TDA.PuntosCriticos;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

public class Maestro {
    private RandomAccessFile archivoR;
    private long ultimo = 0;

    public void escribirB(int llave, int[] puntos) {
        try {
            archivoR = new RandomAccessFile("maestroP.gsh", "rw");
            ultimo = archivoR.length();
            archivoR.seek(ultimo);
            archivoR.writeInt(llave);
            for (int i = 0; i < 16; i++) {
                if (i < puntos.length)
                    archivoR.writeInt(puntos[i]);
                else
                    archivoR.writeInt(-1);
            }
            ultimo = archivoR.getFilePointer();
            archivoR.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void leerB(long posicion) {
        int aux, aux2;
        try {
            if (posicion != -1) {
                archivoR = new RandomAccessFile("maestroP.gsh", "r");
                archivoR.seek(posicion);
                System.out.println("Llave: " + archivoR.readInt());
                for (int i = 0; i < 16; i++) {
                    aux = archivoR.readInt();
                    aux2 = archivoR.readInt();
                    if (aux != -1)
                        System.out.println("Puntos Criticos " + (i + 1) + ": " + aux + "-" + aux2);
                }
            } else
                System.out.println("Error, Esa dirección no existe.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mostrarTodo() {
        int valor, aux, aux2;
        long apActual, apFinal;
        try {
            archivoR = new RandomAccessFile("maestroP.gsh", "r");
            while ((apActual = archivoR.getFilePointer()) != (apFinal = archivoR.length())) {
                valor = archivoR.readInt();
                if (valor != 0) {
                    System.out.println("Llave: " + valor);
                    for (int i = 0; i < 8; i++) {
                        aux = archivoR.readInt();
                        aux2 = archivoR.readInt();
                        if (aux != -1)
                            System.out.println("Puntos Criticos " + (i + 1) + ": " + aux + "-" + aux2);
                    }
                    System.out.println("---------------------------------------------------");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<PuntosCriticos> obtenerPuntos() {
        int punto1[] = new int[2], punto2[] = new int[2], punto3[] = new int[2], punto4[] = new int[2], punto5[] = new int[2], punto6[] = new int[2], punto7[] = new int[2], punto8[] = new int[2];
        int valor;
        long apActual, apFinal;
        ArrayList<PuntosCriticos> puntos = new ArrayList<>();
        try {
            archivoR = new RandomAccessFile("maestroP.gsh", "r");
            while ((apActual = archivoR.getFilePointer()) != (apFinal = archivoR.length())) {
                valor = archivoR.readInt();
                punto1[0] = archivoR.readInt();
                punto1[1] = archivoR.readInt();
                punto2[0] = archivoR.readInt();
                punto2[1] = archivoR.readInt();
                punto3[0] = archivoR.readInt();
                punto3[1] = archivoR.readInt();
                punto4[0] = archivoR.readInt();
                punto4[1] = archivoR.readInt();
                punto5[0] = archivoR.readInt();
                punto5[1] = archivoR.readInt();
                punto6[0] = archivoR.readInt();
                punto6[1] = archivoR.readInt();
                punto7[0] = archivoR.readInt();
                punto7[1] = archivoR.readInt();
                punto8[0] = archivoR.readInt();
                punto8[1] = archivoR.readInt();
                if (valor != 0) {
                    puntos.add(new PuntosCriticos(valor, punto1, punto2, punto3, punto4, punto5, punto6, punto7, punto8));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return puntos;
        }
    }

    public void actualizar(long posicion, boolean eliminar) {
        Scanner s = new Scanner(System.in);
        int llave;
        try {
            if (posicion != -1) {
                archivoR = new RandomAccessFile("maestroP.gsh", "rw");
                archivoR.seek(posicion);
                if (!eliminar) {
                    llave = archivoR.readInt();
                    System.out.println("Su llave es: " + llave);
                    archivoR.seek(posicion);
                    archivoR.writeInt(llave);
                    for (int i = 0; i < 8; i++) {
                        System.out.print("Cambiar del punto critico " + i + " " + archivoR.readInt() + "-" + archivoR.readInt() + " a: ");
                        System.out.println("Punto Critico 1: ");
                        archivoR.writeInt(s.nextInt());
                        System.out.println("Punto Critico 2: ");
                        archivoR.writeInt(s.nextInt());
                    }
                    archivoR.seek(posicion);
                } else {
                    archivoR.writeInt(0);
                    for (int i = 0; i < 16; i++) {
                        archivoR.writeInt(0);
                    }
                }
            } else
                System.out.println("Error, Ese registro no existe.");
            archivoR.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getUltimo() {
        return (int) (ultimo - 68);
    }
}
