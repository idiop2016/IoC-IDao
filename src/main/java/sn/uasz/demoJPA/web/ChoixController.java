package sn.uasz.demoJPA.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sn.uasz.demoJPA.entities.Choix;
import sn.uasz.demoJPA.repositories.ChoixRepository;

import java.util.List;

@Controller
public class ChoixController {

    @Autowired
    ChoixRepository choixRepository;

    @GetMapping("/choix/index")
    public String index(Model model){
        List<Choix> choixList = choixRepository.findAll();
        model.addAttribute("listeChoix", choixList);
        return "choix/index"; 
    }

    @GetMapping("/choix/{id}")
    public String getChoix(@PathVariable Long id, Model model){
        Choix choix = choixRepository.findById(id).orElse(null);
        model.addAttribute("choix", choix);
        return "choix/detail"; 
    }

    @PostMapping("/choix")
    public String createChoix(@ModelAttribute Choix choix){
        choixRepository.save(choix);
        return "redirect:/choix/index";
    }

    @PostMapping("/choix/{id}")
    public String updateChoix(@PathVariable Long id, @ModelAttribute Choix choix){
        choix.setId(id);
        choixRepository.save(choix);
        return "redirect:/choix/index";
    }

    @GetMapping("/choix/delete/{id}")
    public String deleteChoix(@PathVariable Long id){
        choixRepository.deleteById(id);
        return "redirect:/choix/index";
    }
}