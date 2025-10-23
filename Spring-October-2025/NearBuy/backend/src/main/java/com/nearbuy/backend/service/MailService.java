package com.nearbuy.backend.service;

import com.nearbuy.backend.models.User;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.util.Properties;

@Service
public class MailService {

    @Autowired
    public MailService(){

    }

    public JavaMailSender getJavMailSender(){
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        // As our api is going to send email
        // So, We need to configure emailId details in javamailsender object
        javaMailSender.setHost("smtp.gmail.com");
        javaMailSender.setPort(587); // genrally to send mail from our computer we require some port number so, the port number which we will use is 587
        javaMailSender.setUsername("arbikhan.008@gmail.com\n");// We will be sending email so, by what email our spring application will send mail to the users
        javaMailSender.setPassword("qnbxqafzugensoho"); // Password of the email.... It is app password, not actual password
        Properties props = javaMailSender.getJavaMailProperties();
        props.put("mail.smtp.auth", "true"); // Our springboot api will connect gmail to send email via password so, mail.smtp.auth is true
        props.put("mail.smtp.starttls.enable", "true"); // This property we are setting for secure connection
        return javaMailSender;
    }

    public TemplateEngine getTemplateEngine(){
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setPrefix("templates/"); // Make sure this folder exists in resources
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode("HTML");
        templateResolver.setCharacterEncoding("UTF-8");
        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
        return templateEngine;
    }

    public void sendInvitationEmailToAdmin(User admin, User maint) throws MessagingException {
        // To sendEmail we require javamailsender object.
        // MimeMessage -> We will create a object of this class and we will set all our mail content in this class.
        JavaMailSender javaMailSender = getJavMailSender();
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
        // Whom i want to send the mail ? So, We need to set To
        mimeMessageHelper.setTo(admin.getEmail());
        String acceptLink = "http://localhost:8080/api/v1/accept?us"+admin.getId();
        mimeMessageHelper.setSubject("NewBuy Admin Invitation");

        // To set the values for variables which we have defined inside the email template we use context library
        Context context = new Context();
        context.setVariable("adminName", admin.getName());
        context.setVariable("invitedByName", maint.getName());
        context.setVariable("invitedByEmail", maint.getEmail());
        context.setVariable("acceptLink" , acceptLink);
        context.setVariable("rejectLink", "https://www.google.com/");
        TemplateEngine templateEngine = getTemplateEngine();
        String htmlTemplate = templateEngine.process("admin-invitation-template", context);
        mimeMessageHelper.setText(htmlTemplate, true);
        javaMailSender.send(mimeMessage);
    }
}
