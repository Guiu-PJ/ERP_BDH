/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.erp.BDH.DAO;

import com.erp.BDH.model.Jugador;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 * @author guiup
 * extends CrudRepository<Jugador,String>
 */
public interface perfilDAO extends CrudRepository<Jugador, String>{
    List<Jugador> findByDni(String dni);
}
