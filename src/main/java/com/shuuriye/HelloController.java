package com.shuuriye;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

//@RestController
@Controller
public class HelloController {
    @GetMapping("/")
   public String greeting(Model model){
        model.addAttribute("name", "Abdirahman");
        model.addAttribute("paragraph" , "jamhuriya university!");
        return "hello"; // view name
    }
    @GetMapping("/hello")
    public String sayHello(Model model){
        model.addAttribute("name", "Mr Mohamed");
         return "Hello";  //view name
    }

}
