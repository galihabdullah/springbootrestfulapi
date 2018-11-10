package com.sporthubid.controllers.auth;

import com.sporthubid.models.User;
import com.sporthubid.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class Register {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Map<String, Object> register(@Valid @RequestBody User user){

        List<User> l_username = userRepository.findByUsername(user.getUsername());
        List<User> l_usermail = userRepository.findByEmail(user.getEmail());

        Map<String, Object> usermap = new HashMap<>();

        if ( l_username.isEmpty() && l_usermail.isEmpty() ) {
            userRepository.save(user);

            usermap.put("message", "Berhasil");
            usermap.put("status", "200");

            /*if (result == true){
                 response success
             } else {
                 response error
             }*/

        } else {
            usermap.put("message", "Username or Email has already taken!");
            usermap.put("status", "gagal");
        }
        return usermap;
    }

    @RequestMapping(value = "/sendemail")
    public String sendEmail() {
        return "Email sent successfully";
    }

}
