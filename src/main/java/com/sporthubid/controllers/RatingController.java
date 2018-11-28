package com.sporthubid.controllers;


import com.sporthubid.models.sort.RatingModel;
import com.sporthubid.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RatingController {
    @Autowired
    RatingRepository ratingRepository;

    @GetMapping("/detailtempat/id/{id}/rating")
    public Integer getRating(@PathVariable(value = "id") Long id){
        return ratingRepository.getAverageRating(id);
    }

    @PostMapping("/detailtempat/giverating")
    public Boolean giveRating(@RequestParam(value = "idtempat") Long idtempat,
                              @RequestParam(value = "iduser") Long iduser,
                              @RequestParam(value = "rating") Long rating,
                              RatingModel ratingModel
    ){
        if(!ratingRepository.existsByIduserAndIdtempat(iduser,idtempat)){
            ratingRepository.save(ratingModel);
            return true;
        }
        return false;
    }
}
