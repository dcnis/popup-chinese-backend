package de.schmidtdennis.popupchinese.data.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import de.schmidtdennis.popupchinese.data.dto.Dialogs;

/**
 * DialogsRepository
 */
@Repository
public interface DialogsRepository extends CrudRepository<Dialogs, Long> {

    @Query("SELECT d FROM Dialogs d where d.lessonId = :lessonId")
    Iterable<Dialogs> getByLessonId(@Param("lessonId") Integer lessonId);

}