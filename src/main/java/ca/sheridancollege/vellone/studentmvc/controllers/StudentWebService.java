package ca.sheridancollege.vellone.studentmvc.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/StudentAPI")
public class StudentWebService {

    @RequestMapping("greeting")
    public String sayHelloAll(){
        return ("Hello Everyone");
    }
}
