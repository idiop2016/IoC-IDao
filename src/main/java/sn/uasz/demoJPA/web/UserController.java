package sn.uasz.demoJPA.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sn.uasz.demoJPA.entities.User;
import sn.uasz.demoJPA.repositories.UserRepository;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/index")
    public String index(Model model) {
        List<User> userList = userRepository.findAll();
        model.addAttribute("listeUsers", userList);
        return "user/index"; 
    }

    @GetMapping("/user/{id}")
    public String getUser(@PathVariable Long id, Model model) {
        User user = userRepository.findById(id).orElse(null);
        model.addAttribute("user", user);
        return "user/detail"; 
    }

    @PostMapping("/user")
    public String createUser(@ModelAttribute User user) {
        userRepository.save(user);
        return "redirect:/user/index";
    }

    @PostMapping("/user/{id}")
    public String updateUser(@PathVariable Long id, @ModelAttribute User user) {
        user.setId(id);
        userRepository.save(user);
        return "redirect:/user/index";
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
        return "redirect:/user/index";
    }
}