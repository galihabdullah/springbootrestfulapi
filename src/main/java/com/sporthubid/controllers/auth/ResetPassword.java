package com.sporthubid.controllers.auth;

import com.sporthubid.models.UserEdit;
import com.sporthubid.repository.UserEditRepository;
import com.sporthubid.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin
public class ResetPassword {

    @Autowired
    UserEditRepository userRepository;

    @Autowired // inject dependency and function from EmailService
    private EmailService notificationService;

    @PostMapping(path = "/reset-password")
    public Map<String, Object> getResetToken(@RequestParam(value = "email") String email){
        Map<String, Object> usermap = new HashMap<>(); // create new map for json
        Optional<UserEdit> userlist = userRepository.findByEmail(email);

        UserEdit user = userlist.get();

        if (!user.getEmail().isEmpty()){
            UUID randPass = UUID.randomUUID();
            String code = Long.toString(randPass.getMostSignificantBits(), 36).replaceAll("-","");
            user.setResettoken(code);
            userRepository.save(user);

//        ----------------------------------

            String message  = "Reset password!";

            String nama     = user.getF_nama()+ " " +user.getL_nama();

//        ----------------------------------

            try {
                notificationService.prepareResetMail(user.getEmail(), message, code, nama);
            } catch (MailException mailException) {
                usermap.put("error", true);
                usermap.put("message", "Send reset password failed");
                usermap.put("status", "FAIL");
            }

        } else {
            usermap.put("error", true);
            usermap.put("message", "Email tidak tersedia");
            usermap.put("status", "FAIL");
        }
        return usermap;
    }
}
