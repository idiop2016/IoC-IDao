package sn.uasz.demoJPA.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sn.uasz.demoJPA.entities.Enseignement;
import sn.uasz.demoJPA.repositories.EnseignementRepository;

import java.util.List;

@Controller
public class EnseignementController {

    @Autowired
    private EnseignementRepository enseignementRepository;

    @GetMapping("/enseignement/index")
    public String index(Model model) {
        List<Enseignement> enseignementList = enseignementRepository.findAll();
        model.addAttribute("listeEnseignements", enseignementList);
        return "enseignement/index"; 
    }

    @GetMapping("/enseignement/{id}")
    public String getEnseignement(@PathVariable Long id, Model model) {
        Enseignement enseignement = enseignementRepository.findById(id).orElse(null);
        model.addAttribute("enseignement", enseignement);
        return "enseignement/detail"; 
    }

    @PostMapping("/enseignement")
    public String createEnseignement(@ModelAttribute Enseignement enseignement) {
        enseignementRepository.save(enseignement);
        return "redirect:/enseignement/index";
    }

    @PostMapping("/enseignement/{id}")
    public String updateEnseignement(@PathVariable Long id, @ModelAttribute Enseignement enseignement) {
        enseignement.setId(id);
        enseignementRepository.save(enseignement);
        return "redirect:/enseignement/index";
    }

    @GetMapping("/enseignement/delete/{id}")
    public String deleteEnseignement(@PathVariable Long id) {
        enseignementRepository.deleteById(id);
        return "redirect:/enseignement/index";
    }
}