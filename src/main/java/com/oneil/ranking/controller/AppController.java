package com.oneil.ranking.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
 
@Controller
@EnableAutoConfiguration
public class AppController {
 
    @RequestMapping("/")
    String home(ModelMap modal) {
        modal.addAttribute("title","Rank Example");
        return "index";
    }
 
    @RequestMapping("/partials/{page}")
    String partialHandler(@PathVariable("page") final String page) {
        return page;
    }
 
}