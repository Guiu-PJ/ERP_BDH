/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.erp.BDH.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import com.erp.BDH.model.Usuari;
/**
 *
 * @author guiup
 */
public interface usuariDAO extends JpaRepository<Usuari,Long> {
    Usuari findByDni(String dni);
}
