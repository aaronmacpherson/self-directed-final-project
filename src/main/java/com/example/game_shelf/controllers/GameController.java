package com.example.game_shelf.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.game_shelf.models.Game;
import com.example.game_shelf.repositories.GameRepository;
import com.example.game_shelf.repositories.PlatformRepository;
import com.example.game_shelf.repositories.PriorityRepository;
import com.example.game_shelf.repositories.StatusRepository;

import jakarta.validation.Valid;

@Controller
public class GameController {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private PlatformRepository platformRepository;

    @Autowired
    private PriorityRepository priorityRepository;

    @Autowired
    private StatusRepository statusRepository;

    @GetMapping("/")
    public RedirectView index() {
        return new RedirectView("/games");
    }

    @GetMapping("/games")
    public String games(Model model) {
        model.addAttribute("games", gameRepository.findAllByOrderByIdDesc());

        return "games";
    }

    @GetMapping("/games/add")
    public String addGames(Model model) {
        if (!model.containsAttribute("game")) {
            model.addAttribute("game", new Game());
        }

        model.addAttribute("platforms", platformRepository.findAll());
        model.addAttribute("priority", priorityRepository.findAll());
        model.addAttribute("status", statusRepository.findAll());

        return "addGame";
    }

    @PostMapping("/games/add")
    public String addGames(@Valid Game game, BindingResult result, Model model, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.game", result);
            redirectAttributes.addFlashAttribute("game", game);
            return "redirect:/games/add";
        }

        gameRepository.save(game);
        return "redirect:/games";
    }

    @GetMapping("/games/edit/{id}")
    public String editGames(@PathVariable long id, Model model) {
        if (!model.containsAttribute("game")) {
            Game game = gameRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Invalid game id: " + id));
            model.addAttribute("game", game);
        }

        model.addAttribute("platforms", platformRepository.findAll());
        model.addAttribute("priority", priorityRepository.findAll());
        model.addAttribute("status", statusRepository.findAll());

        return "editGame";
    }

    @PostMapping("/games/edit/{id}")
    public String editGames(@PathVariable long id, @Valid Game game, BindingResult result, Model model,
            RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.game", result);
            redirectAttributes.addFlashAttribute("game", game);
            return "redirect:/games/edit/{id}";
        }

        gameRepository.save(game);
        return "redirect:/games";
    }

    @GetMapping("/games/delete/{id}")
    public String deleteGames(@PathVariable("id") long id, Model model) {
        Game game = gameRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid game Id:" + id));
        gameRepository.delete(game);
        return "redirect:/games";
    }
}