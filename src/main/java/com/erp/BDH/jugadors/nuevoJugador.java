/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erp.BDH.jugadors;

import com.erp.BDH.DAO.equipsDAO;
import com.erp.BDH.DAO.jugadorsDAO;
import com.erp.BDH.equips.serveis.EquipsService;
import com.erp.BDH.jugadors.serveis.JugadorsService;
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
 *
 * @author guiup
 */
@Controller
public class nuevoJugador {
    
    @Autowired // Anotació que injecta tots els mètodes i possibles dependències de JugadorsService al controlador    
    private JugadorsService jugadorsService;
    
    @Autowired // Anotació que injecta tots els mètodes i possibles dependències de EquipsService al controlador    
    private EquipsService equipsService;

    /**
     * Mètode que gestiona la sol·licitud GET a "/nuevoJugador" i mostra la pàgina per afegir un nou jugador.
     * @param jugador L'objecte jugador.
     * @param model El model utilitzat per passar dades a la vista.
     * @return La pàgina per afegir un nou jugador.
     */
    @GetMapping("/nuevoJugador")
    public String inici(Jugador jugador, Model model) {
        model.addAttribute("equips", equipsService.llistarEquips());
        
        return "jugadors/nuevoJugador";
    }

    /**
     * Mètode que gestiona la sol·licitud GET a "/nuevoJugador/{dni}" i mostra la pàgina per editar les dades d'un jugador.
     * @param jugador L'objecte jugador.
     * @param model El model utilitzat per passar dades a la vista.
     * @return La pàgina per editar les dades d'un jugador.
     */
    @GetMapping("/nuevoJugador/{dni}")
    public String editar(Jugador jugador, Model model) {
        model.addAttribute("equips", equipsService.llistarEquips());
        
        model.addAttribute("jugador", jugadorsService.cercarJugador(jugador));

        return "jugadors/nuevoJugador";
    }
    
    /**
     * Mètode que gestiona la sol·licitud POST a "/guardarJugador" i guarda les dades d'un jugador.
     * @param model El model utilitzat per passar dades a la vista.
     * @param jugador L'objecte jugador.
     * @param errors Objecte Errors que conté els errors de validació.
     * @return Redirigeix a la pàgina inicial dels jugadors o mostra la pàgina de formulari en cas d'errors.
     */
    @PostMapping("/guardarJugador")
    public String guardarJugador(Model model, @Valid Jugador jugador, Errors errors) {
        model.addAttribute("equips", equipsService.llistarEquips());
        
        if(errors.hasErrors()){ // Si s'han produït errors...
             return "jugadors/nuevoJugador"; // Mostrem la pàgina del formulari
        }
        
        String password = jugador.getContrasenya();
        String  a = EncriptadorContrasenya.encriptarContrasenya(password);
        jugador.setContrasenya(a);

        jugadorsService.afegirJugador(jugador); // Afegim el jugador passat per paràmetre a la base de dades

        return "redirect:/iniciJugadors"; // Redirigeix a la pàgina inicial dels jugadors mitjançant redirect
    }
}

