/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teide.dam.ejecuta;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import com.teide.dam.aortiz.ioutil.OperationsIO;
import com.teide.dam.farmacia.Lotes;
import com.teide.dam.farmacia.Medicamento;
import java.util.ArrayList;

/**
 *
 * @author DAM1
 */
public class ejecuta {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        OperationsIO util = new OperationsIO("datos");
        ArrayList<Medicamento> listado;
        try {
            listado = (ArrayList<Medicamento>) util.read();
        } catch (Exception e) {
            listado = new ArrayList<>();
        }
        int opcion = 0;
        do {
            System.out.println("Introduce opcion:");
            System.out.println("1.Dar de alta un medicamento");
            System.out.println("2.Buscar un medicamento");
            System.out.println("3.Venta de medicamento");
            System.out.println("4.Borrar un medicamento");
            System.out.println("5.SALIR");
            opcion = s.nextInt();
            switch (opcion) {
                case 1: {
                    System.out.println("Introduce el nombre del medicamento: ");
                    String nombre = s.nextLine();
                    System.out.println("Introduce fecha de fabricacion (dd/mm/yyyy)");
                    String fechaFab = s.nextLine();
                    System.out.println("Introduce fecha de caducidad (dd/mm/yyyy)");
                    String fechaCad = s.nextLine();
                    System.out.println("Introduce Precio Venta al Público");
                    double pvp = s.nextDouble();
                    System.out.println("Introduce principio activo del medicamento");
                    String princiActivo = s.nextLine();
                    System.out.println("Introduce miligramos");
                    double miligramos = s.nextDouble();
                    System.out.println("¿Necesita receta?");
                    System.out.println("0=NO");
                    System.out.println("1=SI");
                    int recetaInt = s.nextInt();
                    System.out.println("¿Cuantas unidades?");
                    int unidades = s.nextInt();
                    String lote = "";
                    Medicamento m = new Medicamento(nombre, pvp, princiActivo, recetaInt, miligramos);
                    Lotes l = new Lotes(lote,fechaCad, fechaFab, unidades);
                    lote = l.extension();
                }
                break;
                case 2: {
                    System.out.println("¿Vas a buscar el medicamento por su nombre o principio activo? \n 1. nombre \n 2.principio activo \n 3. Salir"  );
                    String opcionbusqueda = s.nextLine();
                    do {
                        switch (opcionbusqueda) {
                            case "1":
                                System.out.println("¿Cual es el nombre del medicamento que buscas?");
                                String nombreMed = s.nextLine();
                               // if ()
                                break;
                            case "2":
                                String nombrePrincip = s.nextLine();
                                break;
                            case "3":
                                System.out.println("Hasta pronto.");
                                break;
                            default:
                                System.out.println("Opcion no valida...");
                                break;
                        }
                    } while (!opcionbusqueda.equals("1") || !opcionbusqueda.equals("2") || opcionbusqueda.equals("3") );

                }
                break;
                case 3: {


                }
                break;

            }
        } while (opcion != 5);

        try {
            util.write(listado);
        } catch (IOException ex) {
            System.out.println("Error de escritura");
        }
    }
}