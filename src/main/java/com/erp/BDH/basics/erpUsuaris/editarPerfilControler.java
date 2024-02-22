/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erp.BDH.basics.erpUsuaris;

import com.erp.BDH.DAO.perfilDAO;
import com.erp.BDH.jugadors.serveis.JugadorsService;
import com.erp.BDH.model.Entrenador;
import com.erp.BDH.model.Jugador;
import com.erp.BDH.utils.EncriptadorContrasenya;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Controlador per a l'edició del perfil d'un usuari.
 */
@Controller
public class editarPerfilControler {
    @Autowired
    private JugadorsService jugadorsService;
    
    @Autowired
    private perfilDAO perfilDAO;
    
    /**
     * Mètode per mostrar la pàgina d'inici de l'edició del perfil.
     * @param model Model per a afegir atributs a la vista.
     * @return Vista "perfil/editarPerfil".
     */
    @GetMapping("/editarPerfil")
    public String inici(Model model){
        model.addAttribute("perfil", perfilDAO.findAll());

        var perfil = perfilDAO.findByDni("23434507G");
            
        var usuariNom = perfil.getNom(); 
        var usuariCognom = perfil.getCognoms();
        var usuariAdreca = perfil.getAdreca();
        model.addAttribute("usuariAdreca", usuariAdreca);
        var usuariAnyNaixement = perfil.getAny_naixement();
        model.addAttribute("usuariAnyNaixement", usuariAnyNaixement);
        var usuariDni = perfil.getDni();
        model.addAttribute("usuariDni", usuariDni);
        var usuariNumContacte = perfil.getNum_contacte();
        model.addAttribute("usuariNumContacte", usuariNumContacte);
        var usuariCategoria = perfil.getCategoria();
        model.addAttribute("usuariCategoria", usuariCategoria);
        var usuariNumero = perfil.getNumero();
        model.addAttribute("usuariNumero", usuariNumero);
        var usuariQuota = perfil.getQuota();
        model.addAttribute("usuariQuota", usuariQuota);
        var usuariTutorLegal = perfil.getTutor_legal();
        model.addAttribute("usuariTutorLegal", usuariTutorLegal);
        
        var usuariNomICongnoms = usuariNom + " " + usuariCognom;
        model.addAttribute("usuariNomICongnoms", usuariNomICongnoms);
        
        return "perfil/editarPerfil";
    }
    
    /**
     * Mètode per guardar els canvis realitzats en el perfil de l'usuari.
     * @param jugador Objecte jugador amb les dades del perfil actualitzades.
     * @param errors Objecte Errors per a capturar els errors de validació.
     * @return Redirecció a la pàgina de perfil.
     */
    @PostMapping("/guardarPerfil")
    public String guardarPerfil(@Valid Jugador jugador, Errors errors) {
        if(errors.hasErrors()){
            return "perfil/editarPerfil";
        }
        
        jugadorsService.afegirJugador(jugador);
        
        return "redirect:/perfil/perfil";
    }
}