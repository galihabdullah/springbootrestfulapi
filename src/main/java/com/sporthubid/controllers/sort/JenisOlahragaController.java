package com.sporthubid.controllers.sort;

import com.sporthubid.models.sort.JenisOlahragaModel;
import com.sporthubid.repository.sort.JenisOlahrgaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/jenisolahraga")
public class JenisOlahragaController {
    @Autowired
    JenisOlahrgaRepository jenisOlahrgaRepository;

    @GetMapping()
    public List<JenisOlahragaModel> findAllJenisOlahraga(){
        return jenisOlahrgaRepository.findAll();
    }
}
