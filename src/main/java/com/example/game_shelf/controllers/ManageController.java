package com.example.game_shelf.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.game_shelf.models.Platform;
import com.example.game_shelf.repositories.PlatformRepository;
import com.example.game_shelf.repositories.PriorityRepository;
import com.example.game_shelf.repositories.StatusRepository;

import jakarta.validation.Valid;

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

    // ----------------------------------------------------------------------
    // platforms
    @GetMapping("/platforms/add")
    public String addPlatforms(Model model) {
        if (!model.containsAttribute("platform")) {
            model.addAttribute("platform", new Platform());
        }

        return "addPlatform";
    }

    @PostMapping("/platforms/add")
    public String addPlatforms(@Valid Platform platform, BindingResult result, Model model,
            RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.platform", result);
            redirectAttributes.addFlashAttribute("platform", platform);
            return "redirect:/platforms/add";
        }

        platformRepository.save(platform);
        return "redirect:/manage";
    }
}
