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
    /**
     * Retorna una llista de tots els entrenadors.
     *
     * @return Llista d'objectes Entrenador.
     */
    public List<Entrenador> llistarEntrenador();

    /**
     * Afegeix un nou entrenador.
     *
     * @param entrenador Objecte Entrenador a afegir.
     */
    public void afegirEntrenador(Entrenador entrenador);

    /**
     * Elimina un entrenador existent.
     *
     * @param entrenador Objecte Entrenador a eliminar.
     */
    public void eliminarEntrenador(Entrenador entrenador);

    /**
     * Cerca un entrenador amb el mateix identificador.
     *
     * @param entrenador Objecte Entrenador a cercar.
     * @return Objecte Entrenador corresponent o null si no es troba.
     */
    public Entrenador cercarEntrenador(Entrenador entrenador);
}

