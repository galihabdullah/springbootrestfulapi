package com.sportshubid.sportshubid.controllers;


import com.sportshubid.sportshubid.models.SortAndFilterTempatModel;
import com.sportshubid.sportshubid.repository.SortAndFilterTempatRepository;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tempat")
public class SortAndFilterTempatController {

    @Autowired
    SortAndFilterTempatRepository repository;

    @GetMapping
    public Iterable<SortAndFilterTempatModel> listAllCustomers() {
        return repository.findAll();
    }

    @GetMapping("/lokasi={lokasi}&jenisolahraga={jenisOlahraga}")
    public Iterable<SortAndFilterTempatModel> findByJenisAndLokasi(@PathVariable(value = "lokasi") String lokasi, @PathVariable(value = "jenisOlahraga") String jenisOlahraga,Pageable pageable){
        return repository.findByLokasiContainingAndJenisOlahragaContaining(lokasi, jenisOlahraga, pageable);
    }

    @GetMapping("/search={query}")
    public Page<SortAndFilterTempatModel> searchQuery(@PathVariable(value = "query") String query, Pageable pageable){
        return repository.findByLokasiContainingOrJenisOlahragaContaining(query, query, pageable);
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