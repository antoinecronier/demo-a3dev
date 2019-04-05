package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    @RequestMapping
    public String genericRedirection() {
        return "redirect:/index";
    }
    
    @RequestMapping(value = {"/","/index"}, method = {RequestMethod.GET})
    public String index() {
        return "/index";
    }
    
    @RequestMapping(value = {"/toto","/toto/toto"}, method = {RequestMethod.GET})
    public String index1() {
        return "/index1";
    }
}
