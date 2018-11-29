package com.sporthubid.controllers.auth;

import com.sporthubid.models.User;
import com.sporthubid.models.UserEdit;
import com.sporthubid.repository.UserEditRepository;
import com.sporthubid.repository.UserRepository;
import com.sporthubid.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin
public class ResetPassword {

    @Autowired
    UserEditRepository userEditRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired // inject dependency and function from EmailService
    private EmailService notificationService;

    @PostMapping(path = "/create-new-password")
    public Map<String, Object> getResetToken(@Valid @RequestBody UserEdit ue){
        Map<String, Object> usermap = new HashMap<>(); // create new map for json
        Optional<UserEdit> userlist = userEditRepository.findByEmail(ue.getEmail());

        UserEdit user = userlist.get();

        if (!user.getEmail().isEmpty()){
            UUID randPass = UUID.randomUUID();
            String code = Long.toString(randPass.getMostSignificantBits(), 36).replaceAll("-","");
            user.setResettoken(code);
            userEditRepository.save(user);

//        ----------------------------------

            String message  = "Reset password!";
            String nama     = user.getF_nama();

//        ----------------------------------

            try {
                notificationService.prepareResetMail(user.getEmail(), message, code, nama);
                usermap.put("error", false);
                usermap.put("message", "Send reset password successfull");
                usermap.put("status", "Ok");
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

    @PostMapping(path = "/reset-password")
    public Map<String, Object> verifyUser(@Valid @RequestBody User userEdit){
        Map<String, Object> updatemap = new HashMap<>();

        Optional<User> opUser = userRepository.findByEmailAndResettoken(userEdit.getEmail(), userEdit.getResettoken());

            User user = opUser.get();
            if (user != null || !user.getEmail().isEmpty()){
                UUID rand = UUID.randomUUID();
                String token = Long.toString(rand.getMostSignificantBits(), 36).replaceAll("-","");
                user.setPassword(userEdit.getPassword());
                user.setResettoken(token);
                userRepository.save(user);

                updatemap.put("status", "Ok");
                updatemap.put("message", "Reset password berhasil");
                updatemap.put("error", null);
            } else {
                updatemap.put("status", "Ok");
                updatemap.put("message", "Token expired");
                updatemap.put("error", true);
            }

        return updatemap;
    }
}
