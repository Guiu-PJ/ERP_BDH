/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
// Paquet i importacions
package com.erp.BDH.DAO;

import com.erp.BDH.model.Entrenador;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 * Interfície que defineix les operacions de persistència per a l'entitat
 * "Entrenador". Utilitza l'interfície "CrudRepository" proporcionada per Spring
 * Data JPA. Proporciona mètodes per interactuar amb la base de dades, com ara
 * inserir, actualitzar, eliminar i cercar entrenadors. Aquesta interfície ens
 * permet establir comunicació amb la capa de persistència.
 */
public interface entrenadorDAO extends CrudRepository<Entrenador, String> {

    /**
     * Mètode que busca entrenadors per DNI. Retorna una llista d'entrenadors
     * amb el DNI especificat.
     *
     * @param dni El DNI a cercar.
     * @return Llista d'entrenadors amb el DNI especificat.
     */
    List<Entrenador> findBydni(String dni);
}
