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
public class EquipsService implements EquipsServiceInterface{

    @Autowired
    private equipsDAO equipsDAO;
    
    
    @Override
    public List<Equip> llistarEquips() {
        return (List<Equip>) equipsDAO.findAll(); 
    }

    @Override
    public Equip cercarEquip(Equip equip) {
        return this.equipsDAO.findById(equip.getCategoria()).orElse(null);
    }

    @Override
    public void afegirEquip(Equip equip) {
        this.equipsDAO.save(equip);
    }

    @Override
    public void eliminarEquip(Equip equip) {
        this.equipsDAO.delete(equip);
    }
    
}
