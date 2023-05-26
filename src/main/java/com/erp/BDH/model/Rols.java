package com.erp.BDH.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

/**
 *
 * @author guiup
 */

@Data
@Entity
@Table
public class Rols implements Serializable{
    
    private static final long serialVersionUID=1L;

    @Id //L'atribut idRol és la clau primària de la BBDD
    private long idrol;
    
    @NotEmpty//Validació perquè l'usuari afegeixi contingut al camp nom
    private String rol;
    
    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "rols_idrol")
    private List<Usuari> usuarios = new ArrayList<>();
}
