package com.sporthubid.controllers;

import com.sporthubid.models.DetailTempatModel;
import com.sporthubid.repository.DetailTempatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/detailtempat")
public class DetailTempatController {
    @Autowired
    DetailTempatRepository repository;

    @GetMapping
    public Page<DetailTempatModel> getAll(Pageable pageable){
        return repository.findAll(pageable);
    }

    @GetMapping("/id/{id}")
    public Page<DetailTempatModel> getById(@PathVariable(value = "id") Long id, Pageable pageable){
        return repository.findById(id, pageable);
    }
}
