package com.appservicios.appservicios.entidades;

// @author Claudia

import com.appservicios.appservicios.enums.Rol;
import java.util.Date;
import javax.persistence.Entity;

@Entity
public class Administrador extends Usuario {

    public Administrador() {
    }

    public Administrador(Integer dni, String nombre, String domicilio, String telefono, String email, String password, Rol rol, Date fecha_alta, Date fecha_baja, Boolean baja) {
        super(dni, nombre, domicilio, telefono, email, password, rol, fecha_alta, fecha_baja, baja);
    }

   

}

