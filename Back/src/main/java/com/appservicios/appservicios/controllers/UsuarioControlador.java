/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appservicios.appservicios.controllers;

import com.appservicios.appservicios.excepciones.Miexcepcion;
import com.appservicios.appservicios.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author facua
 */
@Controller
@RequestMapping("/usuario")
public class UsuarioControlador {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/registrar")
    public String registar() {
        return "registroUsuario.html";
    }

    @PostMapping("/registro")
    public String registro(
            @RequestParam String nombre,
            @RequestParam String domicilio,
            @RequestParam String telefono,
            @RequestParam String email,
            @RequestParam String password,
            @RequestParam String password2,
            ModelMap modelo) {

        try {

            usuarioService.crearUsuario(nombre, domicilio, telefono, email, password, password2);


            modelo.put("exito", "El usuario fue creado correctamente");


        } catch (Miexcepcion e) {

            modelo.put("error", e.getMessage());
        }

        return "index.html";

    }

}
