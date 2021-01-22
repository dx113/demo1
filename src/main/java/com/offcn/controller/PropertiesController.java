package com.offcn.controller;

import com.offcn.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PropertiesController {

    @Value("${user.username}")
     String username;

    @Value("${user.age}")
     Integer age;

    @Autowired
     Student student;

    @RequestMapping("/value")
    public String showValue(){
        return "username:"+ username +"age:"+age;
    }
    @RequestMapping("/showStudent")
    public String showStudent(){
        return student.toString();
    }

}
