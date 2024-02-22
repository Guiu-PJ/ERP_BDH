/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erp.BDH.jugadors.serveis;

import com.erp.BDH.DAO.jugadorsDAO;
import com.erp.BDH.model.Jugador;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author guiup
 */

@Service
public class JugadorsService implements JugadorsServeisInterface {
    
    @Autowired
    private jugadorsDAO jugadorsDAO;
    
    @Override
    @Transactional(readOnly = true)
    public List<Jugador> llistarJugadors() {
        return (List<Jugador>) jugadorsDAO.findAll();
    }
    
    /**
     * Cerca un jugador a partir del seu dni.
     * @param jugador L'objecte jugador amb el dni a cercar.
     * @return El jugador cercat o null si no es troba.
     */
    @Override
    @Transactional(readOnly = true)
    public Jugador cercarJugador(Jugador jugador) {
        return jugadorsDAO.findById(jugador.getDni()).orElse(null);
    }
    
    /**
     * Afegeix un jugador a la base de dades.
     * @param jugador L'objecte jugador a afegir.
     */
    @Override
    public void afegirJugador(Jugador jugador) {
        jugadorsDAO.save(jugador);
    }

    /**
     * Elimina un jugador de la base de dades.
     * @param jugador L'objecte jugador a eliminar.
     */
    @Override
    public void eliminarJugador(Jugador jugador) {
        jugadorsDAO.delete(jugador);
    }
}
