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
    @GetMapping("/inici")
    public String inici(Model model){ //Aquest és el mètode que generarà la resposta (recurs a retornar)
        org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        boolean esAmin = auth.getAuthorities().contains(new SimpleGrantedAuthority("Admin"));
        boolean esJugador = auth.getAuthorities().contains(new SimpleGrantedAuthority("Jugador"));
        boolean esEntrenador = auth.getAuthorities().contains(new SimpleGrantedAuthority("Entrenador"));
        //Modul Jugadors
        if (esAmin) {
            // Agregar un atributo al modelo para indicar que se debe mostrar la columna X
            model.addAttribute("jugadors", true);
        } else if(esJugador) {
            model.addAttribute("jugadors", true);
        }else if(esEntrenador){
            model.addAttribute("jugadors", true);
        }else{
            model.addAttribute("jugadors", false);
        }
        
        //Modul equips
        if (esAmin) {
            // Agregar un atributo al modelo para indicar que se debe mostrar la columna X
            model.addAttribute("equips", true);
        } else if(esJugador) {
            model.addAttribute("equips", true);
        }else if(esEntrenador){
            model.addAttribute("equips", true);
        }else{
            model.addAttribute("equips", false);
        }
        
        //Modul Usuaris
        if (esAmin) {
            // Agregar un atributo al modelo para indicar que se debe mostrar la columna X
            model.addAttribute("usuaris", true);
        } else if(esJugador) {
            model.addAttribute("usuaris", false);
        }else if(esEntrenador){
            model.addAttribute("usuaris", true);
        }else{
            model.addAttribute("usuaris", false);
        }
        
        //Modul ERP
        if (esAmin) {
            // Agregar un atributo al modelo para indicar que se debe mostrar la columna X
            model.addAttribute("erp", true);
        } else if(esJugador) {
            model.addAttribute("erp", false);
        }else if(esEntrenador){
            model.addAttribute("erp", false);
        }else{
            model.addAttribute("erp", false);
        }
        
        
        //log.info("Executant el controlador Spring MVC"); //Afegeix al log el missatge passat com a paràmetre.
        return "inici"; //Retorn de la pàgina iniciEstatic.html.
    }
}
