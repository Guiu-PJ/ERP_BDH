/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erp.BDH.equips;

import com.erp.BDH.DAO.equipsDAO;
import com.erp.BDH.equips.serveis.EquipsService;
import com.erp.BDH.model.Equip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author guiup
 */


@Controller
public class iniciEquipsControler {

    @Autowired
    private EquipsService equipsService;

    /**
     * Mètode que gestiona la resposta a la sol·licitud GET a "/iniciEquips".
     * Retorna la pàgina "equips/iniciEquips" amb la llista d'equips i l'estat de visibilitat de la columna X en funció del rol de l'usuari.
     *
     * @param model Model per a afegir atributs a la vista.
     * @return La pàgina "equips/iniciEquips".
     */
    @GetMapping("/iniciEquips")
    public String inici(Model model) {
        org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        boolean esTipoX = auth.getAuthorities().contains(new SimpleGrantedAuthority("Admin"));
        if (esTipoX) {
            model.addAttribute("ocultar", true);
        } else {
            model.addAttribute("ocultar", false);
        }
        model.addAttribute("equips", equipsService.llistarEquips());
        return "equips/iniciEquips";
    }

    /**
     * Mètode que gestiona la resposta a la sol·licitud GET a "/equips/eliminar/{categoria}".
     * Elimina l'equip proporcionat i redirigeix a la pàgina inicial dels equips.
     *
     * @param equip Objecte Equip per a eliminar l'equip corresponent.
     * @return Redirecció a la pàgina inicial dels equips.
     */
    @GetMapping("/equips/eliminar/{categoria}")
    public String eliminar(Equip equip) {
        equipsService.eliminarEquip(equip);
        return "redirect:/iniciEquips";
    }
}
