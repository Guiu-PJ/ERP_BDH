/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erp.BDH.basics.erpUsuaris;

import com.erp.BDH.DAO.perfilDAO;
import com.erp.BDH.jugadors.serveis.JugadorsService;
import com.erp.BDH.model.Entrenador;
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
public class editarPerfilControler {
    @Autowired //Anotació que injecta tots els mètodes i possibles dependències de GosService al controlador    
    private JugadorsService jugadorsService;
    
    @Autowired //Anotació que injecta tots els mètodes i possibles dependències de GosDAO al controlador
    private perfilDAO perfilDAO;
    
    /*A l'anotació @GetMapping li passem per paràmetre l'URL on volem que es retorni la resposta,
    *en el nostre cas, localhost:8080/paginaEstatica (només s'escriu la ruta a partir del domini)
    *
    *Aquesta anotació indica al sistema que el mètode que s'ha fet servir per fer la petició al 
    *servidor és el mètode GET, el qual li demana al servidor quin és el recurs vol que li retorni.
    */
   @GetMapping("/editarPerfil")
    public String inici(Model model){ //Aquest és el mètode que generarà la resposta (recurs a retornar)
        
        model.addAttribute("perfil", perfilDAO.findAll());

        //findByDni és el mètode creat per nosaltres en JugadorsDAO
        var perfil = perfilDAO.findByDni("23434507G");

            
        var usuariNom = perfil.getNom(); 
        var usuariCognom = perfil.getCognoms();
        var usuariAdreca = perfil.getAdreca();
         model.addAttribute("usuariAdreca", usuariAdreca);
        var usuariAnyNaixement = perfil.getAny_naixement();
         model.addAttribute("usuariAnyNaixement", usuariAnyNaixement);
        var usuariDni = perfil.getDni();
         model.addAttribute("usuariDni", usuariDni);
        var usuariNumContacte = perfil.getNum_contacte();
         model.addAttribute("usuariNumContacte", usuariNumContacte);
        var usuariCategoria = perfil.getCategoria();
         model.addAttribute("usuariCategoria", usuariCategoria);
        var usuariNumero = perfil.getNumero();
         model.addAttribute("usuariNumero", usuariNumero);
        var usuariQuota = perfil.getQuota();
         model.addAttribute("usuariQuota", usuariQuota);
        var usuariTutorLegal = perfil.getTutor_legal();
         model.addAttribute("usuariTutorLegal", usuariTutorLegal);

        
        var usuariNomICongnoms = usuariNom + " " + usuariCognom;
        model.addAttribute("usuariNomICongnoms", usuariNomICongnoms);
        
        return "perfil/editarPerfil";
    }
    
    @PostMapping("/guardarPerfil") //action=guardarEquip
    public String guardarPerfil(@Valid Jugador jugador, Errors errors) {

        if(errors.hasErrors()){ //Si s'han produït errors...
             return "perfil/editarPerfil"; //Mostrem la pàgina del formulari
        }
        
        jugadorsService.afegirJugador(jugador); //Afegim el gos passat per paràmetre a la base de dades

        return "redirect:/perfil/perfil"; //Retornem a la pàgina inicial dels gossos mitjançant redirect
    }
    
}
