package de.schmidtdennis.popupchinese.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import de.schmidtdennis.popupchinese.data.dto.Dialogs;
import de.schmidtdennis.popupchinese.data.dto.Lessons;
import de.schmidtdennis.popupchinese.data.dto.UserAccount;
import de.schmidtdennis.popupchinese.data.dto.Vocabulary;
import de.schmidtdennis.popupchinese.data.repository.DialogsRepository;
import de.schmidtdennis.popupchinese.data.repository.LessonRepository;
import de.schmidtdennis.popupchinese.data.repository.UserRepository;
import de.schmidtdennis.popupchinese.data.repository.VocabularyRepository;
import de.schmidtdennis.popupchinese.data.requests.DifficultyRequest;

@RestController
public class PopupChineseController {

    private final UserRepository userRepository;
    private final LessonRepository lessonRepository;
    private final DialogsRepository dialogsRepository; 
    private final VocabularyRepository vocabularyRepository;

    @Autowired
    public PopupChineseController(
        UserRepository userRepository, 
        LessonRepository lessonRepository,
        DialogsRepository dialogsRepository,
        VocabularyRepository vocabularyRepository
    ) {
        this.userRepository = userRepository;
        this.lessonRepository = lessonRepository;
        this.dialogsRepository = dialogsRepository;
        this.vocabularyRepository = vocabularyRepository;
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

    @GetMapping("getLesson/{id}")
    public Lessons getLesson(@PathVariable Integer id) {
        Lessons lesson = lessonRepository.findById(id);
        return lesson;
    }

    @GetMapping("getDialogsByLessonId/{lessonId}")
    public Iterable<Dialogs> getDialogsByLessonId(@PathVariable Integer lessonId) {
        return dialogsRepository.getByLessonId(lessonId);
    }

    @PostMapping("findLessonsByDifficulty")
    public List<Lessons> findLessonsByDifficulty(
        @RequestBody DifficultyRequest request){

        return lessonRepository.findBySearchedDifficulty(request.difficulty);
    }

    @GetMapping("getVocabularyByLessonId/{id}")
    public List<Vocabulary> getVocabularyByLessonId(@PathVariable Integer id){
        return vocabularyRepository.findByLessonIdOrderByVocabularyIdAsc(id);
    }

}