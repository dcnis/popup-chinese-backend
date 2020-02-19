package de.schmidtdennis.popupchinese.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import de.schmidtdennis.popupchinese.data.dto.Lessons;;

/**
 * LessonRepository
 */
@Repository
public interface LessonRepository extends CrudRepository<Lessons, Long> {

    Lessons findById(Integer id);

    @Query("SELECT l from Lessons l WHERE l.difficulty.id = :myDifficulty")
    List<Lessons> findBySearchedDifficulty(@Param("myDifficulty") Integer searchedDifficulty);
    
}