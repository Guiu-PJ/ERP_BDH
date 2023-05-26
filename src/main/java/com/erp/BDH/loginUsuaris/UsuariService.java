/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erp.BDH.loginUsuaris;

import com.erp.BDH.DAO.usuariDAO;
import com.erp.BDH.model.Rols;
import com.erp.BDH.model.Usuari;
import static com.erp.BDH.utils.EncriptadorContrasenya.encriptarContrasenya;
import java.util.ArrayList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author guiup
 */

@Service ("userDetailsService")
@Slf4j
public class UsuariService implements UserDetailsService{

    /*Atribut que defineix un UsuariDAO, injectant els seu mètodes a aquesta classe (@Autowired),
     *els quals ens permeten interactuar amb les taules de la BBDD pels usuaris i rols
    */
    @Autowired
    private usuariDAO usuariDAO; 
    
    /*Únic mètode de la interface UserDetailsService que retornarà un usuari a partir del nom d'usuari.
     *L'usuari que retorna es de tipus UserDetails que és una interface de Spring Security que defineix
     *els mètodes necessaris per treballar amb un usuari.
    */
    @Override
    @Transactional(readOnly=true) //Consulta només de lectura
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        /*Implementem el mètode definit en UsuariDao. Hem de pensar que aquest és un mètode predefinit
         *de Spring Security i, per tant, no hem de desnvolupar cap codi, ja ve donat per Spring Security.
         *Aquest mètode ens retornarà l'usuari a partir de nom d'usuari passat per paràmetre.
        */
        Usuari usuari= usuariDAO.findByDni(username);
        
        /*Si l'usuari existeix, recuperarem els rols associats a aquest usuari.
         *Els rols els guardarem dins un ArrayList de tipus genèric GrantedAuthority,
         *tipus genèric de Spring Security necessari perque Spring Security pugui
         *treballar amb els rols.
         *GrantedAuthority, és una interface.
        */
        var rols= new ArrayList<GrantedAuthority>();

        /*Fem un recorregut pels rols de l'usuari actual guardats en l'atribut rols de la classe Usuari
         *per guardar-los com objectes de tipus GrantedAuthority en la variable rols.
         *Per convertir un rol en un objecte de tipus GrantedAuthority, instanciem un objecte de la 
         *classe SimpleGrantedAuthority la qual implementa GrantedAuthority, passant-li com a paràmetre 
         *el nom del rol.
        */
//        for(Rols rol: usuari.getRols()){
//            rols.add(new SimpleGrantedAuthority(rol.getRol()));
//        }
        rols.add(new SimpleGrantedAuthority(usuari.getRols_idrol().getRol()));

        /*Retornme el nou usuari de tipus UserDetails mitjançant la classe User d'Spring Security,
         *la qual implementa la interface UserDetails.
         *Com a paràmetres passem el nom d'usuari, la contrasenya i els rols del l'usuari alqual
         *li correspon el nom d'usuari passat com a paràmetre.
        */
        return new User(usuari.getDni(), usuari.getContrasenya(), rols);
        
    }
    
}
