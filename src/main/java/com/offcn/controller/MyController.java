package com.offcn.controller;

import com.offcn.pojo.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MyController {
    @RequestMapping("/test")
    public String test(){
        return "this is mycontroller";
    }
    @RequestMapping("/findOne")
    public Student findOne(@RequestParam(value = "iid") int id){
        return new Student(id,"猪",10);
    }
    @RequestMapping("/findPath/{id}")
    public Student findPath(@PathVariable(name = "id") int id){
        return new Student( id,"小黑",10);
    }
    @RequestMapping("/findObj")
    public Student findObj(@RequestBody Student student){
        return  student;
    }
    @RequestMapping("/findAll")
    public List<Student> findAll(){
        List<Student> list = new ArrayList<Student>();
        for(int i =0;i<10;i++){
            list.add(new Student(i,"小白"+i,10+i));
        }
        return list;
    }
}
