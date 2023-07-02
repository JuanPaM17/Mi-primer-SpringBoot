/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.spring.demo.service;

import com.spring.demo.interfazServicios.IPostService;
import com.spring.demo.modelos.Post;
import java.util.ArrayList;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

/**
 *
 * @author sarit
 */
@Service("serviceDos")
public class PostServiceDos implements IPostService {

    @Override
    public ArrayList<Post> validacion(ArrayList<Post> posts) {
        Log log = LogFactory.getLog(getClass());
        log.info("Segundo Servicio");
        for (Post post : posts) {
            if (post.getId() == 0) {
                throw new NullPointerException("EL id es nulo");
            }
        }
        return posts;
    }

}
