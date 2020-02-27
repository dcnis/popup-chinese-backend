package de.schmidtdennis.popupchinese.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import de.schmidtdennis.popupchinese.data.dto.UserLessons;

/**
 * UserLessonsRepository
 */
@Repository
public interface UserLessonsRepository extends CrudRepository<UserLessons, Long>{

    List<UserLessons> findByUserAccountId(@Param("userId") Integer userId);

    @Query("Select l from UserLessons l where l.email = :searchedEmail")
    List<UserLessons> findByUserEmail(@Param ("searchedEmail") String searchedEmail);

}