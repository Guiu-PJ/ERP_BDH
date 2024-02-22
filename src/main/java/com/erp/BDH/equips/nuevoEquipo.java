/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erp.BDH.equips;

import com.erp.BDH.basics.erpUsuaris.serveis.EntrenadorsService;
import com.erp.BDH.equips.serveis.EquipsService;
import com.erp.BDH.model.Equip;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author guiup
 */
@Controller
@Slf4j
public class nuevoEquipo {

    @Autowired
    private EntrenadorsService entrenadorsService;

    @Autowired
    private EquipsService equipsService;

    /**
     * Mètode que gestiona la resposta a la sol·licitud GET a "/nuevoEquipo".
     * Retorna la pàgina "equips/nuevoEquipo" amb els entrenadors disponibles.
     *
     * @param equip Objecte Equip per a l'enllaç de dades amb el formulari.
     * @param model Model per a afegir atributs a la vista.
     * @return La pàgina "equips/nuevoEquipo".
     */
    @GetMapping("/nuevoEquipo")
    public String inici(Equip equip, Model model) {
        model.addAttribute("entrenadors", entrenadorsService.llistarEntrenador());
        return "equips/nuevoEquipo";
    }

    /**
     * Mètode que gestiona la resposta a la sol·licitud GET a "/equips/{categoria}".
     * Retorna la pàgina "equips/nuevoEquipo" amb els entrenadors disponibles i les dades de l'equip a editar.
     *
     * @param equip Objecte Equip per a l'enllaç de dades amb el formulari.
     * @param model Model per a afegir atributs a la vista.
     * @return La pàgina "equips/nuevoEquipo".
     */
    @GetMapping("/equips/{categoria}")
    public String editar(Equip equip, Model model) {
        model.addAttribute("entrenadors", entrenadorsService.llistarEntrenador());
        model.addAttribute("equip", equipsService.cercarEquip(equip));
        return "equips/nuevoEquipo";
    }

    /**
     * Mètode que gestiona la resposta a la sol·licitud POST a "/guardarEquips".
     * Guarda l'equip enviat a la base de dades i redirigeix a la pàgina inicial dels equips.
     *
     * @param model Model per a afegir atributs a la vista.
     * @param equip Objecte Equip per a l'enllaç de dades amb el formulari.
     * @param errors Objecte Errors per a verificar si hi ha errors en les dades del formulari.
     * @return Redirecció a la pàgina inicial dels equips.
     */
    @PostMapping("/guardarEquips")
    public String guardarEquips(Model model, @Valid Equip equip, Errors errors) {
        model.addAttribute("entrenadors", entrenadorsService.llistarEntrenador());
        if(errors.hasErrors()){
             return "equips/nuevoEquipo";
        }
        equipsService.afegirEquip(equip);
        return "redirect:/iniciEquips";
    }
}

