package de.schmidtdennis.popupchinese.data.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.schmidtdennis.popupchinese.data.dto.Lessons;;

/**
 * LessonRepository
 */

public interface LessonRepository extends CrudRepository<Lessons, Long> {

    Lessons findById(Integer id);
    
}