package com.appservicios.appservicios.entidades;



import com.appservicios.appservicios.enums.Rol;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;

@Entity
public class Cliente extends Usuario{
    
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

    
    

}

