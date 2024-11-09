package com.kodoro.kodoro.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.kodoro.kodoro.model.Bloc;
import com.kodoro.kodoro.model.Fabrication;
import com.kodoro.kodoro.model.Usuel;
import com.kodoro.kodoro.repository.BlocRepository;
import com.kodoro.kodoro.repository.FabricationRepository;
import com.kodoro.kodoro.repository.UsuelRepository;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class TransRestControlleur {
    @Autowired
    FabricationRepository fabRepo;

    @Autowired
    UsuelRepository usuelRepo;

    @Autowired
    BlocRepository blocRepo;

    // @PostMapping("transform/insert")
    // public String insertTransformation(@RequestParam String idBloc , @RequestParam double longueur,@RequestParam double largeur,@RequestParam double hauteur,@RequestParam LocalDate daty,HttpServletRequest request) throws Exception {
    //     try {
    //         Map<String, String[]> parameterMap = request.getParameterMap();
    //         ArrayList<Fabrication> listeFab = new ArrayList<>();
    //         Bloc bloc = blocRepo.findById(idBloc).orElseThrow(()->new RuntimeException("Bloc non trouvé") );
    //         for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
    //             String paramName = entry.getKey();
    //             if (paramName.startsWith("usuel")) {
    //                 String idUsuel = request.getParameter(paramName);
    //                 Usuel usuel = usuelRepo.findById(idUsuel).orElseThrow(() -> new RuntimeException("Usuel non trouvé"));             
    //                 Fabrication fab = new Fabrication();
    //                 fab.setBloc(bloc);
    //                 fab.setUsuel(usuel);
    //                 fab.setId(Fabrication.generateNextId());
    //                 fab.setDaty(daty);
    //                 listeFab.add(fab);
    //             }
    //         }
    //         fabRepo.saveAll(listeFab);
            
    //     } catch (Exception e) {
    //         return e.getMessage();
    //     }
    //     return "Produit fabriqué";
    // }
    
}
