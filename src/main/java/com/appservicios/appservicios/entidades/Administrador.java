package com.appservicios.appservicios.entidades;
/**
// @author Claudia

import com.appservicios.appservicios.enums.Rol;
import java.util.Date;
import javax.persistence.Entity;

@Entity
public class Administrador extends Usuario {

    public Administrador() {
    }

    public Administrador(int id_Usuario, String nombre_Usuario, String barrio, String domicilio, String telefono, String email, String password, Rol rol, Date fecha_alta, Date fecha_baja, Boolean baja) {
        super(id_Usuario, nombre_Usuario, barrio, domicilio, telefono, email, password, rol, fecha_alta, fecha_baja, baja);
    }

}
**/