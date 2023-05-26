/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erp.BDH.basics.erpUsuaris;

import com.erp.BDH.DAO.entrenadorDAO;
import com.erp.BDH.DAO.perfilDAO;
import java.security.Principal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author guiup
 */
@Controller
@Slf4j
public class perfilControler {

    @Autowired // Anotació que injecta tots els mètodes i possibles dependències de GosDAO al controlador
    private perfilDAO perfilDAO;

    /**
     * Controlador per a la pàgina de perfil de l'usuari.
     *
     * @param model     Model per a afegir atributs per a la vista.
     * @param principal Objecte Principal que representa l'usuari autenticat.
     * @return Retorna la vista "perfil/perfil" amb les dades del perfil de l'usuari.
     */
    @GetMapping("/perfil")
    public String inici(Model model, Principal principal) {
        // Obtener el nombre de usuario del objeto Principal
        String username = principal.getName();

        // Buscar el perfil del usuario en la base de datos utilizando su DNI
        var perfil = perfilDAO.findByDni(username);

        // Agregar los atributos del perfil del usuario al modelo
        model.addAttribute("perfil", perfil);
        model.addAttribute("usuariAdreca", perfil.getAdreca());
        model.addAttribute("usuariAnyNaixement", perfil.getAny_naixement());
        model.addAttribute("usuariDni", perfil.getDni());
        model.addAttribute("usuariNumContacte", perfil.getNum_contacte());
        model.addAttribute("usuariCategoria", perfil.getCategoria());
        model.addAttribute("usuariNumero", perfil.getNumero());
        model.addAttribute("usuariQuota", perfil.getQuota());
        model.addAttribute("usuariTutorLegal", perfil.getTutor_legal());

        var usuariNomICongnoms = perfil.getNom() + " " + perfil.getCognoms();
        model.addAttribute("usuariNomICongnoms", usuariNomICongnoms);

        return "perfil/perfil";
    }
}
