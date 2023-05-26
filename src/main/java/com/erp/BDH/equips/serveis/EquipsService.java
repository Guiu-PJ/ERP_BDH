/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erp.BDH.equips.serveis;

import com.erp.BDH.DAO.equipsDAO;
import com.erp.BDH.model.Equip;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author guiup
 */

@Service
public class EquipsService implements EquipsServiceInterface {

    @Autowired
    private equipsDAO equipsDAO;

    /**
     * Retorna una llista amb tots els equips.
     *
     * @return Llista d'equips.
     */
    @Override
    public List<Equip> llistarEquips() {
        return (List<Equip>) equipsDAO.findAll();
    }

    /**
     * Cerca l'equip corresponent a l'identificador de categoria proporcionat.
     *
     * @param equip Objecte Equip amb l'identificador de categoria a cercar.
     * @return L'equip corresponent o null si no es troba.
     */
    @Override
    public Equip cercarEquip(Equip equip) {
        return this.equipsDAO.findById(equip.getCategoria()).orElse(null);
    }

    /**
     * Afegeix un nou equip a la base de dades.
     *
     * @param equip Objecte Equip a afegir.
     */
    @Override
    public void afegirEquip(Equip equip) {
        this.equipsDAO.save(equip);
    }

    /**
     * Elimina l'equip de la base de dades.
     *
     * @param equip Objecte Equip a eliminar.
     */
    @Override
    public void eliminarEquip(Equip equip) {
        this.equipsDAO.delete(equip);
    }
}
