package com.leandro.consumingrest.controller;

import com.leandro.consumingrest.Picture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Controller
public class PictureController {

    @Autowired
    private RestTemplate restTemplate;

    //it makes a request with a specific date only if it has a date param
    @GetMapping("/")
    public String getPicture(@RequestParam(name = "date", required = false) String date, Model model) {
        try {

            Picture picture = restTemplate.getForObject(
                "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY" + (date == null? "" : "&date=" + date),
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