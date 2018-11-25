package com.sporthubid.controllers;
import com.sporthubid.models.DetailTempatModel;
import com.sporthubid.repository.DetailTempatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/detailtempat")
public class DetailTempatController {


    @Autowired
    DetailTempatRepository repository;

    @GetMapping
    public List<DetailTempatModel> getAll(){
        return repository.findAll();
    }

    @GetMapping("/id/{id}")
    public Optional<DetailTempatModel> getById(@PathVariable(value = "id") Long id){
        return repository.findById(id);
    }

    @PostMapping
    public DetailTempatModel insetFacility(@RequestBody DetailTempatModel detailtempat){

        return repository.save(detailtempat);
    }

    @PutMapping(path = "/id/{id}")
    public Map<String,Object> updateTempat(@PathVariable(value = "id") Long id, @RequestBody DetailTempatModel detailTempatModel){
        Map<String, Object> respon = new HashMap<>();
        if(repository.existsById(id)){
            detailTempatModel.setId(id);
            repository.save(detailTempatModel);
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
    public void delettempat(@PathVariable(value = "id") Long id){
        repository.deleteById(id);
    }
}
