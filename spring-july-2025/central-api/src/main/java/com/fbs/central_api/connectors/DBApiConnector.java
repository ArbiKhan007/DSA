package com.fbs.central_api.connectors;

import com.fbs.central_api.models.AppUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/*
    Purpose of this class is to connect with the db api endpoints.
 */
@Component
@Slf4j
public class DBApiConnector {

    @Value("${db.api.url}")
    String dbApiBaseUrl; // For this variable pick the value for application.properties

    public AppUser callCreateUserEndpoint(AppUser user){
        log.info("Inside callCreateUserEndpoint method with user object: " + user.toString());
        //1. Create URL that you want to call
        String url = dbApiBaseUrl + "/user/create";
        //2. We want to tell what rest method we want to use and what request body we want to pass
        RequestEntity request = RequestEntity.post(url).body(user);
        log.info("Created request : " + request.toString());
        //3. Hit or make the request on post to do this step we click sendbutton
        // but here we are going to use a class called RestTemplate
        RestTemplate restTemplate = new RestTemplate();
        // Send Button(Postman) -> Resttemplate class exchange method
        log.info("Calling dbApi create user endpoint");
        ResponseEntity<AppUser> response = restTemplate.exchange(url, HttpMethod.POST, request, AppUser.class);
        log.info("Respose: " + response.toString());
        return response.getBody();
    }

}
