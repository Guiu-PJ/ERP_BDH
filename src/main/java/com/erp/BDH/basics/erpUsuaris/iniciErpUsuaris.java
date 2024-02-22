/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erp.BDH.basics.erpUsuaris;

import com.erp.BDH.basics.erpUsuaris.serveis.EntrenadorsService;
import com.erp.BDH.model.Entrenador;
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
public class iniciErpUsuaris {
    
    @Autowired // Anotació que injecta tots els mètodes i possibles dependències de EntrenadorsService al controlador    
    private EntrenadorsService entrenadorsService;
    
    /**
     * Controlador per a la pàgina d'inici de l'ERP d'usuaris.
     * 
     * @param model Model per a afegir atributs per a la vista.
     * @return Retorna la vista "erpUsuaris/iniciErpUsuaris".
     */
    @GetMapping("/iniciErpUsuaris")
    public String inici(Model model) {
        // Obtenim l'autenticació de l'usuari actual
        org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        // Comprovem si l'usuari té el rol d'Admin
        boolean esTipoX = auth.getAuthorities().contains(new SimpleGrantedAuthority("Admin"));
        if (esTipoX) {
            // Agreguem un atribut al model per indicar que s'ha de mostrar la columna X
            model.addAttribute("ocultar", true);
        } else {
            model.addAttribute("ocultar", false);
        }
        
        // Afegim al model la llista d'entrenadors obtinguda del servei
        model.addAttribute("entrenadors", entrenadorsService.llistarEntrenador());
        
        return "erpUsuaris/iniciErpUsuaris";
    } 
  
    /**
     * Controlador per a l'eliminació d'un entrenador.
     * 
     * @param entrenador Entrenador a eliminar.
     * @return Redirigeix a la pàgina d'inici de l'ERP d'usuaris.
     */
    @GetMapping("/entrenadors/eliminar/{dni}")
    public String eliminar(Entrenador entrenador) {
        // Eliminem l'entrenador passat per paràmetre, corresponent a l'atribut "dni" de @GetMapping, mitjançant el mètode eliminarEntrenador del servei
        entrenadorsService.eliminarEntrenador(entrenador);
        
        return "redirect:/iniciErpUsuaris";
    }
}
