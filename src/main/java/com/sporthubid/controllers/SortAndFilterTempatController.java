package com.sporthubid.controllers;


import com.sporthubid.models.SortAndFilterTempatModel;
import com.sporthubid.repository.SortAndFilterTempatRepository;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tempat")
public class SortAndFilterTempatController {

    @Autowired
    SortAndFilterTempatRepository repository;

    @GetMapping
    public Iterable<SortAndFilterTempatModel> listAllCustomers() {
        return repository.findAll();
    }

    @GetMapping("/sort")
    public Iterable<SortAndFilterTempatModel> findByJenisAndLokasi(@RequestParam("lokasi") String lokasi, @RequestParam("jenisolahraga") String jenisOlahraga, @RequestParam(name = "kelurahan", required = false) String kelurahan, Pageable pageable){
        return repository.findByLokasiContainingAndJenisOlahragaContainingAndKelurahanContaining(lokasi, jenisOlahraga, kelurahan, pageable);
    }

    @GetMapping("/search")
    public Iterable<SortAndFilterTempatModel> searchQuery(@RequestParam("query") String query, Pageable pageable){
        return repository.findByNamaTempatContainingOrLokasiContainingOrKelurahanContaining(query, query, query, pageable);
    }

    @GetMapping("/lokasi={lokasi}")
    public Page<SortAndFilterTempatModel> findByLokasi(@PathVariable(value = "lokasi") String lokasi, Pageable pageable){
        return repository.findByLokasiContaining(lokasi, pageable);
    }

    @GetMapping("/jenisolahraga={jenisolahraga}")
    public Page<SortAndFilterTempatModel> findBJenis(@PathVariable(value = "jenisolahraga") String jenisolahraga, Pageable pageable){
        return repository.findByJenisOlahragaContaining(jenisolahraga, pageable);
    }
}