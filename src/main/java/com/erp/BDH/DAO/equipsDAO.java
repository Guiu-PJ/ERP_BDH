/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
// Paquet i importacions
package com.erp.BDH.DAO;

import com.erp.BDH.model.Equip;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 * Interfície que defineix les operacions de persistència per a l'entitat
 * "Equip". Utilitza l'interfície "CrudRepository" proporcionada per Spring Data
 * JPA. Proporciona mètodes per interactuar amb la base de dades, com ara
 * inserir, actualitzar, eliminar i cercar equips. Aquesta interfície ens permet
 * establir comunicació amb la capa de persistència.
 */
public interface equipsDAO extends CrudRepository<Equip, String> {

    /**
     * Mètode que cerca equips per categoria. Retorna una llista d'equips amb la
     * categoria especificada.
     *
     * @param categoria La categoria a cercar.
     * @return Llista d'equips amb la categoria especificada.
     */
    List<Equip> findBycategoria(String categoria);
}
