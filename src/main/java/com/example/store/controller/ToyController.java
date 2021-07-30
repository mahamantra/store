package com.example.store.controller;

import com.example.store.model.Toy;
import com.example.store.service.ToyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ToyController {

    private final ToyService toyService;

    @GetMapping("/toys")
    public ResponseEntity<List<Toy>> findAll() {
        List<Toy> toys = toyService.findAll();
        return toys != null && !toys.isEmpty()
                ? new ResponseEntity<>(toys, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
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
