package com.sporthubid.controllers;
import com.sporthubid.models.DetailTempatModel;
import com.sporthubid.repository.DetailTempatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/detailtempat")
public class DetailTempatController {
    @Autowired
    DetailTempatRepository repository;

    @GetMapping
    public List<DetailTempatModel> getAll(){
        return repository.findAll();
    }

    @GetMapping("/id/{id}")
    public Optional<DetailTempatModel> getById(@PathVariable(value = "id") Long id){
        return repository.findById(id);
    }
}
