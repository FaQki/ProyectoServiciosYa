package com.appservicios.appservicios.services;

import com.appservicios.appservicios.entidades.Proveedor;
import com.appservicios.appservicios.entidades.Usuario;
import com.appservicios.appservicios.enums.Rol;
import com.appservicios.appservicios.excepciones.Miexcepcion;
import com.appservicios.appservicios.repository.ProveedorRepositorio;
import com.appservicios.appservicios.repository.UsuarioRepositorio;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProveedorService {

    @Autowired
    ProveedorRepositorio provRepo;

    @Autowired
    UsuarioRepositorio userRepo;

    @Transactional
    public void crearProveedor(String foto, Usuario user) throws Miexcepcion {

        validar(foto, user);
        Proveedor prov = new Proveedor();
        prov.setFoto(foto);
        prov.setUser(user);

        provRepo.save(prov);

        user.setRol(Rol.PROVEEDOR);
        userRepo.save(user);

    }

    private void validar(String foto, Usuario user) throws Miexcepcion {

        if (foto == null) {
            throw new Miexcepcion("Debe seleccionar una foto");
        }

        if (user == null) {
            throw new Miexcepcion("El usuario no puede ser nulo");
        }

    }

    public List<Proveedor> listarProveedores() {

        List<Proveedor> proveedores = new ArrayList();

        proveedores = provRepo.findAll();

        return proveedores;
    }
/**
    @Transactional
    public void modificarProveedor(String foto, Usuario user, String domicilio, String telefono, String email, Long id_proveedor, String password, String password2) throws Miexcepcion {

        validar(nombre, domicilio, telefono, email, password, password2);

        Optional<Proveedor> resp = provRepo.findById(id_proveedor);

        if (resp.isPresent()) {

            Proveedor prov = resp.get();
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
**/
    @Transactional
    public void eliminarProveedor(Long id_proveedor) {

        Optional<Proveedor> resp = provRepo.findById(id_proveedor);
        if (resp.isPresent()) {
            Proveedor prov = resp.get();
            provRepo.delete(prov);

        }

    }

}
