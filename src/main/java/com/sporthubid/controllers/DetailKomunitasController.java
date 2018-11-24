package com.sporthubid.controllers;

import com.sporthubid.models.DetailKomunitasModel;
import com.sporthubid.models.DetailTempatModel;
import com.sporthubid.repository.DetailKomunitasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    @PostMapping
    public DetailKomunitasModel insertKomunitas(@RequestBody DetailKomunitasModel detailKomunitasModel){
        return detailKomunitasRepository.save(detailKomunitasModel);
    }

    @PutMapping(path = "/id/{id}")
    public Map<String,Object> updateKomunitas(@PathVariable(value = "id") Long id, @RequestBody DetailKomunitasModel detailKomunitasModel){
        Map<String, Object> respon = new HashMap<>();
        if(detailKomunitasRepository.existsById(id)){
            detailKomunitasModel.setId(id);
            detailKomunitasRepository.save(detailKomunitasModel);
            respon.put("status","Ok");
            respon.put("error",false);
            return respon;
        } else {
            respon.put("status","Fail");
            respon.put("error",true);
            return respon;
        }
    }

    @DeleteMapping(path = "/id/{id}")
    public void deletkomunitas(@PathVariable(value = "id") Long id){
        detailKomunitasRepository.deleteById(id);
    }
}
