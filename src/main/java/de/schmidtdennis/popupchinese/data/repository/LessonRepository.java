package de.schmidtdennis.popupchinese.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import de.schmidtdennis.popupchinese.data.dto.Lessons;;

/**
 * LessonRepository
 */
@Repository
public interface LessonRepository extends JpaRepository<Lessons, Long> {

    Lessons findById(Integer id);

    @Query("select l from Lessons l inner join l.difficulty ar where ar.id = :myId")
    List<Lessons> findBySearchedDifficulty(@Param ("myId") Integer searchedDifficulty);
    
}