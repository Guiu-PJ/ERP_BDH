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
    
    @Autowired //Anotació que injecta tots els mètodes i possibles dependències de GosService al controlador    
    private JugadorsService jugadorsService;
    
    @Autowired //Anotació que injecta tots els mètodes i possibles dependències de GosService al controlador    
    private EquipsService EquipsService;

    @GetMapping("/nuevoJugador")
    public String inici(Jugador jugador, Model model) { //Aquest és el mètode que generarà la resposta (recurs a retornar)
        model.addAttribute("equips", EquipsService.llistarEquips());
        
        return "jugadors/nuevoJugador"; //Retorn de la pàgina iniciEstatic.html.
    }

    @GetMapping("/nuevoJugador/{dni}")
    public String editar(Jugador jugador, Model model) {
        model.addAttribute("equips", EquipsService.llistarEquips());
        
        model.addAttribute("jugador", jugadorsService.cercarJugador(jugador));

        return "jugadors/nuevoJugador"; //Retorna la pàgina amb el formulari de les dades del gos
    }
    
    @PostMapping("/guardarJugador") //action=guardarJugador
    public String guardarJugador(Model model, @Valid Jugador jugador, Errors errors) {
        model.addAttribute("equips", EquipsService.llistarEquips());
        
        if(errors.hasErrors()){ //Si s'han produït errors...
             return "jugadors/nuevoJugador"; //Mostrem la pàgina del formulari
        }
        
        String password = jugador.getContrasenya();
        String  a = EncriptadorContrasenya.encriptarContrasenya(password);
        jugador.setContrasenya(a);

        jugadorsService.afegirJugador(jugador); //Afegim el gos passat per paràmetre a la base de dades

        return "redirect:/iniciJugadors"; //Retornem a la pàgina inicial dels gossos mitjançant redirect
    }
}
