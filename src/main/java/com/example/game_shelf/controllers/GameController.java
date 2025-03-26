package com.example.game_shelf.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.example.game_shelf.repositories.GameRepository;

@Controller
public class GameController {

    @Autowired
    private GameRepository gameRepository;

    @GetMapping("/")
    public RedirectView index() {
        return new RedirectView("/games");
    }
    
    @GetMapping("/games")
    public String games(Model model) {
        model.addAttribute("games", gameRepository.findAll());
        
        return "games";
    }
}