package com.kodoro.kodoro.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kodoro.kodoro.model.Bloc;
import com.kodoro.kodoro.model.Constantes;
import com.kodoro.kodoro.model.Fabrication;
import com.kodoro.kodoro.model.MvtStockUsuel;
import com.kodoro.kodoro.model.Usuel;
import com.kodoro.kodoro.repository.BlocRepository;
import com.kodoro.kodoro.repository.FabricationRepository;
import com.kodoro.kodoro.repository.MvtStockUsuelRepo;
import com.kodoro.kodoro.repository.UsuelRepository;

import jakarta.servlet.http.HttpServletRequest;


@Controller
public class TransController {
    @Autowired
    FabricationRepository fabRepo;
    
    @Autowired
    UsuelRepository usuelRepo;

    @Autowired
    BlocRepository blocRepo;

    @Autowired
    MvtStockUsuelRepo mvtSeRepo;

    @GetMapping("/transformation/new")
    public ModelAndView toForm(@RequestParam(required=false) String message) {
        ModelAndView mv = new ModelAndView("template");
        mv.addObject("page", "pages/transformation");
        mv.addObject("usuel", usuelRepo.findAll());
        mv.addObject("blocDispo", blocRepo.findBlocsNotInFabrication());
        if (message!=null) {
            mv.addObject("message", message);
        }

        return mv;
    }
    

    @PostMapping("transform/insert")
    public String insertTransformation(@RequestParam int idBloc , @RequestParam double longueur,@RequestParam double largeur,@RequestParam double hauteur,@RequestParam LocalDate daty,HttpServletRequest request) throws Exception {
        try {
            System.out.println("L'indice bloc est "+idBloc);
            Map<String, String[]> parameterMap = request.getParameterMap();
            ArrayList<Fabrication> listeFab = new ArrayList<>();
            Bloc bloc = blocRepo.findById(idBloc).orElseThrow(()->new RuntimeException("Bloc non trouvé") );
            Bloc reste = new Bloc(longueur, largeur, hauteur);
            double totalVolume = reste.getVolume();
        
            for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
                String paramName = entry.getKey();
                if (paramName.startsWith("usuel")) {
                    int idUsuel = Integer.parseInt(paramName.split("usuel")[1]) ;
                    Usuel usuel = usuelRepo.findById(idUsuel).orElseThrow(() -> new RuntimeException("Usuel non trouvé"));             
                    totalVolume += (usuel.getVolume() * Integer.parseInt(request.getParameter(paramName)));
                    /* Mi check raha efa trop  */
                    bloc.checkDebordement(totalVolume);
                    Fabrication fab = new Fabrication();
                    fab.setBloc(bloc);
                    fab.setUsuel(usuel);
                    fab.setDaty(daty);
                    fab.setQuantite(Integer.parseInt(request.getParameter(paramName)));
                    listeFab.add(fab);
                }
            }
            bloc.checkDebordement(totalVolume);
            
            if (totalVolume < bloc.getValuePercentMarge()) {
                throw new Exception("Ne depasse pas la marge");
            }
            
            /* reste */
            reste.setOrigine(bloc); /* tonga dia mi calcule prix revient ato */
            reste.setDaty(daty);
            blocRepo.save(reste);
            //Fabrication
            List<Fabrication> savedFabrications = fabRepo.saveAll(listeFab);
            //MvtStockUsuel
            ArrayList<MvtStockUsuel> listeMvt = new ArrayList<>();
            for (int i = 0; i < savedFabrications.size(); i++) {
                listeMvt.add(new MvtStockUsuel(savedFabrications.get(i)));
            }
            System.err.println("La listes des StockUsuel ");
            mvtSeRepo.saveAll(listeMvt);

        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/transformation/new?message="+e.getMessage();
        }
        return "redirect:/transformation/new?message=Insertion%20reussi";
    }
    
}
