/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erp.BDH.basics.erp;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author guiup
 */

@Controller
public class LogoutController {

    /**
     * Controlador per gestionar la funcionalitat de tancament de sessió (logout).
     * Quan es fa una petició GET a "/logout", es realitza el tancament de sessió de l'usuari
     * i es redirigeix a la pàgina d'inici de sessió.
     */
    @GetMapping("/logout")
    public String logout(HttpServletRequest request) throws ServletException {
        request.logout();
        return "redirect:/login";
    }
}