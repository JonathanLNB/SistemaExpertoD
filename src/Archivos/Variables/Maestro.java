package Archivos.Variables;


import TDA.Variable;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

public class Maestro {
    private RandomAccessFile archivoR;
    private long ultimo = 0;

    public void escribirB(int llave, String nombre, int grupo, int depende) {
        StringBuffer bf;
        try {
            archivoR = new RandomAccessFile("maestroV.gsh", "rw");
            ultimo = archivoR.length();
            archivoR.seek(ultimo);
            archivoR.writeInt(llave);
            bf = new StringBuffer(nombre);
            bf.setLength(99);
            archivoR.writeChars(bf.toString());
            archivoR.writeInt(grupo);
            archivoR.writeInt(depende);
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
                archivoR = new RandomAccessFile("maestroV.gsh", "r");
                archivoR.seek(posicion);
                System.out.println("Llave: " + archivoR.readInt());
                for (int i = 0; i < nombre.length; i++)
                    nombre[i] = archivoR.readChar();
                nom = new String(nombre).replace('\0', ' ');
                System.out.println("Nombre: " + nom);
                System.out.println("Grupo: " + archivoR.readInt());
                System.out.println("Depende: " + archivoR.readInt());
            } else
                System.out.println("Error, Esa dirección no existe.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mostrarTodo() {
        String nom;
        int valor, grupo, depende;
        long apActual, apFinal;
        char nombre[] = new char[99];
        try {
            archivoR = new RandomAccessFile("maestroV.gsh", "r");
            while ((apActual = archivoR.getFilePointer()) != (apFinal = archivoR.length())) {
                valor = archivoR.readInt();
                for (int i = 0; i < nombre.length; i++)
                    nombre[i] = archivoR.readChar();
                nom = new String(nombre).replace('\0', ' ');
                grupo = archivoR.readInt();
                depende = archivoR.readInt();
                if (valor != 0) {
                    System.out.println("Llave: " + valor);
                    System.out.println("Nombre: " + nom);
                    System.out.println("Grupo: " + grupo);
                    System.out.println("Depende: " + ((depende != -1) ? depende : "Nadie"));
                    System.out.println("---------------------------------------------------");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Variable> obtenerVariables() {
        String nom;
        int valor, grupo, depende;
        long apActual, apFinal;
        char nombre[] = new char[99];
        ArrayList<Variable> varibales = new ArrayList<>();
        try {
            archivoR = new RandomAccessFile("maestroV.gsh", "r");
            while ((apActual = archivoR.getFilePointer()) != (apFinal = archivoR.length())) {
                valor = archivoR.readInt();
                for (int i = 0; i < nombre.length; i++)
                    nombre[i] = archivoR.readChar();
                nom = new String(nombre).replace('\0', ' ');
                grupo = archivoR.readInt();
                depende = archivoR.readInt();
                if (valor != 0) {
                    varibales.add(new Variable(valor, nom, grupo, depende));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return varibales;
        }
    }

    public Variable obtenerVariable(int idVariable) {
        String nom;
        int valor, grupo, depende;
        long apActual, apFinal;
        char nombre[] = new char[99];
        Variable variable = null;
        try {
            archivoR = new RandomAccessFile("maestroV.gsh", "r");
            while ((apActual = archivoR.getFilePointer()) != (apFinal = archivoR.length())) {
                valor = archivoR.readInt();
                for (int i = 0; i < nombre.length; i++)
                    nombre[i] = archivoR.readChar();
                nom = new String(nombre).replace('\0', ' ');
                grupo = archivoR.readInt();
                depende = archivoR.readInt();
                if (valor != 0) {
                    if (valor == idVariable) {
                        variable = new Variable(valor, nom, grupo, depende);
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return variable;
        }
    }

    public void actualizar(long posicion, boolean eliminar) {
        Scanner s = new Scanner(System.in);
        StringBuffer bf;
        String nom;
        int llave, grupo, depende;
        char nombre[] = new char[99];
        try {
            if (posicion != -1) {
                archivoR = new RandomAccessFile("maestroV.gsh", "rw");
                archivoR.seek(posicion);
                if (!eliminar) {
                    llave = archivoR.readInt();
                    System.out.println("Su llave es: " + llave);
                    for (int i = 0; i < nombre.length; i++)
                        nombre[i] = archivoR.readChar();
                    nom = new String(nombre).replace('\0', ' ');
                    grupo = archivoR.readInt();
                    depende = archivoR.readInt();
                    System.out.print("Cambiar de " + nom.trim() + " a : ");
                    nom = s.nextLine();
                    System.out.print("Cambiar del Grupo " + grupo + " a : ");
                    grupo = s.nextInt();
                    System.out.print("Cambiar depende de " + depende + " a : ");
                    depende = s.nextInt();
                    archivoR.seek(posicion);
                    archivoR.writeInt(llave);
                    bf = new StringBuffer(nom);
                    bf.setLength(99);
                    archivoR.writeChars(bf.toString());
                    archivoR.writeInt(grupo);
                    archivoR.writeInt(depende);
                } else {
                    archivoR.writeInt(0);
                    for (int i = 0; i < 99; i++)
                        archivoR.writeChar('0');
                    archivoR.writeInt(-1);
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
        return (int) (ultimo - 210);
    }
}
