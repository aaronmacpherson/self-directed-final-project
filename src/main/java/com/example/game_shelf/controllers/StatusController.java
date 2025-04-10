package com.example.game_shelf.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.game_shelf.models.Status;
import com.example.game_shelf.repositories.StatusRepository;

import jakarta.validation.Valid;

@Controller
public class StatusController {
    @Autowired
    private StatusRepository statusRepository;

    @GetMapping("/status/add")
    public String addStatus(Model model) {
        if (!model.containsAttribute("status")) {
            model.addAttribute("status", new Status());
        }

        return "addStatus";
    }

    @PostMapping("/status/add")
    public String addStatus(@Valid Status status, BindingResult result, Model model,
            RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.status", result);
            redirectAttributes.addFlashAttribute("status", status);
            return "redirect:/status/add";
        }

        statusRepository.save(status);
        redirectAttributes.addFlashAttribute("message", status.getName() + " has been added successfully!");
        return "redirect:/status/add";
    }

    @GetMapping("/status/edit/{id}")
    public String editStatus(@PathVariable long id, Model model) {
        if (!model.containsAttribute("status")) {
            Status status = statusRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Invalid status id: " + id));
            model.addAttribute("status", status);
        }

        return "editStatus";
    }

    @PostMapping("/status/edit/{id}")
    public String editStatus(@PathVariable long id, @Valid Status status, BindingResult result, Model model,
            RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.status", result);
            redirectAttributes.addFlashAttribute("status", status);
            return "redirect:/status/edit/{id}";
        }

        statusRepository.save(status);
        redirectAttributes.addFlashAttribute("message", status.getName() + " has been edited successfully!");
        return "redirect:/status/edit/{id}";
    }
}
