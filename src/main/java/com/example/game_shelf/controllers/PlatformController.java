package com.example.game_shelf.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.game_shelf.models.Platform;
import com.example.game_shelf.repositories.PlatformRepository;

import jakarta.validation.Valid;

@Controller
public class PlatformController {
    @Autowired
    private PlatformRepository platformRepository;

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

    @GetMapping("/platforms/edit/{id}")
    public String editPlatforms(@PathVariable long id, Model model) {
        if (!model.containsAttribute("platform")) {
            Platform platform = platformRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Invalid platform id: " + id));
            model.addAttribute("platform", platform);
        }

        return "editPlatform";
    }

    @PostMapping("/platforms/edit/{id}")
    public String editPlatforms(@PathVariable long id, @Valid Platform platform, BindingResult result, Model model,
            RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.platform", result);
            redirectAttributes.addFlashAttribute("platform", platform);
            return "redirect:/platforms/edit/{id}";
        }

        platformRepository.save(platform);
        return "redirect:/manage";
    }
}
