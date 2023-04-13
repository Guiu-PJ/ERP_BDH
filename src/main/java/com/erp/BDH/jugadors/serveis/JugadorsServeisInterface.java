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
    public List<Jugador> llistarJugadors(); //Mètode que implementarem per llistar jugadors
    
    public void afegirJugador(Jugador jugador); //Mètode que implementarem per afegir un jugador
    
    public void eliminarJugador(Jugador jugador); //Mètode que implementarem per eliminar un jugador
    
    public Jugador cercarJugador(Jugador jugador); //Mètode que implementarem per cercar un jugador
}
