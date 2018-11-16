package com.sporthubid.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;


@Service
public class EmailService {

    /*
     * The Spring Framework provides an easy abstraction for sending email by using
     * the JavaMailSender interface, and Spring Boot provides auto-configuration for
     * it as well as a starter module.
     */
    private JavaMailSender javaMailSender;

    /**
     *
     * @param javaMailSender
     */
    @Autowired
    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Autowired
    private MailContentBuilder mailContentBuilder;

    public void prepareAndSend(String mailto, String message, Long id_ver, String nama) {
        MimeMessagePreparator messagePreparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setFrom("ikhsan15fauji@gmail.com");
            messageHelper.setTo(mailto);
            messageHelper.setSubject("Sample mail subject");
            String content = mailContentBuilder.build(message, id_ver, nama);
            messageHelper.setText(content, true);
        };

        try {
            javaMailSender.send(messagePreparator);
        } catch (MailException e) {
            // runtime exception; compiler will not force you to handle it
            e.printStackTrace();
        }
    }


}
