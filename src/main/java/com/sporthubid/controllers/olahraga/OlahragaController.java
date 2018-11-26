package com.sporthubid.controllers.olahraga;

import com.sporthubid.models.UserEdit;
import com.sporthubid.models.sort.JenisOlahragaModel;
import com.sporthubid.repository.UserEditRepository;
import com.sporthubid.repository.sort.JenisOlahrgaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
public class OlahragaController {

    @Autowired
    UserEditRepository userEditRepository;

    @Autowired
    JenisOlahrgaRepository jenisOlahrgaRepository;

    @GetMapping(path = "/sports")
    public List<JenisOlahragaModel> getOlahraga(){
        return jenisOlahrgaRepository.findAll();
    }

    @PutMapping(path = "sports-interest/{id_user}")
    public int setMinat(@Valid @RequestBody UserEdit user, @PathVariable(value = "id_user") Long id_user){
        if (userEditRepository.existsById(id_user)){
            userEditRepository.setMinatOlahraga(user.getMinat_or(), id_user);
            return 1;
        } else {
            return 0;
        }
    }
}
