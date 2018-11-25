package com.sporthubid.controllers;

import com.sporthubid.models.UserEdit;
import com.sporthubid.repository.UserEditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sporthubid.models.User;
import com.sporthubid.repository.UserRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
            Optional<User> user_detail = repository.findById(id_user);

            respon.put("status","Ok");
            respon.put("error",false);
            respon.put("result", user_detail);
            return respon;

        } else {
            respon.put("status","Fail");
            respon.put("messages","Id is not available. Searching failed.");
            respon.put("error",true);
            return respon;
        }
    }

    @DeleteMapping(path = "/{id_user}")
    public Map<String, Object> delete(@PathVariable("id_user") long id_user) {
        Map<String, Object> respon = new HashMap<>();

        if (repository.existsById(id_user)) {
            repository.deleteById(id_user);

            respon.put("status","Ok");
            respon.put("error",false);
            respon.put("messages", "Deletion succeed");
            return respon;
        } else {
            respon.put("status","Fail");
            respon.put("error",true);
            respon.put("messages", "Id is not available. Deletion failed.");
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


