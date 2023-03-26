/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appservicios.appservicios.entidades;

import javax.persistence.*;
import java.io.Serializable;


@Entity
public class Resenia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_resenia;

    @ManyToOne
    private Proveedor id_prov;
    
    private int estrellas;
    private String descrip;

    public Resenia() {
    }

    public Resenia(Long id_resenia, Proveedor id_prov, int estrellas, String descrip) {
        this.id_resenia = id_resenia;
        this.id_prov = id_prov;
        this.estrellas = estrellas;
        this.descrip = descrip;
    }

    public Long getId_resenia() {
        return id_resenia;
    }

    public void setId_resenia(Long id_resenia) {
        this.id_resenia = id_resenia;
    }

    public Proveedor getId_prov() {
        return id_prov;
    }

    public void setId_prov(Proveedor id_prov) {
        this.id_prov = id_prov;
    }

    public int getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(int estrellas) {
        this.estrellas = estrellas;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }
}
