package com.sporthubid.controllers.auth;

import com.sporthubid.models.User;
import com.sporthubid.models.V_User;
import com.sporthubid.repository.UserRepository;
import com.sporthubid.repository.VUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class Login {

    @Autowired
    VUserRepository vuser;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Map<String, Object> login(@Valid @RequestBody V_User user) {

        List<V_User> user_v = vuser.findByUsernameAndPassword(user.getUsername(), user.getPassword());

        Map<String, Object> usermap = new HashMap<>();

        if ( user_v.isEmpty() ) {

            usermap.put("message", "Username or Passrord not match.");
            usermap.put("status", "gagal");

        } else {
            usermap.put("data", user_v);
            usermap.put("status", "suksess");
        }
        return usermap;
    }

    @GetMapping("/users")
    public List<V_User> getAll(){ // membuat list seluruh data member dari model Members
        return vuser.findAll(); // mengoper list seluruh data member dari model Members ke end point
    }
}
