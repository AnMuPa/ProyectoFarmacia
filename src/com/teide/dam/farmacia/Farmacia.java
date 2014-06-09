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
    //private HashMap<String, Medicamento> principios = new HashMap<>();
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

        int i = 0, cont = 0;
        for (Medicamento mEncontrado : listado) {
            if (mEncontrado.getNombre().toLowerCase().contains(medicamento.toLowerCase())) {
                encontradosN.add(mEncontrado.getNombre());
            }
        }
        if (encontradosN.size() > 0) {
            System.out.println("Se han encontrado " + encontradosN.size() + " medicamentos con ese nombre : " + medicamento);
            for (int j = 0; j < listado.size(); j++) {
                System.out.println(encontradosN.get(j));
            }
            return true;
        } else {
            return false;
        }
        /*while (i < listado.size()) {
         if (listado.contains(new Medicamento(medicamento))) {
         encontradosN.add(medicamento);
         cont++;
         return true;
         }
         i++;*/

//            if (i == listado.size() && cont > 1) {
//                System.out.println("Se han encontrado " + cont + " medicamentos con ese nombre :" + "  \n" + encontradosN);
//            } else {
//                System.out.println("No se han encontrado medicamentos con ese nombre");
//            }
        /*if (listado.contains(medicamento)) {
         encontradosN.add(medicamento);
         cont++;
         return true;
         }else return false;*/
       // return false;
    }

    public boolean buscarPrincipioActivo(String PActivo) {

        for (Medicamento mEncontrado : listado) {
            if (mEncontrado.getPinciActivo().toLowerCase().contains(PActivo.toLowerCase())) {
                encontradosN.add(mEncontrado.getNombre());
            }
        }
        if (encontradosN.size() > 0) {
            System.out.println("Se han encontrado " + encontradosN.size() + " medicamentos con ese nombre : " + PActivo);
            for (int j = 0; j < listado.size(); j++) {
                System.out.println(encontradosN.get(j));
            }
            return true;
        } else {
            return false;
        }

        /* while (i < principios.size()) {
         if (principios.containsKey(PActivo)) {
         encontradosPA.add(PActivo);
         cont++;
         return true;
         }
         }*/
        /*  i++;
         if (i == principios.size() && cont > 1) {
         System.out.println("Se han encontrado " + cont + " medicamentos con ese principio activo :" + "  \n" + encontradosPA);
         } else {
         System.out.println("No se han encontrado medicamentos con ese pricipio activo");
         }
         }
         return false;*/
    }
}
