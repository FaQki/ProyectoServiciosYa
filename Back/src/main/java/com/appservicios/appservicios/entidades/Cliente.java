package com.appservicios.appservicios.entidades;



import com.appservicios.appservicios.enums.Rol;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cliente extends Usuario{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_cliente;
    private List<Servicio> misServicios; //Listado de servicios del User/Cliente


    public Cliente() {
    }

    public Cliente(Integer dni, String nombre, String domicilio, String telefono, String email, String password, Rol rol, Date fecha_alta, Date fecha_baja, Boolean baja) {
        super(dni, nombre, domicilio, telefono, email, password, rol, fecha_alta, fecha_baja, baja);
    }

    public Cliente(List<Servicio> misServicios, Integer dni, String nombre, String domicilio, String telefono, String email, String password, Rol rol, Date fecha_alta, Date fecha_baja, Boolean baja) {
        super(dni, nombre, domicilio, telefono, email, password, rol, fecha_alta, fecha_baja, baja);
        this.misServicios = misServicios;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public List<Servicio> getMisServicios() {
        return misServicios;
    }

    public void setMisServicios(List<Servicio> misServicios) {
        this.misServicios = misServicios;
    }
}

