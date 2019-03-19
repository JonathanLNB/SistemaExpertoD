package Archivos.Grupos;

import TDA.Grupo;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

public class Maestro {
    private RandomAccessFile archivoR;
    private long ultimo = 0;

    public void escribirB(int llave, int[] etiquetas) {
        try {
            archivoR = new RandomAccessFile("maestroG.gsh", "rw");
            ultimo = archivoR.length();
            archivoR.seek(ultimo);
            archivoR.writeInt(llave);
            for (int i = 0; i < 8; i++) {
                if (i < etiquetas.length)
                    archivoR.writeInt(etiquetas[i]);
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
        String nom;
        int aux;
        try {
            if (posicion != -1) {
                archivoR = new RandomAccessFile("maestroG.gsh", "r");
                archivoR.seek(posicion);
                System.out.println("Llave: " + archivoR.readInt());
                for (int i = 0; i < 8; i++) {
                    aux = archivoR.readInt();
                    if (aux != -1)
                        System.out.println("Etiqueta " + (i + 1) + ": " + aux);
                }
            } else
                System.out.println("Error, Esa dirección no existe.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mostrarTodo() {
        long apActual, apFinal;
        int valor, aux;
        try {
            archivoR = new RandomAccessFile("maestroG.gsh", "r");
            while ((apActual = archivoR.getFilePointer()) != (apFinal = archivoR.length())) {
                valor = archivoR.readInt();
                if (valor != 0) {
                    System.out.println("Llave: " + valor);
                    for (int i = 0; i < 8; i++) {
                        aux = archivoR.readInt();
                        if (aux != -1)
                            System.out.println("Etiqueta " + (i + 1) + ": " + aux);
                    }
                    System.out.println("---------------------------------------------------");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Grupo> obtenerGrupos() {
        int[] etiquetas = new int[8];
        long apActual, apFinal;
        int valor;
        ArrayList<Grupo> grupos = new ArrayList<>();
        try {
            archivoR = new RandomAccessFile("maestroG.gsh", "r");
            while ((apActual = archivoR.getFilePointer()) != (apFinal = archivoR.length())) {
                valor = archivoR.readInt();
                for (int i = 0; i < 8; i++)
                    etiquetas[i] = archivoR.readInt();
                if (valor != 0)
                    grupos.add(new Grupo(valor, etiquetas));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return grupos;
        }
    }

    public Grupo obtenerGrupo(int idGrupo) {
        int[] etiquetas = new int[8];
        long apActual, apFinal;
        int valor;
        Grupo grupo = null;
        try {
            archivoR = new RandomAccessFile("maestroG.gsh", "r");
            while ((apActual = archivoR.getFilePointer()) != (apFinal = archivoR.length())) {
                valor = archivoR.readInt();
                for (int i = 0; i < 8; i++)
                    etiquetas[i] = archivoR.readInt();
                if (valor != 0) {
                    if (valor == idGrupo) {
                        grupo = new Grupo(valor, etiquetas);
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return grupo;
        }
    }

    public void actualizar(long posicion, boolean eliminar) {
        Scanner s = new Scanner(System.in);
        int llave, aux, valor;
        try {
            if (posicion != -1) {
                archivoR = new RandomAccessFile("maestroG.gsh", "rw");
                archivoR.seek(posicion);
                if (!eliminar) {
                    llave = archivoR.readInt();
                    System.out.println("Su llave es: " + llave);
                    archivoR.seek(posicion);
                    archivoR.writeInt(llave);
                    for (int i = 0; i < 8; i++) {
                        aux = archivoR.readInt();
                        System.out.print("Cambiar de " + aux + " a la etiqueta: ");
                        valor = s.nextInt();
                        archivoR.writeInt(valor);
                    }
                    archivoR.seek(posicion);
                } else {
                    archivoR.writeInt(0);
                    for (int i = 0; i < 8; i++)
                        archivoR.writeInt(-1);
                }
            } else
                System.out.println("Error, Ese registro no existe.");
            archivoR.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getUltimo() {
        return (int) (ultimo - 36);
    }
}
