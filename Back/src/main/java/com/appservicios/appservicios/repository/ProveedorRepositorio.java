/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appservicios.appservicios.repository;

import com.appservicios.appservicios.entidades.Proveedor;

import java.util.List;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author facua
 */

@Repository
public interface ProveedorRepositorio extends JpaRepository<Proveedor, Long> {
    
     @EntityGraph(attributePaths = {"user"})
    List<Proveedor> findAll();
    
    
    
    
}
