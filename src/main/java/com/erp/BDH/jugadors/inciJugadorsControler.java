/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erp.BDH.jugadors;

import com.erp.BDH.DAO.jugadorsDAO;
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
public class inciJugadorsControler {

    @Autowired //Anotació que injecta tots els mètodes i possibles dependències de GosDAO al controlador
    private jugadorsDAO jugadorsDAO; //Atribut per poder utilitzar les funcions CRUD de la interfície GosDAO

    @GetMapping("/iniciJugadors")
    public String inici(Model model) {

        model.addAttribute("jugadors", jugadorsDAO.findAll());

        //Aquest és el mètode que generarà la resposta (recurs a retornar)
        //log.info("Executant el controlador Spring MVC"); //Afegeix al log el missatge passat com a paràmetre.
        return "jugadors/iniciJugadors"; //Retorn de la pàgina iniciEstatic.html.
    }
}
