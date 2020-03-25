package de.schmidtdennis.popupchinese.controller;

import static org.assertj.core.api.Assertions.*;

import de.schmidtdennis.popupchinese.data.dto.UserLessons;
import de.schmidtdennis.popupchinese.data.repository.UserLessonsRepository;
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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import util.JsonConverter;

@RunWith(MockitoJUnitRunner.class)
public class PopupChineseControllerTest {

    private static final String RESOURCES = "src/test/java/resources/";

    @Mock
    LessonRepository lessonRepository;

    @Mock
    UserLessonsRepository userLessonsRepository;

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

    @Test(expected = IllegalArgumentException.class)
    public void should_throwException_when_EmailIsNull() throws IOException {
        //GIVEN
        UserLessonRequest request = JsonConverter.convertFromJson(RESOURCES + "UserLessonRequest.json", UserLessonRequest.class);
        request.setEmail(null);

        //WHEN
        controller.getUserLessons(request);

        //THEN

    }

    @Test
    public void should_setLimitToMaxValue_when_limitIsNull() throws IOException {
        //GIVEN
        UserLessonRequest request = JsonConverter.convertFromJson(RESOURCES + "UserLessonRequest.json", UserLessonRequest.class);
        request.setLimit(null);
        Page<UserLessons> mockResponse = mock(Page.class);

        when(userLessonsRepository.findLikedUserLessons(
                "test@yahoo.de",
                false,
                PageRequest.of(0, Integer.MAX_VALUE))).thenReturn(mockResponse);

        //WHEN
        controller.getUserLessons(request);

        //THEN
        verify(userLessonsRepository, times(1)).findLikedUserLessons(
                "test@yahoo.de",
                false,
                PageRequest.of(0, Integer.MAX_VALUE));
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_ThrowIllegalArgumentException_when_ResponseIsNull() throws IOException {
        //GIVEN
        UserLessonRequest request = JsonConverter.convertFromJson(RESOURCES + "UserLessonRequest.json", UserLessonRequest.class);
        request.setLimit(null);

        when(userLessonsRepository.findLikedUserLessons(
                "test@yahoo.de",
                false,
                PageRequest.of(0, Integer.MAX_VALUE))).thenReturn(null);

        //WHEN
        controller.getUserLessons(request);

        //THEN
    }

    @Test
    public void should_callFindByUserEmail_when_FieldLikedIsNull() throws IOException {
        //GIVEN
        UserLessonRequest request = JsonConverter.convertFromJson(RESOURCES + "UserLessonRequest.json", UserLessonRequest.class);
        request.setLiked(null);
        Page<UserLessons> mockResponse = mock(Page.class);

        when(userLessonsRepository.findByUserEmail(
                "test@yahoo.de",
                PageRequest.of(0, 5))).thenReturn(mockResponse);

        //WHEN
        controller.getUserLessons(request);

        //THEN
        verify(userLessonsRepository, times(1)).findByUserEmail(
                "test@yahoo.de",
                PageRequest.of(0, 5));

        verify(userLessonsRepository, times(0)).findLikedUserLessons(
                any(), any(), any());
    }

}