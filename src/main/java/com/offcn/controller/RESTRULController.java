package com.offcn.controller;

import com.offcn.pojo.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/user")
public class RESTRULController {

    private Collection<User> users = Collections.synchronizedCollection(new ArrayList<User>());
    {
        users.add(new User(2001l,"小白",10));
        users.add(new User(2002l,"小黑",23));
        users.add(new User(2003l,"小红",56));
        users.add(new User(2004l,"小蓝",43));

    }
    @GetMapping("/")
    public Collection<User> findAll(){
        return users;
    }
    @GetMapping("/{id}")
    public User findOne(@PathVariable("id") Long id){
        for(User user :users){
            if(user.getId()==id){
                return user;
            }
        }
        return  null;
    }
    @PostMapping("/")
    public String save(User user){
        users.add(user);
        return "添加成功";
    }
    @PutMapping("/{id}")
    public String update(@PathVariable("id") Long id,User user){
       for(User user1:users){
           if(user1.getId().equals(id)){
               user1.setName(user.getName());
               user1.setAge(user.getAge());
           }
       }
       return "修改成功";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id){
        User user = findOne(id);
        users.remove(user);
        return "删除成功";
    }
}
