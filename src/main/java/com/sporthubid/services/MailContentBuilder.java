package com.sporthubid.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class MailContentBuilder {

    private TemplateEngine templateEngine;

    @Autowired
    public MailContentBuilder(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    public String build(String message, Long id_ver, String nama) {
        Context context = new Context();
        context.setVariable("id_ver", id_ver);
        context.setVariable("nama", nama);
        context.setVariable("message", message);
        final String htmlContent = templateEngine.process("mailTemplate", context);
        return htmlContent;
    }

}
