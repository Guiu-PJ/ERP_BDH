/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erp.BDH.basics.erpUsuaris;

import com.erp.BDH.basics.erpUsuaris.serveis.EntrenadorsService;
import com.erp.BDH.model.Entrenador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author guiup
 */
@Controller
public class iniciErpUsuaris {
    
    @Autowired //Anotació que injecta tots els mètodes i possibles dependències de EntrenadorsService al controlador    
    private EntrenadorsService entrenadorsService;
    
   @GetMapping("/iniciErpUsuaris")
    public String inici(Model model){ //Aquest és el mètode que generarà la resposta (recurs a retornar)
        model.addAttribute("entrenadors", entrenadorsService.llistarEntrenador());
        //log.info("Executant el controlador Spring MVC"); //Afegeix al log el missatge passat com a paràmetre.
        return "erpUsuaris/iniciErpUsuaris"; //Retorn de la pàgina iniciEstatic.html.
    } 
  
   @GetMapping("/entrenadors/eliminar/{dni}")
    public String eliminar(Entrenador entrenador) {

        /*Eliminem el gos passat per paràmetre, al qual li correspón l'idgos de @GetMapping mitjançant 
         *el mètode eliminarGos de la capa de servei.*/
        entrenadorsService.eliminarEntrenador(entrenador);
        
        return "redirect:/iniciErpUsuaris"; //Retornem a la pàgina inicial dels gossos mitjançant redirect
    }
}
