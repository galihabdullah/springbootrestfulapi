package com.sporthubid.controllers;

import com.sporthubid.models.FollowKomunitas;
import com.sporthubid.repository.FollowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping(path= "/follows")
public class FollowController {

    @Autowired
    private FollowRepository repository;

    @GetMapping
    public Iterable<FollowKomunitas> findAll() {
        return repository.findAll();
    }

    @GetMapping(path = "/{id_follow}")
    public Optional<FollowKomunitas> find(@PathVariable("id_follow")int id_follow) {
        if (repository.existsById(id_follow)) {
            return repository.findById(id_follow);
        } else {
            return null;
        }
    }

    @PostMapping(consumes = "application/json")
    public Map<String, Object> create(@RequestBody FollowKomunitas follow) {
        Map<String,Object> respon = new HashMap<>();

        repository.save(follow);

        respon.put("status","Ok");
        respon.put("messages","Following succeed");
        respon.put("error",false);
        return respon;
    }

    @DeleteMapping(path = "/{id_follow}")
    public void delete(@PathVariable("id_follow") int id_follow) { repository.deleteById (id_follow);
    }


}
