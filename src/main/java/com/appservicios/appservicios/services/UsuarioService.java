/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appservicios.appservicios.services;

import com.appservicios.appservicios.entidades.Usuario;
import com.appservicios.appservicios.excepciones.Miexcepcion;
import com.appservicios.appservicios.repository.UsuarioRepositorio;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

/**
 *
 * @author facua
 */
@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepositorio userRepo;
    
    @Transactional
    public void crearUsuario(Integer dni, String nombre_Usuario, String domicilio, String telefono, String email, String password) throws Miexcepcion {
        
        validar(dni, nombre_Usuario, domicilio, telefono, email);
        
        Usuario user = new Usuario();
        
        user.setdni(dni);
        user.setPassword(password);
        user.setNombre_Usuario(nombre_Usuario);
        user.setDomicilio(domicilio);
        user.setTelefono(telefono);
        user.setEmail(email);
        user.setFecha_alta(new Date());
        userRepo.save(user);
        
    }
    
    public List<Usuario> listarUsuarios() {
        
        List<Usuario> usuarios = new ArrayList();
        
        usuarios = userRepo.findAll();
        
        return usuarios;
        
    }
    
    public void modificarUsuario(Integer dni, String nombre_Usuario, String domicilio, String telefono, String email, String barrio) throws Miexcepcion {
        
        validar(dni, nombre_Usuario, domicilio, telefono, email);
        
        Optional<Usuario> resp = userRepo.findById(dni);
        
        if (resp.isPresent()) {
            
            Usuario user = resp.get();
            user.setdni(dni);
            user.setNombre_Usuario(nombre_Usuario);
            user.setDomicilio(domicilio);
            user.setTelefono(telefono);
            user.setEmail(email);
            user.setFecha_alta(new Date());
            
        }
        
    }
    
    private void validar(Integer dni, String nombre_Usuario, String domicilio, String telefono, String email) throws Miexcepcion {
        
        if (dni == null) {
            throw new Miexcepcion("El dni no puede ser nulo");
        }
        
        if (nombre_Usuario.isEmpty() || nombre_Usuario == null) {
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
        
    }
    
}
