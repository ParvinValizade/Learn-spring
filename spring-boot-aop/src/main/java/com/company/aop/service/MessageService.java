package com.company.aop.service;

import org.springframework.stereotype.Service;

@Service
public class MessageService {

   public String messageSend(String param){
       System.out.println("method sent message param:" + param);
        return param;
    }
}
