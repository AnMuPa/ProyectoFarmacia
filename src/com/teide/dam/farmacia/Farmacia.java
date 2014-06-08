/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teide.dam.farmacia;

import java.util.ArrayList;
import java.io.Serializable;
import java.util.*;

/**
 *
 * @author DAM1
 */
public class Farmacia implements Serializable {

    ArrayList<Medicamento> listado = new ArrayList<>();
    private HashMap<String, Double> principios = new HashMap<>();
    ArrayList<String> encontradosN;
    ArrayList<String> encontradosPA;

    public Farmacia(ArrayList<String> encontradosN, ArrayList<String> encontradosPA) {
        this.encontradosN = encontradosN;
        this.encontradosPA = encontradosPA;
    }

    public Farmacia() {
    }

    public boolean caducados(Lotes l) {
        GregorianCalendar gc = new GregorianCalendar();
        String[] caduca = (l.getFechaCad()).split("/");
        String[] fecha = (gc.get(GregorianCalendar.DAY_OF_MONTH) + "/" + (gc.get(GregorianCalendar.MONTH) + 1) + "/" + (gc.get(GregorianCalendar.YEAR))).split("/");
        int[] cad = {0, 0, 0};
        int[] fech = {0, 0, 0};
        for (int i = 0; i < 3; i++) {
            cad[i] = Integer.parseInt(caduca[i]);
            fech[i] = Integer.parseInt(fecha[i]);
        }
        if (cad[2] < fech[2]) {
            return true;
        } else if (cad[2] > fech[2]) {
            return false;
        } else {
            if (cad[1] < fech[1]) {
                return true;
            } else if (cad[1] > fech[1]) {
                return false;
            } else {
                if (cad[0] < fech[0]) {
                    return true;
                } else if (cad[0] > fech[0]) {
                    return false;
                } else {
                    return false;
                }
            }
        }
    }

    public boolean buscarMedicamento(String medicamento) {
        encontradosN = new ArrayList<>();
        int i = 0, cont = 0;
        while (i < listado.size()) {
            if (listado.contains(medicamento)) {
                encontradosN.add(medicamento);
                cont++;
                return true;
            }
            i++;
            if (i == listado.size() && cont > 1) {
                System.out.println("Se han encontrado " + cont + " medicamentos con ese nombre :" + "  \n" + encontradosN);
            } else {
                System.out.println("No se han encontrado medicamentos con ese nombre");
            }
        }
        return false;

    }

    public boolean buscarPrincipioActivo(String PActivo) {

        int i = 0, cont = 0;
        while (i < principios.size()) {
            if (principios.containsKey(PActivo)) {
                encontradosPA.add(PActivo);
                cont++;
                return true;
            }
            i++;
            if (i == principios.size() && cont > 1) {
                System.out.println("Se han encontrado " + cont + " medicamentos con ese principio activo :" + "  \n" + encontradosPA);
            } else {
                System.out.println("No se han encontrado medicamentos con ese pricipio activo");
            }
        }
        return false;

    }
}
