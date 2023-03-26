package com.appservicios.appservicios.entidades;

import java.util.List;
import javax.persistence.*;


@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id_cliente;

    @OneToOne
    private Usuario user;//Un cliente sera un usuario


    @OneToMany
    private List<Servicio> misServicios; //Listado de servicios del User/Cliente

    public Cliente() {
    }

    public Cliente(Long id_cliente, Usuario user, List<Servicio> misServicios) {
        this.id_cliente = id_cliente;
        this.user = user;
        this.misServicios = misServicios;
    }

    public Long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Long id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public List<Servicio> getMisServicios() {
        return misServicios;
    }

    public void setMisServicios(List<Servicio> misServicios) {
        this.misServicios = misServicios;
    }
}
