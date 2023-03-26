/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appservicios.appservicios.services;

import com.appservicios.appservicios.entidades.Usuario;
import com.appservicios.appservicios.enums.Rol;
import com.appservicios.appservicios.excepciones.Miexcepcion;
import com.appservicios.appservicios.repository.UsuarioRepositorio;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author facua
 */
@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepositorio userRepo;

    @Transactional
    public void crearUsuario(String nombre, String domicilio, String telefono, String email, String password, String password2) throws Miexcepcion {

        validar(nombre, domicilio, telefono, email, password, password2);

        Usuario user = new Usuario();

        user.setPassword(password);
        user.setNombre(nombre);
        user.setDomicilio(domicilio);
        user.setTelefono(telefono);
        user.setEmail(email);
        user.setFecha_alta(new Date());
        user.setRol(Rol.USER);
        userRepo.save(user);


    }

    public List<Usuario> listarUsuarios() {

        List<Usuario> usuarios = new ArrayList();

        usuarios = userRepo.findAll();

        return usuarios;

    }

    public void modificarUsuario(Long id_Usuario, String nombre, String domicilio, String telefono, String email, String password, String password2) throws Miexcepcion {

        validar(nombre, domicilio, telefono, email, password, password2);

        Optional<Usuario> resp = userRepo.findById(id_Usuario);

        if (resp.isPresent()) {

            Usuario user = resp.get();
            
            user.setNombre(nombre);
            user.setDomicilio(domicilio);
            user.setTelefono(telefono);
            user.setEmail(email);
            user.setFecha_alta(new Date());
            

        }

    }
    
    public void eliminarProveedor(Long id_Usuario)  {

        Optional<Usuario> resp = userRepo.findById(id_Usuario);
        if (resp.isPresent()) {
            Usuario user = resp.get();
            userRepo.delete(user);

        }

    }

    public void validar(String nombre, String domicilio, String telefono, String email, String password, String password2) throws Miexcepcion {


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
        if (password.isEmpty() || password == null || password.length() <= 6) {
            throw new Miexcepcion("El password no puede ser nulo, y debe ser mayor a 6 digitos");
        }
        if (!password2.equals(password)) {
            throw new Miexcepcion("El password no coincide");
        }

    }

    @Override //para autenticar usuario, una vez que se loguee spring con este metodo le da los permisos..
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        
        /**
        Usuario usuario = userRepo.buscarPorEmail(email);

        if (usuario != null) {

            List<GrantedAuthority> permisos = new ArrayList();

            GrantedAuthority p = new SimpleGrantedAuthority("ROLE_" + usuario.getRol().toString());

            permisos.add(p);

            return new User(usuario.getEmail(), usuario.getPassword(), permisos);

        } else {
             return null;
        }
         **/
return null;
    }

 
}
