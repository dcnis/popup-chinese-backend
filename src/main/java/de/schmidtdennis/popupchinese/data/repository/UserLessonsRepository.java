package de.schmidtdennis.popupchinese.data.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import de.schmidtdennis.popupchinese.data.dto.UserLessons;

/**
 * UserLessonsRepository
 */
@Repository
public interface UserLessonsRepository extends JpaRepository<UserLessons, Integer> {

    List<UserLessons> findByUserAccountId(@Param("userId") Integer userId);

    @Query("SELECT u FROM UserLessons u INNER JOIN u.userAccountId ua WHERE ua.email LIKE %:email% ORDER BY u.lastSeen DESC")
    Page<UserLessons> findByUserEmail(@Param("email") String searchedEmail, Pageable pageable);

    @Transactional
    @Modifying
    @Query("UPDATE UserLessons u SET u.lastSeen = :timestamp WHERE u.id IN (SELECT u1.id FROM UserLessons u1 INNER JOIN u1.userAccountId u1a INNER JOIN u1.lessonId u1l WHERE u1a.email LIKE %:email% AND u1l.id = :lessonId)")
    int updateLessonTimestamp(
            @Param("email") String email,
            @Param("lessonId") Integer lessonId,
            @Param("timestamp") LocalDateTime timestamp);

    @Query("SELECT u from UserLessons u INNER JOIN u.lessonId ul INNER JOIN u.userAccountId ua WHERE ua.email LIKE %:email% AND ul.id = :lessonId")
    List<UserLessons> findByEmailAndLessonId(@Param("email") String email, @Param("lessonId") Integer lessonId);

    @Transactional
    @Modifying
    @Query("UPDATE UserLessons u SET u.liked = :liked WHERE u.id IN (SELECT u1.id FROM UserLessons u1 INNER JOIN u1.userAccountId user INNER JOIN u1.lessonId lesson WHERE user.email LIKE %:email% AND lesson.id = :lessonId)")
	int updateLiked(
        @Param("email") String email,
        @Param("lessonId") Integer lessonId,
        @Param("liked") Boolean liked);


    @Query("SELECT u from UserLessons u INNER JOIN u.userAccountId ua WHERE ua.email LIKE %:email% AND u.liked = :liked ORDER BY u.lastSeen DESC")
    Page<UserLessons> findLikedUserLessons(
        @Param ("email") String searchedEmail,
        @Param ("liked") Boolean liked,
        Pageable pageable);

}