package com.appservicios.appservicios.entidades;



import com.appservicios.appservicios.enums.Rol;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Enumerated;

@Entity
public class Administrador extends Usuario {


    public Administrador() {
    }

    public Administrador(Long  id_Usuario, String nombre, String domicilio, String telefono, String email, String password, Rol rol, Date fecha_alta, Date fecha_baja, Boolean baja) {
        super(id_Usuario, nombre, domicilio, telefono, email, password, rol, fecha_alta, fecha_baja, baja);
    }


}


