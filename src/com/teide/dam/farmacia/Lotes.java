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
public class Lotes {

    private String lote, fechaFab, fechaCad;
    private int unidades;
    GregorianCalendar gc = new GregorianCalendar();
    private Medicamento m;

    public Lotes(String lote, int unidades, Medicamento m) {
        this.lote = lote;
        this.fechaCad = gc.get(GregorianCalendar.DAY_OF_MONTH) + "/" + (gc.get(GregorianCalendar.MONTH) + 1) + "/" + (gc.get(GregorianCalendar.YEAR) + 1);
        this.fechaFab = gc.get(GregorianCalendar.DAY_OF_MONTH) + "/" + (gc.get(GregorianCalendar.MONTH) + 1) + "/" + (gc.get(GregorianCalendar.YEAR));
        this.unidades = unidades;
        this.m = m;
 
    }
    
    public Lotes(Medicamento m) {
        this.m = m;
    }
    
    public Medicamento getM() {
        return m;
    }

    public void setM(Medicamento m) {
        this.m = m;
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

    public String getFechaFab() {
        return fechaFab;
    }

    public String getFechaCad() {
        return fechaCad;
    }

   

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Lotes other = (Lotes) obj;
        if (!Objects.equals(this.m, other.m)) {
            return false;
        }
        return true;
    }

    
}