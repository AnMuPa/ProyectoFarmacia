/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teide.dam.ejecuta;

import java.io.IOException;
import java.util.Scanner;
import com.teide.dam.aortiz.ioutil.OperationsIO;
import com.teide.dam.farmacia.Lotes;
import com.teide.dam.farmacia.Medicamento;
import com.teide.dam.farmacia.Farmacia;
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
            Farmacia f = new Farmacia();
            switch (opcion) {
                case 1: {
                    s.nextLine();
                    System.out.println("Introduce el nombre del medicamento: ");
                    String nombre = s.nextLine();
//                    System.out.println("Introduce fecha de fabricacion (dd/mm/yyyy)");
//                    String fechaFab = s.nextLine();
//                    System.out.println("Introduce fecha de caducidad (dd/mm/yyyy)");
//                    String fechaCad = s.nextLine();
                    System.out.println("Introduce Precio Venta al Público");
                    double pvp = s.nextDouble();
                    s.nextLine();
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
                    s.nextLine();
                    Medicamento m =new Medicamento(nombre, pvp, princiActivo, recetaInt, miligramos);
                    String lote=m.extension();
                    Lotes l = new Lotes(lote, unidades);
                    
                    
                }
                break;
                case 2: {
                    s.nextLine();
                    System.out.println("¿Vas a buscar el medicamento por su nombre o principio activo? \n 1. nombre \n 2.principio activo \n 3. Salir"  );
                    String opcionbusqueda = s.nextLine();
                    do {
                        switch (opcionbusqueda) {
                            case "1":
                                System.out.println("¿Cual es el nombre del medicamento que buscas?");
                                String nombreMed = s.nextLine();
                                if(f.buscarMedicamento(nombreMed)==true){
                                    System.out.println("encontrado");
                                }else{
                                    System.out.println("no encontrado");
                                }
                                break;
                            case "2":
                                System.out.println("¿Cual es el principio activo del medicamento que buscas?");
                                String nombrePrincip = s.nextLine();
                                if(f.buscarPrincipioActivo(nombrePrincip)==true){
                                    System.out.println("encontrado");
                                }else{
                                    System.out.println("no encontrado");
                                }
                                break;
                            case "3":
                                System.out.println("Hasta pronto.");
                                break;
                            default:
                                System.out.println("Opcion no valida...");
                                break;
                        }
                        System.out.println("¿Vas a buscar el medicamento por su nombre o principio activo? \n 1. nombre \n 2.principio activo \n 3. Salir"  );
                        opcionbusqueda = s.nextLine();
                    } while (!opcionbusqueda.equals("3") );

                }
                break;
                case 3: {
                    s.nextLine();
                    Medicamento m = new Medicamento();
                    System.out.println("De que medicamento se va a realizar la venta?");
                    String nombreV = s.nextLine();
                    if(f.buscarMedicamento(nombreV) || f.buscarPrincipioActivo(nombreV)){
                        System.out.println("¿Cuantas unidades de "+nombreV+" ?");
                        int unidadesV = s.nextInt();
                        s.nextLine();
                        m.ventaMedicamento(nombreV, unidadesV);
                    }else{
                        System.out.println("medicamento no encontrado");
                    }
                    
                }
                break;
                case 4: {
                    s.nextLine();
                    System.out.println("Introduce el nombre del medicamento a borrar: ");
                    String nombre=s.nextLine();
                    
                }
            }
            
        } while (opcion != 5);

        try {
            util.write(listado);
        } catch (IOException ex) {
            System.out.println("Error de escritura");
        }
    }
}