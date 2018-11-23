package com.sporthubid.controllers;

import com.sporthubid.models.UserEdit;
import com.sporthubid.repository.UserEditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sporthubid.models.User;
import com.sporthubid.repository.UserRepository;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping(path = "/users")
public class UserController {

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserEditRepository editRepository;

    @GetMapping
    public Iterable<User> findAll() { return repository.findAll();
    }

    @GetMapping(path = "/{id_user}")
    public Map<String, Object> find(@PathVariable("id_user") long id_user) {
        Map<String,Object> respon = new HashMap<>();

        if (repository.existsById(id_user)) {
            repository.findById(id_user);

            respon.put("status","succeed");
            respon.put("error",false);
            return respon;

        } else {
            respon.put("status","Id is not available. Searching failed.");
            respon.put("error",true);
            return respon;
        }
    }

    @PostMapping(consumes = "application/json")
    public User create(@RequestBody User user) {
        return repository.save(user);
    }

    @DeleteMapping(path = "/{id_user}")
    public Map<String, Object> delete(@PathVariable("id_user") long id_user) {
        Map<String, Object> respon = new HashMap<>();

        if (repository.existsById(id_user)) {
            repository.deleteById(id_user);

            respon.put("status", "Deletion succeed");
            respon.put("error", false);
            return respon;

        } else {
            respon.put("status", "Id is not available. Deletion failed.");
            respon.put("error", true);
            return respon;
        }
    }

    @PutMapping(path = "/{id_user}")
    public Map<String, Object> update(@PathVariable("id_user") long id_user, @RequestBody UserEdit user) {
        Map<String, Object> respon = new HashMap<>();

        if (editRepository.existsById(id_user)) {
            user.setId_user(id_user);
            editRepository.save(user);
            respon.put("status","Update Suceed.");
            respon.put("error",false);
            return respon;
        } else {
            respon.put("status","Id is not available. Update failed.");
            respon.put("error",true);
            return respon;
        }
    }

}


