package com.appservicios.appservicios.entidades;


import com.appservicios.appservicios.enums.Rol;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
public class Proveedor extends Usuario{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_proveedor;
    private String foto; //Link de foto de perfil
    @OneToOne
    private Servicio servicio;

    private char puntaje_calif; //cantidad de estrellas que se califica
    private String resenia_calif; //Comentario del usuario que califica


    public Proveedor() {
    }
    public Proveedor(Integer dni, String nombre, String domicilio, String telefono, String email, String password, Rol rol, Date fecha_alta, Date fecha_baja, Boolean baja, int id_proveedor, String foto, Servicio servicio, char puntaje_calif, String resenia_calif) {
        super(dni, nombre, domicilio, telefono, email, password, rol, fecha_alta, fecha_baja, baja);
        this.id_proveedor = id_proveedor;
        this.foto = foto;
        this.servicio = servicio;
        this.puntaje_calif = puntaje_calif;
        this.resenia_calif = resenia_calif;
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

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
}

