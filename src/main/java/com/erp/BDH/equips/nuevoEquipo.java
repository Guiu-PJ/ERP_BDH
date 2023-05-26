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

    @Autowired //Anotació que injecta tots els mètodes i possibles dependències de EntrenadorsService al controlador    
    private EntrenadorsService entrenadorsService;

    @Autowired //Anotació que injecta tots els mètodes i possibles dependències de GosService al controlador    
    private EquipsService equipsService;

    @GetMapping("/nuevoEquipo")
    public String inici(Equip equip, Model model) { //Aquest és el mètode que generarà la resposta (recurs a retornar)

        model.addAttribute("entrenadors", entrenadorsService.llistarEntrenador());
        //log.info("Executant el controlador Spring MVC"); //Afegeix al log el missatge passat com a paràmetre.
        return "equips/nuevoEquipo"; //Retorn de la pàgina iniciEstatic.html.
    }

    @GetMapping("/equips/{categoria}")
    public String editar(Equip equip, Model model) {
        model.addAttribute("entrenadors", entrenadorsService.llistarEntrenador());
        model.addAttribute("equip", equipsService.cercarEquip(equip));

        return "equips/nuevoEquipo"; //Retorna la pàgina amb el formulari de les dades del gos
    }

    @PostMapping("/guardarEquips") //action=guardarEquip
    public String guardarEquips(Model model, @Valid Equip equip, Errors errors) {
        model.addAttribute("entrenadors", entrenadorsService.llistarEntrenador());
        if(errors.hasErrors()){ //Si s'han produït errors...
             return "equips/nuevoEquipo"; //Mostrem la pàgina del formulari
        }
        equipsService.afegirEquip(equip); //Afegim el gos passat per paràmetre a la base de dades

        return "redirect:/iniciEquips"; //Retornem a la pàgina inicial dels gossos mitjançant redirect
    }
}
