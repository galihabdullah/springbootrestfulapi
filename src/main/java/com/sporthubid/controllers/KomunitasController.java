package com.sporthubid.controllers;

import com.sporthubid.models.FasilitasModel;
import com.sporthubid.models.sort.KelurahanModel;
import com.sporthubid.models.sort.KomunitasModel;
import com.sporthubid.repository.KomunitasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/komunitas")
public class KomunitasController {

    @Autowired
    KomunitasRepository komunitasRepository;

    @GetMapping()
    public Page<KomunitasModel> findAllKomunitas(Pageable pageable){
        return komunitasRepository.findAll(pageable);
    }

    @GetMapping("/sort")
    public Page<KomunitasModel> filerfasilitas(@RequestParam("lokasi") String lokasi,
                                               @RequestParam("jenisolahraga") String jenisolahraga,
                                               @RequestParam(name = "kelurahan", required = false) String kelurahan,
                                               org.springframework.data.domain.Pageable pageable){
        return komunitasRepository.findByKotaContainingAndJenisolahragaContainingAndKelurahanContaining(lokasi, jenisolahraga, kelurahan, pageable);
    }
    @GetMapping("search")
    public Page<KomunitasModel> searchTempat(@RequestParam("query") String query, org.springframework.data.domain.Pageable pageable){
        return komunitasRepository.findByKotaContainingOrJenisolahragaContainingOrKelurahanContaining(query, query, query, pageable);
    }

}
