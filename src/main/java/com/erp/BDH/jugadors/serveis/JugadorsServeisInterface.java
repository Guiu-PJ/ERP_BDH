/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.erp.BDH.jugadors.serveis;

import com.erp.BDH.model.Jugador;
import java.util.List;

/**
 *
 * @author guiup
 */
public interface JugadorsServeisInterface {
    /**
     * Mètode per obtenir la llista de jugadors.
     * @return La llista de jugadors.
     */
    public List<Jugador> llistarJugadors();
    
    /**
     * Mètode per afegir un jugador.
     * @param jugador L'objecte jugador a afegir.
     */
    public void afegirJugador(Jugador jugador);
    
    /**
     * Mètode per eliminar un jugador.
     * @param jugador L'objecte jugador a eliminar.
     */
    public void eliminarJugador(Jugador jugador);
    
    /**
     * Mètode per cercar un jugador.
     * @param jugador L'objecte jugador a cercar.
     * @return El jugador cercat o null si no es troba.
     */
    public Jugador cercarJugador(Jugador jugador);
}