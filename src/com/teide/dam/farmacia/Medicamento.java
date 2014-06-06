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
    private String nombre,fechaFab,fechaCad,pinciActivo;
    private int receta;
    private double miligr,pvp;
    private HashMap <String, Double>principios=new HashMap<>();
    ArrayList<Lotes>listaLotes=new ArrayList<>();
    GregorianCalendar gc=new GregorianCalendar();
    
    public Medicamento(String nombre,Double pvp,String princiActivo,int receta,double miligr){
        this.fechaCad=gc.get(GregorianCalendar.DAY_OF_MONTH)+"/"+(gc.get(GregorianCalendar.MONTH)+1)+"/"+(gc.get(GregorianCalendar.YEAR)+1);
        this.fechaFab=gc.get(GregorianCalendar.DAY_OF_MONTH)+"/"+(gc.get(GregorianCalendar.MONTH)+1)+"/"+(gc.get(GregorianCalendar.YEAR));
        this.miligr=miligr;
        this.nombre=nombre;
        this.pinciActivo=princiActivo;
        this.pvp=pvp;
        this.receta=receta;
    }
    public String getNombre() {
        return nombre;
    }
    public String getFechaFab() {
        return fechaFab;
    }
    public String getFechaCad() {
        return fechaCad;
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
        
        
        
    }
   
    
    @Override
    public boolean equals(Object obj) {
        Medicamento m=(Medicamento) obj;
        return m.nombre.contains(nombre);
    }

    @Override
    public String toString() {
        return "Nombre: "+nombre+" Pr.activo: "+pinciActivo+" "+miligr+"mg"+" Receta: "+receta+" Fab: "+fechaFab+" Cad : "+fechaCad+" --> "+pvp+"€";
    }
}