/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erp.BDH.jugadors;

import com.erp.BDH.jugadors.serveis.JugadorsService;
import com.erp.BDH.model.Jugador;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author guiup
 */
@Controller
@Slf4j
public class inciJugadorsControler {

    @Autowired //Anotació que injecta tots els mètodes i possibles dependències de JugadorsService al controlador    
    private JugadorsService jugadorsService;

    @GetMapping("/iniciJugadors")
    public String inici(Model model) {

        model.addAttribute("jugadors", jugadorsService.llistarJugadors());

        //Aquest és el mètode que generarà la resposta (recurs a retornar)
        //log.info("Executant el controlador Spring MVC"); //Afegeix al log el missatge passat com a paràmetre.
        return "jugadors/iniciJugadors"; //Retorn de la pàgina iniciEstatic.html.
    }
    
    @GetMapping("/eliminar/{dni}") 
    public String eliminar(Jugador jugador) {

        /*Eliminem el gos passat per paràmetre, al qual li correspón l'idgos de @GetMapping mitjançant 
         *el mètode eliminarGos de la capa de servei.*/
        jugadorsService.eliminarJugador(jugador);
        
        return "redirect:/iniciJugadors"; //Retornem a la pàgina inicial dels gossos mitjançant redirect
    }
    
    @PostMapping("/filtrarJugadors")
    public String filtrar(@RequestParam("categoria")String categoria,@RequestParam("any") String any, Model model){
        
        List<Jugador> jugadorsFiltrats = a(categoria, any);
        
        
        model.addAttribute("categoria", categoria);
        model.addAttribute("any", any);
        model.addAttribute("jugadors", jugadorsFiltrats);
        
        return "jugadors/iniciJugadors";
    }
    
    public List<Jugador> a(String categoria, String any){
        List<Jugador> jugadorsSenseFiltrar = jugadorsService.llistarJugadors();
        List<Jugador> jugadorsFiltrats;
        System.out.println(categoria);
        System.out.println(any);
        if("".equals(categoria) && !"".equals(any)){
            jugadorsFiltrats = jugadorsSenseFiltrar.stream()
                    .filter(jugador -> jugador.getAny_naixement().equals(any))
                    .collect(Collectors.toList());
            return jugadorsFiltrats;
        }else if(!"".equals(categoria) && "".equals(any)){
            jugadorsFiltrats = jugadorsSenseFiltrar.stream()
                    .filter(jugador -> jugador.getCategoria().equals(categoria))
                    .collect(Collectors.toList());
            return jugadorsFiltrats;
        }else if(!"".equals(categoria) && !"".equals(any)){
            jugadorsFiltrats = jugadorsSenseFiltrar.stream()
                    .filter(jugador -> jugador.getCategoria().equals(categoria))
                    .collect(Collectors.toList());
             jugadorsFiltrats = jugadorsFiltrats.stream()
                    .filter(jugador -> jugador.getAny_naixement().equals(any))
                    .collect(Collectors.toList());
             return jugadorsFiltrats;
        }else{
            jugadorsFiltrats = jugadorsSenseFiltrar;
            return jugadorsFiltrats;
        }
    }
}
