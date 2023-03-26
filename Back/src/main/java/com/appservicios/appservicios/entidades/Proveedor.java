package com.appservicios.appservicios.entidades;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Proveedor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_proveedor;
    private String foto; //Link de foto de perfil

    @OneToOne
    private Usuario user;

    public Proveedor() {
    }

    public Proveedor(Long id_proveedor, String foto, Usuario user) {
        this.id_proveedor = id_proveedor;
        this.foto = foto;
        this.user = user;

    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public Long getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(Long id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

}
