package com.appservicios.appservicios.services;

import com.appservicios.appservicios.entidades.Proveedor;
import com.appservicios.appservicios.enums.Rol;
import com.appservicios.appservicios.excepciones.Miexcepcion;
import com.appservicios.appservicios.repository.ProveedorRepositorio;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProveedorService extends UsuarioService{

    @Autowired
    ProveedorRepositorio provRepo;

    @Transactional
    public void crearProveedor(String foto, Integer dni, String nombre, String domicilio, String telefono, String email, String password, String password2) throws Miexcepcion {
               
        validar(foto, dni, nombre, domicilio, telefono, email, password, password2);

        Proveedor prov = new Proveedor();
        Date fechaAlta = new Date();

        prov.setFoto(foto);
        prov.setDni(dni);
        prov.setNombre(nombre);
        prov.setDomicilio(domicilio);
        prov.setTelefono(telefono);
        prov.setEmail(email);
        prov.setPassword(password);
        prov.setFecha_alta(fechaAlta);
        prov.setRol(Rol.PROVEEDOR);
        provRepo.save(prov);

    }
    
    

    private void validar(String foto, Integer dni, String nombre, String domicilio, String telefono, String email, String password, String password2) throws Miexcepcion {

        if (foto == null) {
            throw new Miexcepcion("Debe seleccionar una foto");
        }

        if (dni == null) {
            throw new Miexcepcion("El dni no puede ser nulo");
        }

        if (nombre.isEmpty() || nombre == null) {
            throw new Miexcepcion("El nombre no puede ser nulo");
        }

        if (domicilio.isEmpty() || domicilio == null) {
            throw new Miexcepcion("El domicilio no puede ser nulo");
        }

        if (telefono == null) {
            throw new Miexcepcion("El telefono no puede ser nulo");
        }
        if (email.isEmpty() || email == null) {
            throw new Miexcepcion("El email no puede ser nulo");
        }
        if (password.isEmpty() || password == null || password.length() >= 6) {
            throw new Miexcepcion("El password no puede ser nulo, y debe ser mayor a 6 digitos");
        }
        if (!password2.equals(password)) {
            throw new Miexcepcion("El password no coincide");
        }

    }

    public List<Proveedor> listarProveedores() {

        List<Proveedor> proveedores = new ArrayList();

        proveedores = provRepo.findAll();

        return proveedores;
    }

    @Transactional
    public void modificarProveedor(String foto, Integer dni, String nombre, String domicilio, String telefono, String email,int id_proveedor, String password, String password2) throws Miexcepcion {

        validar(foto, dni, nombre, domicilio, telefono, email, password, password2);

        Optional<Proveedor> resp = provRepo.findById(id_proveedor);

        if (resp.isPresent()) {

            Proveedor prov = resp.get();
            prov.setDni(dni);
            prov.setNombre(nombre);
            prov.setDomicilio(domicilio);
            prov.setTelefono(telefono);
            prov.setEmail(email);
            prov.setFecha_alta(new Date());
            prov.setPassword(password);
            prov.setRol(Rol.PROVEEDOR);
            provRepo.save(prov);

        }

    }

    @Transactional
    public void eliminarProveedor(int id_proveedor)  {

        Optional<Proveedor> resp = provRepo.findById(id_proveedor);
        if (resp.isPresent()) {
            Proveedor prov = resp.get();
            provRepo.delete(prov);

        }

    }

}
