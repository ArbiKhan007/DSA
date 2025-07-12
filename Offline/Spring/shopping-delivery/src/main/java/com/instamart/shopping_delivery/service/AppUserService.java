package com.instamart.shopping_delivery.service;

import com.instamart.shopping_delivery.exceptions.InvalidOperationException;
import com.instamart.shopping_delivery.exceptions.UserNotExistException;
import com.instamart.shopping_delivery.models.AppUser;
import com.instamart.shopping_delivery.repositories.AppUserRepository;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.Properties;
import java.util.UUID;

@Service
public class AppUserService {

   AppUserRepository appUserRepository;

   @Autowired
   public AppUserService(AppUserRepository appUserRepository){
       this.appUserRepository = appUserRepository;
   }

   public AppUser registerCustomer(AppUser customer){
       return appUserRepository.save(customer);
   }

   public AppUser wareHouseAdminInvite(UUID userId, AppUser wareHouseAdmin){
       // 1. First verify user who is inviting is of type appadmin or not.
       AppUser admin = appUserRepository.findById(userId).orElse(null);
       if(admin == null){
           // Throw exception that user does not exist
           throw new UserNotExistException(String.format("User with id %s does not exist", userId.toString()));
       }
       if(!admin.getUserType().equals("APP_ADMIN")){
           throw new InvalidOperationException("User is not allowed to invite warehosue admim");
       }
       wareHouseAdmin.setStatus("INACTIVE");
       this.sendInvitationMail(wareHouseAdmin);
       return appUserRepository.save(wareHouseAdmin);
   }

   public void sendInvitationMail(AppUser wareHouseAdmin){
       JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
       javaMailSender.setHost("smtp.gmail.com");
       javaMailSender.setPort(587);
       javaMailSender.setUsername("accioshoppingwebsite@gmail.com");
       javaMailSender.setPassword("relcfdwhahhcvokv");
       Properties props = javaMailSender.getJavaMailProperties();
       props.put("mail.smtp.auth", "true");
       props.put("mail.smtp.starttls.enable", "true");
       // Mime message ke andar hum mail ka content set karte hai
       MimeMessage mimeMessage = javaMailSender.createMimeMessage();
       // Mime message ke andar bhi hum directly content set nahi kar sakte hume banana hota hai mimeMessage helper
       MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
       try{
           mimeMessageHelper.setTo(wareHouseAdmin.getEmail());
           mimeMessageHelper.setSubject("Invitation to our swiggy platform as warehouse amdin");
           mimeMessageHelper.setText("Hey " + wareHouseAdmin.getName());
       }catch (Exception e){

       }

       javaMailSender.send(mimeMessage);
   }
}
