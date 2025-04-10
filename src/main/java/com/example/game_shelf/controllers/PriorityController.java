package com.example.game_shelf.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.game_shelf.models.Priority;
import com.example.game_shelf.repositories.PriorityRepository;

import jakarta.validation.Valid;

@Controller
public class PriorityController {
    @Autowired
    private PriorityRepository priorityRepository;

    @GetMapping("/priorities/add")
    public String addPriorities(Model model) {
        if (!model.containsAttribute("priority")) {
            model.addAttribute("priority", new Priority());
        }

        return "addPriority";
    }

    @PostMapping("/priorities/add")
    public String addPriorities(@Valid Priority priority, BindingResult result, Model model,
            RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.priority", result);
            redirectAttributes.addFlashAttribute("priority", priority);
            return "redirect:/priorities/add";
        }

        priorityRepository.save(priority);
        redirectAttributes.addFlashAttribute("message", priority.getName() + " has been added successfully!");
        return "redirect:/priorities/add";
    }

    @GetMapping("/priorities/edit/{id}")
    public String editPriorities(@PathVariable long id, Model model) {
        if (!model.containsAttribute("priority")) {
            Priority priority = priorityRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Invalid priority id: " + id));
            model.addAttribute("priority", priority);
        }

        return "editPriority";
    }

    @PostMapping("/priorities/edit/{id}")
    public String editPriorities(@PathVariable long id, @Valid Priority priority, BindingResult result, Model model,
            RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.priority", result);
            redirectAttributes.addFlashAttribute("priority", priority);
            return "redirect:/priorities/edit/{id}";
        }

        priorityRepository.save(priority);
        redirectAttributes.addFlashAttribute("message", priority.getName() + " has been edited successfully!");
        return "redirect:/priorities/edit/{id}";
    }
}
