/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erp.BDH.equips;

import com.erp.BDH.DAO.equipsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author guiup
 */
@Controller
public class iniciEquipsControler {
    @Autowired //Anotació que injecta tots els mètodes i possibles dependències de GosDAO al controlador
    private equipsDAO equipsDAO; //Atribut per poder utilitzar les funcions CRUD de la interfície GosDAO
    
   @GetMapping("/iniciEquips")
    public String inici(Model model){ //Aquest és el mètode que generarà la resposta (recurs a retornar)
        
        model.addAttribute("equips", equipsDAO.findAll());
        //log.info("Executant el controlador Spring MVC"); //Afegeix al log el missatge passat com a paràmetre.
        return "equips/iniciEquips"; //Retorn de la pàgina iniciEstatic.html.
    }  
}
