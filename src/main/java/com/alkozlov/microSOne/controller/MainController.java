package com.alkozlov.microSOne.controller;

import com.alkozlov.microSOne.entity.Cat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

   @Autowired
   private ObjectMapper objectMapper;

    @GetMapping("/api/main")
    public String mainListener() {
        return "Hello from Main Listener";
    }

   @GetMapping("/api/cat")
    public String giveCat() {
        String jsonData = null;
        Cat cat = new Cat("Barsik", 5, 8);
        try {
            jsonData = objectMapper.writeValueAsString(cat);
        } catch (JsonProcessingException e) {
            jsonData = e.getMessage();
        }
        return jsonData;
    }

    @PostMapping("/api/special")
    public String giveSpecialCat(@RequestParam String name) {
        String jsonData = null;
        Cat cat = new Cat(name, 5, 8);
        try {
            jsonData = objectMapper.writeValueAsString(cat);
        } catch (JsonProcessingException e) {
            jsonData = e.getMessage();
        }
        return jsonData;
    }
}
