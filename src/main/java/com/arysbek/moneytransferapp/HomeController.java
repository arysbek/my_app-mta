package com.arysbek.moneytransferapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class HomeController {
    @GetMapping("/home")
    public String homePage(Model model)
    {
        model.addAttribute( "message", "Welcome Home!");
        return "home";
    }
}


