package com.naukri.central_api.connectors;


import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


public class RestAPI {
    // makeGetCall , makePostCall, makePutCall, makeDeleteCall


    public Object  makePostCall(String url, Object body){
        RequestEntity request = RequestEntity.post(url).body(body);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity response = restTemplate.exchange(url, HttpMethod.POST, request, Object.class);
        return response.getBody();
    }
}
