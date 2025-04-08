package com.example.game_shelf.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.game_shelf.repositories.PlatformRepository;
import com.example.game_shelf.repositories.PriorityRepository;
import com.example.game_shelf.repositories.StatusRepository;

@Controller
public class ManageController {
    @Autowired
    private PlatformRepository platformRepository;

    @Autowired
    private PriorityRepository priorityRepository;

    @Autowired
    private StatusRepository statusRepository;

    @GetMapping("/manage")
    public String games(Model model) {
        model.addAttribute("platforms", platformRepository.findAll());
        model.addAttribute("priorities", priorityRepository.findAll());
        model.addAttribute("statuses", statusRepository.findAll());

        return "manage";
    }
}
