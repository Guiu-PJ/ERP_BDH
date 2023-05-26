/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erp.BDH.basics.erp;

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
public class iniciControler {
    /**
     * Controlador per a la pàgina d'inici.
     * Retorna la vista "inici" i configura els atributs del model en funció del rol de l'usuari autenticat.
     */
    @GetMapping("/inici")
    public String inici(Model model) {
        org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        boolean esAdmin = auth.getAuthorities().contains(new SimpleGrantedAuthority("Admin"));
        boolean esJugador = auth.getAuthorities().contains(new SimpleGrantedAuthority("Jugador"));
        boolean esEntrenador = auth.getAuthorities().contains(new SimpleGrantedAuthority("Entrenador"));

        // Mòdul Jugadors
        if (esAdmin || esJugador || esEntrenador) {
            model.addAttribute("jugadors", true);
        } else {
            model.addAttribute("jugadors", false);
        }

        // Mòdul Equips
        if (esAdmin || esJugador || esEntrenador) {
            model.addAttribute("equips", true);
        } else {
            model.addAttribute("equips", false);
        }

        // Mòdul Usuaris
        if (esAdmin || esEntrenador) {
            model.addAttribute("usuaris", true);
        } else {
            model.addAttribute("usuaris", false);
        }

        // Mòdul ERP
        if (esAdmin) {
            model.addAttribute("erp", true);
        } else {
            model.addAttribute("erp", false);
        }

        return "inici";
    }
}
