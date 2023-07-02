/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spring.demo.service;

import com.spring.demo.interfazServicios.IPostService;
import com.spring.demo.modelos.Post;
import java.util.ArrayList;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sarit
 */
@Service("serviceDecorado")
public class PostServiceDecorado implements IPostService {

    @Autowired
    private PostService postService;

    @Autowired
    private PostServiceDos postServiceDos;

    @Override
    public ArrayList<Post> validacion(ArrayList<Post> posts) {
        Log log = LogFactory.getLog(getClass());
        posts = postService.validacion(posts);
        posts = postServiceDos.validacion(posts);
        for (Post post : posts) {
            if (post.getDescripcion() == null) {
                throw new NullPointerException("No tiene descripcion");
            }
        }
        log.info("Segundo Servicio");
        return posts;
    }

}
