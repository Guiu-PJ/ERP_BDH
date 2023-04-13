/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.erp.BDH.basics.erpUsuaris.serveis;

import com.erp.BDH.model.Entrenador;
import java.util.List;

/**
 *
 * @author guiup
 */
public interface EntrenadorsServeisInterface {
    public List<Entrenador> llistarEntrenador(); //Mètode que implementarem per llistar entrenador
    
    public void afegirEntrenador(Entrenador entrenador); //Mètode que implementarem per afegir un entrenador
    
    public void eliminarEntrenador(Entrenador entrenador); //Mètode que implementarem per eliminar un entrenador
    
    public Entrenador cercarEntrenador(Entrenador entrenador); //Mètode que implementarem per cercar un entrenador
}
