/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appservicios.appservicios.repository;

import com.appservicios.appservicios.entidades.Servicio;
import com.appservicios.appservicios.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

/**
 *
 * @author facua
 */
@Repository
public interface ServicioRepositorio extends JpaRepository<Servicio, Integer> {

}
