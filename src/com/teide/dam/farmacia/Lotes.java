/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teide.dam.farmacia;

import java.util.Collections;
import java.util.GregorianCalendar;

/**
 *
 * @author DAM1
 */
public class Lotes {
    
    private String lote, fechaFab, fechaCad;
    private int unidades;
    GregorianCalendar gc=new GregorianCalendar();

    public Lotes(String lote, String fechaFab, String fechaCad, int unidades) {
        this.lote = lote;
        this.fechaCad=gc.get(GregorianCalendar.DAY_OF_MONTH)+"/"+(gc.get(GregorianCalendar.MONTH)+1)+"/"+(gc.get(GregorianCalendar.YEAR)+1);
        this.fechaFab=gc.get(GregorianCalendar.DAY_OF_MONTH)+"/"+(gc.get(GregorianCalendar.MONTH)+1)+"/"+(gc.get(GregorianCalendar.YEAR));
        this.unidades = unidades;
    }

    public String getLote() {
        return lote;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }
    
    public String extension(){
        int i = 0;
        i++;
        String extension = "";
        extension = String.valueOf(i);
        
        return "lote"+extension;
    }
    
    
    public String getFechaFab() {
    return fechaFab;
    }
    public String getFechaCad() {
        return fechaCad;
    }  
    
    
}