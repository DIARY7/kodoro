package com.kodoro.kodoro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kodoro.kodoro.dto.ResultTabUsuel;
import com.kodoro.kodoro.dto.VolumeReste;
import com.kodoro.kodoro.model.Usuel;
import com.kodoro.kodoro.repository.BlocRepository;
import com.kodoro.kodoro.repository.MvtStockUsuelRepo;
import com.kodoro.kodoro.repository.UsuelRepository;


@Controller
public class ResultTrans {

    @Autowired
    MvtStockUsuelRepo mvtURepo;

    @Autowired
    UsuelRepository uRepo;

    @Autowired
    BlocRepository blocRepo;
    
    @GetMapping("/result-trans")
    public ModelAndView toTab() {
        ModelAndView mv = new ModelAndView("template");
        Usuel usuel = uRepo.findMaxBenefice();
        /* Aleo le indice 0 ihany alony no raisina eto */
        List<VolumeReste> volumesReste = blocRepo.findVolumeReste();
        double nombre = (int) ( volumesReste.get(0).getVolume() / usuel.getVolume());
        
        /* Minimum de perte */
        List<Usuel> listeUsuels = uRepo.findAll();
        double perte = Double.MAX_VALUE;
        Usuel uMinPerte = null;
        double nbuMinPerte = 0;
        for (int i = 0; i < listeUsuels.size() ; i++) {
            double nbPossible = (int) (volumesReste.get(0).getVolume() / listeUsuels.get(i).getVolume());
            double volume = nbPossible*listeUsuels.get(i).getVolume();
            double tempPerte = volumesReste.get(0).getVolume() - volume;
            if (tempPerte<perte) {
                uMinPerte = listeUsuels.get(i);
                perte = tempPerte;
                nbuMinPerte = nbPossible;
            }
        }
        
        /*------------------- */
        mv.addObject("page", "pages/resultat-trans");
        mv.addObject("tabUsuel", mvtURepo.getResultTabUsuel());
        mv.addObject("volReste", volumesReste.get(0).getVolume()); 
        mv.addObject("tabMaxBenef", new ResultTabUsuel(usuel.getDesignation(), nombre, ( (nombre * usuel.getVolume()) / volumesReste.get(0).getVolume()) * volumesReste.get(0).getPrixRevient() , nombre*volumesReste.get(0).getVolume(),volumesReste.get(0).getVolume() - (nombre * usuel.getVolume()) ));
        mv.addObject("tabMinPerte", new ResultTabUsuel(uMinPerte.getDesignation(), nbuMinPerte,  ((nbuMinPerte * uMinPerte.getVolume()) / volumesReste.get(0).getVolume()) * volumesReste.get(0).getPrixRevient() , nbuMinPerte*volumesReste.get(0).getVolume(), volumesReste.get(0).getVolume() - (nbuMinPerte * uMinPerte.getVolume()) ));  
        return mv;
    }
    
}
