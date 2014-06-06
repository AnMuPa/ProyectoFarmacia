/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teide.dam.farmacia;

import java.util.GregorianCalendar;

/**
 *
 * @author DAM1
 */
public class Lotes {
    
    
     private String lote,fechaFab,fechaCad;
    private int unidades;
 GregorianCalendar gc=new GregorianCalendar();
    
    public Lotes(String lote, int unidades) {
        this.lote = lote;
        this.unidades = unidades;
        this.fechaCad=gc.get(GregorianCalendar.DAY_OF_MONTH)+"/"+(gc.get(GregorianCalendar.MONTH)+1)+"/"+(gc.get(GregorianCalendar.YEAR)+1);
        this.fechaFab=gc.get(GregorianCalendar.DAY_OF_MONTH)+"/"+(gc.get(GregorianCalendar.MONTH)+1)+"/"+(gc.get(GregorianCalendar.YEAR));
    }
    
    
    public String getFechaFab() {
        return fechaFab;
    }
    public String getFechaCad() {
        return fechaCad;
    }  
  
    public String getLote() {
        return lote;
    }
    
    public int getUnidades() {
        return unidades;
    }
    
}