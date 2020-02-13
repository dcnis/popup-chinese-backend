package de.schmidtdennis.popupchinese.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PopupChineseController {

    @GetMapping("/")
    public String getHello(){
        return "Hello World";
    }

}