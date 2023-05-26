/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erp.BDH.basics.erpUsuaris;

import com.erp.BDH.basics.erpUsuaris.serveis.EntrenadorsService;
import com.erp.BDH.model.Entrenador;
import com.erp.BDH.utils.EncriptadorContrasenya;
import jakarta.validation.Valid;
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
public class nuevoEntrenador {
    @Autowired //Anotació que injecta tots els mètodes i possibles dependències de EntrenadorsService al controlador    
    private EntrenadorsService entrenadorsService;
    
    @GetMapping("/nuevoEntrenador")
    public String inici(Entrenador entenador){ //Aquest és el mètode que generarà la resposta (recurs a retornar)
        //log.info("Executant el controlador Spring MVC"); //Afegeix al log el missatge passat com a paràmetre.
        return "erpUsuaris/nuevoEntrenador"; //Retorn de la pàgina iniciEstatic.html.
    }
    
    @GetMapping("/entrenadors/{dni}")
    public String editar(Entrenador entrenador, Model model) {
        model.addAttribute("entrenador", entrenadorsService.cercarEntrenador(entrenador));

        return "erpUsuaris/nuevoEntrenador"; //Retorna la pàgina amb el formulari de les dades del gos
    }
    
    @PostMapping("/guardarEntrenador") //action=guardarEquip
    public String guardarEntrenador(@Valid Entrenador entrenador, Errors errors) {

        if(errors.hasErrors()){ //Si s'han produït errors...
             return "erpUsuaris/nuevoEntrenador"; //Mostrem la pàgina del formulari
        }
        String password = entrenador.getContrasenya();
        String  a = EncriptadorContrasenya.encriptarContrasenya(password);
        entrenador.setContrasenya(a);
        
        
        entrenadorsService.afegirEntrenador(entrenador); //Afegim el gos passat per paràmetre a la base de dades

        return "redirect:/iniciErpUsuaris"; //Retornem a la pàgina inicial dels gossos mitjançant redirect
    }
    
    
    
}
