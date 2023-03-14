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
@Table(name = "jugadors")
public class Jugador extends Client implements Serializable{
    private String categoria;
    private int numero;
    private double quota;
    private String tutorLegal;

    public Jugador() {
    }

    public Jugador(String categoria, int numero, double quota, String tutorLegal) {
        this.categoria = categoria;
        this.numero = numero;
        this.quota = quota;
        this.tutorLegal = tutorLegal;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getQuota() {
        return quota;
    }

    public void setQuota(double quota) {
        this.quota = quota;
    }

    public String getTutorLegal() {
        return tutorLegal;
    }

    public void setTutorLegal(String tutorLegal) {
        this.tutorLegal = tutorLegal;
    }
    
    
}
