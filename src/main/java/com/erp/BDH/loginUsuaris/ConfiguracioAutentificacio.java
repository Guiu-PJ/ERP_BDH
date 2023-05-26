/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erp.BDH.loginUsuaris;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 *
 * @author guiup
 */

/*Classe de configuració de Spring Security per configurar l'accés d'usuaris (autenticació).
 *Aquesta classe ha d'extendre de la classe WebSecurityConfigurerAdapter de Spring Security per poder
 *autenticar els usuaaris.
 */
@Configuration //Indica al sistema que és una classe de configuració
@EnableWebSecurity //Habilita la seguretat web
@Slf4j
public class ConfiguracioAutentificacio {
    @Autowired
    private UserDetailsService userDetailsService; //Objecte per recuperar l'usuari

    /*AUTENTICACIÓ*/
    /*Injectem mitjançant @Autowired, els mètodes de la classe AuthenticationManagerBuilder. Mitjançant
     *aquesta classe cridarem al mètode userDetailsService de la classe AuthenticationManagerBuilder què és el mètode que
     *realitzarà l'autenticació. Per parm̀etre el sistema li passa l'usuari introduit en el formulari d'autenticació.
     *Aquest usuari ens el retorna el mètode loadUserByUsername implementat en UsuariService.
     *
     *Cridem al mètode passwordEncoder passant-li com a paràmetre un objecte de tipus BCryptPasswordEncoder()
     *per encriptar el password introduït per l'usuari en el moment d'autenticar-se i comparar-lo
     *amb l'encriptació del password guardat a la BBDD corresponent a l'username introduït també en l'autenticació.
     */
    @Autowired
    public void autenticacio(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }
    
    /*AUTORITZACIÓ*/
    /*Utilitzem el mètode filterChain per configurar l'accés dels nostre usuaris a l'aplicació, segons
     *els seus rols, el que s'anomena autoritzar.
     *Passem com a paràmetre un objecte de la classe HttpSecurity de Spring Security que
     *és el que ens permetrà cridar als mètodes per configurar les restriccions d'accés a la nostra aplicació.
    */

   
    @Bean //L'indica al sistema que el mètode és un Bean, en aquest cas perquè crea un objecte de la classe HttpSecurity
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

                return http.csrf().disable().authorizeHttpRequests((requests) -> requests
                .requestMatchers("/css/**").permitAll()
                .requestMatchers("/imatges/**").permitAll()
                .requestMatchers("/inici").authenticated()
                .requestMatchers("/perfil").hasAnyAuthority("Jugador")
                .requestMatchers("/iniciJugadors","/guardarJugador").hasAnyAuthority("Entrenador","Jugador","Admin")
                .requestMatchers("/iniciEquips").hasAnyAuthority("Entrenador","Jugador","Admin")
                .requestMatchers("/iniciErpUsuaris").hasAnyAuthority("Entrenador","Admin")
                .requestMatchers("/iniciErp").hasAnyAuthority("Admin")
                .requestMatchers("/nuevoJugador","/guardarJugador","/nuevoJugador/{dni}","/eliminar/{dni}").hasAnyAuthority("Admin")
                .requestMatchers("/nuevoEquipo","/equips/{categoria}","/guardarEquips","/equips/eliminar/{categoria}").hasAnyAuthority("Admin")
                .requestMatchers("/nuevoEntrenador","/entrenadors/{dni}","/guardarEntrenador","/entrenadors/eliminar/{dni}").hasAnyAuthority("Admin")
                .anyRequest().authenticated())
                .formLogin((form) -> form //Objecte que representa el formulari de login personalitzat que utilitzarem
                .loginPage("/login")
                .defaultSuccessUrl("/inici",true)  //Pàgina on es troba el formulari per fer login personalitzat
                .permitAll() //Permet acceddir a tothom
                )
                .exceptionHandling((exception) -> exception //Quan es produeix una excepcció 403, accés denegat, mostrem el nostre missatge
                .accessDeniedPage("/errors/error403"))
                .build();

    }
    
    
}
