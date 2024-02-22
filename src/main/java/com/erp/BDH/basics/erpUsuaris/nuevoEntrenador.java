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
    @Autowired // Anotació que injecta tots els mètodes i possibles dependències de EntrenadorsService al controlador    
    private EntrenadorsService entrenadorsService;
    
    /**
     * Controlador per a la pàgina de creació d'un nou entrenador.
     * 
     * @param entrenador Entrenador a crear.
     * @return Retorna la vista "erpUsuaris/nuevoEntrenador" amb el formulari per a introduir les dades del nou entrenador.
     */
    @GetMapping("/nuevoEntrenador")
    public String inici(Entrenador entenador) {
        //log.info("Executant el controlador Spring MVC"); //Afegeix al log el missatge passat com a paràmetre.
        return "erpUsuaris/nuevoEntrenador"; //Retorn de la pàgina iniciEstatic.html.
    }
    
    /**
     * Controlador per a l'edició d'un entrenador.
     * 
     * @param entrenador Entrenador a editar.
     * @param model Model per a afegir atributs per a la vista.
     * @return Retorna la vista "erpUsuaris/nuevoEntrenador" amb el formulari per a editar les dades de l'entrenador.
     */
    @GetMapping("/entrenadors/{dni}")
    public String editar(Entrenador entrenador, Model model) {
        model.addAttribute("entrenador", entrenadorsService.cercarEntrenador(entrenador));

        return "erpUsuaris/nuevoEntrenador"; //Retorna la pàgina amb el formulari de les dades del gos
    }
    
    /**
     * Controlador per a guardar les dades d'un entrenador.
     * 
     * @param entrenador Entrenador a guardar.
     * @param errors Objecte Errors per a comprovar si hi ha hagut errors en les dades del formulari.
     * @return Redirigeix a la pàgina inicial de l'ERP d'usuaris si les dades són vàlides, altrament torna a la pàgina "erpUsuaris/nuevoEntrenador" amb el formulari mostrant els errors.
     */
    @PostMapping("/guardarEntrenador")
    public String guardarEntrenador(@Valid Entrenador entrenador, Errors errors) {
        if (errors.hasErrors()) { // Si s'han produït errors...
             return "erpUsuaris/nuevoEntrenador"; // Mostrem la pàgina del formulari
        }
        
        String password = entrenador.getContrasenya();
        String encryptedPassword = EncriptadorContrasenya.encriptarContrasenya(password);
        entrenador.setContrasenya(encryptedPassword);
        
        entrenadorsService.afegirEntrenador(entrenador); // Afegim l'entrenador passat per paràmetre a la base de dades

        return "redirect:/iniciErpUsuaris"; // Retornem a la pàgina inicial dels gossos mitjançant redirect
    }
}

