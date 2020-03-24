package de.schmidtdennis.popupchinese.controller;

import static org.assertj.core.api.Assertions.*;

import de.schmidtdennis.popupchinese.data.requests.UserLessonRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.mockito.junit.MockitoJUnitRunner;

import de.schmidtdennis.popupchinese.data.dto.Lessons;
import de.schmidtdennis.popupchinese.data.repository.LessonRepository;
import de.schmidtdennis.popupchinese.data.repository.UserRepository;
import util.JsonConverter;

@RunWith(MockitoJUnitRunner.class)
public class PopupChineseControllerTest {

    private static final String RESOURCES = "src/test/java/resources/";

    @Mock
    LessonRepository lessonRepository;

    @InjectMocks
    PopupChineseController controller;


    @Test
    public void getLessons(){
        //GIVEN
        final int mockLessonId = 1;
        Lessons mockLesson = new Lessons();
        mockLesson.id = 100;

        when(lessonRepository.findAll()).thenReturn(null);
        when(lessonRepository.findById(mockLessonId)).thenReturn(mockLesson);

        //WHEN
        Iterable<Lessons> response = controller.getLessons();
        Lessons responseLesson = controller.getLesson(mockLessonId);

        //THEN
        assertThat(response).isNull();
        verify(lessonRepository, times(1)).findAll();
        assertThat(responseLesson.getId()).isEqualTo(100);
        verify(lessonRepository, times(1)).findById(mockLessonId);

    }

    @Test
    public void getUserLessons() throws IOException {
        //GIVEN
        UserLessonRequest request = JsonConverter.convertFromJson(RESOURCES + "UserLessonRequest.json", UserLessonRequest.class);

        System.out.println(request);

        //WHEN


        //THEN

    }
}