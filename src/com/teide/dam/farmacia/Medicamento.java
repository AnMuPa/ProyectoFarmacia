/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teide.dam.farmacia;


import java.util.*;

/**
 *
 * @author DAM1
 */
public class Medicamento {
    private String nombre,pinciActivo;
    private int receta, unidadesTotales;
    private double miligr,pvp;
    ArrayList<Lotes>listaLotes =new ArrayList<>();
    ArrayList<Medicamento> listaMedicamentos =new ArrayList<>();
    

  public Medicamento(){
      
  }
    
    
    public Medicamento(String nombre,Double pvp,String princiActivo,int receta,double miligr){
        this.miligr=miligr;
        this.nombre=nombre;
        this.pinciActivo=princiActivo;
        this.pvp=pvp;
        this.receta=receta;
        
    }
    
    public Medicamento(String princiActivo){

        this.pinciActivo=princiActivo;

    }
    
    
    public String getNombre() {
        return nombre;
    }

    public void setUnidadesTotales(int unidadesTotales) {
        this.unidadesTotales += unidadesTotales;
    }

    public String getPinciActivo() {
        return pinciActivo;
    }
    public int getReceta() {
        return receta;
    }
    public double getMiligr() {
        return miligr;
    }
    public double getPvp() {
        return pvp;
    }

    public void setPvp(double pvp) {
        this.pvp = pvp;
    }

    public boolean altaLote(Lotes l){
    if (listaLotes.contains(l.getLote())) return false;
    listaLotes.add(l);
    unidadesTotales += l.getUnidades();
    return true;
        
        
    }
  
    private boolean eliminarLote (Lotes l) {
        if( listaLotes.remove(l.getLote())) return true;
        return false;
    }
    
    public boolean ventaMedicamento (String Nmedicamento, int unidades){
        Scanner s = new Scanner(System.in);
        double precioTotal;
        if (listaMedicamentos.contains(Nmedicamento)) {
          if (unidadesTotales >= unidades) {
          precioTotal = pvp * unidades;
          System.out.println("El coste total es de: "+precioTotal+" \n ¿Esta conforme? \n 1.Si \n 2.No");
          int opcion = s.nextInt();
          s.nextLine();
          do {
          switch (opcion) {
            case 1: {
          System.out.println("Venta realizada con exito");
          unidadesTotales =  unidadesTotales - unidades;
          return true;
            }
            case 2: {
                System.out.println("Operación cancelada");
                return false;
            }
            default: System.out.println("Opcion incorrecta");
                return false;
                
          }
          } while (opcion != 1 || opcion != 2);
          } 
          else System.out.println("No disponemos de tal numero de unidades,  unicamente quedan "+unidadesTotales+" de "+Nmedicamento);
          return false;
        }
        return false;
    }
    
    public String extension(){
        int i = 0;
        i++;
        String extension = "";
        extension = String.valueOf(i);
        return "lote"+extension;
    }
   

    
    @Override
    public boolean equals(Object obj) {
        Medicamento m=(Medicamento) obj;
        return m.nombre.contains(nombre);
    }

        public String toString(Object obj) {
        Lotes lt = (Lotes) obj;
        return "Nombre: "+nombre+" Pr.activo: "+pinciActivo+" "+miligr+"mg"+" Receta: "+receta+" Fab: "+lt.getFechaFab()+" Cad : "+lt.getFechaCad()+" --> "+pvp+"€";
    }
}