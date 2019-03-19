import TDA.Grupo;
import TDA.Variable;

import java.util.Scanner;

public class Simulador {
    private Scanner s;
    private Archivos.Etiquetas.Maestro maestroE;
    private Archivos.Etiquetas.Indexado indexadoE;
    private Archivos.Grupos.Maestro maestroG;
    private Archivos.Grupos.Indexado indexadoG;
    private Archivos.Variables.Maestro maestroV;
    private Archivos.Variables.Indexado indexadoV;
    private Archivos.PuntosCriticos.Maestro maestroP;
    private Archivos.PuntosCriticos.Indexado indexadoP;

    public Simulador() {
        s = new Scanner(System.in);
        maestroE = new Archivos.Etiquetas.Maestro();
        maestroG = new Archivos.Grupos.Maestro();
        maestroV = new Archivos.Variables.Maestro();
        maestroP = new Archivos.PuntosCriticos.Maestro();
        indexadoE = new Archivos.Etiquetas.Indexado();
        indexadoG = new Archivos.Grupos.Indexado();
        indexadoV = new Archivos.Variables.Indexado();
        indexadoP = new Archivos.PuntosCriticos.Indexado();
        configuracion();
    }

    public void configuracion() {
        int aux;
        do {
            System.out.println("************* Menú ***************");
            System.out.println("----------------------------------");
            System.out.println("Ingresa la opción deseada");
            System.out.println("    1)Agregar");
            System.out.println("    2)Buscar");
            System.out.println("    3)Actualizar");
            System.out.println("    4)Eliminar");
            System.out.println("    5)Sistema Experto");
            System.out.println("    6)Salir");
            aux = s.nextInt();
            switch (aux) {
                case 1:
                    agregar();
                    break;
                case 2:
                    buscar();
                    break;
                case 3:
                    actualizar();
                    break;
                case 4:
                    eliminar();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Gracias :3");
                    break;
            }
        } while (aux < 6);
    }

    private void eliminar() {
        int tipoArchivo, llave;
        System.out.println("*********** Eliminar *************");
        System.out.println("----------------------------------");
        tipoArchivo = tipoArchivo();
        System.out.println("Ingresa la llave: ");
        llave = s.nextInt();
        switch (tipoArchivo) {
            case 1:
                maestroE.actualizar(indexadoE.leerArchivoSecuencial(llave), true);
                break;
            case 2:
                maestroG.actualizar(indexadoG.leerArchivoSecuencial(llave), true);
                break;
            case 3:
                maestroV.actualizar(indexadoV.leerArchivoSecuencial(llave), true);
                break;
            case 4:
                maestroP.actualizar(indexadoP.leerArchivoSecuencial(llave), true);
                break;
            case 5:
                break;
            default:
                System.out.println("Error: Esa opción no existe :'(");
        }
    }

    private void actualizar() {
        int tipoArchivo, llave;
        System.out.println("*********** Actualizar *************");
        System.out.println("------------------------------------");
        tipoArchivo = tipoArchivo();
        System.out.println("Ingresa la llave: ");
        llave = s.nextInt();
        switch (tipoArchivo) {
            case 1:
                maestroE.actualizar(indexadoE.leerArchivoSecuencial(llave), false);
                break;
            case 2:
                maestroG.actualizar(indexadoG.leerArchivoSecuencial(llave), false);
                break;
            case 3:
                maestroV.actualizar(indexadoV.leerArchivoSecuencial(llave), false);
                break;
            case 4:
                maestroP.actualizar(indexadoP.leerArchivoSecuencial(llave), false);
                break;
            case 5:
                break;
            default:
                System.out.println("Error: Esa opción no existe :'(");
        }
    }

    private void buscar() {
        int tipoArchivo, tipoBusqueda, llave;
        System.out.println("*********** Buscar *************");
        System.out.println("--------------------------------");
        tipoArchivo = tipoArchivo();
        if (tipoArchivo != 5) {
            tipoBusqueda = tipoBusqueda();
            if (tipoBusqueda == 1) {
                System.out.println("Ingresa la llave: ");
                llave = s.nextInt();
                switch (tipoArchivo) {
                    case 1:
                        maestroE.leerB(indexadoE.leerArchivoSecuencial(llave));
                        break;
                    case 2:
                        maestroG.leerB(indexadoG.leerArchivoSecuencial(llave));
                        break;
                    case 3:
                        maestroV.leerB(indexadoV.leerArchivoSecuencial(llave));
                        break;
                    case 4:
                        maestroP.leerB(indexadoP.leerArchivoSecuencial(llave));
                        break;
                    case 5:
                        break;
                    default:
                        System.out.println("Error: Esa opción no existe :'(");
                }
                System.out.println("---------------------------------");

            }
            if (tipoBusqueda == 2 || tipoBusqueda == 3) {
                switch (tipoArchivo) {
                    case 1:
                        if (tipoBusqueda == 2)
                            maestroE.mostrarTodo();
                        else
                            indexadoE.mostrarTodo();
                        break;
                    case 2:
                        if (tipoBusqueda == 2)
                            maestroG.mostrarTodo();
                        else
                            indexadoG.mostrarTodo();
                        break;
                    case 3:
                        if (tipoBusqueda == 2)
                            maestroV.mostrarTodo();
                        else
                            indexadoV.mostrarTodo();
                        break;
                    case 4:
                        if (tipoBusqueda == 2)
                            maestroP.mostrarTodo();
                        else
                            indexadoP.mostrarTodo();
                        break;
                    case 5:
                        break;
                    default:
                        System.out.println("Error: Esa opción no existe :'(");
                }
            }
        }
    }

