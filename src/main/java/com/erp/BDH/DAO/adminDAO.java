/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.erp.BDH.DAO;

import com.erp.BDH.model.Admin;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author guiup
 * extends CrudRepository<Admin,String>
 */

public interface adminDAO extends CrudRepository<Admin, String>{
    
}
