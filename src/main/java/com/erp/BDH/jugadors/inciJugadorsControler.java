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
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
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

    @Autowired // Anotació que injecta tots els mètodes i possibles dependències de JugadorsService al controlador    
    private JugadorsService jugadorsService;

    /**
     * Mètode que gestiona la sol·licitud GET a "/iniciJugadors" i mostra la pàgina d'inici dels jugadors.
     * @param model El model utilitzat per passar dades a la vista.
     * @return La pàgina d'inici dels jugadors.
     */
    @GetMapping("/iniciJugadors")
    public String inici(Model model) {
        // Obtindre l'autenticació de l'usuari actual
        org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        boolean esTipoX = auth.getAuthorities().contains(new SimpleGrantedAuthority("Admin"));
        if (esTipoX) {
            // Afegir un atribut al model per indicar que s'ha de mostrar la columna X
            model.addAttribute("ocultar", true);
        } else {
            model.addAttribute("ocultar", false);
        }

        model.addAttribute("jugadors", jugadorsService.llistarJugadors());

        return "jugadors/iniciJugadors";
    }
    
    /**
     * Mètode que gestiona la sol·licitud GET a "/eliminar/{dni}" i elimina un jugador.
     * @param jugador El jugador a eliminar.
     * @return Redirigeix a la pàgina inicial dels jugadors.
     */
    @GetMapping("/eliminar/{dni}") 
    public String eliminar(Jugador jugador) {

        /* Eliminem el jugador passat per paràmetre, al qual li correspon l'idjugador de @GetMapping mitjançant 
         * el mètode eliminarJugador de la capa de servei. */
        jugadorsService.eliminarJugador(jugador);
        
        return "redirect:/iniciJugadors"; // Redirigeix a la pàgina inicial dels jugadors mitjançant redirect
    }
    
    /**
     * Mètode que gestiona la sol·licitud POST a "/filtrarJugadors" i filtra els jugadors segons els criteris seleccionats.
     * @param categoria La categoria del jugador a filtrar.
     * @param any L'any de naixement del jugador a filtrar.
     * @param model El model utilitzat per passar dades a la vista.
     * @return La pàgina d'inici dels jugadors amb els jugadors filtrats.
     */
    @PostMapping("/filtrarJugadors")
    public String filtrar(@RequestParam("categoria")String categoria,@RequestParam("any") String any, Model model){
        
        List<Jugador> jugadorsFiltrats = llistar(categoria, any, model);
        
        model.addAttribute("categoria", categoria);
        model.addAttribute("any", any);
        model.addAttribute("jugadors", jugadorsFiltrats);
        
        return "jugadors/iniciJugadors";
    }
    
    /**
     * Mètode que filtra els jugadors segons els criteris seleccionats.
     * @param categoria La categoria del jugador a filtrar.
     * @param any L'any de naixement del jugador a filtrar.
     * @param model El model utilitzat per passar dades a la vista.
     * @return La llista de jugadors filtrats.
     */
    public List<Jugador> llistar(String categoria, String any, Model model){
        List<Jugador> jugadorsSenseFiltrar = jugadorsService.llistarJugadors();
        List<Jugador> jugadorsFiltrats;
        org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        boolean esTipoX = auth.getAuthorities().contains(new SimpleGrantedAuthority("Admin"));
        if (esTipoX) {
            // Afegir un atribut al model per indicar que s'ha de mostrar la columna X
            model.addAttribute("ocultar", true);
        } else {
            model.addAttribute("ocultar", false);
        }
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
