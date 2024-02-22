/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
 
// Paquet i importacions
package com.erp.BDH.DAO;

import java.util.List;
import com.erp.BDH.model.Jugador;
import org.springframework.data.repository.CrudRepository;

/**
 * Interfície que defineix les operacions de persistència per a l'entitat "Jugador".
 * Utilitza l'interfície "CrudRepository" proporcionada per Spring Data JPA.
 * Proporciona mètodes per interactuar amb la base de dades, com ara inserir, actualitzar, eliminar i cercar jugadors.
 * Aquesta interfície ens permet establir comunicació amb la capa de persistència.
 */
public interface jugadorsDAO extends CrudRepository<Jugador, String> {
    /**
     * Mètode que busca jugadors per DNI.
     * Retorna una llista de jugadors amb el DNI especificat.
     * @param dni El DNI a cercar.
     * @return Llista de jugadors amb el DNI especificat.
     */
    List<Jugador> findBydni(String dni);
}
