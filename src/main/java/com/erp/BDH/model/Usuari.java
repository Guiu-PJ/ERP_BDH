/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erp.BDH.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.List;
import lombok.Data;


/**
 *
 * @author guiup
 */

@Data
@Entity
@Table(name = "Usuari")
public class Usuari implements Serializable{
    private static final long serialVersionUID = 1L;          
    
    @Id
    @Pattern(regexp = "[0-9]{8}[A-Z]")
    @Column(name="dni")
    private String dni;
    
    @NotEmpty
    private String nom;
    
    @NotEmpty
    private String cognoms;
    
    @NotEmpty
    private String contrasenya;
    
    @ManyToOne //Indica al sistema que la relació entre les taules usuari i rol en aquest cas és d'un a molts.
    @JoinColumn(name="rols_idrol") //Columna de la base de dades que farà de clau forana relacionant les dues taules.
    private Rols rols_idrol;

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
