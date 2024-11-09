package com.kodoro.kodoro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.servlet.ModelAndView;


@Controller
public class Acceuil {
    @GetMapping("/")
    public ModelAndView acceuil() {
        System.out.println("COUCOUUUUUUUU");
        ModelAndView mv = new ModelAndView("template");
        mv.addObject("page", "Acceuil");
        return mv;
    }
    
}
