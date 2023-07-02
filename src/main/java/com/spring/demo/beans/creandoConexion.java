/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spring.demo.beans;

import com.spring.demo.modelos.Conexion;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 *
 * @author sarit
 */
@Component
public class creandoConexion {

    @Bean(name="beanConexion")
    public Conexion getConexion() {
        Conexion conexion = new Conexion();
        conexion.setBd("mySQL");
        conexion.setUrl("localHOst");
        return conexion;
    }

}
