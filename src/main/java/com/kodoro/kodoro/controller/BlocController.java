package com.kodoro.kodoro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kodoro.kodoro.model.Bloc;
import com.kodoro.kodoro.repository.BlocRepository;


@Controller
public class BlocController {
    
    @Autowired
    BlocRepository blocRepo;

    @GetMapping("/bloc/new")
    public ModelAndView toFormBloc(@RequestParam(required=false) String message) {
        ModelAndView mv = new ModelAndView("template");
        mv.addObject("page", "pages/insert-bloc");
        if(message!=null){
            mv.addObject("message", message);
        }
        return mv;
    }

    @PostMapping(value="/bloc/insert",consumes = "application/x-www-form-urlencoded")
    public String insertBloc(@ModelAttribute Bloc bloc) {
        String message=null;
        try {
            blocRepo.save(bloc);
            message="INSERTION%20bloc%20REUSSI";    
        } catch (Exception e) {
            // TODO: handle exception
            message = e.getMessage();
            e.printStackTrace();
        }
        return "redirect:/bloc/new?message="+message;
        
    }
    // @PostMapping(value = "/bloc/update")
    // public String updateRevient(@RequestParam double prixRevient , @RequestParam int id ) {
    //     Bloc mere = (Bloc) blocRepo.findById(id).orElseThrow(()->new RuntimeException("Bloc non trouvé") );
    //     double coeff = (mere.getPrixRevient() / prixRevient);
    //     List<Bloc> filles = blocRepo.getFilles(mere.getId());
    //     while (true) {
    //         for (int i = 0; i < filles.size() ; i++) {
                
    //         }
    //     }
    //     return "redirect:/bloc/new_update";
    // }

    @GetMapping("/bloc/new_update")
    public String toFormRevient() {
        ModelAndView mv = new ModelAndView("template");
        mv.addObject("page", "pages/update_prix_revient");

        return "";
    }
    
    
}
