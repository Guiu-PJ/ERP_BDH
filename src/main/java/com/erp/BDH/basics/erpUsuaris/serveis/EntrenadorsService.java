/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erp.BDH.basics.erpUsuaris.serveis;

import com.erp.BDH.DAO.entrenadorDAO;
import com.erp.BDH.model.Entrenador;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author guiup
 */
@Service
public class EntrenadorsService implements EntrenadorsServeisInterface {

    @Autowired
    private entrenadorDAO entrenadorsDAO;

    @Override
    public List<Entrenador> llistarEntrenador() {
        return (List<Entrenador>) entrenadorsDAO.findAll();
    }

    @Override
    public void afegirEntrenador(Entrenador entrenador) {
        this.entrenadorsDAO.save(entrenador);
    }

    @Override
    public void eliminarEntrenador(Entrenador entrenador) {
        this.entrenadorsDAO.delete(entrenador);
    }

    @Override
    public Entrenador cercarEntrenador(Entrenador entrenador) {
        return this.entrenadorsDAO.findById(entrenador.getDni()).orElse(null);
    }

}
