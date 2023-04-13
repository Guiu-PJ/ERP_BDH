/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erp.BDH.basics.erpUsuaris;

import com.erp.BDH.DAO.entrenadorDAO;
import com.erp.BDH.DAO.perfilDAO;
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
public class perfilControler {

    @Autowired //Anotació que injecta tots els mètodes i possibles dependències de GosDAO al controlador
    private perfilDAO perfilDAO;

    @GetMapping("/perfil")
    public String inici(Model model) { //Aquest és el mètode que generarà la resposta (recurs a retornar)
        //log.info("Executant el controlador Spring MVC"); //Afegeix al log el missatge passat com a paràmetre.
        //findAll retorna el llistat d'objectes gos guardats en la taula gos de la BBDD    
        model.addAttribute("perfil", perfilDAO.findAll());

        //findByNom és el mètode creat per nosaltres en JugadorsDAO
        var perfil = perfilDAO.findByDni("23434567G");

        //Com sé que la consulta anterior només hem retornarà un gos, fem:        
        var usuariNom = perfil.get(0).getNom(); //En la posició 0 del llistat de la resposta de la consulta, trobem el gos
        var usuariCognom = perfil.get(0).getCognoms();
        var usuariAdreca = perfil.get(0).getAdreca();
         model.addAttribute("usuariAdreca", usuariAdreca);
        var usuariAnyNaixement = perfil.get(0).getAny_naixement();
         model.addAttribute("usuariAnyNaixement", usuariAnyNaixement);
        var usuariDni = perfil.get(0).getDni();
         model.addAttribute("usuariDni", usuariDni);
        var usuariNumContacte = perfil.get(0).getNum_contacte();
         model.addAttribute("usuariNumContacte", usuariNumContacte);
        var usuariCategoria = perfil.get(0).getCategoria();
         model.addAttribute("usuariCategoria", usuariCategoria);
        var usuariNumero = perfil.get(0).getNumero();
         model.addAttribute("usuariNumero", usuariNumero);
        var usuariQuota = perfil.get(0).getQuota();
         model.addAttribute("usuariQuota", usuariQuota);
        var usuariTutorLegal = perfil.get(0).getTutor_legal();
         model.addAttribute("usuariTutorLegal", usuariTutorLegal);

        
        var usuariNomICongnoms = usuariNom + " " + usuariCognom;
        model.addAttribute("usuariNomICongnoms", usuariNomICongnoms);

        return "perfil/perfil"; //Retorn de la pàgina iniciEstatic.html.
    }
}
