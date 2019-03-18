package Archivos.Etiquetas;

import TDA.Etiqueta;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

public class Maestro {
    private RandomAccessFile archivoR;
    private long ultimo = 0;
    
    public void escribirB(int llave, String nombre) {
        StringBuffer bf;
        try {
            archivoR = new RandomAccessFile("maestroE.gsh", "rw");
            ultimo = archivoR.length();
            archivoR.seek(ultimo);
            archivoR.writeInt(llave);
            bf = new StringBuffer(nombre);
            bf.setLength(99);
            archivoR.writeChars(bf.toString());
            ultimo = archivoR.getFilePointer();
            archivoR.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void leerB(long posicion) {
        String nom;
        char nombre[] = new char[99];
        try {
            if (posicion != -1) {
                archivoR = new RandomAccessFile("maestroE.gsh", "r");
                archivoR.seek(posicion);
                System.out.println("Llave: " + archivoR.readInt());
                for (int i = 0; i < nombre.length; i++)
                    nombre[i] = archivoR.readChar();
                nom = new String(nombre).replace('\0', ' ');
                System.out.println("Etiqueta: " + nom);
            } else
                System.out.println("Error, Esa dirección no existe.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mostrarTodo() {
        String nom;
        int valor;
        long apActual, apFinal;
        char nombre[] = new char[99];
        try {
            archivoR = new RandomAccessFile("maestroE.gsh", "r");
            while ((apActual = archivoR.getFilePointer()) != (apFinal = archivoR.length())) {
                valor = archivoR.readInt();
                for (int i = 0; i < nombre.length; i++)
                    nombre[i] = archivoR.readChar();
                nom = new String(nombre).replace('\0', ' ');
                if (valor != 0) {
                    System.out.println("Llave: " + valor);
                    System.out.println("Etiqueta: " + nom);
                    System.out.println("---------------------------------------------------");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Etiqueta> obteneretiquetas() {
        String nom;
        int valor;
        long apActual, apFinal;
        char nombre[] = new char[99];
        ArrayList<Etiqueta> etiquetas = new ArrayList<>();
        try {
            archivoR = new RandomAccessFile("maestroE.gsh", "r");
            while ((apActual = archivoR.getFilePointer()) != (apFinal = archivoR.length())) {
                valor = archivoR.readInt();
                for (int i = 0; i < nombre.length; i++)
                    nombre[i] = archivoR.readChar();
                nom = new String(nombre).replace('\0', ' ');
                if (valor != 0) {
                    etiquetas.add(new Etiqueta(valor, nom));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return etiquetas;
        }
    }

    public void actualizar(long posicion, boolean eliminar) {
        Scanner s = new Scanner(System.in);
        StringBuffer bf;
        String nom;
        int llave;
        char nombre[] = new char[99];
        try {
            if (posicion != -1) {
                archivoR = new RandomAccessFile("maestroE.gsh", "rw");
                archivoR.seek(posicion);
                if (!eliminar) {
                    llave = archivoR.readInt();
                    System.out.println("Su llave es: " + llave);
                    for (int i = 0; i < nombre.length; i++)
                        nombre[i] = archivoR.readChar();
                    nom = new String(nombre).replace('\0', ' ');
                    System.out.println("Cambiar de " + nom.trim() + " a la etiqueta: ");
                    nom = s.nextLine();
                    archivoR.seek(posicion);
                    archivoR.writeInt(llave);
                    bf = new StringBuffer(nom);
                    bf.setLength(99);
                    archivoR.writeChars(bf.toString());
                    archivoR.seek(posicion);
                } else {
                    archivoR.writeInt(0);
                    for (int i = 0; i < 99; i++)
                        archivoR.writeChar('0');
                }
            } else
                System.out.println("Error, Ese registro no existe.");
            archivoR.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getUltimo() {
        return (int) (ultimo - 202);
    }
}
