/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spring.demo.modelos;

/**
 *
 * @author sarit
 */
public class Post {

    private int id;
    private String descripcion;
    private String urlImg;
    private String titulo;

    public Post() {
    }

    public Post(int id, String descripcion, String urlImg, String titulo) {
        this.id = id;
        this.descripcion = descripcion;
        this.urlImg = urlImg;
        this.titulo = titulo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "Post{" + "id=" + id + ", descripcion=" + descripcion + ", urlImg=" + urlImg + ", titulo=" + titulo + '}';
    }

}
