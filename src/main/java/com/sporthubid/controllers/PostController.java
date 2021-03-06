package com.sporthubid.controllers;

import com.sporthubid.models.Post;
import com.sporthubid.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping(path = "/posts")
public class PostController {
    @Autowired
    private PostRepository repository;

    @GetMapping
    public Iterable<Post> findAll() {
        return repository.findAll();
    }

    @GetMapping(path = "/{id_post}")
    public Map<String, Object> put(@PathVariable("id_post") int id_post) {
        Map<String,Object> respon = new HashMap<>();

        if (repository.existsById(id_post)) {
            repository.findById(id_post);

            respon.put("status","Ok");
            respon.put("messages","Searching succeed");
            respon.put("error",false);
            return respon;

        } else {
            respon.put("status","Fail");
            respon.put("messages","Id is not available. Searching failed.");
            respon.put("error",true);
            return respon;
        }
    }

    @PostMapping(consumes = "application/json")
    public Map<String, Object> create(@RequestBody Post post) {
        Map<String,Object> respon = new HashMap<>();

        repository.save(post);

        respon.put("status","Ok");
        respon.put("messages","Posting succeed");
        respon.put("error",false);
        return respon;
    }

    @DeleteMapping(path = "/{id_post}")
    public Map<String, Object> delete(@PathVariable("id_post") int id_post) {
        Map<String,Object> respon = new HashMap<>();

        if (repository.existsById(id_post)) {
            repository.deleteById(id_post);

            respon.put("status","Ok");
            respon.put("messages","Deletion succeed");
            respon.put("error",false);
            return respon;

        } else {
            respon.put("status","Fail");
            respon.put("messages","Id is not available. Deletion failed.");
            respon.put("error",true);
            return respon;
        }
    }

    @PutMapping(path = "/{id_post}")
    public Map<String, Object> update(@PathVariable("id_post") int id_post, @RequestBody Post post) {
        Map<String,Object> respon = new HashMap<>();

        if (repository.existsById(id_post)) {
            post.setId_post(id_post);
            repository.save(post);

            respon.put("status","Ok");
            respon.put("messages","update succeed");
            respon.put("error",false);
            return respon;

        } else {
            respon.put("status","Fail");
            respon.put("messages","Id is not available. Update failed.");
            respon.put("error",true);
            return respon;
        }
    }
}
