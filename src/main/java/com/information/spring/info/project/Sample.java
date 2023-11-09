package com.information.spring.info.project;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Sample {

    @RequestMapping("/check/sample")
    public String sample(){
        return "SpringBoot Application Runs Well";
    }
}
