package sn.uasz.demoJPA.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sn.uasz.demoJPA.entities.EC;
import sn.uasz.demoJPA.repositories.ECRepository;

import java.util.List;

@Controller
public class ECController {

    @Autowired
    private ECRepository ecRepository;

    @GetMapping("/ec/index")
    public String index(Model model) {
        List<EC> ecList = ecRepository.findAll();
        model.addAttribute("listeEC", ecList);
        return "ec/index"; 
    }

    @GetMapping("/ec/{id}")
    public String getEC(@PathVariable Long id, Model model) {
        EC ec = ecRepository.findById(id).orElse(null);
        model.addAttribute("ec", ec);
        return "ec/detail"; 
    }

    @PostMapping("/ec")
    public String createEC(@ModelAttribute EC ec) {
        ecRepository.save(ec);
        return "redirect:/ec/index";
    }

    @PostMapping("/ec/{id}")
    public String updateEC(@PathVariable Long id, @ModelAttribute EC ec) {
        ec.setId(id);
        ecRepository.save(ec);
        return "redirect:/ec/index";
    }

    @GetMapping("/ec/delete/{id}")
    public String deleteEC(@PathVariable Long id) {
        ecRepository.deleteById(id);
        return "redirect:/ec/index";
    }
}