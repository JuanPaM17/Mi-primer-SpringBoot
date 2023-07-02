package com.spring.demo.components;

import com.spring.demo.modelos.Post;
import java.util.ArrayList;
import org.springframework.stereotype.Component;

/**
 *
 * @author sarit
 */
@Component("com.spring.demo.components.PostComponent")
public class PostComponent {

    public ArrayList<Post> obtenerPost() {
        ArrayList<Post> listaPosts = new ArrayList<>();
        listaPosts = new ArrayList<>();
        listaPosts.add(new Post(1, "lorem1", "https://i.postimg.cc/tJTxQyXj/ponymalta.jpg", "titulo1"));
        listaPosts.add(new Post(2, "lorem2", "https://i.postimg.cc/tJTxQyXj/ponymalta.jpg", "titulo2"));
        listaPosts.add(new Post(0, "lorem3", "https://i.postimg.cc/tJTxQyXj/ponymalta.jpg", "titulo3"));
        return listaPosts;
    }

}
