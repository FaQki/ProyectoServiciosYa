package com.appservicios.appservicios.services;

import com.appservicios.appservicios.entidades.Cliente;
import com.appservicios.appservicios.entidades.Servicio;
import com.appservicios.appservicios.entidades.Usuario;
import com.appservicios.appservicios.excepciones.Miexcepcion;
import com.appservicios.appservicios.repository.ClienteRepositorio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.appservicios.appservicios.repository.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ClienteService  extends UsuarioService{

  
    @Autowired
    private ClienteRepositorio ClienteRepo;
    @Autowired
    private UsuarioRepositorio userRepo;

    @Transactional
    public void crearCliente(Integer dni, String nombre, String domicilio, String telefono, String email, String password, String password2) throws Miexcepcion{

        crearUsuario(dni, nombre, domicilio, telefono, email, password, password2);

    }

    public List<Cliente> listarClientes(){

        List<Cliente> clientes = new ArrayList();

        clientes = ClienteRepo.findAll();

        return clientes;

    }

    public void modificarCliente(Integer dni, String nombre, String domicilio, String telefono, String email, String password, String password2) throws Miexcepcion {

        validar(dni, nombre, domicilio, telefono, email, password, password2);

        Optional<Cliente> resp = ClienteRepo.findById(dni);

        if (resp.isPresent()) {

            Cliente client = resp.get();
            client.setDni(dni);
            client.setNombre(nombre);
            client.setDomicilio(domicilio);
            client.setTelefono(telefono);
            client.setEmail(email);
            client.setFecha_alta(new Date());


        }

    }


    
    
    
}
