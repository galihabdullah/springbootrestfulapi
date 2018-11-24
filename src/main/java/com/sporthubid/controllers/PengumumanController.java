package com.sporthubid.controllers;

import com.sporthubid.models.Pengumuman;
import com.sporthubid.repository.MjRepository;
import com.sporthubid.repository.PengumumanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "/pengumuman")
public class PengumumanController {

    @Autowired
    MjRepository mjRepository;

    @Autowired
    PengumumanRepository pengumumanRepository;

    @Autowired
    EntityManager em;


    @GetMapping(path = "/get-pengumuman/{id_user}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Pengumuman> mJoin(@Valid @PathVariable(name = "id_user") Long id_user){

        if (mjRepository.existsById(id_user)){
            Query sql = em.createNativeQuery("SELECT id_komunitas from tb_member_join where id_user="+id_user+"");
            List<Integer> id_kom = sql.getResultList();
//          String strikom = StringUtils.join(id_kom,","); // koversi list ke array

            if (!id_kom.isEmpty()){
                List<Pengumuman> pengumuman = pengumumanRepository.getById_komunitas(id_kom);
                return pengumuman;
            } else {
                return null;
            }

        } else {
            return null;
        }

    }
}
