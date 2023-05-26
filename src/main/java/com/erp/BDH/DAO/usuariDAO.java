/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
 
// Paquet i importacions
package com.erp.BDH.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import com.erp.BDH.model.Usuari;

/**
 * Interfície que defineix les operacions de persistència per a l'entitat "Usuari".
 * Utilitza l'interfície "JpaRepository" proporcionada per Spring Data JPA.
 * Proporciona mètodes per interactuar amb la base de dades, com ara inserir, actualitzar, eliminar i cercar usuaris.
 * Aquesta interfície ens permet establir comunicació amb la capa de persistència.
 */
public interface usuariDAO extends JpaRepository<Usuari, Long> {
    /**
     * Mètode que cerca un usuari pel DNI.
     * Retorna l'usuari amb el DNI especificat.
     * @param dni El DNI a cercar.
     * @return L'usuari amb el DNI especificat.
     */
    Usuari findByDni(String dni);
}
