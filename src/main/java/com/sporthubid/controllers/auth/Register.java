package com.sporthubid.controllers.auth;

import com.sporthubid.models.User;
import com.sporthubid.repository.UserRepository;
import com.sporthubid.services.EmailService;
//import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class Register {

    @Autowired // inject dependency and function from user repository
    UserRepository userRepository;

    @Autowired // inject dependency and function from EmailService
    private EmailService notificationService;

    /*
    * Mapping end point to localhost:8080/register
    * Request method POST
    * @param user
    * */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Map<String, Object> register(@Valid @RequestBody User user){

        // cek username and email
        List<User> l_username = userRepository.findByUsername(user.getUsername());
        List<User> l_usermail = userRepository.findByEmail(user.getEmail());

        Map<String, Object> usermap = new HashMap<>(); // create new map for json

        if ( l_username.isEmpty() && l_usermail.isEmpty() ) {
            // save new user
            userRepository.save(user);
            // get id new user
            List<User> users = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
            List<User> user_id = new ArrayList<>();
            user_id.addAll(users);

            // get id user from array list
            Long id_ver = user_id.get(0).getId_user();
            // get first name
            String nama = user.getF_nama();
            // message
            String message = "Klik disini untuk verifikasi.";
            //when
            try {
                notificationService.prepareAndSend(user.getEmail(), message, id_ver, nama);
            } catch (MailException mailException) {
                usermap.put("error", true);
                usermap.put("message", "Send confirmation message failed");
                usermap.put("status", "FAIL");
            }

            usermap.put("error", null);
            usermap.put("message", "Registrasi berhasil");
            usermap.put("status", "OK");

            /*if (result == true){
                 response success
             } else {
                 response error
             }*/

        } else {
            usermap.put("error", true);
            usermap.put("message", "Register gagal");
            usermap.put("status", "FAIL");
        }
        return usermap;
    }

    /*
    * Request mapping for end point localhost:8080/verify
    * This method is used for verification new user
    * @param verify (id_user)
    * */
    @RequestMapping("/verify")
    public Map<String, Object> verifyUser(@RequestParam(value = "ver") Long verify){
        User idUpdate = userRepository.getOne(verify); // get data by id

        idUpdate.setId_user(verify); // set id data
        idUpdate.setStatus("1"); // set status
        userRepository.save(idUpdate);

        Map<String, Object> updatemap = new HashMap<>();
        updatemap.put("status", "OK");
        updatemap.put("message", "Verifikasi berhasil");
        updatemap.put("error", null);
        return updatemap;
    }

}
