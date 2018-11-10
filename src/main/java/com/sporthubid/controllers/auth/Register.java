package com.sporthubid.controllers.auth;

import com.sporthubid.models.Email;
import com.sporthubid.models.User;
import com.sporthubid.repository.UserRepository;
import com.sporthubid.services.EmailService;
import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
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


    @Autowired
    private EmailService notificationService;

    @Autowired
    private Email user;


    @RequestMapping(value = "/sendemail")
    public String send() {

        /*
         * Creating a User with the help of User class that we have declared and setting
         * Email address of the sender.
         */
        user.setEmailAddress("ikhsan3f@gmail.com");
        /*
         * Here we will call sendEmail() for Sending mail to the sender.
         */
        try {
            notificationService.sendEmail(user);
        } catch (MailException mailException) {
            System.out.println(mailException);
        }
        return "Congratulations! Your mail has been send to the user.";
    }

    /**
     *
     * @return
     * @throws MessagingException
     */
    @RequestMapping("/send-mail-attachment")
    public String sendWithAttachment() throws MessagingException {

        /*
         * Creating a User with the help of User class that we have declared and setting
         * Email address of the sender.
         */
        user.setEmailAddress("ikhsan3f@gmail.com");

        /*
         * Here we will call sendEmailWithAttachment() for Sending mail to the sender
         * that contains a attachment.
         */
        try {
            notificationService.sendEmailWithAttachment(user);
        } catch (MailException mailException) {
            System.out.println(mailException);
        } catch (javax.mail.MessagingException e) {
            e.printStackTrace();
        }
        return "Congratulations! Your mail has been send to the user.";
    }

    @RequestMapping("/send-mail-html")
    public String shouldSendMail() throws Exception {
        //given
        String recipient = "ikhsan3f@gmail.com";
        String message = "Verifikai";
        //when
        try {
            notificationService.prepareAndSend(recipient, message);
        } catch (MailException mailException) {
            System.out.println(mailException);
        }
        return "Congratulations! Your mail has been send to the user.";
    }


    @RequestMapping("/verify")
    public String verify(){
        return "Verify Page";
    }

}
