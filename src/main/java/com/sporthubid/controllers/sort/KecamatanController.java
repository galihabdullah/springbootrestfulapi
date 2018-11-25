package com.sporthubid.controllers.sort;

import com.sporthubid.models.sort.KecamatanModel;
import com.sporthubid.models.sort.KelurahanModel;
import com.sporthubid.models.sort.LokasiModel;
import com.sporthubid.repository.sort.KecamatanRepository;
import com.sporthubid.repository.sort.KelurahanRepository;
import com.sporthubid.repository.sort.LokasiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
public class KecamatanController {
    @Autowired
    KecamatanRepository kecamatan;

    @Autowired
    LokasiRepository kota;

    @Autowired
    KelurahanRepository kelurahan;

    @GetMapping("lokasi/{idkota}/kecamatan")
    public Page<KecamatanModel> findAllKecamatanNByLokasiId(@PathVariable(value = "idkota") Long idkota, Pageable pageable){
        return kecamatan.findByIdkota(idkota, pageable);
    }
/**
    @GetMapping("lokasi/{idkota}/kecamatan/{idkecamatan)/kelurahan}")
    public Page<KelurahanModel> fiindAllKelurahanByKecamatanId(@PathVariable("idkota") Long idkota,
                                                               @PathVariable("idkecamatan") Long idkecamatan,
                                                               Pageable pageable){
        if(!kota.existsById(idkota) && kecamatan.existsById(idkecamatan)){
            Map<String Object> = new HashMap<>();
        }
        return kelurahan.findByIdkotaAndIdkecamatan(idkota, idkecamatan, pageable);
    }
                                                               */
}
