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
   /**
    * Retorna una llista amb tots els equips.
    *
    * @return Llista d'equips.
    */
   public List<Equip> llistarEquips();

   /**
    * Afegeix un nou equip a la base de dades.
    *
    * @param equip Objecte Equip a afegir.
    */
   public void afegirEquip(Equip equip);

   /**
    * Elimina un equip de la base de dades.
    *
    * @param equip Objecte Equip a eliminar.
    */
   public void eliminarEquip(Equip equip);

   /**
    * Cerca un equip a la base de dades segons l'identificador de categoria.
    *
    * @param equip Objecte Equip amb l'identificador de categoria a cercar.
    * @return L'equip corresponent o null si no es troba.
    */
   public Equip cercarEquip(Equip equip);
}

