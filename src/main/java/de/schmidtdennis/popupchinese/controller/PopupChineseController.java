package de.schmidtdennis.popupchinese.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import de.schmidtdennis.popupchinese.data.dto.Dialogs;
import de.schmidtdennis.popupchinese.data.dto.Lessons;
import de.schmidtdennis.popupchinese.data.dto.UserAccount;
import de.schmidtdennis.popupchinese.data.dto.UserLessons;
import de.schmidtdennis.popupchinese.data.dto.Vocabulary;
import de.schmidtdennis.popupchinese.data.repository.DialogsRepository;
import de.schmidtdennis.popupchinese.data.repository.LessonRepository;
import de.schmidtdennis.popupchinese.data.repository.UserLessonsRepository;
import de.schmidtdennis.popupchinese.data.repository.UserRepository;
import de.schmidtdennis.popupchinese.data.repository.VocabularyRepository;
import de.schmidtdennis.popupchinese.data.requests.DifficultyRequest;
import de.schmidtdennis.popupchinese.data.requests.UserLessonRequest;

@RestController
@CrossOrigin(origins = { "https://heroku-popup-chinese-frontend.herokuapp.com", "http://localhost:8080" })
public class PopupChineseController {

    private final UserRepository userRepository;
    private final LessonRepository lessonRepository;
    private final DialogsRepository dialogsRepository;
    private final VocabularyRepository vocabularyRepository;
    private final UserLessonsRepository userLessonsRepository;

    @Autowired
    public PopupChineseController(UserRepository userRepository, LessonRepository lessonRepository,
            DialogsRepository dialogsRepository, VocabularyRepository vocabularyRepository,
            UserLessonsRepository userLessonsRepository) {
        this.userRepository = userRepository;
        this.lessonRepository = lessonRepository;
        this.dialogsRepository = dialogsRepository;
        this.vocabularyRepository = vocabularyRepository;
        this.userLessonsRepository = userLessonsRepository;
    }

    @GetMapping("/getUsers")
    public Iterable<UserAccount> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("getLessons")
    public Iterable<Lessons> getLessons() {
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
    public List<Lessons> findLessonsByDifficulty(@RequestBody DifficultyRequest request) {

        return lessonRepository.findBySearchedDifficulty(request.difficulty);
    }

    @GetMapping("getVocabularyByLessonId/{id}")
    public List<Vocabulary> getVocabularyByLessonId(@PathVariable Integer id) {
        return vocabularyRepository.findByLessonIdOrderByVocabularyIdAsc(id);
    }

    @GetMapping("getUserLessonsByUserId/{userId}")
    public List<UserLessons> getUserLessonsByUserId(@PathVariable Integer userId) {
        return userLessonsRepository.findByUserAccountId(userId);
    }

    @PostMapping("getUserLessons")
    public Page<UserLessons> getUserLessons(@RequestBody UserLessonRequest request) {
        Assert.notNull(request.getEmail(), "User email must not be null");
        
        Integer limit = request.getLimit();

        if (limit == null){
            limit = Integer.MAX_VALUE;
        }

        Page<UserLessons> response = null;

        if(request.getLiked() == null){
            response = userLessonsRepository.findByUserEmail(
                request.getEmail(),
                PageRequest.of(0, limit));
        } else {
            response = userLessonsRepository.findLikedUserLessons(
                request.getEmail(),
                request.getLiked(),
                PageRequest.of(0, limit));
        }

        Assert.notNull(response, "No UserLessons found for given request");

        return response;
    }

    @PostMapping("getSingleUserLesson")
    public ResponseEntity<UserLessons> getSingleUserLesson(@RequestBody UserLessonRequest request){
        Assert.notNull(request.getEmail(), "user email must not be null!");
        Assert.notNull(request.getLessonId(), "lessonId must not be null!");

        List<UserLessons> userLessons = new ArrayList<>();

        userLessons = userLessonsRepository.findByEmailAndLessonId(request.getEmail(), request.getLessonId());

        if (userLessons.size() != 1){
             throw new IllegalArgumentException("No lesson found with given email and lessonId");
        }

        return new ResponseEntity<>(userLessons.get(0), HttpStatus.OK);

    }
    

    @PostMapping("updateUserLesson")
    public ResponseEntity<Integer> updateUserLesson(@RequestBody UserLessonRequest request) {        
        int affectedRows = 0;

        if(request.getLastSeen() != null) {
            affectedRows = userLessonsRepository.updateLessonTimestamp(
                request.getEmail(), 
                request.getLessonId(),
                request.getLastSeen());
        }

        if(request.getLiked() != null){
            affectedRows = userLessonsRepository.updateLiked(
                request.getEmail(), 
                request.getLessonId(),
                request.getLiked()
            );
        }

        return new ResponseEntity<>(affectedRows, HttpStatus.OK);
    }


    @PostMapping("addLatestLessonsOfUser")
    public void addLatestLessonsOfUser(
        @RequestParam String email,
        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime lastSeen,
        @RequestParam Integer lessonId) {

        // Find user
        List<UserAccount> userList = userRepository.findByEmail(email);
        if (userList == null || userList.size() != 1) {
            throw new IllegalArgumentException("no user exists with email: " + email);
        }
        UserAccount user = userList.get(0);

        // Find lesson
        Lessons lesson = lessonRepository.findById(lessonId);
        Assert.notNull(lesson, "lesson must not be null");

        // Create new UserLesson
        UserLessons newUserLesson = new UserLessons(user, lesson, lastSeen);

        // Add new UserLesson to user-parent
        List<UserLessons> currentUserLessons = user.getUserLessons();
        currentUserLessons.add(newUserLesson);
        user.setUserLessons(currentUserLessons);

        // Add new UserLesson to lesson-parent

        // update user-parent and lesson-parent, therefore create userlesson CASCADE.ALL

        userRepository.save(user);
    }

}