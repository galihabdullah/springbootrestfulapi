package com.sporthubid.controllers;

import com.sporthubid.models.Post;
import com.sporthubid.repository.PostRepository;
import javassist.tools.web.BadHttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping (path= "/posts")


public class PostController {
    @Autowired
    private PostRepository repository;

    @GetMapping
    public Iterable<Post> findAll() {
        return repository.findAll();
    }

    @GetMapping(path = "/{id_post}")
    public Optional<Post> find(@PathVariable("id_post") int id_post) {
       if (repository.existsById(id_post)){
           return repository.findById(id_post);
    } else {
        return null;
    }

}

    @PostMapping(consumes = "application/json")
    public Post create(@RequestBody Post post) {
        return repository.save(post);
    }

    @DeleteMapping(path = "/{id_post}")
    public void delete(@PathVariable("id_post") int id_post) {
        repository.deleteById(id_post);
    }

    @PutMapping(path = "/{id_post}")
    public Post update(@PathVariable("id_post") int id_post, @RequestBody Post post) throws BadHttpRequest {
        if (repository.existsById(id_post)) {
            post.setId_post(id_post);
            return repository.save(post);
        } else {
            throw new BadHttpRequest();
        }
    }

}
