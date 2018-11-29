package com.sporthubid.controllers;

import com.sporthubid.models.Pengumuman;
import com.sporthubid.models.Post;
import com.sporthubid.repository.FollowRepository;
import com.sporthubid.repository.MjRepository;
import com.sporthubid.repository.PengumumanRepository;
import com.sporthubid.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
public class PengumumanController {

    @Autowired
    MjRepository mjRepository;

    @Autowired
    PengumumanRepository pengumumanRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private FollowRepository followRepository;

    @Autowired
    EntityManager em;

    @GetMapping(path = "/pengumuman/{id_user}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Post> getPengumuman(@Valid @PathVariable(name = "id_user") Integer id_user){

            Query sql = em.createNativeQuery("SELECT id_komunitas FROM tb_follow WHERE id_user="+id_user+"");
            List<Integer> id_kom = sql.getResultList();

            if (!id_kom.isEmpty()){
                List<Post> pengumuman = postRepository.getById_komunitas(id_kom);
                return pengumuman;
            } else {
                return null;
            }

    }


    @GetMapping(path = "/history/{id_komunitas}")
    public List<Post> mJoin(@Valid @PathVariable(name = "id_komunitas") Integer id_komunitas){

        List<Post> histpry = postRepository.findById_komunitas(id_komunitas);

        if (histpry.isEmpty()){
            return null;
        } else {
            return histpry;
        }


    }
}
