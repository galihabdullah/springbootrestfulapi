package com.sporthubid.controllers;


import com.sporthubid.models.FasilitasModel;
import com.sporthubid.repository.FasilitasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/tempat")
public class FasilitasController {
    @Autowired
    FasilitasRepository fasilitasRepository;

    @GetMapping()
    public Page<FasilitasModel> findAllFasilitas(Pageable pageable){
        return fasilitasRepository.findAll(pageable);
    }

    @GetMapping("/sort")
    public Page<FasilitasModel> filerfasilitas(@RequestParam("lokasi") String lokasi,
                                               @RequestParam("jenisolahraga") String jenisolahraga,
                                               @RequestParam(name = "kelurahan", required = false) String kelurahan,
                                               Pageable pageable){
        return fasilitasRepository.findByKotaContainingAndJenisolahragaContainingAndKelurahanContaining(lokasi, jenisolahraga, kelurahan, pageable);
    }

    @GetMapping("/search")
    public Iterable<FasilitasModel> searchQuery(@RequestParam("query") String query, Pageable pageable){
        return fasilitasRepository.findByKotaContainingOrJenisolahragaContainingOrKelurahanContaining(query, query, query, pageable);
    }
}
