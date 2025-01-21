package sn.uasz.demoJPA.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sn.uasz.demoJPA.entities.Etudiant;
import sn.uasz.demoJPA.repositories.EtudiantRepository;

import java.util.List;

@Controller
public class EtudiantController {

    @Autowired
    private EtudiantRepository etudiantRepository;

    @GetMapping("/etudiant/index")
    public String index(Model model) {
        List<Etudiant> etudiantList = etudiantRepository.findAll();
        model.addAttribute("listeEtudiants", etudiantList);
        return "etudiant/index"; 
    }

    @GetMapping("/etudiant/{id}")
    public String getEtudiant(@PathVariable Long id, Model model) {
        Etudiant etudiant = etudiantRepository.findById(id).orElse(null);
        model.addAttribute("etudiant", etudiant);
        return "etudiant/detail"; 
    }

    @PostMapping("/etudiant")
    public String createEtudiant(@ModelAttribute Etudiant etudiant) {
        etudiantRepository.save(etudiant);
        return "redirect:/etudiant/index";
    }

    @PostMapping("/etudiant/{id}")
    public String updateEtudiant(@PathVariable Long id, @ModelAttribute Etudiant etudiant) {
        etudiant.setId(id);
        etudiantRepository.save(etudiant);
        return "redirect:/etudiant/index";
    }

    @GetMapping("/etudiant/delete/{id}")
    public String deleteEtudiant(@PathVariable Long id) {
        etudiantRepository.deleteById(id);
        return "redirect:/etudiant/index";
    }
}