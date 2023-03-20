/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appservicios.appservicios.controllers;

import com.appservicios.appservicios.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
        return "registro_usuario.html";
    }

    @PostMapping("/registro")
    public String registro(
            @RequestParam("nombre") String nombre,
            @RequestParam("barrio") String barrio,
            @RequestParam("domicilio") String domicilio,
            @RequestParam("telefono") String telefono,
            @RequestParam("email") String email,
            @RequestParam("contrasenia") String contrasenia,
            Model modelo) {
        
        System.out.println(nombre);

        modelo.addAttribute("nombre", nombre);
        modelo.addAttribute("barrio", barrio);
        modelo.addAttribute("telefono", telefono);
        modelo.addAttribute("email", email);
        modelo.addAttribute("domicilio", domicilio);
        modelo.addAttribute("contrasenia", contrasenia);
       
        return "index.html";

    }

}
