package com.sporthubid.services;

import com.sporthubid.models.Email;
import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;


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

    /**
     * This function is used to send mail without attachment.
     * @param user
     * @throws MailException
     */

    public void sendEmail(Email user) throws MailException {

        /*
         * This JavaMailSender Interface is used to send Mail in Spring Boot. This
         * JavaMailSender extends the MailSender Interface which contains send()
         * function. SimpleMailMessage Object is required because send() function uses
         * object of SimpleMailMessage as a Parameter
         */

        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(user.getEmailAddress());
        mail.setFrom("ikhsan15fauji@gmail.com");
        mail.setSubject("Testing Mail API");
        mail.setText("Hurray ! You have done that dude...");

        /*
         * This send() contains an Object of SimpleMailMessage as an Parameter
         */
        javaMailSender.send(mail);
    }

    /**
     * This fucntion is used to send mail that contains a attachment.
     *
     * @param user
     * @throws MailException
     * @throws MessagingException
     */
    public void sendEmailWithAttachment(Email user) throws MailException, MessagingException, javax.mail.MessagingException {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        helper.setTo(user.getEmailAddress());
        helper.setSubject("Testing Mail API with Attachment");
        helper.setText("Please find the attached document below.");

        FileSystemResource file = new FileSystemResource("C:\\Users\\uswa15\\Downloads\\Documents\\FlowDiagramComunity.pdf");
        helper.addAttachment(file.getFilename(), file);

        javaMailSender.send(mimeMessage);
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
