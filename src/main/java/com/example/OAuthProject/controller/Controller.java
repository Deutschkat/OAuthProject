package com.example.OAuthProject.controller;


import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@org.springframework.stereotype.Controller
@RequestMapping("/")
public class Controller {

    @GetMapping("/")
    public String getProtectedPage(Authentication authentication) {
        if (authentication != null) {
            System.out.println(authentication);
        }
        return "index";
    }

    @GetMapping("/protected")
    public String protectedPage(Model model) {

        return "index";
    }
}
