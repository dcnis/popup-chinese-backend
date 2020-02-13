package de.schmidtdennis.popupchinese.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import de.schmidtdennis.popupchinese.data.dto.UserAccount;
import de.schmidtdennis.popupchinese.data.repository.UserRepository;

@RestController
public class PopupChineseController {

    private final UserRepository userRepository;

    @Autowired
    public PopupChineseController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public String getHello(){
        return "Hello World";
    }

    @GetMapping("/getUsers")
    public Iterable<UserAccount> getUsers(){
        return userRepository.findAll();
    }

}