/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erp.BDH.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;


/**
 *
 * @author guiup
 */

@Data
@Entity
@Table(name = "usuari")
abstract class Usuari implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    private String dni;
    private String nom;
    private String cognoms;

//    public Usuari(String nomCognoms, String dni) {
//        this.nomCognoms = nomCognoms;
//        this.dni = dni;
//    }
//
//    public Usuari() {
//    }
//
//    public String getNomCognoms() {
//        return nomCognoms;
//    }
//
//    public void setNomCognoms(String nomCognoms) {
//        this.nomCognoms = nomCognoms;
//    }
//
//    public String getDni() {
//        return dni;
//    }
//
//    public void setDni(String dni) {
//        this.dni = dni;
//    }
}
