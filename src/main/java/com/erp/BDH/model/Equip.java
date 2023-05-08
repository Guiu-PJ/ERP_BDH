/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erp.BDH.model;

import jakarta.persistence.Entity;
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
@Table(name = "equips")
public class Equip implements Serializable {
    
    //Identificació de la classe per poder deserialitzar de manera correcta
    private static final long serialVersionUID = 1L;
    
    @Id //Indica al sistema que l'atribut idgos és la clau primària de la BBDD
    private String categoria;
    
    private String entrenador;

//    public Equip() {
//    }
//
//    public Equip(String categoria) {
//        this.categoria = categoria;
//    }
//
//    public String getCategoria() {
//        return categoria;
//    }
//
//    public void setCategoria(String categoria) {
//        this.categoria = categoria;
//    }
    
}
