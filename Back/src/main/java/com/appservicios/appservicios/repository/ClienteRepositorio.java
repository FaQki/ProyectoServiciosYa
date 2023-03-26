/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appservicios.appservicios.repository;

import com.appservicios.appservicios.entidades.Cliente;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author facua
 */

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {


    @EntityGraph(attributePaths = {"user"})
    List<Cliente> findAll();
}
