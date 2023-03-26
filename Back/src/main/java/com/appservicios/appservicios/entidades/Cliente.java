package com.appservicios.appservicios.entidades;

import com.appservicios.appservicios.enums.Rol;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;


@Entity
public class Cliente extends Usuario {

    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id_cliente;

    @OneToMany
    private List<Servicio> misServicios; //Listado de servicios del User/Cliente

    public Cliente() {
    }

    public Cliente(Long id_cliente, List<Servicio> misServicios) {
        this.id_cliente = id_cliente;
        this.misServicios = misServicios;
    }

    public Cliente(Long  id_cliente, List<Servicio> misServicios, Long  id_Usuario, String nombre, String domicilio, String telefono, String email, String password, Rol rol, Date fecha_alta, Date fecha_baja, Boolean baja) {
        super(id_Usuario, nombre, domicilio, telefono, email, password, rol, fecha_alta, fecha_baja, baja);
        this.id_cliente = id_cliente;
        this.misServicios = misServicios;
    }

    public Long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Long id_cliente) {
        this.id_cliente = id_cliente;
    }

    public List<Servicio> getMisServicios() {
        return misServicios;
    }

    public void setMisServicios(List<Servicio> misServicios) {
        this.misServicios = misServicios;
    }

}
