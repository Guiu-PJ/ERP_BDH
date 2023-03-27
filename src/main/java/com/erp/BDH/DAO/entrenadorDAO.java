/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.erp.BDH.DAO;

import com.erp.BDH.model.Entrenador;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author guiup
 * extends CrudRepository<Entrenador,String>
 */
public interface entrenadorDAO extends CrudRepository<Entrenador, String>{
    
}
