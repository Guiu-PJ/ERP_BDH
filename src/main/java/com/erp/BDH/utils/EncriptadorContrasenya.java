package com.erp.BDH.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author guiup
 
 * Aquesta és una classe Java anomenada EncriptadorContrasenya que proporciona un mètode estàtic per encriptar contrasenyes.
 * El mètode encriptarContrasenya rep una cadena com a entrada i retorna la cadena encriptada utilitzant l'algoritme d'encriptació BCryptPasswordEncoder de la biblioteca Spring Security.
 */
public class EncriptadorContrasenya {
    
    public static String encriptarContrasenya(String contrasenya) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(contrasenya);
    }
}