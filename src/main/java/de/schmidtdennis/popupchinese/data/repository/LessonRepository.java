package de.schmidtdennis.popupchinese.data.repository;

import org.springframework.data.repository.CrudRepository;

import de.schmidtdennis.popupchinese.data.dto.Lesson;

/**
 * LessonRepository
 */

public interface LessonRepository extends CrudRepository<Lesson, Long> {

    
}