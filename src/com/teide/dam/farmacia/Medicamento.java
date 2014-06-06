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
    private HashMap <String, Double>principios=new HashMap<>();
    ArrayList<Lotes>listaLotes=new ArrayList<>();
    
    
    
    public Medicamento(String nombre,Double pvp,String princiActivo,int receta,double miligr){
        this.miligr=miligr;
        this.nombre=nombre;
        this.pinciActivo=princiActivo;
        this.pvp=pvp;
        this.receta=receta;
    }
    public String getNombre() {
        return nombre;
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