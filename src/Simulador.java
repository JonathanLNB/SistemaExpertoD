import TDA.Etiqueta;
import TDA.Grupo;
import TDA.PuntosCriticos;
import TDA.Variable;

import java.util.ArrayList;
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
    private ArrayList<Variable> variables;
    private ArrayList<PuntosCriticos> puntosCriticos;
    private double[] resultadosD;

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
                    mostrarOpciones();
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
                    auxG = maestroG.obtenerGrupo(auxV.getIdGrupo());
                    if (auxG != null) {
                        puntos = new int[auxG.getIdEtiquetas().length * 2];
                        inicializar(puntos);
                        for (int i = 0; i < auxG.getIdEtiquetas().length; i++) {
                            if (auxG.getIdEtiquetas()[i] != -1) {
                                etiqueta = maestroE.obtenerEtiqueta(auxG.getIdEtiquetas()[i]).getNombre();
                                System.out.println("Ingresa El Rango Inicial " + etiqueta.trim() + ": ");
                                puntos[cont] = s.nextInt();
                                cont++;
                                System.out.println("Ingresa El Rango Final " + etiqueta.trim() + ": ");
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

    private void mostrarOpciones() {
        String famAux[] = new String[2];
        double aux = 0;
        boolean primera = true;
        variables = maestroV.obtenerVariables();
        puntosCriticos = maestroP.obtenerPuntos();
        System.out.println("*********** Sistema Experto *************");
        System.out.println("-----------------------------------------");
        for (int i = 0; i < variables.size(); i++) {
            System.out.println("Ingresa la calificación referente a \"" + variables.get(i).getNombre().trim() + "\"");
            if (primera) {
                primera = false;
                aux = s.nextInt();
            } else {
                if (aux > 70) {
                    aux = s.nextInt();
                    if (aux * 1.05 <= 100)
                        aux *= 1.05;
                } else
                    aux = s.nextInt();
                s.nextLine();
            }
            variables.get(i).setCalificacion(aux);
            puntosCriticos.get(i).setVariable(variables.get(i));
            puntosCriticos.get(i).getVariable().setGrupo(maestroG.obtenerGrupo(puntosCriticos.get(i).getVariable().getIdGrupo()));
            for (int e = 0; e < puntosCriticos.get(i).getVariable().getGrupo().getIdEtiquetas().length; e++) {
                if (puntosCriticos.get(i).getVariable().getGrupo().getIdEtiquetas()[e] != -1) {
                    puntosCriticos.get(i).getVariable().getGrupo().getEtiquetas().add(maestroE.obtenerEtiqueta(puntosCriticos.get(i).getVariable().getGrupo().getIdEtiquetas()[e]));
                    switch (e) {
                        case 0:
                            puntosCriticos.get(i).getVariable().getGrupo().getEtiquetas().get(e).setGradoM(membresia(variables.get(i).getCalificacion(), puntosCriticos.get(i).getPunto1()));
                            break;
                        case 1:
                            puntosCriticos.get(i).getVariable().getGrupo().getEtiquetas().get(e).setGradoM(membresia(variables.get(i).getCalificacion(), puntosCriticos.get(i).getPunto2()));
                            break;
                        case 2:
                            puntosCriticos.get(i).getVariable().getGrupo().getEtiquetas().get(e).setGradoM(membresia(variables.get(i).getCalificacion(), puntosCriticos.get(i).getPunto3()));
                            break;
                        case 3:
                            puntosCriticos.get(i).getVariable().getGrupo().getEtiquetas().get(e).setGradoM(membresia(variables.get(i).getCalificacion(), puntosCriticos.get(i).getPunto3()));
                            break;
                        case 4:
                            puntosCriticos.get(i).getVariable().getGrupo().getEtiquetas().get(e).setGradoM(membresia(variables.get(i).getCalificacion(), puntosCriticos.get(i).getPunto3()));
                            break;
                        case 5:
                            puntosCriticos.get(i).getVariable().getGrupo().getEtiquetas().get(e).setGradoM(membresia(variables.get(i).getCalificacion(), puntosCriticos.get(i).getPunto3()));
                            break;
                        case 6:
                            puntosCriticos.get(i).getVariable().getGrupo().getEtiquetas().get(e).setGradoM(membresia(variables.get(i).getCalificacion(), puntosCriticos.get(i).getPunto3()));
                            break;
                        case 7:
                            puntosCriticos.get(i).getVariable().getGrupo().getEtiquetas().get(e).setGradoM(membresia(variables.get(i).getCalificacion(), puntosCriticos.get(i).getPunto3()));
                            break;
                    }
                }
            }
        }
        famAux[0] = "N,0," + puntosCriticos.get(0).getVariable().getGrupo().getEtiquetas().get(0).getGradoM();
        famAux[1] = "N,1," + puntosCriticos.get(0).getVariable().getGrupo().getEtiquetas().get(1).getGradoM();
        for (int i = 1; i < puntosCriticos.size(); i++)
            famAux = generarMatrizFAM(famAux, puntosCriticos.get(i).getVariable().getGrupo().getEtiquetas());
        mostrarMatriz(famAux);
        resultadosD = maximos(famAux);
        System.out.println("--------------------------------------------");
        System.out.println("*********** Resultados Difusos *************");
        System.out.println("--------------------------------------------");
        for(int i = 0; i<resultadosD.length; i++){
            System.out.print("Grados de membresia en ");
            if(i == 0)
                System.out.println("Reprobado: "+resultadosD[i]);
            if(i == 1)
                System.out.println("Semi-Reprobado: "+resultadosD[i]);
            if(i == 2)
                System.out.println("Puede: "+resultadosD[i]);
            if(i == 3)
                System.out.println("Bueno: "+resultadosD[i]);
            if(i == 4)
                System.out.println("Excelente: "+resultadosD[i]);
        }
        System.out.println("--------------------------------------------");

    }

    private double membresia(double calificacion, int[] rango) {
        double gMembresia = 0;
        int rangoM, rangoMax, puntoCritico1, puntoCritico2;
        rangoM = rango[0];
        rangoMax = rango[1];
        puntoCritico1 = (rango[0] == 0) ? rango[0] : rango[0] + 10;
        puntoCritico2 = (rango[1] == 100) ? rango[1] : rango[1] - 10;
        if (puntoCritico1 >= 0) {
            if (puntoCritico2 == -1) {
                if (calificacion >= rangoM && calificacion <= rangoMax) {
                    if (calificacion == puntoCritico1)
                        return 1;
                    if (calificacion < puntoCritico1)
                        gMembresia = (double) (calificacion - rangoM) / (puntoCritico1 - rangoM);
                    if (calificacion > puntoCritico1)
                        gMembresia = (double) (rangoMax - calificacion) / (rangoMax - puntoCritico1);
                } else
                    return 0;
            } else {
                if (calificacion >= rangoM && calificacion <= rangoMax) {
                    if (puntoCritico1 <= calificacion && calificacion <= puntoCritico2)
                        return 1;
                    if (calificacion < puntoCritico1)
                        gMembresia = (double) (calificacion - rangoM) / (puntoCritico1 - rangoM);
                    if (calificacion > puntoCritico2)
                        gMembresia = (double) (rangoMax - calificacion) / (rangoMax - puntoCritico2);
                } else
                    return 0;
            }
        } else
            return 0;
        return gMembresia;
    }

    private String[] generarMatrizFAM(String aux[], ArrayList<Etiqueta> etiquetas) {
        String salida[] = new String[aux.length * etiquetas.size()];
        int cont = 0;
        for (int i = 0; i < aux.length; i++) {
            for (int e = 0; e < etiquetas.size(); e++) {
                if (Integer.parseInt(aux[i].split(",")[1]) + (e > 1 ? 1 : e) < 2)
                    salida[cont] = "N," + (Integer.parseInt(aux[i].split(",")[1]) + (e > 1 ? 1 : e)) + "," + ((etiquetas.get(e).getGradoM() < Double.parseDouble(aux[i].split(",")[2])) ? etiquetas.get(e).getGradoM() : Double.parseDouble(aux[i].split(",")[2]));
                else if (Integer.parseInt(aux[i].split(",")[1]) + (e > 1 ? 1 : e) < 4)
                    salida[cont] = "I," + (Integer.parseInt(aux[i].split(",")[1]) + (e > 1 ? 1 : e)) + "," + ((etiquetas.get(e).getGradoM() < Double.parseDouble(aux[i].split(",")[2])) ? etiquetas.get(e).getGradoM() : Double.parseDouble(aux[i].split(",")[2]));
                else if (Integer.parseInt(aux[i].split(",")[1]) + (e > 1 ? 1 : e) < 6)
                    salida[cont] = "P," + (Integer.parseInt(aux[i].split(",")[1]) + (e > 1 ? 1 : e)) + "," + ((etiquetas.get(e).getGradoM() < Double.parseDouble(aux[i].split(",")[2])) ? etiquetas.get(e).getGradoM() : Double.parseDouble(aux[i].split(",")[2]));
                else if (Integer.parseInt(aux[i].split(",")[1]) + (e > 1 ? 1 : e) < 8)
                    salida[cont] = "B," + (Integer.parseInt(aux[i].split(",")[1]) + (e > 1 ? 1 : e)) + "," + ((etiquetas.get(e).getGradoM() < Double.parseDouble(aux[i].split(",")[2])) ? etiquetas.get(e).getGradoM() : Double.parseDouble(aux[i].split(",")[2]));
                if (Integer.parseInt(aux[i].split(",")[1]) + (e > 1 ? 1 : e) >= 8)
                    salida[cont] = "E," + (Integer.parseInt(aux[i].split(",")[1]) + (e > 1 ? 1 : e)) + "," + ((etiquetas.get(e).getGradoM() < Double.parseDouble(aux[i].split(",")[2])) ? etiquetas.get(e).getGradoM() : Double.parseDouble(aux[i].split(",")[2]));
                cont++;
            }
        }
        return salida;
    }

    private double[] maximos(String aux[]) {
        double max[] = new double[5];
        max[0] = 0;
        max[1] = 0;
        max[2] = 0;
        max[3] = 0;
        max[4] = 0;
        for (int i = 0; i < aux.length; i++) {
            if (aux[i].split(",")[0].equals("N"))
                max[0] = max[0] < Double.parseDouble(aux[i].split(",")[2]) ? Double.parseDouble(aux[i].split(",")[2]) : max[0];
            if (aux[i].split(",")[0].equals("I"))
                max[1] = max[1] < Double.parseDouble(aux[i].split(",")[2]) ? Double.parseDouble(aux[i].split(",")[2]) : max[1];
            if (aux[i].split(",")[0].equals("P"))
                max[2] = max[2] < Double.parseDouble(aux[i].split(",")[2]) ? Double.parseDouble(aux[i].split(",")[2]) : max[2];
            if (aux[i].split(",")[0].equals("B"))
                max[3] = max[3] < Double.parseDouble(aux[i].split(",")[2]) ? Double.parseDouble(aux[i].split(",")[2]) : max[3];
            if (aux[i].split(",")[0].equals("E"))
                max[4] = max[4] < Double.parseDouble(aux[i].split(",")[2]) ? Double.parseDouble(aux[i].split(",")[2]) : max[4];
        }
        return max;
    }

    public void mostrarMatriz(String aux[]){
        int cont = 0;
        for (int i = 0; i < aux.length; i++) {
            System.out.print(aux[i].split(",")[0]+" | ");
            cont++;
            if(cont == 54) {
                System.out.println("");
                cont=0;
            }
        }
        System.out.println("");
    }

    private void inicializar(int[] puntos) {
        for (int i = 0; i < puntos.length; i++)
            puntos[i] = -1;
    }
}
