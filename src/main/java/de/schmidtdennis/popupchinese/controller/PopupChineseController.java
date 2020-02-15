package de.schmidtdennis.popupchinese.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import de.schmidtdennis.popupchinese.data.dto.Lessons;
import de.schmidtdennis.popupchinese.data.dto.UserAccount;
import de.schmidtdennis.popupchinese.data.repository.LessonRepository;
import de.schmidtdennis.popupchinese.data.repository.UserRepository;

@RestController
public class PopupChineseController {

    private final UserRepository userRepository;
    private final LessonRepository lessonRepository;

    @Autowired
    public PopupChineseController(UserRepository userRepository, LessonRepository lessonRepository) {
        this.userRepository = userRepository;
        this.lessonRepository = lessonRepository;
    }

    @GetMapping("/")
    public String getHello(){
        return "Hello World";
    }

    @GetMapping("/getUsers")
    public Iterable<UserAccount> getUsers(){
        return userRepository.findAll();
    }

    @GetMapping("getLessons")
    public Iterable<Lessons> getLessons(){
        Iterable<Lessons> lessons = lessonRepository.findAll();
        return lessons;
    }

}