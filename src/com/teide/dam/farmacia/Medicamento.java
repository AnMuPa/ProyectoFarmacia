/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teide.dam.farmacia;

import java.util.Date;

/**
 *
 * @author DAM1
 */
public class Medicamento {
    String nombre;
    Date fechaFabricacion, fechaCaducidad;
    double precioVenta;
    boolean tipo;
    
    @Override
    public boolean equals(Object o){
        Medicamento m = (Medicamento) o;
        return m.contains(nombre);
    }
}
