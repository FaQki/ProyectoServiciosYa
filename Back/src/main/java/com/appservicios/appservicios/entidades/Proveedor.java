package com.appservicios.appservicios.entidades;


import com.appservicios.appservicios.enums.Rol;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Proveedor extends Usuario{
    
    private String foto; //Link de foto de perfil
    @OneToOne
    private Servicio servicio;
    

    public Proveedor() {
    }

    public Proveedor(String foto) {
        this.foto = foto;
    }

    public Proveedor(String foto, Integer dni, String nombre, String domicilio, String telefono, String email, String password, Rol rol, Date fecha_alta, Date fecha_baja, Boolean baja) {
        super(dni, nombre, domicilio, telefono, email, password, rol, fecha_alta, fecha_baja, baja);
        this.foto = foto;
    }
    
    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
    
    
    
    

  

}

