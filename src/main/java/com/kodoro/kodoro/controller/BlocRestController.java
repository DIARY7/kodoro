package com.kodoro.kodoro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kodoro.kodoro.model.Bloc;
import com.kodoro.kodoro.repository.BlocRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class BlocRestController {
    @Autowired
    BlocRepository blocRepo;


    // @PostMapping("/bloc/insert")
    // public String insertBloc(@RequestBody Bloc bloc) {
    //     String message="";
    //     try {
    //         blocRepo.save(bloc);
    //         message="INSERTION REUSSI 👌";    
    //     } catch (Exception e) {
    //         // TODO: handle exception
    //         message = e.getMessage();
    //     }
    //     return message;
        
    // }
    
}
