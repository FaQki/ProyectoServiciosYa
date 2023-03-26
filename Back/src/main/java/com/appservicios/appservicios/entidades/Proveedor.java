package com.appservicios.appservicios.entidades;


import com.appservicios.appservicios.enums.Rol;
import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Proveedor implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id_proveedor;
    private String foto; //Link de foto de perfil

    @OneToOne
    private Usuario user;

    private char puntaje_calif; //cantidad de estrellas que se califica
    private String resenia_calif; //Comentario del usuario que califica

    public Proveedor() {
    }

    public Proveedor(Long id_proveedor, String foto, Usuario user, char puntaje_calif, String resenia_calif) {
        this.id_proveedor = id_proveedor;
        this.foto = foto;
       
        this.user = user;
        this.puntaje_calif = puntaje_calif;
        this.resenia_calif = resenia_calif;
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
   
    public char getPuntaje_calif() {
        return puntaje_calif;
    }

    public void setPuntaje_calif(char puntaje_calif) {
        this.puntaje_calif = puntaje_calif;
    }

    public String getResenia_calif() {
        return resenia_calif;
    }

    public void setResenia_calif(String resenia_calif) {
        this.resenia_calif = resenia_calif;
    }


    
}
