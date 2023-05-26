/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erp.BDH.basics.erp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author guiup
 */
@Controller
public class iniciErpControler {
    /**
     * Controlador per a la pàgina d'inici del mòdul ERP.
     * Retorna la vista "erp/iniciErp".
     */
    @GetMapping("/iniciErp")
    public String inici() {
        return "erp/iniciErp";
    }
}
