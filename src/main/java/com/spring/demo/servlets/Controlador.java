/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spring.demo.servlets;

import com.spring.demo.components.PostComponent;
import com.spring.demo.configuracion.Paginas;
import com.spring.demo.modelos.Post;
import java.util.ArrayList;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author sarit
 */
@Controller
@RequestMapping("/home")
public class Controlador {

    @Autowired
    private PostComponent _postComponent;

    @GetMapping("/inicio")
    public String index(Model modelo) {
        modelo.addAttribute("listaPosts", _postComponent.obtenerPost());
        return "index";
    }

    @GetMapping("/formulario")
    public String formulario(Model modelo) {
        modelo.addAttribute("listaPosts", _postComponent.obtenerPost());
        modelo.addAttribute("post", new Post());
        return Paginas.FORMULARIO;
    }

    @PostMapping("/newPost")
    public String nuevoPost(Model modelo, Post post) {
        ArrayList listaPosts = _postComponent.obtenerPost();
        listaPosts.add(post);
        modelo.addAttribute("listaPosts", listaPosts);
        modelo.addAttribute("post", new Post());
        return Paginas.FORMULARIO;
    }

    @GetMapping(path = {"/post", "/post/{id}"})
    public ModelAndView obtenerPostIndividual(@RequestParam(defaultValue = "1", name = "id", required = false) @PathVariable(required = true, name = "post") int id) {
        ModelAndView modelAndView = new ModelAndView(Paginas.POST);
        ArrayList<Post> postFiltadro = (ArrayList) _postComponent.obtenerPost().stream()
                .filter((post) -> {
                    return post.getId() == id;
                }).collect(Collectors.toList());
        modelAndView.addObject("listaPosts", postFiltadro.get(0));
        return modelAndView;
    }

}
