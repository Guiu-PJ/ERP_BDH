/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.erp.BDH.DAO;

import java.util.List;
import com.erp.BDH.model.Jugador;
//import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author guiup
 * extends CrudRepository<Jugador,Integer>
 */
public interface jugadorsDAO  {
    List<Jugador> findByNom(String nom);
}
