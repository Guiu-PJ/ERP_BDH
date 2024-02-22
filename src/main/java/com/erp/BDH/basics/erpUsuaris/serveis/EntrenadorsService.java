/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erp.BDH.basics.erpUsuaris.serveis;

import com.erp.BDH.DAO.entrenadorDAO;
import com.erp.BDH.model.Entrenador;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author guiup
 */
@Service
@Slf4j
public class EntrenadorsService implements EntrenadorsServeisInterface {

    @Autowired
    private entrenadorDAO entrenadorsDAO;

    /**
     * Retorna una llista de tots els entrenadors.
     *
     * @return Llista d'objectes Entrenador.
     */
    @Override
    public List<Entrenador> llistarEntrenador() {
        return (List<Entrenador>) entrenadorsDAO.findAll();
    }

    /**
     * Afegeix un nou entrenador.
     *
     * @param entrenador Objecte Entrenador a afegir.
     */
    @Override
    public void afegirEntrenador(Entrenador entrenador) {
        this.entrenadorsDAO.save(entrenador);
    }

    /**
     * Elimina un entrenador existent.
     *
     * @param entrenador Objecte Entrenador a eliminar.
     */
    @Override
    public void eliminarEntrenador(Entrenador entrenador) {
        this.entrenadorsDAO.delete(entrenador);
    }

    /**
     * Cerca un entrenador amb el mateix identificador.
     *
     * @param entrenador Objecte Entrenador a cercar.
     * @return Objecte Entrenador corresponent o null si no es troba.
     */
    @Override
    public Entrenador cercarEntrenador(Entrenador entrenador) {
        return this.entrenadorsDAO.findById(entrenador.getDni()).orElse(null);
    }
}
