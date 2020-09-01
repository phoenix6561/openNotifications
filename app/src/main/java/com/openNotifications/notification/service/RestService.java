package com.openNotifications.notification.service;

import android.content.Context;

import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class RestService {

    Context context;

    public RestService(Context context){

        this.context = context;
    }

    public String checkRestEndpoint(String url , String request){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
        String result = restTemplate.getForObject("https://ajax.googleapis.com/ajax/" +
                "services/search/web?v=1.0&q={query}", String.class, request );

        return result;
    }


}