    public int tipoArchivo() {
        int aux;
        System.out.println("Ingresa la opción deseada");
        System.out.println("    1)Etiquetas");
        System.out.println("    2)Grupos");
        System.out.println("    3)Variables");
        System.out.println("    4)Puntos Criticos");
        System.out.println("    5)Salir");
        aux = s.nextInt();
        return aux <= 5 ? aux : -1;
    }

    public int tipoBusqueda() {
        int aux;
        System.out.println("Ingresa la opción deseada");
        System.out.println("    1)Buscar por Llave");
        System.out.println("    2)Mostrar Maestro");
        System.out.println("    3)Mostrar Indice");
        System.out.println("    4)Salir");
        aux = s.nextInt();
        return aux <= 4 ? aux : -1;
    }

    public void agregar() {
        int tipoArchivo, llave, llaveGrupo, depende, etiquetas[];
        String nom;
        System.out.println("*********** Agregar *************");
        System.out.println("---------------------------------");
        tipoArchivo = tipoArchivo();
        switch (tipoArchivo) {
            case 1:
                System.out.println("Ingresa la llave: ");
                llave = s.nextInt();
                s.nextLine();
                System.out.println("Ingresa el nombre de la etiqueta: ");
                nom = s.nextLine();
                maestroE.escribirB(llave, nom);
                indexadoE.escribirArchivo(llave, maestroE.getUltimo());
                break;
            case 2:
                System.out.println("Ingresa la llave: ");
                llave = s.nextInt();
                s.nextLine();
                System.out.println("Ingresa la cantidad de etiquetas pertenecientes al grupo: ");
                etiquetas = new int[s.nextInt()];
                for (int i = 0; i < etiquetas.length; i++) {
                    System.out.println("Ingresa la etiqueta número " + (i + 1));
                    etiquetas[i] = s.nextInt();
                }
                maestroG.escribirB(llave, etiquetas);
                indexadoG.escribirArchivo(llave, maestroG.getUltimo());
                break;
            case 3:
                System.out.println("Ingresa la llave: ");
                llave = s.nextInt();
                s.nextLine();
                System.out.println("Ingresa el nombre de la variable: ");
                nom = s.nextLine();
                System.out.println("Ingresa la llave del grupo al que pertenece: ");
                llaveGrupo = s.nextInt();
                System.out.println("Ingresa la llave de la variable de la cual depende: ");
                depende = s.nextInt();
                maestroV.escribirB(llave, nom, llaveGrupo, depende);
                indexadoV.escribirArchivo(llave, maestroV.getUltimo());
                break;
            case 4:
                Variable auxV;
                Grupo auxG;
                String etiqueta;
                int cont = 0, puntos[];
                System.out.println("Ingresa la llave de la variable a la que pertenece: ");
                llave = s.nextInt();
                s.nextLine();
                auxV = maestroV.obtenerVariable(llave);
                if (auxV != null) {
                    auxG = maestroG.obtenerGrupo(auxV.getGrupo());
                    if (auxG != null) {
                        puntos = new int[auxG.getEtiquetas().length * 2];
                        inicializar(puntos);
                        for (int i = 0; i < auxG.getEtiquetas().length; i++) {
                            if (auxG.getEtiquetas()[i] != -1) {
                                etiqueta = maestroE.obtenerEtiqueta(auxG.getEtiquetas()[i]).getNombre();
                                System.out.println("Ingresa Punto Critico 1 para " + etiqueta.trim() + ": ");
                                puntos[cont] = s.nextInt();
                                cont++;
                                System.out.println("Ingresa Punto Critico 2 para " + etiqueta.trim() + ": ");
                                puntos[cont] = s.nextInt();
                                cont++;
                            } else
                                break;
                        }
                        maestroP.escribirB(llave, puntos);
                        indexadoP.escribirArchivo(llave, maestroP.getUltimo());
                    }
                }
                break;
            case 5:
                break;
            default:
                System.out.println("Error: Esa opción no existe :'(");
        }
    }

    private void inicializar(int[] puntos) {
        for (int i = 0; i < puntos.length; i++)
            puntos[i] = -1;
    }
}
