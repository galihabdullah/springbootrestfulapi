package com.sporthubid.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sporthubid.models.User;
import com.sporthubid.repository.UserRepository;

import javassist.tools.web.BadHttpRequest;

import java.util.Optional;


@RestController
@RequestMapping(path = "/users")
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping
    public Iterable<User> findAll() {
        return repository.findAll();
    }

    @GetMapping(path = "/{id_user}")
    public Optional<User> find(@PathVariable("id_user")long id_user) {
        if (repository.existsById(id_user)) {
            return repository.findById(id_user);
        } else {
            return null;
        }
    }

    @PostMapping(consumes = "application/json")
    public User create(@RequestBody User user) {
        return repository.save(user);
    }

    @DeleteMapping(path = "/{id_user}")
    public void delete(@PathVariable("id_user") long id_user) {
        repository.deleteById(id_user);
    }

    @PutMapping(path = "/{id_user}")
    public User update(@PathVariable("id_user") long id_user, @RequestBody User user) throws BadHttpRequest {
        if (repository.existsById(id_user)) {
            user.setId_user(id_user);
            return repository.save(user);
        } else {
            throw new BadHttpRequest();
        }
    }

}

