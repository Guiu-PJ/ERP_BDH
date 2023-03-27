/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erp.BDH.model;

import jakarta.persistence.Entity;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author guiup
 */
@Data
@Entity
abstract class Client extends Usuari implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String adreca;
    private int anyNaixement;
    private int numContacte;

}
