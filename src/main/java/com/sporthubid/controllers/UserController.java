package com.sporthubid.controllers;

import com.sporthubid.models.DetailKomunitasModel;
import com.sporthubid.models.DetailTempatModel;
import com.sporthubid.models.UserEdit;
import com.sporthubid.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.sporthubid.models.User;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping(path = "/users")
public class UserController {


    @Autowired
    EntityManager em;

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserEditRepository editRepository;

    @Autowired
    private DetailKomunitasRepository detailKomunitasRepository;

    @Autowired
    private DetailTempatRepository detailTempatRepository;

    @Autowired
    OlahragaRepository olahragaRepository;

    @GetMapping
    public Iterable<User> findAll() { return repository.findAll();
    }

    @GetMapping(path = "/{id_user}")
    public Map<String, Object> find(@PathVariable("id_user") long id_user) {
        Map<String,Object> respon = new HashMap<>();

        if (repository.existsById(id_user)) {
            Optional<User> user_detail = repository.findById(id_user);

            respon.put("status","Ok");
            respon.put("error",false);
            respon.put("result", user_detail);
            return respon;

        } else {
            respon.put("status","Fail");
            respon.put("messages","Id is not available. Searching failed.");
            respon.put("error",true);
            return respon;
        }
    }

    @DeleteMapping(path = "/{id_user}")
    public Map<String, Object> delete(@PathVariable("id_user") long id_user) {
        Map<String, Object> respon = new HashMap<>();

        if (repository.existsById(id_user)) {
            repository.deleteById(id_user);

            respon.put("status","Ok");
            respon.put("error",false);
            respon.put("messages", "Deletion succeed");
            return respon;
        } else {
            respon.put("status","Fail");
            respon.put("error",true);
            respon.put("messages", "Id is not available. Deletion failed.");
            return respon;
        }
    }

    @PutMapping(path = "/{id_user}")
    public Map<String, Object> update(@PathVariable("id_user") long id_user, @RequestBody UserEdit user) {
        Map<String, Object> respon = new HashMap<>();

        if (editRepository.existsById(id_user)) {
            user.setId_user(id_user);
            editRepository.save(user);
            respon.put("status","Update Suceed.");
            respon.put("error",false);
            return respon;
        } else {
            respon.put("status","Id is not available. Update failed.");
            respon.put("error",true);
            return respon;
        }
    }

    @GetMapping(path = "/komunitas/{id_user}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DetailKomunitasModel> getPengumuman(@Valid @PathVariable(name = "id_user") Integer id_user){

        Query sql = em.createNativeQuery("SELECT id_komunitas FROM tb_follow WHERE id_user="+id_user+"");
        List<Integer> id_kom = sql.getResultList();

        if (!id_kom.isEmpty()){
            List<DetailKomunitasModel> komunitas = detailKomunitasRepository.getById_komunitas(id_kom);
            return komunitas;
        } else {
            return null;
        }

    }


    @GetMapping(path = "/profile/{id_user}")
    public Map<String, Object> getProfile(@PathVariable("id_user") Long id_user) {
        Map<String,Object> respon = new HashMap<>();
        Map<String,Object> rus = new HashMap<>();

        List<DetailKomunitasModel> komunitas = null;
        List<DetailKomunitasModel> datakomunitas = null;
        List<DetailTempatModel> datatempat = null;
        List olahraga = null;
        String[] minat = null;

        if (repository.existsById(id_user)) {
            Optional<User> user_detail = repository.findById(id_user);
            User data_user = user_detail.get();

            if (data_user.getId_level()==5){

                datakomunitas = detailKomunitasRepository.findByIduser(data_user.getId_user());
                respon.put("profil_komunitas", datakomunitas);

            } else if (data_user.getId_level()==6){

                datatempat = detailTempatRepository.findByIduser(data_user.getId_user());
                respon.put("profil_tempat", datatempat);

            } else {

                //  --------------- get komunitas by user id -------------
                try
                {
                    Query sql = em.createNativeQuery("SELECT id_komunitas FROM tb_follow WHERE id_user="+id_user+"");
                    List<Integer> id_kom = sql.getResultList();
                    komunitas = detailKomunitasRepository.getById_komunitas(id_kom);
                }catch (Exception e){
                    komunitas = null;
                }

                //  ----------------- get olahraga by user id -------------
                try
                {
                    minat = data_user.getMinat_or().split(",");
                    olahraga = olahragaRepository.getById_komunitas(minat);
                } catch (Exception e){
                    olahraga = null;
                }

                rus.put("minat_or", olahraga);
                rus.put("komunitas", komunitas);
            }


//  ------------------ user map -------------

            rus.put("id_user", data_user.getId_user());
            rus.put("id_level", data_user.getId_level());
            rus.put("f_nama", data_user.getF_nama());
            rus.put("l_nama", data_user.getL_nama());
            rus.put("foto", data_user.getFoto());
            rus.put("tmp_lahir", data_user.getTmp_lahir());
            rus.put("tgl_lahir", data_user.getTgl_lahir());
            rus.put("jenis_kelamin", data_user.getJenis_kelamin());
            rus.put("email", data_user.getEmail());
            rus.put("no_hp", data_user.getNo_hp());
            rus.put("alamat", data_user.getAlamat());
            rus.put("username", data_user.getUsername());
            rus.put("status", data_user.getStatus());
            rus.put("created_at", data_user.getCreated_at());
            rus.put("updated_at", data_user.getUpdated_at());

//  ------------------ respon map -------------

            respon.put("status","Ok");
            respon.put("error",false);
            respon.put("result", rus);
            return respon;

        } else {
            respon.put("status","Fail");
            respon.put("messages","Id is not available. Searching failed.");
            respon.put("error",true);
            return respon;
        }
    }

}


