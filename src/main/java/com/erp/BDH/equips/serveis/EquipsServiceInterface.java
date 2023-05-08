/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.erp.BDH.equips.serveis;

import com.erp.BDH.model.Equip;
import java.util.List;

/**
 *
 * @author guiup
 */
public interface EquipsServiceInterface {
   public List<Equip> llistarEquips(); //Mètode que implementarem per llistar jugadors
    
   public void afegirEquip(Equip equip); //Mètode que implementarem per afegir un jugador
    
   public void eliminarEquip(Equip equip); //Mètode que implementarem per eliminar un jugador
    
    public Equip cercarEquip(Equip equip); //Mètode que implementarem per cercar un jugador
}
