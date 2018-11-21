package com.sporthubid.controllers.sort;

import com.sporthubid.models.FasilitasModel;
import com.sporthubid.models.sort.JenisOlahragaModel;
import com.sporthubid.models.sort.LokasiModel;
import com.sporthubid.repository.sort.JenisOlahrgaRepository;
import com.sporthubid.repository.sort.LokasiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
