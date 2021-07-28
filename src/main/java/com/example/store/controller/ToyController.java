package com.example.store.controller;

import com.example.store.model.Toy;
import com.example.store.service.ToyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ToyController {

    private final ToyService toyService;

    @Autowired
    public ToyController(ToyService toyService) {
        this.toyService = toyService;
    }

    @GetMapping("/toys")
    public String findAll(Model model) {
        List<Toy> toys = toyService.findAll();
        model.addAttribute("toys", toys);
        return "toy-list";
    }

    @GetMapping("/toy-create")
    public String createUserForm(Toy toy){
        return "toy-create";
    }

    @PostMapping("/toy-create")
    public String createUser(Toy toy){
        toyService.saveToy(toy);
        return "redirect:/toys";
    }

    @GetMapping("toy-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        toyService.deleteById(id);
        return "redirect:/toys";
    }

    @GetMapping("/toy-update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model){
        Toy toy = toyService.findById(id);
        model.addAttribute("toy", toy);
        return "toy-update";
    }

    @PostMapping("/toy-update")
    public String updateUser(Toy toy){
        toyService.saveToy(toy);
        return "redirect:/toys";
    }
}
