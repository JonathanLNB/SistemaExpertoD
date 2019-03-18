package Archivos.Etiquetas;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Indexado {
    private RandomAccessFile archivoR;
    private long ultima = 0;

    public Indexado() {

    }

    public void escribirArchivo(int llave, long pos) {
        try {
            archivoR = new RandomAccessFile("indexE.gsh", "rw");
            ultima = archivoR.length();
            archivoR.seek(ultima);
            archivoR.writeInt(llave);
            archivoR.writeLong(pos);
            ultima = archivoR.getFilePointer();
            archivoR.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public long leerArchivoSecuencial(int llave) {
        int valor;
        long apActual, apFinal, salida = -1;
        try {

            archivoR = new RandomAccessFile("indexE.gsh", "r");
            while ((apActual = archivoR.getFilePointer()) != (apFinal = archivoR.length())) {
                valor = archivoR.readInt();
                if (valor == llave) {
                    salida = archivoR.readLong();
                    break;
                }
                archivoR.readLong();
            }
            archivoR.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return salida;
        }
    }

    public long eliminarArchivoSecuencial(int llave) {
        int valor;
        long apActual, apFinal, salida = -1;
        try {
            archivoR = new RandomAccessFile("indexE.gsh", "rw");
            while ((apActual = archivoR.getFilePointer()) != (apFinal = archivoR.length())) {
                valor = archivoR.readInt();
                if (valor == llave) {
                    salida = archivoR.readLong();
                    archivoR.seek(apActual);
                    archivoR.writeInt(0);
                    archivoR.writeLong(0);
                    break;
                }
                archivoR.readLong();
            }
            archivoR.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return salida;
        }
    }

    public void mostrarTodo() {
        int auxl;
        long apActual, apFinal, auxd;
        try {
            archivoR = new RandomAccessFile("indexE.gsh", "r");
            while ((apActual = archivoR.getFilePointer()) != (apFinal = archivoR.length())) {
                auxl = archivoR.readInt();
                auxd = archivoR.readLong();
                if (auxl != 0) {
                    if (auxl > 0 && (auxd / 202 + 1) != 0)
                        System.out.println("Llave: " + auxl + " - Dirección: " + (auxd / 202 + 1));
                }
            }
            archivoR.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
