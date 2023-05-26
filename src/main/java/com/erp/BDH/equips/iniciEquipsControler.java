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
    @Autowired //Anotació que injecta tots els mètodes i possibles dependències de GosService al controlador    
    private EquipsService equipsService;
    
   @GetMapping("/iniciEquips")
    public String inici(Model model){ //Aquest és el mètode que generarà zla resposta (recurs a retornar)
        org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        boolean esTipoX = auth.getAuthorities().contains(new SimpleGrantedAuthority("Admin"));
        if (esTipoX) {
            // Agregar un atributo al modelo para indicar que se debe mostrar la columna X
            model.addAttribute("ocultar", true);
        } else {
            model.addAttribute("ocultar", false);
        }
        model.addAttribute("equips", equipsService.llistarEquips());
        //log.info("Executant el controlador Spring MVC"); //Afegeix al log el missatge passat com a paràmetre.
        return "equips/iniciEquips"; //Retorn de la pàgina iniciEstatic.html.
    }  

    @GetMapping("/equips/eliminar/{categoria}")
    public String eliminar(Equip equip) {

        /*Eliminem el gos passat per paràmetre, al qual li correspón l'idgos de @GetMapping mitjançant 
         *el mètode eliminarGos de la capa de servei.*/
        equipsService.eliminarEquip(equip);
        
        return "redirect:/iniciEquips"; //Retornem a la pàgina inicial dels gossos mitjançant redirect
    }
}
