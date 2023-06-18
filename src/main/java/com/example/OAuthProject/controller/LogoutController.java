package com.example.OAuthProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController {

    @GetMapping("/logout-success")
    public String logoutSuccessPage() {
        return "logout-success"; // Return the name of the Thymeleaf template for the logout success page
    }
}