package com.appservicios.appservicios.entidades;

// @author Claudia
/**
import com.appservicios.appservicios.enums.Rol;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;

@Entity
public class Proveedor extends Usuario{
    private Rubro id_Rubro; //Rubro en el que se desempeña
    private String foto; //Link de foto de perfil
    

    public Proveedor() {
    }

    public Proveedor(Rubro id_Rubro, String portfolio, String foto, int id, String nombre_Usuario, String barrio, String domicilio, String telefono, String email, String password, Rol rol, Date fecha_alta, Date fecha_baja, Boolean baja) {
        super(id, nombre_Usuario, barrio, domicilio, telefono, email, password, rol, fecha_alta, fecha_baja, baja);
        this.id_Rubro = id_Rubro;
        this.portfolio = portfolio;
        this.foto = foto;
    }

    public Rubro getId_Rubro() {
        return id_Rubro;
    }

    public void setId_Rubro(Rubro id_Rubro) {
        this.id_Rubro = id_Rubro;
    }

    public String getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(String portfolio) {
        this.portfolio = portfolio;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

}
**/
