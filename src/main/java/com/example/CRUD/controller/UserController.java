package com.example.CRUD.controller;

import com.example.CRUD.model.User;
import com.example.CRUD.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class UserController {


    @Autowired
    private UserService userserviceobj;


    @GetMapping("/")
    public String open(Model mod) {
        mod.addAttribute("userobj", new User());
        return "register";
    }

    @PostMapping("/new")
    public String newdeatil(@ModelAttribute("userobj") User user, Model mod) {
        userserviceobj.create(user);
        mod.addAttribute("users", userserviceobj.Read());
        return "success";
    }

    @GetMapping("/del/{id}")
    public String delete(@PathVariable("id") Long id, Model mod) {
        userserviceobj.deleteById(id);
        mod.addAttribute("users", userserviceobj.Read());
        return "success";

    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id")Long id, Model mod)
    {
        mod.addAttribute("users",userserviceobj.getById(id).get());
        return "edit";
    }
    @PostMapping("/update/{id}")
    public  String update(@PathVariable Long id,@ModelAttribute User user,Model mod)
    {
        userserviceobj.create(user);
        mod.addAttribute("users",userserviceobj.Read());
        return "success";
    }







}
