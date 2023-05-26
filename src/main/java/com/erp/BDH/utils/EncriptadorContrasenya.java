package com.erp.BDH.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author guiup
 */

/*
 * Esta es una clase Java llamada EncriptadorContrasenya que proporciona un método estático para encriptar contraseñas.
 * El método encriptarContrasenya toma una cadena como entrada y devuelve la cadena encriptada utilizando el algoritmo de encriptación BCryptPasswordEncoder de la biblioteca Spring Security.
 */
public class EncriptadorContrasenya {
    
    public static String encriptarContrasenya(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }
}
