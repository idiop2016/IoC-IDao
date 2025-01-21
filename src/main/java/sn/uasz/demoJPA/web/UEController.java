package sn.uasz.demoJPA.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sn.uasz.demoJPA.entities.UE;
import sn.uasz.demoJPA.repositories.UERepository;

import java.util.List;

@Controller
public class UEController {

    @Autowired
    private UERepository ueRepository;

    @GetMapping("/ue/index")
    public String index(Model model) {
        List<UE> ueList = ueRepository.findAll();
        model.addAttribute("listeUE", ueList);
        return "ue/index"; 
    }

    @GetMapping("/ue/{id}")
    public String getUE(@PathVariable Long id, Model model) {
        UE ue = ueRepository.findById(id).orElse(null);
        model.addAttribute("ue", ue);
        return "ue/detail"; 
    }

    @PostMapping("/ue")
    public String createUE(@ModelAttribute UE ue) {
        ueRepository.save(ue);
        return "redirect:/ue/index";
    }

    @PostMapping("/ue/{id}")
    public String updateUE(@PathVariable Long id, @ModelAttribute UE ue) {
        ue.setId(id);
        ueRepository.save(ue);
        return "redirect:/ue/index";
    }

    @GetMapping("/ue/delete/{id}")
    public String deleteUE(@PathVariable Long id) {
        ueRepository.deleteById(id);
        return "redirect:/ue/index";
    }
}