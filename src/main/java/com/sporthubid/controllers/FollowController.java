package com.sporthubid.controllers;

import com.sporthubid.models.DetailKomunitasModel;
import com.sporthubid.models.FollowKomunitas;
import com.sporthubid.repository.DetailKomunitasRepository;
import com.sporthubid.repository.FollowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin
//@RequestMapping(path= "/follows")
public class FollowController {

    @Autowired
    FollowRepository repository;

    @Autowired
    DetailKomunitasRepository detailKomunitasRepository;

    /**
    @GetMapping
    public Iterable<FollowKomunitas> findAll() {
        return repository.findAll();
    }

    @GetMapping(path = "/{id_follow}")
    public Optional<FollowKomunitas> find(@PathVariable("id_follow")int id_follow) {
        if (repository.existsById(id_follow)) {
            return repository.findById(id_follow);
        } else {
            return null;
        }
    }

    @PostMapping(consumes = "application/json")
    public Map<String, Object> create(@RequestBody FollowKomunitas follow) {
        Map<String,Object> respon = new HashMap<>();

        repository.save(follow);

        respon.put("status","Ok");
        respon.put("messages","Following succeed");
        respon.put("error",false);
        return respon;
    }

    @DeleteMapping(path = "/{id_follow}")
    public void delete(@PathVariable("id_follow") int id_follow) { repository.deleteById (id_follow);
    }
     **/

    @GetMapping("/detailkomunitas/{idkomunitas}/follow")
    public Integer getCountFollower(@PathVariable(value = "idkomunitas") Integer idkomunitas){
        return repository.countByIdkomunitas(idkomunitas);
    }

    @GetMapping("users/{iduser}/followed")
    public List<FollowKomunitas> getCommunityFollowedByUser(@PathVariable(value = "iduser") Integer iduser){
        return repository.findByIduser(iduser);
    }

    @PostMapping(path = "detailkomunitas/{idkomunitas}/follow", consumes = "application/json")
    public Map<String, Object> create(@PathVariable("idkomunitas") Long idkomunitas, @RequestBody FollowKomunitas follow) {
        Map<String,Object> respon = new HashMap<>();
        if (!detailKomunitasRepository.existsById(idkomunitas)){
            respon.put("status","false");
            respon.put("messages","Following failed");
            respon.put("error",true);
            return respon;
        }else{
            repository.save(follow);
            respon.put("status","Ok");
            respon.put("messages","Following succeed");
            respon.put("error",false);
            return respon;
        }


    }

    @DeleteMapping(path = "/detailkomunitas/{idkomunitas}/unfollow/{iduser}")
   public void delete(@PathVariable("idkomunitas") Integer idkomunitas,
                      @PathVariable("iduser") Integer iduser) {
        repository.deleteByIduserAndIdkomunitas(iduser, idkomunitas);
    }
}
