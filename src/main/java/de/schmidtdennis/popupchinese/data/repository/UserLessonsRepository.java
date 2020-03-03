package de.schmidtdennis.popupchinese.data.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import de.schmidtdennis.popupchinese.data.dto.Lessons;
import de.schmidtdennis.popupchinese.data.dto.UserLessons;

/**
 * UserLessonsRepository
 */
@Repository
public interface UserLessonsRepository extends CrudRepository<UserLessons, Long> {

    List<UserLessons> findByUserAccountId(@Param("userId") Integer userId);

    @Query("SELECT u FROM UserLessons u INNER JOIN u.userAccountId ua WHERE ua.email LIKE %:email% ORDER BY u.lastSeen DESC")
    List<UserLessons> findByUserEmail(@Param("email") String searchedEmail);

    @Transactional
    @Modifying
    @Query("UPDATE UserLessons u SET u.lastSeen = :timestamp WHERE u.id IN (SELECT u1.id FROM UserLessons u1 INNER JOIN u1.userAccountId u1a INNER JOIN u1.lessonId u1l WHERE u1a.email LIKE %:email% AND u1l.id = :lessonId)")
    int updateLessonTimestamp(@Param("timestamp") LocalDateTime timestamp, @Param("lessonId") Integer lessonId,
            @Param("email") String email);

    @Transactional
    @Modifying
    @Query("UPDATE UserLessons u SET u.lastSeen = '1999-01-01T00:00:00.515Z' WHERE u.id = 2")
    int updateLessonTimestampSimple();

}