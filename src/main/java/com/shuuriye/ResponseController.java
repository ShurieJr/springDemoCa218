package com.shuuriye;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ResponseController {
    @GetMapping("/ok")
    public ResponseEntity getOk(){
        //200 status code
        return ResponseEntity.ok().body("ok!");
    }

    @GetMapping("/notfound")
    public ResponseEntity getNotFound(){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not found!");
    }
    @GetMapping("/unauthorized")
    public ResponseEntity getUnauthorized(){
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @GetMapping("/withHeaders")
    public ResponseEntity getWithHeaders(){
        HttpHeaders header = new HttpHeaders();
        header.add("custom-message" , "with-headers");
        return ResponseEntity.status(HttpStatus.ACCEPTED).headers(header).body("with-headers Example");
    }

    @GetMapping("/error")
    public ResponseEntity<Map<String , String>> getError(){
        Map<String , String> errorDetials = new HashMap<>();
        errorDetials.put("error", "something went wrong");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorDetials);
    }
}
