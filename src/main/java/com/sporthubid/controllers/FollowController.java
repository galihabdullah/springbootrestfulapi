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

    @GetMapping("checkfollow")
    public Map<String, Object> checkFollow(@RequestParam("idkomunitas") Integer idkomunitas,
                                           @RequestParam(value = "iduser", required = false) Integer iduser){
        Map<String, Object> respon = new HashMap<>();
        if(iduser != null){
            if(repository.existsByIdkomunitasAndIduser(idkomunitas, iduser)){
                respon.put("status", true);
                respon.put("unfollow", " https://sportshubid.herokuapp.com/detailkomunitas/unfollow?idkomunitas="+idkomunitas+"&iduser="+iduser);
            }else{
                respon.put("status", true);
                respon.put("follow"," https://sportshubid.herokuapp.com/follow?idkomunitas="+idkomunitas+"&iduser="+iduser);
            }
        }else{
            respon.put("status",false);
        }
        return respon;

    }

    @GetMapping("/detailkomunitas/{idkomunitas}/follow")
    public Integer getCountFollower(@PathVariable(value = "idkomunitas") Integer idkomunitas){
        return repository.countByIdkomunitas(idkomunitas);
    }

    @GetMapping("users/{iduser}/followed")
    public List<FollowKomunitas> getCommunityFollowedByUser(@PathVariable(value = "iduser") Integer iduser){
        return repository.findByIduser(iduser);
    }

    @PostMapping(path = "/detailkomunitas/follow", consumes = "application/json")
    public FollowKomunitas follow(@RequestParam("idkomunitas") Long idkomunitas,
                                  @RequestParam("iduser") Long iduser,
                                  FollowKomunitas followKomunitas) {
        return repository.save(followKomunitas);

    }
    @DeleteMapping(path = "/detailkomunitas/unfollow")
   public void unfollow(@RequestParam("idkomunitas") Integer idkomunitas,
                        @RequestParam("iduser") Integer iduser) {
        repository.removeByIduserAndIdkomunitas(idkomunitas,iduser);
    }

}
