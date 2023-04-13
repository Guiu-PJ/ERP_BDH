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
public class JugadorsService implements JugadorsServeisInterface{
    
    @Autowired
    private jugadorsDAO jugadorsDAO;
    
    
    @Override
    @Transactional(readOnly=true)
    public List<Jugador> llistarJugadors() {
        return (List<Jugador>) jugadorsDAO.findAll(); 
    }
    
    
    /*Cercar el jugador passat per paràmetre en la taula jugadors de la BBDD bdh*/
    @Override
    @Transactional(readOnly=true) //Igual que en el mètode llistarJugadors, no modifiquem la informació de la BBDD
    public Jugador cercarJugador(Jugador jugador) {
        
        /*Cridem al mètode findById() de CrudRepository perquè ens retorni el gos passat com a paràmetre.
         *El paràmetre que li passem a aquest mètode, ha de ser la clau primària de l'entitat, en el nostre 
         *cas el jugador.
         *
         *Si el jugador no existei retornarà null (orElse(null)).
        */ 

        return this.jugadorsDAO.findById(jugador.getDni()).orElse(null);
        
    }
    
    //@Override
    //@Transactional
    @Override
    public void afegirJugador(Jugador jugador) {
        this.jugadorsDAO.save(jugador); 
    }

    @Override
    public void eliminarJugador(Jugador jugador) {
        this.jugadorsDAO.delete(jugador);
    }

    
    
    
}
