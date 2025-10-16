package com.mahesh.controller;

import com.mahesh.entity.Message;
import com.mahesh.serviceimplimentation.MessageDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class MessageController {

    @Autowired
    private MessageDAO mdao;

    @GetMapping("/")
    public String home() {
        return "index"; // single HTML page
    }

    @PostMapping("/encrypt")
    public String encrypt(@RequestParam("message") String message,
                          @RequestParam("password") String password,
                          Model model) {
        if (message.length() > 999 || password.length() > 999) {
            model.addAttribute("result", "Error: Message and password must not exceed 230 characters.");
            return "index";
        }
        String secret = mdao.encryptMessage(message, password);
        model.addAttribute("result", "Your Secret Key: " + secret);
        return "index";
    }

    @PostMapping("/decrypt")
    public String decrypt(@RequestParam("secret") String secret,
                          @RequestParam("password") String password,
                          Model model) {
        String decrypted = mdao.decryptMessage(secret, password);
        model.addAttribute("result", decrypted);
        return "index";
    }


}
