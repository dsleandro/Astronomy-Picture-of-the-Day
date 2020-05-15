package com.leandro.consumingrest.controller;

import com.leandro.consumingrest.Picture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Controller
public class PictureController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public String getPicture(Model model) {
        try {

            Picture picture = restTemplate.getForObject("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY",
                    Picture.class);

            model.addAttribute("data", picture);
            return "index";

        } catch (RestClientException e) {
            return "error";
        }
    }

    @GetMapping("/error")
    public String errorMessage() {
        return "error";
    }

}