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
    private Cliente clientes; //Muchos servicios para un usuario/cliente
    @OneToOne
    private Proveedor proveedores;  //

    public Servicio() {
    }

    public Servicio(int id_Servicio, String descripcion_Servicio, Date fecha_Inicio_Servicio, Date fecha_fin_Servicio, char tipo_Servicio, Cliente clientes, Proveedor proveedores) {
        this.id_Servicio = id_Servicio;
        this.descripcion_Servicio = descripcion_Servicio;
        this.fecha_Inicio_Servicio = fecha_Inicio_Servicio;
        this.fecha_fin_Servicio = fecha_fin_Servicio;
        this.tipo_Servicio = tipo_Servicio;
        this.clientes = clientes;
        this.proveedores = proveedores;
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

    public Cliente getClientes() {
        return clientes;
    }

    public void setClientes(Cliente clientes) {
        this.clientes = clientes;
    }

    public Proveedor getProveedores() {
        return proveedores;
    }

    public void setProveedores(Proveedor proveedores) {
        this.proveedores = proveedores;
    }
}

