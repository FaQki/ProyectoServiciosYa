package com.appservicios.appservicios.services;

import com.appservicios.appservicios.entidades.Cliente;
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
    private ClienteRepositorio clienteRepo;
    @Autowired
    private UsuarioRepositorio userRepo;

    @Transactional
    public void crearCliente(Long id_Usuario,String nombre, String domicilio, String telefono, String email, String password, String password2) throws Miexcepcion{

        crearUsuario(id_Usuario,nombre, domicilio, telefono, email, password, password2);

    }

    public List<Cliente> listarClientes(){

        List<Cliente> clientes = new ArrayList();

        clientes = clienteRepo.findAll();

        return clientes;

    }

    public void modificarCliente(Long id_Usuario, String nombre, String domicilio, String telefono, String email, String password, String password2) throws Miexcepcion {

        validar(nombre, domicilio, telefono, email, password, password2);

        Optional<Cliente> resp = clienteRepo.findById(id_Usuario);

        if (resp.isPresent()) {

            Cliente client = resp.get();
            client.setId_cliente(client.getId_cliente());
            client.setNombre(nombre);
            client.setDomicilio(domicilio);
            client.setTelefono(telefono);
            client.setEmail(email);
            client.setFecha_alta(new Date());


        }

    }

    @Transactional
    public void eliminarCliente(Long id_cliente)  {

        Optional<Cliente> resp = clienteRepo.findById(id_cliente);
        if (resp.isPresent()) {
            Cliente client = resp.get();
            clienteRepo.delete(client);

        }

    }

    
    
    
}
