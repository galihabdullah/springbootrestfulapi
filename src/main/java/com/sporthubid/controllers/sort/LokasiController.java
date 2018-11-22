package com.sporthubid.controllers.sort;

import com.sporthubid.models.sort.LokasiModel;
import com.sporthubid.repository.sort.LokasiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lokasi")
public class LokasiController {
    @Autowired
    LokasiRepository lokasiRepository;

    @GetMapping()
    public List<LokasiModel> findAllJenis(){
        return lokasiRepository.findAll();
    }

}
