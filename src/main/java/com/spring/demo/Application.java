package com.spring.demo;

import com.spring.demo.components.PostComponent;
import com.spring.demo.interfazServicios.IPostService;
import com.spring.demo.modelos.Conexion;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    @Qualifier("beanConexion")
    private Conexion con = new Conexion();

    @Autowired
    @Qualifier("com.spring.demo.components.PostComponent")
    private PostComponent _postComponent;

    @Autowired
    @Qualifier("serviceDecorado")
    private IPostService postService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Log log = LogFactory.getLog(getClass());
        System.out.println(con.getBd());
        try {
            postService.validacion(_postComponent.obtenerPost()).forEach(p -> {
                log.info(p.toString());
            });
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        System.exit(0);
    }

}
