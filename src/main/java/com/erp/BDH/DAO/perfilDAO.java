/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
 
// Paquet i importacions
package com.erp.BDH.DAO;

import com.erp.BDH.model.Admin;
import com.erp.BDH.model.Entrenador;
import com.erp.BDH.model.Jugador;
import com.erp.BDH.model.Usuari;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 * Interfície que defineix les operacions de persistència per als perfils d'usuari (Jugador, Entrenador, Admin, Usuari).
 * Utilitza l'interfície "CrudRepository" proporcionada per Spring Data JPA.
 * Proporciona mètodes per interactuar amb la base de dades, com ara inserir, actualitzar, eliminar i cercar perfils d'usuari.
 * Aquesta interfície ens permet establir comunicació amb la capa de persistència.
 */
public interface perfilDAO extends CrudRepository<Jugador, String> {
    /**
     * Mètode que cerca un jugador pel DNI.
     * Retorna el jugador amb el DNI especificat.
     * @param dni El DNI a cercar.
     * @return El jugador amb el DNI especificat.
     */
    Jugador findByDni(String dni);
}
