package com.example.game_shelf.controllers;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String login() {
        Authentication authToken = SecurityContextHolder.getContext().getAuthentication();

        // redirect to the games view if the user attempting to access the login page is already authenticated
        if (!(authToken instanceof AnonymousAuthenticationToken)) {
            return "redirect:/games";
        }

        return "login";
    }
}
