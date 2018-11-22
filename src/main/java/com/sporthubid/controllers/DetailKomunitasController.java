package com.sporthubid.controllers;

import com.sporthubid.models.DetailKomunitasModel;
import com.sporthubid.repository.DetailKomunitasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/detailkomunitas")
public class DetailKomunitasController {
    @Autowired
    DetailKomunitasRepository detailKomunitasRepository;

    @GetMapping()
    public List<DetailKomunitasModel> findAll(){
        return detailKomunitasRepository.findAll();
    }

    @GetMapping("/id/{id}")
    public Optional<DetailKomunitasModel> findById(@PathVariable("id") Long id){
        return detailKomunitasRepository.findById(id);
    }

}
