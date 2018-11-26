package com.sporthubid.controllers.sort;

import com.sporthubid.models.sort.LokasiModel;
import com.sporthubid.repository.sort.LokasiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/lokasi")
public class LokasiController {
    @Autowired
    LokasiRepository lokasiRepository;

    @GetMapping()
    public List<LokasiModel> findAllJenis(){
        return lokasiRepository.findAll();
    }

    @GetMapping("/lokasi/{idkota}")
    public Optional<LokasiModel> findKotaById(@PathVariable("idkota") Long idkota){
        return lokasiRepository.findById(idkota);
    }

}
