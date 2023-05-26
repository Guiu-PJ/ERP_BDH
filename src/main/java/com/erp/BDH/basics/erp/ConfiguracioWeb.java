/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erp.BDH.basics.erp;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * @author guiup
 */
@Configuration // Indica que aquesta classe és una classe de configuració
public class ConfiguracioWeb implements WebMvcConfigurer {

    /**
     * En aquest mètode definirem les pàgines que es mostraran a l'usuari quan es produeixi un esdeveniment,
     * sense passar per un controlador.
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registre) {
        // Mostrarem la pàgina inicial, que està reanomenada com a "index", quan encara no ens hem autenticat
        //registre.addViewController("/").setViewName("index");
        
        // Mostrarem la pàgina de login quan l'usuari no ha pogut autenticar-se
        registre.addViewController("/login");
        
        // Mostrarem la pàgina d'error 403 (forbidden) quan l'usuari no té accés a una pàgina determinada
        registre.addViewController("/errors/error403").setViewName("/errors/error403");
    }

}

