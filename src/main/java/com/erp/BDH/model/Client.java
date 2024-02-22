/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.erp.BDH.model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
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
    @NotEmpty
    private String adreca;
    @Size(min = 4, max = 4)
    @Digits(integer=4, fraction=0)
    private String any_naixement;
    @Size(min = 9, max = 9)
    @Digits(integer=9, fraction=0)
    private String num_contacte;

}
