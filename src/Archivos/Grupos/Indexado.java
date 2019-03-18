package Archivos.Grupos;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Indexado {
    private RandomAccessFile archivo;
    private long ultima = 0;

    public Indexado() {

    }

    public void escribirArchivo(int llave, long pos) {
        try {
            archivo = new RandomAccessFile("indexG.gsh", "rw");
            ultima = archivo.length();
            archivo.seek(ultima);
            archivo.writeInt(llave);
            archivo.writeLong(pos);
            ultima = archivo.getFilePointer();
            archivo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public long leerArchivoSecuencial(int llave) {
        int valor;
        long apActual, apFinal, salida = -1;
        try {
            archivo = new RandomAccessFile("indexG.gsh", "r");
            while ((apActual = archivo.getFilePointer()) != (apFinal = archivo.length())) {
                valor = archivo.readInt();
                if (valor == llave) {
                    salida = archivo.readLong();
                    break;
                }
                archivo.readLong();
            }
            archivo.close();
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
            archivo = new RandomAccessFile("indexG.gsh", "rw");
            while ((apActual = archivo.getFilePointer()) != (apFinal = archivo.length())) {
                valor = archivo.readInt();
                if (valor == llave) {
                    salida = archivo.readLong();
                    archivo.seek(apActual);
                    archivo.writeInt(0);
                    archivo.writeLong(0);
                    break;
                }
                archivo.readLong();
            }
            archivo.close();
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
            archivo = new RandomAccessFile("indexG.gsh", "r");
            while ((apActual = archivo.getFilePointer()) != (apFinal = archivo.length())) {
                auxl = archivo.readInt();
                auxd = archivo.readLong();
                if (auxl != 0) {
                    if (auxl > 0 && (auxd / 36 + 1) != 0)
                        System.out.println("Llave: " + auxl + " - Dirección: " + (auxd / 36 + 1));
                }
            }
            archivo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
