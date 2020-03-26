package de.schmidtdennis.popupchinese.repository;

import de.schmidtdennis.popupchinese.data.dto.Lessons;
import de.schmidtdennis.popupchinese.data.repository.LessonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class LessonRepositoryTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private LessonRepository lessonRepository;

    @Test
    public void test(){

        Lessons lesson = lessonRepository.findById(1);

        assertThat(lesson.getId()).isEqualTo(1);
        assertThat(lesson.getDifficulty().getDescription()).isEqualTo("Absolute Beginners");

    }

}
