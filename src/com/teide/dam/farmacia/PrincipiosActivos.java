/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teide.dam.farmacia;

import java.util.HashMap;

/**
 *
 * @author DAM1
 */
public class PrincipiosActivos {
    String nombre;
    double miligramos;
    private HashMap <String, Double>principios=new HashMap<>();
    
     @Override
    public boolean equals(Object o){
        PrincipiosActivos pa = (PrincipiosActivos) o;
        return pa.nombre.contains(nombre);
    }
}