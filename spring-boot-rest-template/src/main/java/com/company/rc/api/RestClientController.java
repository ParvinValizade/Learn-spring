package com.company.rc.api;

import com.company.rc.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
@RequestMapping("/test")
public class RestClientController {

    private static final String webUrl = "http://localhost:8080/user";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public ResponseEntity<List<UserDto>> getUserList(){
       ResponseEntity<List> result =  restTemplate.getForEntity(webUrl,List.class);
          List<UserDto> responseBody =  result.getBody();
          return ResponseEntity.ok(responseBody);
    }

    @PostMapping
    public ResponseEntity<UserDto> save(@RequestBody UserDto userDto) {
        ResponseEntity<UserDto> result = restTemplate.postForEntity(webUrl,userDto,UserDto.class);
        UserDto responseBody = result.getBody();
        return ResponseEntity.ok(responseBody);
    }
}
