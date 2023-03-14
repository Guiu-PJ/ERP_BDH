/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erp.BDH.jugadors;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author guiup
 */
@Controller
public class inciJugadorsControler {
    
    /*A l'anotació @GetMapping li passem per paràmetre l'URL on volem que es retorni la resposta,
    *en el nostre cas, localhost:8080/paginaEstatica (només s'escriu la ruta a partir del domini)
    *
    *Aquesta anotació indica al sistema que el mètode que s'ha fet servir per fer la petició al 
    *servidor és el mètode GET, el qual li demana al servidor quin és el recurs vol que li retorni.
    */
   @GetMapping("/iniciJugadors")
    public String inici(){ //Aquest és el mètode que generarà la resposta (recurs a retornar)
        //log.info("Executant el controlador Spring MVC"); //Afegeix al log el missatge passat com a paràmetre.
        return "jugadors/iniciJugadors"; //Retorn de la pàgina iniciEstatic.html.
    }
}
