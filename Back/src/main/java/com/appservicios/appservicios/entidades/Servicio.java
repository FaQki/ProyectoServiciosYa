package com.appservicios.appservicios.entidades;

import java.util.Date;
import javax.persistence.*;

@Entity 
public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Servicio;  //Clave de identificación del servicio
    
   
    private String descripcion_Servicio; //Descripción del pedido del usuario
    
    @Temporal(TemporalType.DATE)
    private Date fecha_Inicio_Servicio; //Fecha de comienzo del trabajo
    @Temporal(TemporalType.DATE)
    private Date fecha_fin_Servicio;  //Fecha de finalización del trabajo
    
    private char tipo_Servicio; //0-aceptado, 1-finalizado, 3-cancelado

    @ManyToOne
    private Cliente dni; //Muchos servicios para un usuario/cliente
    @OneToOne
    private Proveedor dni;  //
    
    private char puntaje_calif; //cantidad de estrellas que se califica
    private String resenia_calif; //Comentario del usuario que califica

    public Servicio() {
    }

    public Servicio(int id_Servicio, String descripcion_Servicio, Date fecha_Inicio_Servicio, Date fecha_fin_Servicio, char tipo_Servicio, Cliente id_Cliente, Proveedor id_Prov, char puntaje_calif, String resenia_calif) {
        this.id_Servicio = id_Servicio;
        this.descripcion_Servicio = descripcion_Servicio;
        this.fecha_Inicio_Servicio = fecha_Inicio_Servicio;
        this.fecha_fin_Servicio = fecha_fin_Servicio;
        this.tipo_Servicio = tipo_Servicio;
        this.id_Cliente = id_Cliente;
        this.id_Prov = id_Prov;
        this.puntaje_calif = puntaje_calif;
        this.resenia_calif = resenia_calif;
    }

    public int getId_Servicio() {
        return id_Servicio;
    }

    public void setId_Servicio(int id_Servicio) {
        this.id_Servicio = id_Servicio;
    }

    public String getDescripcion_Servicio() {
        return descripcion_Servicio;
    }

    public void setDescripcion_Servicio(String descripcion_Servicio) {
        this.descripcion_Servicio = descripcion_Servicio;
    }

    public Date getFecha_Inicio_Servicio() {
        return fecha_Inicio_Servicio;
    }

    public void setFecha_Inicio_Servicio(Date fecha_Inicio_Servicio) {
        this.fecha_Inicio_Servicio = fecha_Inicio_Servicio;
    }

    public Date getFecha_fin_Servicio() {
        return fecha_fin_Servicio;
    }

    public void setFecha_fin_Servicio(Date fecha_fin_Servicio) {
        this.fecha_fin_Servicio = fecha_fin_Servicio;
    }

    public char getTipo_Servicio() {
        return tipo_Servicio;
    }

    public void setTipo_Servicio(char tipo_Servicio) {
        this.tipo_Servicio = tipo_Servicio;
    }

    public Cliente getId_Cliente() {
        return id_Cliente;
    }

    public void setId_Cliente(Cliente id_Cliente) {
        this.id_Cliente = id_Cliente;
    }

    public Proveedor getId_Prov() {
        return id_Prov;
    }

    public void setId_Prov(Proveedor id_Prov) {
        this.id_Prov = id_Prov;
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

