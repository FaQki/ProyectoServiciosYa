package com.appservicios.appservicios.entidades;

// @author Claudia
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Rubro {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id_Rubro; //Clave de identificación del rubro
    private String nombre_Rubro; //Nombre identificatorio: gasista, electricista, etc. 
    private String descripcion_Rubro; //Que abarca 

    public Rubro() {
    }

    public Rubro(String id_Rubro, String nombre_Rubro, String descripcion_Rubro) {
        this.id_Rubro = id_Rubro;
        this.nombre_Rubro = nombre_Rubro;
        this.descripcion_Rubro = descripcion_Rubro;
    }

    public String getId_Rubro() {
        return id_Rubro;
    }

    public void setId_Rubro(String id_Rubro) {
        this.id_Rubro = id_Rubro;
    }

    public String getNombre_Rubro() {
        return nombre_Rubro;
    }

    public void setNombre_Rubro(String nombre_Rubro) {
        this.nombre_Rubro = nombre_Rubro;
    }

    public String getDescripcion_Rubro() {
        return descripcion_Rubro;
    }

    public void setDescripcion_Rubro(String descripcion_Rubro) {
        this.descripcion_Rubro = descripcion_Rubro;
    }
    
}
